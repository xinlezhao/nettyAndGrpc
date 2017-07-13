package com.xinle.netty.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import thrift.generated.PersonService;

/**
 * Created by xinle on 7/11/17.
 */
public class ThriftServer {

    public static void main(String[] args) throws Exception{

        TNonblockingServerSocket serverSocket  = new TNonblockingServerSocket(8899);
        THsHaServer.Args args1 = new THsHaServer.Args(serverSocket).minWorkerThreads(2).maxWorkerThreads(5);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());


        args1.protocolFactory(new TCompactProtocol.Factory());
        args1.transportFactory(new TFramedTransport.Factory());
        args1.processorFactory(new TProcessorFactory(processor));

        TServer server = new THsHaServer(args1);

        System.out.println("Thrift Server Started!");

        server.serve();

    }

}
