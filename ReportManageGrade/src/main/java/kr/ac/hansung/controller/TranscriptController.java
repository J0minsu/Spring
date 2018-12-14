package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Transcript;
import kr.ac.hansung.service.TranscriptService;

@Controller
public class TranscriptController {
	
	@Autowired
	private TranscriptService transcriptService;
	
	//transcripts란 request올 시 아래 수행
	@RequestMapping("/transcripts")
	public String showTranscripts(Model model)	{
		List<Transcript> transcripts = transcriptService.getAnalysis();
		model.addAttribute("transcripts", transcripts);
		
		return "transcripts";
	}
	
	//transcripts란 request올 시 아래 수행
	@RequestMapping("/getchoicesemestertranscripts")
	public String showWantTranscripts(Model model,  @RequestParam(value = "year", required = false) int year ,
													@RequestParam(value = "semester", required = false) int semester)	{
		
		List<Transcript> transcripts = transcriptService.getChoiceSemesterTranscripts(year, semester);
		
		model.addAttribute("transcripts", transcripts);
		model.addAttribute("selectYear", year);
		model.addAttribute("selectSemester", semester);
		
		return "selectyeartranscript";
	}
	
	@RequestMapping("/createtranscript")
	public String createTranscript(Model model)	{
		
		//모델을 하나 만들어주고
		model.addAttribute("transcript", new Transcript());
		
		//만든 모델을 뷰에 넘겨준다.
		return "createtranscript";
	}
	
	@RequestMapping("/dotranscript")
	public String doCreate(Model model, @Valid Transcript transcript, BindingResult result)	{
		
		if(result.hasErrors())	{
			System.out.println("===Form Data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error: errors)
				System.out.println(error.getDefaultMessage());
			
			return "createtranscript";
		}
		
		
		transcriptService.insert(transcript);
		
		return "transcriptcreated";
	}
}
