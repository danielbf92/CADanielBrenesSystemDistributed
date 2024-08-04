package grpc.cadanielSecuritySystem;

import java.io.IOException;

import grpc.cadanielSecuritySystem.CamaraServiceGrpc.CamaraServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CamaraService extends CamaraServiceImplBase{
    public static void main(String[] args) throws InterruptedException, IOException{
        CamaraService camaraService = new CamaraService();

        int port = 50056;

        Server server = ServerBuilder.forPort(port)
            .addService(camaraService)
            .build()
            .start();

        System.out.println("Service Camara Monitoring started, listening on " + port);

		server.awaitTermination();
    }

    @Override
	public void checkCamara(CheckCamaraRequest request, StreamObserver<CheckCamaraResponse> responseObserver) {

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
