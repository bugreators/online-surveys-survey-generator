package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.api;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyQuestion;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyTemplate;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.requests.SurveyTemplateRequest;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence.SurveyQuestionRepository;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.service.SurveyTemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/** controller za Surveys templates*/
@RestController
@RequestMapping(path = "/surveys-templates")
public class SurveyTemplateController {

    private final SurveyTemplateService service;
    private final SurveyQuestionRepository repository;


    public SurveyTemplateController(SurveyTemplateService service, SurveyQuestionRepository repository) {
        this.service = service;
        this.repository = repository;
    }
/**Creiranje na template*/
    @PostMapping(path = "/create")
    public SurveyTemplate create(@RequestBody SurveyTemplateRequest request) {
        return service.createSurvey(request);
    }
/** Prevzemanje na site templates*/
    @GetMapping("/all")
    public List<SurveyTemplateResponse> getSurveys() {
        return service.getAll().stream().map(it -> {
            return new SurveyTemplateResponse(it, repository.findAllBySurveyTemplateId(it.getId()));
        }).collect(Collectors.toList());

    }
/**Zemanje na daden template spored id*/
    @GetMapping("/{id}")
    public  SurveyTemplateResponse getSurvey(@PathVariable("id") Long id){
        SurveyTemplate survey = service.get(id);
        List<SurveyQuestion> surveyQuestions = repository.findAllBySurveyTemplateId(survey.getId());
        return new SurveyTemplateResponse(survey, surveyQuestions);
    }
}
