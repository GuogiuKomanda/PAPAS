package lt.pap.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

@Component("sessionBean")
@Scope("session")
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 3729328103103002629L;

	private int countryId = 186;
	private short localeId = 4;
	
	private static String DE = "Deutsch";
	private static String EN = "English";
	private static String LT = "Lietuvi\u0173";
	private static String RU = "\u0440\u0443\u0441\u0441\u043A\u0438\u0439";

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
	private LocaleResolver localeResolver;

	@Autowired(required = true)
	private HttpServletRequest request;

	@Autowired(required = true)
	private HttpServletResponse response;

	private String localeString;

	private Map<String, Locale> supportedLocales;

	public SessionBean() {
		supportedLocales = new LinkedHashMap<String, Locale>();
		supportedLocales.put(DE, new Locale("de"));
		supportedLocales.put(EN, Locale.ENGLISH);
		supportedLocales.put(LT, new Locale("lt"));
		supportedLocales.put(RU, new Locale("ru")); //russian

		localeString = Locale.ENGLISH.getLanguage();
	}

	public Map<String, Locale> getSupportedLocales() {
		return supportedLocales;
	}

	public String getLocaleString() {
		return localeString;
	}

	public void setLocaleString(String localeString) {
		this.localeString = localeString;
		if("de".equals(localeString)) localeId = ApplicationBean.GERMAN;
		if("en".equals(localeString)) localeId = ApplicationBean.ENGLISH;
		if("lt".equals(localeString)) localeId = ApplicationBean.LITHUANIAN;
		if("ru".equals(localeString)) localeId = ApplicationBean.RUSSIAN;
	}

	public void localeChanged() {
		
		for (Map.Entry<String, Locale> entry : supportedLocales.entrySet()) {
			if (entry.getValue().toString().equals(localeString)) {
				Locale locale = entry.getValue();

				localeResolver.setLocale(request, response, locale);
				LocaleContextHolder.setLocale(locale, true);

				break;
			}
		}
	}

}
