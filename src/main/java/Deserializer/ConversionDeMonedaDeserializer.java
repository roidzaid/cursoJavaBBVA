package Deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import modelos.ConversionDeMoneda;

public class ConversionDeMonedaDeserializer extends StdDeserializer<ConversionDeMoneda>{

	private static final long serialVersionUID = 1L;

	protected ConversionDeMonedaDeserializer(Class<?> vc) {
		super(vc);
		// TODO Auto-generated constructor stub
	}

	protected ConversionDeMonedaDeserializer() {
		this(null);
	}

	@Override
	public ConversionDeMoneda deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JacksonException {
		JsonNode nodo = p.getCodec().readTree(p);
		ConversionDeMoneda c = new ConversionDeMoneda();
		c.setRate(nodo.get("info").get("rate").asDouble());
		c.setResult(nodo.get("result").asDouble());
		return c;

	}

}
