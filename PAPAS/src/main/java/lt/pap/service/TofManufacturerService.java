package lt.pap.service;

import java.util.List;

import lt.pap.dao.TofManufacturerRepository;
import lt.pap.model.TofManufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class TofManufacturerService
{
    @Autowired
    private TofManufacturerRepository tofmanufacturerRepository;

    public List< TofManufacturer> findAll()
    {
        return tofmanufacturerRepository.findAll();
    }

    public  TofManufacturer findOne(Long mfaid)
    {
        return tofmanufacturerRepository.findOne(mfaid);
    }

   
}
