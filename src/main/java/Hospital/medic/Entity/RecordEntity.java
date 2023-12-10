package Hospital.medic.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "record")
public class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer R_id;

    @Column
    private String R_date;

    @Column
    private String R_drug;

    @Column
    private String R_note;

    @Column
    private String R_name;

    @Column
    private String R_doctor;


}
