package com.xinle.netty.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * Created by xinle on 7/11/17.
 */
public class ThrifyClient {

    public static void main(String[] args) {


        TTransport tTransport = new TFramedTransport(new TSocket("localhost", 8899),600);

        TProtocol protocol = new TCompactProtocol(tTransport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {

            tTransport.open();

            Person p = client.getPersonByUserName("李四");

            System.out.println(p.getAge());
            System.out.println(p.getUsername());
            System.out.println(p.isMarried());

            Person person = new Person();

            person.setUsername("wangwu");
            person.setAge(30);
            person.setMarried(true);

            client.savePerson(person);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }finally {
            tTransport.close();
        }




    }
}
