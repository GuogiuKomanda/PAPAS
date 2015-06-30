package lt.pap.service;

import java.util.List;

import lt.pap.dao.WPartRepository;
import lt.pap.model.WPart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class WPartService {
	@Autowired
	private WPartRepository wPartRepository;
	
	@Autowired
	private TofTypeService typeService;

	public List<WPart> findAll() {
		return wPartRepository.findAll();
	}

	public WPart findOne(Integer id) {
		return wPartRepository.findOne(id);
	}

	public <S extends WPart> S save(S entity) {
		return wPartRepository.save(entity);
	}

	public List<WPart> findAllByTofEngineEngCodeIn(List<String> codes) {
		return wPartRepository.findAllByTofEngineEngCodeIn(codes);
	}
	
	public void loadWPartDesignations(WPart wPart, int countryId, short localeId){
		typeService.loadTypeDesignations(wPart.getTofType(), countryId, localeId);
	}

	public void loadWPartListDesignations(List<WPart> wPartList, int countryId, short localeId){
		for(WPart wPart : wPartList) {
			loadWPartDesignations(wPart, countryId, localeId);
		}
	}
	
}