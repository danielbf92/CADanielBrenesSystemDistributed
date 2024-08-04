package grpc.cadanielSecuritySystem;

import java.io.IOException;

import grpc.cadanielSecuritySystem.LockUnlockDoorsGrpc.LockUnlockDoorsImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CheckDoorsService extends LockUnlockDoorsImplBase{
    public static void main(String[] args) throws InterruptedException, IOException{
        CheckDoorsService checkDoorsService = new CheckDoorsService();

        int port = 50054;

        Server server = ServerBuilder.forPort(port)
            .addService(checkDoorsService)
            .build()
            .start();

        System.out.println("Service Check Doors started, listening on " + port);

		server.awaitTermination();
    }

    @Override
	public void checkDoors(CheckDoorsRequest request, StreamObserver<CheckDoorsResponse> responseObserver) {

		//prepare the value to be set back
        String roomNumber = request.getRoomNumber();

        boolean isRoomAvailable = checkDoorsMethod(roomNumber);
		
		//preparing the response message
		CheckDoorsResponse reply = CheckDoorsResponse.newBuilder().setAvailable(isRoomAvailable).build();

		responseObserver.onNext( reply ); 

		responseObserver.onCompleted();

	}

    //Method to check room availability based on roomNumber
    private boolean checkDoorsMethod(String roomNumber) {
        
        int [] rooms = {1, 5};
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i] == Integer.parseInt(roomNumber)) {
                return true; 
            } 
        } return false;
}
}
