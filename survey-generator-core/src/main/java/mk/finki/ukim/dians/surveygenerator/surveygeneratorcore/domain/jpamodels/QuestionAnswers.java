package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(schema = "surveys", name = "question_answers")
public class QuestionAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer")
    private int answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private SurveyQuestion surveyQuestion;

}
