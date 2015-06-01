package lt.pap.dao;

import java.util.List;

import lt.pap.model.TofManufacturer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TofManufacturerRepository extends JpaRepository<TofManufacturer, Short>
{
	public List<TofManufacturer> findAllByOrderByMfaBrand();
	
	@Query("SELECT m.mfaId, m.mfaBrand FROM TofManufacturer m ORDER BY m.mfaBrand ASC")
	public List<Object[]> findManufacturersForSelect();
}
