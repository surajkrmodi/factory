package app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class App2Controller {
	
	@Autowired
	//@LoadBalanced
	RestTemplate template ;
	
	@GetMapping("/callapp2")
	public void callapp2() {
		
		String response = template.getForObject("http://APP1/user",String.class);
		System.out.println("callapi2 controller "+response);
	}

}
