package lt.pap.bean;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sessionBean")
@Scope("session")
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 3729328103103002629L;

	private int countryId = 186;
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
	

//  @Autowired
//  private LocaleResolver localeResolver;
//
//  @Autowired(required = true)
//  private HttpServletRequest request;
//
//  @Autowired(required = true)
//  private HttpServletResponse response;
//
//  private String localeString;
//
//  private Map<String, Locale> supportedLocales;
//
//  public SessionBean() {
//    supportedLocales = new LinkedHashMap<String, Locale>();
//    supportedLocales.put("English", Locale.ENGLISH);
//    supportedLocales.put("Lietuvi\u0173", new Locale("lt"));
//    supportedLocales.put("Latvian", new Locale("lv"));
//
//    localeString = Locale.ENGLISH.getLanguage();
//  }
//
//  public Map<String, Locale> getSupportedLocales() {
//    return supportedLocales;
//  }
//
//  public String getLocaleString() {
//    return localeString;
//  }
//
//  public void setLocaleString(String localeString) {
//    this.localeString = localeString;
//  }
//
//  public void localeChanged() {
//    for (Map.Entry<String, Locale> entry : supportedLocales.entrySet()) {
//      if (entry.getValue().toString().equals(localeString)) {
//        Locale locale = entry.getValue();
//
//        localeResolver.setLocale(request, response, locale);
//        LocaleContextHolder.setLocale(locale, true);
//
//        break;
//      }
//    }
//  }

}
