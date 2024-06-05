import javax.swing.JOptionPane;
import java.util.ArrayList;

abstract class ContaBancaria {
    private String numeroConta;
    private String titular;
    protected double saldo;

    public ContaBancaria(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        JOptionPane.showMessageDialog(null, "Depósito de R$" + valor + " realizado na conta " + numeroConta);
    }

    public abstract void sacar(double valor);

    public void transferir(ContaBancaria destino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            destino.depositar(valor);
            JOptionPane.showMessageDialog(null, "Transferência de R$" + valor + " realizada com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para transferência.");
        }
    }
}