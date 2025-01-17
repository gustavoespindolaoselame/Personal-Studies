package alura.desafio.literalura;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {
    @JsonProperty("name")
    private String nome;
    @JsonProperty("birth_year")
    private int anoNasc;
    @JsonProperty("death_year")
    private int anoMort;

    public Autor(){

    }

    public Autor(String nome, int anoNasc, int anoMort) {
        this.nome = nome;
        this.anoNasc = anoNasc;
        this.anoMort = anoMort;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public int getAnoMort() {
        return anoMort;
    }

    public void setAnoMort(int anoMort) {
        this.anoMort = anoMort;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", anoNasc=" + anoNasc +
                ", anoMort=" + anoMort +
                '}';
    }
}
