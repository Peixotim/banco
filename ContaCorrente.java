package NivelIntermediario.Desafio5;

public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(String id,Cliente titular) {
        super(id, titular,tipoDeConta.CORRENTE);
    }
}
