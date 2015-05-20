package lt.pap.dao;

import java.util.List;

import lt.pap.model.TofEngine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TofEngineRepository extends JpaRepository<TofEngine, Integer>
{
	@Transactional
    List<TofEngine> findAllByEngIdIn(List<Integer> list);
}
