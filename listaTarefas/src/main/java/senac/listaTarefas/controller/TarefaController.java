package senac.listaTarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import senac.listaTarefas.dto.ResumoTarefasDTO;
import senac.listaTarefas.model.Tarefa;
import senac.listaTarefas.service.TarefaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List <Tarefa> getAllTarefas(){
        return tarefaService.listarTodasTarefas();
    }

    @PostMapping
    public Tarefa createTarefa(@Valid @RequestBody Tarefa tarefa) {
        //TODO: process POST request
        return tarefaService.criarTarefa(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa updateTarefa(@PathVariable Long id, @Valid @RequestBody Tarefa tarefaDetalhes) {
        //TODO: process PUT request
        
        return tarefaService.atualizarTarefa(id, tarefaDetalhes);
    }

    @DeleteMapping("/{id}")
    public void deleteTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
    }

    @GetMapping("/resumo")
    public ResumoTarefasDTO getResumo(){
        return tarefaService.getResumoTarefas();
    }
    
    
     
    @GetMapping("/hello")
    public String hello(){
        return "Ola, API de tarefas";
    }
}
