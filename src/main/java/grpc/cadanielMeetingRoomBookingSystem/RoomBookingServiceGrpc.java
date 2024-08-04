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
    comments = "Source: roomBookingService.proto")
public final class RoomBookingServiceGrpc {

  private RoomBookingServiceGrpc() {}

  public static final String SERVICE_NAME = "cadanielMeetingRoomBookingSystem.RoomBookingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.cadanielMeetingRoomBookingSystem.RoomBookingRequest,
      grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse> getBookRoomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookRoom",
      requestType = grpc.cadanielMeetingRoomBookingSystem.RoomBookingRequest.class,
      responseType = grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.cadanielMeetingRoomBookingSystem.RoomBookingRequest,
      grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse> getBookRoomMethod() {
    io.grpc.MethodDescriptor<grpc.cadanielMeetingRoomBookingSystem.RoomBookingRequest, grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse> getBookRoomMethod;
    if ((getBookRoomMethod = RoomBookingServiceGrpc.getBookRoomMethod) == null) {
      synchronized (RoomBookingServiceGrpc.class) {
        if ((getBookRoomMethod = RoomBookingServiceGrpc.getBookRoomMethod) == null) {
          RoomBookingServiceGrpc.getBookRoomMethod = getBookRoomMethod = 
              io.grpc.MethodDescriptor.<grpc.cadanielMeetingRoomBookingSystem.RoomBookingRequest, grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "cadanielMeetingRoomBookingSystem.RoomBookingService", "bookRoom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielMeetingRoomBookingSystem.RoomBookingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RoomBookingServiceMethodDescriptorSupplier("bookRoom"))
                  .build();
          }
        }
     }
     return getBookRoomMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoomBookingServiceStub newStub(io.grpc.Channel channel) {
    return new RoomBookingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoomBookingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RoomBookingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoomBookingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RoomBookingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RoomBookingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.cadanielMeetingRoomBookingSystem.RoomBookingRequest> bookRoom(
        io.grpc.stub.StreamObserver<grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBookRoomMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBookRoomMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.cadanielMeetingRoomBookingSystem.RoomBookingRequest,
                grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse>(
                  this, METHODID_BOOK_ROOM)))
          .build();
    }
  }

  /**
   */
  public static final class RoomBookingServiceStub extends io.grpc.stub.AbstractStub<RoomBookingServiceStub> {
    private RoomBookingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomBookingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomBookingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomBookingServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.cadanielMeetingRoomBookingSystem.RoomBookingRequest> bookRoom(
        io.grpc.stub.StreamObserver<grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getBookRoomMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class RoomBookingServiceBlockingStub extends io.grpc.stub.AbstractStub<RoomBookingServiceBlockingStub> {
    private RoomBookingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomBookingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomBookingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomBookingServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class RoomBookingServiceFutureStub extends io.grpc.stub.AbstractStub<RoomBookingServiceFutureStub> {
    private RoomBookingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomBookingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomBookingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomBookingServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_BOOK_ROOM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RoomBookingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RoomBookingServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_BOOK_ROOM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bookRoom(
              (io.grpc.stub.StreamObserver<grpc.cadanielMeetingRoomBookingSystem.RoomBookingResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RoomBookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoomBookingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.cadanielMeetingRoomBookingSystem.RoomBookingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RoomBookingService");
    }
  }

  private static final class RoomBookingServiceFileDescriptorSupplier
      extends RoomBookingServiceBaseDescriptorSupplier {
    RoomBookingServiceFileDescriptorSupplier() {}
  }

  private static final class RoomBookingServiceMethodDescriptorSupplier
      extends RoomBookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RoomBookingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RoomBookingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoomBookingServiceFileDescriptorSupplier())
              .addMethod(getBookRoomMethod())
              .build();
        }
      }
    }
    return result;
  }
}
