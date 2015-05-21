package lt.pap.service;

import java.util.List;

import lt.pap.dao.TofCountryDesignationRepository;
import lt.pap.model.TofCountryDesignation;
import lt.pap.model.TofCountryDesignationPK;
import lt.pap.model.TofDesText;
import lt.pap.model.TofDesignation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TofCountryDesignationService {

	@Autowired
	private TofCountryDesignationRepository tofCountryDesignationRepository;

	@Autowired
	private TofDesignationService tofDesignationService;

	public String getCountryDesignationString(Integer countryDesignationId,	Integer countryId) {
		return getCountryDesignationString(countryDesignationId, countryId,	(short) 4); // 4 - English. At the moment all county_designations are in English only
	}

	private String getCountryDesignationString(Integer countryDesignationId,
			Integer countryId, Short localeId) {

		List<TofCountryDesignation> cdList = tofCountryDesignationRepository.findCountryDesignationById(countryDesignationId, countryId, localeId);

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
