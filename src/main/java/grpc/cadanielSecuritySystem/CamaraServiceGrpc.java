package grpc.cadanielSecuritySystem;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: camaraMonitoring.proto")
public final class CamaraServiceGrpc {

  private CamaraServiceGrpc() {}

  public static final String SERVICE_NAME = "cadanielSecuritySystem.CamaraService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.cadanielSecuritySystem.CheckCamaraRequest,
      grpc.cadanielSecuritySystem.CheckCamaraResponse> getCheckCamaraMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkCamara",
      requestType = grpc.cadanielSecuritySystem.CheckCamaraRequest.class,
      responseType = grpc.cadanielSecuritySystem.CheckCamaraResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.cadanielSecuritySystem.CheckCamaraRequest,
      grpc.cadanielSecuritySystem.CheckCamaraResponse> getCheckCamaraMethod() {
    io.grpc.MethodDescriptor<grpc.cadanielSecuritySystem.CheckCamaraRequest, grpc.cadanielSecuritySystem.CheckCamaraResponse> getCheckCamaraMethod;
    if ((getCheckCamaraMethod = CamaraServiceGrpc.getCheckCamaraMethod) == null) {
      synchronized (CamaraServiceGrpc.class) {
        if ((getCheckCamaraMethod = CamaraServiceGrpc.getCheckCamaraMethod) == null) {
          CamaraServiceGrpc.getCheckCamaraMethod = getCheckCamaraMethod = 
              io.grpc.MethodDescriptor.<grpc.cadanielSecuritySystem.CheckCamaraRequest, grpc.cadanielSecuritySystem.CheckCamaraResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "cadanielSecuritySystem.CamaraService", "checkCamara"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielSecuritySystem.CheckCamaraRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielSecuritySystem.CheckCamaraResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CamaraServiceMethodDescriptorSupplier("checkCamara"))
                  .build();
          }
        }
     }
     return getCheckCamaraMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CamaraServiceStub newStub(io.grpc.Channel channel) {
    return new CamaraServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CamaraServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CamaraServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CamaraServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CamaraServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CamaraServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkCamara(grpc.cadanielSecuritySystem.CheckCamaraRequest request,
        io.grpc.stub.StreamObserver<grpc.cadanielSecuritySystem.CheckCamaraResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckCamaraMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckCamaraMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.cadanielSecuritySystem.CheckCamaraRequest,
                grpc.cadanielSecuritySystem.CheckCamaraResponse>(
                  this, METHODID_CHECK_CAMARA)))
          .build();
    }
  }

  /**
   */
  public static final class CamaraServiceStub extends io.grpc.stub.AbstractStub<CamaraServiceStub> {
    private CamaraServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CamaraServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CamaraServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CamaraServiceStub(channel, callOptions);
    }

    /**
     */
    public void checkCamara(grpc.cadanielSecuritySystem.CheckCamaraRequest request,
        io.grpc.stub.StreamObserver<grpc.cadanielSecuritySystem.CheckCamaraResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCheckCamaraMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CamaraServiceBlockingStub extends io.grpc.stub.AbstractStub<CamaraServiceBlockingStub> {
    private CamaraServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CamaraServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CamaraServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CamaraServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<grpc.cadanielSecuritySystem.CheckCamaraResponse> checkCamara(
        grpc.cadanielSecuritySystem.CheckCamaraRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getCheckCamaraMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CamaraServiceFutureStub extends io.grpc.stub.AbstractStub<CamaraServiceFutureStub> {
    private CamaraServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CamaraServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CamaraServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CamaraServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHECK_CAMARA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CamaraServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CamaraServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_CAMARA:
          serviceImpl.checkCamara((grpc.cadanielSecuritySystem.CheckCamaraRequest) request,
              (io.grpc.stub.StreamObserver<grpc.cadanielSecuritySystem.CheckCamaraResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CamaraServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CamaraServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.cadanielSecuritySystem.CamaraServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CamaraService");
    }
  }

  private static final class CamaraServiceFileDescriptorSupplier
      extends CamaraServiceBaseDescriptorSupplier {
    CamaraServiceFileDescriptorSupplier() {}
  }

  private static final class CamaraServiceMethodDescriptorSupplier
      extends CamaraServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CamaraServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CamaraServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CamaraServiceFileDescriptorSupplier())
              .addMethod(getCheckCamaraMethod())
              .build();
        }
      }
    }
    return result;
  }
}
