package app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class App2Controller {
	
	//@Autowired
	RestTemplate template = new RestTemplate();
	
	@GetMapping("/callapp2")
	void callapp2() {
		
		String response = template.getForObject("http://localhost:8082/user",String.class);
		System.out.println("callapi2 controller "+response);
	}

}
