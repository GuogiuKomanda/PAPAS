package lt.pap.bean;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import lt.pap.model.WPart;
import lt.pap.model.utils.Functions;
import lt.pap.service.WPartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("engineEditBean")
@Scope("session")
public class EngineEditBean {
	
	@Autowired
	private SessionBean session;
	
	@Autowired
	private WPartService wpartService;

	private Short manufacturer;
	
	private Integer model;
	
	private Integer engineId;
	
	private String engineCodeFull;
	
	private Year year;
	
	private String comment;
	
	

	public void updateModelList() {
		model = null;
		updateCodeList();
	}

	public void updateCodeList() {
		engineId = null;
	}
	
	public void doSave() {
		
		WPart part = new WPart();
		part.setEngine(engineId);
		part.setFullCode(engineCodeFull);
		part.setLocation("xxx");
		part.setStatus("new");
		part.setYear(year);
		wpartService.save(part);
		// selectedModelList, selectedFuelTypeList);
	}

	public List<SelectItem> getAvailableManufacturerList() {
		return session.getAvailableManufacturers();
	}

	public List<SelectItem> getAvailableModelList() {
		if (manufacturer != null) {
			return session.getAvailableModels(manufacturer);
		} else {
			return new ArrayList<SelectItem>();
		}
	}
	
	public List<SelectItem> getAvailableEngineCodesList() {
		if (model != null) {
			return session.getAvailableEngineCodes(model);
		} else {
			return new ArrayList<SelectItem>();
		}
	}
	
	public List<SelectItem> getAvailableYearsList() {
		return Functions.yearsAsSelectItems(1999, Year.now().getValue());
	}

	public Short getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Short manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public Integer getEngineId() {
		return engineId;
	}

	public void setEngineId(Integer engineId) {
		this.engineId = engineId;
	}

	public String getEngineCodeFull() {
		return engineCodeFull;
	}

	public void setEngineCodeFull(String engineCodeFull) {
		this.engineCodeFull = engineCodeFull;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
