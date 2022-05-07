package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		
		// Faz a conexão com o banco de dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setNumero(1234); 
		conta.setAgencia(4321);

		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
	}

}
