package DAO;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import configuracion.Configuracion;

public class UsaDAOs {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuracion.class);
		
		
		
		
		((ConfigurableApplicationContext) ctx).close();


	}

}
