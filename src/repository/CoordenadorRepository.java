package repository;

import model.Coordenador;
import java.util.ArrayList;
import java.util.List;

public class CoordenadorRepository {
    private List<Coordenador> coordenadores = new ArrayList<>();

    public void salvar(Coordenador c) {
        coordenadores.add(c);
    }

    public List<Coordenador> listar() {
        return coordenadores;
    }

    public Coordenador buscarPorCpf(String cpf) {
        for (Coordenador c : coordenadores) {
            if (c.cpf.equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public boolean atualizar(String cpf, Coordenador novo) {
        for (int i = 0; i < coordenadores.size(); i++) {
            if (coordenadores.get(i).cpf.equals(cpf)) {
                coordenadores.set(i, novo);
                return true;
            }
        }
        return false;
    }

    public boolean remover(String cpf) {
        return coordenadores.removeIf(c -> c.cpf.equals(cpf));
    }
}
