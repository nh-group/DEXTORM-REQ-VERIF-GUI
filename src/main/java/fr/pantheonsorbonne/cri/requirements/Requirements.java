// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/requirements.proto

package fr.pantheonsorbonne.cri.requirements;

public final class Requirements {
  private Requirements() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_requirements_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_requirements_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_requirements_Requirement_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_requirements_Requirement_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_requirements_AgentConfig_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_requirements_AgentConfig_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\030proto/requirements.proto\022\014requirements" +
      "\"\007\n\005Empty\"+\n\013Requirement\022\n\n\002id\030\001 \001(\t\022\020\n\010" +
      "issueURI\030\002 \001(\t\"9\n\013AgentConfig\022\023\n\013project" +
      "Name\030\001 \001(\t\022\025\n\rprojectGHPath\030\002 \001(\t2\234\001\n\014Re" +
      "qCollector\022E\n\017pushRequirement\022\031.requirem" +
      "ents.Requirement\032\023.requirements.Empty\"\000(" +
      "\001\022E\n\017pullRequirement\022\023.requirements.Empt" +
      "y\032\031.requirements.Requirement\"\0000\0012`\n\022Agen" +
      "tConfiguration\022J\n\026pushAgentConfiguration" +
      "\022\031.requirements.AgentConfig\032\023.requiremen" +
      "ts.Empty\"\000B@\n<fr.pantheonsorbonne.cri.fr" +
      ".pantheonsorbonne.cri.requirementsP\001b\006pr" +
      "oto3"
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
    internal_static_requirements_Empty_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_requirements_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_requirements_Empty_descriptor,
        new String[] { });
    internal_static_requirements_Requirement_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_requirements_Requirement_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_requirements_Requirement_descriptor,
        new String[] { "Id", "IssueURI", });
    internal_static_requirements_AgentConfig_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_requirements_AgentConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_requirements_AgentConfig_descriptor,
        new String[] { "ProjectName", "ProjectGHPath", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
