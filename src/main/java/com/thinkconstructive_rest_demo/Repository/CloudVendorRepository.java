package com.thinkconstructive_rest_demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkconstructive_rest_demo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository< CloudVendor, String >{

}
