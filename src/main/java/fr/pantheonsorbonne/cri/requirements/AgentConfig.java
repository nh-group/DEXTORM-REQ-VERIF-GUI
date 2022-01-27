// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/requirements.proto

package fr.pantheonsorbonne.cri.requirements;

/**
 * Protobuf type {@code requirements.AgentConfig}
 */
public  final class AgentConfig extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:requirements.AgentConfig)
        AgentConfigOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AgentConfig.newBuilder() to construct.
  private AgentConfig(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AgentConfig() {
    projectName_ = "";
    projectGHPath_ = "";
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AgentConfig(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
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
          case 10: {
            String s = input.readStringRequireUtf8();

            projectName_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            projectGHPath_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
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
    return Requirements.internal_static_requirements_AgentConfig_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Requirements.internal_static_requirements_AgentConfig_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            AgentConfig.class, AgentConfig.Builder.class);
  }

  public static final int PROJECTNAME_FIELD_NUMBER = 1;
  private volatile Object projectName_;
  /**
   * <code>string projectName = 1;</code>
   */
  public String getProjectName() {
    Object ref = projectName_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      projectName_ = s;
      return s;
    }
  }
  /**
   * <code>string projectName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getProjectNameBytes() {
    Object ref = projectName_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      projectName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PROJECTGHPATH_FIELD_NUMBER = 2;
  private volatile Object projectGHPath_;
  /**
   * <code>string projectGHPath = 2;</code>
   */
  public String getProjectGHPath() {
    Object ref = projectGHPath_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      projectGHPath_ = s;
      return s;
    }
  }
  /**
   * <code>string projectGHPath = 2;</code>
   */
  public com.google.protobuf.ByteString
      getProjectGHPathBytes() {
    Object ref = projectGHPath_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      projectGHPath_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getProjectNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, projectName_);
    }
    if (!getProjectGHPathBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, projectGHPath_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getProjectNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, projectName_);
    }
    if (!getProjectGHPathBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, projectGHPath_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof AgentConfig)) {
      return super.equals(obj);
    }
    AgentConfig other = (AgentConfig) obj;

    if (!getProjectName()
        .equals(other.getProjectName())) return false;
    if (!getProjectGHPath()
        .equals(other.getProjectGHPath())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PROJECTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getProjectName().hashCode();
    hash = (37 * hash) + PROJECTGHPATH_FIELD_NUMBER;
    hash = (53 * hash) + getProjectGHPath().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static AgentConfig parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AgentConfig parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AgentConfig parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AgentConfig parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AgentConfig parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static AgentConfig parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static AgentConfig parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AgentConfig parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static AgentConfig parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static AgentConfig parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static AgentConfig parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static AgentConfig parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(AgentConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code requirements.AgentConfig}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:requirements.AgentConfig)
          AgentConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Requirements.internal_static_requirements_AgentConfig_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Requirements.internal_static_requirements_AgentConfig_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AgentConfig.class, AgentConfig.Builder.class);
    }

    // Construct using fr.pantheonsorbonne.cri.fr.pantheonsorbonne.cri.requirements.AgentConfig.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      projectName_ = "";

      projectGHPath_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Requirements.internal_static_requirements_AgentConfig_descriptor;
    }

    @Override
    public AgentConfig getDefaultInstanceForType() {
      return AgentConfig.getDefaultInstance();
    }

    @Override
    public AgentConfig build() {
      AgentConfig result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public AgentConfig buildPartial() {
      AgentConfig result = new AgentConfig(this);
      result.projectName_ = projectName_;
      result.projectGHPath_ = projectGHPath_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof AgentConfig) {
        return mergeFrom((AgentConfig)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(AgentConfig other) {
      if (other == AgentConfig.getDefaultInstance()) return this;
      if (!other.getProjectName().isEmpty()) {
        projectName_ = other.projectName_;
        onChanged();
      }
      if (!other.getProjectGHPath().isEmpty()) {
        projectGHPath_ = other.projectGHPath_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      AgentConfig parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (AgentConfig) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private Object projectName_ = "";
    /**
     * <code>string projectName = 1;</code>
     */
    public String getProjectName() {
      Object ref = projectName_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        projectName_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string projectName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getProjectNameBytes() {
      Object ref = projectName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        projectName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string projectName = 1;</code>
     */
    public Builder setProjectName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      projectName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string projectName = 1;</code>
     */
    public Builder clearProjectName() {

      projectName_ = getDefaultInstance().getProjectName();
      onChanged();
      return this;
    }
    /**
     * <code>string projectName = 1;</code>
     */
    public Builder setProjectNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      projectName_ = value;
      onChanged();
      return this;
    }

    private Object projectGHPath_ = "";
    /**
     * <code>string projectGHPath = 2;</code>
     */
    public String getProjectGHPath() {
      Object ref = projectGHPath_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        projectGHPath_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string projectGHPath = 2;</code>
     */
    public com.google.protobuf.ByteString
        getProjectGHPathBytes() {
      Object ref = projectGHPath_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        projectGHPath_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string projectGHPath = 2;</code>
     */
    public Builder setProjectGHPath(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }

      projectGHPath_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string projectGHPath = 2;</code>
     */
    public Builder clearProjectGHPath() {

      projectGHPath_ = getDefaultInstance().getProjectGHPath();
      onChanged();
      return this;
    }
    /**
     * <code>string projectGHPath = 2;</code>
     */
    public Builder setProjectGHPathBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

      projectGHPath_ = value;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:requirements.AgentConfig)
  }

  // @@protoc_insertion_point(class_scope:requirements.AgentConfig)
  private static final AgentConfig DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new AgentConfig();
  }

  public static AgentConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AgentConfig>
      PARSER = new com.google.protobuf.AbstractParser<AgentConfig>() {
    @Override
    public AgentConfig parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AgentConfig(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AgentConfig> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<AgentConfig> getParserForType() {
    return PARSER;
  }

  @Override
  public AgentConfig getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

