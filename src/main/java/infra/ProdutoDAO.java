package infra;

import modelo.basico.Produto;

//herdando todos os metodos da classe DAO e especificando que esse DAO é do tipo Produto
public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO(){
        //chamando o construtor da classe super para saber qual entidade do BD será gerenciado
        super(Produto.class);
    }
}
