package lt.pap.dao;

import java.util.List;

import lt.pap.model.TofCountryDesignation;
import lt.pap.model.TofCountryDesignationPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TofCountryDesignationRepository extends JpaRepository<TofCountryDesignation, TofCountryDesignationPK>
{
	@Query("select t from TofCountryDesignation t where t.id.cdsId=:id and SUBSTRING(t.id.cdsCtm, :countryId+2, 1)='1' and t.id.cdsLngId=:localeId" )
    public List<TofCountryDesignation> findCountryDesignationById(@Param("id") Integer id, @Param("countryId") Integer countryId, @Param("localeId") Short localeId);
    
}
