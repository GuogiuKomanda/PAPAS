package lt.pap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import lt.pap.model.WPart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("engineListBean")
@Scope("session")
public class EngineListBean {

	@Autowired
	private SessionBean session;

	//@Autowired
	//private WPartService wpartService;

	private String selectedTofManufacturer = null;
	private List<Integer> selectedTofModelList = new ArrayList<Integer>();
	private List<Integer> selectedFuelList = new ArrayList<Integer>();

	private List<WPart> wpartList;

	@PostConstruct
	public void init() {

	}

	public void updateTofModelList() {

	}

	public void updateFuelList() {

	}

	public void doSearch() {
		// wpartList = wpartService.findByFilters2(selectedTofManufacturer,
		// selectedTofModelList, selectedFuelTypeList);
	}

	public List<SelectItem> getAvailableTofManufacturerList() {
		return session.getAvailableManufacturers();
	}

	public List<SelectItem> getAvailableTofModelList() {
		if (selectedTofManufacturer != null) {
			short mfaId = Short.parseShort(selectedTofManufacturer);
			return session.getAvailableModels(mfaId);
		} else {
			return new ArrayList<SelectItem>();
		}
	}

	public String getSelectedTofManufacturer() {
		return selectedTofManufacturer;
	}

	public void setSelectedTofManufacturer(String selectedTofManufacturer) {
		this.selectedTofManufacturer = selectedTofManufacturer;
	}

	public List<SelectItem> getAvailableFuelList() {
		return session.getAvailableFuels();
	}

	public List<Integer> getSelectedTofModelList() {
		return selectedTofModelList;
	}

	public void setSelectedTofModelList(List<Integer> selectedTofModelList) {
		this.selectedTofModelList = selectedTofModelList;
	}

	public List<Integer> getSelectedFuelList() {
		return selectedFuelList;
	}

	public void setSelectedFuelList(List<Integer> selectedFuelList) {
		this.selectedFuelList = selectedFuelList;
	}

	public List<WPart> getWpartList() {
		return wpartList;
	}

}