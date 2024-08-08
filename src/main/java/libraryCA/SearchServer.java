package libraryCA;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import generated.search.AvailableBooks;
import generated.search.ListBy;
import generated.search.userID;
import generated.search.userInformation;
import generated.search.SearchEngineGrpc.SearchEngineImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import library.objects.Books;
import library.objects.Visitor;

public class SearchServer extends SearchEngineImplBase{
	public static void main(String[] args) {
		SearchServer searchServer = new SearchServer();
		
		int port = 50052;
		
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
	
	public static void startServer() throws IOException{
		SearchServer sServer = new SearchServer();
		int port = 50052;
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(sServer)
					.build()
					.start();
			
			System.out.println(LocalTime.now().toString() + ": Search Engine Server started, listening on " + port);
			Thread.sleep(200);
			
		} catch (IOException | InterruptedException e) {
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

		Books[] bookList = new Books[7];
		
		Books TGatsby = new Books(7836262, "The great Gatsby", "F. Scott Fitzgerald", "English", "Fiction",3);
		Books TKill = new Books(7174668, "To kill a mockingbird", "Harper Lee", "English", "Thriller",7);
		Books Pride = new Books(8724795, "Pride and prejudice","Jane Austen", "English", "Romance",5);
		Books Tcatcher = new Books (7660479, "The catcher in the Rye", "J. D. Salinger", "English", "Young adult fiction",1);
		Books Phantom = new Books (3283121, "Phantom", "Jo Nesbo", "English", "Mystery",9);
		Books	WNext = new Books (1917707, "What comes next", "John Katzenbach", "English", "Suspense",4);
		Books PetS = new Books (3924794, "Pet Sematary", "Stephen King", "English", "Thriller",8);
		
		bookList[0] = WNext;
		bookList[1] = Phantom;
		bookList[2] = PetS;
		bookList[3] = TKill;
		bookList[4] = Tcatcher;
		bookList[5] = TGatsby;
		bookList[6] = Pride;
		
		AvailableBooks response;
		
		switch (request.getOperation()) {  
	     case TITLE:
	    	 for (int i=0; i < bookList.length; i++) {
	    		quickSort(bookList, 0, bookList.length-1, "Title");
	 			response = AvailableBooks.newBuilder().setTitle(bookList[i].getTitle()).setBookId(bookList[i].getBookId())
	 					.setAuthor(bookList[i].getAuthor()).setLanguage(bookList[i].getLang()).setSubject(bookList[i].getSubject())
	 					.setBookQty(bookList[i].getBookQty()).build();
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
	    	 for (int i=0; i < bookList.length; i++) {
	    		 quickSort(bookList, 0, bookList.length-1, "Author");
		 		response = AvailableBooks.newBuilder().setTitle(bookList[i].getTitle()).setBookId(bookList[i].getBookId()).setAuthor(bookList[i].getAuthor()).setLanguage(bookList[i].getLang()).setSubject(bookList[i].getSubject()).setBookQty(bookList[i].getBookQty()).build();
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
	    	 for (int i=0; i < bookList.length; i++) {
	    		 quickSort(bookList, 0, bookList.length-1, "ID");
		 			response = AvailableBooks.newBuilder().setTitle(bookList[i].getTitle()).setBookId(bookList[i].getBookId()).setAuthor(bookList[i].getAuthor()).setLanguage(bookList[i].getLang()).setSubject(bookList[i].getSubject()).setBookQty(bookList[i].getBookQty()).build();
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
	     case UNRECOGNIZED:
			 response = AvailableBooks.newBuilder().setBookId(0).setTitle("N/A").setAuthor("N/A").setLanguage("N/A").setSubject("N/A").build();
			 responseObserver.onNext(response);
				break;
		 default :
			 //AvailableBooks response;
			 response = AvailableBooks.newBuilder().setBookId(0).setTitle("N/A").setAuthor("N/A").setLanguage("N/A").setSubject("N/A").build();
			 responseObserver.onNext(response);
	      }
		
		
		// signal that there are no more responses
		responseObserver.onCompleted();
		
		
	}
	
	/*
	 * QUICK SORT ALGORITHM USED TO SORT THE ARRAYS
	 */
	private void quickSort(Books[] list, int iStart, int iEnd, String opt) {
        int iPivotIndex;
        if (iStart < iEnd) {
            iPivotIndex = partition(list, iStart, iEnd, opt);
            quickSort(list, iStart, iPivotIndex - 1, opt);
            quickSort(list, iPivotIndex + 1, iEnd, opt);
        } 
    }

    private int partition(Books[] list, int iStart, int iEnd, String opt) {
        int iUp, iDown;
        Books pivot;
        pivot = list[iStart];
        iUp = iStart;
        iDown = iEnd;
        while (iUp < iDown) {
            while (iUp < iEnd && list[iUp].compareObject(pivot, opt)<= 0 ) {
                iUp = iUp + 1;
            }
            while (iDown > iStart && list[iDown].compareObject(pivot, opt) > 0){
                iDown = iDown - 1;
            }
            if (iUp < iDown) {
                Books elementUp = list[iUp];
                list[iUp] = list[iDown];
                list[iDown] = elementUp;
                
            } 
        }
        list[iStart] = list[iDown];
        list[iDown] = pivot;
        return iDown;
    }
	
	/*
	 * VISITOR SEARCH SERVICE
	 * UNARY RPC
	 */
	public void readerInfo(userID request, StreamObserver<userInformation> responseObserver) {
		System.out.println(LocalTime.now().toString() + ": receiving userID request: " + request.getUserNumber());
		ArrayList<Visitor> visitorList = new ArrayList<Visitor>();
		// USERIDs available 443325, 493947, 102934, and 980661
				Visitor v1 = new Visitor("Mildred García", true, "20/12/2004", true, 443325, 4);
				Visitor v2 = new Visitor("Edward Cullen", true, "15/04/2007", true, 493947, 2);
				Visitor v3 = new Visitor("Alice Cullen", false, "03/02/2007", false, 102934, 0);
				Visitor v4 = new Visitor("Bella Swan", true, "03/11/2001", false, 980661, 0);

				visitorList.add(v1);
				visitorList.add(v2);
				visitorList.add(v3);
				visitorList.add(v4);
				
		String name, registrationDate;
		boolean borrowedBooks, status, found;
		int totalBooksBorrowed;
		
		
		int iFound;
		if(!visitorList.isEmpty()) {
			iFound = binarySearch(request.getUserNumber(), visitorList, 0, visitorList.size()-1);
		} else {
			iFound = -1;
		}
		
		if(iFound >=0) {
			found = true;
			name = visitorList.get(iFound).getName();
			registrationDate = visitorList.get(iFound).getRegDate();
			borrowedBooks = visitorList.get(iFound).getbBooks();
			status = visitorList.get(iFound).getStatus();
			totalBooksBorrowed = visitorList.get(iFound).getBorrowedBooks();
		} else {
			found = false;
			name = "N/F";
			registrationDate = "Unavailable";
			borrowedBooks = false;
			status = false;
			totalBooksBorrowed = 0;
		}
		
		
		userInformation response = userInformation.newBuilder().setName(name)
				.setRegistrationDate(registrationDate).setBorrowedBooks(borrowedBooks)
				.setStatus(status).setTotalBooksBorrowed(totalBooksBorrowed).setFound(found).build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	/*
	 * BINARY SEARCH METHOD
	 */
	private static int binarySearch(int key, ArrayList<Visitor> list, int iStart, int iEnd) {
        int iResult = 0;
        int iMiddle = (iStart + iEnd) / 2;
        if (list.get(iMiddle).getVisitorId() == key) {
            iResult = iMiddle;
            System.out.println("The element " + key + " was found in the index: " + iResult 
                    + "\nEntire element data:\n" + list.get(iMiddle).toString());
        } else if(iStart == iEnd){
        	iResult = -1;
        }else {
            if (list.get(iMiddle).getVisitorId() > key) {
                iResult = binarySearch(key, list, iStart, iMiddle - 1);
            } else {
                iResult = binarySearch(key, list, iMiddle + 1, iEnd);
            }
        }
        return iResult;
    }
}
