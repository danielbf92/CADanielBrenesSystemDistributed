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
    comments = "Source: lockUnLockDoors.proto")
public final class LockUnlockDoorsGrpc {

  private LockUnlockDoorsGrpc() {}

  public static final String SERVICE_NAME = "cadanielSecuritySystem.LockUnlockDoors";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.cadanielSecuritySystem.CheckDoorsRequest,
      grpc.cadanielSecuritySystem.CheckDoorsResponse> getCheckDoorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkDoors",
      requestType = grpc.cadanielSecuritySystem.CheckDoorsRequest.class,
      responseType = grpc.cadanielSecuritySystem.CheckDoorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.cadanielSecuritySystem.CheckDoorsRequest,
      grpc.cadanielSecuritySystem.CheckDoorsResponse> getCheckDoorsMethod() {
    io.grpc.MethodDescriptor<grpc.cadanielSecuritySystem.CheckDoorsRequest, grpc.cadanielSecuritySystem.CheckDoorsResponse> getCheckDoorsMethod;
    if ((getCheckDoorsMethod = LockUnlockDoorsGrpc.getCheckDoorsMethod) == null) {
      synchronized (LockUnlockDoorsGrpc.class) {
        if ((getCheckDoorsMethod = LockUnlockDoorsGrpc.getCheckDoorsMethod) == null) {
          LockUnlockDoorsGrpc.getCheckDoorsMethod = getCheckDoorsMethod = 
              io.grpc.MethodDescriptor.<grpc.cadanielSecuritySystem.CheckDoorsRequest, grpc.cadanielSecuritySystem.CheckDoorsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cadanielSecuritySystem.LockUnlockDoors", "checkDoors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielSecuritySystem.CheckDoorsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielSecuritySystem.CheckDoorsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LockUnlockDoorsMethodDescriptorSupplier("checkDoors"))
                  .build();
          }
        }
     }
     return getCheckDoorsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LockUnlockDoorsStub newStub(io.grpc.Channel channel) {
    return new LockUnlockDoorsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LockUnlockDoorsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LockUnlockDoorsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LockUnlockDoorsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LockUnlockDoorsFutureStub(channel);
  }

  /**
   */
  public static abstract class LockUnlockDoorsImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkDoors(grpc.cadanielSecuritySystem.CheckDoorsRequest request,
        io.grpc.stub.StreamObserver<grpc.cadanielSecuritySystem.CheckDoorsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckDoorsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckDoorsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.cadanielSecuritySystem.CheckDoorsRequest,
                grpc.cadanielSecuritySystem.CheckDoorsResponse>(
                  this, METHODID_CHECK_DOORS)))
          .build();
    }
  }

  /**
   */
  public static final class LockUnlockDoorsStub extends io.grpc.stub.AbstractStub<LockUnlockDoorsStub> {
    private LockUnlockDoorsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LockUnlockDoorsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LockUnlockDoorsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LockUnlockDoorsStub(channel, callOptions);
    }

    /**
     */
    public void checkDoors(grpc.cadanielSecuritySystem.CheckDoorsRequest request,
        io.grpc.stub.StreamObserver<grpc.cadanielSecuritySystem.CheckDoorsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckDoorsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LockUnlockDoorsBlockingStub extends io.grpc.stub.AbstractStub<LockUnlockDoorsBlockingStub> {
    private LockUnlockDoorsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LockUnlockDoorsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LockUnlockDoorsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LockUnlockDoorsBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.cadanielSecuritySystem.CheckDoorsResponse checkDoors(grpc.cadanielSecuritySystem.CheckDoorsRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckDoorsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LockUnlockDoorsFutureStub extends io.grpc.stub.AbstractStub<LockUnlockDoorsFutureStub> {
    private LockUnlockDoorsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LockUnlockDoorsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LockUnlockDoorsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LockUnlockDoorsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.cadanielSecuritySystem.CheckDoorsResponse> checkDoors(
        grpc.cadanielSecuritySystem.CheckDoorsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckDoorsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_DOORS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LockUnlockDoorsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LockUnlockDoorsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_DOORS:
          serviceImpl.checkDoors((grpc.cadanielSecuritySystem.CheckDoorsRequest) request,
              (io.grpc.stub.StreamObserver<grpc.cadanielSecuritySystem.CheckDoorsResponse>) responseObserver);
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

  private static abstract class LockUnlockDoorsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LockUnlockDoorsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.cadanielSecuritySystem.LockUnlockDoorsImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LockUnlockDoors");
    }
  }

  private static final class LockUnlockDoorsFileDescriptorSupplier
      extends LockUnlockDoorsBaseDescriptorSupplier {
    LockUnlockDoorsFileDescriptorSupplier() {}
  }

  private static final class LockUnlockDoorsMethodDescriptorSupplier
      extends LockUnlockDoorsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LockUnlockDoorsMethodDescriptorSupplier(String methodName) {
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
      synchronized (LockUnlockDoorsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LockUnlockDoorsFileDescriptorSupplier())
              .addMethod(getCheckDoorsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
