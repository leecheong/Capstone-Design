package Hospital.medic.Service;

import Hospital.medic.Entity.RecordEntity;
import Hospital.medic.Repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    //진료기록 불러오기 처리
    public List<RecordEntity> recordEntityList(String R_name) {



        return recordRepository.rename(R_name);
    }

    //진료 상세기록 처리
    public RecordEntity record_detail(Integer R_id){

        return recordRepository.findById(R_id).get();
    }


}
