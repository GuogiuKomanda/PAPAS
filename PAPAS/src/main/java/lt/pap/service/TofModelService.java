package lt.pap.service;

import java.util.List;

import lt.pap.dao.TofModelRepository;
import lt.pap.model.TofModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional


public class TofModelService
{
    @Autowired
    private TofModelRepository tofmodelRepository;

    public List<TofModel> findAll()
    {
        return tofmodelRepository.findAll();
    }

    public TofModel findOne(Long modid)
    {
        return tofmodelRepository.findOne(modid);
    }

    
    
}
