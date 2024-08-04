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
    comments = "Source: turnOnOffLights.proto")
public final class TurnOnOffLightsGrpc {

  private TurnOnOffLightsGrpc() {}

  public static final String SERVICE_NAME = "cadanielLightingSystem.TurnOnOffLights";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.cadanielLightingSystem.CheckLightsRequest,
      grpc.cadanielLightingSystem.CheckLightsResponse> getCheckLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkLights",
      requestType = grpc.cadanielLightingSystem.CheckLightsRequest.class,
      responseType = grpc.cadanielLightingSystem.CheckLightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.cadanielLightingSystem.CheckLightsRequest,
      grpc.cadanielLightingSystem.CheckLightsResponse> getCheckLightsMethod() {
    io.grpc.MethodDescriptor<grpc.cadanielLightingSystem.CheckLightsRequest, grpc.cadanielLightingSystem.CheckLightsResponse> getCheckLightsMethod;
    if ((getCheckLightsMethod = TurnOnOffLightsGrpc.getCheckLightsMethod) == null) {
      synchronized (TurnOnOffLightsGrpc.class) {
        if ((getCheckLightsMethod = TurnOnOffLightsGrpc.getCheckLightsMethod) == null) {
          TurnOnOffLightsGrpc.getCheckLightsMethod = getCheckLightsMethod = 
              io.grpc.MethodDescriptor.<grpc.cadanielLightingSystem.CheckLightsRequest, grpc.cadanielLightingSystem.CheckLightsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cadanielLightingSystem.TurnOnOffLights", "checkLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielLightingSystem.CheckLightsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielLightingSystem.CheckLightsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TurnOnOffLightsMethodDescriptorSupplier("checkLights"))
                  .build();
          }
        }
     }
     return getCheckLightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TurnOnOffLightsStub newStub(io.grpc.Channel channel) {
    return new TurnOnOffLightsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TurnOnOffLightsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TurnOnOffLightsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TurnOnOffLightsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TurnOnOffLightsFutureStub(channel);
  }

  /**
   */
  public static abstract class TurnOnOffLightsImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkLights(grpc.cadanielLightingSystem.CheckLightsRequest request,
        io.grpc.stub.StreamObserver<grpc.cadanielLightingSystem.CheckLightsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckLightsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckLightsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.cadanielLightingSystem.CheckLightsRequest,
                grpc.cadanielLightingSystem.CheckLightsResponse>(
                  this, METHODID_CHECK_LIGHTS)))
          .build();
    }
  }

  /**
   */
  public static final class TurnOnOffLightsStub extends io.grpc.stub.AbstractStub<TurnOnOffLightsStub> {
    private TurnOnOffLightsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TurnOnOffLightsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TurnOnOffLightsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TurnOnOffLightsStub(channel, callOptions);
    }

    /**
     */
    public void checkLights(grpc.cadanielLightingSystem.CheckLightsRequest request,
        io.grpc.stub.StreamObserver<grpc.cadanielLightingSystem.CheckLightsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckLightsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TurnOnOffLightsBlockingStub extends io.grpc.stub.AbstractStub<TurnOnOffLightsBlockingStub> {
    private TurnOnOffLightsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TurnOnOffLightsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TurnOnOffLightsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TurnOnOffLightsBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.cadanielLightingSystem.CheckLightsResponse checkLights(grpc.cadanielLightingSystem.CheckLightsRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckLightsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TurnOnOffLightsFutureStub extends io.grpc.stub.AbstractStub<TurnOnOffLightsFutureStub> {
    private TurnOnOffLightsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TurnOnOffLightsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TurnOnOffLightsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TurnOnOffLightsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.cadanielLightingSystem.CheckLightsResponse> checkLights(
        grpc.cadanielLightingSystem.CheckLightsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckLightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_LIGHTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TurnOnOffLightsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TurnOnOffLightsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_LIGHTS:
          serviceImpl.checkLights((grpc.cadanielLightingSystem.CheckLightsRequest) request,
              (io.grpc.stub.StreamObserver<grpc.cadanielLightingSystem.CheckLightsResponse>) responseObserver);
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

  private static abstract class TurnOnOffLightsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TurnOnOffLightsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.cadanielLightingSystem.TurnOnOffLightsImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TurnOnOffLights");
    }
  }

  private static final class TurnOnOffLightsFileDescriptorSupplier
      extends TurnOnOffLightsBaseDescriptorSupplier {
    TurnOnOffLightsFileDescriptorSupplier() {}
  }

  private static final class TurnOnOffLightsMethodDescriptorSupplier
      extends TurnOnOffLightsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TurnOnOffLightsMethodDescriptorSupplier(String methodName) {
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
      synchronized (TurnOnOffLightsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TurnOnOffLightsFileDescriptorSupplier())
              .addMethod(getCheckLightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
