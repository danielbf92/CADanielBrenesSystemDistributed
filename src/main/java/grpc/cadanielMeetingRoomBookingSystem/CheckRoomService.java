package grpc.cadanielMeetingRoomBookingSystem;

import java.io.IOException;

import grpc.cadanielMeetingRoomBookingSystem.CheckRoomServiceGrpc.CheckRoomServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CheckRoomService extends CheckRoomServiceImplBase{
    public static void main(String[] args) throws InterruptedException, IOException{
        CheckRoomService checkRoomService = new CheckRoomService();

        int port = 50051;

        Server server = ServerBuilder.forPort(port)
            .addService(checkRoomService)
            .build()
            .start();

        System.out.println("Service Check Room started, listening on " + port);

		server.awaitTermination();
    }

    @Override
	public void checkRoomAvailability(RoomAvailabilityRequest request, StreamObserver<RoomAvailabilityResponse> responseObserver) {

		//prepare the value to be set back
        String roomNumber = request.getRoomNumber();

        boolean isRoomAvailable = checkRoomAvailabilityMethod(roomNumber);
		
		//preparing the response message
		RoomAvailabilityResponse reply = RoomAvailabilityResponse.newBuilder().setAvailable(isRoomAvailable).build();

		responseObserver.onNext( reply ); 

		responseObserver.onCompleted();

	}

    //Method to check room availability based on roomNumber
    private boolean checkRoomAvailabilityMethod(String roomNumber) {
        
        int [] rooms = {1, 3, 5};
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i] == Integer.parseInt(roomNumber)) {
                return true; 
            } 
        } return false;
}
}
