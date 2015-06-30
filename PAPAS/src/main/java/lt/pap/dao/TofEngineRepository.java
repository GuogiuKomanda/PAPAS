package lt.pap.dao;

import java.util.List;

import lt.pap.model.TofEngine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TofEngineRepository extends JpaRepository<TofEngine, Integer>
{
	@Transactional
    List<TofEngine> findAllByEngIdIn(List<Integer> list);
	
    @Query(nativeQuery = true, value="SELECT DISTINCT eng.eng_id, eng.eng_code "
    		+ "FROM tof_engines eng "
    		+ "left join tof_link_typ_eng link on link.lte_eng_id = eng.eng_id  "
    		+ "left join tof_types typ on typ.typ_id= link.lte_typ_id "
    		+ "left join tof_models model on mod_id= typ.typ_mod_id "
    		+ "WHERE model.mod_id=?1 ")
    public List<Object[]> findEngineCodesForSelect(Integer modelId);
    
    @Query(nativeQuery = true, value="SELECT ...")
    public List<String> findEngineCodesbyManufacturer(Integer mfaId);
    
    @Query(nativeQuery = true, value="SELECT ...")
    public List<String> findEngineCodesbyManufacturerAndFuel(Integer manufacturerId, List<Integer> fuelIdList);
    
    @Query(nativeQuery = true, value="SELECT ...")
    public List<String> findEngineCodesbyModel(List<Integer> modelId);
    
    //visi like variantai
}
