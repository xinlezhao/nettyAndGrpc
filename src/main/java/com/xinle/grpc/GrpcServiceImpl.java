package com.xinle.grpc;

import com.xinle.protolearn.MyRequest;
import com.xinle.protolearn.MyResponse;
import com.xinle.protolearn.StudentServiceGrpc;
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
}
