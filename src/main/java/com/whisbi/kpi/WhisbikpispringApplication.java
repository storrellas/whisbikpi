package com.whisbi.kpi;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.whisbi.api.WhisbigatewayapiApplication.EventLogin;
import com.whisbi.api.WhisbigatewayapiApplication.EventLogout;

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
    					        HttpServletRequest request) 
    {
    	
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
    	    	
    	InteractionKpiKey.interaction_type interaction_type_enum = InteractionKpiKey.interaction_type.values()[interaction_code];
    	InteractionKpiKey.room_user_type user_type_enum = InteractionKpiKey.room_user_type.values()[user_type];
    	InteractionKpiKey.room_type room_type_enum = InteractionKpiKey.room_type.values()[room_type];
    	InteractionKpiKey interaction_key = 
    			new InteractionKpiKey(interaction_type_enum, session_guid, user_id, interaction_value, user_type_enum, room_type_enum);
    	
    	InteractionKpi interaction = new InteractionKpi();
    	interaction.setId(interaction_key);
    	return interaction;
    }
        
    
    /*
    curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST 
    -d '{"agent_id":"587A179B-7097-46EC-B2E8-89D435975252"}' 
    http://localhost:8080/api/login/
    */
    public static class EventLogin{
		public String event = "login";
		public String agent_id;
    }   
	@RequestMapping(value = "/api/login/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public String login(@RequestBody EventLogin event_login, HttpServletRequest request) {
		log.info("Body: " + event_login.agent_id);
		
		// Login request to LM 
		RestTemplate restTemplate = new RestTemplate(); 
		String str = restTemplate.postForObject("http://localhost:8011/", event_login, String.class);
		log.info(str);
		return str;
	}
    

    /*
	curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST 
	-d '{"agent_id":"587A179B-7097-46EC-B2E8-89D435975252", "session":"3a7773a8-3a13-489d-adac-561057e922cb"}' 
	http://localhost:8080/api/logout/
    */
    public static class EventLogout{
		public String event = "logout";
		public String agent_id;
		public String session;
    }
	@RequestMapping(value = "/api/logout/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public String logout(@RequestBody EventLogout event_logout, HttpServletRequest request) {
		log.info("Body: " + event_logout.agent_id + " " + event_logout.session);
				
		// Login request to LM 
		RestTemplate restTemplate = new RestTemplate(); 
		String str = restTemplate.postForObject("http://localhost:8011/", event_logout, String.class); 
		log.info(str);
		return str;
	}
    
	public static void main(String[] args) {
		SpringApplication.run(WhisbikpispringApplication.class, args);
	}
}

