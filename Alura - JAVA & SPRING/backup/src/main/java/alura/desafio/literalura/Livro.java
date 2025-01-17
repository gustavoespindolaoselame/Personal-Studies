package alura.desafio.literalura;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("authors")
    private List<Autor> autores;
    @JsonProperty("languages")
    private List<String> idiomas;
    @JsonProperty("download_count")
    private double numDownloads;

    public Livro(){}

    public Livro(int id, List<Autor> autores, Autor autor, List<String> idiomas, double numDownloads) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.idiomas = idiomas;
        this.numDownloads = numDownloads;
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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public double getNumDownloads() {
        return numDownloads;
    }

    public void setNumDownloads(double numDownloads) {
        this.numDownloads = numDownloads;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", idiomas=" + idiomas +
                ", numDownloads=" + numDownloads +
                '}';
    }
}
