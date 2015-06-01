package lt.pap.service;

import init.TestConfig;

import java.util.List;

import javax.faces.model.SelectItem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class TofModelServiceTest {
	
	@Autowired
	private TofModelService tofModelService;

	@Test
	public void test() {
		List<SelectItem> items = tofModelService.findModelsForSelect((short)511, 248, (short)4);
		System.out.println(items.size());
	}

}
