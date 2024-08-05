package libraryCA;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import generated.registration.BookRegistrationRequest;
import generated.registration.BookRegistrationRequest.RegistrationType;
import generated.registration.BookRegistrationResponse;
import generated.registration.RegistrationBookGrpc.RegistrationBookImplBase;
import generated.registration.VisitorRegistrationRequest;
import generated.registration.VisitorRegistrationResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RegisterServer extends RegistrationBookImplBase {
	private static final Books[][] Array = null;
	private static final ArrayList<Visitor> visitorList = new ArrayList<Visitor>();

	public static void main(String[] args) {

		Visitor Cata = new Visitor("Catalina Jauregui", "Active", "20/12/2004", "Yes", 443325, 4);
		visitorList.add(Cata);

		RegisterServer regServ = new RegisterServer();

		int port = 50051;

		try {
			Server srvr = ServerBuilder.forPort(port).addService(regServ).build().start();
			System.out.println(LocalTime.now().toString() + ": Register Server started, listening on " + port);
			srvr.awaitTermination();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // Main

	/*
	 * VISITOR REGISTRATION SERVICE UNARY RPC
	 */
	public void visitorRegister(VisitorRegistrationRequest request,
			StreamObserver<VisitorRegistrationResponse> responseObserver) {

		System.out.println("Reveiving visitor's registration request.");
		String confirmation, date, vName = request.getName(), vStatus = request.getStatus();
		int vId = request.getVisitorId();
		date = LocalDate.now().toString();

		Visitor v1 = new Visitor(vName, vStatus, date, "No", vId, 0);
		visitorList.add(v1);

		confirmation = "Registration complete for the visitor " + v1.getName() + " with ID " + v1.getVisitorId()
				+ "\nStatus: " + v1.getStatus();

		VisitorRegistrationResponse resp = VisitorRegistrationResponse.newBuilder()
				.setRegistrationConfirmation(confirmation).setRegistrationDate(date).build();

		responseObserver.onNext(resp);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		responseObserver.onCompleted();
	} // Visitor register

	/*
	 * BOOK REGISTRATION SERVICE BI-DIRECTIONAL STREAM RPC rpc bookRegister (stream
	 * BookRegistrationRequest) returns (stream BookRegistrationResponse)
	 */
	public StreamObserver<BookRegistrationRequest> bookRegister(
			StreamObserver<BookRegistrationResponse> responseObserver) {

		return new StreamObserver<BookRegistrationRequest>() {
			int success = 0, totalQty = 0, failed=0;

			@Override
			public void onNext(BookRegistrationRequest msg) {
				System.out.println(
						LocalTime.now().toString() + ": receiving registration type: " + msg.getRegistration());

				// IDs available 7836262, 7174668, 8724795, 7660479, 3283121, 1917707, 3924794
				Books[] booksList = new Books[7];

				Books TGatsby = new Books(7836262, "The great Gatsby", "F. Scott Fitzgerald", "English", "Fiction", 3);
				Books TKill = new Books(7174668, "To kill a mockingbird", "Harper Lee", "English", "Thriller", 7);
				Books Pride = new Books(8724795, "Pride and prejudice", "Jane Austen", "English", "Romance", 5);
				Books Tcatcher = new Books(7660479, "The catcher in the Rye", "J. D. Salinger", "English",
						"Young adult fiction", 100);
				Books Phantom = new Books(3283121, "Phantom", "Jo Nesbo", "English", "Mystery", 9);
				Books WNext = new Books(1917707, "What comes next", "John Katzenbach", "English", "Suspense", 4);
				Books PetS = new Books(3924794, "Pet Sematary", "Stephen King", "English", "Thriller", 8);
				booksList[0] = WNext;
				booksList[1] = Phantom;
				booksList[2] = PetS;
				booksList[3] = TKill;
				booksList[4] = Tcatcher;
				booksList[5] = TGatsby;
				booksList[6] = Pride;

				Integer[] idList = new Integer[7];
				for (int i = 0; i < idList.length; i++) {
					idList[i] = booksList[i].getBookId();
				}
				
				System.out.println(idList[0] + ", " + idList[6]);

				String visitorId = "User ID: " + msg.getUserId();
				boolean reqStat;

				String bookDtls = "";
				BookRegistrationResponse resp = BookRegistrationResponse.newBuilder().setUserInfo(visitorId).build();
				String regType = "" + msg.getRegistration();
				
				
				//System.out.println(msg.getUserId());
				boolean idFound = findID(visitorList, msg.getUserId(), msg);
				
				if (idFound) {
					switch (msg.getRegistration()) {
					case BORROW:
						System.out.println("Requesting to borrow " + msg.getBookQty() + " copies.");
						int iIndex = Arrays.binarySearch(idList, 0, idList.length-1, msg.getBookId());
						if (iIndex >= 0) {
							if (msg.getBookQty() <= booksList[iIndex].getBookQty()) {
								System.out.println("SUCCESSFUL\n" + booksList[iIndex].toString());
								bookDtls = "ID: " + booksList[iIndex].getBookId() + "Title: " + booksList[iIndex].getTitle() + " Author: " + booksList[iIndex].getAuthor();
								totalQty += msg.getBookQty();
								success++;
								reqStat=true;
							} else {
								System.out.println("FAILURE\n There are no more available copies of the book: "+ booksList[iIndex].getTitle());
								bookDtls = "There are no more available copies of the book: "
										+ booksList[iIndex].getTitle();
								reqStat=false;
							}

						} else {
							System.out.println("FAILURE \nBook not found");
							bookDtls = "Book not found.";
							reqStat=false;
							failed++;
						}
						
						break;
					case RETURN:

						//visitorId = "User registered: " + msg.getUserId();
						bookDtls = "Book registered: " + msg.getBookId();
						totalQty += msg.getBookQty();
						reqStat=true;
						success++;
						// resp =
						// BookRegistrationResponse.newBuilder().setUserInfo(visitorId).setBookDetails(bookDtls)
						// .setTotalBooks(iCount).build();
						break;
					case UNRECOGNIZED:
						bookDtls = "Invalid option";
						reqStat=false;
						break;
					default:
						bookDtls = "Invalid option";
						reqStat=false;
					} // Switch
				} else {
					bookDtls = "User inactive or not found.";
					reqStat=false;
				}
				System.out.println(totalQty);
				int totReg = success+failed;
				resp = BookRegistrationResponse.newBuilder().setUserInfo(visitorId).setBookDetails(bookDtls)
						.setComplReg(totReg).setRegType(regType).setTotalBooks(totalQty).setReqStatus(reqStat).build();
				responseObserver.onNext(resp);

			} // On next

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
			}// onError

			@Override
			public void onCompleted() {
				System.out.println(LocalTime.now().toString() + ": receiving book registration completed. Successful operations: " + success + ". Failed attempts: " + (failed) + "\nTotal books registered: " + totalQty);
				responseObserver.onCompleted();

			} // onCompleted
		}; // Stream observer
	} // Book register

	private boolean findID(ArrayList<Visitor> list, int vId, BookRegistrationRequest msg) {
		for (int i = 0; i < visitorList.size(); i++) {
			System.out.println(visitorList.get(i).toString());
			if (list.get(i).getVisitorId() == msg.getUserId()
					&& visitorList.get(i).getStatus().equalsIgnoreCase("Active")) {
				return true;
			}
		}
		return false;
	}

} // Register server
