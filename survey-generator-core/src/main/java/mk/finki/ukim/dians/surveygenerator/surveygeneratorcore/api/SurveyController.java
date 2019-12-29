package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.api;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.Survey;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyQuestion;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.requests.SurveyRequest;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence.SurveyQuestionRepository;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.service.SurveyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
/**
* Definiranje na kontoler za surveys
* */

@RestController
@RequestMapping(path = "/surveys")
public class SurveyController {

    private final SurveyService service;
    private final SurveyQuestionRepository repository;
/**Dependency injection by constructor */
    public SurveyController(SurveyService service, SurveyQuestionRepository repository) {
        this.service = service;
        this.repository = repository;
    }
/*Prevzemanje na site surveys*/
    @GetMapping("/all")
    public List<SurveyResponse> getSurveys() {
        return service.getAll().stream().map(it -> {
            return new SurveyResponse(it, repository.findAllBySurveyTemplateId(it.getSurveyTemplate().getId()));
        }).collect(Collectors.toList());

    }

//    Zemanje na daden survey
    @GetMapping("/{id}")
    public  SurveyResponse getSurvey(@PathVariable("id") Long id){
        Survey survey = service.get(id);
        List<SurveyQuestion> surveyQuestions = repository.findAllBySurveyTemplateId(survey.getSurveyTemplate().getId());
    return new SurveyResponse(survey, surveyQuestions);
    }
/*creiranje na survey*/
    @PostMapping("/create")
    public Survey create (@RequestBody SurveyRequest surveyRequest ){
        return service.createSurvey(surveyRequest);
    }
/*brisenje na survey*/
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }


}
