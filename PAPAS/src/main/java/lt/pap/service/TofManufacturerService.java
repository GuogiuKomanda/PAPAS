package lt.pap.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.model.SelectItem;

import lt.pap.dao.TofManufacturerRepository;
import lt.pap.model.TofManufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
//        return tofmanufacturerRepository.findAll(sortByIdAsc());
    	return tofmanufacturerRepository.findAllByOrderByMfaBrand();
    }

    public  TofManufacturer findOne(Short mfaid)
    {
        return tofmanufacturerRepository.findOne(mfaid);
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "mfaBrand");
    }
    
    public List<SelectItem> findManufacturersForSelect() {
    	return tofmanufacturerRepository.findManufacturersForSelect().stream().map( list -> 
    		{ return new SelectItem((Short)list[0], (String)list[1] ); } ).collect(Collectors.toList());
    }
   
}
