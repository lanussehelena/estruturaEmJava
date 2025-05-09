import controller.AlunoController;
import controller.ProfessorController;
import controller.CoordenadorController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoController alunoController = new AlunoController();
        ProfessorController professorController = new ProfessorController();
        CoordenadorController coordenadorController = new CoordenadorController();

        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Gerenciar Alunos");
            System.out.println("2 - Gerenciar Professores");
            System.out.println("3 - Gerenciar Coordenadores");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> alunoController.menuAluno();
                case 2 -> professorController.menuProfessor();
                case 3 -> coordenadorController.menuCoordenador();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
