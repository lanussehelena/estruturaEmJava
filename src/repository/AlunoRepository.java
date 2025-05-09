package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno salvo no repositório.");
    }

    public List<Aluno> listar() {

        return alunos;
    }

    public Aluno buscarPorCpf(String cpf) {
        for (Aluno a : alunos) {
            if (a.cpf.equals(cpf)) {
                return a;
            }
        }
        return null;
    }

    public boolean atualizar(String cpf, Aluno novoAluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).cpf.equals(cpf)) {
                alunos.set(i, novoAluno);
                return true;
            }
        }
        return false;
    }

    public boolean remover(String cpf) {
        return alunos.removeIf(a -> a.cpf.equals(cpf));
    }
}
