package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		// Transient
		Conta conta = new Conta();
		conta.setTitular("julio");
		conta.setAgencia(45075);
		conta.setNumero(123456);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Transient -> Managed
		em.persist(conta);
		
		// Maneged -> Removed
		em.remove(conta);

		em.getTransaction().commit();
		
		
		
	}
}
