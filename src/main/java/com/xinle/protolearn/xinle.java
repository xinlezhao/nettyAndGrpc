// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: xinle.proto

package com.xinle.protolearn;

public final class xinle {
  private xinle() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_xinle_protolearn_MyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xinle_protolearn_MyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_xinle_protolearn_MyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xinle_protolearn_MyResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_xinle_protolearn_StudentAge_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xinle_protolearn_StudentAge_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_xinle_protolearn_StudentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xinle_protolearn_StudentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_xinle_protolearn_StudentResponseList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_xinle_protolearn_StudentResponseList_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013xinle.proto\022\024com.xinle.protolearn\"\035\n\tM" +
      "yRequest\022\020\n\010username\030\001 \001(\t\"\036\n\nMyResponse" +
      "\022\020\n\010realname\030\002 \001(\t\"\031\n\nStudentAge\022\013\n\003age\030" +
      "\001 \001(\005\":\n\017StudentResponse\022\014\n\004name\030\001 \001(\t\022\013" +
      "\n\003age\030\002 \001(\005\022\014\n\004city\030\003 \001(\t\"U\n\023StudentResp" +
      "onseList\022>\n\017studentResponse\030\001 \003(\0132%.com." +
      "xinle.protolearn.StudentResponse2\273\002\n\016Stu" +
      "dentService\022\\\n\025GetRealnameByusername\022\037.c" +
      "om.xinle.protolearn.MyRequest\032 .com.xinl" +
      "e.protolearn.MyResponse\"\000\022_\n\020GetStudents",
      "ByAge\022 .com.xinle.protolearn.StudentAge\032" +
      "%.com.xinle.protolearn.StudentResponse\"\000" +
      "0\001\022j\n\027GetStudentWrapperByAges\022 .com.xinl" +
      "e.protolearn.StudentAge\032).com.xinle.prot" +
      "olearn.StudentResponseList\"\000(\001B\037\n\024com.xi" +
      "nle.protolearnB\005xinleP\001b\006proto3"
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
    internal_static_com_xinle_protolearn_MyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_xinle_protolearn_MyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xinle_protolearn_MyRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_com_xinle_protolearn_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_xinle_protolearn_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xinle_protolearn_MyResponse_descriptor,
        new java.lang.String[] { "Realname", });
    internal_static_com_xinle_protolearn_StudentAge_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_xinle_protolearn_StudentAge_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xinle_protolearn_StudentAge_descriptor,
        new java.lang.String[] { "Age", });
    internal_static_com_xinle_protolearn_StudentResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_xinle_protolearn_StudentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xinle_protolearn_StudentResponse_descriptor,
        new java.lang.String[] { "Name", "Age", "City", });
    internal_static_com_xinle_protolearn_StudentResponseList_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_xinle_protolearn_StudentResponseList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_xinle_protolearn_StudentResponseList_descriptor,
        new java.lang.String[] { "StudentResponse", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
