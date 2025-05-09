package controller;

import model.Professor;
import service.ProfessorService;

import java.util.Scanner;

public class ProfessorController {
    private ProfessorService service = new ProfessorService();
    private Scanner scanner = new Scanner(System.in);

    public void menuProfessor() {
        int opcao;
        do {
            System.out.println("\n--- Menu Professor ---");
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
                case 2 -> service.listar();
                case 3 -> buscar();
                case 4 -> atualizar();
                case 5 -> remover();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public void cadastrar() {
        Professor p = new Professor();
        System.out.print("Nome: ");
        p.nome = scanner.nextLine();
        System.out.print("CPF: ");
        p.cpf = scanner.nextLine();
        System.out.print("Email: ");
        p.email = scanner.nextLine();
        System.out.print("Disciplina: ");
        p.setDisciplina(scanner.nextLine());
        service.cadastrar(p);
    }

    public void buscar() {
        System.out.print("CPF: ");
        Professor p = service.buscar(scanner.nextLine());
        if (p != null) p.exibirInformacoes();
        else System.out.println("Não encontrado.");
    }

    public void atualizar() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (service.buscar(cpf) == null) {
            System.out.println("Não encontrado.");
            return;
        }
        Professor p = new Professor();
        System.out.print("Novo nome: ");
        p.nome = scanner.nextLine();
        p.cpf = cpf;
        System.out.print("Novo email: ");
        p.email = scanner.nextLine();
        System.out.print("Nova disciplina: ");
        p.setDisciplina(scanner.nextLine());

        if (service.atualizar(cpf, p)) System.out.println("Atualizado.");
    }

    public void remover() {
        System.out.print("CPF: ");
        if (service.remover(scanner.nextLine())) System.out.println("Removido.");
        else System.out.println("Não encontrado.");
    }
}
