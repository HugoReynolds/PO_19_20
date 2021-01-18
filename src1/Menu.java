
import java.util.HashMap;
import java.util.Scanner;

public class Menu
{
    Empresa E;
    private Scanner sc;
    public Menu(){
        sc=new Scanner(System.in);
    }
    private HashMap<Integer,Utilizador>listaU= new HashMap<>();
    int util;
    int op;


    public void mostraMenuPrincipal(){
        System.out.println("::Menu::");
        System.out.println("1- Novo CLiente");
        System.out.println("2- Login CLiente");
        System.out.println("3- Novo Fornecedor");
        System.out.println("4- Login Fornecedor");
        System.out.println("5- Lista de CLientes");
        System.out.println("6- Lista de Fornecedores");
    }


}
