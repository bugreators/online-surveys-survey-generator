package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(schema = "surveys", name = "surveys_answers")
public class SurveyAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;
}
