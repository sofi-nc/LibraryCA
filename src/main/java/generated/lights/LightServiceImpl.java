// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lighting.proto

package generated.lights;

public final class LightServiceImpl {
  private LightServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_LightLevel_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_LightLevel_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_AverageResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_AverageResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_LightRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_LightRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_lighting_StatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_lighting_StatusResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016lighting.proto\022\010lighting\"0\n\nLightLevel" +
      "\022\r\n\005level\030\001 \001(\005\022\023\n\013currentTime\030\002 \001(\t\"\'\n\017" +
      "AverageResponse\022\024\n\014lightAverage\030\001 \001(\t\"#\n" +
      "\014LightRequest\022\023\n\013lightButton\030\001 \001(\005\"$\n\016St" +
      "atusResponse\022\022\n\nlightState\030\001 \001(\t2\227\001\n\014Lig" +
      "htService\022F\n\017averageLighting\022\024.lighting." +
      "LightLevel\032\031.lighting.AverageResponse\"\000(" +
      "\001\022?\n\tturnOnOff\022\026.lighting.LightRequest\032\030" +
      ".lighting.StatusResponse\"\000B&\n\020generated." +
      "lightsB\020LightServiceImplP\001b\006proto3"
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
    internal_static_lighting_LightLevel_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_lighting_LightLevel_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_LightLevel_descriptor,
        new java.lang.String[] { "Level", "CurrentTime", });
    internal_static_lighting_AverageResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_lighting_AverageResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_AverageResponse_descriptor,
        new java.lang.String[] { "LightAverage", });
    internal_static_lighting_LightRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_lighting_LightRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_LightRequest_descriptor,
        new java.lang.String[] { "LightButton", });
    internal_static_lighting_StatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_lighting_StatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_lighting_StatusResponse_descriptor,
        new java.lang.String[] { "LightState", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}