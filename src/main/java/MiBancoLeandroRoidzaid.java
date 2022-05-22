import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MiBancoLeandroRoidzaid {

	public static void main(String[] args){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/contexto-jpa.xml");

		
//		Direccion direccion = new Direccion("Juan Larrea", 460, "D", 1, "Moron", 1708, "Buenos Aires");
//		Cliente cliente = new Cliente("Leandro", "Roidzaid", direccion, 1151040420, "Roidzaid@gmail.com");
		
		
		
		
		System.out.println("Termino");

	}

}
