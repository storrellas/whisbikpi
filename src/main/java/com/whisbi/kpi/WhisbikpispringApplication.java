package com.whisbi.kpi;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WhisbikpispringApplication {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private static final Logger log = LoggerFactory.getLogger(WhisbikpispringApplication.class);
    
	
    @RequestMapping("/kpi")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/api/tracking")
    public Greeting interaction(@RequestParam String branch, 
    					        @RequestParam String clientbrowser, 
    					        @RequestParam String clientdevice,
    					        @RequestParam String clientos,
    					        @RequestParam String cookieguid,
    					        @RequestParam String kpiguid,
    					        @RequestParam String kpi,
    					        HttpServletRequest request
    					        ) {
    	
    	log.info("Request URL: " + request.getRequestURL().toString() + " " + request.getQueryString());
    	new ClientKpi(branch, clientbrowser, clientdevice, clientos, cookieguid, kpiguid, kpi);
    	
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, "sergi"));
    }
    
	public static void main(String[] args) {
		SpringApplication.run(WhisbikpispringApplication.class, args);
	}
}
