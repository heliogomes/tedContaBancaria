import java.util.Random;

public class Conta {
    private Cadastro cadastro;
    private static int numberAccount = 1;
    private int conta;
    private double saldo;


    public Conta(Cadastro cadastro){
        this.cadastro=cadastro;
        this.conta = Conta.numberAccount;
        Conta.numberAccount += 1;
        this.updateSaldo();
    }


    public int getConta(){
        return conta;
    }

    public Cadastro getClient(){
        return cadastro;
    }
    public void setClient(Cadastro cadastro){
        this.cadastro = cadastro;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }

    public String toString(){
        return "\nNúmero Conta: " + this.getConta() +
                "\nCliente: " + this.cadastro.getNome() +
                "\nCPF: " + this.cadastro.getCpf() +
                "\nSaldo: " + this.getSaldo();
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }
}
