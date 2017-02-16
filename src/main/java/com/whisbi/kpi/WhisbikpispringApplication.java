package com.whisbi.kpi;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WhisbikpispringApplication {

    private static final Logger log = LoggerFactory.getLogger(WhisbikpispringApplication.class);
    
    @Autowired
    ClientKpiRepository respository;
	
    @RequestMapping("/api/tracking")
    public ClientKpiKey tracking(@RequestParam String branch, 
    					        @RequestParam String clientbrowser, 
    					        @RequestParam String clientdevice,
    					        @RequestParam String clientos,
    					        @RequestParam String cookieguid,
    					        @RequestParam String kpiguid,
    					        @RequestParam int kpi,
    					        HttpServletRequest request
    					        ) {
    	
    	log.info("Request URL: " + request.getRequestURL().toString() + " " + request.getQueryString());
    	
    	// Generate entity
    	ClientKpiKey client_key = new ClientKpiKey(kpiguid, cookieguid, branch, kpi, clientbrowser, clientdevice, clientos);
    	ClientKpi client = new ClientKpi();
    	client.setId(client_key);

    	// Save to repository
    	respository.save(client);    	
    	return client_key;
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

