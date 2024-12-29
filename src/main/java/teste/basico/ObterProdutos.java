package teste.basico;

import infra.ProdutoDAO;
import infra.UsuarioDAO;
import modelo.basico.Produto;
import modelo.basico.Usuario;

import java.util.List;

public class ObterProdutos {

    public static void main(String[] args) {

        //criando o dao generico do tipo produto
        ProdutoDAO dao = new ProdutoDAO();

        List<Produto> produtos = dao.obterTodos();

        for (Produto p: produtos){
            System.out.println("ID: " + p.getId() +
                    " Nome: " + p.getNome());
        }

        double precoTotal = produtos
                .stream()

                //filtrar a colecao
                .map(p -> p.getPreco())

                //reduce: acumulador de valores de um stream
                .reduce(0.0, Double::sum)
                .doubleValue();

        System.out.println();

        System.out.println("Preço total: " + precoTotal);

        System.out.println();

        UsuarioDAO daoUser = new UsuarioDAO();
        List<Usuario> usuarios = daoUser.obterTodos();

        for (Usuario u: usuarios){
            System.out.println("Nome: " + u.getNome());
        }



        dao.fechar();
        daoUser.fechar();
    }
}
