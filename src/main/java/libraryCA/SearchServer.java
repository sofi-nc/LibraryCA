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
		
		//ArrayList<Books> booksList = new ArrayList<>();
		Books[] byTitle = new Books[7];
		Books[] byAuthor = new Books[7];
		Books[] byId = new Books[7];
		Books[] bookList = new Books[7];
		
		Books TGatsby = new Books(7836262, "The great Gatsby", "F. Scott Fitzgerald", "English", "Fiction",3);
		Books TKill = new Books(7174668, "To kill a mockingbird", "Harper Lee", "English", "Thriller",7);
		Books Pride = new Books(8724795, "Pride and prejudice","Jane Austen", "English", "Romance",5);
		Books Tcatcher = new Books (7660479, "The catcher in the Rye", "J. D. Salinger", "English", "Young adult fiction",1);
		Books Phantom = new Books (3283121, "Phantom", "Jo Nesbo", "English", "Mystery",9);
		Books	WNext = new Books (1917707, "What comes next", "John Katzenbach", "English", "Suspense",4);
		Books PetS = new Books (3924794, "Pet Sematary", "Stephen King", "English", "Thriller",8);
		
	/*	byTitle[0] = PetS;
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
		byId[6] = Pride; */
		
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
	    	 for (int i=0; i < byTitle.length; i++) {
	    		quickSort(bookList, 0, bookList.length-1, "Title");
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
	       
	     case AUTHOR:
	    	 for (int i=0; i < 7; i++) {
	    		 quickSort(bookList, 0, bookList.length-1, "Author");
		 		response = AvailableBooks.newBuilder().setTitle(bookList[i].getTitle()).setBookId(bookList[i].getBookId()).setAuthor(bookList[i].getAuthor()).setLanguage(bookList[i].getLang()).setSubject(bookList[i].getSubject()).build();
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
	    		 quickSort(bookList, 0, bookList.length-1, "ID");
		 			response = AvailableBooks.newBuilder().setTitle(bookList[i].getTitle()).setBookId(bookList[i].getBookId()).setAuthor(bookList[i].getAuthor()).setLanguage(bookList[i].getLang()).setSubject(bookList[i].getSubject()).build();
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
            /*
                select pivot and re-arrange elements in two partitions such as
                all array[start … p-1] are less than pivot = array [p] and
                all array[p+1 … end] are >= pivot
             */
            iPivotIndex = partition(list, iStart, iEnd, opt);
            //System.out.println("\npivotindex sort\n");

            // sort first partition of the array (from start to pivot_index-1)
            quickSort(list, iStart, iPivotIndex - 1, opt);
            //System.out.println("\nquick sortleft\n");
            
            //sort second partition of the array
            quickSort(list, iPivotIndex + 1, iEnd, opt);
            //System.out.println("\nquick sortright\n");
        } 
    }

    private int partition(Books[] list, int iStart, int iEnd, String opt) {
        int iUp, iDown;
        Books pivot;

        // select the first element as pivot
        pivot = list[iStart];
        //System.out.println("pivot: " + pivot);
        
        // set the UP and DOWN indexes
        iUp = iStart;
        iDown = iEnd;
        //System.out.println("Start: " + iUp + " End: " + iDown);
        // as long as UP and DOWN indexes did not pass each other
        while (iUp < iDown) {
            // increment UP index until found first element higher than pivot
            /*
            * HERE IS WHERE YOU SHOULD PUT THE CONDITIONAL FOR THE ID BECAUSE IT SHOULD CHECK IF THE ENTIRE OBJECT IS < OR WHATEVER??
            */
            while (iUp < iEnd && list[iUp].compareObject(pivot, opt)<= 0 ) {
                iUp = iUp + 1;
               // System.out.println("value[iUp] < pivot: " + list[iUp].getlValue() + " < " + pivot.getlValue());
            }
            

            // decrement DOWN until found first element smaller than  pivot
            while (iDown > iStart && list[iDown].compareObject(pivot, opt) > 0){
                iDown = iDown - 1;
               // System.out.println("value[iDown] < pivot");
            }

            // if UP and DOWN indexes did not pass each other
            if (iUp < iDown) {
                Books elementUp = list[iUp];
                //swap the two elements found
                
                    list[iUp] = list[iDown];
                    list[iDown] = elementUp;
                   // System.out.println("swap");
                
            } 
        }

        // UP and DOWN indexes have passed each other, so swap pivot with the element on DOWN position
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
		String name, registrationDate;
		boolean borrowedBooks, status, found;
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
				found = true;
				break;
			case 493947:
				name = "Edward Cullen";
				registrationDate = "15/04/2007";
				borrowedBooks = true;
				status = true;
				totalBooksBorrowed = 2;
				found = true;
				break;
			case 102934:
				name = "Alice Cullen";
				registrationDate = "03/02/2007";
				borrowedBooks = false;
				status = false;
				totalBooksBorrowed = 0;
				found = true;
				break;
			case 980661:
				name = "Bella Swan";
				registrationDate = "03/11/2001";
				borrowedBooks = false;
				status = true;
				totalBooksBorrowed = 0;
				found = true;
				break;
			default :
				name = "User not found";
				registrationDate = "";
				borrowedBooks = false;
				status = false;
				totalBooksBorrowed = 0;
				found = false;
		}
		
		
		userInformation response = userInformation.newBuilder().setName(name).setRegistrationDate(registrationDate).setBorrowedBooks(borrowedBooks).setStatus(status).setTotalBooksBorrowed(totalBooksBorrowed).setFound(found).build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
