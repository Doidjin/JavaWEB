package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadoJPA {
	public static void main(String[] args){
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 6);
		System.out.println(conta.getTitular());
		conta.setTitular("Testando");
		System.out.println(conta.getTitular());
		
		manager.getTransaction().commit();
		
		manager.close();
	}
}
