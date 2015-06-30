package lt.pap.service;

import init.TestConfig;

import java.util.ArrayList;
import java.util.List;

import lt.pap.model.WPart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class WpartServiceTest
{
    @Autowired
    private WPartService wpartService;
    
    
    @Test
    public void test() {
        List<WPart> items = wpartService.findAll() ;
        System.out.println(items.size());
    }
    
    @Test
    public void test2() {
    	List<String> codes = new ArrayList<String>();
    	codes.add("CAYC");
        List<WPart> items = wpartService.findAllByTofEngineEngCodeIn(codes);
        System.out.println(items.size());
    }

}
