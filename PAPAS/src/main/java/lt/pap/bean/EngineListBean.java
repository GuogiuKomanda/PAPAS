package lt.pap.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import lt.pap.model.WPart;
import lt.pap.service.I18nService;
import lt.pap.service.WPartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("engineListBean")
@Scope("session")
public class EngineListBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8405718332067019644L;

	@Autowired
	private SessionBean session;

	@Autowired
	private I18nService i18nService;
	@Autowired
	private WPartService wpartService;


	private List<WPart> wpartList = new ArrayList<WPart>();

	@PostConstruct
	public void init() {
		wpartList = wpartService.findAll();
		//reload();
	}

	/**
	 * Loads designations
	 */
	public void reload() {
		i18nService.loadWPartListDesignations(wpartList, session.getCountryId(), session.getLocaleId());
	}

	public List<WPart> getWpartList() {
		return wpartList;
	}

	public void setWpartList(List<WPart> wpartList) {
		this.wpartList = wpartList;
	}


}