package libraryCA;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;

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
import library.objects.BookRegistration;

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
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JList;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.AbstractListModel;

import generated.registration.BookRegistrationRequest;
import generated.registration.BookRegistrationResponse;
import generated.registration.RegistrationBookGrpc;
import generated.registration.VisitorRegistrationRequest;
import generated.registration.VisitorRegistrationResponse;
import generated.registration.BookRegistrationRequest.RegistrationType;
import generated.registration.RegistrationBookGrpc.RegistrationBookBlockingStub;
import generated.registration.RegistrationBookGrpc.RegistrationBookStub;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JTree;

public class LibraryGUI extends JFrame {

	private static class SampleListener implements ServiceListener {

		@Override
		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service added : " + event.getInfo());
		}

		@Override
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service removed : " + event.getInfo());

		}

		@Override
		public void serviceResolved(ServiceEvent event) {
			System.out.println("Service resolved : " + event.getInfo());

			ServiceInfo info = event.getInfo();
			int port = info.getPort();
			String path = info.getNiceTextString().split("=")[1];

			String url = "Localhost:" + port + "/" + path;
			System.out.println(" - - sending request to " + url);

		}
	}

	int barCount, lightCount = 0, calcAvg = 0;
	ArrayList<Double> lightList = new ArrayList<Double>();
	ArrayList<String> timeList = new ArrayList<String>();
	ArrayList<BookRegistration> regList = new ArrayList<BookRegistration>();
	boolean manualID = false, manualbkReg = false;

	int onOffInst = 0;

	private static LightServiceBlockingStub LSblockingStub;
	private static LightServiceStub asyncStub;
	public static SearchEngineStub SEasyncStub;
	private static SearchEngineBlockingStub SEblockingStub;
	private static RegistrationBookStub RAsyncStub;
	private static RegistrationBookBlockingStub RblockingStub;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userIDinput;
	private JTextField userIdTxt;
	private JTextField manualbkID;
	private JTextField visitrNmTxt;
	private JTextField visitrIDTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {

			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			// add a service listener
			jmdns.addServiceListener("_grpc.local.", new SampleListener());
			Thread.sleep(2000);
			System.out.println("Adding service listener to hostname: " + InetAddress.getLocalHost());

			// Create channel and stubs for Lighting service
			ManagedChannel lightCh = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

			ManagedChannel searchCh = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

			ManagedChannel registrationCh = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

			LSblockingStub = LightServiceGrpc.newBlockingStub(lightCh);
			asyncStub = LightServiceGrpc.newStub(lightCh);
			SEasyncStub = SearchEngineGrpc.newStub(searchCh);
			SEblockingStub = SearchEngineGrpc.newBlockingStub(searchCh);
			RAsyncStub = RegistrationBookGrpc.newStub(registrationCh);
			RblockingStub = RegistrationBookGrpc.newBlockingStub(registrationCh);

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

			// averageLighting();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("IOEXC\n" + e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // End service discovery
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LibraryGUI() {
		setTitle("Smart library");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\frida\\eclipse-workspace\\LibraryCA\\iconovaca1.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		/*
		 * AVERAGE LIGHTING SERVER STREAMING RPC
		 */
		contentPane.setLayout(null);

		JTabbedPane MenuTab = new JTabbedPane(JTabbedPane.LEFT);
		MenuTab.setBackground(new Color(240, 240, 240));
		MenuTab.setBounds(10, 7, 450, 400);
		MenuTab.setBorder(new EmptyBorder(0, 0, 0, 0));
		MenuTab.setToolTipText("Light Service");
		contentPane.add(MenuTab);

		JPanel LightPane = new JPanel();
		MenuTab.addTab("Lighting service", null, LightPane, null);
		LightPane.setLayout(null);

		JPanel AvgPanel = new JPanel();
		AvgPanel.setBounds(15, 11, 273, 230);
		LightPane.add(AvgPanel);
		AvgPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Average lighting", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		AvgPanel.setLayout(null);

		JLabel lightUsageLbl = new JLabel("Electric usage (W)");
		lightUsageLbl.setBounds(24, 25, 155, 14);
		AvgPanel.add(lightUsageLbl);

		JLabel TimeLbl = new JLabel("Time (Select)");
		TimeLbl.setBounds(24, 50, 155, 14);
		AvgPanel.add(TimeLbl);

		JSpinner LightLvlSpn = new JSpinner();
		LightLvlSpn.setModel(new SpinnerNumberModel(120.0, 0.0, 3000.0, 60.0));
		LightLvlSpn.setBounds(177, 22, 86, 20);
		AvgPanel.add(LightLvlSpn);

		JLabel avgLbl = new JLabel("Average light level");
		avgLbl.setBounds(24, 114, 114, 14);
		AvgPanel.add(avgLbl);

		JComboBox timeOptions = new JComboBox();
		timeOptions.setBounds(177, 46, 86, 22);
		AvgPanel.add(timeOptions);
		timeOptions.setModel(new DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00",
				"05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00",
				"16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 139, 221, 70);
		AvgPanel.add(scrollPane);

		JTextArea avgTa = new JTextArea();
		avgTa.setPreferredSize(new Dimension(5, 40));
		avgTa.setWrapStyleWord(true);
		avgTa.setFont(new Font("Monospaced", Font.PLAIN, 12));
		avgTa.setLineWrap(true);
		scrollPane.setViewportView(avgTa);
		avgTa.setEditable(false);

		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double lightLvl = (double) LightLvlSpn.getValue();

					String lightTime = (String) timeOptions.getSelectedItem();
					if (lightTime.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Invalid input for time");
					} else if (lightLvl >= 120 && lightLvl <= 3000) {
						timeList.add(lightCount, lightTime);
						lightList.add(lightCount, lightLvl);
						System.out.println("Operation #" + (lightCount+1) + ". Electric usage registered: " + lightLvl + " for the time "
								+ timeOptions.getSelectedItem());
						lightCount++;
						
					} else {
						JOptionPane.showMessageDialog(null, "Invalid input for electric usage. \nIt must be between 120 and 3000");
					}
					
					
				} catch (Exception x) {
					x.printStackTrace();
				}
			}
		});
		submitBtn.setBounds(10, 80, 89, 23);
		AvgPanel.add(submitBtn);

		// Sending the information to the server
		JButton avgBtn = new JButton("Calculate average");
		avgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// averageLighting(stream LightLevel) returns (AverageResponse)
				StreamObserver<AverageResponse> responseObserver = new StreamObserver<AverageResponse>() {

					@Override
					public void onNext(AverageResponse msg) {
						System.out.println(
								LocalTime.now().toString() + ": Response from server: " + msg.getUsageAverage());
						avgTa.setText(msg.getUsageAverage());
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
					}

					@Override
					public void onCompleted() {
						System.out.println(LocalTime.now().toString() + ": Stream is completed.");
					}

				};

				StreamObserver<LightLevel> requestObserver = asyncStub.averageLighting(responseObserver);
				try {
					for (int i = 0; i < lightList.size(); i++) {
						requestObserver.onNext(LightLevel.newBuilder().setElecUsage(lightList.get(i))
								.setCurrentTime(timeList.get(i)).build());
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

		JPanel emergencyPanel = new JPanel();
		emergencyPanel.setBounds(15, 270, 273, 92);
		LightPane.add(emergencyPanel);
		emergencyPanel.setBorder(
				new TitledBorder(null, "Emergency lights", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
				if (onOffInst == 1) {
					onOffInst = 0;
					instruction = onOffInst;
				} else {
					onOffInst = 1;
					instruction = onOffInst;
				}
				LightRequest req = LightRequest.newBuilder().setLightButton(instruction).build();
				StatusResponse resp = LSblockingStub.lightControl(req);

				System.out.println(LocalTime.now().toString() + ": Validation message: " + resp.getLightState());
				lightStateTa.replaceRange(resp.getLightState(), 0, resp.getLightState().length());
			}
		});
		OnOffBtn.setBounds(69, 56, 121, 23);
		emergencyPanel.add(OnOffBtn);

		JPanel SearchPane = new JPanel();
		MenuTab.addTab("Search service", null, SearchPane, null);
		SearchPane.setLayout(null);

		JPanel availabilityPanel = new JPanel();
		availabilityPanel.setBounds(5, 4, 294, 158);
		SearchPane.add(availabilityPanel);
		availabilityPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Book Availability", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		availabilityPanel.setLayout(null);

		JComboBox listByOptions = new JComboBox();
		listByOptions.setBounds(93, 15, 75, 20);
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
				
				/*
				 * SERVER STREAMING 
				 */
				// set up the responseObserver - this is a new object where the client specifies
				// the
				// behaviour to be performed for onNext , onCompleted and onError
				// the responseObserver is passed to the server when the request is made.
				// The server calls onNext() for each response and onComplete() when its
				// finished responding
				// The client is able to observe these events via the responseObserver.
				// note that we are calling the same server side method as for the synchronous
				// call
				// the server behaves the same - the clients reaction to the responses is
				// different - it is
				// asynchronous
				
				booksTa.setText("");
				ListBy requestAsyn;
				ListBy.ListOperation operation;
				operation = (ListOperation) listByOptions.getSelectedItem();

				System.out.println("You selected to list the books by: " + operation);
				requestAsyn = ListBy.newBuilder().setOperation(operation).build();

				StreamObserver<AvailableBooks> responseObserver = new StreamObserver<AvailableBooks>() {

					int count = 0;

					@Override
					public void onNext(AvailableBooks value) {
						switch (operation) {
						case AUTHOR:
							System.out.println(LocalTime.now().toString() + ": receiving book's information.\nAuthor: "
									+ value.getAuthor() + "\nBook ID: " + value.getBookId() + "\nTitle: "
									+ value.getTitle() + "\nLanguage: " + value.getLanguage() + "\nSubject: "
									+ value.getSubject());
							count += 1;
							booksTa.append("Author: " + value.getAuthor() + "\nBook ID: " + value.getBookId()
									+ "\nTitle: " + value.getTitle() + "\nLanguage: " + value.getLanguage()
									+ "\nSubject: " + value.getSubject() + "\nQuantity: " + value.getBookQty()
									+ "\n- - - - - -\n");
							break;
						case ID:
							System.out.println(LocalTime.now().toString() + ": receiving book's information."
									+ "\nBook ID: " + value.getBookId() + "\nAuthor: " + value.getAuthor() + "\nTitle: "
									+ value.getTitle() + "\nLanguage: " + value.getLanguage() + "\nSubject: "
									+ value.getSubject());
							count += 1;
							booksTa.append("Book ID: " + value.getBookId() + "\nTitle: " + value.getTitle()
									+ "\nAuthor: " + value.getAuthor() + "\nLanguage: " + value.getLanguage()
									+ "\nSubject: " + value.getSubject() + "\nQuantity: " + value.getBookQty()
									+ "\n- - - - - -\n");
							break;
						case TITLE:
							System.out.println(LocalTime.now().toString() + ": receiving book's information."
									+ "\nTitle: " + value.getTitle() + "\nBook ID: " + value.getBookId() + "\nAuthor: "
									+ value.getAuthor() + "\nLanguage: " + value.getLanguage() + "\nSubject: "
									+ value.getSubject());
							count += 1;
							booksTa.append("\nTitle: " + value.getTitle() + value.getBookId() + "\nAuthor: "
									+ value.getAuthor() + "\nLanguage: " + value.getLanguage() + "\nSubject: "
									+ value.getSubject() + "\nQuantity: " + value.getBookQty() + "\n- - - - - -\n");
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
						System.out.println(
								LocalTime.now().toString() + ": stream is completed ... received " + count + " books");
					}

				};

				// the client does not have to wait for the server to return - it can just fire
				// off the request and go to sleep.
				// SEasyncStub.availability(request, responseObs);

				SEasyncStub.availability(requestAsyn, responseObserver);
				// the sleep here is optional - its purpose is to slow things down so we can
				// observe what is happening
				try {
					Thread.sleep(15000);
				} catch (InterruptedException ie) {
					// TODO Auto-generated catch block
					ie.printStackTrace();
				} // SERVER STREAMING Nonblocking
			}
		});
		btnListBy.setBounds(178, 13, 89, 23);
		availabilityPanel.add(btnListBy);

		JLabel lblNewLabel = new JLabel("List books by:");
		lblNewLabel.setBounds(10, 18, 89, 14);
		availabilityPanel.add(lblNewLabel);

		JPanel detailsPanel = new JPanel();
		detailsPanel.setBounds(5, 169, 294, 218);
		SearchPane.add(detailsPanel);
		detailsPanel.setBorder(
				new TitledBorder(null, "Visitor details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		detailsPanel.setLayout(null);

		JComboBox userIDopt = new JComboBox();
		userIDopt.setModel(new DefaultComboBoxModel(new String[] { "443325", "493947", "102934", "980661" }));
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
				 * VISITOR SEARCH SERVICE UNARY RPC
				 */

				userID req;
				int userNum = 0;
				String sBwdBooks, sStatus;
				try {
					if (manualID == false) {
						// USERIDs available 443325, 493947, 102934, and 980661
						// userNum = (int) userIDopt.getSelectedItem();

						userNum = Integer.valueOf((String) userIDopt.getSelectedItem());

					} else {
						userNum = Integer.valueOf(userIDinput.getText());

					}

					req = userID.newBuilder().setUserNumber(userNum).build();

					userInformation responseRI = SEblockingStub.readerInfo(req);
					visitorDtlsTa.setText("");
					if (responseRI.getFound()) {
						System.out.println(LocalTime.now().toString() + ": User's information: \nNAME: "
								+ responseRI.getName() + "\nREGISTRATION DATE: " + responseRI.getRegistrationDate()
								+ "\nBORROWED BOOKS: " + responseRI.getBorrowedBooks() + "\nTOTAL BORROWED BOOKS: "
								+ responseRI.getTotalBooksBorrowed() + "\nACTIVE: " + responseRI.getStatus());
						if (responseRI.getBorrowedBooks()) {
							sBwdBooks = "Yes";
						} else {
							sBwdBooks = "No";
						}

						if (responseRI.getStatus()) {
							sStatus = "Active";
						} else {
							sStatus = "Inactive";
						}
						visitorDtlsTa.append("NAME: " + responseRI.getName() + "\nREGISTRATION DATE: "
								+ responseRI.getRegistrationDate() + "\nBORROWED BOOKS: " + sBwdBooks
								+ "\nTOTAL BORROWED BOOKS: " + responseRI.getTotalBooksBorrowed() + "\nSTATUS: "
								+ sStatus);
					} else {
						System.out.println(LocalTime.now().toString() + ": USER NOT FOUND.");
						visitorDtlsTa.append("USER NOT FOUND");
					}
				} catch (NumberFormatException | InputMismatchException inputE) {
					visitorDtlsTa.append("Invalid input");
					System.out.println("Invalid input.");
				}

			}
		});
		useridBtn.setBounds(98, 82, 89, 23);
		detailsPanel.add(useridBtn);

		JPanel RegisterPane = new JPanel();
		RegisterPane.setBackground(UIManager.getColor("Button.background"));
		MenuTab.addTab("Registration service", null, RegisterPane, null);
		RegisterPane.setLayout(null);

		JPanel bkRegisterPanel_1 = new JPanel();
		bkRegisterPanel_1.setBackground(UIManager.getColor("Button.background"));
		bkRegisterPanel_1.setLayout(null);
		bkRegisterPanel_1.setBorder(
				new TitledBorder(null, "Book Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bkRegisterPanel_1.setBounds(5, 11, 297, 251);
		RegisterPane.add(bkRegisterPanel_1);

		JComboBox regTypeOpt = new JComboBox();
		regTypeOpt.setModel(new DefaultComboBoxModel(RegistrationType.values()));
		regTypeOpt.setBounds(65, 23, 80, 22);
		bkRegisterPanel_1.add(regTypeOpt);

		JLabel TypeLbl = new JLabel("Type");
		TypeLbl.setBounds(10, 29, 55, 14);
		bkRegisterPanel_1.add(TypeLbl);

		manualbkID = new JTextField();
		manualbkID.setEditable(false);
		manualbkID.setBounds(150, 80, 85, 20);
		bkRegisterPanel_1.add(manualbkID);
		manualbkID.setColumns(10);

		JLabel bkIDLbl = new JLabel("Book ID");
		bkIDLbl.setBounds(10, 58, 70, 14);
		bkRegisterPanel_1.add(bkIDLbl);

		JComboBox bkIDRegopt = new JComboBox();
		bkIDRegopt.setModel(new DefaultComboBoxModel(
				new String[] { "7836262", "7174668", "8724795", "7660479", "3283121", "1917707", "3924794" }));
		bkIDRegopt.setBounds(65, 54, 80, 22);
		bkRegisterPanel_1.add(bkIDRegopt);

		JCheckBox chckbxEnterBookId = new JCheckBox("Enter other book ID");
		chckbxEnterBookId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (manualbkReg == true) {
					manualbkID.setEditable(false);
					manualbkReg = false;
				} else {
					System.out.println("Enter the book's ID: ");
					manualbkID.setEditable(true);
					manualbkReg = true;
				}
			}
		});
		chckbxEnterBookId.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxEnterBookId.setBounds(4, 79, 141, 23);
		bkRegisterPanel_1.add(chckbxEnterBookId);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 136, 272, 104);
		bkRegisterPanel_1.add(scrollPane_3);

		JTextArea bkRegTa = new JTextArea();
		bkRegTa.setLineWrap(true);
		scrollPane_3.setViewportView(bkRegTa);
		bkRegTa.setEditable(false);

		JLabel bookQtyLbl = new JLabel("Quantity");
		bookQtyLbl.setBounds(155, 55, 55, 14);
		bkRegisterPanel_1.add(bookQtyLbl);

		JLabel visIdLbl = new JLabel("Visitor ID");
		visIdLbl.setBounds(152, 27, 55, 14);
		bkRegisterPanel_1.add(visIdLbl);

		userIdTxt = new JTextField();
		userIdTxt.setBounds(207, 24, 80, 20);
		bkRegisterPanel_1.add(userIdTxt);
		userIdTxt.setColumns(10);

		JSpinner qtySpin = new JSpinner();
		qtySpin.setBounds(207, 52, 30, 20);
		bkRegisterPanel_1.add(qtySpin);
		qtySpin.setModel(new SpinnerNumberModel(1, 1, 10, 1));

		JButton bkRegBtn = new JButton("Register");
		bkRegBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bkRegTa.setText("");
				StreamObserver<BookRegistrationResponse> responseObserver = new StreamObserver<BookRegistrationResponse>() {
					// USERID available 443325, 493947, 102934, and 980661
					int success = 0, totalQty = 0, failed = 0, totalReq = 0;

					@Override
					public void onNext(BookRegistrationResponse value) {
						System.out.println(LocalTime.now().toString() + ": received information\n"
								+ "Type of registration: " + value.getRegType() + "\n" + value.getBookDetails()
								+ "\nQuantity of books registered so far: " + value.getTotalBooks());
						totalReq = value.getComplReg();

						if (value.getReqStatus()) {
							System.out.println("SUCCESS");
							totalQty = value.getTotalBooks();
							success++;
						} else {
							System.out.println("FAILURE");
							failed++;
						}

						bkRegTa.append("Type of registration: " + value.getRegType() + "\n" + value.getUserInfo() + "\n"
								+ value.getBookDetails() + "\n\n");
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();

					}

					@Override
					public void onCompleted() {
						System.out.println(LocalTime.now().toString() + ": stream is completed... Received " + totalReq
								+ " registration requests (Success: " + success + ", Failed: " + failed
								+ "). \nRegistered a total of: " + totalQty + " books.");

					}

				};

				StreamObserver<BookRegistrationRequest> request = RAsyncStub.bookRegister(responseObserver);
				try {
					for (int i = 0; i < regList.size(); i++) {
						request.onNext(BookRegistrationRequest.newBuilder().setBookId(regList.get(i).getBookID())
								.setUserId(regList.get(i).getUserID()).setBookQty(regList.get(i).getBookQty())
								.setTotal(i + 1).setRegistration(regList.get(i).getReg()).build());
					}
					// IDs available 7836262, 7174668, 8724795, 7660479, 3283121, 1917707, 3924794

					request.onCompleted();

					Thread.sleep(7000);
					regList.clear();

				} catch (RuntimeException | InterruptedException ex) {
					ex.printStackTrace();
				}

			}
		});
		bkRegBtn.setBounds(161, 107, 89, 23);
		bkRegisterPanel_1.add(bkRegBtn);

		JButton regSubBtn = new JButton("Submit");
		regSubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int bookID, userID, bookQty, total;
					RegistrationType regT;

					if (manualbkReg) {
						bookID = Integer.valueOf(manualbkID.getText());
					} else {
						bookID = Integer.valueOf((String) bkIDRegopt.getSelectedItem());
					}
					userID = Integer.valueOf(userIdTxt.getText());
					bookQty = (int) qtySpin.getValue();
					regT = (RegistrationType) regTypeOpt.getSelectedItem();

					BookRegistration regBook = new BookRegistration(bookID, userID, bookQty, regT);
					regList.add(regBook);

				} catch (InputMismatchException | NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input");
				}

			}
		});
		regSubBtn.setBounds(38, 107, 89, 23);
		bkRegisterPanel_1.add(regSubBtn);
		regSubBtn.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Visitor registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 273, 297, 111);
		RegisterPane.add(panel);
		panel.setLayout(null);

		JLabel usrNameLbl = new JLabel("Name");
		usrNameLbl.setBounds(10, 21, 62, 14);
		panel.add(usrNameLbl);

		JLabel idLbl = new JLabel("ID");
		idLbl.setBounds(10, 47, 46, 14);
		panel.add(idLbl);

		visitrNmTxt = new JTextField();
		visitrNmTxt.setBounds(50, 18, 86, 20);
		panel.add(visitrNmTxt);
		visitrNmTxt.setColumns(10);

		visitrIDTxt = new JTextField();
		visitrIDTxt.setBounds(50, 45, 86, 20);
		panel.add(visitrIDTxt);
		visitrIDTxt.setColumns(10);

		JScrollPane visitorRegScrll = new JScrollPane();
		visitorRegScrll.setBounds(146, 13, 141, 88);
		panel.add(visitorRegScrll);

		JTextArea visitorRegTa = new JTextArea();
		visitorRegTa.setEditable(false);
		visitorRegTa.setWrapStyleWord(true);
		visitorRegTa.setLineWrap(true);
		visitorRegScrll.setViewportView(visitorRegTa);

		JButton visitrBtn = new JButton("Register");
		visitrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int visitorID;
					String visitorName;
					boolean valInput = true;

					visitorID = Integer.valueOf(visitrIDTxt.getText());
					visitorName = visitrNmTxt.getText();
					for (int i = 0; i < visitorName.length(); i++) {
						if (!Character.isLetter(visitorName.charAt(i)) && visitorName.charAt(i) != ' ') {
							valInput = false;
						}
					}

					if (valInput == true) {

						VisitorRegistrationRequest req = VisitorRegistrationRequest.newBuilder().setVisitorId(visitorID)
								.setName(visitorName).setStatus("Active").build();

						VisitorRegistrationResponse response = RblockingStub.visitorRegister(req);

						System.out.println(LocalTime.now().toString() + ": receiving message: "
								+ response.getRegistrationConfirmation() + " on the date "
								+ response.getRegistrationDate());
						visitorRegTa.setText("Date: " + response.getRegistrationDate() + "\n"
								+ response.getRegistrationConfirmation());
					} else {
						JOptionPane.showMessageDialog(null, "Invalid input for Name.");
					}

				} catch (InputMismatchException | NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input for user ID.");
				}

			}
		});
		visitrBtn.setBounds(30, 71, 89, 23);
		panel.add(visitrBtn);
		

	}// Library GUI
}
