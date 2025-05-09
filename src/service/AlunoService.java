package service;

import model.Aluno;
import repository.AlunoRepository;

public class AlunoService {
    private AlunoRepository repository = new AlunoRepository();

    public void cadastrar(Aluno aluno) {
        repository.salvar(aluno);
    }

    public void listar() {
        for (Aluno a : repository.listar()) {
            a.exibirInformacoes();
            System.out.println("-------------------");
        }
    }

    public Aluno buscar(String cpf) {
        return repository.buscarPorCpf(cpf);
    }

    public boolean atualizar(String cpf, Aluno alunoAtualizado) {
        return repository.atualizar(cpf, alunoAtualizado);
    }

    public boolean remover(String cpf) {
        return repository.remover(cpf);
    }
}
