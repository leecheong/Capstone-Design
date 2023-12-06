package Hospital.medic.Repository;

import Hospital.medic.Entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository  extends JpaRepository<RecordEntity, Integer> {

    @Query(value = "select * from record where R_name = :Rname", nativeQuery = true)
    public List<RecordEntity> rename(@Param("Rname") String R_name);





}
