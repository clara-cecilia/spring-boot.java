package senac.listaTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import senac.listaTarefas.model.Tarefa;


public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

    long countByConcluida(boolean concluida);
}
