package com.xinle.grpc;

import com.xinle.protolearn.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

/**
 * Created by xinle on 7/13/17.
 */
public class GrpcServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getRealnameByusername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接受的客户端信息" + request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentAge request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接收到客户端消息" + request.getAge());


        responseObserver.onNext(StudentResponse.newBuilder().setAge(16).setCity("beijing").setName("张三").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(16).setCity("shanghai").setName("李四").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(16).setCity("shenzhen").setName("王五").build());
        responseObserver.onNext(StudentResponse.newBuilder().setAge(16).setCity("guangzhou").setName("赵六").build());
        responseObserver.onCompleted();
    }


    @Override
    public StreamObserver<StudentAge> getStudentWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {

        return new StreamObserver<StudentAge>() {
            @Override
            public void onNext(StudentAge value) {

                System.out.println("onNext" + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {

                StudentResponse studentResponse = StudentResponse.newBuilder().setName("张三").setAge(18).setCity("广州").build();
                StudentResponse studentResponse1 = StudentResponse.newBuilder().setName("小明").setAge(19).setCity("白云").build();

                StudentResponseList studentResponseList = StudentResponseList.newBuilder().
                        addStudentResponse(studentResponse).addStudentResponse(studentResponse1).build();

                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();


            }
        };
    }


    @Override
    public StreamObserver<StreamRequest> bitalk(StreamObserver<StreamResponse> responseObserver) {


        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {

                System.out.println(value.getRequestInfo());

                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());

            }

            @Override
            public void onError(Throwable t) {

                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {

                responseObserver.onCompleted();

            }
        };




    }
}
