package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 6);
		
		manager.getTransaction().commit();
		
		conta.setTitular("Caelum ensino e inovacao");
		manager.getTransaction().begin();
		manager.merge(conta);
		manager.getTransaction().commit();
		
		
		manager.close();

	}

}
