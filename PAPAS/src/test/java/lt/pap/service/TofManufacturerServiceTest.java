package lt.pap.service;

import init.InitConfig;

import java.util.List;

import lt.pap.model.TofDesignation;
import lt.pap.model.TofEngine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { InitConfig.class })
public class TofManufacturerServiceTest {
	
	@Autowired
	TofEngineService tofEngineService;

//	@Test
//	@Transactional
//	public void testFindAll() {
//		List<TofEngine> e = tofEngineService.findAll();
////		Hibernate.initialize(e.get(0));
//		List<TofDesignation> l = e.get(0).getKvEngineTranslations();
//		for(TofDesignation d : l) {
//			System.out.println(d);
//		}
//		System.out.println(e.size());
//		fail("Not yet implemented");
//	}

	@Test
	@Transactional
	public void testFindOne() {
		TofEngine e = tofEngineService.findOne(8);
//		Hibernate.initialize(e);
		List<TofDesignation> l = e.getKvEngineTranslations();
		for(TofDesignation d : l) {
			System.out.println(d.getTofDesText().getTexText());
		}
//		fail("Not yet implemented");
	}
}
