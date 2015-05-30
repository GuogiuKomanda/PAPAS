package lt.pap.model.utils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import lt.pap.model.Fuel;
import lt.pap.model.TofManufacturer;
import lt.pap.model.TofModel;

import org.springframework.ui.Model;



public class Functions
{
    private static  Function<TofManufacturer, SelectItem> tofmanufacturerToSelectItem = new Function<TofManufacturer, SelectItem>() {

        public SelectItem apply(TofManufacturer tofmanufacturer) {
            SelectItem item = new SelectItem();
            item.setLabel(tofmanufacturer.getMfaBrand());
            item.setValue(tofmanufacturer.getMfaId());
            return item;
        }
    };
    
//  private static  Function<ModelGroup, SelectItem> modelGroupToSelectItem = new Function<ModelGroup, SelectItem>() {
//
//      public SelectItem apply(ModelGroup modelGroup) {
//          SelectItemGroup group = new SelectItemGroup(modelGroup.getName());
//          SelectItem[] items =  modelGroup.getModelList().stream().map(modelToSelectItem).toArray(SelectItem[]::new);
//          group.setSelectItems(items);
//          return group;
//      }
//  };
    /*
    private static BiFunction<ModelGroup, List<Model>, SelectItem> modelGroupToSelectItem = new BiFunction<ModelGroup, List<Model>, SelectItem>() {

        @Override
        public SelectItem apply(ModelGroup modelGroup, List<Model> modelList) {
            SelectItemGroup group = new SelectItemGroup(modelGroup.getName());
            SelectItem[] items =  modelList.stream().map(modelToSelectItem).toArray(SelectItem[]::new);
            group.setSelectItems(items);
            return group;
        }
        
    };
    */
    private static  Function<TofModel, SelectItem> tofmodelToSelectItem = new Function<TofModel, SelectItem>() {

        public SelectItem apply(TofModel tofmodel) {
            SelectItem item = new SelectItem();
            item.setLabel(tofmodel.getModString());
            item.setValue(tofmodel.getModId());
            return item;
        }
    };
    
    private static  Function<Fuel, SelectItem> fuelToSelectItem = new Function<Fuel, SelectItem>() {

        public SelectItem apply(Fuel ft) {
            SelectItem item = new SelectItem();
            item.setLabel(ft.getDesId().toString());
            item.setValue(ft.getDesId());
            return item;
        }
    };
    
    public static List<SelectItem> tofmanufacturerToSelectItems(List<TofManufacturer> tofmanufacturerList) {
        return  tofmanufacturerList.stream().map(tofmanufacturerToSelectItem).collect(Collectors.toList());
    }
    
    public static List<SelectItem> tofmodelToSelectItems(List<TofModel> tofmodelList) {
        return  tofmodelList.stream().map(tofmodelToSelectItem).collect(Collectors.toList());
        }
    
    public static List<SelectItem> fuelToSelectItems(List<Fuel> fuelList) {
        return  fuelList.stream().map(fuelToSelectItem).collect(Collectors.toList());
    }
    
    
  
    public static List<Integer> tofmodelListToId(List<TofModel> tofmodelList) {
      return tofmodelList.stream().map(i -> i.getModId()).collect(Collectors.toList());
    }
        public static List<Integer> fuelListToId(List<Fuel> fuelList) {
      return fuelList.stream().map(i -> i.getDesId()).collect(Collectors.toList());
    }
}
