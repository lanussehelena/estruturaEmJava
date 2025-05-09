package service;

import model.Professor;
import repository.ProfessorRepository;

public class ProfessorService {
    private ProfessorRepository repository = new ProfessorRepository();

    public void cadastrar(Professor p) {
        repository.salvar(p);
    }

    public void listar() {
        for (Professor p : repository.listar()) {
            p.exibirInformacoes();
            System.out.println("-------------------");
        }
    }

    public Professor buscar(String cpf) {
        return repository.buscarPorCpf(cpf);
    }

    public boolean atualizar(String cpf, Professor p) {
        return repository.atualizar(cpf, p);
    }

    public boolean remover(String cpf) {
        return repository.remover(cpf);
    }
}
