package com.mybank.app;
import java.util.Scanner;
/**
 * Hello world!
 */
public class ContaTerminal {
    int numeroDaConta;
    String agencia;
    String nomeCliente;
    float saldo;

    public ContaTerminal(int numero, String agencia,
        String cliente, float saldo) {

        this.numeroDaConta = numero;
        this.agencia = agencia;
        this.nomeCliente = cliente;
        this.saldo = saldo;
    }

    public ContaTerminal() {}

    public int getNumeroDaConta() {
        return this.numeroDaConta;
    }

    public void setNumeroDaConta(int numero) {
        this.numeroDaConta = numero;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia){
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema JavaBanking.");
        System.out.println("Para criar sua conta, siga as intruções a seguir.");
        System.out.println("Por favor, digite o número da conta.");
        int numeroDaConta = scanner.nextInt();
        System.out.println("Digite o código da agência, no formato ###-#");
        String agencia = scanner.next();
        System.out.println("Digite seu nome completo.");
        String nomeCliente = scanner.next();
        System.out.println("Insira o seu saldo no formato ##.##");
        String inputSaldo = scanner.next();
        scanner.close();
        float saldo = Float.parseFloat(inputSaldo);
        ContaTerminal novaConta = new ContaTerminal(numeroDaConta, agencia, nomeCliente, saldo);
        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %s e seu saldo de R$%s já está disponível para saque.\n", novaConta.getNomeCliente(),
        novaConta.getAgencia(), novaConta.getNumeroDaConta(), novaConta.getSaldo() );

    }
}
