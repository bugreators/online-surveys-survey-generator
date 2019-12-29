package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.requests;

import lombok.Data;


@Data
public class SurveyRequest {

    private Long surveyTemplateId;

    private Boolean status;

    private int amount;

    private String endTime;
}
