package lt.pap.service;

import static org.junit.Assert.fail;
import init.InitConfig;

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
		fail("Not yet implemented");
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

}
