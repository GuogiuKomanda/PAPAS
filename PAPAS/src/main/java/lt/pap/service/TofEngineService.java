package lt.pap.service;

import java.util.List;

import lt.pap.dao.TofEngineRepository;
import lt.pap.model.TofEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TofEngineService
{
    /**
     * 
     */
    @Autowired
    private TofEngineRepository tofengineRepository;

    public List<TofEngine> findAll()
    {
        return tofengineRepository.findAll();
    }

    public TofEngine findOne(Long engId)
    {
        return tofengineRepository.findOne(engId);
    }

    public TofEngine save(TofEngine engine) {
        return tofengineRepository.save(engine);
        
      }
    
}
