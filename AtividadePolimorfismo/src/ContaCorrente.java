import javax.swing.JOptionPane;

class ContaCorrente extends ContaBancaria {
    private double taxaOperacao;

    public ContaCorrente(String numeroConta, String titular, double saldo, double taxaOperacao) {
        super(numeroConta, titular, saldo);
        this.taxaOperacao = taxaOperacao;
    }

    @Override
    public void sacar(double valor) {
        double valorTotal = valor + taxaOperacao;
        if (saldo >= valorTotal) {
            saldo -= valorTotal;
            JOptionPane.showMessageDialog(null, "Saque de R$" + valor + " realizado na conta " + getNumeroConta());
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque.");
        }
    }
}