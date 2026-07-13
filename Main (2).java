import java.util.Scanner ;
import java.util.ArrayList;
public class Main {
    static double saldo = 1450;
    static Scanner sc = new Scanner(System.in);
    static String usuarioCorreto = "Luks";
    static String senhaCorreta = "1234";
    static int tentativasRestantes = 3;
    static boolean loginRealizado = false;
    static ArrayList<String> historico = new ArrayList<>();    
    public static void login() {
        for(int i=0; i <tentativasRestantes;i++){
            System.out.print("Usuario: ");
            String usuarioDigitado = sc.nextLine();
            System.out.print("Senha: ");
            String senhaDigitada = sc.nextLine();
            if (usuarioDigitado.equals(usuarioCorreto) && senhaDigitada.equals(senhaCorreta)) {
                System.out.print("Login efetuado com sucesso!");
                loginRealizado = true;
                break;
            } else {
                System.out.print("Login ou senha invalidas!\n");
            } 
        }
    }
    public static void mostrarMenu() {
        System.out.print("\n====Bank Inter====\nBem-Vindo(a)!");
        System.out.print("\n1-Saldo\n2-Depositar\n3-Pix\n4-Saque\n5-Extrato\n0-Sair\n");
    }
    public static void verSaldo() {
        System.out.printf("\nSaldo: R$ %.2f%n", saldo);
    }
    public static void depositar() {
        System.out.print("\nQual valor para realizar o deposito?\nR$:");
        double deposito = sc.nextDouble();
        saldo += deposito ;
        System.out.print("\nDeposito realizado com sucesso!\nSeu saldo atual é R$: " + saldo);
        historico.add("Deposito: \nR$+ " + deposito);
    }   
    public static void fazerPix() {
        
        System.out.print("Digite a chave Pix:\n");
        String chaveDigitada = sc.next();
        String chaveCorreta = "130107";
        
        System.out.print("Digite o valor do pix:\n");
        double valorPix = sc.nextDouble();
        
        if (chaveDigitada.equals(chaveCorreta) && valorPix <= saldo){
            saldo -= valorPix;
            System.out.print("\nPix enviado com sucesso!\nSeu saldo atual é: R$" + saldo);
            historico.add("Pix:\nR$- " + valorPix);
        } else {
            System.out.print("Saldo insuficiente ou chave  pix incorreta!");
        } 
        
    }
    public static void saque() {
        System.out.print("\nQual o valor do saque?\nR$:");
        double valorSaque = sc.nextDouble();
        if (valorSaque <= saldo) {
            saldo -= valorSaque;
            System.out.print("\nDinheiro sacado com sucesso!\nSeu saldo atual é:R$ " + saldo);
            historico.add("Saque:\nR$:- " + valorSaque);
        } else {
            System.out.print("Saldo insuficiente para sacar!");
        } 
    }
    public static void extrato() {
        for (int i = 0; i < historico.size(); i++) {
            System.out.print("\n" +historico.get(i)+"\n");
        }
    }
    public static void sair() {
    
    }
    public static void main (String []args) {
        int opcao;
        login();
        if (loginRealizado == true)  {
            do {
            mostrarMenu();
            opcao = sc.nextInt();
            switch (opcao) {
                case 1: verSaldo(); break;
                case 2: depositar(); break;
                case 3: fazerPix(); break;
                case 4: saque(); break;
                case 5: extrato(); break;
                case 0: System.out.print("\nSaindo..."); break;
                default: System.out.print("\nOpção invalida!");
            }
        } while (opcao != 0);
        }
        
        
    }
}