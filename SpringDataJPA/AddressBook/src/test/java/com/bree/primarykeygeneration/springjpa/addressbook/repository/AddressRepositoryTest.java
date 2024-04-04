package com.bree.primarykeygeneration.springjpa.addressbook.repository;

import com.bree.primarykeygeneration.springjpa.addressbook.entity.Addresses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.bree.primarykeygeneration.springjpa.addressbook.entity.Addresses.saved;

@SpringBootTest
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveMethod(){

        //create an object of class Addresses
        Addresses addresses = new Addresses();
        addresses.setCity("Southfield");
        addresses.setCountry("USA");
        addresses.setState("Michigan");
        addresses.setZip_code("011-0012");

        //save the object
        saved = addressRepository.save(addresses);

        System.out.println(saved.getId());
        System.out.println(saved.toString());
    }

    @Test
    void updateUsingSaveMethod(){
        //find the entity by id
        Long id = 1L;
        Addresses addresses = addressRepository.findById(id).get();

        //updatethe entity informtion
        addresses.setState("Texas");
        addresses.setCity("Warren");

        addressRepository.save(addresses);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Addresses addresses = addressRepository.findById(id).get();
    }

    @Test
    void saveAllMethod(){

        Addresses addresses1 = new Addresses();
        addresses1.setCity("Nairobi");
        addresses1.setCountry("Kenya");
        addresses1.setState("Runda");
        addresses1.setZip_code("0012");

        Addresses addresses2 = new Addresses();
        addresses2.setCity("Southern");
        addresses2.setCountry("Libia");
        addresses2.setState("Karen");
        addresses2.setZip_code("01234");

        Addresses addresses3 = new Addresses();
        addresses3.setCity("Nakuru");
        addresses3.setCountry("Kenya");
        addresses3.setState("Naivasha");
        addresses3.setZip_code("Naks002");

        addressRepository.saveAll(List.of(addresses1,addresses2,addresses3));
    }

    @Test
    void findAllMethod(){
        List<Addresses> addresses = addressRepository.findAll();

        addresses.forEach((p) ->{
                    System.out.println(p.getCountry());
                });
    }

    @Test
    void existsByIdMethod(){
        Long id = 102L;
        boolean result = addressRepository.existsById(id);
        System.out.println(result);
    }
}


