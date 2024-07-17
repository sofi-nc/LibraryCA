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

public class LibraryGUI extends JFrame {

	int barCount, lightCount=0, calcAvg=0;
	ArrayList<Integer> lightList = new ArrayList<Integer>();
	ArrayList<String> timeList = new ArrayList<String>();
	
	int onOffInst = 0;
	
	//ListBy request;
	//ListBy.ListOperation operation;
	
	private static LightServiceBlockingStub LSblockingStub;
	private static LightServiceStub asyncStub;
	public static SearchEngineStub SEasyncStub;
	private static SearchEngineBlockingStub SEblockingStub;
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		LightLevelLbl.setBounds(24, 25, 114, 14);
		AvgPanel.add(LightLevelLbl);
		
		JLabel TimeLbl = new JLabel("Time (Select)");
		TimeLbl.setBounds(24, 50, 93, 14);
		AvgPanel.add(TimeLbl);
		
		JSpinner LightLvlSpn = new JSpinner();
		LightLvlSpn.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		LightLvlSpn.setBounds(141, 22, 86, 20);
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
		timeOptions.setBounds(141, 46, 86, 22);
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
				if(lightLvl>= 0 && lightLvl<=100) {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Book Availability", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(293, 11, 294, 158);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox listByOptions = new JComboBox();
		listByOptions.setBounds(93, 12, 75, 20);
		listByOptions.setModel(new DefaultComboBoxModel(ListOperation.values()));
		panel_1.add(listByOptions);
		
		JButton btnListBy = new JButton("Submit");
		btnListBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListBy requestAsyn;
				ListBy.ListOperation operation = ListBy.ListOperation.AUTHOR;
				//operation = (ListOperation) listByOptions.getSelectedItem();
				System.out.println("You selected to list the books by: " + operation);
				requestAsyn = ListBy.newBuilder().setOperation(operation).build();
				
				/*
				 * SERVER STREAMING (BLOCKING)
				 */
			/*	ListBy listingReq = ListBy.newBuilder().setOperation(operation).build();
				try {
				Iterator<AvailableBooks> responses = SEblockingStub.availability(listingReq);
				
				while(responses.hasNext()) {
					AvailableBooks bk = responses.next();
					System.out.println(bk.getAuthor());
				}
			} catch (StatusRuntimeException ie) {
				ie.printStackTrace();
			} */
				
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
						System.out.println(LocalTime.now().toString() + ": receiving book's information.\nBook ID: " + value.getBookId() + "\nTitle: " + value.getTitle() + "\nAuthor: " + value.getAuthor() + "\nLanguage: " + value.getLanguage() + "\nSubject: " + value.getSubject());
						count += 1;
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
		panel_1.add(btnListBy);
		
		JLabel lblNewLabel = new JLabel("List books by:");
		lblNewLabel.setBounds(10, 15, 89, 14);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 40, 274, 107);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Visitor details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(293, 180, 294, 116);
		contentPane.add(panel);
		
		
		
	}//Library GUI
}
