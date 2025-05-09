package service;

import model.Coordenador;
import repository.CoordenadorRepository;

public class CoordenadorService {
    private CoordenadorRepository repository = new CoordenadorRepository();

    public void cadastrar(Coordenador c) {
        repository.salvar(c);
    }

    public void listar() {
        for (Coordenador c : repository.listar()) {
            c.exibirInformacoes();
            System.out.println("-------------------");
        }
    }

    public Coordenador buscar(String cpf) {
        return repository.buscarPorCpf(cpf);
    }

    public boolean atualizar(String cpf, Coordenador c) {
        return repository.atualizar(cpf, c);
    }

    public boolean remover(String cpf) {
        return repository.remover(cpf);
    }
}
