package lt.pap.dao;

import java.util.List;

import lt.pap.model.Fuel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Integer>
{
    
	@Query(value = "select f.DES_ID, tdt.TEX_TEXT from fuel f "
			+ "left outer join tof_designations td on f.DES_ID=td.DES_ID "
			+ "left outer join tof_des_texts tdt on td.DES_TEX_ID=tdt.TEX_ID "
			+ "where td.DES_LNG_ID = ?1 and f.FSTATUS = 1 ORDER BY f.FORDER ASC", nativeQuery = true)
	public List<Object[]> findFuelsForSelect(Short localeId);
}
