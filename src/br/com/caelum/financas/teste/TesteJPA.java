package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

    public static void main(String[] args) {
    	
    	double inicio = System.currentTimeMillis();
    	double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
    	
    	Conta conta = new Conta();
    	conta.setId(8);
        conta.setTitular("Mario Santos");
        conta.setBanco("Itau");
        conta.setNumero("54321");
        conta.setAgencia("2323");


        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();
        
        Conta removeConta = manager.find(Conta.class, 6);
        //System.out.println(removeConta.getTitular());
        //manager.remove(removeConta);
        //Para remover qualquer entidade, ela precisa estar managed
        //manager.merge(conta);
        //O merge faz um objeto Detached voltar a ser Managed
        
        manager.getTransaction().commit();
        
        
        manager.close();
    }
}