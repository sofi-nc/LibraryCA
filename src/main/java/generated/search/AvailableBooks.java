// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: searchEngine.proto

package generated.search;

/**
 * Protobuf type {@code searchEngine.AvailableBooks}
 */
public  final class AvailableBooks extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:searchEngine.AvailableBooks)
    AvailableBooksOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AvailableBooks.newBuilder() to construct.
  private AvailableBooks(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AvailableBooks() {
    bookId_ = 0;
    title_ = "";
    author_ = "";
    language_ = "";
    subject_ = "";
    bookQty_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AvailableBooks(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            bookId_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            title_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            author_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            language_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            subject_ = s;
            break;
          }
          case 48: {

            bookQty_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return generated.search.SearchEngineImpl.internal_static_searchEngine_AvailableBooks_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return generated.search.SearchEngineImpl.internal_static_searchEngine_AvailableBooks_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            generated.search.AvailableBooks.class, generated.search.AvailableBooks.Builder.class);
  }

  public static final int BOOKID_FIELD_NUMBER = 1;
  private int bookId_;
  /**
   * <code>int32 bookId = 1;</code>
   */
  public int getBookId() {
    return bookId_;
  }

  public static final int TITLE_FIELD_NUMBER = 2;
  private volatile java.lang.Object title_;
  /**
   * <code>string title = 2;</code>
   */
  public java.lang.String getTitle() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      title_ = s;
      return s;
    }
  }
  /**
   * <code>string title = 2;</code>
   */
  public com.google.protobuf.ByteString
      getTitleBytes() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      title_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AUTHOR_FIELD_NUMBER = 3;
  private volatile java.lang.Object author_;
  /**
   * <code>string author = 3;</code>
   */
  public java.lang.String getAuthor() {
    java.lang.Object ref = author_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      author_ = s;
      return s;
    }
  }
  /**
   * <code>string author = 3;</code>
   */
  public com.google.protobuf.ByteString
      getAuthorBytes() {
    java.lang.Object ref = author_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      author_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LANGUAGE_FIELD_NUMBER = 4;
  private volatile java.lang.Object language_;
  /**
   * <code>string language = 4;</code>
   */
  public java.lang.String getLanguage() {
    java.lang.Object ref = language_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      language_ = s;
      return s;
    }
  }
  /**
   * <code>string language = 4;</code>
   */
  public com.google.protobuf.ByteString
      getLanguageBytes() {
    java.lang.Object ref = language_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      language_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SUBJECT_FIELD_NUMBER = 5;
  private volatile java.lang.Object subject_;
  /**
   * <code>string subject = 5;</code>
   */
  public java.lang.String getSubject() {
    java.lang.Object ref = subject_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      subject_ = s;
      return s;
    }
  }
  /**
   * <code>string subject = 5;</code>
   */
  public com.google.protobuf.ByteString
      getSubjectBytes() {
    java.lang.Object ref = subject_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      subject_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BOOKQTY_FIELD_NUMBER = 6;
  private int bookQty_;
  /**
   * <code>int32 bookQty = 6;</code>
   */
  public int getBookQty() {
    return bookQty_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (bookId_ != 0) {
      output.writeInt32(1, bookId_);
    }
    if (!getTitleBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, title_);
    }
    if (!getAuthorBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, author_);
    }
    if (!getLanguageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, language_);
    }
    if (!getSubjectBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, subject_);
    }
    if (bookQty_ != 0) {
      output.writeInt32(6, bookQty_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (bookId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, bookId_);
    }
    if (!getTitleBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, title_);
    }
    if (!getAuthorBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, author_);
    }
    if (!getLanguageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, language_);
    }
    if (!getSubjectBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, subject_);
    }
    if (bookQty_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, bookQty_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof generated.search.AvailableBooks)) {
      return super.equals(obj);
    }
    generated.search.AvailableBooks other = (generated.search.AvailableBooks) obj;

    boolean result = true;
    result = result && (getBookId()
        == other.getBookId());
    result = result && getTitle()
        .equals(other.getTitle());
    result = result && getAuthor()
        .equals(other.getAuthor());
    result = result && getLanguage()
        .equals(other.getLanguage());
    result = result && getSubject()
        .equals(other.getSubject());
    result = result && (getBookQty()
        == other.getBookQty());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + BOOKID_FIELD_NUMBER;
    hash = (53 * hash) + getBookId();
    hash = (37 * hash) + TITLE_FIELD_NUMBER;
    hash = (53 * hash) + getTitle().hashCode();
    hash = (37 * hash) + AUTHOR_FIELD_NUMBER;
    hash = (53 * hash) + getAuthor().hashCode();
    hash = (37 * hash) + LANGUAGE_FIELD_NUMBER;
    hash = (53 * hash) + getLanguage().hashCode();
    hash = (37 * hash) + SUBJECT_FIELD_NUMBER;
    hash = (53 * hash) + getSubject().hashCode();
    hash = (37 * hash) + BOOKQTY_FIELD_NUMBER;
    hash = (53 * hash) + getBookQty();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static generated.search.AvailableBooks parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.search.AvailableBooks parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.search.AvailableBooks parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.search.AvailableBooks parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.search.AvailableBooks parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.search.AvailableBooks parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.search.AvailableBooks parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static generated.search.AvailableBooks parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static generated.search.AvailableBooks parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static generated.search.AvailableBooks parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static generated.search.AvailableBooks parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static generated.search.AvailableBooks parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(generated.search.AvailableBooks prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code searchEngine.AvailableBooks}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:searchEngine.AvailableBooks)
      generated.search.AvailableBooksOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return generated.search.SearchEngineImpl.internal_static_searchEngine_AvailableBooks_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return generated.search.SearchEngineImpl.internal_static_searchEngine_AvailableBooks_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              generated.search.AvailableBooks.class, generated.search.AvailableBooks.Builder.class);
    }

    // Construct using generated.search.AvailableBooks.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bookId_ = 0;

      title_ = "";

      author_ = "";

      language_ = "";

      subject_ = "";

      bookQty_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return generated.search.SearchEngineImpl.internal_static_searchEngine_AvailableBooks_descriptor;
    }

    @java.lang.Override
    public generated.search.AvailableBooks getDefaultInstanceForType() {
      return generated.search.AvailableBooks.getDefaultInstance();
    }

    @java.lang.Override
    public generated.search.AvailableBooks build() {
      generated.search.AvailableBooks result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public generated.search.AvailableBooks buildPartial() {
      generated.search.AvailableBooks result = new generated.search.AvailableBooks(this);
      result.bookId_ = bookId_;
      result.title_ = title_;
      result.author_ = author_;
      result.language_ = language_;
      result.subject_ = subject_;
      result.bookQty_ = bookQty_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof generated.search.AvailableBooks) {
        return mergeFrom((generated.search.AvailableBooks)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(generated.search.AvailableBooks other) {
      if (other == generated.search.AvailableBooks.getDefaultInstance()) return this;
      if (other.getBookId() != 0) {
        setBookId(other.getBookId());
      }
      if (!other.getTitle().isEmpty()) {
        title_ = other.title_;
        onChanged();
      }
      if (!other.getAuthor().isEmpty()) {
        author_ = other.author_;
        onChanged();
      }
      if (!other.getLanguage().isEmpty()) {
        language_ = other.language_;
        onChanged();
      }
      if (!other.getSubject().isEmpty()) {
        subject_ = other.subject_;
        onChanged();
      }
      if (other.getBookQty() != 0) {
        setBookQty(other.getBookQty());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      generated.search.AvailableBooks parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (generated.search.AvailableBooks) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int bookId_ ;
    /**
     * <code>int32 bookId = 1;</code>
     */
    public int getBookId() {
      return bookId_;
    }
    /**
     * <code>int32 bookId = 1;</code>
     */
    public Builder setBookId(int value) {
      
      bookId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 bookId = 1;</code>
     */
    public Builder clearBookId() {
      
      bookId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object title_ = "";
    /**
     * <code>string title = 2;</code>
     */
    public java.lang.String getTitle() {
      java.lang.Object ref = title_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        title_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string title = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTitleBytes() {
      java.lang.Object ref = title_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        title_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string title = 2;</code>
     */
    public Builder setTitle(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      title_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string title = 2;</code>
     */
    public Builder clearTitle() {
      
      title_ = getDefaultInstance().getTitle();
      onChanged();
      return this;
    }
    /**
     * <code>string title = 2;</code>
     */
    public Builder setTitleBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      title_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object author_ = "";
    /**
     * <code>string author = 3;</code>
     */
    public java.lang.String getAuthor() {
      java.lang.Object ref = author_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        author_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string author = 3;</code>
     */
    public com.google.protobuf.ByteString
        getAuthorBytes() {
      java.lang.Object ref = author_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        author_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string author = 3;</code>
     */
    public Builder setAuthor(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      author_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string author = 3;</code>
     */
    public Builder clearAuthor() {
      
      author_ = getDefaultInstance().getAuthor();
      onChanged();
      return this;
    }
    /**
     * <code>string author = 3;</code>
     */
    public Builder setAuthorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      author_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object language_ = "";
    /**
     * <code>string language = 4;</code>
     */
    public java.lang.String getLanguage() {
      java.lang.Object ref = language_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        language_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string language = 4;</code>
     */
    public com.google.protobuf.ByteString
        getLanguageBytes() {
      java.lang.Object ref = language_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        language_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string language = 4;</code>
     */
    public Builder setLanguage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      language_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string language = 4;</code>
     */
    public Builder clearLanguage() {
      
      language_ = getDefaultInstance().getLanguage();
      onChanged();
      return this;
    }
    /**
     * <code>string language = 4;</code>
     */
    public Builder setLanguageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      language_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object subject_ = "";
    /**
     * <code>string subject = 5;</code>
     */
    public java.lang.String getSubject() {
      java.lang.Object ref = subject_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        subject_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string subject = 5;</code>
     */
    public com.google.protobuf.ByteString
        getSubjectBytes() {
      java.lang.Object ref = subject_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        subject_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string subject = 5;</code>
     */
    public Builder setSubject(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      subject_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string subject = 5;</code>
     */
    public Builder clearSubject() {
      
      subject_ = getDefaultInstance().getSubject();
      onChanged();
      return this;
    }
    /**
     * <code>string subject = 5;</code>
     */
    public Builder setSubjectBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      subject_ = value;
      onChanged();
      return this;
    }

    private int bookQty_ ;
    /**
     * <code>int32 bookQty = 6;</code>
     */
    public int getBookQty() {
      return bookQty_;
    }
    /**
     * <code>int32 bookQty = 6;</code>
     */
    public Builder setBookQty(int value) {
      
      bookQty_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 bookQty = 6;</code>
     */
    public Builder clearBookQty() {
      
      bookQty_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:searchEngine.AvailableBooks)
  }

  // @@protoc_insertion_point(class_scope:searchEngine.AvailableBooks)
  private static final generated.search.AvailableBooks DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new generated.search.AvailableBooks();
  }

  public static generated.search.AvailableBooks getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AvailableBooks>
      PARSER = new com.google.protobuf.AbstractParser<AvailableBooks>() {
    @java.lang.Override
    public AvailableBooks parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AvailableBooks(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AvailableBooks> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AvailableBooks> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public generated.search.AvailableBooks getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

