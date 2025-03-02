package com.gcu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gcu.business.UserBusinessInterface;
import com.gcu.model.UserModel;



@Controller
public class UserContoller {
    
    @Autowired
    private UserBusinessInterface userBusinessInterface;


    
    
    
   //---------------- ACCOUNT ACTIVITY ----------------//
    
    
    
    @PostMapping("/account/update")
    public String updateUser(Model model, @RequestParam int id) {
        UserModel user = userBusinessInterface.findById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }
    
    @PostMapping("/account/update/confirm")
    public String updateUserConfirm(
    		// Get parameters from the HTML form
    		@RequestParam int id,
	        @RequestParam(required = false) String firstName,
	        @RequestParam(required = false) String lastName,
	        @RequestParam(required = false) String username,
	        @RequestParam(required = false) String password,
	        @RequestParam(required = false) String email,
	        RedirectAttributes redirectAttributes
	        )
    {
    	// Get the current user information
    	UserModel user = userBusinessInterface.findById(id);
    	
    	if (firstName != null && !firstName.isBlank()) user.setFirstName(firstName);
    	if (lastName != null && !lastName.isBlank()) user.setLastName(lastName);
    	if (username != null && !username.isBlank()) user.setUsername(username);
    	if (password != null && !password.isBlank()) user.setPassword(password);
    	if (email != null && !email.isBlank()) user.setEmail(email);


    	// Update the user in the database
    	userBusinessInterface.updateUser(user);
    	
    	// Send the user back to the users page
    	return "redirect:/account";
    }
    
    @PostMapping("/account/delete")
    public String deleteUser(Model model, @RequestParam int id) {
        UserModel user = userBusinessInterface.findById(id);
        model.addAttribute("user", user);
        return "confirmDeleteAccount";
    }

    /*
    @PostMapping("/account/delete/confirm")
    public String deleteUserConfirm(Model model, @RequestParam boolean confirm) {
        if (confirm) {
        	userBusinessInterface.deleteUser(user.getId());
            String msg = "Username: " + user.getUsername() + " was Deleted";
            model.addAttribute("msg", msg);
        }
        List<UserModel> users = userBusinessInterface.findAllUsers();
        model.addAttribute("users", users);
        return "redirect:/login";
    }
    */
    
    
  //---------------- REGISTRATION ----------------//
    
    
    
    @GetMapping("/login")
    public String display(Model model)
    {
    	// Display login form view
    	model.addAttribute("title", "Login Form");
    	return "login";
    }
    
    
    
    
    //---------------- REGISTRATION ----------------//
    
    

    
    @GetMapping("/register")
    public String register() {
        return "register";
    }

	@PostMapping("/register/submitRegistration")
    public String submitRegistrationForm(@ModelAttribute UserModel user, HttpSession session) {

		userBusinessInterface.addUser(user.getFirstName(), user.getLastName(), user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), user.getEmail());
		
		return "registerSuccess";
    }
}
