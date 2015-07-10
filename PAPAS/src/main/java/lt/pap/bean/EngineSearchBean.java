package lt.pap.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import lt.pap.model.WPart;
import lt.pap.service.I18nService;
import lt.pap.service.TofEngineService;
import lt.pap.service.WPartService;

import org.richfaces.component.AbstractExtendedDataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("engineSearchBean")
@Scope("session")
public class EngineSearchBean implements Serializable {

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
	@Autowired
	private TofEngineService tofEngineService;

	private String tofEngineCodeFilter;

	private Short selectedManufacturer = null;
	private List<Integer> selectedModelList = new ArrayList<Integer>();
	private List<Integer> selectedFuelList = new ArrayList<Integer>();

	private List<WPart> wpartList = new ArrayList<WPart>();
	private List<String> engCodeList;
	
	private List<WPart> selectionItems = new ArrayList<WPart>();
	private Collection<Object> selection;

	@PostConstruct
	public void init() {

	}

	public void updateModelList() {

	}

	public void updateFuelList() {

	}

	public void doSearch() {
		if (selectedManufacturer != null) {
			engCodeList = tofEngineService.findEngineCodes(
					selectedManufacturer, selectedModelList, selectedFuelList);
			wpartList = wpartService.findAllByTofEngineEngCodeIn(engCodeList);
		} else {
			wpartList = wpartService.findAll();
		}
		reload();
	}

	/**
	 * Loads designations
	 */
	public void reload() {
		i18nService.loadWPartListDesignations(wpartList,
				session.getCountryId(), session.getLocaleId());
	}

	public List<SelectItem> getAvailableManufacturerList() {
		return session.getAvailableManufacturers();
	}

	public List<SelectItem> getAvailableModelList() {
		if (selectedManufacturer != null) {
			short mfaId = selectedManufacturer;
			return session.getAvailableModels(mfaId);
		} else {
			return new ArrayList<SelectItem>();
		}
	}

	public List<SelectItem> getAvailableFuelList() {
		return session.getAvailableFuels();
	}

	public Short getSelectedManufacturer() {
		return selectedManufacturer;
	}

	public void setSelectedManufacturer(Short selectedManufacturer) {
		this.selectedManufacturer = selectedManufacturer;
	}

	public List<Integer> getSelectedModelList() {
		return selectedModelList;
	}

	public void setSelectedModelList(List<Integer> selectedModelList) {
		this.selectedModelList = selectedModelList;
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

	public void settofEngineCodeFilter(String tofEngineCodeFilter) {
		this.tofEngineCodeFilter = tofEngineCodeFilter;
	}

	public String gettofEngineCodeFilter() {
		return tofEngineCodeFilter;
	}
	
    public void selectionListener(AjaxBehaviorEvent event) {
    	AbstractExtendedDataTable dataTable = (AbstractExtendedDataTable) event.getComponent();
    	Object originalKey = dataTable.getRowKey();
    	selectionItems.clear();
    	for (Object selectionKey : selection) {
    		dataTable.setRowKey(selectionKey);
    		if (dataTable.isRowAvailable()) {
    			selectionItems.add((WPart) dataTable.getRowData());
    		}
    	}
    	dataTable.setRowKey(originalKey);
    }
    
	public List<WPart> getSelectionItems() {
		return selectionItems;
	}

	public void setSelectionItems(List<WPart> selectionItems) {
		this.selectionItems = selectionItems;
	}

	public Collection<Object> getSelection() {
		return selection;
	}

	public void setSelection(Collection<Object> selection) {
		this.selection = selection;
	}
}
