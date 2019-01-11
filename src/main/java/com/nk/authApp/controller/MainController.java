package com.nk.authApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nk.authApp.model.User;
import com.nk.authApp.repository.UserRepository;


@Controller
public class MainController {

	@Autowired
	UserRepository userRepository;
	
	private final String INFO_PAGE = "info";
	private final String REGISTER_PAGE = "register";
	private final String LOGIN_PAGE = "login";
	
	@RequestMapping("/Register")
	public ModelAndView registerPage(@ModelAttribute("emailExists") final String emailMSG
			,BindingResult bindingResult,ModelAndView modelAndView)
	{
		
		if (!bindingResult.hasErrors())
		{
			modelAndView.addObject("emailExists",emailMSG);
		}
		
		modelAndView.setViewName(REGISTER_PAGE);
		return modelAndView;
	}
	
	@RequestMapping(value = "/AddUser",method=RequestMethod.POST)
	public ModelAndView submitUser(@Valid @ModelAttribute("user")User user
			,BindingResult result
			,ModelAndView modelAndView
			,final RedirectAttributes redirectAttributes
			)
	{
		
		if(result.hasErrors())
		{
			modelAndView.setViewName(REGISTER_PAGE);
			return modelAndView;
		}
		
		User userDB = userRepository.findUserByEmail(user.getEmail());
		if(userDB == null) {
			
			//if email is not taken we store in database 
			//and redirect to login
			userRepository.save(user);
			modelAndView.setViewName("redirect:Login");
			return modelAndView;
			
		}else {
			
			//if email already exists we return an error message
			redirectAttributes.addFlashAttribute("emailExists","Email already exists");
			modelAndView.setViewName("redirect:Register");
			return modelAndView;
		}
	
	}
	
	
	@RequestMapping(value= {"/Login", "/" } )
	public ModelAndView loginPage(@ModelAttribute("userNotExist") final String userMSG
			,BindingResult bindingResult
			,ModelAndView modelAndView)
	{
		
		//we get in the if someone has sent us a userNotExist property
		if (!bindingResult.hasErrors())
			modelAndView.addObject("userNotExist",userMSG);
		
		
		
		modelAndView.setViewName(LOGIN_PAGE);
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/checkUser",method=RequestMethod.POST)
	public ModelAndView userPageCheck(@RequestParam("email") String email
			,@RequestParam("password")String password
			,ModelAndView modelAndView
			,final RedirectAttributes redirectAttributes)
	{
		
		User user = userRepository.findUserByEmailAndPassword(email,password);
		
		if (user == null) {
			
			//user with credentials does not exist so we return an error message
			redirectAttributes.addFlashAttribute("userNotExist","No user with such credentials exist");
			modelAndView.setViewName("redirect:Login");
		}
		else {
			
			//user exists and we can redirect to info
			redirectAttributes.addFlashAttribute("user",user);
			modelAndView.setViewName("redirect:userInfo");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/userInfo",method = RequestMethod.GET)
	public ModelAndView userInfo(@ModelAttribute("user") final User user
			,ModelAndView modelAndView)
	{
		//gets the information from redirects and returns 
		//the info page for the user
		
		modelAndView.addObject("user",user);
		modelAndView.setViewName(INFO_PAGE);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/UpdateUser",method = RequestMethod.POST)
	public ModelAndView updateUser(@Valid @ModelAttribute("user")User user
			,BindingResult result
			,ModelAndView modelAndView
			,final RedirectAttributes redirectAttributes)
	{
		if (result.hasErrors())
		{
			//IMPORTANT---if we uncomment user will not be able
			//to see the error messages (TODO----)
			//
			//User oldUserCredentials =  userRepository.findUserById(user.getId());
			//modelAndView.addObject("user",oldUserCredentials);
			
			modelAndView.setViewName(INFO_PAGE);
			return modelAndView;
		}
		
		User dummyUser = userRepository.findUserById(user.getId());
		if (dummyUser.getEmail() == user.getEmail())
		{
			//user did not update his email
			//we can update credentials with ease
			wrapperUpdateDB(user,modelAndView,redirectAttributes);
		}
		else {
			//user changed his email
			User oldUser = userRepository.findUserByEmail(user.getEmail());
			if (oldUser == null)
			{
				//the new email does not exist
				//update the database
				wrapperUpdateDB(user,modelAndView,redirectAttributes);
				
			}else {
				
				//send back and error message
				//new email already exists
				
				User oldUserCredentials =  userRepository.findUserById(user.getId());
				redirectAttributes.addFlashAttribute("emailExists","Email already exists");
				redirectAttributes.addFlashAttribute("user",oldUserCredentials);
			}
		}
		
		modelAndView.setViewName("redirect:userInfo");
		return modelAndView;
	}
	
	private void wrapperUpdateDB(User user,ModelAndView modelAndView,RedirectAttributes redirectAttributes)
	{
		User newUser = userRepository.save(user);
		modelAndView.addObject("user",newUser);
		redirectAttributes.addFlashAttribute("user",newUser);	
	}
	
	@RequestMapping(value = "/Disconnect",method = RequestMethod.POST)
	public ModelAndView disconnect(ModelAndView modelAndView)
	{
		modelAndView.setViewName("redirect:Login");
		return modelAndView;
	}
	
}
