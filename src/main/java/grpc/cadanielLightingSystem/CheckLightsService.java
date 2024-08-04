package grpc.cadanielLightingSystem;

import java.io.IOException;

import grpc.cadanielLightingSystem.TurnOnOffLightsGrpc.TurnOnOffLightsImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CheckLightsService extends TurnOnOffLightsImplBase{
    public static void main(String[] args) throws InterruptedException, IOException{
        CheckLightsService checkRoomService = new CheckLightsService();

        int port = 50053;

        Server server = ServerBuilder.forPort(port)
            .addService(checkRoomService)
            .build()
            .start();

        System.out.println("Service Check Room started, listening on " + port);

		server.awaitTermination();
    }

    @Override
	public void checkLights(CheckLightsRequest request, StreamObserver<CheckLightsResponse> responseObserver) {

		//prepare the value to be set back
        String roomNumber = request.getRoomNumber();

        boolean isRoomAvailable = checkLightsMethod(roomNumber);
		
		//preparing the response message
		CheckLightsResponse reply = CheckLightsResponse.newBuilder().setAvailable(isRoomAvailable).build();

		responseObserver.onNext( reply ); 

		responseObserver.onCompleted();

	}

    //Method to check room availability based on roomNumber
    private boolean checkLightsMethod(String roomNumber) {
        
        int [] rooms = {2, 4};
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i] == Integer.parseInt(roomNumber)) {
                return true; 
            } 
        } return false;
}
}
