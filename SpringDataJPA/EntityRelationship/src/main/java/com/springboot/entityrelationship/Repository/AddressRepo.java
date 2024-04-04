package com.springboot.entityrelationship.Repository;

import com.springboot.entityrelationship.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long>{

}
