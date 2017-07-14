package com.xinle.grpc;

import com.xinle.protolearn.*;
import io.grpc.stub.StreamObserver;

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
}
