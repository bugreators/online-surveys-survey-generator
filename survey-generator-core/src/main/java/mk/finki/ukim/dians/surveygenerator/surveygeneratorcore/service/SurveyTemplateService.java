package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.service;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.Survey;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyTemplate;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.requests.SurveyTemplateRequest;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence.SurveyQuestionRepository;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence.SurveyTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**Definiranje na service bean za surveytemplate */
@Service
public class SurveyTemplateService {

    private final SurveyTemplateRepository repository;

    public SurveyTemplateService(SurveyTemplateRepository repository, SurveyQuestionRepository surveyQuestionRepository) {
        this.repository = repository;
    }
/**Kreiranje na survey Template*/
    public SurveyTemplate createSurvey(SurveyTemplateRequest request) {
        return repository.save(new SurveyTemplate(1L, request.getName()));
    }
/** Update na survey template*/
    public SurveyTemplate updateSurveyTemplate(SurveyTemplateRequest request) {
        return repository.save(new SurveyTemplate(1L, request.getName()));
    }
/**Brisenje na survey template*/
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    public List<SurveyTemplate> getAll() {
        return repository.findAll();
    }

    public SurveyTemplate get(Long id) {
        return repository.getOne(id);
    }


}
