package teste.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.basico.Usuario;

public class AlterarUsuario1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //criando um objeto para armazenar o usuario a ser localizado, passando como parametro a classe entidade
        // que vai ser consultada, e o id do objeto
        Usuario usuario = em.find(Usuario.class, 1);

        //alterando os valores do objeto
        usuario.setNome("Jeni");
        usuario.setEmail("jeni@email.com");

        //o merge ele altera(update) um usuario que ja existe no banco e persiste ele, nao necessariamente precisa
        //chamar o merge, todo objeto gerenciado, implicitamente altera automaticamente
        em.merge(usuario);


        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
