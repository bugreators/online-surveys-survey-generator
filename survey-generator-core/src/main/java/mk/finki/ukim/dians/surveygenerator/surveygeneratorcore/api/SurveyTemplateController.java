package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.api;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence.SurveyQuestionRepository;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.service.SurveyTemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/surveys-templates")
public class SurveyTemplateController {

    private final SurveyTemplateService service;
    private final SurveyQuestionRepository repository;


    public SurveyTemplateController(SurveyTemplateService service, SurveyQuestionRepository repository) {
        this.service = service;
        this.repository = repository;
    }
}
