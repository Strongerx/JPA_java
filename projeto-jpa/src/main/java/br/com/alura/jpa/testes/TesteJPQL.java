package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {
	public static void main(String[] args) {
		// Faz a conexão com o banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(2L);
        // Cria um String JPQL
        String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";

        TypedQuery query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pConta", conta);
        List<Movimentacao> resultList = query.getResultList();
        // Lista a movimentação
        for (Movimentacao movimentacao : resultList) {
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
    }
}
}