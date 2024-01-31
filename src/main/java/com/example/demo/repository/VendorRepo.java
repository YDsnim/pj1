package com.example.demo.repository;

import com.example.demo.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepo extends JpaRepository <Vendor,String>{

    @Query("select i from Vendor i where i.vendorName=:name")
    Vendor findbyName(@Param("name") String name);

}
