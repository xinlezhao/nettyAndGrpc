package com.xinle.grpc;

import com.xinle.protolearn.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

/**
 * Created by xinle on 7/13/17.
 */
public class GrpcClient {


    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8899).usePlaintext(true).build();

        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        MyResponse myResponse = blockingStub.getRealnameByusername(MyRequest.newBuilder().setUsername("zhangsan").build());
        System.out.println(myResponse.getRealname());
        System.out.println("-------------------------------");
        Iterator<StudentResponse> responseIterator = blockingStub.getStudentsByAge(StudentAge.newBuilder().setAge(16).build());
        while (responseIterator.hasNext()){
            StudentResponse studentResponse = responseIterator.next();
            System.out.println(studentResponse.getName() + ", " + studentResponse.getCity() + ", " + studentResponse.getAge());
        }
        System.out.println("-------------------------------");

    }

}
