package lt.pap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import lt.pap.model.TofManufacturer;
import lt.pap.model.TofModel;
import lt.pap.model.WPart;
import lt.pap.model.utils.Functions;
import lt.pap.service.FuelService;
import lt.pap.service.TofManufacturerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("session")
public class EngineBean {
    @Autowired
    private TofManufacturerService tofmanufacturerSercive;

    @Autowired
    private TofModel tofmodelService;

    
    @Autowired
    private FuelService fuelService;

    @Autowired
  //  private WPartService wpartService;
    // manufacturer
    private String selectedTofManufacturer = "";

    private List<SelectItem> availableTofManufacturerList;

    // model
    private List<Long> selectedTofModelList = new ArrayList<Long>();

    private List<SelectItem> availableTofModelList;

    // fuel
    private List<Long> selectedFuelList= new ArrayList<Long>();

    private List<SelectItem> availableFuelList;
    
    private List<WPart> wpartList;

    @PostConstruct
    private void init() {
        availableTofManufacturerList = Functions.tofmanufacturerToSelectItems(tofmanufacturerSercive.findAll());
        availableTofModelList = Functions.tofmodelToSelectItems(tofmodelService.findAll());
        availableFuelList = Functions.fuelToSelectItems(fuelService.findAll());

    }

    public void updateTofModelList() {
        if (selectedTofManufacturer != null) {
            TofManufacturer mk =  tofmanufacturerSercive.findOne(Long.parseLong(selectedTofManufacturer));
            availableTofModelList = Functions.modelToSelectItems(tofmodelService.findByModelGroupTofManufacturerId(mk.getMfaId()));
        } else {
          availableTofModelList = Functions.modelToSelectItems(tofmodelService.findAll());
        }
    }

    public void updateFuelList() {
//      if (selectedModelList != null) {
////            TofManufacturer mk =  manufacturerService.findOne(Long.parseLong(selectedTofManufacturer));
////            availableModelList = Functions.modelToSelectItems(modelService.findByModelGroupTofManufacturerId(mk.getId()));
//          List<Long> modelIdList = selectedModelList.stream().map(m -> ((Model)m.getValue()).getId()).collect(Collectors.toList());
////            List<>
////            availableFuelTypeList
//      } else {
//          availableFuelTypeList = Functions.fuelTypeToSelectItems(fueltypeService.findAll());
//      }
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

    public List<Long> getSelectedTofModelList() {
        return selectedTofModelList;
    }

    public void setSelectedTofModelList(List<Long> selectedTofModelList) {
        this.selectedTofModelList = selectedTofModelList;
    }

    public List<SelectItem> getAvailableTofModelList() {
        return availableTofModelList;
    }

    public void setAvailableTofModelList(List<SelectItem> availableTofModelList) {
        this.availableTofModelList = availableTofModelList;
    }

    public List<Long> getSelectedFuelList() {
        return selectedFuelList;
    }

    public void setSelectedFuelList(List<Long> selectedFuelList) {
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