package com.xinle.grpc;

import com.xinle.protolearn.MyRequest;
import com.xinle.protolearn.MyResponse;
import com.xinle.protolearn.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Created by xinle on 7/13/17.
 */
public class GrpcClient {


    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8899).usePlaintext(true).build();


        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);

        MyResponse myResponse = blockingStub.getRealnameByusername(MyRequest.newBuilder().setUsername("zhangsan").build());

        System.out.println(myResponse.getRealname());


    }




}
