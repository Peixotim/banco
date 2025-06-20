package NivelIntermediario.Desafio5;

public class Cliente {
    String nome;
    String cpf;
    String email;
    String cidade;
    int idade;

    public Cliente(){

    }

    public Cliente(String nome, String cpf, int idade, String email, String cidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.cidade = cidade;
    }
}
