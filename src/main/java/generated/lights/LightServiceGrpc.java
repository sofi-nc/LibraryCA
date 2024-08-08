package generated.lights;

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
    comments = "Source: lighting.proto")
public final class LightServiceGrpc {

  private LightServiceGrpc() {}

  public static final String SERVICE_NAME = "lighting.LightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.lights.LightLevel,
      generated.lights.AverageResponse> getAverageLightingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "averageLighting",
      requestType = generated.lights.LightLevel.class,
      responseType = generated.lights.AverageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.lights.LightLevel,
      generated.lights.AverageResponse> getAverageLightingMethod() {
    io.grpc.MethodDescriptor<generated.lights.LightLevel, generated.lights.AverageResponse> getAverageLightingMethod;
    if ((getAverageLightingMethod = LightServiceGrpc.getAverageLightingMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getAverageLightingMethod = LightServiceGrpc.getAverageLightingMethod) == null) {
          LightServiceGrpc.getAverageLightingMethod = getAverageLightingMethod = 
              io.grpc.MethodDescriptor.<generated.lights.LightLevel, generated.lights.AverageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lighting.LightService", "averageLighting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.lights.LightLevel.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.lights.AverageResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("averageLighting"))
                  .build();
          }
        }
     }
     return getAverageLightingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.lights.LightRequest,
      generated.lights.StatusResponse> getLightControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lightControl",
      requestType = generated.lights.LightRequest.class,
      responseType = generated.lights.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.lights.LightRequest,
      generated.lights.StatusResponse> getLightControlMethod() {
    io.grpc.MethodDescriptor<generated.lights.LightRequest, generated.lights.StatusResponse> getLightControlMethod;
    if ((getLightControlMethod = LightServiceGrpc.getLightControlMethod) == null) {
      synchronized (LightServiceGrpc.class) {
        if ((getLightControlMethod = LightServiceGrpc.getLightControlMethod) == null) {
          LightServiceGrpc.getLightControlMethod = getLightControlMethod = 
              io.grpc.MethodDescriptor.<generated.lights.LightRequest, generated.lights.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lighting.LightService", "lightControl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.lights.LightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.lights.StatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightServiceMethodDescriptorSupplier("lightControl"))
                  .build();
          }
        }
     }
     return getLightControlMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightServiceStub newStub(io.grpc.Channel channel) {
    return new LightServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class LightServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * client-streaming RPC
     * client sends continuous input on the light level in the building
     * server processes the information and, when reaching a specific level, returns a message
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.lights.LightLevel> averageLighting(
        io.grpc.stub.StreamObserver<generated.lights.AverageResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAverageLightingMethod(), responseObserver);
    }

    /**
     * <pre>
     * unary RPC
     * client sends one message to either turn on the lights or turn them off
     * server sends back a single confirmation message
     * </pre>
     */
    public void lightControl(generated.lights.LightRequest request,
        io.grpc.stub.StreamObserver<generated.lights.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLightControlMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAverageLightingMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                generated.lights.LightLevel,
                generated.lights.AverageResponse>(
                  this, METHODID_AVERAGE_LIGHTING)))
          .addMethod(
            getLightControlMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.lights.LightRequest,
                generated.lights.StatusResponse>(
                  this, METHODID_LIGHT_CONTROL)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LightServiceStub extends io.grpc.stub.AbstractStub<LightServiceStub> {
    private LightServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * client-streaming RPC
     * client sends continuous input on the light level in the building
     * server processes the information and, when reaching a specific level, returns a message
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.lights.LightLevel> averageLighting(
        io.grpc.stub.StreamObserver<generated.lights.AverageResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAverageLightingMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * unary RPC
     * client sends one message to either turn on the lights or turn them off
     * server sends back a single confirmation message
     * </pre>
     */
    public void lightControl(generated.lights.LightRequest request,
        io.grpc.stub.StreamObserver<generated.lights.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLightControlMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LightServiceBlockingStub extends io.grpc.stub.AbstractStub<LightServiceBlockingStub> {
    private LightServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary RPC
     * client sends one message to either turn on the lights or turn them off
     * server sends back a single confirmation message
     * </pre>
     */
    public generated.lights.StatusResponse lightControl(generated.lights.LightRequest request) {
      return blockingUnaryCall(
          getChannel(), getLightControlMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class LightServiceFutureStub extends io.grpc.stub.AbstractStub<LightServiceFutureStub> {
    private LightServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary RPC
     * client sends one message to either turn on the lights or turn them off
     * server sends back a single confirmation message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.lights.StatusResponse> lightControl(
        generated.lights.LightRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLightControlMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIGHT_CONTROL = 0;
  private static final int METHODID_AVERAGE_LIGHTING = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIGHT_CONTROL:
          serviceImpl.lightControl((generated.lights.LightRequest) request,
              (io.grpc.stub.StreamObserver<generated.lights.StatusResponse>) responseObserver);
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
        case METHODID_AVERAGE_LIGHTING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.averageLighting(
              (io.grpc.stub.StreamObserver<generated.lights.AverageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.lights.LightServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightService");
    }
  }

  private static final class LightServiceFileDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier {
    LightServiceFileDescriptorSupplier() {}
  }

  private static final class LightServiceMethodDescriptorSupplier
      extends LightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightServiceFileDescriptorSupplier())
              .addMethod(getAverageLightingMethod())
              .addMethod(getLightControlMethod())
              .build();
        }
      }
    }
    return result;
  }
}
