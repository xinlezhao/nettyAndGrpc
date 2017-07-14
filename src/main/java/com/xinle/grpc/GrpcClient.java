package com.xinle.grpc;

import com.xinle.protolearn.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;

/**
 * Created by xinle on 7/13/17.
 */
public class GrpcClient {


    public static void main(String[] args) throws InterruptedException {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8899).usePlaintext(true).build();

        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        StudentServiceGrpc.StudentServiceStub studentServiceStub = StudentServiceGrpc.newStub(managedChannel);
        MyResponse myResponse = blockingStub.getRealnameByusername(MyRequest.newBuilder().setUsername("zhangsan").build());
        System.out.println(myResponse.getRealname());
        System.out.println("-------------------------------");
        Iterator<StudentResponse> responseIterator = blockingStub.getStudentsByAge(StudentAge.newBuilder().setAge(16).build());
        while (responseIterator.hasNext()){
            StudentResponse studentResponse = responseIterator.next();
            System.out.println(studentResponse.getName() + ", " + studentResponse.getCity() + ", " + studentResponse.getAge());
        }
        System.out.println("-------------------------------");


        StreamObserver<StudentResponseList> studentResponseListStreamObserver =new StreamObserver<StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList value) {

                value.getStudentResponseList().forEach(studentResponse -> {
                    System.out.println(studentResponse.getName());
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                    System.out.println("*********************");
                });

            }

            @Override
            public void onError(Throwable t) {

                System.out.println(t.getMessage());

            }

            @Override
            public void onCompleted() {

                System.out.println("completed");

            }
        };


        StreamObserver<StudentAge> studentAgeStreamObserver = studentServiceStub.getStudentWrapperByAges(studentResponseListStreamObserver);
        studentAgeStreamObserver.onNext(StudentAge.newBuilder().setAge(20).build());
        studentAgeStreamObserver.onNext(StudentAge.newBuilder().setAge(21).build());
        studentAgeStreamObserver.onNext(StudentAge.newBuilder().setAge(22).build());
        studentAgeStreamObserver.onNext(StudentAge.newBuilder().setAge(23).build());
        studentAgeStreamObserver.onNext(StudentAge.newBuilder().setAge(24).build());
        studentAgeStreamObserver.onNext(StudentAge.newBuilder().setAge(25).build());
        studentAgeStreamObserver.onCompleted();

        Thread.sleep(50000);


    }

}
