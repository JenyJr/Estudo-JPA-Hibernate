package teste.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.basico.Usuario;

public class Insert {
    public static void main(String[] args) {
        //Usado para armazenar instâncias do EntityManager, o emf salva a conexão com o BD.
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("conexao");

        //cria um objeto e recebe o emf para manipulação de dados, o EM vai ser responsavel em realizar o crud
        EntityManager em = emf.createEntityManager();

        //usado para iniciar uma transação no BD.
        em.getTransaction().begin();

        //apos o begin, usa-se o persist para enviar os dados para o BD.
        em.persist(new Usuario("lucineide", "lucineide@email.com.br"));

        //o commit ele confirma e envia os dados para o BD.
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
