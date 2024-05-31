package com.thinkconstructive_rest_demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkconstructive_rest_demo.Service.CloudVendorService;
import com.thinkconstructive_rest_demo.model.CloudVendor;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
		
	//CloudVendor cloudVendor;
	CloudVendorService cloudVendorService;
	
	public CloudVendorController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}

	// Read Specific Vendor id details Present in DB
	@GetMapping("{vendorId}")
	public CloudVendor getCloudVendorDetails(@PathVariable ("vendorId") String vendorId) { 
		return cloudVendorService.getCloudVendor(vendorId);
	
	};

	/*
	 * http://localhost:8080/cloudvendor/1 { "vendorId": "1", "vendorName": "abc",
	 * "vendorAddress": "Address2", "vendorPhoneNumber": "123456789" }
	 */
	// Read All the Vendor id details present in DB
	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails() { 
		return cloudVendorService.getAllCloudVendors();
	
	};
	
	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.createCloudVendor(cloudVendor);
		return "Successfully added the vendor details of "+ cloudVendor;
	}

	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Successfully updated the vendor details ";
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable ("vendorId") String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);
		return "Successfully deleted the vendor details ";
		
	}
	
}
