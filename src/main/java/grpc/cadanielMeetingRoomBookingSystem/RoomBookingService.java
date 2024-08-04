package grpc.cadanielMeetingRoomBookingSystem;

import java.io.IOException;

import grpc.cadanielMeetingRoomBookingSystem.RoomBookingServiceGrpc.RoomBookingServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RoomBookingService extends RoomBookingServiceImplBase{
    public static void main(String[] args) throws InterruptedException, IOException{
        RoomBookingService RoomBookingService = new RoomBookingService();

        int port = 50052;

        Server server = ServerBuilder.forPort(port)
            .addService(RoomBookingService)
            .build()
            .start();

        System.out.println("Service Check Room started, listening on " + port);

		server.awaitTermination();
    }

    @Override
    public StreamObserver<RoomBookingRequest> bookRoom(StreamObserver<RoomBookingResponse> responseObserver) {
        // Return a new StreamObserver to handle incoming RoomBookingRequest messages.
        return new StreamObserver<RoomBookingRequest>() {
            @Override
            public void onNext(RoomBookingRequest request) {
                // Process each RoomBookingRequest
                String confirmationMessage = "Room booked on " + request.getDate() + " at " + request.getTime() + " for " + request.getDuration() + " with requirements: " + request.getRequirements();

                // Create a response with the confirmation message
                RoomBookingResponse response = RoomBookingResponse.newBuilder()
                        .setConfirmation(confirmationMessage)
                        .build();

                // Send the response back to the client
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                // Handle error scenario
                System.err.println("Error in booking room: " + t.getMessage());
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                // Complete the stream of responses when all requests are processed
                responseObserver.onCompleted();
            }
        };
    }

   
}
