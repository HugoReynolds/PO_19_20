 
import java.util.Scanner;

public class EntregasExpress {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Empresa E = new Empresa();
        boolean v = true;
        int util;
        int opc;
        E.read();

       while (v) {
            E.mostraMenuPrincipal();
            opc=scn.nextInt();
            switch (opc) {
                case 1:
                    E.novoCliente();
                    break;
                case 2:
                    if ((util = E.login()) == -1) {
                        System.out.println("Login Invalido.");
                    } else {
                        E.menuCliente(util);
                    }
                    break;
                case 3:
                    E.novoFornecedor();
                    break;
                case 4:
                    if ((util = E.login()) == -1) {
                        System.out.println("Login Invalido");
                    } else {
                        E.menuFornecedor(util);
                    }
                    break;
                case 5:
                    E.prinListaCliente();
                    break;
                case 6:
                    E.printListaFornecedores();
                    break;
                case 7:
                    E.listadeFornComMaisServicos();
                    break;
                case 0:
                    if(E.save()){
                        v=false;
                    }else{
                        System.out.println("Erro a gravar no ficheiro, desja sair mesmo assim?\n1-Sim\n2-Não");
                        opc=scn.nextInt();
                        if (opc==1){
                            v=false;
                        }
                    }
                    System.out.println("A fechar programa.");
                    break;
                    default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
