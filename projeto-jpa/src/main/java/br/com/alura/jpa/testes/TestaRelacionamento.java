package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamento {
	public static void main(String[] args) {
		// Faz a conexão com o banco de dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setAgencia(1234);
		conta.setNumero(12345);
		conta.setSaldo(300.0);
		conta.setTitular("Leonardo");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);

		movimentacao.setConta(conta);

		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		
		em.close();
	}
}
