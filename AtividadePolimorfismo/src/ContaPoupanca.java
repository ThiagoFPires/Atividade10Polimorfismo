import javax.swing.JOptionPane;
class ContaPoupanca extends ContaBancaria {
    private static final int MAX_SAQUES_GRATUITOS = 3;
    private int saquesRealizados;
    private double taxaRendimento;

    public ContaPoupanca(String numeroConta, String titular, double saldo, double taxaRendimento) {
        super(numeroConta, titular, saldo);
        this.taxaRendimento = taxaRendimento;
        this.saquesRealizados = 0;
    }

    @Override
    public void sacar(double valor) {
        if (saquesRealizados < MAX_SAQUES_GRATUITOS) {
            if (saldo >= valor) {
                saldo -= valor;
                saquesRealizados++;
                JOptionPane.showMessageDialog(null, "Saque de R$" + valor + " realizado na conta " + getNumeroConta());
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente para saque.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Limite de saques gratuitos atingido para este mês.");
        }
    }

    public void calcularRendimento() {
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento;
        JOptionPane.showMessageDialog(null, "Rendimento aplicado. Novo saldo: R$" + saldo);
    }
}