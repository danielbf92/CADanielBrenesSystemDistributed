package grpc.cadanielSecuritySystem;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.cadanielSecuritySystem.LockUnlockDoorsGrpc.LockUnlockDoorsImplBase;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class CheckDoorsService extends LockUnlockDoorsImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        CheckDoorsService checkDoorsService = new CheckDoorsService();

        int port = 50054;

        Server server = ServerBuilder.forPort(port)
            .addService(checkDoorsService)
            .build()
            .start();

        System.out.println("Service Check Doors started, listening on " + port);

        // Register the service with jmDNS  
        registerService(port);

        server.awaitTermination();
    }

    private static void registerService(int port) {
        try {
            // Create a JmDNS instance  
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Define service details  
            String serviceName = "CheckDoorsService";
            String serviceType = "_grpc._tcp.local.";
            String serviceDescription = "Service for checking door availability in rooms";

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
	public void checkDoors(CheckDoorsRequest request, StreamObserver<CheckDoorsResponse> responseObserver) {

        // Extract metadata from the incoming request  
        Metadata metadata = new Metadata();
        // Note: You will need to set up a ServerInterceptor to pass the metadata properly to the handler
        String authToken = "my_secure_token_doors";
        // Validate the token from the metadata  
        metadata.get(Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER));
        // Validate the token  
        if (!"my_secure_token_doors".equals(authToken)) {
            responseObserver.onError(Status.UNAUTHENTICATED.withDescription("Invalid auth token").asRuntimeException());
            return;
        }

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
