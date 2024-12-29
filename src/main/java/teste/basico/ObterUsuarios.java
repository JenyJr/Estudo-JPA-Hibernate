package teste.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import modelo.basico.Usuario;

import java.util.List;

public class ObterUsuarios {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao");
        EntityManager em = emf.createEntityManager();

        //codigo consulta no banco de dados
        String jpql = "select u from Usuario u";

        //o typedquerry ele cria uma consulta retornando uma consulta do tipo da entidade especifica,
        //usado quando quero fazer uma consulta e retornar todos os atributos da entidade. Quando desejo apenas atributos
        // especificos, criar um typedquerry do tipo object[]
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);

        //limita a pesquisa em 6 resultados
        query.setMaxResults(6);

        //cria uma lista para armazenar os resultados da pesquisa
        List<Usuario> usuarios = query.getResultList();

        //imprime os valores
        for (Usuario usuario: usuarios){
            System.out.println("Id: " + usuario.getId() + " Email: " + usuario.getEmail());
        }


        em.close();
        emf.close();
    }
}
