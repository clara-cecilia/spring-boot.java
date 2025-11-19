package senac.listaTarefas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import senac.listaTarefas.dto.ResumoTarefasDTO;
import senac.listaTarefas.model.Tarefa;
import senac.listaTarefas.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;



    public List<Tarefa> listarTodasTarefas(){
        return tarefaRepository.findAll();
    }

    public Tarefa criarTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefaDetalhes){
        Tarefa tarefaExistente = tarefaRepository.findById(id).orElseThrow (() -> new RuntimeException("Tarefa não encontrada com o id: "+id));
    
        tarefaExistente.setTitulo(tarefaDetalhes.getTitulo());
        tarefaExistente.setDescricao(tarefaDetalhes.getDescricao());
        tarefaExistente.setConcluida(tarefaDetalhes.isConcluida());

        return tarefaRepository.save(tarefaExistente);
    }

    public void deletarTarefa(Long id){
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o id: "+ id));
    
        tarefaRepository.delete(tarefa);
    }

    public ResumoTarefasDTO getResumoTarefas(){
        long totalTarefas = tarefaRepository.count();

        long tarefasConcluidas = tarefaRepository.countByConcluida(true);

        return new ResumoTarefasDTO(totalTarefas, tarefasConcluidas);
    }
}
