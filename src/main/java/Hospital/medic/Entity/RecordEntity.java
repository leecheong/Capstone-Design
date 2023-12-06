package Hospital.medic.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "record")
public class RecordEntity {
    @Id
    private Integer R_id;

    @Column
    private Date R_date;

    @Column
    private String R_drug;

    @Column
    private String R_note;

    @Column
    private String R_name;

    @Column
    private String R_doctor;


}
