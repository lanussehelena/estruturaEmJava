package repository;

import model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private List<Professor> professores = new ArrayList<>();

    public void salvar(Professor p) {
        professores.add(p);
    }

    public List<Professor> listar() {
        return professores;
    }

    public Professor buscarPorCpf(String cpf) {
        for (Professor p : professores) {
            if (p.cpf.equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public boolean atualizar(String cpf, Professor novoProf) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).cpf.equals(cpf)) {
                professores.set(i, novoProf);
                return true;
            }
        }
        return false;
    }

    public boolean remover(String cpf) {
        return professores.removeIf(p -> p.cpf.equals(cpf));
    }
}
