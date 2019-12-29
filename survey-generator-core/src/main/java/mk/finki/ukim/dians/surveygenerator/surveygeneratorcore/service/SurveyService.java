package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.service;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.Survey;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyTemplate;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.requests.SurveyRequest;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence.SurveyRepository;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence.SurveyTemplateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
/** Definiranje na  service bean za surveys*/
@Service
public class SurveyService {

    private final SurveyRepository repository;
    private final SurveyTemplateRepository surveyTemplateRepository;

    public SurveyService(SurveyRepository repository, SurveyTemplateRepository surveyTemplateRepository) {
        this.repository = repository;
        this.surveyTemplateRepository = surveyTemplateRepository;
    }
/**Creiranje na survey  ova se koristi vo kontrolerot*/
    public Survey createSurvey(SurveyRequest request) {
        SurveyTemplate surveyTemplate = surveyTemplateRepository.getOne(request.getSurveyTemplateId());
        LocalDateTime endDate = LocalDateTime.parse(request.getEndTime());
        return repository.save(new Survey(1L, request.getStatus(), request.getAmount(), endDate, surveyTemplate));
    }
    /** Update na survey */
    public Survey updateSurvey(SurveyRequest request) {
        SurveyTemplate surveyTemplate = surveyTemplateRepository.getOne(request.getSurveyTemplateId());
        LocalDateTime endDate = LocalDateTime.parse(request.getEndTime());
        return repository.save(new Survey(1L, request.getStatus(), request.getAmount(), endDate, surveyTemplate));
    }
/**Brisenje na survey*/
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
/**Zemanje na site surveys*/
    public List<Survey> getAll() {
        return repository.findAll();
    }
/** zemanje na daden survey*/
    public Survey get(Long id) {
        return repository.getOne(id);
    }

}
