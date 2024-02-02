package com.Bootcamp.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bootcamp.Service.CandidateService;
import com.Bootcamp.Service.EvaluatorService;
import com.Bootcamp.Service.FeedbackService;
import com.Bootcamp.model.Candidate;
import com.Bootcamp.model.Evaluator;





@Controller
public class EvaluatorController 
{
	@Autowired
	CandidateService candidateService;

	@Autowired
	EvaluatorService evaluatorService;
	
	@Autowired
	FeedbackService feedbackService;
	


	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		List<Candidate> list = candidateService.findAll();
		
		model.addAttribute("candidatelist", list);
		return "candidatelist";
	}
	@RequestMapping("/login")
	public String login(Model model,@RequestParam String DasID,@RequestParam String Password,HttpSession httpSession ) 
	{
		try 
		{
			Evaluator evaluator = evaluatorService.doLogin(DasID, Password);
			httpSession.setAttribute("curr_user", evaluator);
			return "redirect:/test/home";
		}
		catch(Exception e) 
		{
			model.addAttribute("error", "Invalid DAS Id or Password");
			return "index";
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) 
	{
		httpSession.invalidate();
		return "redirect:/test/";
	}
}

