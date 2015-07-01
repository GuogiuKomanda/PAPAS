package lt.pap.service;

import java.util.List;

import lt.pap.dao.TofCountryDesignationRepository;
import lt.pap.model.TofCountryDesignation;
import lt.pap.model.TofDesText;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TofCountryDesignationService {

	@Autowired
	private TofCountryDesignationRepository countryDesignationRepository;


	public String getCountryDesignationString(Integer countryDesignationId,	Integer countryId,  Short localeId) {
		return getCountryDesignationsString(countryDesignationId, countryId,	localeId); // 4 - English. At the moment all county_designations are in English only
	}

	private String getCountryDesignationsString(Integer countryDesignationId, Integer countryId, Short localeId) {

		List<TofCountryDesignation> cdList = countryDesignationRepository.findCountryDesignationById(countryDesignationId, countryId, localeId);

		if (cdList == null || cdList.isEmpty()) {
			return null;
		}

		TofDesText desText = cdList.get(0).getTofDesText();

		if (desText == null) {
			return null;
		}

		return desText.getTexText();
	}

}
