package controller;

import model.Aluno;
import service.AlunoService;

public class AlunoController {
    private AlunoService service = new AlunoService();

    public void avaliarAluno(String nome, double nota) {
        Aluno aluno = new Aluno();
        aluno.nome = nome;
        aluno.nota = nota;

        String resultado = service.classificar(aluno);

        System.out.println("O aluno " + aluno.nome + " foi: " + resultado);
    }

    public void listarAlunos() {
        service.mostrarTodosAlunos();
    }
}
