package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.api;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyQuestion;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyTemplate;

import java.util.List;

public class SurveyTemplateResponse {

    private Long id;

    private String name;

    private List<SurveyQuestion> surveyQuestions;

    SurveyTemplateResponse(SurveyTemplate surveyTemplate, List<SurveyQuestion> surveyQuestions) {
        this.id = surveyTemplate.getId();
        this.name = surveyTemplate.getName();
        this.surveyQuestions = surveyQuestions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<SurveyQuestion> getSurveyQuestions() {
        return surveyQuestions;
    }
}
