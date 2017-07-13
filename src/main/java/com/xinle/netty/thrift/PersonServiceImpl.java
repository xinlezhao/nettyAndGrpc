package com.xinle.netty.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

import java.util.stream.Stream;

/**
 * Created by xinle on 7/11/17.
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUserName(String username) throws DataException, TException {
        System.out.println("Got Client Param" + username);
        Person person = new Person();
        person.setAge(20);
        person.setUsername(username);
        person.setMarried(false);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {

        System.out.println("Got Client Param ");
        System.out.println(person.getUsername());
        Stream.of(person).map(Person::getUsername).forEach(System.out::println);
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
