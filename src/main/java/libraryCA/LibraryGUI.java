package libraryCA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import generated.lights.AverageResponse;
import generated.lights.LightLevel;
import generated.lights.LightRequest;
import generated.lights.LightServiceGrpc;
import generated.lights.StatusResponse;
import generated.lights.LightServiceGrpc.LightServiceBlockingStub;
import generated.lights.LightServiceGrpc.LightServiceStub;
import generated.search.AvailableBooks;
import generated.search.ListBy;
import generated.search.ListBy.ListOperation;
import generated.search.SearchEngineGrpc;
import generated.search.userID;
import generated.search.userInformation;
//import generated.search.SearchEngineGrpc.SearchEngineBlockingStub;
//import generated.search.SearchEngineGrpc.SearchEngineStub;
import generated.search.SearchEngineGrpc.*;
import generated.search.AvailableBooks;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibraryGUI extends JFrame {

	int barCount, lightCount=0, calcAvg=0;
	ArrayList<Integer> lightList = new ArrayList<Integer>();
	ArrayList<String> timeList = new ArrayList<String>();
	boolean manualID=false;
	
	int onOffInst = 0;
	
	//ListBy request;
	//ListBy.ListOperation operation;
	
	private static LightServiceBlockingStub LSblockingStub;
	private static LightServiceStub asyncStub;
	public static SearchEngineStub SEasyncStub;
	private static SearchEngineBlockingStub SEblockingStub;
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userIDinput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 50051)
				.usePlaintext()
				.build();
		
		LSblockingStub = LightServiceGrpc.newBlockingStub(channel);
		asyncStub = LightServiceGrpc.newStub(channel);
		SEasyncStub = SearchEngineGrpc.newStub(channel); 
		SEblockingStub = SearchEngineGrpc.newBlockingStub(channel);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryGUI frame = new LibraryGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LibraryGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel AvgPanel = new JPanel();
		AvgPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Average lighting", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		AvgPanel.setBounds(10, 10, 273, 187);
		contentPane.add(AvgPanel);
		AvgPanel.setLayout(null);
		
		JLabel LightLevelLbl = new JLabel("Natural light level (1-5)");
		LightLevelLbl.setBounds(24, 25, 155, 14);
		AvgPanel.add(LightLevelLbl);
		
		JLabel TimeLbl = new JLabel("Time (Select)");
		TimeLbl.setBounds(24, 50, 155, 14);
		AvgPanel.add(TimeLbl);
		
		JSpinner LightLvlSpn = new JSpinner();
		LightLvlSpn.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		LightLvlSpn.setBounds(177, 22, 86, 20);
		AvgPanel.add(LightLvlSpn);
		
		JLabel avgLbl = new JLabel("Average light level");
		avgLbl.setBounds(24, 114, 114, 14);
		AvgPanel.add(avgLbl);
		
		JPanel emergencyPanel = new JPanel();
		emergencyPanel.setBorder(new TitledBorder(null, "Emergency lights", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		emergencyPanel.setBounds(10, 204, 273, 92);
		contentPane.add(emergencyPanel);
		emergencyPanel.setLayout(null);
		
		JLabel lightStateLbl = new JLabel("Current state");
		lightStateLbl.setBounds(10, 31, 89, 14);
		emergencyPanel.add(lightStateLbl);
		lightStateLbl.setHorizontalAlignment(SwingConstants.LEFT);
		
		JTextArea lightStateTa = new JTextArea();
		lightStateTa.setLineWrap(true);
		lightStateTa.setWrapStyleWord(true);
		lightStateTa.setText("Lights are turned off");
		lightStateTa.setEditable(false);
		lightStateTa.setBounds(109, 26, 154, 21);
		emergencyPanel.add(lightStateTa);
		
		JButton OnOffBtn = new JButton("Turn On/Off");
		OnOffBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int instruction;
				if(onOffInst==1) {
					onOffInst = 0;
					instruction = onOffInst;
				} else {
					onOffInst = 1;
					instruction = onOffInst;
				}
				LightRequest req = LightRequest.newBuilder().setLightButton(instruction).build();
				StatusResponse resp = LSblockingStub.turnOnOff(req);
				
				System.out.println(LocalTime.now().toString() + ": Validation message: " + resp.getLightState());
				lightStateTa.replaceRange(resp.getLightState(), 0, resp.getLightState().length());
			}
		});
		OnOffBtn.setBounds(69, 56, 121, 23);
		emergencyPanel.add(OnOffBtn);
		
		JComboBox timeOptions = new JComboBox();
		timeOptions.setBounds(177, 46, 86, 22);
		AvgPanel.add(timeOptions);
		timeOptions.setModel(new DefaultComboBoxModel(new String[] {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 139, 221, 37);
		AvgPanel.add(scrollPane);
		
		JTextArea avgTa = new JTextArea();
		avgTa.setFont(new Font("Monospaced", Font.PLAIN, 12));
		avgTa.setLineWrap(true);
		scrollPane.setViewportView(avgTa);
		avgTa.setEditable(false);
		
		/*
		 * AVERAGE LIGHTING
		 * SERVER STREAMING RPC
		 */
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lightLvl = (int) LightLvlSpn.getValue();
				if(lightLvl>= 0 && lightLvl<=5) {
					lightList.add(lightCount, lightLvl);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid input for light level");
				}
				
				/*String lightTime = TimeTxt.getText();
				 */
				String lightTime = (String) timeOptions.getSelectedItem();
				if(lightTime.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Invalid input for time");
				} else {
					timeList.add(lightCount, lightTime);
				}
				if(lightLvl>= 0 && lightLvl<=100 && !lightTime.isEmpty()) {
					lightCount++;
				}
			}
		});
		submitBtn.setBounds(10, 80, 89, 23);
		AvgPanel.add(submitBtn);
		
		//Sending the information to the server
		JButton avgBtn = new JButton("Calculate average");
		avgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//averageLighting(stream LightLevel) returns (AverageResponse)
				//averageValues(stream NumberMessage) returns (CalculateResponse )
				StreamObserver<AverageResponse> responseObserver = new StreamObserver<AverageResponse>() {
					
					@Override
					public void onNext(AverageResponse msg) {
						// TODO Auto-generated method stub
						System.out.println(LocalTime.now().toString() + ": Response from server " + msg.getLightAverage());
						avgTa.append(msg.getLightAverage());
						
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
					for(int i=0; i<lightList.size(); i++) {
						requestObserver.onNext(LightLevel.newBuilder().setLevel(lightList.get(i)).setCurrentTime(timeList.get(i)).build());
						Thread.sleep(700);
					}
					
					requestObserver.onCompleted();
					
					Thread.sleep(7000);
					
				} catch (RuntimeException exc) {
					exc.printStackTrace();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		});
		avgBtn.setBounds(109, 80, 136, 23);
		AvgPanel.add(avgBtn);
		
		JPanel availabilityPanel = new JPanel();
		availabilityPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Book Availability", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		availabilityPanel.setBounds(293, 11, 294, 158);
		contentPane.add(availabilityPanel);
		availabilityPanel.setLayout(null);
		
		JComboBox listByOptions = new JComboBox();
		listByOptions.setBounds(93, 12, 75, 20);
		listByOptions.setModel(new DefaultComboBoxModel(ListOperation.values()));
		availabilityPanel.add(listByOptions);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 40, 274, 107);
		availabilityPanel.add(scrollPane_1);
		
		JTextArea booksTa = new JTextArea();
		booksTa.setEditable(false);
		scrollPane_1.setViewportView(booksTa);
		
		JButton btnListBy = new JButton("Submit");
		btnListBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListBy requestAsyn;
				ListBy.ListOperation operation;
				operation = (ListOperation) listByOptions.getSelectedItem();
				
				System.out.println("You selected to list the books by: " + operation);
				requestAsyn = ListBy.newBuilder().setOperation(operation).build();
				
				/*
				 * SERVER STREAMING (NON-BLOCKING)
				 */
				// set up the responseObserver - this is a new object where the client specifies the
				// behaviour to be performed for onNext , onCompleted and onError 
				// the responseObserver is passed to the server when the request is made.
				// The server calls onNext() for each response and onComplete() when its finished responding 
				// The client is able to observe these events via the responseObserver.
				// note that we are calling the same server side method as for the synchronous call  
				// the server behaves the same - the clients reaction to the responses is different - it is 
				// asynchronous
				
				StreamObserver<AvailableBooks> responseObserver = new StreamObserver<AvailableBooks>() {
				
					int count =0 ;

					@Override
					public void onNext(AvailableBooks value) {
						switch (operation) {
						case AUTHOR:
							System.out.println(LocalTime.now().toString() + ": receiving book's information.\nAuthor: " + value.getAuthor() + "\nBook ID: " + value.getBookId() + "\nTitle: " + value.getTitle() + "\nLanguage: " + value.getLanguage() + "\nSubject: " + value.getSubject());
							count += 1;
							booksTa.append("Author: " + value.getAuthor() + "\nBook ID: " + value.getBookId() + "\nTitle: " + value.getTitle() + "\nLanguage: " + value.getLanguage() + "\nSubject: " + value.getSubject() + "\n- - - - - -\n");
							break;
						case ID:
							System.out.println(LocalTime.now().toString() + ": receiving book's information." + "\nBook ID: " + value.getBookId() + "\nAuthor: " + value.getAuthor() + "\nTitle: " + value.getTitle() + "\nLanguage: " + value.getLanguage() + "\nSubject: " + value.getSubject());
							count += 1;
							booksTa.append("Book ID: " + value.getBookId() + "\nTitle: " + value.getTitle() + "\nAuthor: " + value.getAuthor() + "\nLanguage: " + value.getLanguage() + "\nSubject: " + value.getSubject() + "\n- - - - - -\n");
							break;
						case TITLE:
							System.out.println(LocalTime.now().toString() + ": receiving book's information." + "\nTitle: " + value.getTitle() + "\nBook ID: " + value.getBookId() + "\nAuthor: " + value.getAuthor() +  "\nLanguage: " + value.getLanguage() + "\nSubject: " + value.getSubject());
							count += 1;
							booksTa.append("\nTitle: " + value.getTitle() + value.getBookId() + "\nAuthor: " + value.getAuthor() + "\nLanguage: " + value.getLanguage() + "\nSubject: " + value.getSubject() + "\n- - - - - -\n");
							break;
						case UNRECOGNIZED:
							System.out.println("Invalid option");
							booksTa.append("Invalid selection");
							break;
						default:
							System.out.println("Invalid option");
							booksTa.append("Invalid selection");
							break;
						
						}
						
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();

					}

					@Override
					public void onCompleted() {
						System.out.println(LocalTime.now().toString() + ": stream is completed ... received "+ count+ " books");
					}

				};

				
				// the client does not have to wait for the server to return - it can just fire off the request and go to sleep.
				//SEasyncStub.availability(request, responseObs);

				SEasyncStub.availability(requestAsyn, responseObserver);
				// the sleep here is optional - its purpose is to slow things down so we can observe what is happening
				try {
					Thread.sleep(15000);
				} catch (InterruptedException ie) {
					// TODO Auto-generated catch block
					ie.printStackTrace();
				} //SERVER STREAMING Nonblocking
			}
		});
		btnListBy.setBounds(178, 11, 89, 23);
		availabilityPanel.add(btnListBy);
		
		JLabel lblNewLabel = new JLabel("List books by:");
		lblNewLabel.setBounds(10, 15, 89, 14);
		availabilityPanel.add(lblNewLabel);
		
		
		JPanel detailsPanel = new JPanel();
		detailsPanel.setBorder(new TitledBorder(null, "Visitor details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		detailsPanel.setBounds(293, 180, 294, 218);
		contentPane.add(detailsPanel);
		detailsPanel.setLayout(null);
		
		JComboBox userIDopt = new JComboBox();
		userIDopt.setModel(new DefaultComboBoxModel(new String[] {"443325", "493947", "102934", "980661"}));
		userIDopt.setSelectedIndex(0);
		userIDopt.setBounds(157, 20, 86, 22);
		detailsPanel.add(userIDopt);
		
		JLabel userIDLbl = new JLabel("Select user ID:");
		userIDLbl.setBounds(29, 24, 100, 14);
		detailsPanel.add(userIDLbl);
		
		userIDinput = new JTextField();
		userIDinput.setEditable(false);
		userIDinput.setBounds(157, 53, 86, 20);
		detailsPanel.add(userIDinput);
		userIDinput.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 132, 274, 75);
		detailsPanel.add(scrollPane_2);
		
		JTextArea visitorDtlsTa = new JTextArea();
		scrollPane_2.setViewportView(visitorDtlsTa);
		
		JLabel detailsLbl = new JLabel("Visitor details:");
		detailsLbl.setBounds(10, 116, 100, 14);
		detailsPanel.add(detailsLbl);
		
		JCheckBox chckbxEnterIdManually = new JCheckBox("Enter ID manually");
		chckbxEnterIdManually.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (manualID == true) {
					userIDinput.setEditable(false);
					manualID = false;
				} else {
					System.out.println("Enter the visitor's ID: ");
					userIDinput.setEditable(true);
					manualID = true;
				}
				
			}
		});
		chckbxEnterIdManually.setBounds(10, 52, 141, 23);
		detailsPanel.add(chckbxEnterIdManually);
		
		JButton useridBtn = new JButton("Submit");
		useridBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * VISITOR SEARCH SERVICE
				 * UNARY RPC
				 */
				
				userID req;
				int userNum;
				if (manualID==false) {
					//USERIDs available 443325, 493947, 102934, and 980661
					//userNum = (int) userIDopt.getSelectedItem();
					userNum = Integer.valueOf((String) userIDopt.getSelectedItem());
					
				} else {
					userNum = Integer.valueOf(userIDinput.getText());
					
				}
				req = userID.newBuilder().setUserNumber(userNum).build();
				
				userInformation responseRI = SEblockingStub.readerInfo(req);
					
					System.out.println(LocalTime.now().toString() + ": User's information: \nNAME: " + responseRI.getName() + "\nREGISTRATION DATE: " + responseRI.getRegistrationDate() + "\nBORROWED BOOKS: " + responseRI.getBorrowedBooks() + "\nTOTAL BORROWED BOOKS: " + responseRI.getTotalBooksBorrowed() + "\nACTIVE: " + responseRI.getStatus());
				
					visitorDtlsTa.append("NAME: " + responseRI.getName() + "\nREGISTRATION DATE: " + responseRI.getRegistrationDate() + "\nBORROWED BOOKS: " + responseRI.getBorrowedBooks() + "\nTOTAL BORROWED BOOKS: " + responseRI.getTotalBooksBorrowed() + "\nACTIVE: " + responseRI.getStatus());
					
				
			}
		});
		useridBtn.setBounds(98, 82, 89, 23);
		detailsPanel.add(useridBtn);
		
		
		
		
		
		
		
		
		
	}//Library GUI
}
