package lt.pap.dao;

import lt.pap.model.TofCountryDesignation;
import lt.pap.model.TofCountryDesignationPK;
import lt.pap.model.TofDesignation;
import lt.pap.model.TofDesignationPK;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TofCountryDesignationRepository extends JpaRepository<TofCountryDesignation, TofCountryDesignationPK>
{
    @Cacheable("countrydesignationByPK")
    public TofCountryDesignation findOne(TofCountryDesignationPK pk);   
}
