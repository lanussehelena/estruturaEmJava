package model;

public class Pessoa {
    public String nome;
    public String cpf;
    public String email;

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Email: " + email);
    }
}
