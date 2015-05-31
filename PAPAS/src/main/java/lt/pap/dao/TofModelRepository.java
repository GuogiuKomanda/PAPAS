package lt.pap.dao;

import java.util.List;

import lt.pap.model.TofModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TofModelRepository extends JpaRepository<TofModel, Integer>
{
    public List<TofModel> findByTofManufacturerMfaId(short mfaId);
}
