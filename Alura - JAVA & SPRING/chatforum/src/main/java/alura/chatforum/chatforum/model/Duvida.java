package alura.chatforum.chatforum.model;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "duvidas")
@Entity(name = "duvida")
public class Duvida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String mensagem;
    private Date dataCriacao;

    public Duvida() {
        super();
        this.dataCriacao = new Date();
    }

    public Duvida(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
