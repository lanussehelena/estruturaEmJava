package controller;

import model.Aluno;
import service.AlunoService;

import java.util.Scanner;

public class AlunoController {
    private AlunoService service = new AlunoService();
    private Scanner scanner = new Scanner(System.in);

    public void menuAluno() {
        int opcao;
        do {
            System.out.println("\n--- Menu Aluno ---");
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
                case 1 -> cadastrarAluno();
                case 2 -> listarAlunos();
                case 3 -> buscarAluno();
                case 4 -> atualizarAluno();
                case 5 -> removerAluno();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public void cadastrarAluno() {
        Aluno aluno = new Aluno();
        System.out.print("Nome: ");
        aluno.nome = scanner.nextLine();
        System.out.print("CPF: ");
        aluno.cpf = scanner.nextLine();
        System.out.print("Email: ");
        aluno.email = scanner.nextLine();
        System.out.print("Nota: ");
        aluno.setNota(scanner.nextDouble());
        scanner.nextLine();

        service.cadastrar(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void listarAlunos() {
        service.listar();
    }

    public void buscarAluno() {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        Aluno aluno = service.buscar(cpf);
        if (aluno != null) {
            aluno.exibirInformacoes();
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void atualizarAluno() {
        System.out.print("CPF do aluno a atualizar: ");
        String cpf = scanner.nextLine();

        Aluno alunoExistente = service.buscar(cpf);
        if (alunoExistente == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        Aluno novoAluno = new Aluno();
        System.out.print("Novo nome: ");
        novoAluno.nome = scanner.nextLine();
        novoAluno.cpf = cpf; // manter o CPF igual
        System.out.print("Novo email: ");
        novoAluno.email = scanner.nextLine();
        System.out.print("Nova nota: ");
        novoAluno.setNota(scanner.nextDouble());
        scanner.nextLine();

        boolean sucesso = service.atualizar(cpf, novoAluno);
        if (sucesso) {
            System.out.println("Aluno atualizado com sucesso.");
        } else {
            System.out.println("Erro ao atualizar.");
        }
    }

    public void removerAluno() {
        System.out.print("CPF do aluno a remover: ");
        String cpf = scanner.nextLine();

        boolean sucesso = service.remover(cpf);
        if (sucesso) {
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
}
