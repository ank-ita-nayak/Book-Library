package com.cttc.booklibrary.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cttc.booklibrary.model.LibraryMaster;
import com.cttc.booklibrary.model.RegistrationDetails;
import com.cttc.booklibrary.model.SubscriptionMaster;
import com.cttc.booklibrary.service.LibraryService;
import com.cttc.booklibrary.service.RegistrationService;
import com.cttc.booklibrary.service.SubscriptionService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/menu")
public class BookLibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@Autowired
	RegistrationService registrationService;
	
	@GetMapping("/homepage")
	public String homePage(Model model) {
		
		List<LibraryMaster> libraryList= libraryService.getAllLibraryList();
		
		
		List<RegistrationDetails> regList = registrationService.getAllRegistration();
		
		model.addAttribute("lbList", libraryList);
	    
	    model.addAttribute("regList",regList);
		return "index";
	}
	@PostMapping("/register")
	public String registerBook(@RequestParam("lId") Integer lId,
							   @RequestParam("subId") Integer subId,
							   @RequestParam("name") String name,
							   @RequestParam("email") String email,
							   @RequestParam("mobileNo") String mobileNo,
							   @RequestParam("dob") String dob,
							   @RequestParam("gender") String gender,
							   @RequestParam("photoFile") MultipartFile photoFile) {
		 
		System.out.println(lId);
		System.out.println(subId);
		System.out.println(name);
		System.out.println(email);
		System.out.println(mobileNo);
		System.out.println(dob);
		System.out.println(gender);
		System.out.println(photoFile.getOriginalFilename());
		
		RegistrationDetails details = new RegistrationDetails();
		
		LibraryMaster selectedLibrary = libraryService.getSelectedLibrary(lId);
		
		SubscriptionMaster selectedSub = subscriptionService.getSelectedSub(subId);
				
		details.setLibraryMaster(selectedLibrary);
		details.setSubscriptionMaster(selectedSub);
		details.setApplicantName(name);
		details.setEmailId(email);
		details.setMobileNo(mobileNo);
		details.setDob(dob);
		details.setGender(gender);
		details.setImagePath(photoFile.getOriginalFilename());
		details.setIsDeleted(0);
		
		RegistrationDetails saveDetails = registrationService.saveDetails(details);
		return "redirect:./homepage";
	}
	@PostMapping("/getSubscription")
	public void getSubscription(@RequestParam("libId") Integer lId,HttpServletResponse response) throws IOException {
		
		List<SubscriptionMaster> subscriptionList = subscriptionService.getSubscriptionListByLibId(lId);
		
		System.out.println("hi"+lId);
		System.out.println(subscriptionList);
		String option = "<option value='-1'>-- Select --</option value>";
		for(SubscriptionMaster x : subscriptionList) {
			 
			option = option + "<option value='"+x.getSubscriptionId()+"'>"+x.getSubscriptionType()+"</option>";
		}
		response.getWriter().print(option);//getWriter()=can only take string
	}
	@GetMapping("/delete")
	public String softDeleteDetails(@RequestParam("uId") Integer regId) {
		
		RegistrationDetails toBeDeletedObj = registrationService.getDetailsById(regId);
		RegistrationDetails deletedObj = registrationService.deleteDetails(toBeDeletedObj);
		
		return "redirect:./homepage";//after deletion return to homepage
	}	
	}
