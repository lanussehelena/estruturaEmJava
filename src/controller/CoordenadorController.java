package controller;

import model.Coordenador;
import service.CoordenadorService;

import java.util.Scanner;

public class CoordenadorController {
    private CoordenadorService service = new CoordenadorService();
    private Scanner scanner = new Scanner(System.in);

    public void menuCoordenador() {
        int opcao;
        do {
            System.out.println("\n--- Menu Coordenador ---");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por CPF");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> atualizar();
                case 5 -> remover();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void cadastrar() {
        Coordenador coord = new Coordenador();
        System.out.print("Nome: ");
        coord.nome = scanner.nextLine();
        System.out.print("CPF: ");
        coord.cpf = scanner.nextLine();
        System.out.print("Email: ");
        coord.email = scanner.nextLine();
        System.out.print("Departamento: ");
        coord.setDepartamento(scanner.nextLine());

        service.cadastrar(coord);
        System.out.println("Coordenador cadastrado com sucesso!");
    }

    public void listar() {
        System.out.println("\n=== Lista de Coordenadores ===");
        service.listar();
    }

    public void buscar() {
        System.out.print("Digite o CPF do coordenador: ");
        String cpf = scanner.nextLine();
        Coordenador coord = service.buscar(cpf);
        if (coord != null) {
            coord.exibirInformacoes();
        } else {
            System.out.println("Coordenador não encontrado.");
        }
    }

    public void atualizar() {
        System.out.print("Digite o CPF do coordenador a atualizar: ");
        String cpf = scanner.nextLine();

        Coordenador existente = service.buscar(cpf);
        if (existente == null) {
            System.out.println("Coordenador não encontrado.");
            return;
        }

        Coordenador novo = new Coordenador();
        System.out.print("Novo nome: ");
        novo.nome = scanner.nextLine();
        novo.cpf = cpf;
        System.out.print("Novo email: ");
        novo.email = scanner.nextLine();
        System.out.print("Novo departamento: ");
        novo.setDepartamento(scanner.nextLine());

        if (service.atualizar(cpf, novo)) {
            System.out.println("Coordenador atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar coordenador.");
        }
    }

    public void remover() {
        System.out.print("Digite o CPF do coordenador a remover: ");
        String cpf = scanner.nextLine();

        if (service.remover(cpf)) {
            System.out.println("Coordenador removido com sucesso!");
        } else {
            System.out.println("Coordenador não encontrado.");
        }
    }
}
