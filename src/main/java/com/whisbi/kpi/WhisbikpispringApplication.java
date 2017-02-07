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

import com.whisbi.kpi.InteractionKpi.interaction_type;
import com.whisbi.kpi.InteractionKpi.room_type;
import com.whisbi.kpi.InteractionKpi.room_user_type;

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
    public ClientKpi tracking(@RequestParam String branch, 
    					        @RequestParam String clientbrowser, 
    					        @RequestParam String clientdevice,
    					        @RequestParam String clientos,
    					        @RequestParam String cookieguid,
    					        @RequestParam String kpiguid,
    					        @RequestParam String kpi,
    					        HttpServletRequest request
    					        ) {
    	
    	log.info("Request URL: " + request.getRequestURL().toString() + " " + request.getQueryString());
    	return new ClientKpi(branch, clientbrowser, clientdevice, clientos, cookieguid, kpiguid, kpi);
    }
    

    @RequestMapping("/api/interaction")
    public InteractionKpi interaction(@RequestParam int interaction_code, 
    					        @RequestParam String interaction_value, 
    					        @RequestParam String session_guid,
    					        @RequestParam int user_id,
    					        @RequestParam int user_type,
    					        @RequestParam int room_type,
    					        HttpServletRequest request
    					        ) {    	
    	log.info("Request URL: " + request.getRequestURL().toString() + "?" + request.getQueryString());
    	    	
    	InteractionKpi.interaction_type interaction_type_enum = InteractionKpi.interaction_type.values()[interaction_code];
    	InteractionKpi.room_user_type user_type_enum = InteractionKpi.room_user_type.values()[user_type];
    	InteractionKpi.room_type room_type_enum = InteractionKpi.room_type.values()[room_type];   	
    	return new InteractionKpi(interaction_type_enum, session_guid, user_id, interaction_value, user_type_enum, room_type_enum);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(WhisbikpispringApplication.class, args);
	}
}

