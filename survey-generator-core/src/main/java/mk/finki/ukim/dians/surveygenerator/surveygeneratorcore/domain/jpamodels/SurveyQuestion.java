package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(schema = "survey_templates", name = "survey_question")
public class SurveyQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String Text;

    @ManyToOne
    @JoinColumn(name = "survey_template_id",nullable = false)
    private SurveyTemplate surveyTemplate;

}
