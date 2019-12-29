package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.api;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.Survey;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyQuestion;

import java.time.LocalDateTime;
import java.util.List;

public class SurveyResponse {

    private Long id;

    private Boolean status = false;

    private int amount;

    private LocalDateTime endDate;

    private Long surveyTemplateId;

    private List<SurveyQuestion> surveyQuestions;

    public SurveyResponse(Survey survey, List<SurveyQuestion> surveyQuestions){
        this.amount = survey.getAmount();
        this.id = survey.getId();
        this.endDate = survey.getEndDate();
        this.surveyQuestions = surveyQuestions;
        this.status = survey.getStatus();
        this.surveyTemplateId = survey.getSurveyTemplate().getId();
    }

    public Long getId() {
        return id;
    }

    public Boolean getStatus() {
        return status;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Long getSurveyTemplateId() {
        return surveyTemplateId;
    }

    public List<SurveyQuestion> getSurveyQuestions() {
        return surveyQuestions;
    }
}
