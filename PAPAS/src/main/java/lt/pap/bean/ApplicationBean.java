package lt.pap.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	private static int EUROPE = 248;
	
	//supported locales
	public static short GERMAN = 1;
	public static short ENGLISH = 4;
	public static short RUSSIAN = 16;
	public static short LITHUANIAN = 34;

	private Map<Short, String> supportedLocales = new TreeMap<Short, String>();
	
	private List<SelectItem> availableManufacturersSelect = new ArrayList<SelectItem>();
	
	private Map<Short, List<SelectItem>> availableManufacturerToModelSelect = new TreeMap<Short,List<SelectItem>>();
	
	private Map<Short, List<SelectItem>> localeToFuelSelect = new TreeMap<Short,List<SelectItem>>();
	
	@Autowired
	private TofManufacturerService manufacturerService;
	
	@Autowired
	private TofModelService modelService;
	
	@Autowired
	private FuelService fuelService;
	
	@PostConstruct
	private void init() {
		//TODO load designations?
		supportedLocales.put(GERMAN, "German");
		supportedLocales.put(ENGLISH, "English");
		supportedLocales.put(RUSSIAN, "Russian");
		supportedLocales.put(LITHUANIAN, "Lithuanian");

		//load manufacturers
		availableManufacturersSelect = manufacturerService.findManufacturersForSelect();
		
		//load models
		for(SelectItem manufacturer : availableManufacturersSelect) {
			short mfaId = (Short)manufacturer.getValue();
			List<SelectItem> modelList = modelService.findModelsForSelect(mfaId, EUROPE, ENGLISH);
			availableManufacturerToModelSelect.put(mfaId, modelList);
		}
		
		//load fuels for each locale
		for(Short localeId : supportedLocales.keySet()) {
			List<SelectItem> fuelList = fuelService.findFuelsForSelect(localeId);
			localeToFuelSelect.put(localeId, fuelList);
		}
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
}
