package lt.pap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import lt.pap.model.TofManufacturer;
import lt.pap.model.WPart;
import lt.pap.model.utils.Functions;
import lt.pap.service.FuelService;
import lt.pap.service.TofManufacturerService;
import lt.pap.service.TofModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component("engineListBean")
@Scope("session")
public class EngineListBean {
	
    @Autowired
    private SessionBean session;
	
//    @Autowired
//    private TofManufacturerService manufacturerSercive;
//
//    @Autowired
//    private TofModelService modelService;
//
//    @Autowired
//    private FuelService fuelService;
    
    @Autowired
    private ApplicationBean applicationBean;

//    @Autowired
  //  private WPartService wpartService;
    // manufacturer
    
    private String selectedTofManufacturer = "";

    private List<SelectItem> availableTofManufacturerList;

    // model
    private List<Integer> selectedTofModelList = new ArrayList<Integer>();

    private List<SelectItem> availableTofModelList;

    // fuel
    private List<Integer> selectedFuelList= new ArrayList<Integer>();

    private List<SelectItem> availableFuelList;
    
    private List<WPart> wpartList;

    @PostConstruct
    private void init() {
        availableTofManufacturerList = applicationBean.getAvailableManufacturers(session.getCountryId(),  session.getLocaleId());
        availableFuelList = applicationBean.getAvailableFuels( session.getCountryId(),  session.getLocaleId());

    }

    public void updateTofModelList() {
        if (selectedTofManufacturer != null) {
        	short mfaId = Short.parseShort(selectedTofManufacturer);
        	availableTofModelList = applicationBean.getAvailableModels(mfaId, session.getCountryId(),  session.getLocaleId());
        } else {
          availableTofModelList = new ArrayList<SelectItem>();
        }
    }

    public void updateFuelList() {

    }
    
    public void doSearch(){
        

      //  wpartList = wpartService.findByFilters2(selectedTofManufacturer, selectedTofModelList, selectedFuelTypeList);
    }



    public String getSelectedTofManufacturer() {
        return selectedTofManufacturer;
    }

    public void setSelectedTofManufacturer(String selectedTofManufacturer) {
        this.selectedTofManufacturer = selectedTofManufacturer;
    }

    public List<SelectItem> getAvailableTofManufacturerList() {
        return availableTofManufacturerList;
    }

    public void setAvailableTofManufacturerList(List<SelectItem> availableTofManufacturerList) {
        this.availableTofManufacturerList = availableTofManufacturerList;
    }

    public List<Integer> getSelectedTofModelList() {
        return selectedTofModelList;
    }

    public void setSelectedTofModelList(List<Integer> selectedTofModelList) {
        this.selectedTofModelList = selectedTofModelList;
    }

    public List<SelectItem> getAvailableTofModelList() {
        return availableTofModelList;
    }

    public void setAvailableTofModelList(List<SelectItem> availableTofModelList) {
        this.availableTofModelList = availableTofModelList;
    }

    public List<Integer> getSelectedFuelList() {
        return selectedFuelList;
    }

    public void setSelectedFuelList(List<Integer> selectedFuelList) {
        this.selectedFuelList = selectedFuelList;
    }

    public List<SelectItem> getAvailableFuelList() {
        return availableFuelList;
    }

    public void setAvailableFuelList(List<SelectItem> availableFuelList) {
        this.availableFuelList = availableFuelList;
    }

    public List<WPart> getWpartList() {
        return wpartList;
    }
}