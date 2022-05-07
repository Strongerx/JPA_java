package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaTabelas {

	public static void main(String[] args) {
		// Faz a conexão com o banco de dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager createEntityManager = emf.createEntityManager();
		emf.close();
	}

}
