
/**
 * Escreva a descrição da classe Login aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Scanner;
import java.util.HashMap;
public class Login
{
    /*Empresa E= new Empresa();
    Menu M = new Menu();
    private HashMap<Integer,Cliente>listaC= new HashMap<>();
    private HashMap<Integer,Fornecedor>listaF= new HashMap<>();
    private HashMap<Integer,Utilizador>listaU= new HashMap<>();
    private Scanner buf = new Scanner(System.in);
    private int nC;
    private int nF=1000;
    int []c=new int[2];

    public int login(){
        System.out.print("Mail: ");
        buf=new Scanner(System.in);
        String mail= buf.nextLine();
        int n=1;

        for(int j:listaU.keySet()){
            if(listaU.get(j).getEmail().equals(mail)){
                n=j;
            }else{
                System.out.println("Nao existe nenhum ultilizador com esse nome");
                n=-1;
            }
        }
        return n;
    }
    
    public void novoCliente(){
        try{
            System.out.print("Email: ");
            buf=new Scanner(System.in);
            String email=buf.nextLine();
            for(Integer k: listaU.keySet()){
                while(email.equals(listaU.get(k).getEmail())) {
                    System.out.println("Mail existente.");
                    email = buf.nextLine();
                }
            }
            System.out.print("Digite o Nome:");
            String nome=buf.nextLine();
            System.out.print("Digite a Password:");
            String password=buf.nextLine();
            System.out.print("Digite a Morada:");
            String morada=buf.nextLine();
            System.out.print("Digite a Data de Nascimento:");
            String data=buf.nextLine();
            nC++;
            Cliente c = new Cliente(email, nome, password, morada, data);
            E.getlista(listaU).put(nC,c);
            System.out.println("CLiente adicionado com Sucesso.");
            E.visualizarCLiente(c,nC);
            M.menuCliente(1);
            System.out.println("CLiente adicionado com Sucesso1.");
        }catch (Exception e){
            System.out.println("Erro do Sistema. Tente Novamente.\n");
        }
    }
    
    public void novoFornecedor(){
        try{
            System.out.print("Email: ");
            buf=new Scanner(System.in);
            String email=buf.nextLine();
            for(Integer k: listaF.keySet()){
                while(email.equals(listaF.get(k).getEmail())) {
                    System.out.println("Mail existente.");
                    email = buf.nextLine();
                }
            }
            System.out.println("Digite o Nome:");
            String nome=buf.nextLine();
            System.out.println("Digite a Password:");
            String password=buf.nextLine();
            System.out.println("Digite a Morada:");
            String morada=buf.nextLine();
            System.out.println("Digite a Data de Nascimento:");
            String data=buf.nextLine();
            System.out.println("Onde se Localiza?");
            System.out.println("Coord X: ");
            c[0]=buf.nextInt();
            System.out.println("Coord Y: ");
            c[1]=buf.nextInt();
            Servico s = E.FornecedorEscolhadeServicos();
            nF++;
            System.out.println("Fornecedor adicionado com Sucesso.");
            Fornecedor f = new Fornecedor(email, nome, password, morada, data, c,s);
            listaF.put(nF,f);
        }catch (Exception e){
            System.out.println("Erro do Sistema. \n Tente Novamente.\n");
        }
    }*/
}
