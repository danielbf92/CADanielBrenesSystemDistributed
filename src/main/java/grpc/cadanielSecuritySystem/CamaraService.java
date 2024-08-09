package grpc.cadanielSecuritySystem;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.cadanielSecuritySystem.CamaraServiceGrpc.CamaraServiceImplBase;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class CamaraService extends CamaraServiceImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        CamaraService camaraService = new CamaraService();

        int port = 50056;

        Server server = ServerBuilder.forPort(port)
            .addService(camaraService)
            .build()
            .start();

        System.out.println("Service Camara Monitoring started, listening on " + port);

        // Register the service with jmDNS  
        registerService(port);

        server.awaitTermination();
    }

    private static void registerService(int port) {
        try {
            // Create a JmDNS instance  
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Define service details  
            String serviceName = "CamaraMonitoringService";
            String serviceType = "_grpc._tcp.local.";
            String serviceDescription = "Service for monitoring camera data";

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
    public void checkCamara(CheckCamaraRequest request, StreamObserver<CheckCamaraResponse> responseObserver) {
        // Extract metadata from the incoming request  
        Metadata metadata = new Metadata();
        // Extract metadata from the incoming request  
        String authToken = "my_secure_token_camara";  
        // Validate the token from the metadata  
        metadata.get(Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER));
        // Validate the token  
        if (!"my_secure_token_camara".equals(authToken)) {
            responseObserver.onError(Status.UNAUTHENTICATED.withDescription("Invalid auth token").asRuntimeException());
            return;
        }

        String cameraId = request.getCamaraId();
        // Simulating continuous data streaming  
        for (int i = 0; i < 10; i++) { // Example to send 10 pieces of data  
            String data = "Data from camera " + cameraId + " #" + (i + 1);
            CheckCamaraResponse output = CheckCamaraResponse.newBuilder()
                    .setCamaraId(cameraId)
                    .setData(data)
                    .build();
            
            responseObserver.onNext(output);
            try {
                Thread.sleep(1000); // Simulating delay between data  
            } catch (InterruptedException e) {
                responseObserver.onError(e);
            }
        }
        responseObserver.onCompleted();
    }
}
