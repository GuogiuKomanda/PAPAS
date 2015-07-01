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

    public List<TofModel> findAll(int countryId, short localeId)
    {
        List<TofModel> modelList = tofmodelRepository.findAll();
        return modelList;
              
    }
    
    public List<TofModel> findByMake(short makeId, int countryId, short localeId)
    {
        List<TofModel> modelList = tofmodelRepository.findByTofManufacturerMfaId(makeId);
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
        return model;
    }

	public List<SelectItem> findModelsForSelect(Short manufacturerId, Integer countryId, Short localeId) {
		//.stream().map( list -> { return new SelectItem(list[0], (String)list[1] ); } ).collect(Collectors.toList())
		return Functions.modelsToSelectItems(tofmodelRepository.findModelsForSelect(manufacturerId, countryId,	localeId));
	}
    
    
    
}
