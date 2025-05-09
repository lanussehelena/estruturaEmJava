import controller.AlunoController;

public class Main {
    public static void main(String[] args) {

        AlunoController controller = new AlunoController();

        controller.avaliarAluno("Maria", 8.5);
        controller.avaliarAluno("João", 6.0);

        controller.listarAlunos();
    }
}