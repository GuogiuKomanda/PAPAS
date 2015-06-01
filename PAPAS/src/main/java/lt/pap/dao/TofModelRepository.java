package lt.pap.dao;

import java.util.List;

import lt.pap.model.TofModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TofModelRepository extends JpaRepository<TofModel, Integer>
{
    public List<TofModel> findByTofManufacturerMfaId(short mfaId);
    
    @Query(nativeQuery = true, value="SELECT model.MOD_ID id, tdt.TEX_TEXT label from tof_manufacturers manufacturer "
    		+ "left outer join tof_models model on manufacturer.MFA_ID=model.MOD_MFA_ID "
    		+ "left outer join tof_country_designations tcd on model.mod_cds_id=tcd.CDS_ID "
    		+ "left outer join tof_des_texts tdt on tcd.CDS_TEX_ID=tdt.TEX_ID "
    		+ "where "
    		+ "manufacturer.MFA_ID = ?1 "
    		+ "and   SUBSTRING(tcd.CDS_CTM, ?2+2, 1)='1' "
    		+ "and tcd.CDS_LNG_ID=?3 order by label asc")
//    @Query("SELECT new lt.pap.model.Item(model.modId, tcd.tofDesText.texText) from TofModel model "
////    		+ "left join TofModel model on manufacturer.mfaId=model.mfaId "
//    		+ " join TofCountryDesignation tcd "//on model.ModCdsId=tcd.id.cdsId "
////    		+ "left outer join tof_des_texts tdt on tcd.CDS_TEX_ID=tdt.TEX_ID "
//    		+ "where "
//    		+ "model.ModCdsId=tcd.id.cdsId "
//    		+ "and model.tofManufacturer.mfaId = ?1 "
//    		+ "and SUBSTRING(tcd.id.cdsCtm, ?2+2, 1)='1' "
//    		+ "and tcd.cdsLngId=?3")
//    @SqlResultSetMapping(
//    	       name="MyResults",
//    	       classes={
//    	          @ConstructorResult(
//    	               targetClass=lt.pap.model.Item.class,
//    	                 columns={
//    	                    @ColumnResult(name="id"),
//    	                    @ColumnResult(name="label"),
//    	
//    	                    }
//    	          )
//    	       }
//    	      )
    
    public List<Object[]> findModelsForSelect(Short manufacturerId, Integer countryId, Short localeId);
}
