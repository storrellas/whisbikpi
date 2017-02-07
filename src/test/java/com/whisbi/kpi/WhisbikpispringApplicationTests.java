package com.whisbi.kpi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhisbikpispringApplicationTests {

	@Test
	public void contextLoads() {
	}

    private static final Logger log = LoggerFactory.getLogger(WhisbikpispringApplicationTests.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        String str = restTemplate.getForObject("http://localhost:8080/greeting?kpi=sergi", String.class);
        log.info(str);
        
        str = restTemplate.getForObject("http://localhost:8080/api/interaction?kpi=sergi", String.class);
        log.info(str);
        
    }
	
}
