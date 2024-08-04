package grpc.cadanielLightingSystem;

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
    comments = "Source: adjustBrightness.proto")
public final class BrightnessServiceGrpc {

  private BrightnessServiceGrpc() {}

  public static final String SERVICE_NAME = "cadanielLightingSystem.BrightnessService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.cadanielLightingSystem.BrightnessRequest,
      grpc.cadanielLightingSystem.BrightnessResponse> getAdjustBrightnessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "adjustBrightness",
      requestType = grpc.cadanielLightingSystem.BrightnessRequest.class,
      responseType = grpc.cadanielLightingSystem.BrightnessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.cadanielLightingSystem.BrightnessRequest,
      grpc.cadanielLightingSystem.BrightnessResponse> getAdjustBrightnessMethod() {
    io.grpc.MethodDescriptor<grpc.cadanielLightingSystem.BrightnessRequest, grpc.cadanielLightingSystem.BrightnessResponse> getAdjustBrightnessMethod;
    if ((getAdjustBrightnessMethod = BrightnessServiceGrpc.getAdjustBrightnessMethod) == null) {
      synchronized (BrightnessServiceGrpc.class) {
        if ((getAdjustBrightnessMethod = BrightnessServiceGrpc.getAdjustBrightnessMethod) == null) {
          BrightnessServiceGrpc.getAdjustBrightnessMethod = getAdjustBrightnessMethod = 
              io.grpc.MethodDescriptor.<grpc.cadanielLightingSystem.BrightnessRequest, grpc.cadanielLightingSystem.BrightnessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "cadanielLightingSystem.BrightnessService", "adjustBrightness"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielLightingSystem.BrightnessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielLightingSystem.BrightnessResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BrightnessServiceMethodDescriptorSupplier("adjustBrightness"))
                  .build();
          }
        }
     }
     return getAdjustBrightnessMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BrightnessServiceStub newStub(io.grpc.Channel channel) {
    return new BrightnessServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BrightnessServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BrightnessServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BrightnessServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BrightnessServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BrightnessServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.cadanielLightingSystem.BrightnessRequest> adjustBrightness(
        io.grpc.stub.StreamObserver<grpc.cadanielLightingSystem.BrightnessResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAdjustBrightnessMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAdjustBrightnessMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.cadanielLightingSystem.BrightnessRequest,
                grpc.cadanielLightingSystem.BrightnessResponse>(
                  this, METHODID_ADJUST_BRIGHTNESS)))
          .build();
    }
  }

  /**
   */
  public static final class BrightnessServiceStub extends io.grpc.stub.AbstractStub<BrightnessServiceStub> {
    private BrightnessServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BrightnessServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrightnessServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BrightnessServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.cadanielLightingSystem.BrightnessRequest> adjustBrightness(
        io.grpc.stub.StreamObserver<grpc.cadanielLightingSystem.BrightnessResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAdjustBrightnessMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class BrightnessServiceBlockingStub extends io.grpc.stub.AbstractStub<BrightnessServiceBlockingStub> {
    private BrightnessServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BrightnessServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrightnessServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BrightnessServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class BrightnessServiceFutureStub extends io.grpc.stub.AbstractStub<BrightnessServiceFutureStub> {
    private BrightnessServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BrightnessServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrightnessServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BrightnessServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ADJUST_BRIGHTNESS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BrightnessServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BrightnessServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADJUST_BRIGHTNESS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.adjustBrightness(
              (io.grpc.stub.StreamObserver<grpc.cadanielLightingSystem.BrightnessResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BrightnessServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BrightnessServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.cadanielLightingSystem.BrightnessServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BrightnessService");
    }
  }

  private static final class BrightnessServiceFileDescriptorSupplier
      extends BrightnessServiceBaseDescriptorSupplier {
    BrightnessServiceFileDescriptorSupplier() {}
  }

  private static final class BrightnessServiceMethodDescriptorSupplier
      extends BrightnessServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BrightnessServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BrightnessServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BrightnessServiceFileDescriptorSupplier())
              .addMethod(getAdjustBrightnessMethod())
              .build();
        }
      }
    }
    return result;
  }
}
