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

import grpc.cadanielMeetingRoomBookingSystem.CheckRoomServiceGrpc;
import grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest;
import grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class ControllerGUI implements ActionListener{

    private JTextField entry1, reply1;

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
		
		} else {

        }
    }

}