package libraryCA;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import generated.registration.BookRegistrationRequest;
import generated.registration.BookRegistrationRequest.RegistrationType;
import generated.registration.BookRegistrationResponse;
import generated.registration.RegistrationBookGrpc.RegistrationBookImplBase;
import generated.registration.VisitorRegistrationRequest;
import generated.registration.VisitorRegistrationResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RegisterServer extends RegistrationBookImplBase{
	private static final Books[][] Array = null;
	
	public static void main(String[] args) {
		RegisterServer regServ = new RegisterServer();
		
		int port = 50051;
		
		try {
			Server srvr = ServerBuilder.forPort(port)
					.addService(regServ)
					.build()
					.start();
			System.out.println(LocalTime.now().toString() + ": Register Server started, listening on " + port);
			srvr.awaitTermination();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * VISITOR REGISTRATION SERVICE
	 * UNARY RPC
	 */
	public void visitorRegister(VisitorRegistrationRequest request, StreamObserver<VisitorRegistrationResponse> responseObserver) {
		System.out.println("Reveiving visitor's registration request.");
		
		String confirmation, date;
		
		confirmation = "Registration complete for the ID: " + request.getVisitorId();
		date = LocalDate.now().toString();
		
		VisitorRegistrationResponse resp = VisitorRegistrationResponse.newBuilder()
.setRegistrationConfirmation(confirmation).setRegistrationDate(date).build();
		
		responseObserver.onNext(resp);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		responseObserver.onCompleted();
	}
	
	/*
	 * BOOK REGISTRATION SERVICE
	 * BINARY STREAM RPC
	 * rpc bookRegister (stream BookRegistrationRequest) returns (stream BookRegistrationResponse)
	 */
	public StreamObserver<BookRegistrationRequest> bookRegister(StreamObserver<BookRegistrationResponse> responseObserver){
		return new StreamObserver<BookRegistrationRequest> () {
			@Override
			public void onNext(BookRegistrationRequest msg) {
				System.out.println(LocalTime.now().toString() + ": receiving registration type: " + msg.getRegistration());
				
				//IDs available 7836262, 7174668, 8724795, 7660479, 3283121, 1917707, 3924794
				Books[] booksList = new Books[7];
				
				Books TGatsby = new Books(7836262, "The great Gatsby", "F. Scott Fitzgerald", "English", "Fiction");
				Books TKill = new Books(7174668, "To kill a mockingbird", "Harper Lee", "English", "Thriller");
				Books Pride = new Books(8724795, "Pride and prejudice","Jane Austen", "English", "Romance");
				Books Tcatcher = new Books (7660479, "The catcher in the Rye", "J. D. Salinger", "English", "Young adult fiction");
				Books Phantom = new Books (3283121, "Phantom", "Jo Nesbo", "English", "Mystery");
				Books	WNext = new Books (1917707, "What comes next", "John Katzenbach", "English", "Suspense");
				Books PetS = new Books (3924794, "Pet Sematary", "Stephen King", "English", "Thriller");
				booksList[0] = WNext;
				booksList[1] = Phantom;
				booksList[2] = PetS;
				booksList[3] = TKill;
				booksList[4] = Tcatcher;
				booksList[5] = TGatsby;
				booksList[6] = Pride;
				
				switch (msg.getRegistration()) {
				case BORROW:
					int found = booksList.binarySearch(booksList, 0, booksList.length, Phantom);
					//if()
					String regBook = "Book with ID " + msg.getBookId() + " has been SUCCESSFULLY REGISTERED." 
					+ "Book details: ";
					break;
				default:
				}

				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}
		}
	}
	
}
