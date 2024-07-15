package generated.registration;

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
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: registration.proto")
public final class RegistrationBookGrpc {

  private RegistrationBookGrpc() {}

  public static final String SERVICE_NAME = "searchEngine.RegistrationBook";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.registration.BookRegistrationRequest,
      generated.registration.BookRegistrationResponse> getBookRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookRegister",
      requestType = generated.registration.BookRegistrationRequest.class,
      responseType = generated.registration.BookRegistrationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<generated.registration.BookRegistrationRequest,
      generated.registration.BookRegistrationResponse> getBookRegisterMethod() {
    io.grpc.MethodDescriptor<generated.registration.BookRegistrationRequest, generated.registration.BookRegistrationResponse> getBookRegisterMethod;
    if ((getBookRegisterMethod = RegistrationBookGrpc.getBookRegisterMethod) == null) {
      synchronized (RegistrationBookGrpc.class) {
        if ((getBookRegisterMethod = RegistrationBookGrpc.getBookRegisterMethod) == null) {
          RegistrationBookGrpc.getBookRegisterMethod = getBookRegisterMethod = 
              io.grpc.MethodDescriptor.<generated.registration.BookRegistrationRequest, generated.registration.BookRegistrationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "searchEngine.RegistrationBook", "bookRegister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.registration.BookRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.registration.BookRegistrationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RegistrationBookMethodDescriptorSupplier("bookRegister"))
                  .build();
          }
        }
     }
     return getBookRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.registration.VisitorRegistrationRequest,
      generated.registration.VisitorRegistrationResponse> getVisitorRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "visitorRegister",
      requestType = generated.registration.VisitorRegistrationRequest.class,
      responseType = generated.registration.VisitorRegistrationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.registration.VisitorRegistrationRequest,
      generated.registration.VisitorRegistrationResponse> getVisitorRegisterMethod() {
    io.grpc.MethodDescriptor<generated.registration.VisitorRegistrationRequest, generated.registration.VisitorRegistrationResponse> getVisitorRegisterMethod;
    if ((getVisitorRegisterMethod = RegistrationBookGrpc.getVisitorRegisterMethod) == null) {
      synchronized (RegistrationBookGrpc.class) {
        if ((getVisitorRegisterMethod = RegistrationBookGrpc.getVisitorRegisterMethod) == null) {
          RegistrationBookGrpc.getVisitorRegisterMethod = getVisitorRegisterMethod = 
              io.grpc.MethodDescriptor.<generated.registration.VisitorRegistrationRequest, generated.registration.VisitorRegistrationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "searchEngine.RegistrationBook", "visitorRegister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.registration.VisitorRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.registration.VisitorRegistrationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RegistrationBookMethodDescriptorSupplier("visitorRegister"))
                  .build();
          }
        }
     }
     return getVisitorRegisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegistrationBookStub newStub(io.grpc.Channel channel) {
    return new RegistrationBookStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegistrationBookBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RegistrationBookBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegistrationBookFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RegistrationBookFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class RegistrationBookImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * BINARY STREAM RPC
     *Client chooses an option between registering books that are either being borrowed or returned
     *they send the book's ID and get a confirmation message from the system when they're finished (or when they reach the limit of books)
     *Once the registration is completed, the system sends back a message with a list of the book's information, the reader's information, and the total number of registered books
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.registration.BookRegistrationRequest> bookRegister(
        io.grpc.stub.StreamObserver<generated.registration.BookRegistrationResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBookRegisterMethod(), responseObserver);
    }

    /**
     * <pre>
     *UNARY RPC
     *Client sends a reader's ID to register their visit in the system. The system returns a confirmation message.
     * </pre>
     */
    public void visitorRegister(generated.registration.VisitorRegistrationRequest request,
        io.grpc.stub.StreamObserver<generated.registration.VisitorRegistrationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getVisitorRegisterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBookRegisterMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                generated.registration.BookRegistrationRequest,
                generated.registration.BookRegistrationResponse>(
                  this, METHODID_BOOK_REGISTER)))
          .addMethod(
            getVisitorRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.registration.VisitorRegistrationRequest,
                generated.registration.VisitorRegistrationResponse>(
                  this, METHODID_VISITOR_REGISTER)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RegistrationBookStub extends io.grpc.stub.AbstractStub<RegistrationBookStub> {
    private RegistrationBookStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegistrationBookStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationBookStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegistrationBookStub(channel, callOptions);
    }

    /**
     * <pre>
     * BINARY STREAM RPC
     *Client chooses an option between registering books that are either being borrowed or returned
     *they send the book's ID and get a confirmation message from the system when they're finished (or when they reach the limit of books)
     *Once the registration is completed, the system sends back a message with a list of the book's information, the reader's information, and the total number of registered books
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.registration.BookRegistrationRequest> bookRegister(
        io.grpc.stub.StreamObserver<generated.registration.BookRegistrationResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBookRegisterMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *UNARY RPC
     *Client sends a reader's ID to register their visit in the system. The system returns a confirmation message.
     * </pre>
     */
    public void visitorRegister(generated.registration.VisitorRegistrationRequest request,
        io.grpc.stub.StreamObserver<generated.registration.VisitorRegistrationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getVisitorRegisterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RegistrationBookBlockingStub extends io.grpc.stub.AbstractStub<RegistrationBookBlockingStub> {
    private RegistrationBookBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegistrationBookBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationBookBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegistrationBookBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *UNARY RPC
     *Client sends a reader's ID to register their visit in the system. The system returns a confirmation message.
     * </pre>
     */
    public generated.registration.VisitorRegistrationResponse visitorRegister(generated.registration.VisitorRegistrationRequest request) {
      return blockingUnaryCall(
          getChannel(), getVisitorRegisterMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RegistrationBookFutureStub extends io.grpc.stub.AbstractStub<RegistrationBookFutureStub> {
    private RegistrationBookFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegistrationBookFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationBookFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegistrationBookFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *UNARY RPC
     *Client sends a reader's ID to register their visit in the system. The system returns a confirmation message.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.registration.VisitorRegistrationResponse> visitorRegister(
        generated.registration.VisitorRegistrationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getVisitorRegisterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VISITOR_REGISTER = 0;
  private static final int METHODID_BOOK_REGISTER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegistrationBookImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegistrationBookImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VISITOR_REGISTER:
          serviceImpl.visitorRegister((generated.registration.VisitorRegistrationRequest) request,
              (io.grpc.stub.StreamObserver<generated.registration.VisitorRegistrationResponse>) responseObserver);
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
        case METHODID_BOOK_REGISTER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bookRegister(
              (io.grpc.stub.StreamObserver<generated.registration.BookRegistrationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RegistrationBookBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegistrationBookBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.registration.RegistrationImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegistrationBook");
    }
  }

  private static final class RegistrationBookFileDescriptorSupplier
      extends RegistrationBookBaseDescriptorSupplier {
    RegistrationBookFileDescriptorSupplier() {}
  }

  private static final class RegistrationBookMethodDescriptorSupplier
      extends RegistrationBookBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegistrationBookMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegistrationBookGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegistrationBookFileDescriptorSupplier())
              .addMethod(getBookRegisterMethod())
              .addMethod(getVisitorRegisterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
