package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(schema = "surveys", name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private Boolean status = false;

    @Column(name = "amount")
    private int amount;

    @Column(name = "end_time")
    private LocalDateTime endDate;

}
