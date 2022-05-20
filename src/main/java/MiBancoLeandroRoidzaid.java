import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MiBancoLeandroRoidzaid {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miBanco");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		
		System.out.println("Termino");

	}

}
