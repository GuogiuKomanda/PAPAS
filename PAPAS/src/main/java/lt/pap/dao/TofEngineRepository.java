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
    
    @Query(nativeQuery = true, value="SELECT DISTINCT  eng.eng_code "
    		+ "FROM tof_engines eng "
    		+ "left join tof_link_typ_eng link on link.lte_eng_id = eng.eng_id  "
    		+ "left join tof_types typ on typ.typ_id= link.lte_typ_id "
    		+ "left join tof_models model on mod_id= typ.typ_mod_id "
    		+ "WHERE model.mod_mfa_id=?1 ")
    public List<String> findEngineCodesbyManufacturer(Short mfaId);
    
    @Query(nativeQuery = true, value="SELECT DISTINCT  eng.eng_code "
    		+ "FROM tof_engines eng "
    		+ "left join tof_link_typ_eng link on link.lte_eng_id = eng.eng_id  "
    		+ "left join tof_types typ on typ.typ_id= link.lte_typ_id "
    		+ "left join tof_models model on mod_id= typ.typ_mod_id "
    		+ "WHERE model.mod_mfa_id=?1 and typ.TYP_KV_FUEL_DES_ID in (?2) ")
    public List<String> findEngineCodesbyManufacturerAndFuel(Short manufacturerId, List<Integer> fuelIdList);
    
    @Query(nativeQuery = true, value="SELECT DISTINCT eng.eng_code "
    		+ "FROM tof_engines eng "
    		+ "left join tof_link_typ_eng link on link.lte_eng_id = eng.eng_id  "
    		+ "left join tof_types typ on typ.typ_id= link.lte_typ_id "
    		+ "left join tof_models model on mod_id= typ.typ_mod_id "
    		+ "WHERE model.mod_id IN ( ?1) ")
    public List<String> findEngineCodesbyModel(List<Integer> modelId);
    
    @Query(nativeQuery = true, value="SELECT DISTINCT eng.eng_code "
    		+ "FROM tof_engines eng "
    		+ "left join tof_link_typ_eng link on link.lte_eng_id = eng.eng_id  "
    		+ "left join tof_types typ on typ.typ_id= link.lte_typ_id "
    		+ "left join tof_models model on mod_id= typ.typ_mod_id "
    		+ "WHERE model.mod_id IN ( ?1)  and typ.TYP_KV_FUEL_DES_ID in (?2) ")
    public List<String> findEngineCodesbyModelAndFuel(List<Integer> modelId,  List<Integer> fuelIdList);
    
    
    
    //visi like variantai
}
