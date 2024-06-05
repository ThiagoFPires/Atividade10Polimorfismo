import javax.swing.JOptionPane;
import java.util.ArrayList;

public class GerenciamentoContas {
    private ArrayList<ContaBancaria> contas;

    public GerenciamentoContas() {
        this.contas = new ArrayList<>();
    }

    public void adicionarConta() {
        String numeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
        String titular = JOptionPane.showInputDialog("Digite o nome do titular:");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo inicial da conta:"));
        String tipoConta = JOptionPane.showInputDialog("Digite o tipo da conta (Corrente/Poupança):");

        if ("Corrente".equalsIgnoreCase(tipoConta)) {
            double taxaOperacao = Double.parseDouble(JOptionPane.showInputDialog("Digite a taxa de operação da conta corrente:"));
            contas.add(new ContaCorrente(numeroConta, titular, saldo, taxaOperacao));
        } else if ("Poupança".equalsIgnoreCase(tipoConta)) {
            double taxaRendimento = Double.parseDouble(JOptionPane.showInputDialog("Digite a taxa de rendimento da conta poupança:"));
            contas.add(new ContaPoupanca(numeroConta, titular, saldo, taxaRendimento));
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de conta inválido.");
        }
    }

    public void realizarDeposito() {
        String numeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do depósito:"));
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    public void realizarSaque() {
        String numeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque:"));
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    public void realizarTransferencia() {
        String numeroContaOrigem = JOptionPane.showInputDialog("Digite o número da conta de origem:");
        String numeroContaDestino = JOptionPane.showInputDialog("Digite o número da conta de destino:");
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da transferência:"));
        ContaBancaria origem = buscarConta(numeroContaOrigem);
        ContaBancaria destino = buscarConta(numeroContaDestino);
        if (origem != null && destino != null) {
            origem.transferir(destino, valor);
        } else {
            JOptionPane.showMessageDialog(null, "Conta de origem ou destino não encontrada.");
        }
    }

    private ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        GerenciamentoContas gerenciador = new GerenciamentoContas();

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha uma opção:\n" +
                            "1. Adicionar Conta\n" +
                            "2. Realizar Depósito\n" +
                            "3. Realizar Saque\n" +
                            "4. Realizar Transferência\n" +
                            "5. Sair"));

            switch (opcao) {
                case 1:
                    gerenciador.adicionarConta();
                    break;
                case 2:
                    gerenciador.realizarDeposito();
                    break;
                case 3:
                    gerenciador.realizarSaque();
                    break;
                case 4:
                    gerenciador.realizarTransferencia();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (opcao != 5);
    }
}