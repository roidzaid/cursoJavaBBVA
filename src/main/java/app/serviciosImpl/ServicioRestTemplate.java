package app.serviciosImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicioRestTemplate {

	private RestTemplate rt;
	
	public ServicioRestTemplate() {
		this.rt = new RestTemplate();
	}
	
	public RestTemplate getRT() {
		return rt;
	}
}
