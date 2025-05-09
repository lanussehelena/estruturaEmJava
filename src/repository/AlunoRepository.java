package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private List<Aluno> bancoDeAlunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        bancoDeAlunos.add(aluno);
        System.out.println("Aluno salvo no repositório.");
    }

    public List<Aluno> listarTodos() {
        return bancoDeAlunos;
    }
}
