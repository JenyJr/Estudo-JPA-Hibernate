package teste.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.basico.Usuario;

public class AlterarUsuario3   {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 4);

        //o detach ele torna o objeto nao gerenciado, ou seja, eu preciso usar o merge no final da alteração,
        // para que as alterações no banco de dados sejam atualizadas
        em.detach(usuario);
        usuario.setNome("jay");
        usuario.setEmail("jay@email.com");

        em.merge(usuario);
        em.getTransaction().commit();

        em.close();
        emf.close();


    }
}
