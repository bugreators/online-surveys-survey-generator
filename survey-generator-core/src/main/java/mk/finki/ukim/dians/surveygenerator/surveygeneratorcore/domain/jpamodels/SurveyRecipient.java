package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(schema = "surveys", name = "surveys_recipients")
public class SurveyRecipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

}
