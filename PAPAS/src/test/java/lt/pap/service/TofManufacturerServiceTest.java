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
public class TofManufacturerServiceTest {

	@Autowired
	private TofManufacturerService manufacturerService;

//	@Test
	public void test() {
		List<SelectItem> items = manufacturerService.findManufacturersForSelect();
		System.out.println(items.size());
	}

	@Test
	public void test2() {

	}
}
