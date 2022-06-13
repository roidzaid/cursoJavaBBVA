package app.serviciosImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import app.modelos.ConversionDeMoneda;
import app.servicios.ServicioCambio;

@Service
public class ServicioCambioImpl implements ServicioCambio{

	@Autowired
	private ServicioRestTemplate template;
	
	@Override
	public ConversionDeMoneda cambiar(String monedaDE, String monedaA, Double monto) {
		
		String amount = monto.toString();
		
		Map<String,String> urlVariables = new HashMap<>();
		urlVariables.put("to", monedaA);
		urlVariables.put("from", monedaDE);
		urlVariables.put("amount", amount);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", "906bohkfFYjvKwPu44ILvO16MGqK0M4L");
		
		HttpEntity<Void> httpentity = new HttpEntity<>(headers);
		
		ResponseEntity<ConversionDeMoneda> respuesta = template.getRT().exchange(
				"https://api.apilayer.com/exchangerates_data/convert?to={to}&from={from}&amount={amount}", HttpMethod.GET, httpentity, ConversionDeMoneda.class, urlVariables);
		
		return respuesta.getBody();
		
		//System.out.println(respuesta.getBody().toString());
		
		
	}
}
