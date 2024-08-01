// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: registration.proto

package generated.registration;

public final class RegistrationImpl {
  private RegistrationImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_registration_BookRegistrationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_registration_BookRegistrationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_registration_BookRegistrationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_registration_BookRegistrationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_registration_VisitorRegistrationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_registration_VisitorRegistrationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_registration_VisitorRegistrationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_registration_VisitorRegistrationResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022registration.proto\022\014registration\"\263\001\n\027B" +
      "ookRegistrationRequest\022\016\n\006bookId\030\001 \001(\005\022\016" +
      "\n\006userId\030\002 \001(\005\022L\n\014registration\030\003 \001(\01626.r" +
      "egistration.BookRegistrationRequest.Regi" +
      "strationType\"*\n\020RegistrationType\022\n\n\006BORR" +
      "OW\020\000\022\n\n\006RETURN\020\001\"U\n\030BookRegistrationResp" +
      "onse\022\020\n\010userInfo\030\001 \001(\t\022\023\n\013bookDetails\030\002 " +
      "\001(\t\022\022\n\ntotalBooks\030\003 \001(\005\"/\n\032VisitorRegist" +
      "rationRequest\022\021\n\tvisitorId\030\001 \001(\005\"Y\n\033Visi" +
      "torRegistrationResponse\022 \n\030registrationC" +
      "onfirmation\030\001 \001(\t\022\030\n\020registrationDate\030\002 " +
      "\001(\t2\341\001\n\020RegistrationBook\022c\n\014bookRegister" +
      "\022%.registration.BookRegistrationRequest\032" +
      "&.registration.BookRegistrationResponse\"" +
      "\000(\0010\001\022h\n\017visitorRegister\022(.registration." +
      "VisitorRegistrationRequest\032).registratio" +
      "n.VisitorRegistrationResponse\"\000B,\n\026gener" +
      "ated.registrationB\020RegistrationImplP\001b\006p" +
      "roto3"
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
    internal_static_registration_BookRegistrationRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_registration_BookRegistrationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_registration_BookRegistrationRequest_descriptor,
        new java.lang.String[] { "BookId", "UserId", "Registration", });
    internal_static_registration_BookRegistrationResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_registration_BookRegistrationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_registration_BookRegistrationResponse_descriptor,
        new java.lang.String[] { "UserInfo", "BookDetails", "TotalBooks", });
    internal_static_registration_VisitorRegistrationRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_registration_VisitorRegistrationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_registration_VisitorRegistrationRequest_descriptor,
        new java.lang.String[] { "VisitorId", });
    internal_static_registration_VisitorRegistrationResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_registration_VisitorRegistrationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_registration_VisitorRegistrationResponse_descriptor,
        new java.lang.String[] { "RegistrationConfirmation", "RegistrationDate", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
