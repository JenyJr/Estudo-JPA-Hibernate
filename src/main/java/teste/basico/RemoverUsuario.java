package teste.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.basico.Usuario;

public class RemoverUsuario {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao");
        EntityManager em = emf.createEntityManager();

        //objeto que armazena o usuario selecionado no banco de dados
        Usuario usuario = em.find(Usuario.class, 7);


        //verificar se o usuario se encontra no banco de dados e assim remover. lembrando que qualquer
        //atualização no banco de dados, precisa estar em uma transação
        if (usuario !=null){
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }
}
