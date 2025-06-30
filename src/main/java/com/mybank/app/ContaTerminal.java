package com.mybank.app;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.math.BigDecimal;
/**
 * Hello world!
 */
public class ContaTerminal {
    int numeroDaConta;
    String agencia;
    String nomeCliente;
    BigDecimal saldo;

    public ContaTerminal(int numero, String agencia,
        String cliente, BigDecimal saldo) {

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

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public static int inputNumeroConta(Scanner scanner) {
        int digito;
        while (true) {
            String input = scanner.next();
            if (Pattern.matches("\\d{4}+", input)){
                digito = Integer.parseInt(input);
                break;
            }
            System.out.println ("Erro!(" + input + ") Por favor digite um número de 4 dígitos: ");

        }
        return digito;
    }

    public static String inputCodigoAgencia(Scanner scanner) {
        String agencia;

        while (true) {
        String input = scanner.next();
            if (Pattern.matches("\\d{4}+", input)){
                agencia = input.substring(0, 3) + "-" + input.substring(3);
                break;
            }
            System.out.println ("Erro!(" + input + ") Por favor digite 4 dígitos: ");

        }
        return agencia;
    }

    public static String inputSaldo(Scanner scanner) {
        String saldo;

        while (true) {
        String input = scanner.next();
            if (Pattern.matches("\\d+", input)){
                saldo = input.substring(0, (input.length()-2)) + "." + input.substring(input.length()-2);
                break;
            } else if (Pattern.matches("\\.\\d{2}", input)) {
                saldo = input;
                break;
            }
            System.out.println ("Erro!(" + input + ") Por favor digite 4 dígitos: ");

        }
        return saldo;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema JavaBanking.");
        System.out.println("Para criar sua conta, siga as intruções a seguir.");
        System.out.println("Por favor, digite o número da conta.");
        int numeroDaConta = inputNumeroConta(scanner);
        System.out.println("Digite o código da agência, no formato ###-#");
        String agencia = inputCodigoAgencia(scanner);
        System.out.println("Digite seu nome completo.");
        String nomeCliente = scanner.next();
        System.out.println("Insira o seu saldo no formato ##.##");
        String stringSaldo = inputSaldo(scanner);
        scanner.close();
        BigDecimal saldo = new BigDecimal(stringSaldo);
        ContaTerminal novaConta = new ContaTerminal(numeroDaConta, agencia, nomeCliente, saldo);
        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %s e seu saldo de R$%s já está disponível para saque.\n", novaConta.getNomeCliente(),
        novaConta.getAgencia(), novaConta.getNumeroDaConta(), novaConta.getSaldo() );

    }
}
