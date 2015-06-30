package lt.pap.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.model.SelectItem;

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
    private TofTypeRepository tofTypeRepository;
    
    @Autowired
    private TofModelService modelService;
    
    @Autowired
    private TofCountryDesignationService countryDesignationService;
    
    @Autowired
    private TofDesignationService designationService;

    public List<TofType> findAll()
    {
        return tofTypeRepository.findAll();
    }

    public TofType findOne(Integer typeId)
    {
        return tofTypeRepository.findOne(typeId);
    }

	public List<SelectItem> findTypForSelect(Integer modelId, Integer engineId, Integer countryId, Short localeId) {
		return tofTypeRepository.findTypForSelect(modelId, engineId).stream().map( list -> 
		{ return new SelectItem((Integer)list[0], 
								countryDesignationService.getCountryDesignationString((Integer)list[1], countryId, localeId) +
								"\t"+
								list[2]+"KW\\"+
								list[3]+"HP\\"+
								list[4]+"cc");} ).collect(Collectors.toList());
	}
    
    public void loadTypeDesignations(TofType type, int countryId, short localeId){
    	type.setFuelString(designationService.getDesignationString(type.getTypKvFuelDesId(), localeId));
    	type.setTypeString(countryDesignationService.getCountryDesignationString(type.getTypCdsId(), countryId, localeId));
    	
    	modelService.loadModelDesignations(type.getTofModel(), countryId, localeId);
    	
    }
}
