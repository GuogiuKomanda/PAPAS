package lt.pap.dao;

import lt.pap.model.TofDesignation;
import lt.pap.model.TofDesignationPK;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TofDesignationRepository extends JpaRepository<TofDesignation, TofDesignationPK> {

	@Cacheable("designationByPK")
	public TofDesignation findOne(TofDesignationPK pk);
}