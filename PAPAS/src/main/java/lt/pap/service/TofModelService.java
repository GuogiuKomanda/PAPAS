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
    
    @Autowired
    private TofCountryDesignationService tofCountryDesignationService;

    public List<TofModel> findAll(int countryId, short localeId)
    {
        List<TofModel> modelList = tofmodelRepository.findAll();
        loadCountryDesignations(modelList,countryId ,localeId);
        return modelList;
              
    }
    
    public List<TofModel> findByMake(short makeId, int countryId, short localeId)
    {
        List<TofModel> modelList = tofmodelRepository.findByTofManufacturerMfaId(makeId);
        loadCountryDesignations(modelList,countryId ,localeId);
        return modelList;
              
    }
    
    @Transactional
    public TofModel findOne(Integer modelId,Integer countryId, short localeId) {
    TofModel model = tofmodelRepository.findOne(modelId);
        loadCountryDesignation(model, countryId, localeId );
        return model;
    }

    
    private void loadCountryDesignations(List<TofModel> modelList,Integer countryId, short localeId){
        for(TofModel model : modelList) {
            loadCountryDesignation(model, countryId, localeId);
        }
    }
    
    private void loadCountryDesignation(TofModel model,Integer countryId, short localeId){
        String ModString = tofCountryDesignationService.getCountryDesignationString(model.getModCdsId(), countryId, localeId);
        model.setModString( ModString);
    }
}
