package NivelIntermediario.Desafio5;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<ContaBancaria> contas = new ArrayList<>();
        int opcao;
        do {
            System.out.println("======================================");
            System.out.println("🌟   SISTEMA BANCÁRIO - CITY BANK   🌟");
            System.out.println("======================================");
            System.out.println("1️⃣  - Cadastrar novo cliente");
            System.out.println("2️⃣  - Abrir conta corrente");
            System.out.println("3️⃣  - Abrir conta poupança");
            System.out.println("4️⃣  - Consultar saldo");
            System.out.println("5️⃣  - Depositar valor");
            System.out.println("6️⃣ - Visualizar dados da conta");
            System.out.println("7️⃣ - Sair");
            System.out.print("👉 Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer


            switch (opcao) {
                case 1:
                    System.out.println("📝 Cadastro de novo cliente");
                    System.out.print("Digite seu nome : ");
                    String nome = sc.nextLine();
                    System.out.print("Digite sua idade : ");
                    int idade = sc.nextInt();
                    sc.nextLine(); // limpa o buffer
                    if (idade < 18) {
                        System.out.print(" Cadastros somente com +18 anos !");
                        break;
                    } else {
                        System.out.print("Digite seu CPF : ");
                        String cpfDigitado = sc.nextLine();
                        String cpf = cpfDigitado.replaceAll("[^0-9]", ""); // remove tudo que não for número
                        System.out.print("Digite seu Email : ");
                        String email = sc.nextLine();
                        System.out.print("Digite sua cidade : ");
                        String cidade = sc.nextLine();
                        Cliente novoCliente = new Cliente(nome, cpf, idade, email, cidade);
                        clientes.add(novoCliente);
                        System.out.println("✅ Cliente cadastrado com sucesso!");
                    }
                    break;
                case 2:
                    if (clientes.isEmpty()) {
                        System.out.println("Nao há clientes cadastrados!");
                    } else {
                        Cliente contaEncontrada;
                        boolean clientesEncontrado = false;
                        System.out.print("Digite seu cpf : ");
                        String cpfDigitado = sc.nextLine();
                        String cpfLimpo = cpfDigitado.replaceAll("[^0-9]", "");

                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente cC = clientes.get(i); //
                            String cpfVerificar = cC.cpf;

                            if (cpfVerificar.equals(cpfLimpo)) {// fez a verificao do CPF
                                ContaBancaria c = new ContaBancaria();
                                clientesEncontrado = true;
                                contaEncontrada = cC;// Salvamos o Cliente em uma variavel
                                String id = c.geradorId();
                                ContaCorrente novaConta = new ContaCorrente(id, contaEncontrada);
                                contas.add(novaConta);
                                System.out.println("✅ Conta Corrente criada com sucesso!");
                                System.out.println("ID da Conta: " + novaConta.id);
                            }
                        }

                        if (!clientesEncontrado) {
                            System.out.println("❌ Cliente não encontrado com esse CPF.");
                        }
                    }
                    break;
                case 3:
                    if (clientes.isEmpty()) {
                        System.out.println("Nao há clientes cadastrados!");
                    } else {
                        Cliente contaEncontrada;
                        boolean clientesEncontrado = false;
                        System.out.print("Digite seu cpf : ");
                        String cpfDigitado = sc.nextLine();
                        String cpfLimpo = cpfDigitado.replaceAll("[^0-9]", "");

                        for (int i = 0; i < clientes.size(); i++) {
                            Cliente cC = clientes.get(i); //
                            String cpfVerificar = cC.cpf;

                            if (cpfVerificar.equals(cpfLimpo)) {// fez a verificao do CPF
                                ContaBancaria c = new ContaBancaria();
                                clientesEncontrado = true;
                                contaEncontrada = cC;// Salvamos o Cliente em uma variavel
                                String id = c.geradorId();
                                ContaPoupanca novaConta = new ContaPoupanca(id, contaEncontrada);
                                contas.add(novaConta);
                                System.out.println("✅ Conta Poupanca criada com sucesso!");
                                System.out.println("ID da Conta: " + novaConta.id);
                            }
                        }
                        if (!clientesEncontrado) {
                            System.out.println("❌ Cliente não encontrado com esse CPF.");
                        }
                    }
                        break;
                case 4 :
                    if(contas.isEmpty()){
                        System.out.println("❌ Nao há clientes cadastrados!");
                    }else{
                        System.out.print("Digite o CPF para buscar a conta:");
                        String cpfBusca = sc.nextLine();
                        String cpfLimpoBusca = cpfBusca.replaceAll("[^0-9]", "");

                        for (int i = 0; i < contas.size(); i++) {
                            ContaBancaria conta = contas.get(i);

                            if (conta.titular != null && conta.titular.cpf.equals(cpfLimpoBusca)) {
                                conta.consultarSaldo();
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    if (contas.isEmpty()){
                        System.out.println("❌ Nao há clientes cadastrados!");
                    }else{
                        System.out.print("Digite o CPF para buscar a conta:");
                        String cpfBusca = sc.nextLine();
                        String cpfLimpoBusca = cpfBusca.replaceAll("[^0-9]", "");

                        for (int i = 0; i < contas.size(); i++) {
                            ContaBancaria conta = contas.get(i);
                            if (conta.titular != null && conta.titular.cpf.equals(cpfLimpoBusca)) {
                                switch(conta.tipoConta){
                                    case CORRENTE:
                                        conta.despositarValorContaCorrente(sc);
                                        break;
                                    case POUPANCA:
                                        conta.depositarValorContaPoupanca(sc);
                                        break;
                                }
                                break;
                            }
                        }
                    }
                    break;
                        case 6:
                            System.out.print("Digite o CPF para buscar a conta: ");

                            String cpfBusca = sc.nextLine();
                            String cpfLimpoBusca = cpfBusca.replaceAll("[^0-9]", "");

                            boolean encontrou = false;
                            for (int i = 0; i < contas.size(); i++) {
                                ContaBancaria conta = contas.get(i);
                                if (conta.titular != null && conta.titular.cpf.equals(cpfLimpoBusca)) {
                                    conta.exibirDados();
                                    encontrou = true;
                                    break;
                                }
                            }
                            if (!encontrou) {
                                System.out.println("❌ Nenhuma conta encontrada com esse CPF.");
                            }
                            break;
                    }
            }
            while (opcao != 7) ;
    }
}
