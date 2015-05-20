package lt.pap.service;

import lt.pap.dao.TofDesignationRepository;
import lt.pap.model.TofDesText;
import lt.pap.model.TofDesignation;
import lt.pap.model.TofDesignationPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TofDesignationService {

	@Autowired
	private TofDesignationRepository tofDesignationRepository;

	public String getDesignationString(Integer designationId, Short localeId) {
		TofDesignationPK pk = new TofDesignationPK();
		pk.setDesId(designationId);
		pk.setDesLngId(localeId);

		TofDesignation designation = tofDesignationRepository.findOne(pk);
		if (designation == null) {
			return null;
		}

		TofDesText desText = designation.getTofDesText();
		if (desText == null) {
			return null;
		}

		return desText.getTexText();
	}
}
