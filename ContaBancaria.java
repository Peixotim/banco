package NivelIntermediario.Desafio5;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class ContaBancaria implements Conta{
    double saldo;
    String id;
    double entrada;
    Cliente titular;
    tipoDeConta tipoConta;
    double taxa = 0.5 / 100;
    ArrayList<String>  alfabeto = new ArrayList<>();
    public ContaBancaria(){Mo
    }

    //TODO: Fazer uma sobrecarga , criando uma contaBancaria com cliente


    public ContaBancaria(String id, Cliente titular, tipoDeConta tipoConta){
        this.id = id;
        this.titular = titular;
        this.tipoConta = tipoConta;
        this.saldo = 0.0;
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Seu saldo é " + saldo);
    }

    @Override
    public void despositarValorContaCorrente(Scanner sc) {
        System.out.println("Digite o valor para depositar : ");
        entrada = sc.nextDouble();
        if(entrada <= 0){
            System.out.println("❌ Erro: valor inválido para depósito.");
        }else{
            saldo += (entrada - taxa);
            System.out.printf("✅ Depositado R$%.2f com taxa de R$%.2f%n", entrada, taxa);
        }
    }
    @Override
    public void depositarValorContaPoupanca(Scanner sc) {
        System.out.println("Digite o valor para depositar : ");
        entrada = sc.nextDouble();
        if(entrada <= 0){
            System.out.println("❌ Erro: valor inválido para depósito.");
        }else{
            saldo += entrada;
            System.out.printf("✅ Depositado R$%.2f sem taxa.%n", entrada);

        }
    }
    public String geradorId(){
        alfabeto.add("A");
        alfabeto.add("B");
        alfabeto.add("C");
        alfabeto.add("D");
        alfabeto.add("E");
        alfabeto.add("F");
        alfabeto.add("G");
        alfabeto.add("H");
        alfabeto.add("I");
        alfabeto.add("J");
        alfabeto.add("K");
        alfabeto.add("L");
        alfabeto.add("M");
        alfabeto.add("N");
        alfabeto.add("O");
        alfabeto.add("P");
        alfabeto.add("Q");
        alfabeto.add("R");
        alfabeto.add("S");
        alfabeto.add("T");
        alfabeto.add("U");
        alfabeto.add("V");
        alfabeto.add("W");
        alfabeto.add("X");
        alfabeto.add("Y");
        alfabeto.add("Z");

        Random rand = new Random();
        int numero = rand.nextInt(9);
        int numero2 = rand.nextInt(8);
        int numero3 = rand.nextInt(6);
        int numeroAlfabeto = rand.nextInt(26);
        int numeroAlfabeto2 = rand.nextInt(22);
        int numeroAlfabeto3 = rand.nextInt(21);
        String letraAlfabeto = alfabeto.get(numeroAlfabeto).toString();
        String letraAlfabeto2 = alfabeto.get(numeroAlfabeto2).toString();
        String letraAlfabeto3 = alfabeto.get(numeroAlfabeto3).toString();

        String id = String.valueOf(numero + letraAlfabeto + numero2 + letraAlfabeto2 + numero3 + letraAlfabeto3);
        return id;
    }

    public void exibirDados() {
        System.out.println("🆔 ID da Conta: " + id);
        System.out.println("👤 Titular: " + titular.nome);
        System.out.println("📧 Email: " + titular.email);
        System.out.println("📍 Cidade: " + titular.cidade);
        System.out.println("🧾 CPF: " + titular.cpf);
        System.out.println("🏦 Tipo da Conta: " + tipoConta);
        System.out.println("💰 Saldo: R$" + saldo);
    }

}
