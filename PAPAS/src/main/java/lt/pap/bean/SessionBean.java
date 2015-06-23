package lt.pap.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lt.pap.service.TofEngineService;
import lt.pap.service.TofTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

@Component("sessionBean")
@Scope("session")
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 3729328103103002629L;

	private int countryId = 248;
	private short localeId = 4;

	public short getLocaleId() {
		return localeId;
	}

	public void setLocaleId(short localeId) {
		this.localeId = localeId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
    @Autowired
    private ApplicationBean applicationBean;
    
    @Autowired
    private TofEngineService engineService;
    
    @Autowired
    private TofTypeService typeService;

	@Autowired
	private LocaleResolver localeResolver;

	@Autowired(required = true)
	private HttpServletRequest request;

	@Autowired(required = true)
	private HttpServletResponse response;

	private String localeString;


	public SessionBean() {

	}

	public Map<Locale, String> getSupportedLocales() {
		return applicationBean.getSupportedLocales();
	}

	public String getLocaleString() {
		return localeString;
	}

	public void setLocaleString(String localeString) {
		this.localeString = localeString;
		this.localeId = ApplicationBean.localeStringToId(localeString);
	}

	public void localeChanged() {
		for (Map.Entry<Locale, String> entry : getSupportedLocales().entrySet()) {
			if (entry.getKey().toString().equals(localeString)) {
				Locale locale = entry.getKey();

				localeResolver.setLocale(request, response, locale);
				LocaleContextHolder.setLocale(locale, true);

				break;
			}
		}
	}

	public List<SelectItem> getAvailableManufacturers() {
		return applicationBean.getAvailableManufacturers(countryId, localeId);
	}

	public List<SelectItem> getAvailableModels(short mfaId) {
		return applicationBean.getAvailableModels(mfaId, countryId, localeId);
	}

	public List<SelectItem> getAvailableFuels() {
		return applicationBean.getAvailableFuels(countryId, localeId);
	}

	public List<SelectItem> getAvailableEngineCodes(Integer modelId) {
		return engineService.findEngineCodesForSelect(modelId);
	}
	
	public List<SelectItem> getAvailableTypes(Integer modelId, Integer engineId) {
		return typeService.findTypForSelect(modelId, engineId, countryId, (short)4); //locale 4 - english name
	}

}
