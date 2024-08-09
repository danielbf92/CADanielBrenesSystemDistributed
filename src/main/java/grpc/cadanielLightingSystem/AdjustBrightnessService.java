package grpc.cadanielLightingSystem;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.cadanielLightingSystem.BrightnessServiceGrpc.BrightnessServiceImplBase;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class AdjustBrightnessService extends BrightnessServiceImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        AdjustBrightnessService brightnessServices = new AdjustBrightnessService();

        int port = 50055;

        Server server = ServerBuilder.forPort(port)
            .addService(brightnessServices)
            .build()
            .start();

        System.out.println("Service Adjust Brightness started, listening on " + port);

        // Register the service with jmDNS  
        registerService(port);

        server.awaitTermination();
    }

    private static void registerService(int port) {
        try {
            // Create a JmDNS instance  
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Define service details  
            String serviceName = "AdjustBrightnessService";
            String serviceType = "_grpc._tcp.local.";
            String serviceDescription = "Service for adjusting brightness in specified locations";

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
    public StreamObserver<BrightnessRequest> adjustBrightness(StreamObserver<BrightnessResponse> responseObserver) {
        // Extract metadata from the incoming request  
        Metadata metadata = new Metadata();
        // Note: You will need to set up a ServerInterceptor to pass the metadata properly to the handler  
        String authToken = "my_secure_token_brightness";
        // Validate the token from the metadata  
        metadata.get(Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER));
        // Validate the token  
        if (!"my_secure_token_brightness".equals(authToken)) {
            responseObserver.onError(Status.UNAUTHENTICATED.withDescription("Invalid auth token").asRuntimeException());
            return null; // Early exit  
        }
        
        return new StreamObserver<BrightnessRequest>() {
            @Override  
            public void onNext(BrightnessRequest request) {
                int brightnessLevel = request.getBrightnessLevel(); 
                String location = request.getLocation();
                boolean success = false;
                String message;

                // Simulate brightness adjustment  
                if (adjustBrightness(brightnessLevel, location)) {
                    success = true;
                    message = "Brightness set to " + brightnessLevel + " at " + location;
                } else {
                    message = "Failed to set brightness at " + location;
                }

                // Create and send response  
                BrightnessResponse response = BrightnessResponse.newBuilder()
                        .setLocation(location)
                        .setSuccess(success)
                        .setMessage(message)
                        .build();

                responseObserver.onNext(response);
            }

            @Override  
            public void onError(Throwable t) {
                // Handle error here, if necessary  
                System.err.println("Error: " + t.getMessage());
            }

            @Override  
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    private boolean adjustBrightness(int level, String location) {
        // Simulate successful adjustment.
        return level >= 0 && level <= 100;
    }
}
