package lt.pap.service;

import init.InitConfig;

import java.util.List;

import lt.pap.model.TofEngine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { InitConfig.class })
public class TofEngineServiceTest {

	private static short LOCALE_ID = 34; 

	@Autowired
	TofEngineService tofEngineService;

	@Test
	@Transactional
	public void testFindAll() {
		List<TofEngine> eList = tofEngineService.findAll(LOCALE_ID);
		for (TofEngine e : eList) {
			System.out.println(e.getEngKvEngineString());
		}
		
		eList = tofEngineService.findAll(LOCALE_ID);
		for (TofEngine e : eList) {
			System.out.println(e.getEngKvEngineString());
		}
	}

	@Test
	@Transactional
	public void testFindOne() {
		TofEngine e = tofEngineService.findOne(3, LOCALE_ID);
		System.out.println(e.getEngKvEngineString());
	}
}
