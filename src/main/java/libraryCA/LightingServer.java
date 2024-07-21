package libraryCA;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import generated.lights.AverageResponse;
import generated.lights.LightLevel;
import generated.lights.LightRequest;
import generated.lights.StatusResponse;
import generated.lights.LightServiceGrpc.LightServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class LightingServer extends LightServiceImplBase{
	public static void main(String[] args) {
		LightingServer lightServer = new LightingServer();
		
		int port = 50051;
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(lightServer)
					.build()
					.start();
			
			System.out.println(LocalTime.now().toString() + ": Lighting Server started, listening on " + port);
			server.awaitTermination();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 	LIGHTING SERVICE
	 * CLIENT-STREAMING RPC
	 * The client sends continuous messages of the natural light level in the building
	 * Server processes the information and, when reaching a level, changes the light status and returns a message
	 */
	public StreamObserver<LightLevel> averageLighting(StreamObserver<AverageResponse> responseObserver){
		
		return new StreamObserver<LightLevel>() {
			
			ArrayList<Integer> levelList = new ArrayList<Integer>();

			@Override
			public void onNext(LightLevel request) {
				// TODO Auto-generated method stub
				System.out.println(LocalTime.now().toString() + ": received the light level: " + request.getLevel() + "\nTime of the recording: " + request.getCurrentTime());
					
				levelList.add(request.getLevel());
				//System.out.println("\n" + levelList.toString() + "\n");
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.printf(LocalTime.now().toString() + ": Natural light level stream complete \n");
				
				double lightPercentage = 0;
				for (float v: levelList) {
					lightPercentage = lightPercentage + v;
				}
				float mean = (float) (lightPercentage/levelList.size());
				
				String finalMsg = "Today's natural lighting average was: " + mean;
				
				AverageResponse reply = AverageResponse.newBuilder().setLightAverage(finalMsg).build();
				
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
				
			}
			
			
			
		};
	}
	
	/*
	 * LIGHTING
	 * UNARY RPC.
	 * The client sends a message to turn on or turn off the lights (String)
	 * The system responds with a confirmation message (String).
	 */
	public void turnOnOff(LightRequest request, StreamObserver <StatusResponse> responseObserver) {
		
		System.out.println("Receiving instruction request.");
		
		String msg = "";
		if(request.getLightButton() == 1) {
			msg = "Lights are turned on ";
		} else { if(request.getLightButton() == 0) {
			msg = "Lights are turned off";
		} else {
			msg = "Invalid input";
		}
			
		}
		
		StatusResponse response = StatusResponse.newBuilder().setLightState(msg).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
		
	}
	
}
