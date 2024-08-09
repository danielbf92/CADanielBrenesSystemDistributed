package grpc.cadanielMeetingRoomBookingSystem;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.cadanielMeetingRoomBookingSystem.RoomBookingServiceGrpc.RoomBookingServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class RoomBookingService extends RoomBookingServiceImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        RoomBookingService roomBookingService = new RoomBookingService();

        int port = 50052;

        Server server = ServerBuilder.forPort(port)
            .addService(roomBookingService)
            .build()
            .start();

        System.out.println("Room Booking Service started, listening on " + port);

        // Register the service with jmDNS  
        registerService(port);

        server.awaitTermination();
    }

    private static void registerService(int port) {
        try {
            // Create a JmDNS instance  
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Define service name, type, and description  
            String serviceName = "RoomBookingService";
            String serviceType = "_grpc._tcp.local.";
            String serviceDescription = "Service for booking meeting rooms";

            // Create ServiceInfo object  
            ServiceInfo serviceInfo = ServiceInfo.create(
                    serviceType,
                    serviceName,
                    serviceDescription,
                    port,
                    "null"
            );

            // Register the service  
            jmdns.registerService(serviceInfo);
            System.out.println("Service registered: " + serviceName + " on port " + port);

        } catch (IOException e) {
            System.err.println("Error registering service: " + e.getMessage());
        }
    }

    @Override  
    public StreamObserver<RoomBookingRequest> bookRoom(StreamObserver<RoomBookingResponse> responseObserver) {
        // Logic for processing booking requests...

        // Return new StreamObserver to handle incoming RoomBookingRequest messages.
        return new StreamObserver<RoomBookingRequest>() {
            @Override  
            public void onNext(RoomBookingRequest request) {
                // Process the request  
                String confirmationMessage = "Room booked on " + request.getDate() +
                        " at " + request.getTime() + " for " + request.getDuration() +
                        " with requirements: " + request.getRequirements();

                RoomBookingResponse response = RoomBookingResponse.newBuilder()
                        .setConfirmation(confirmationMessage)
                        .build();

                responseObserver.onNext(response);
            }

            @Override  
            public void onError(Throwable t) {
                // Handle error  
                System.err.println("Error in booking room: " + t.getMessage());
                responseObserver.onError(t);
            }

            @Override  
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
