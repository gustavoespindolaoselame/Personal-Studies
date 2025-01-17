package alura.desafio.literalura;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    private int count;
    private List<Livro> results;

    public ApiResponse() {
    }

    public ApiResponse(int count, List<Livro> results) {
        this.count = count;
        this.results = results;
    }

    public ApiResponse(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Livro> getResults() {
        return results;
    }

    public void setResults(List<Livro> results) {
        this.results = results;
    }
}
