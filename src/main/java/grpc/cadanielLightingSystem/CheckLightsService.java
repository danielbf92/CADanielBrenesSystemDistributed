package grpc.cadanielLightingSystem;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.cadanielLightingSystem.TurnOnOffLightsGrpc.TurnOnOffLightsImplBase;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class CheckLightsService extends TurnOnOffLightsImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        CheckLightsService checkLightsService = new CheckLightsService();

        int port = 50053;

        Server server = ServerBuilder.forPort(port)
            .addService(checkLightsService)
            .build()
            .start();

        System.out.println("Check Lights Service started, listening on " + port);

        // Register the service with jmDNS  
        registerService(port);

        server.awaitTermination();
    }

    private static void registerService(int port) {
        try {
            // Create a JmDNS instance  
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Define service details  
            String serviceName = "CheckLightsService";
            String serviceType = "_grpc._tcp.local.";
            String serviceDescription = "Service for checking lights availability in rooms";

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
    public void checkLights(CheckLightsRequest request, StreamObserver<CheckLightsResponse> responseObserver) {
        // Extract metadata from the incoming request  
        Metadata metadata = new Metadata();
        // Note: You will need to set up a ServerInterceptor to pass the metadata properly to the handler  
        String authToken = "my_secure_token_Lights";
        // Validate the token from the metadata  
        metadata.get(Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER));
        // Validate the token  
        if (!"my_secure_token_Lights".equals(authToken)) {
            responseObserver.onError(Status.UNAUTHENTICATED.withDescription("Invalid auth token").asRuntimeException());
            return; // Early exit on error  
        }

        // Prepare the value to be set back  
        String roomNumber = request.getRoomNumber();
        boolean isRoomAvailable = checkLightsMethod(roomNumber);

        // Preparing the response message  
        CheckLightsResponse reply = CheckLightsResponse.newBuilder().setAvailable(isRoomAvailable).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    // Method to check lights availability based on room number  
    private boolean checkLightsMethod(String roomNumber) {
        int[] rooms = {2, 4};
        for (int room : rooms) {
            if (room == Integer.parseInt(roomNumber)) {
                return true;
            }
        }
        return false;
    }
}
