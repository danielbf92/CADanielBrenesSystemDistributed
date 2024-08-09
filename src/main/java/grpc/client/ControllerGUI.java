package grpc.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

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
import grpc.cadanielSecuritySystem.CamaraServiceGrpc;
import grpc.cadanielSecuritySystem.CheckCamaraRequest;
import grpc.cadanielSecuritySystem.CheckCamaraResponse;
import grpc.cadanielSecuritySystem.CheckDoorsRequest;
import grpc.cadanielSecuritySystem.CheckDoorsResponse;
import grpc.cadanielSecuritySystem.LockUnlockDoorsGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


public class ControllerGUI implements ActionListener{

    private JTextField entryRoom, replyRoom;
	private JTextField entryDoor, replyDoor;
	private JTextField entryLight, replyLight;
	private JTextField entryDate, entryTime, entryDuration, entryReq, replyBooking;
	private JTextField entryCamaraID, replyCamara;
	private JTextField entryBrightnessLevel, entryLocation, replyBrightness;

    private JPanel getService1JPanel() {

		JPanel panel = new JPanel(new GridBagLayout());
		TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Check Room Service Unary");
		// Set the title color
		titleBorder.setTitleColor(Color.BLUE);
		// Set the border to the panel
		panel.setBorder(titleBorder);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add space between components
        gbc.anchor = GridBagConstraints.WEST; // Align to the left
		
		JLabel label = new JLabel("Enter number of room between 1 to 5")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));
		entryRoom = new JTextField("",20);
		panel.add(entryRoom);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));

		JButton button = new JButton("CheckRoomService");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(20, 0)));

		replyRoom = new JTextField("", 20);
		replyRoom .setEditable(false);
		panel.add(replyRoom );

		//panel.setLayout(boxlayout);

		return panel;

	}

	private JPanel getService2JPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Room Booking Service Client Streaming");
		// Set the title color
		titleBorder.setTitleColor(Color.RED);
		// Set the border to the panel
		panel.setBorder(titleBorder);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add space between components
        gbc.anchor = GridBagConstraints.WEST; // Align to the left
		
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
	
		replyBooking = new JTextField("", 10);
		replyBooking.setEditable(false);
		panel.add(replyBooking);
	
		//panel.setLayout(boxlayout);
		return panel;
	}

	private JPanel getService3JPanel() {

		JPanel panel = new JPanel(new GridBagLayout());
		TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Check Lights Service Unary");
		// Set the title color
		titleBorder.setTitleColor(Color.CYAN);
		// Set the border to the panel
		panel.setBorder(titleBorder);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add space between components
        gbc.anchor = GridBagConstraints.WEST; // Align to the left

		// Configure brightness level label and input
        JLabel LightsLevel = new JLabel("Enter number of room between 1 to 5 and see if the lights are ON - OFF");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(LightsLevel, gbc);

		entryLight = new JTextField(10);
        gbc.gridx = 1;
        panel.add(entryLight, gbc);

		// Configure button
        JButton button = new JButton("CheckLightsService");
        button.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Make button span two columns
        panel.add(button, gbc);

		// Configure reply field
        replyLight = new JTextField(20);
        replyLight.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(replyLight, gbc);

		return panel;

	}

	private JPanel getService4JPanel() {

		JPanel panel = new JPanel(new GridBagLayout());
		TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Check Doors Service Unary");
		// Set the title color
		titleBorder.setTitleColor(Color.ORANGE);
		// Set the border to the panel
		panel.setBorder(titleBorder);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add space between components
        gbc.anchor = GridBagConstraints.WEST; // Align to the left

		// Configure brightness level label and input
        JLabel DoorsLevel = new JLabel("Enter number of room between 1 to 5 and see if the doors are UnLock - Lock");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(DoorsLevel, gbc);
        
        entryDoor = new JTextField(10);
        gbc.gridx = 1;
        panel.add(entryDoor, gbc);

		// Configure button
        JButton button = new JButton("CheckDoorsService");
        button.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Make button span two columns
        panel.add(button, gbc);

		// Configure reply field
        replyDoor = new JTextField(20);
        replyDoor.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(replyDoor, gbc);

        return panel;
	}
	private JPanel getService5JPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Adjust Brightness Service Bi Directional");
		// Set the title color
		titleBorder.setTitleColor(Color.BLACK);
		// Set the border to the panel
		panel.setBorder(titleBorder);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add space between components
        gbc.anchor = GridBagConstraints.WEST; // Align to the left

        // Configure brightness level label and input
        JLabel brightnessLevel = new JLabel("Enter brightness level (0-100) or -1 to exit:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(brightnessLevel, gbc);
        
        entryBrightnessLevel = new JTextField(10);
        gbc.gridx = 1;
        panel.add(entryBrightnessLevel, gbc);

        // Configure location label and input
        JLabel locationlabel = new JLabel("Enter Location:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(locationlabel, gbc);
        
        entryLocation = new JTextField(10);
        gbc.gridx = 1;
        panel.add(entryLocation, gbc);

        // Configure button
        JButton button = new JButton("AdjustBrightnessService");
        button.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Make button span two columns
        panel.add(button, gbc);

        // Configure reply field
        replyBrightness = new JTextField(20);
        replyBrightness.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(replyBrightness, gbc);

        return panel;
	}

	private JPanel getService6JPanel() {
		JPanel panel = new JPanel(new GridBagLayout());
		TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Camara Service Server Streaming");
		// Set the title color
		titleBorder.setTitleColor(Color.YELLOW);
		// Set the border to the panel
		panel.setBorder(titleBorder);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add space between components
        gbc.anchor = GridBagConstraints.WEST; // Align to the left

        // Configure camera ID label and input
        JLabel cameraIDLabel = new JLabel("Enter camera ID:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(cameraIDLabel, gbc);
        
        entryCamaraID = new JTextField(10);
        gbc.gridx = 1;
        panel.add(entryCamaraID, gbc);

        // Configure camera service button
        JButton button = new JButton("CamaraService");
        button.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Make button span two columns
        panel.add(button, gbc);

        // Configure reply field
        replyCamara = new JTextField(20);
        replyCamara.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(replyCamara, gbc);

        return panel;
	}

    public static void main(String[] args) {

		ControllerGUI gui = new ControllerGUI();

		gui.build();
	}

    private void build() { 

		JFrame frame = new JFrame("CA Daniel B - Device Office Smart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with vertical BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // margin for main panel

        mainPanel.add(getService1JPanel());
        mainPanel.add(getService2JPanel());
		mainPanel.add( getService3JPanel() );
		mainPanel.add( getService4JPanel() );
		mainPanel.add( getService5JPanel() );
		mainPanel.add( getService6JPanel() );

		//Create the message label 
		JLabel messageLabel = new JLabel("Please check the command line as well as a results");
		messageLabel.setFont(new Font("Arial", Font.BOLD, 14)); 
		messageLabel.setForeground(Color.RED); 
		messageLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		// Add the message label to the bottom of the main panel  
		mainPanel.add(Box.createVerticalGlue());  
		mainPanel.add(messageLabel);

		// Set the window to be visible as the default to be false
		frame.add(mainPanel);
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

			CheckRoomServiceGrpc.CheckRoomServiceBlockingStub stub = CheckRoomServiceGrpc.newBlockingStub(channel);

            String userInput = entryRoom.getText();

            RoomAvailabilityRequest request = RoomAvailabilityRequest.newBuilder().setRoomNumber(userInput).build();

            try {
				RoomAvailabilityResponse response = stub.checkRoomAvailability(request);
				// Check if the room is available or not  
				if (response.getAvailable()) {
					replyRoom.setText("Room " + userInput + " is available");
				} else {
					replyRoom.setText("Room " + userInput + " is not available");
				}
			} catch (StatusRuntimeException error) {
				// Handle the specific error messages returned from the server  
				replyRoom.setText("Error: " + error.getStatus().getDescription());
			}
		
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
					SwingUtilities.invokeLater(() -> replyBooking.setText("Latest: " + response.getConfirmation()));
				}
	
				@Override  
				public void onError(Throwable t) {
					System.err.println("Error from server: " + t.getMessage());
				}
	
				@Override  
				public void onCompleted() {
					System.out.println("All bookings processed.");
					SwingUtilities.invokeLater(() -> replyBooking.setText("Client Streaming completed."));
					channel.shutdown();
				}
			};

			// Initiate the stream  
        	StreamObserver<RoomBookingRequest> requestObserver = Stub.bookRoom(responseObserver);

			String date = entryDate.getText();
			String time = entryTime.getText();
			String duration = entryDuration.getText();
			String requirements = entryReq.getText();
			
			//preparing message to send
			requestObserver.onNext(RoomBookingRequest.newBuilder()
											.setDate(date)
											.setTime(time)
											.setDuration(duration)
											.setRequirements(requirements).build());

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

            String userInput = entryLight.getText();

            CheckLightsRequest request = CheckLightsRequest.newBuilder().setRoomNumber(userInput).build();
			try {
				CheckLightsResponse response = stub.checkLights(request);

				// Check if the room is available or not
				if (response.getAvailable()) {
					replyLight.setText("Room " + userInput + " is with the lights ON");
				} else {
					replyLight.setText("Room " + userInput + " is with the lights OFF");
				}
			} catch (StatusRuntimeException error){
				// Handle the specific error messages returned from the server  
				replyLight.setText("Error: " + error.getStatus().getDescription());
			}
		} else if (label.equals("CheckDoorsService")) {
			System.out.println("CheckLightsService to be called ...");

		
			/*
			 * 
			 */
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();

			LockUnlockDoorsGrpc.LockUnlockDoorsBlockingStub stub = LockUnlockDoorsGrpc.newBlockingStub(channel);

            String userInput = entryDoor.getText();

            CheckDoorsRequest request = CheckDoorsRequest.newBuilder().setRoomNumber(userInput).build();
			try {
            	CheckDoorsResponse response = stub.checkDoors(request);

				// Check if the room is available or not
				if (response.getAvailable()) {
					replyDoor.setText("Room " + userInput + " is with the Doors Unlock");
				} else {
					replyDoor.setText("Room " + userInput + " is with the Doors Lock");
				}
			} catch (StatusRuntimeException error){
				// Handle the specific error messages returned from the server  
				replyDoor.setText("Error: " + error.getStatus().getDescription());
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
					SwingUtilities.invokeLater(() -> replyBrightness.setText("Latest: " + response.getMessage()));
				}
	
				@Override  
				public void onError(Throwable t) {
					System.err.println("Error from server: " + t.getMessage());
					SwingUtilities.invokeLater(() -> replyBrightness.setText("Error: " + t.getMessage()));
				}
	
				@Override  
				public void onCompleted() {
					System.out.println("Server finished processing.");
					SwingUtilities.invokeLater(() -> replyBrightness.setText("Bi Directional Streaming completed."));
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
		} else if (label.equals("CamaraService")) {
			System.out.println("CamaraService to be invoked ...");

			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50056).usePlaintext().build();
			CamaraServiceGrpc.CamaraServiceStub stub = CamaraServiceGrpc.newStub(channel);

			// Prepare the StreamObserver for the response  
			StreamObserver<CheckCamaraResponse> responseObserver = new StreamObserver<CheckCamaraResponse>() {
				@Override  
				public void onNext(CheckCamaraResponse response) {
					System.out.printf("Received data from Camera %s: %s%n", response.getCamaraId(), response.getData());
					// Update the reply text field with the latest data
					SwingUtilities.invokeLater(() -> replyCamara.setText("Latest: " + response.getData()));
				}

				@Override  
				public void onError(Throwable t) {
					System.err.println("Error from server: " + t.getMessage());
					// Update the reply text field with the error
					SwingUtilities.invokeLater(() -> replyCamara.setText("Error: " + t.getMessage()));
				}

				@Override  
				public void onCompleted() {
					System.out.println("All camaras processed.");
					SwingUtilities.invokeLater(() -> replyCamara.setText("Server Streaming completed."));
				}
			};

			// Create and send the request with the camera ID
			String cameraId = entryCamaraID.getText().trim();
			CheckCamaraRequest request = CheckCamaraRequest.newBuilder()
															.setCamaraId(cameraId)
															.build();

			// Invoke the streaming method
			stub.checkCamara(request, responseObserver);
		}
    }

}