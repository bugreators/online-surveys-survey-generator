package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(schema = "surveys", name = "recipient")
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column (name = "status")
    private Boolean status;

}
