package lt.pap.service;

import java.util.List;

import javax.faces.model.SelectItem;

import lt.pap.dao.TofModelRepository;
import lt.pap.model.TofModel;
import lt.pap.model.utils.Functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional


public class TofModelService
{
    @Autowired
    private TofModelRepository tofmodelRepository;
    
    @Autowired
    private TofCountryDesignationService tofCountryDesignationService;

    public List<TofModel> findAll(int countryId, short localeId)
    {
        List<TofModel> modelList = tofmodelRepository.findAll();
//        loadCountryDesignations(modelList,countryId ,localeId);
        return modelList;
              
    }
    
    public List<TofModel> findByMake(short makeId, int countryId, short localeId)
    {
        List<TofModel> modelList = tofmodelRepository.findByTofManufacturerMfaId(makeId);
//        loadCountryDesignations(modelList,countryId ,localeId);
        return modelList;
              
    }
    
    public List<TofModel> findByManufacturer(short mfaId)
    {
        List<TofModel> modelList = tofmodelRepository.findByTofManufacturerMfaId(mfaId);
        return modelList;
              
    }
    
    @Transactional
    public TofModel findOne(Integer modelId,Integer countryId, short localeId) {
    TofModel model = tofmodelRepository.findOne(modelId);
        loadModelDesignations(model, countryId, localeId );
        return model;
    }

    
    private void loadCountryDesignations(List<TofModel> modelList,Integer countryId, short localeId){
        for(TofModel model : modelList) {
//            loadCountryDesignation(model, countryId, localeId);
        }
    }
    
    public void loadModelDesignations(TofModel model,Integer countryId, short localeId){
        String modelString = tofCountryDesignationService.getCountryDesignationString(model.getModCdsId(), countryId, localeId);
        model.setModelString( modelString);
    }

	public List<SelectItem> findModelsForSelect(Short manufacturerId, Integer countryId, Short localeId) {
		//.stream().map( list -> { return new SelectItem(list[0], (String)list[1] ); } ).collect(Collectors.toList())
		return Functions.modelsToSelectItems(tofmodelRepository.findModelsForSelect(manufacturerId, countryId,	localeId));
	}
    
    
    
}
