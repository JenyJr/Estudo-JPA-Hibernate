package infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAO<E> {

    //atributo estatico, para todo DAO criado, ele automaticamente vai inicializar esse metodo
    private static EntityManagerFactory emf;

    private EntityManager em;

    //atributo que vai armazenar a entidade
    private Class<E> classe;

    //bloco statico que vai garantir que todo DAO compartilhe do mesmo emf(banco de dados)
    static {
        try {
            emf = Persistence.createEntityManagerFactory("conexao");
        }catch (Exception e){
            System.out.println("Falha ao estabelecer conexão com o banco de dados");
        }
    }

    //construtor padrao recebendo nulo para herdar a logica do parametrizado
    public DAO(){
        this(null);
    }

    //construtor parametrizado que recebe a entidade e cria o entitymanager para essa entidade
    public DAO(Class<E> classe){
        this.classe = classe;
        em = emf.createEntityManager();
    }

    //metodos usando o return this, possibilitando o encapsulamento.
    public DAO<E> abrirT(){
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> inserirT(E entidade){
        em.persist(entidade);
        return this;
    }

    public DAO<E> fecharT(){
        if (em != null && em.isOpen()){
            em.getTransaction().commit();
        }
        return this;
    }

    //encapsulamento de metodos.
    public DAO<E> IncluirTudo(E entidade){
        return abrirT().inserirT(entidade).fecharT();
    }

    public List<E> obterTodos(){
        return this.obterTodos(10, 0);
    }


    public List<E> obterTodos(int qnt, int deslocamento){
        if (classe == null){
            throw new UnsupportedOperationException("Classe nula");
        }
        //comando sql
        String jpql = "select e from " + classe.getName() + "e";

        //criando uma consulta no BD
        TypedQuery<E> querry = em.createQuery(jpql, classe);
        querry.setMaxResults(qnt);
        querry.setFirstResult(deslocamento);
        return  querry.getResultList();
    }
}
