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
    internal_static_searchEngine_BookRegistrationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_searchEngine_BookRegistrationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_searchEngine_BookRegistrationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_searchEngine_BookRegistrationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_searchEngine_VisitorRegistrationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_searchEngine_VisitorRegistrationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_searchEngine_VisitorRegistrationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_searchEngine_VisitorRegistrationResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022registration.proto\022\014searchEngine\"\243\001\n\027B" +
      "ookRegistrationRequest\022\016\n\006bookId\030\001 \001(\005\022L" +
      "\n\014registration\030\002 \001(\01626.searchEngine.Book" +
      "RegistrationRequest.RegistrationType\"*\n\020" +
      "RegistrationType\022\n\n\006BORROW\020\000\022\n\n\006RETURN\020\001" +
      "\"U\n\030BookRegistrationResponse\022\020\n\010userInfo" +
      "\030\001 \001(\t\022\023\n\013bookDetails\030\002 \001(\t\022\022\n\ntotalBook" +
      "s\030\003 \001(\005\",\n\032VisitorRegistrationRequest\022\016\n" +
      "\006bookId\030\001 \001(\005\"Y\n\033VisitorRegistrationResp" +
      "onse\022 \n\030registrationConfirmation\030\001 \001(\t\022\030" +
      "\n\020registrationDate\030\002 \001(\t2\341\001\n\020Registratio" +
      "nBook\022c\n\014bookRegister\022%.searchEngine.Boo" +
      "kRegistrationRequest\032&.searchEngine.Book" +
      "RegistrationResponse\"\000(\0010\001\022h\n\017visitorReg" +
      "ister\022(.searchEngine.VisitorRegistration" +
      "Request\032).searchEngine.VisitorRegistrati" +
      "onResponse\"\000B,\n\026generated.registrationB\020" +
      "RegistrationImplP\001b\006proto3"
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
    internal_static_searchEngine_BookRegistrationRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_searchEngine_BookRegistrationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_searchEngine_BookRegistrationRequest_descriptor,
        new java.lang.String[] { "BookId", "Registration", });
    internal_static_searchEngine_BookRegistrationResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_searchEngine_BookRegistrationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_searchEngine_BookRegistrationResponse_descriptor,
        new java.lang.String[] { "UserInfo", "BookDetails", "TotalBooks", });
    internal_static_searchEngine_VisitorRegistrationRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_searchEngine_VisitorRegistrationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_searchEngine_VisitorRegistrationRequest_descriptor,
        new java.lang.String[] { "BookId", });
    internal_static_searchEngine_VisitorRegistrationResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_searchEngine_VisitorRegistrationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_searchEngine_VisitorRegistrationResponse_descriptor,
        new java.lang.String[] { "RegistrationConfirmation", "RegistrationDate", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}