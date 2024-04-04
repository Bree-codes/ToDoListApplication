package com.bree.primarykeygeneration.springjpa.addressbook.repository;

import com.bree.primarykeygeneration.springjpa.addressbook.entity.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Addresses, Long> {

}
