package lt.pap.dao;

import java.util.List;

import lt.pap.model.TofType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TofTypeRepository extends JpaRepository<TofType, Long>
{
   @Query(nativeQuery = true, value="SELECT typ.typ_id, typ.TYP_CDS_ID, typ.TYP_KW_FROM, typ.TYP_HP_FROM, typ.TYP_CCM"
   		+ "	FROM tof_engines eng"
   		+ "	left join tof_link_typ_eng link on link.lte_eng_id = eng.eng_id"
   		+ " left join tof_types typ on typ.typ_id= link.lte_typ_id"
   		+ " left join tof_models model on mod_id= typ.typ_mod_id"
   		+ " WHERE model.mod_id=?1 and eng.ENG_ID=?2")
   //id, cds, kw, hp, ccm
    public List<Object[]> findTypForSelect(Integer modelId, Integer engineId);
	
//	public List<TofType> findByTofModelModIdAndTof
}
