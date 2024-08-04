package grpc.client;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import grpc.cadanielLightingSystem.BrightnessRequest;
import grpc.cadanielLightingSystem.BrightnessResponse;
import grpc.cadanielLightingSystem.BrightnessServiceGrpc;
import grpc.cadanielLightingSystem.CheckLightsRequest;
import grpc.cadanielLightingSystem.CheckLightsResponse;
import grpc.cadanielLightingSystem.TurnOnOffLightsGrpc;
import grpc.cadanielMeetingRoomBookingSystem.CheckRoomServiceGrpc;
import grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest;
import grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse;
import grpc.cadanielMeetingRoomBookingSystem.RoomBookingRequest;
import grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse;
import grpc.cadanielMeetingRoomBookingSystem.RoomBookingServiceGrpc;
import grpc.cadanielSecuritySystem.CheckDoorsRequest;
import grpc.cadanielSecuritySystem.CheckDoorsResponse;
import grpc.cadanielSecuritySystem.LockUnlockDoorsGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class ControllerGUI implements ActionListener{

    private JTextField entry1, reply1;
	private JTextField entryDate, entryTime, entryDuration, entryReq, reply2;
	private JTextField entry3, reply3;
	private JTextField entry4, reply4;
	private JTextField entryBrightnessLevel, entryLocation, reply5;

    private JPanel getService1JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter number of room between 1 to 5")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));
		entry1 = new JTextField("",20);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));

		JButton button = new JButton("CheckRoomService");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));

		reply1 = new JTextField("", 20);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getService2JPanel() {
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
		
		// Add labels and text fields
		JLabel datelabel = new JLabel("Enter date you would like to book: (MM-DD-YYYY)");
		panel.add(datelabel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		entryDate = new JTextField("", 10);
		panel.add(entryDate); // Add entryTime TEXTFIELD
	
		JLabel timelabel = new JLabel("Enter a time (14:00)");
		panel.add(timelabel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		entryTime = new JTextField("", 10);
		panel.add(entryTime); // Add entryTime TEXTFIELD
	
		JLabel durationlabel = new JLabel("Enter a duration (1 hour)");
		panel.add(durationlabel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		entryDuration = new JTextField("", 10);
		panel.add(entryDuration); // Add entryDuration TEXTFIELD
	
		JLabel reqlabel = new JLabel("Enter a requirements (Whiteboard)");
		panel.add(reqlabel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		entryReq = new JTextField("", 10);
		panel.add(entryReq); // Add entryReq TEXTFIELD
	
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
	
		JButton button = new JButton("RoomBooking");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
	
		reply2 = new JTextField("", 10);
		reply2.setEditable(false);
		panel.add(reply2);
	
		panel.setLayout(boxlayout);
		return panel;
	}

	private JPanel getService3JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter number of room between 1 to 5 and see if the lights are ON - OFF")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));
		entry1 = new JTextField("",20);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));

		JButton button = new JButton("CheckLightsService");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));

		reply1 = new JTextField("", 20);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getService4JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter number of room between 1 to 5 and see if the doors are UnLock - Lock")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));
		entry1 = new JTextField("",20);
		panel.add(entry1);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));

		JButton button = new JButton("CheckDoorsService");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));

		reply1 = new JTextField("", 20);
		reply1 .setEditable(false);
		panel.add(reply1 );

		panel.setLayout(boxlayout);

		return panel;

	}
	private JPanel getService5JPanel() {
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
		
		// Add labels and text fields
		JLabel brightnessLevel = new JLabel("Enter brightness level (0-100) or -1 to exit:");
		panel.add(brightnessLevel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		entryBrightnessLevel = new JTextField("", 10);
		panel.add(entryBrightnessLevel); // Add entryTime TEXTFIELD
	
		JLabel locationlabel = new JLabel("Enter Location");
		panel.add(locationlabel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		entryLocation = new JTextField("", 10);
		panel.add(entryLocation); // Add entryTime TEXTFIELD
	
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
	
		JButton button = new JButton("AdjustBrightnessService");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
	
		reply5 = new JTextField("", 10);
		reply5.setEditable(false);
		panel.add(reply5);
	
		panel.setLayout(boxlayout);
		return panel;
	}

    public static void main(String[] args) {

		ControllerGUI gui = new ControllerGUI();

		gui.build();
	}

    private void build() { 

		JFrame frame = new JFrame("CA Daniel B - Device office smarted");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getService1JPanel() );
		panel.add( getService2JPanel() );
		panel.add( getService3JPanel() );
		panel.add( getService4JPanel() );
		panel.add( getService5JPanel() );

        // Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

    @Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  

		if (label.equals("CheckRoomService")) {
			System.out.println("CheckRoomService to be called ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			CheckRoomServiceGrpc.CheckRoomServiceBlockingStub blockingStub = CheckRoomServiceGrpc.newBlockingStub(channel);

			CheckRoomServiceGrpc.CheckRoomServiceBlockingStub stub = CheckRoomServiceGrpc.newBlockingStub(channel);

            String userInput = entry1.getText();

            RoomAvailabilityRequest request = RoomAvailabilityRequest.newBuilder().setRoomNumber(userInput).build();

            RoomAvailabilityResponse response = stub.checkRoomAvailability(request);

            // Check if the room is available or not
            if (response.getAvailable()) {
                reply1.setText("Room " + userInput + " is available");
            } else {
                reply1.setText("Room " + userInput + " is not available");
            }

            //reply1.setText(String.valueOf(response.getAvailable()));
		
		} else if (label.equals("RoomBooking")) {
			System.out.println("RoomBooking to be invoked ...");

		
			/*
			 * 
			 */

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			RoomBookingServiceGrpc.RoomBookingServiceStub Stub = RoomBookingServiceGrpc.newStub(channel);

			// Prepare the StreamObserver for the response  
			StreamObserver<RoomBookingResponse> responseObserver = new StreamObserver<RoomBookingResponse>() {
				@Override  
				public void onNext(RoomBookingResponse response) {
					System.out.println("Server response: " + response.getConfirmation());
				}
	
				@Override  
				public void onError(Throwable t) {
					System.err.println("Error from server: " + t.getMessage());
				}
	
				@Override  
				public void onCompleted() {
					System.out.println("All bookings processed.");
				}
			};

			// Initiate the stream  
        	StreamObserver<RoomBookingRequest> requestObserver = Stub.bookRoom(responseObserver);

			String userInput1 = entryDate.getText();
			String userInput2 = entryTime.getText();
			String userInput3 = entryDuration.getText();
			String userInput4 = entryReq.getText();
			
			//preparing message to send
			requestObserver.onNext(RoomBookingRequest.newBuilder()
											.setDate(userInput1)
											.setTime(userInput2)
											.setDuration(userInput3)
											.setRequirements(userInput4).build());

			//retreving reply from service
			// Signal that we are done sending requests  
            requestObserver.onCompleted();
        } else if (label.equals("CheckLightsService")) {
			System.out.println("CheckLightsService to be called ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

			TurnOnOffLightsGrpc.TurnOnOffLightsBlockingStub stub = TurnOnOffLightsGrpc.newBlockingStub(channel);

            String userInput = entry1.getText();

            CheckLightsRequest request = CheckLightsRequest.newBuilder().setRoomNumber(userInput).build();

            CheckLightsResponse response = stub.checkLights(request);

            // Check if the room is available or not
            if (response.getAvailable()) {
                reply1.setText("Room " + userInput + " is with the lights ON");
            } else {
                reply1.setText("Room " + userInput + " is with the lights OFF");
            }
		} else if (label.equals("CheckDoorsService")) {
			System.out.println("CheckLightsService to be called ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();

			LockUnlockDoorsGrpc.LockUnlockDoorsBlockingStub stub = LockUnlockDoorsGrpc.newBlockingStub(channel);

            String userInput = entry1.getText();

            CheckDoorsRequest request = CheckDoorsRequest.newBuilder().setRoomNumber(userInput).build();

            CheckDoorsResponse response = stub.checkDoors(request);

            // Check if the room is available or not
            if (response.getAvailable()) {
                reply1.setText("Room " + userInput + " is with the Doors Unlock");
            } else {
                reply1.setText("Room " + userInput + " is with the Doors Lock");
            }
		} else if (label.equals("AdjustBrightnessService")) {
			System.out.println("AdjustBrightnessService to be invoked ...");

		
			/*
			 * 
			 */

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055).usePlaintext().build();
			BrightnessServiceGrpc.BrightnessServiceStub Stub = BrightnessServiceGrpc.newStub(channel);

			// Prepare the StreamObserver for the response  
			StreamObserver<BrightnessResponse> responseObserver = new StreamObserver<BrightnessResponse>() {
				@Override  
				public void onNext(BrightnessResponse response) {
					System.out.println("Server response: " + response.getMessage());
				}
	
				@Override  
				public void onError(Throwable t) {
					System.err.println("Error from server: " + t.getMessage());
				}
	
				@Override  
				public void onCompleted() {
					System.out.println("Server finished processing.");
				}
			};

			// Initiate the stream  
        	StreamObserver<BrightnessRequest> requestObserver = Stub.adjustBrightness(responseObserver);
			try {
				for (int i = 0; i < 20; i++) {
					String brightnessText = entryBrightnessLevel.getText();
					String locationText = entryLocation.getText();
	
					// Validate user input
					int userInput1;
					try {
						userInput1 = Integer.parseInt(brightnessText);
						if (userInput1 == -1) break; // Exit if -1 is entered
						if (userInput1 < 0 || userInput1 > 100) {
							System.out.println("Brightness level must be between 0 and 100.");
							continue; // Skip this iteration
						}
					} catch (NumberFormatException exception) {
						System.out.println("Invalid brightness level. Please enter a number.");
						continue; // Skip this iteration
					}
	
					if (locationText == null || locationText.isEmpty()) {
						System.out.println("Location cannot be empty.");
						continue; // Skip this iteration
					}
	
					// Preparing message to send
					BrightnessRequest request = BrightnessRequest.newBuilder()
							.setBrightnessLevel(userInput1)
							.setLocation(locationText).build();
	
					requestObserver.onNext(request);
					Thread.sleep(100); // Simulating a delay
				}
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt(); // Restore the interrupted status
			} finally {
				requestObserver.onCompleted();
				channel.shutdown();
			}
		}
    }

}