package service;

import model.Aluno;
import repository.AlunoRepository;

public class AlunoService {
    private AlunoRepository repository = new AlunoRepository();

    public String classificar(Aluno aluno) {
        String resultado = aluno.nota >= 7 ? "Aprovado" : "Reprovado";
        repository.salvar(aluno);
        return resultado;
    }

    public void mostrarTodosAlunos() {
        System.out.println("\n=== Alunos cadastrados ===");
        for (Aluno a : repository.listarTodos()) {
            System.out.println(a.nome + " - Nota: " + a.nota);
        }
    }
}
