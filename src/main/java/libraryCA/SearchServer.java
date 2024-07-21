package libraryCA;

import java.io.IOException;
import java.time.LocalTime;

import generated.search.AvailableBooks;
import generated.search.ListBy;
import generated.search.userID;
import generated.search.userInformation;
import generated.search.SearchEngineGrpc.SearchEngineImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SearchServer extends SearchEngineImplBase{
	public static void main(String[] args) {
		SearchServer searchServer = new SearchServer();
		
		int port = 50051;
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(searchServer)
					.build()
					.start();
			
			System.out.println(LocalTime.now().toString() + ": Search Engine Server started, listening on " + port);
			server.awaitTermination();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	/*
	 * SEARCH SERVICE
	 * SERVER-STREAMING RPC
	 * The client sends information about a book they're looking for and the system returns
	 * data related to that book's availability in different locations
	 */
	public void availability(ListBy request,
			StreamObserver<AvailableBooks> responseObserver) {
		
		System.out.println(LocalTime.now().toString() + " : receiving convert request with values : " + request.getOperation());
		
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
	 			response = AvailableBooks.newBuilder().setTitle(byTitle[i].getTitle()).setBookId(byTitle[i].getBookId()).setAuthor(byTitle[i].getAuthor()).setLanguage(byTitle[i].getLang()).setSubject(byTitle[i].getSubject()).build();
	 			responseObserver.onNext(response);
	 			
	 			//slow it all down a bit so we can observe the behaviour 
	 			try {
	 				//wait for a second
	 				Thread.sleep(7000);
	 			} catch (InterruptedException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	 			
	 		}
	       break;
	       
	     case AUTHOR:
	    	 for (int i=0; i < 7; i++) {
	    		 AvailableBooks response;
		 		response = AvailableBooks.newBuilder().setAuthor(byAuthor[i].getAuthor()).setBookId(byAuthor[i].getBookId()).setTitle(byAuthor[i].getTitle()).setLanguage(byAuthor[i].getLang()).setSubject(byAuthor[i].getSubject()).build();
	    		 //response = AvailableBooks.newBuilder().setBookId(3+i).build();
	    		 
		 			responseObserver.onNext(response);
		 			
		 			//slow it all down a bit so we can observe the behaviour 
		 			try {
		 				//wait for a second
		 				Thread.sleep(7000);
		 			} catch (InterruptedException e) {
		 				// TODO Auto-generated catch block
		 				System.out.println("No book");
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
		 				Thread.sleep(7000);
		 			} catch (InterruptedException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 			}
		 			
		 		}
		       break;
		 default :
			 AvailableBooks response;
			 response = AvailableBooks.newBuilder().setBookId(0).setTitle("N/A").setAuthor("N/A").setLanguage("N/A").setSubject("N/A").build();
			 responseObserver.onNext(response);
	      }
		
		
		// signal that there are no more responses
		responseObserver.onCompleted();
		
		
	}
	
	/*
	 * VISITOR SEARCH SERVICE
	 * UNARY RPC
	 */
	public void readerInfo(userID request, StreamObserver<userInformation> responseObserver) {
		System.out.println(LocalTime.now().toString() + ": receiving userID request: " + request.getUserNumber());
		String name, registrationDate;
		boolean borrowedBooks, status;
		int totalBooksBorrowed;
		
		switch (request.getUserNumber()) {
		/*
		 * USERID available 443325, 493947, 102934, and 980661
		 */
		
			case 443325:
				name = "Catalina Jauregui";
				registrationDate = "20/12/2004";
				borrowedBooks = true;
				status = true;
				totalBooksBorrowed = 4;
				break;
			default :
				name = "User not found";
				registrationDate = "";
				borrowedBooks = false;
				status = false;
				totalBooksBorrowed = 0;
		}
		
		
		userInformation response = userInformation.newBuilder().setName(name).setRegistrationDate(registrationDate).setBorrowedBooks(borrowedBooks).setStatus(status).setTotalBooksBorrowed(totalBooksBorrowed).build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
