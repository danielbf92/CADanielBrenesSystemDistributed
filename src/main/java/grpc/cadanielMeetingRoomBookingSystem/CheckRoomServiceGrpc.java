package grpc.cadanielMeetingRoomBookingSystem;

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
    comments = "Source: roomavailability.proto")
public final class CheckRoomServiceGrpc {

  private CheckRoomServiceGrpc() {}

  public static final String SERVICE_NAME = "cadanielMeetingRoomBookingSystem.CheckRoomService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest,
      grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse> getCheckRoomAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkRoomAvailability",
      requestType = grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest.class,
      responseType = grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest,
      grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse> getCheckRoomAvailabilityMethod() {
    io.grpc.MethodDescriptor<grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest, grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse> getCheckRoomAvailabilityMethod;
    if ((getCheckRoomAvailabilityMethod = CheckRoomServiceGrpc.getCheckRoomAvailabilityMethod) == null) {
      synchronized (CheckRoomServiceGrpc.class) {
        if ((getCheckRoomAvailabilityMethod = CheckRoomServiceGrpc.getCheckRoomAvailabilityMethod) == null) {
          CheckRoomServiceGrpc.getCheckRoomAvailabilityMethod = getCheckRoomAvailabilityMethod = 
              io.grpc.MethodDescriptor.<grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest, grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cadanielMeetingRoomBookingSystem.CheckRoomService", "checkRoomAvailability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CheckRoomServiceMethodDescriptorSupplier("checkRoomAvailability"))
                  .build();
          }
        }
     }
     return getCheckRoomAvailabilityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CheckRoomServiceStub newStub(io.grpc.Channel channel) {
    return new CheckRoomServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CheckRoomServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CheckRoomServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CheckRoomServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CheckRoomServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CheckRoomServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkRoomAvailability(grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest request,
        io.grpc.stub.StreamObserver<grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckRoomAvailabilityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckRoomAvailabilityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest,
                grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse>(
                  this, METHODID_CHECK_ROOM_AVAILABILITY)))
          .build();
    }
  }

  /**
   */
  public static final class CheckRoomServiceStub extends io.grpc.stub.AbstractStub<CheckRoomServiceStub> {
    private CheckRoomServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CheckRoomServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckRoomServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CheckRoomServiceStub(channel, callOptions);
    }

    /**
     */
    public void checkRoomAvailability(grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest request,
        io.grpc.stub.StreamObserver<grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckRoomAvailabilityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CheckRoomServiceBlockingStub extends io.grpc.stub.AbstractStub<CheckRoomServiceBlockingStub> {
    private CheckRoomServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CheckRoomServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckRoomServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CheckRoomServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse checkRoomAvailability(grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckRoomAvailabilityMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CheckRoomServiceFutureStub extends io.grpc.stub.AbstractStub<CheckRoomServiceFutureStub> {
    private CheckRoomServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CheckRoomServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckRoomServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CheckRoomServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse> checkRoomAvailability(
        grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckRoomAvailabilityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_ROOM_AVAILABILITY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CheckRoomServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CheckRoomServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_ROOM_AVAILABILITY:
          serviceImpl.checkRoomAvailability((grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityRequest) request,
              (io.grpc.stub.StreamObserver<grpc.cadanielMeetingRoomBookingSystem.RoomAvailabilityResponse>) responseObserver);
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

  private static abstract class CheckRoomServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CheckRoomServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.cadanielMeetingRoomBookingSystem.CheckRoomServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CheckRoomService");
    }
  }

  private static final class CheckRoomServiceFileDescriptorSupplier
      extends CheckRoomServiceBaseDescriptorSupplier {
    CheckRoomServiceFileDescriptorSupplier() {}
  }

  private static final class CheckRoomServiceMethodDescriptorSupplier
      extends CheckRoomServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CheckRoomServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CheckRoomServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CheckRoomServiceFileDescriptorSupplier())
              .addMethod(getCheckRoomAvailabilityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
