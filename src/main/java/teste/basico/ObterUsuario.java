package teste.basico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.basico.Usuario;

public class ObterUsuario {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao");
        EntityManager em = emf.createEntityManager();


        //o find ele procura no BD o alvo a ser procurado(chave primaria) e retorna uma instancia da entidade se encontrada
        //o primeiro parametro é a classe entidade em que eu quero selecionar no BD
        // o segundo parametro é a chave primaria
        Usuario user = em.find(Usuario.class, 1);

        if (user!= null){
            System.out.println("Usuario encontrdo: " + user.getNome());
        }else {
            System.out.println("Usuario não encontrado!");
        }

        em.close();
        emf.close();

    }
}
