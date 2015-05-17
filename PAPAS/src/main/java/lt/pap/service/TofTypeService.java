package lt.pap.service;

import java.util.List;

import lt.pap.dao.TofTypeRepository;
import lt.pap.model.TofType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class TofTypeService
{
    @Autowired
    private TofTypeRepository toftypeRepository;

    public List<TofType> findAll()
    {
        return toftypeRepository.findAll();
    }

    public TofType findOne(Long typid)
    {
        return toftypeRepository.findOne(typid);
    }
}
