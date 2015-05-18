package lt.pap.service;

import static org.junit.Assert.fail;
import init.InitConfig;

import java.util.List;
import java.util.Set;

import lt.pap.model.TofDesignation;
import lt.pap.model.TofEngine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { InitConfig.class })
public class TofManufacturerServiceTest {
	
	@Autowired
	TofEngineService tofEngineService;

	@Test
	public void testFindAll() {
		List<TofEngine> e = tofEngineService.findAll();
		Set<TofDesignation> l = e.get(0).getKvEngineTranslations();
		for(TofDesignation d : l) {
			System.out.println(d);
		}
		System.out.println(e.size());
		fail("Not yet implemented");
	}

}
