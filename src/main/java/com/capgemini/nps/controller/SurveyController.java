package com.capgemini.nps.controller;

import com.capgemini.nps.entity.Survey;
import com.capgemini.nps.service.SurveyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/survey")
@RestController
@CrossOrigin(origins = "*")
public class SurveyController {

	private final SurveyService surveyService;

	public SurveyController(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	@PostMapping
	public void addSurvey(@RequestBody Survey survey) {
		// TODO Convert Eklenecek
		surveyService.saveSurvey(survey);

	}

	@GetMapping
	public List<Survey> findAllSurveys() {
		return surveyService.getSurveys();
	}
}
