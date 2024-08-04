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
      "\n\022registration.proto\022\014registration\"\323\001\n\027B" +
      "ookRegistrationRequest\022\016\n\006bookId\030\001 \001(\005\022\016" +
      "\n\006userId\030\002 \001(\005\022\017\n\007bookQty\030\003 \001(\005\022\r\n\005total" +
      "\030\004 \001(\005\022L\n\014registration\030\005 \001(\01626.registrat" +
      "ion.BookRegistrationRequest.Registration" +
      "Type\"*\n\020RegistrationType\022\n\n\006BORROW\020\000\022\n\n\006" +
      "RETURN\020\001\"x\n\030BookRegistrationResponse\022\020\n\010" +
      "userInfo\030\001 \001(\t\022\023\n\013bookDetails\030\002 \001(\t\022\022\n\nt" +
      "otalBooks\030\003 \001(\005\022\017\n\007regType\030\004 \001(\t\022\020\n\010comp" +
      "lReg\030\005 \001(\005\"M\n\032VisitorRegistrationRequest" +
      "\022\021\n\tvisitorId\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\022\016\n\006sta" +
      "tus\030\003 \001(\t\"Y\n\033VisitorRegistrationResponse" +
      "\022 \n\030registrationConfirmation\030\001 \001(\t\022\030\n\020re" +
      "gistrationDate\030\002 \001(\t2\341\001\n\020RegistrationBoo" +
      "k\022c\n\014bookRegister\022%.registration.BookReg" +
      "istrationRequest\032&.registration.BookRegi" +
      "strationResponse\"\000(\0010\001\022h\n\017visitorRegiste" +
      "r\022(.registration.VisitorRegistrationRequ" +
      "est\032).registration.VisitorRegistrationRe" +
      "sponse\"\000B,\n\026generated.registrationB\020Regi" +
      "strationImplP\001b\006proto3"
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
        new java.lang.String[] { "BookId", "UserId", "BookQty", "Total", "Registration", });
    internal_static_registration_BookRegistrationResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_registration_BookRegistrationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_registration_BookRegistrationResponse_descriptor,
        new java.lang.String[] { "UserInfo", "BookDetails", "TotalBooks", "RegType", "ComplReg", });
    internal_static_registration_VisitorRegistrationRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_registration_VisitorRegistrationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_registration_VisitorRegistrationRequest_descriptor,
        new java.lang.String[] { "VisitorId", "Name", "Status", });
    internal_static_registration_VisitorRegistrationResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_registration_VisitorRegistrationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_registration_VisitorRegistrationResponse_descriptor,
        new java.lang.String[] { "RegistrationConfirmation", "RegistrationDate", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
