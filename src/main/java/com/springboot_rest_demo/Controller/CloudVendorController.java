package com.springboot_rest_demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_rest_demo.Service.CloudVendorService;
import com.springboot_rest_demo.model.CloudVendor;
import com.springboot_rest_demo.response.ResponseHandler;

import io.swagger.v3.oas.annotations.Operation;

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
	@Operation(description = "To get particular vendor details by passing vendorId")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable ("vendorId") String vendorId) { 
		
		return ResponseHandler.responseBuilder("Requested CloudVendor details are given here", 
											HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
		//return cloudVendorService.getCloudVendor(vendorId);
	
	};

	/*
	 * http://localhost:8080/cloudvendor/1 { "vendorId": "1", "vendorName": "abc",
	 * "vendorAddress": "Address2", "vendorPhoneNumber": "123456789" }
	 */
	// Read All the Vendor id details present in DB
	@GetMapping()
	@Operation(description = "To get all vendor details present in DB")
	public List<CloudVendor> getAllCloudVendorDetails() { 
		return cloudVendorService.getAllCloudVendors();
	
	};
	
	@PostMapping
	@Operation(description = "Add new vendor details by passing the Json object")
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.createCloudVendor(cloudVendor);
		return "Successfully added the vendor details of "+ cloudVendor;
	}

	@PutMapping
	@Operation(description = "Update the requested vendor details by passing the Json object")
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Successfully updated the vendor details ";
	}
	
	@DeleteMapping("{vendorId}")
	@Operation(description = "Deleting the vendor details by passing vendorId")
	public String deleteCloudVendorDetails(@PathVariable ("vendorId") String vendorId) {
		cloudVendorService.deleteCloudVendor(vendorId);
		return "Successfully deleted the vendor details ";
		
	}
	
}
