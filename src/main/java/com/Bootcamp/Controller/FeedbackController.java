package com.Bootcamp.Controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Bootcamp.Service.CandidateService;
import com.Bootcamp.Service.EvaluatorService;
import com.Bootcamp.Service.FeedbackService;
import com.Bootcamp.model.Candidate;
import com.Bootcamp.model.Feedback;



@Controller
@RequestMapping("/feedback")
public class FeedbackController 
{
	@Autowired
	CandidateService candidateService;
	
	@Autowired
	EvaluatorService evaluatorService;
	
	@Autowired
	FeedbackService feedbackService;
	
	
	

	@RequestMapping("/add/{c_ID}")
	public String add(Model model,@PathVariable int c_ID)
	{
		List<String> screeninglevels = new ArrayList<>(Arrays.asList("L1","L2","L3"));

		
		Candidate candidate = candidateService.findById(c_ID);
		candidate.setCandidateFeedback(feedbackService.findByCandidate(c_ID));
		model.addAttribute("candidate", candidate);
		List<String> l1 = candidate.getCandidateFeedback().stream().map(m->m.getF_ScreeningLevel()).toList(); 
		System.out.println(screeninglevels);
		screeninglevels.removeAll(l1);
		System.out.println(screeninglevels);

		model.addAttribute("screeninglevels",screeninglevels);
		
		return "addfeedback";
	}
	@GetMapping("/form/{c_ID}")
	public String addfeedback(@PathVariable int c_ID,Model model) {
		 	Candidate candidate=candidateService.findById(c_ID);
		 	model.addAttribute(candidate);
		return "addfeedback";
	}
	@RequestMapping("/bycandidate/{c_ID}")
	public String feedbackByCandidate(@PathVariable int c_ID,Model model)
	{
		model.addAttribute("feedback", feedbackService.findByCandidate(c_ID));
		return "candidatefeedback";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute Feedback feedback)
	{
	
		System.out.println(feedback);
		feedbackService.add(feedback);
		return "redirect:/test/candidate/view/"+feedback.getC_ID();
	}

	@RequestMapping("/list")
	public String list(Model model)
	{
		model.addAttribute("feedbacklist", feedbackService.findAll());
		return "feedbacklist";
	}
	
	
}
