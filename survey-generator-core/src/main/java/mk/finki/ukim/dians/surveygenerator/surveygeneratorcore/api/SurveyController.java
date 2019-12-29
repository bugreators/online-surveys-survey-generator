package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.api;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.Survey;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyQuestion;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.requests.SurveyRequest;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence.SurveyQuestionRepository;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.service.SurveyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/surveys")
public class SurveyController {
    private final SurveyService service;
    private final SurveyQuestionRepository repository;

    public SurveyController(SurveyService service, SurveyQuestionRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<SurveyResponse> getSurveys() {
        return service.getAll().stream().map(it -> {
            SurveyResponse surveyResponse = new SurveyResponse(it, repository.findAllBySurveyTemplateId(it.getSurveyTemplate().getId()));
            return surveyResponse;
        }).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public  SurveyResponse getSurvey(@PathVariable("id") Long id){
        Survey survey = service.get(id);
        List<SurveyQuestion> surveyQuestions = repository.findAllBySurveyTemplateId(survey.getSurveyTemplate().getId());
    return new SurveyResponse(survey, surveyQuestions);
    }

    @PostMapping("/create")
    public Survey create (@RequestBody SurveyRequest surveyRequest ){
        return service.createSurvey(surveyRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }


}
