package modelos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import Deserializer.ConversionDeMonedaDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = ConversionDeMonedaDeserializer.class)
public class ConversionDeMoneda {
	
	private Double rate;
	private Double result;
	
	
}
