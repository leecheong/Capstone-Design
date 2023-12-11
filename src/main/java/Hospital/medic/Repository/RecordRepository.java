package Hospital.medic.Repository;

import Hospital.medic.Entity.RecordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository  extends JpaRepository<RecordEntity, Integer> {

    //환자 페이지 진료기록
    @Query(value = "select * from record where R_name = :Rname", nativeQuery = true)
    public List<RecordEntity> rename(@Param("Rname") String R_name);
    //의사 페이지 진료기록
    @Query(value = "SELECT * FROM record WHERE R_name = :Rname", nativeQuery = true)
    List<RecordEntity> findByName(@Param("Rname") String R_name);





}
