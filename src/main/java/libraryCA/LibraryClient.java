package libraryCA;

import java.time.LocalTime;

import generated.lights.AverageResponse;
import generated.lights.LightLevel;
import generated.lights.LightServiceGrpc;
import generated.lights.LightServiceGrpc.LightServiceStub;
import generated.registration.RegistrationBookGrpc.RegistrationBookBlockingStub;
import generated.registration.RegistrationBookGrpc.RegistrationBookStub;
import generated.registration.RegistrationBookGrpc;
import generated.registration.VisitorRegistrationRequest;
import generated.registration.VisitorRegistrationResponse;
import generated.search.AvailableBooks;
import generated.search.ListBy;
import generated.search.SearchEngineGrpc;
import generated.search.userID;
import generated.search.userInformation;
import generated.search.SearchEngineGrpc.SearchEngineBlockingStub;
import generated.search.SearchEngineGrpc.SearchEngineStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class LibraryClient {
	private static SearchEngineBlockingStub blockingStub;
	private static SearchEngineStub asyncStub;
	private static LightServiceStub LSasyncStub;
	private static RegistrationBookStub RAsyncStub;
	private static RegistrationBookBlockingStub RblockingStub;
	
	
	public static void main(String[] args) {
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		
		blockingStub = SearchEngineGrpc.newBlockingStub(channel);
		asyncStub = SearchEngineGrpc.newStub(channel);
		LSasyncStub = LightServiceGrpc.newStub(channel);
		RblockingStub = RegistrationBookGrpc.newBlockingStub(channel);
		
		//availabilityAsyn();
		//LightAvg();
		readerInfo();
		//visitorRegister();
	}
	
	public static void availabilityAsyn() {
		ListBy.ListOperation operation = ListBy.ListOperation.AUTHOR;
		ListBy request = ListBy.newBuilder().setOperation(ListBy.ListOperation.AUTHOR).build();
		
		StreamObserver<AvailableBooks> responseObserver = new StreamObserver<AvailableBooks>() {
			int count = 0;
			
			@Override
			public void onNext(AvailableBooks value) {
				System.out.println(LocalTime.now().toString() + ": receiving book's information\nAuthor: " + value.getAuthor());
				count += 1;
			}
			
			@Override
			public void onError(Throwable t) {
				System.out.println("ERROR");
				t.printStackTrace();
			}
			
			@Override
			public void onCompleted() {
				System.out.println(LocalTime.now().toString() + ": stream is completed. Received " + count + " books");
			}
		};
		
		asyncStub.availability(request, responseObserver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
	}
	
	/*
	 * VISITOR SEARCH SERVICE
	 * UNARY RPC
	 */
	public static void readerInfo() {
		System.out.println("Enter a user number");
		/*
		 * USERID available 443325, 493947, 102934, and 980661
		 */
		int userNum = 443325;
		userID req = userID.newBuilder().setUserNumber(userNum).build();
		userInformation responseRI = blockingStub.readerInfo(req);
		
		System.out.println(LocalTime.now().toString() + ": User's information: \nNAME: " + responseRI.getName() + "\nREGISTRATION DATE: " + responseRI.getRegistrationDate());
		
	}
	
	public static void visitorRegister() {
		int visitorID = 12;
		VisitorRegistrationRequest req = VisitorRegistrationRequest.newBuilder().setBookId(visitorID).build();
		
		VisitorRegistrationResponse response = RblockingStub.visitorRegister(req);
		
		System.out.println(LocalTime.now().toString() + ": receiving message: " + response.getRegistrationConfirmation() + " for the date: " + response.getRegistrationDate());
	}
	
	public static void LightAvg() {
		StreamObserver<AverageResponse> responseObserver = new StreamObserver<AverageResponse>() {
			
			@Override
			public void onNext(AverageResponse msg) {
				// TODO Auto-generated method stub
				System.out.println(LocalTime.now().toString() + ": Response from server " + msg.getLightAverage());
				
				
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
		
		StreamObserver<LightLevel> requestObserver = LSasyncStub.averageLighting(responseObserver);
		try {
			
			requestObserver.onNext(LightLevel.newBuilder().setLevel(1).setCurrentTime("0").build());
			Thread.sleep(700);
			requestObserver.onNext(LightLevel.newBuilder().setLevel(2).setCurrentTime("2").build());
			Thread.sleep(700);
			
			
			requestObserver.onCompleted();
			
			Thread.sleep(7000);
			
		} catch (RuntimeException exc) {
			exc.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
}
