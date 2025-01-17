package alura.chatforum.chatforum.controller;

import alura.chatforum.chatforum.model.Duvida;
import alura.chatforum.chatforum.repositories.DuvidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos/")
public class DuvidaController {

    @Autowired
    private DuvidaRepository duvidaRepository;

    @PostMapping
    public Duvida createDuvida(@RequestBody Duvida duvida){
        return duvidaRepository.save(duvida);
    }

    @GetMapping
    public Iterable<Duvida> getAllDuvida(){
        return duvidaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Duvida getDuvidaById(@PathVariable Long id){
        return duvidaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Duvida updateDuvida(@PathVariable Long id, @RequestBody Duvida update){
        return duvidaRepository.findById(id).map(duvida -> {
            duvida.setId(update.getId());
            duvida.setMensagem(update.getMensagem());
            duvida.setTitulo(update.getTitulo());
            duvida.setDataCriacao(update.getDataCriacao());
            return duvidaRepository.save(duvida);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteDuvida(@PathVariable Long id){
        duvidaRepository.deleteById(id);
    }
}
