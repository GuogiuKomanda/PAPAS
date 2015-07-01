package lt.pap.service;

import java.util.List;

import lt.pap.model.TofModel;
import lt.pap.model.TofType;
import lt.pap.model.WPart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class I18nService {

	@Autowired
	private TofCountryDesignationService countryDesignationService;
	
	@Autowired
	private TofDesignationService designationService;
	
	
	public void loadWPartDesignations(WPart wPart, int countryId, short localeId){
		loadTypeDesignations(wPart.getTofType(), countryId, localeId);
	}

	public void loadWPartListDesignations(List<WPart> wPartList, int countryId, short localeId){
		for(WPart wPart : wPartList) {
			loadWPartDesignations(wPart, countryId, localeId);
		}
	}
    
    public void loadTypeDesignations(TofType type, int countryId, short localeId){
    	type.setFuelString(designationService.getDesignationString(type.getTypKvFuelDesId(), localeId));
    	type.setTypeString(countryDesignationService.getCountryDesignationString(type.getTypCdsId(), countryId, localeId));
    	
    	loadModelDesignations(type.getTofModel(), countryId, localeId);
    }
    
    public void loadModelDesignations(TofModel model,Integer countryId, short localeId){
        String modelString = countryDesignationService.getCountryDesignationString(model.getModCdsId(), countryId, localeId);
        model.setModelString( modelString);
    }
}
