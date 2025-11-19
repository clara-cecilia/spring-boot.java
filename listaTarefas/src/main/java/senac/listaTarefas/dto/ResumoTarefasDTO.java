package senac.listaTarefas.dto;

import lombok.Data;

@Data
public class ResumoTarefasDTO {

    private long totalTarefas;
    private long tarefasConcluidas;

    public ResumoTarefasDTO (long totalTarefas, long tarefasConcluidas){
        this.totalTarefas = totalTarefas;
        this.tarefasConcluidas = tarefasConcluidas;

    }
    
}
