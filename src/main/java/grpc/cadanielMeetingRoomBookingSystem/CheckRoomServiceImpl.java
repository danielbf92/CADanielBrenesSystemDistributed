// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: roomavailability.proto

package grpc.cadanielMeetingRoomBookingSystem;

public final class CheckRoomServiceImpl {
  private CheckRoomServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cadanielMeetingRoomBookingSystem_RoomAvailabilityRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cadanielMeetingRoomBookingSystem_RoomAvailabilityRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cadanielMeetingRoomBookingSystem_RoomAvailabilityResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cadanielMeetingRoomBookingSystem_RoomAvailabilityResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026roomavailability.proto\022 cadanielMeetin" +
      "gRoomBookingSystem\"-\n\027RoomAvailabilityRe" +
      "quest\022\022\n\nroomNumber\030\001 \001(\t\"-\n\030RoomAvailab" +
      "ilityResponse\022\021\n\tavailable\030\001 \001(\0102\243\001\n\020Che" +
      "ckRoomService\022\216\001\n\025checkRoomAvailability\022" +
      "9.cadanielMeetingRoomBookingSystem.RoomA" +
      "vailabilityRequest\032:.cadanielMeetingRoom" +
      "BookingSystem.RoomAvailabilityResponseB?" +
      "\n%grpc.cadanielMeetingRoomBookingSystemB" +
      "\024CheckRoomServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_cadanielMeetingRoomBookingSystem_RoomAvailabilityRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cadanielMeetingRoomBookingSystem_RoomAvailabilityRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cadanielMeetingRoomBookingSystem_RoomAvailabilityRequest_descriptor,
        new java.lang.String[] { "RoomNumber", });
    internal_static_cadanielMeetingRoomBookingSystem_RoomAvailabilityResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_cadanielMeetingRoomBookingSystem_RoomAvailabilityResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cadanielMeetingRoomBookingSystem_RoomAvailabilityResponse_descriptor,
        new java.lang.String[] { "Available", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
