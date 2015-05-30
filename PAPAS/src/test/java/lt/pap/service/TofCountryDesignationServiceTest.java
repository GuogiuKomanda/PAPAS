package lt.pap.service;

import init.InitConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { InitConfig.class })
public class TofCountryDesignationServiceTest {
    private static short LOCALE_ID = 34; 
	@Autowired
	TofCountryDesignationService tofCountryDesignationService;
	
	@Test
	public void findOneTest() {
		String tcd = tofCountryDesignationService.getCountryDesignationString(541002222, 186, LOCALE_ID);
		System.out.println(tcd);
	}

}
