package grpc.cadanielLightingSystem;

import java.io.IOException;

import grpc.cadanielLightingSystem.BrightnessServiceGrpc.BrightnessServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class AdjustBrightnessService extends BrightnessServiceImplBase{
    public static void main(String[] args) throws InterruptedException, IOException{
        AdjustBrightnessService BrightnessServices = new AdjustBrightnessService();

        int port = 50055;

        Server server = ServerBuilder.forPort(port)
            .addService(BrightnessServices)
            .build()
            .start();

        System.out.println("Service Adjust Brightness started, listening on " + port);

		server.awaitTermination();
    }

    @Override
    public StreamObserver<BrightnessRequest> adjustBrightness(StreamObserver<BrightnessResponse> responseObserver) {
        return new StreamObserver<BrightnessRequest>() {
            @Override
            public void onNext(BrightnessRequest request) {
                int brightnessLevel = request.getBrightnessLevel(); 
                String location = request.getLocation();
                boolean success = false;
                String message;

                //Simulate brightness
                if (adjustBrightness(brightnessLevel, location)) {
                    success = true;
                    message = "Brightness set to " + brightnessLevel + " at " + location;
                } else {
                    message = "Failed to set brightness at " + location;
                }

                //Create and send response
                BrightnessResponse response = BrightnessResponse.newBuilder()
                        .setLocation(location)
                        .setSuccess(success)
                        .setMessage(message)
                        .build();

                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                // Handle error
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
