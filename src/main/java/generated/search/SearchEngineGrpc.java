package generated.search;

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
    comments = "Source: searchEngine.proto")
public final class SearchEngineGrpc {

  private SearchEngineGrpc() {}

  public static final String SERVICE_NAME = "searchEngine.SearchEngine";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.search.ListBy,
      generated.search.AvailableBooks> getAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "availability",
      requestType = generated.search.ListBy.class,
      responseType = generated.search.AvailableBooks.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.search.ListBy,
      generated.search.AvailableBooks> getAvailabilityMethod() {
    io.grpc.MethodDescriptor<generated.search.ListBy, generated.search.AvailableBooks> getAvailabilityMethod;
    if ((getAvailabilityMethod = SearchEngineGrpc.getAvailabilityMethod) == null) {
      synchronized (SearchEngineGrpc.class) {
        if ((getAvailabilityMethod = SearchEngineGrpc.getAvailabilityMethod) == null) {
          SearchEngineGrpc.getAvailabilityMethod = getAvailabilityMethod = 
              io.grpc.MethodDescriptor.<generated.search.ListBy, generated.search.AvailableBooks>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "searchEngine.SearchEngine", "availability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.search.ListBy.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.search.AvailableBooks.getDefaultInstance()))
                  .setSchemaDescriptor(new SearchEngineMethodDescriptorSupplier("availability"))
                  .build();
          }
        }
     }
     return getAvailabilityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.search.userID,
      generated.search.userInformation> getReaderInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "readerInfo",
      requestType = generated.search.userID.class,
      responseType = generated.search.userInformation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.search.userID,
      generated.search.userInformation> getReaderInfoMethod() {
    io.grpc.MethodDescriptor<generated.search.userID, generated.search.userInformation> getReaderInfoMethod;
    if ((getReaderInfoMethod = SearchEngineGrpc.getReaderInfoMethod) == null) {
      synchronized (SearchEngineGrpc.class) {
        if ((getReaderInfoMethod = SearchEngineGrpc.getReaderInfoMethod) == null) {
          SearchEngineGrpc.getReaderInfoMethod = getReaderInfoMethod = 
              io.grpc.MethodDescriptor.<generated.search.userID, generated.search.userInformation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "searchEngine.SearchEngine", "readerInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.search.userID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.search.userInformation.getDefaultInstance()))
                  .setSchemaDescriptor(new SearchEngineMethodDescriptorSupplier("readerInfo"))
                  .build();
          }
        }
     }
     return getReaderInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SearchEngineStub newStub(io.grpc.Channel channel) {
    return new SearchEngineStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SearchEngineBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SearchEngineBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SearchEngineFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SearchEngineFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SearchEngineImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * This service allows the client  to see a list of available books.
     * The user can list the books by author, by title or by book ID
     * server returns a list of books ordered by the selected parameter
     * </pre>
     */
    public void availability(generated.search.ListBy request,
        io.grpc.stub.StreamObserver<generated.search.AvailableBooks> responseObserver) {
      asyncUnimplementedUnaryCall(getAvailabilityMethod(), responseObserver);
    }

    /**
     * <pre>
     * client sends 1 integer (user id)
     * server sends back the user's information 
     * </pre>
     */
    public void readerInfo(generated.search.userID request,
        io.grpc.stub.StreamObserver<generated.search.userInformation> responseObserver) {
      asyncUnimplementedUnaryCall(getReaderInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAvailabilityMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                generated.search.ListBy,
                generated.search.AvailableBooks>(
                  this, METHODID_AVAILABILITY)))
          .addMethod(
            getReaderInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.search.userID,
                generated.search.userInformation>(
                  this, METHODID_READER_INFO)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SearchEngineStub extends io.grpc.stub.AbstractStub<SearchEngineStub> {
    private SearchEngineStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchEngineStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchEngineStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchEngineStub(channel, callOptions);
    }

    /**
     * <pre>
     * This service allows the client  to see a list of available books.
     * The user can list the books by author, by title or by book ID
     * server returns a list of books ordered by the selected parameter
     * </pre>
     */
    public void availability(generated.search.ListBy request,
        io.grpc.stub.StreamObserver<generated.search.AvailableBooks> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAvailabilityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * client sends 1 integer (user id)
     * server sends back the user's information 
     * </pre>
     */
    public void readerInfo(generated.search.userID request,
        io.grpc.stub.StreamObserver<generated.search.userInformation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReaderInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SearchEngineBlockingStub extends io.grpc.stub.AbstractStub<SearchEngineBlockingStub> {
    private SearchEngineBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchEngineBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchEngineBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchEngineBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * This service allows the client  to see a list of available books.
     * The user can list the books by author, by title or by book ID
     * server returns a list of books ordered by the selected parameter
     * </pre>
     */
    public java.util.Iterator<generated.search.AvailableBooks> availability(
        generated.search.ListBy request) {
      return blockingServerStreamingCall(
          getChannel(), getAvailabilityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * client sends 1 integer (user id)
     * server sends back the user's information 
     * </pre>
     */
    public generated.search.userInformation readerInfo(generated.search.userID request) {
      return blockingUnaryCall(
          getChannel(), getReaderInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SearchEngineFutureStub extends io.grpc.stub.AbstractStub<SearchEngineFutureStub> {
    private SearchEngineFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SearchEngineFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchEngineFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SearchEngineFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * client sends 1 integer (user id)
     * server sends back the user's information 
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.search.userInformation> readerInfo(
        generated.search.userID request) {
      return futureUnaryCall(
          getChannel().newCall(getReaderInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AVAILABILITY = 0;
  private static final int METHODID_READER_INFO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SearchEngineImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SearchEngineImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AVAILABILITY:
          serviceImpl.availability((generated.search.ListBy) request,
              (io.grpc.stub.StreamObserver<generated.search.AvailableBooks>) responseObserver);
          break;
        case METHODID_READER_INFO:
          serviceImpl.readerInfo((generated.search.userID) request,
              (io.grpc.stub.StreamObserver<generated.search.userInformation>) responseObserver);
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

  private static abstract class SearchEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SearchEngineBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.search.SearchEngineImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SearchEngine");
    }
  }

  private static final class SearchEngineFileDescriptorSupplier
      extends SearchEngineBaseDescriptorSupplier {
    SearchEngineFileDescriptorSupplier() {}
  }

  private static final class SearchEngineMethodDescriptorSupplier
      extends SearchEngineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SearchEngineMethodDescriptorSupplier(String methodName) {
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
      synchronized (SearchEngineGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SearchEngineFileDescriptorSupplier())
              .addMethod(getAvailabilityMethod())
              .addMethod(getReaderInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
