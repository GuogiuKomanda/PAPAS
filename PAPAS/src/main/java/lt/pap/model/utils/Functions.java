package lt.pap.model.utils;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

public class Functions {

	// we assume list already sorted
	public static List<SelectItem> modelsToSelectItems(List<Object[]> list) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		if (list != null && !list.isEmpty()) {
			Map<String, List<SelectItem>> groupToItems = new TreeMap<String, List<SelectItem>>();
			for (Object[] l : list) {
				Integer value = (Integer) l[0];
				String label = (String) l[1];
				String group = label.split(" ")[0];
				SelectItem item = new SelectItem(value, label);
				List<SelectItem> groupItems = groupToItems.get(group);
				if (groupItems == null) {
					groupItems = new ArrayList<SelectItem>();
					groupToItems.put(group, groupItems);
				}
				groupItems.add(item);
			}

			for (String group : groupToItems.keySet()) {
				SelectItemGroup sig = new SelectItemGroup(group);
				List<SelectItem> sil = groupToItems.get(group);
				sig.setSelectItems(sil.toArray(new SelectItem[sil.size()]));
				items.add(sig);
			}

		}
		return items;
	}
	
	public static List<SelectItem> yearsAsSelectItems(int from, int to) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for(int i = from; i <= to; i++) {
			SelectItem item = new SelectItem();
			item.setValue(Year.of(i));
			item.setLabel(""+i);
			items.add(item);
		}
		return items;
	}
}
