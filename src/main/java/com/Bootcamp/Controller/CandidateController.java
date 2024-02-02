package com.Bootcamp.Controller;

import java.io.IOException;   
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Bootcamp.Service.CandidateService;
import com.Bootcamp.Service.FeedbackService;
import com.Bootcamp.model.Candidate;
import com.Bootcamp.model.Feedback;






@Controller
@RequestMapping("/candidate")
public class CandidateController 
{
	@Autowired
	CandidateService candidateService;
	
	@Autowired
	FeedbackService feedbackService;
	
	public static String uploadDirectory = "C:\\Users\\a881546\\eclipse-workspace\\CandidateEvaluation\\src\\main\\webapp\\WEB-INF\\resources\\resume";
	
	
	@GetMapping(value = "/list")  
  public ModelAndView list()
  {
      ModelAndView mv = new ModelAndView();
      mv.addObject("candidate",new Candidate());
      mv.addObject("candidatelist", candidateService.findAll());
     
      mv.setViewName("candidatelist"); 
      return mv;
  }

	@RequestMapping("/search")
	public String search(@RequestParam String c_Name,Model model)
	{
		List<Candidate> list = candidateService.findByName(c_Name);
		list.forEach(candidate->candidate.setCandidateFeedback(feedbackService.findByCandidate(candidate.getC_ID())));
		model.addAttribute("candidatelist", list);
		return "candidatelist";
	}

	@RequestMapping("/delete/{c_ID}")
	public String delete(@PathVariable Long c_ID)
	{
		candidateService.delete(c_ID);
		return "redirect:/test/candidate/list";
	}
	@RequestMapping("/add")
	public String add(Model model)
	{
		model.addAttribute("candidate", new Candidate());
		return "feedbackform";
	}
	
	@RequestMapping("/edit/{c_ID}")
	public String edit(@PathVariable int c_ID,Model model)
	{
		Candidate candidate = candidateService.findById(c_ID);
		
		
		model.addAttribute("candidate", candidate);
		return "editform";
	}
		
	@PostMapping("/update")

	public String  update(Candidate candidate,@RequestParam("resume") MultipartFile file,Model m) throws IOException
	{
	    try
	    {
	        System.out.println(candidate);
 System.out.println(file.getOriginalFilename());
	        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
	        String filename = candidate.getC_Name().replaceAll(" ", "_")+extension;
	        Path fileNameAndPath = Paths.get(uploadDirectory,filename);
	        Files.write(fileNameAndPath, file.getBytes());
	        candidate.setC_Resume(filename);

	        System.out.println(candidate);

	       candidateService.update(candidate);
	    }
	    catch(DuplicateKeyException e)
	    {
	    	   System.out.println(e.getRootCause());	           
	           String duplicateKeyMsg = e.getRootCause().toString();	            	    
	           int startIndex = duplicateKeyMsg.lastIndexOf("' for key '") + 11;
	           int endIndex = duplicateKeyMsg.lastIndexOf("'");	
	           String keyName = duplicateKeyMsg.substring(startIndex, endIndex);	           
	           System.out.println(keyName);	           
	           if(keyName.equals("candidate.c_Phone"))
	           {
	           m.addAttribute("error", "Phone number already exists.....!");

	           }	          
	          else {
	               m.addAttribute("error","Email Id already exits try anonther one......!");
	           }
	           return "feedbackform";
	       }
	    return "redirect:/test/candidate/list";

	}
	
	
	@PostMapping("/save")

	public String  save(Candidate candidate,@RequestParam("resume") MultipartFile file,Model m) throws IOException
	{
	    try
	    {
	        System.out.println(candidate);
 System.out.println(file.getOriginalFilename());
	        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
	        String filename = candidate.getC_Name().replaceAll(" ", "_")+extension;
	        Path fileNameAndPath = Paths.get(uploadDirectory,filename);
	        Files.write(fileNameAndPath, file.getBytes());
	        candidate.setC_Resume(filename);

	        System.out.println(candidate);

	       candidateService.add(candidate);
	    }
	    catch(DuplicateKeyException e)
	    {
	    	   System.out.println(e.getRootCause());	           
	           String duplicateKeyMsg = e.getRootCause().toString();	            	    
	           int startIndex = duplicateKeyMsg.lastIndexOf("' for key '") + 11;
	           int endIndex = duplicateKeyMsg.lastIndexOf("'");	
	           String keyName = duplicateKeyMsg.substring(startIndex, endIndex);	           
	           System.out.println(keyName);	           
	           if(keyName.equals("candidate.c_Phone"))
	           {
	           m.addAttribute("error", "Phone number already exists.....!");

	           }	          
	          else {
	               m.addAttribute("error","Email Id already exits try anonther one......!");
	           }
	           return "feedbackform";
	       }
	    return "redirect:/test/candidate/list";

	}
	
	
	
	  @GetMapping("/view/{c_ID}")

	    public ModelAndView details(@PathVariable int c_ID)

	    {

	        ModelAndView mv = new ModelAndView();

	        mv.setViewName("candidatefeedback");

	        Candidate candidate = candidateService.findById(c_ID);

	        List<Feedback> fList = feedbackService.findByCandidate(c_ID);

	        candidate.setCandidateFeedback(fList);
	        boolean flag = candidate.getCandidateFeedback().stream().anyMatch(f->f.getFeedbackStatus().equals("notselected")||f.getF_ScreeningLevel().equals("L3"));
	        System.out.println(flag);
	        mv.addObject("Feedback",flag);
	        
	        mv.addObject(candidate);
	        return mv;
	    }
	  
	  
	  
	@RequestMapping("/selected")
	public String selected(Model model) {
		List<Candidate> list = candidateService.findSeleted();
		model.addAttribute("candidatelist", list);
		return "candidatelist";
	}

	@RequestMapping("/notselected")
	public String notselected(Model model) {
		List<Candidate> list = candidateService.findNotSeleted();
		model.addAttribute("candidatelist", list);
		return "canidatelist";
	}
	

}