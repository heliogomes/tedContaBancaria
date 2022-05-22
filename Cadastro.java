
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


    public class Cadastro {
        String nome;
        String cpf;
        double depositoInicial;
        Scanner sc = new Scanner(System.in);


        public Cadastro() {
        }

        public Cadastro(String nome, String cpf) {
            this.nome = nome;
            this.cpf = cpf;
        }


        public String getNome() {
            return nome;
        }

        public void setName(String name) {
            this.nome = nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }


        public String toString() {
            return "\nName: " + this.getNome() +
                    "\nCPF: " + this.getCpf();
        }
    }