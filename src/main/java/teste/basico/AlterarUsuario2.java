package teste.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.basico.Usuario;

public class AlterarUsuario2 {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence
                .createEntityManagerFactory("conexao");
        EntityManager em =
                emf
                .createEntityManager();

        em.getTransaction()
                .begin();

        Usuario usuario = em.find(Usuario.class, 3);
        usuario.setEmail("jp@email.com");
        usuario.setNome("Jp");

       // em.merge(usuario);

        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}
