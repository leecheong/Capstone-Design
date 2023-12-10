package Hospital.medic.Dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecordDTO {

    private Integer R_id;
    private String R_date;
    private String R_drug;
    private String R_note;
    private String R_name;
    private String R_doctor;
}
