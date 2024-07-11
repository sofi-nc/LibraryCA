package ca.library;

import java.time.LocalTime;

import generated.lights.AverageResponse;
import generated.lights.LightLevel;
import generated.lights.LightRequest;
import generated.lights.LightServiceGrpc;
import generated.lights.LightServiceGrpc.LightServiceBlockingStub;
import generated.lights.LightServiceGrpc.LightServiceStub;
import generated.lights.StatusResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

@SuppressWarnings("unused")
public class LibraryClient {
	private static LightServiceBlockingStub blockingStub;
	private static LightServiceStub asyncStub;
	
	public static void main(String[] args) {
			ManagedChannel channel = ManagedChannelBuilder
					.forAddress("localhost", 50051)
					.usePlaintext()
					.build();
			
			blockingStub = LightServiceGrpc.newBlockingStub(channel);
			asyncStub = LightServiceGrpc.newStub(channel);
			
			averageLighting();
			//turnOnOff();
			
			
	}
	
	// Client-streaming RPC
	public static void averageLighting() {
		//averageLighting(stream LightLevel) returns (AverageResponse)
		//averageValues(stream NumberMessage) returns (CalculateResponse )
		StreamObserver<AverageResponse> responseObserver = new StreamObserver<AverageResponse>() {
			
			@Override
			public void onNext(AverageResponse msg) {
				// TODO Auto-generated method stub
				System.out.println(LocalTime.now().toString() + ": Response from server: " + msg.getLightAverage());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				System.out.println(LocalTime.now().toString() + ": Stream is completed.");
				
			}
			
		};
		
		StreamObserver<LightLevel> requestObserver = asyncStub.averageLighting(responseObserver);
		try {
			requestObserver.onNext(LightLevel.newBuilder().setLevel(10).setCurrentTime("0:00").build());
			Thread.sleep(700);
			
			requestObserver.onNext(LightLevel.newBuilder().setLevel(7).setCurrentTime("1:00").build());
			Thread.sleep(700);
			
			requestObserver.onNext(LightLevel.newBuilder().setLevel(5).setCurrentTime("2:00").build());
			Thread.sleep(700);
			
			requestObserver.onNext(LightLevel.newBuilder().setLevel(2).setCurrentTime("3:00").build());
			Thread.sleep(700);
			
			requestObserver.onNext(LightLevel.newBuilder().setLevel(5).setCurrentTime("4:00").build());
			Thread.sleep(700);
			
			requestObserver.onNext(LightLevel.newBuilder().setLevel(10).setCurrentTime("5:00").build());
			Thread.sleep(700);
			
			requestObserver.onNext(LightLevel.newBuilder().setLevel(20).setCurrentTime("6:00").build());
			Thread.sleep(700);
			
			requestObserver.onNext(LightLevel.newBuilder().setLevel(30).setCurrentTime("7:00").build());
			Thread.sleep(700);
			
			
			requestObserver.onCompleted();
			
			Thread.sleep(15000);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	//UNARY RPC
	public static void turnOnOff() {
		int instruction = 1;
		LightRequest req = LightRequest.newBuilder().setLightButton(instruction).build();
		StatusResponse resp = blockingStub.turnOnOff(req);
		
		System.out.println(LocalTime.now().toString() + ": Validation message: " + resp.getLightState());
	}
	
}
