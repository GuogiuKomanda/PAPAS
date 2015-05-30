package lt.pap.service;

import java.util.List;

import lt.pap.dao.FuelRepository;
import lt.pap.model.Fuel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class FuelService
{
    @Autowired
    private FuelRepository fuelRepository;

    public List<Fuel> findAll()
    {
        return fuelRepository.findAll();
    }

    public Fuel findOne(Integer id)
    {
        return fuelRepository.findOne(id);
    }
    
}
