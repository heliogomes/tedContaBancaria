import java.util.ArrayList;
import java.util.Scanner;




public class main {
    static ArrayList<Conta> contas;


    public static void main(String[] args) {
        contas = new ArrayList<Conta>();
        iniciar();
    }

    public static void iniciar(){
        int opcao;
        Scanner sc = new Scanner(System.in);

        do{
            exibeMenu();
            opcao = sc.nextInt();
            menu(opcao);
        }while(opcao!=4);
    }

    public static void exibeMenu(){
        System.out.println("\t Escolha a opção desejada");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Listar contas");
        System.out.println("5 - Sair\n");
        System.out.print("Opção: ");
    }

    public static void menu(int opcao){

        switch( opcao ){
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                listarContas();
                break;

            case 5:
                System.out.println("Sistema encerrado.");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida");
                iniciar();
                break;
        }
    }

    public static void criarConta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Abertura de conta.");

        System.out.println("Insira seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Insira seu CPF: ");
        String cpf = sc.nextLine();

        System.out.println("Insira o valor do primeiro depósito. (Valor mínimo: R$ 100,00)");
        double depositoInicial = sc.nextDouble();

        do {
            if (depositoInicial < 100) {
                System.out.println("Valor mínimo não atingido. Insira um novo valor:");
                depositoInicial = sc.nextDouble();
            }
        } while (depositoInicial < 100);

        Cadastro cliente = new Cadastro(nome, cpf);
        Conta novaConta = new Conta(cliente);
        contas.add(novaConta);

        novaConta.depositar(depositoInicial);

        iniciar();
    }

    private static Conta encontrarConta(int conta) {
        Conta novaConta = null;
        if(contas.size() > 0) {
            for(Conta contaa : contas) {
                if(contaa.getConta() == conta) {
                    novaConta = contaa;
                }
            }
        }
        return novaConta;
    }

    public static void depositar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Número da conta: ");
        int conta = sc.nextInt();
        Conta novaConta = encontrarConta(conta);

        if(novaConta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = sc.nextDouble();

            novaConta.depositar(valorDeposito);
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        iniciar();
    }

    public static void sacar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Número da conta: ");
        int conta = sc.nextInt();

        Conta novaConta = encontrarConta(conta);

        if(novaConta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = sc.nextDouble();

            novaConta.sacar(valorSaque);
            System.out.println("--- Saque realizado com sucesso! ---");
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        iniciar();
    }

    public static void listarContas() {
        if(contas.size() > 0) {
            for(Conta novaConta: contas) {
                System.out.println(novaConta);
            }
        }else {
            System.out.println("--- Não há contas cadastradas ---");
        }

        iniciar();
    }
}
