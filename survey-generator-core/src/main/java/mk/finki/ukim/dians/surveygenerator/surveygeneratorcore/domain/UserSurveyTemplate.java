package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(schema = "survey_templates", name = "users_survey_templates")
public class UserSurveyTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "survey_template_id", nullable = false)
    private SurveyTemplate surveyTemplate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
