package modelo.basico;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//anotação obrigatória, define que a classe é uma entidade no banco de dados
@Entity
public class Usuario {
// anotação obrigatória, define que o atributo é a chave primária do banco de dados e terá um gerador auto incremetado(generatedvalue)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String email;

    public Usuario() {
    }

    public Usuario(String nome, String email) {
        super();
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}