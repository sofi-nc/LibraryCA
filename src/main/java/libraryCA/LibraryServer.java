package libraryCA;


import generated.lights.AverageResponse;
import generated.lights.LightLevel;
import generated.lights.LightRequest;
import generated.lights.LightServiceGrpc.LightServiceImplBase;
import generated.lights.StatusResponse;
import generated.search.AvailableBooks;
import generated.search.ListBy;
import io.grpc.ServerBuilder;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

@SuppressWarnings("unused")
public class LibraryServer extends LightServiceImplBase{
	private static final Books[][] Array = null;

	public static void main(String[] args) {
		LibraryServer libserver = new LibraryServer();
		
		int port = 50051;
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(libserver)
					.build()
					.start();
			
			System.out.println(LocalTime.now().toString() + ": Library Server started, listening on " + port);
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
	
	/*
	 * SEARCH SERVICE
	 * SERVER-STREAMING RPC
	 * The client sends information about a book they're looking for and the system returns
	 * data related to that book's availability in different locations
	 */
	public void availability(ListBy request,
			StreamObserver<AvailableBooks> responseObserver) {
		
		System.out.println(LocalTime.now().toString() + " : receiving convert request with values : " + request.getOperation() );
		
		//ArrayList<Books> booksList = new ArrayList<>();
		Books[] byTitle = new Books[7];
		Books[] byAuthor = new Books[7];
		Books[] byId = new Books[7];
		
		Books TGatsby = new Books(7836262, "The great Gatsby", "F. Scott Fitzgerald", "English", "Fiction");
		Books TKill = new Books(7174668, "To kill a mockingbird", "Harper Lee", "English", "Thriller");
		Books Pride = new Books(8724795, "Pride and prejudice","Jane Austen", "English", "Romance");
		Books Tcatcher = new Books (7660479, "The catcher in the Rye", "J. D. Salinger", "English", "Young adult fiction");
		Books Phantom = new Books (3283121, "Phantom", "Jo Nesbo", "English", "Mystery");
		Books	WNext = new Books (1917707, "What comes next", "John Katzenbach", "English", "Suspense");
		Books PetS = new Books (3924794, "Pet Sematary", "Stephen King", "English", "Thriller");
		
		byTitle[0] = PetS;
		byTitle[1] = Phantom;
		byTitle[2] = Pride;
		byTitle[3] = Tcatcher;
		byTitle[4] = TGatsby;
		byTitle[5] = TKill;
		byTitle[6] = WNext;
		
		byAuthor[0] = TGatsby;
		byAuthor[1] = TKill;
		byAuthor[2] = Tcatcher;
		byAuthor[3] = Pride;
		byAuthor[4] = Phantom;
		byAuthor[5] = WNext;
		byAuthor[6] = PetS;
		
		byId[0] = WNext;
		byId[1] = Phantom;
		byId[2] = PetS;
		byId[3] = TKill;
		byId[4] = Tcatcher;
		byId[5] = TGatsby;
		byId[6] = Pride;
		
		
		
		switch (request.getOperation()) {  
	     case TITLE:
	    	 for (int i=0; i < byTitle.length; i++) {
	    		AvailableBooks response;
	 			response = AvailableBooks.newBuilder().setBookId(byTitle[i].getBookId()).setTitle(byTitle[i].getTitle()).setAuthor(byTitle[i].getAuthor()).setLanguage(byTitle[i].getLang()).setSubject(byTitle[i].getSubject()).build();
	 			responseObserver.onNext(response);
	 			
	 			//slow it all down a bit so we can observe the behaviour 
	 			try {
	 				//wait for a second
	 				Thread.sleep(1000);
	 			} catch (InterruptedException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	 			
	 		}
	       break;
	       
	     case AUTHOR:
	    	 for (int i=0; i < 7; i++) {
	    		 AvailableBooks response;
		 		//	response = AvailableBooks.newBuilder().setBookId(byAuthor[i].getBookId()).setTitle(byAuthor[i].getTitle()).setAuthor(byAuthor[i].getAuthor()).setLanguage(byAuthor[i].getLang()).setSubject(byAuthor[i].getSubject()).build();
	    		 response = AvailableBooks.newBuilder().setBookId(3+i).build();
		 			responseObserver.onNext(response);
		 			
		 			//slow it all down a bit so we can observe the behaviour 
		 			try {
		 				//wait for a second
		 				Thread.sleep(1000);
		 			} catch (InterruptedException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 			}
		 			
		 		}
		       break;
		       
	     case ID:
	    	 for (int i=0; i < 7; i++) {
	    		 AvailableBooks response;
		 			response = AvailableBooks.newBuilder().setBookId(byId[i].getBookId()).setTitle(byId[i].getTitle()).setAuthor(byId[i].getAuthor()).setLanguage(byId[i].getLang()).setSubject(byId[i].getSubject()).build();
		 			responseObserver.onNext(response);
		 			
		 			//slow it all down a bit so we can observe the behaviour 
		 			try {
		 				//wait for a second
		 				Thread.sleep(700);
		 			} catch (InterruptedException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 			}
		 			
		 		}
		       break;
		 default :
			 AvailableBooks response;
			 response = AvailableBooks.newBuilder().setBookId(0).setTitle("N/A").setAuthor("N/A").setLanguage("N/A").setSubject("N/A").build();
			 
	      }
		//AvailableBooks response;
		//response = AvailableBooks.newBuilder().setBookId(0).setTitle("N/A").setAuthor("N/A").setLanguage("N/A").setSubject("N/A").build();
		
		// signal that there are no more responses
		responseObserver.onCompleted();
		
		
	}
	
	
	
	
}
