package grpc.cadanielMeetingRoomBookingSystem;

import java.io.IOException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.cadanielMeetingRoomBookingSystem.CheckRoomServiceGrpc.CheckRoomServiceImplBase;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class CheckRoomService extends CheckRoomServiceImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        CheckRoomService checkRoomService = new CheckRoomService();

        int port = 50051;

        Server server = ServerBuilder.forPort(port)
            .addService(checkRoomService)
            .build()
            .start();

        // Register the service with jmDNS
        registerServiceWithJmDNS("CheckRoomService", port);

        System.out.println("Service Check Room started, listening on " + port);

        server.awaitTermination();
    }

    private static void registerServiceWithJmDNS(String serviceName, int port) throws IOException {
        JmDNS jmdns = JmDNS.create();
        String type = "_grpc._tcp.local."; // This type can be customized
        String name = serviceName; // Service name
        String description = "gRPC service for checking room availability";
        
        // Service info to be registered
        ServiceInfo serviceInfo = ServiceInfo.create(type, name, description, port, "null");
        jmdns.registerService(serviceInfo);
        
        System.out.println("Service registered via jmdns: " + serviceName);
    }

    @Override
    public void checkRoomAvailability(RoomAvailabilityRequest request, StreamObserver<RoomAvailabilityResponse> responseObserver) {
        Metadata metadata = new Metadata();
        String authToken = "my_secure_token_checkRoom";
        metadata.get(Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER));
        
        if (!"my_secure_token_checkRoom".equals(authToken)) {
            responseObserver.onError(Status.UNAUTHENTICATED.withDescription("Invalid auth token").asRuntimeException());
            return;
        }

        try {
            String roomNumber = request.getRoomNumber();
            boolean isRoomAvailable = checkRoomAvailabilityMethod(roomNumber);
            RoomAvailabilityResponse reply = RoomAvailabilityResponse.newBuilder().setAvailable(isRoomAvailable).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (NumberFormatException e) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("Invalid room number format.").asRuntimeException());
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL.withDescription("An internal error occurred.").asRuntimeException());
        }
    }

    private boolean checkRoomAvailabilityMethod(String roomNumber) {
        int[] rooms = {1, 3, 5};
        for (int room : rooms) {
            if (room == Integer.parseInt(roomNumber)) {
                return true;
            }
        }
        return false;
    }
}