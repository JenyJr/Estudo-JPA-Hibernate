package modelo.basico;

import jakarta.persistence.*;

@Table(name = "produtos")
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //set o nome da coluna ao invés de usar o nome do atributo
    @Column(name = "prod_nome", length = 120, nullable = false)
    private String nome;

    //nullable = campo vazio
    // precision = tamanho total do atributo
    // scale= casa decimais apos a virgula, lembrando que dentro do limite do precision
    @Column(name = "prod_preco", nullable = false)
    private double preco;

    public Produto() {
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
