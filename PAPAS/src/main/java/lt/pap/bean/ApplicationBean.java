package lt.pap.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import lt.pap.service.FuelService;
import lt.pap.service.TofManufacturerService;
import lt.pap.service.TofModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("applicationBean")
@Scope("singleton")
public class ApplicationBean {
	
	//country
	private static int EUROPE_ID = 248;
	
	//supported locales
	private static short GERMAN_ID = 1;
	private static short ENGLISH_ID = 4;
	private static short RUSSIAN_ID = 16;
	private static short LITHUANIAN_ID = 34;
	
	private static String GERMAN = "Deutsch";
	private static String ENGLISH = "English";
	private static String LITHUANIAN = "Lietuvi\u0173";
	private static String RUSSIAN = "\u0420\u0443\u0441\u0441\u043A\u0438\u0439"; 

	private Map<Locale, String> supportedLocales = new LinkedHashMap<Locale, String>();
	
	private List<SelectItem> availableManufacturersSelect = new ArrayList<SelectItem>();
	
	private Map<Short, List<SelectItem>> availableManufacturerToModelSelect = new HashMap<Short,List<SelectItem>>();
	
	private Map<Short, List<SelectItem>> localeToFuelSelect = new HashMap<Short,List<SelectItem>>();
	
	@Autowired
	private TofManufacturerService manufacturerService;
	
	@Autowired
	private TofModelService modelService;
	
	@Autowired
	private FuelService fuelService;
	
	@PostConstruct
	private void init() {
		supportedLocales.put(new Locale("en"), ENGLISH);
		supportedLocales.put(new Locale("de"), GERMAN);
		supportedLocales.put(new Locale("ru"), RUSSIAN);
		supportedLocales.put(new Locale("lt"), LITHUANIAN);

		//load manufacturers
		availableManufacturersSelect = manufacturerService.findManufacturersForSelect();
		
		//load models
		for(SelectItem manufacturer : availableManufacturersSelect) {
			short mfaId = (Short)manufacturer.getValue();
			List<SelectItem> modelList = modelService.findModelsForSelect(mfaId, EUROPE_ID, ENGLISH_ID);
			availableManufacturerToModelSelect.put(mfaId, modelList);
		}
		
		//load fuels for each locale
		for(Locale locale : supportedLocales.keySet()) {
			Short localeId = localeStringToId(locale.toLanguageTag());
			List<SelectItem> fuelList = fuelService.findFuelsForSelect(localeId);
			localeToFuelSelect.put(localeId, fuelList);
		}
	}

	public Map<Locale, String> getSupportedLocales() {
		return supportedLocales;
	}

	public List<SelectItem> getAvailableManufacturers(int countryId, short localeId) {
		return availableManufacturersSelect;
	}
	
	public List<SelectItem> getAvailableModels(short mfaId, int countryId, short localeId) {
		return availableManufacturerToModelSelect.get(mfaId);
	}
	
	public List<SelectItem> getAvailableFuels(int countryId, short localeId) {
		return localeToFuelSelect.get(localeId);
	}
	
	public static Short localeStringToId(String localeString) {
		switch (localeString) {
		case "de":
			return GERMAN_ID;
		case "en":
			return ENGLISH_ID;
		case "lt":
			return LITHUANIAN_ID;
		case "ru":
			return RUSSIAN_ID;
		default:
			return ENGLISH_ID;
		}
	}
}
