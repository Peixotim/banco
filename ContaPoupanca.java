package NivelIntermediario.Desafio5;

public class ContaPoupanca extends ContaBancaria{
    public ContaPoupanca(String id, Cliente titular) {
        super(id, titular,tipoDeConta.POUPANCA);
    }
}
