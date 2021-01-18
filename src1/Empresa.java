
import java.util.*;
import java.io.*;
import java.io.FileOutputStream;

public class Empresa{
    private HashMap<Integer,Utilizador>listaU= new HashMap<>();
    ArrayList<Viagem>listvCliente= new ArrayList<>();
    ArrayList<Viagem>listvForn= new ArrayList<>();
    ArrayList<Servico>listsCliente= new ArrayList<>();
    ArrayList<Servico>listsForn= new ArrayList<>();
    private Scanner buf = new Scanner(System.in);
    private int nS;
    private int nC;
    private int nF;
    private int nU;
    Servico serv;
    Fornecedor forn;
    Cliente cli;

    public int login() {
        System.out.print("Mail: ");
        buf = new Scanner(System.in);
        String mail = buf.nextLine();
        System.out.print("Password: ");
        buf=new Scanner(System.in);
        String pass= buf.nextLine();
        int n = -1;

        for (int j : listaU.keySet()) {
            if (listaU.get(j) instanceof Cliente) {
                if (listaU.get(j).getEmail().equals(mail)&&listaU.get(j).getPassword().equals(pass)) {
                    n = j;
                }
            } else if (listaU.get(j) instanceof Fornecedor) {
                if (listaU.get(j).getEmail().equals(mail)&&listaU.get(j).getPassword().equals(pass)) {
                    n = j;
                }
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
                    System.out.println("Introduz novo Email: ");
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
            nU++;
            nC++;
            Cliente c = new Cliente(email, nome, password, morada, data,listvCliente,listsCliente);
            listaU.put(nU,c);
            System.out.println("CLiente adicionado com Sucesso.");
            menuCliente(nU);

        }catch (Exception e){
            System.out.println("Erro do Sistema. Tente Novamente.\n");
        }
    }

    public void novoFornecedor(){
        int []c=new int[2];
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
            System.out.println("Onde se Localiza?");
            System.out.print("Coord X: ");
            c[0]=buf.nextInt();
            System.out.print("Coord Y: ");
            c[1]=buf.nextInt();
            System.out.println("Que tipo de servicos irá executar?");
            System.out.print("1-Pessoas\n 2-Bus\n 3-Big\n 4-Urgentes\n 5-Refeições \n Op->");
            int op=buf.nextInt();
            switch (op){
                case 1:
                        System.out.println("Qual o custo por km?");
                            int preco=buf.nextInt();
                        System.out.println("Qual a Distancia maxima que irá percorrer?");
                            int distancia=buf.nextInt();
                        System.out.println("Qual a autonomia?");
                            int auton=buf.nextInt();
                        System.out.println("Quantas pesseoas pretende levar?");
                            int p=buf.nextInt();
                            while(p>5){
                                System.out.println("\nNao possuimos nenhum veiculo com essa capacidade.\n Quantas pessoas pretende levar?\n->");
                                p=buf.nextInt();
                            }
                        nS=0;
                    serv= new Pessoas(nS,distancia,auton,preco,p);
                break;
                case 2:
                    System.out.println("Qual o custo por km?");
                    int preco1=buf.nextInt();
                    System.out.println("Qual a Distancia maxima que irá percorrer?");
                    int distancia1=buf.nextInt();
                    System.out.println("Qual a autonomia?");
                    int auton1=buf.nextInt();
                    System.out.println("Quantas pesseoas pretende levar?");
                    int p1=buf.nextInt();
                    while(p1<5 && p1>30){
                        System.out.println("\nNao possuimos nenhum veiculo com essa capacidade.\n Quantas pessoas pretende levar?\n->");
                        p1=buf.nextInt();
                    }
                    nS=0;
                    serv= new Bus(nS,distancia1,auton1,preco1,p1);
                break;
                case 3:
                    System.out.println("Qual o custo por km?");
                    int preco2=buf.nextInt();
                    System.out.println("Qual a Distancia maxima que irá percorrer?");
                    int distancia2=buf.nextInt();
                    System.out.println("Qual a autonomia?");
                    int auton2=buf.nextInt();
                    System.out.println("Qual é o peso Maximo que consegue carregar?");
                    int peso=buf.nextInt();
                    nS=0;
                    serv= new Big(nS,distancia2,auton2,preco2,peso);
                break;
                case 4:
                    System.out.println("Qual o custo por km?");
                    int preco3=buf.nextInt();
                    System.out.println("Qual a Distancia maxima que irá percorrer?");
                    int distancia3=buf.nextInt();
                    System.out.println("Qual a autonomia?");
                    int auton3=buf.nextInt();
                    System.out.println("Qual é a Temperatura a que pretende transportar o item?");
                    int temp=buf.nextInt();
                    nS=0;
                    serv= new Urgentes(nS,distancia3,auton3,preco3,temp);
                break;
                case 5:
                    System.out.println("Qual o custo por km?");
                    int preco4=buf.nextInt();
                    System.out.println("Qual a Distancia maxima que irá percorrer?");
                    int distancia4=buf.nextInt();
                    System.out.println("Qual a autonomia?");
                    int auton4=buf.nextInt();
                    System.out.println("Qual é a Temperatura a que pretende transportar o item?");
                    int temp1=buf.nextInt();
                    nS=0;
                    serv= new Refeicoes(nS,distancia4,auton4,preco4,temp1);
                    break;
                default: serv=serv; break;
            }
            nU++;
            nF++;
            Fornecedor f = new Fornecedor(email, nome, password, morada, data,listvForn,listsForn, c,serv);
            System.out.println("Fornecedor adicionado com Sucesso.");
            System.out.println("Tipo de servico do Fornecedor "+f.getServico().getClassName());
            listaU.put(nU,f);
            menuFornecedor(nU);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro do Sistema. \n Tente Novamente.\n "+ e);
        }
    }

    public void novoServPessoas(int cli){
        try{
            System.out.println("Numero de pessoas?");
            int n=buf.nextInt();
            while(n>5){
                System.out.println("\nNao possuimos nenhum veiculo com essa capacidade.\n Quantas pessoas deseja levar?\n->");
                n=buf.nextInt();
            }
            int c[]=ClienteLocal();
            menuEscolhadeServico();
            int op=buf.nextInt();
            switch (op){
                case 1:
                    forn=printListaFornPessoas();
                    break;
                case 2:
                    forn=printFornPessmaisBarato();
                    break;
                case 3:
                    forn=printFornPessmaisRapido(c);
                    break;
                case 4:
                    break;
                default: forn=forn; break;
            }
            System.out.println("\n\t Fornecedor: " + forn.getNome()+
                    "\n\t Preco do Servico:" + forn.getServico().getPrecoServico()+"$/km"+
                    "\n\t Autonomia:" + forn.getServico().getAutonmia()+
                    "\n\t Precorre uma distancia máxima de:" + forn.getServico().getDistanciaMaxima()+" metros");

            double distan=CalcDistancia(c,forn.getFornCoords());
            double precoF=forn.getServico().getPrecoServico()*distan;
            nS++;
            Viagem v= new Viagem(precoF,distan,nS,forn.getServico().getDistanciaMaxima(),forn.getServico().getAutonmia(),forn.getServico().getPrecoServico());
            Servico s= new Pessoas(nS,forn.getServico().getDistanciaMaxima(),forn.getServico().getAutonmia(),forn.getServico().getPrecoServico(),n);

            listsCliente=listaU.get(cli).getListadeServicos();
            listsCliente.add(s.clone());
            listaU.get(cli).setListadeServicos(listsCliente);
            listsForn=forn.getListadeServicos();
            listsForn.add(s.clone());
            forn.setListadeServicos(listsForn);

            listvCliente= listaU.get(cli).getListadeviagens();
            listvCliente.add(v.clone());
            listaU.get(cli).setListadeviagens(listvCliente);
            listvForn=forn.getListadeviagens();
            listvForn.add(v.clone());
            forn.setListadeviagens(listvForn);

            System.out.println("SERVICO EFETUADO!!!!");
            printCaracteristicasdoServico(forn,v);
            menuCliente(cli);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro do Sistema. \n Tente Novamente.\n "+ e);
        }
    }

    public void novoServBus(int cli){
        try{
            System.out.println("Numero de pessoas?");
            int n=buf.nextInt();
            while(n>5){
                System.out.println("\nNao possuimos nenhum veiculo com essa capacidade.\n Quantas pessoas deseja levar?\n->");
                n=buf.nextInt();
            }
            int c[]=ClienteLocal();
            menuEscolhadeServico();
            int op=buf.nextInt();
            switch (op){
                case 1:
                    forn=printListaFornBus();
                    break;
                case 2:
                    forn=printFornBusmaisBarato();
                    break;
                case 3:
                    forn=printFornBusmaisRapido(c);
                    break;
                case 4:
                    break;
                default: forn=forn; break;
            }
            System.out.println("\n\t Fornecedor: " + forn.getNome()+
                    "\n\t Preco do Servico:" + forn.getServico().getPrecoServico()+"$/km"+
                    "\n\t Autonomia:" + forn.getServico().getAutonmia()+
                    "\n\t Precorre uma distancia máxima de:" + forn.getServico().getDistanciaMaxima()+" metros");

            double distan=CalcDistancia(c,forn.getFornCoords());
            double precoF=forn.getServico().getPrecoServico()*distan;
            nS++;
            Viagem v= new Viagem(precoF,distan,nS,forn.getServico().getDistanciaMaxima(),forn.getServico().getAutonmia(),forn.getServico().getPrecoServico());
            Servico s= new Bus(nS,forn.getServico().getDistanciaMaxima(),forn.getServico().getAutonmia(),forn.getServico().getPrecoServico(),n);
            listsCliente=listaU.get(cli).getListadeServicos();
            listsCliente.add(s.clone());
            listaU.get(cli).setListadeServicos(listsCliente);
            listsForn=forn.getListadeServicos();
            listsForn.add(s.clone());
            forn.setListadeServicos(listsForn);

            listvCliente= listaU.get(cli).getListadeviagens();
            listvCliente.add(v.clone());
            listaU.get(cli).setListadeviagens(listvCliente);
            listvForn=forn.getListadeviagens();
            listvForn.add(v.clone());
            forn.setListadeviagens(listvForn);
            System.out.println("SERVICO EFETUADO!!!!");
            printCaracteristicasdoServico(forn,v);
            menuCliente(cli);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro do Sistema. \n Tente Novamente.\n "+ e);
        }
    }

    public void novoServBig(int cli){
        try{
            System.out.println("Peso da Encomenda:");
            int p=buf.nextInt();
            int c[]=ClienteLocal();
            menuEscolhadeServico();
            int op=buf.nextInt();
            switch (op){
                case 1:
                    forn=printListaFornBig();
                    break;
                case 2:
                    forn=printFornBigmaisBarato();
                    break;
                case 3:
                    forn=printFornBigmaisRapido(c);
                    break;
                case 4:
                    break;
                default: forn=forn; break;
            }
            System.out.println("\n\t Fornecedor: " + forn.getNome()+
                    "\n\t Preco do Servico:" + forn.getServico().getPrecoServico()+"$/km"+
                    "\n\t Autonomia:" + forn.getServico().getAutonmia()+
                    "\n\t Peso da Encomenda:" + ((Big)forn.getServico()).getPeso()+
                    "\n\t Precorre uma distancia máxima de:" + forn.getServico().getDistanciaMaxima()+" metros");

            double distan=CalcDistancia(c,forn.getFornCoords());
            double precoF=forn.getServico().getPrecoServico()*distan;
            nS++;
            Viagem v= new Viagem(precoF,distan,nS,forn.getServico().getDistanciaMaxima(),forn.getServico().getAutonmia(),forn.getServico().getPrecoServico());
            Servico s= new Big(nS,forn.getServico().getDistanciaMaxima(),forn.getServico().getAutonmia(),forn.getServico().getPrecoServico(),p);
            listsCliente=listaU.get(cli).getListadeServicos();
            listsCliente.add(s.clone());
            listaU.get(cli).setListadeServicos(listsCliente);
            listsForn=forn.getListadeServicos();
            listsForn.add(s.clone());
            forn.setListadeServicos(listsForn);

            listvCliente= listaU.get(cli).getListadeviagens();
            listvCliente.add(v.clone());
            listaU.get(cli).setListadeviagens(listvCliente);
            listvForn=forn.getListadeviagens();
            listvForn.add(v.clone());
            forn.setListadeviagens(listvForn);

            System.out.println("SERVICO EFETUADO!!!!");
            printCaracteristicasdoServico(forn,v);
            menuCliente(cli);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro do Sistema. \n Tente Novamente.\n "+ e);
        }
    }

    public void novoServUrgentes(int cli){
        try{
            System.out.println("Temperatura do Servico:");
            double t=buf.nextDouble();
            int c[]=ClienteLocal();
            menuEscolhadeServico();
            int op=buf.nextInt();
            switch (op){
                case 1:
                    forn=printListaFornUrgentes();
                    break;
                case 2:
                    forn=printFornUrgentesmaisBarato();
                    break;
                case 3:
                    forn=printFornUrgentesmaisRapido(c);
                    break;
                case 4:
                    break;
                default: forn=forn; break;
            }
            System.out.println("\n\t Fornecedor: " + forn.getNome()+
                    "\n\t Preco do Servico:" + forn.getServico().getPrecoServico()+"$/km"+
                    "\n\t Autonomia:" + forn.getServico().getAutonmia()+
                    "\n\t Temperatura da Encomenda:" + ((Urgentes)forn.getServico()).getTemperatura()+
                    "\n\t Precorre uma distancia máxima de:" + forn.getServico().getDistanciaMaxima()+" metros");

            double distan=CalcDistancia(c,forn.getFornCoords());
            double precoF=forn.getServico().getPrecoServico()*distan;
            nS++;
            Viagem v= new Viagem(precoF,distan,nS,forn.getServico().getDistanciaMaxima(),forn.getServico().getAutonmia(),forn.getServico().getPrecoServico());
            Servico s= new Urgentes(nS,forn.getServico().getDistanciaMaxima(),forn.getServico().getAutonmia(),forn.getServico().getPrecoServico(),t);
            listsCliente=listaU.get(cli).getListadeServicos();
            listsCliente.add(s.clone());
            listaU.get(cli).setListadeServicos(listsCliente);
            listsForn=forn.getListadeServicos();
            listsForn.add(s.clone());
            forn.setListadeServicos(listsForn);

            listvCliente= listaU.get(cli).getListadeviagens();
            listvCliente.add(v.clone());
            listaU.get(cli).setListadeviagens(listvCliente);
            listvForn=forn.getListadeviagens();
            listvForn.add(v.clone());
            forn.setListadeviagens(listvForn);
            System.out.println("SERVICO EFETUADO!!!!");
            printCaracteristicasdoServico(forn,v);
            menuCliente(cli);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro do Sistema. \n Tente Novamente.\n "+ e);
        }
    }

    public void novoServRefeicoes(int cli){
        try{
            System.out.println("Temperatura da Encomenda:");
            double t=buf.nextDouble();
            int c[]=ClienteLocal();
            menuEscolhadeServico();
            int op=buf.nextInt();
            switch (op){
                case 1:
                    forn=printListaFornRefeicoes();
                    break;
                case 2:
                    forn=printFornRefmaisBarato();
                    break;
                case 3:
                    forn=printFornRefmaisRapido(c);
                    break;
                case 4:
                    break;
                default: forn=forn; break;
            }
            System.out.println("\n\t Fornecedor: " + forn.getNome()+
                    "\n\t Preco do Servico:" + forn.getServico().getPrecoServico()+"$/km"+
                    "\n\t Autonomia:" + forn.getServico().getAutonmia()+
                    "\n\t Temperatura da Encomenda:" + ((Refeicoes)forn.getServico()).getTemperatura()+
                    "\n\t Precorre uma distancia máxima de:" + forn.getServico().getDistanciaMaxima()+" metros");

            double distan=CalcDistancia(c,forn.getFornCoords());
            double precoF=0.0;
            if(distan<5.0){
                precoF=((Refeicoes)forn.getServico()).getPrecoFixo();
            }else{
                precoF=forn.getServico().getPrecoServico()*distan;
            }
            nS++;
            Viagem v= new Viagem(precoF,distan,nS,forn.getServico().getDistanciaMaxima(),forn.getServico().getAutonmia(),forn.getServico().getPrecoServico());
            Servico s= new Refeicoes(nS,forn.getServico().getDistanciaMaxima(),forn.getServico().getAutonmia(),forn.getServico().getPrecoServico(),t);
            listsCliente=listaU.get(cli).getListadeServicos();
            listsCliente.add(s.clone());
            listaU.get(cli).setListadeServicos(listsCliente);
            listsForn=forn.getListadeServicos();
            listsForn.add(s.clone());
            forn.setListadeServicos(listsForn);

            listvCliente= listaU.get(cli).getListadeviagens();
            listvCliente.add(v.clone());
            listaU.get(cli).setListadeviagens(listvCliente);
            listvForn=forn.getListadeviagens();
            listvForn.add(v.clone());
            forn.setListadeviagens(listvForn);
            System.out.println("SERVICO EFETUADO!!!!");
            printCaracteristicasdoServico(forn,v);
            menuCliente(cli);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro do Sistema. \n Tente Novamente.\n "+ e);
        }
    }

    public void printCaracteristicasdoServico(Fornecedor f, Viagem v){
        double rounded1= Math.round(v.getDistanciaPercorrida()*10)/10.0;
        double rounded2= Math.round(v.getPrecoF()*10)/10.0;

        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%15s %17s %23s %15s", "FORNECEDOR", "TIPO DE SERVICO", "DISTANCIA PERCORRIDA", "PRECO FINAL");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%12s %16s %19s %20s", f.getNome(),f.getServico().getClassName(),rounded1+"km",rounded2+"euros");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
    }

    public void printFornecedor(int k){
            System.out.println("\n\t Nome: " + listaU.get(k).getNome() +
                    "\n\t Email:" + listaU.get(k).getEmail() +
                    "\n\t Password:" + listaU.get(k).getPassword() +
                    "\n\t Morada:" + listaU.get(k).getMorada() +
                    "\n\t Fornecedor Presta Servicos do tipo:" + ((Fornecedor) listaU.get(k)).getServico().getClassName() +
                    "\n\t Data:" + listaU.get(k).getEmail());
    }

    public void menuCliente(int n){
        System.out.print("\n\nBem vindo "+listaU.get(n).getNome()+"!!\n\n"+
                "Que tipo de Servico irá querer requerir?\n"+
                "1- Servico de Pessoas\n"+
                "2- Servico Bus\n"+
                "3- Servico Big\n"+
                "4- Servico Urgente\n"+
                "5- Servico de Refeições\n"+
                "6- Os meus servicos\n"+
                "7- Voltar ao Menu do Inicio\n"+
                "Op->");
            int opc=buf.nextInt();
            opcoesCliente(opc,n);
    }

    public void mostraMenuPrincipal(){
        System.out.println("::Menu::");
        System.out.println("1- Novo Cliente");
        System.out.println("2- Login Cliente");
        System.out.println("3- Novo Fornecedor");
        System.out.println("4- Login Fornecedor");
        System.out.println("5- Lista de Clientes");
        System.out.println("6- Lista de Fornecedores");
        System.out.println("7- Lista de Fornecedores por ordem de mais servicos efetuados ");
        System.out.println("0- Sair do Programa");
    }

    public void menuFornecedor(int n){
        System.out.print("\n\nBem vindo "+listaU.get(n).getNome()+"!!\n\n"+
                "Opções:\n"+
                "1- Atualizar as coordenadas?\n"+
                "2- Modificar preço do Serviço?\n"+
                "3- Alterar autonomia?\n"+
                "4- Historico de Serviços executados\n"+
                "5- Total Faturado\n"+
                "6- Voltar Menu do Inicio\n"+
                "Op->");
        int opc=buf.nextInt();
        opcoesFornecedor(opc,n);
    }

    public void menuEscolhadeServico(){
        System.out.print("Opções:\n"+
                "1- Lista de Fornecedores que executam esse Servico\n"+
                "2- Fornecedor mais barato\n"+
                "3- Fornecedor mais rápido\n"+
                "4- Voltar Menu do Inicio\n"+
                "Op->");
    }

    public int[]  ActualizaCoordenadas(int a){
        int asd[]= new int [2];
        System.out.println("Coordenadas Atuais:  "+Arrays.toString(((Fornecedor) listaU.get(a)).getFornCoords()));
        System.out.println("Novas Coordenadas");
        System.out.print("Coord X: ");
        asd[0]=buf.nextInt();
        System.out.print("Coord Y: ");
        asd[1]=buf.nextInt();
        ((Fornecedor) listaU.get(a)).setFornCoords(asd);
        System.out.println("Coordenadas Atualizadas:  "+Arrays.toString(((Fornecedor) listaU.get(a)).getFornCoords()));
        return asd;
    }

    public void ModificarPreco(int a){
        System.out.println("Preco Atual:  "+((Fornecedor) listaU.get(a)).getServico().getPrecoServico());
        System.out.println("Novo Preco:");
        double b=buf.nextDouble();
        ((Fornecedor) listaU.get(a)).getServico().setPrecoServico(b);
        System.out.println("Preco Atualizado: "+((Fornecedor) listaU.get(a)).getServico().getPrecoServico());

    }

    public int AlterarAutonomia(int a){
        System.out.println("Autonomia Atual:  "+((Fornecedor) listaU.get(a)).getServico().getAutonmia());
        System.out.println("Nova Autonomia:");
        int b=buf.nextInt();
        ((Fornecedor) listaU.get(a)).getServico().setAutonomia(b);
        System.out.println("Autonomia Atualizada: "+((Fornecedor) listaU.get(a)).getServico().getAutonmia());
        return b;
    }

    public int [] ClienteLocal(){
        int[] c= new int[2];
        System.out.println("Onde se Encontra?");
        System.out.println("Coord X:");
        c[0]=buf.nextInt();
        System.out.println("Coord Y:");
        c[1]=buf.nextInt();
        return c;
    }
    
    public Double CalcDistancia(int[]c1 , int[]c2){
        return Math.sqrt((c1[0]-c1[1])*(c1[0]-c1[1]) + (c2[0]-c2[1])*(c2[0]-c2[1]));
    }

    public void opcoesCliente(int opc, int c){
        switch (opc){
            case 1:
                novoServPessoas(c);
                break;
            case 2:
                novoServBus(c);
                break;
            case 3:
                novoServBig(c);
                break;
            case 4:
                novoServUrgentes(c);
                break;
            case 5:
                novoServRefeicoes(c);
                break;
            case 6:
                printHistorico(c);
                break;
        }
    }

    public void opcoesFornecedor(int opc, int f){
        switch (opc){
            case 1:
                ActualizaCoordenadas(f);
                break;
            case 2:
                ModificarPreco(f);
                break;
            case 3:
                AlterarAutonomia(f);
                break;
            case 4:
                printHistorico(f);
                break;
            case 5:
                printTotalFaturado(f);
                break;
        }
    }

    public void printTotalFaturado(int a){
        double total=0.0;
        ArrayList<Viagem>lista= listaU.get(a).getListadeviagens();

        for(Viagem v: lista){
            total+=v.precoF;
        }
        double rounded1= Math.round(total*10)/10.0;
        System.out.println("O total faturado até este preciso momeneto é: "+rounded1+" euros");
    }

    public void listadeFornComMaisServicos(){
        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor){
                if(listaU.get(a).getListadeServicos().size()<listaU.get(a).getListadeServicos().size()+1){
                    System.out.println("Fornecedores:");
                    System.out.println(" "+listaU.get(a).getNome());
                    System.out.println();
                }
            }
        }

    }

    public void printHistorico(int a){
        ArrayList<Viagem>lista=  listaU.get(a).getListadeviagens();

        for(Viagem v: lista){
            double rounded1= Math.round(v.getDistanciaPercorrida()*10)/10.0;
            double rounded2= Math.round(v.getPrecoF()*10)/10.0;
            System.out.println("Servico de nº " +v.getNumeroServico());
            System.out.println("Distancia percorrida: " +rounded1+" km");
            System.out.println("Preco Final: "+ rounded2+" euros");
            System.out.println();
        }
    }

    public void printCLiente(int k){
        System.out.println("Nome: " + listaU.get(k).getNome()+
                "\n\t Email:" + listaU.get(k).getEmail()+
                "\n\t Password:" + listaU.get(k).getPassword()+
                "\n\t Morada:" + listaU.get(k).getMorada()+
                "\n\t Data:" + listaU.get(k).getEmail());
    }

    public void prinListaCliente(){
        try{
            System.out.println("Clientes: ");{
                for(Integer k: listaU.keySet()){
                    if(listaU.get(k) instanceof Cliente){
                        printCLiente(k);
                        System.out.println("\n");
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Nao existem dados suficientes");
        }
    }

    public void printListaFornecedores(){
        try{
            System.out.println("Fornecedores: ");{
                for(Integer k: listaU.keySet()){
                    if(listaU.get(k) instanceof Fornecedor){
                        printFornecedor(k);
                        System.out.println("\n");
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Nao existem dados suficientes");
        }
    }

    public void printUtilizadores(){
        try{
            System.out.println("Utilizadores: ");{
                for(Integer k: listaU.keySet()){
                   if(listaU.get(k)instanceof Fornecedor){
                       System.out.println("Nome: " + listaU.get(k).getNome()+
                               "\n\t Email:" + listaU.get(k).getEmail()+
                               "\n\t Password:" + listaU.get(k).getPassword()+
                               "\n\t Morada:" + listaU.get(k).getMorada()+
                               "\n\t Servico:" + ((Fornecedor) listaU.get(k)).getServico().getClassName()+
                               "\n\t Coordenadas:"  +Arrays.toString(((Fornecedor) listaU.get(k)).getFornCoords())+
                               "\n\t Data:" + listaU.get(k).getEmail());
                   }else if(listaU.get(k)instanceof Cliente){
                       System.out.println("Nome: " + listaU.get(k).getNome()+
                               "\n\t Email:" + listaU.get(k).getEmail()+
                               "\n\t Password:" + listaU.get(k).getPassword()+
                               "\n\t Morada:" + listaU.get(k).getMorada()+
                               "\n\t Morada:" + listaU.get(k).getMorada()+
                               "\n\t Data:" + listaU.get(k).getEmail());

                   }
                }
            }
        }catch (Exception e){
            System.out.println("Nao existem dados suficientes");
        }
    }

    public Fornecedor printListaFornPessoas() {
        System.out.println("Fornecedores: ");
        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor){
                if(((Fornecedor) listaU.get(a)).getServico()instanceof Pessoas){
                    System.out.println(" -" + a + " " + listaU.get(a).getNome());
                }
            }
        }
        int opc=buf.nextInt();
        for(Integer a: listaU.keySet()) {
            if (listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Pessoas) {
                    if (a == opc) {
                        forn = ((Fornecedor) listaU.get(a));
                        System.out.println("Fornecedor Escolhido!!");
                    }
                }
            }
        }
        return forn;
    }

    public Fornecedor printFornPessmaisBarato(){
        Map<Integer,Double>list= new HashMap<>();
        for(Integer a : listaU.keySet()){
            if (listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Pessoas) {
                    list.put(a,((Fornecedor) listaU.get(a)).getServico().getPrecoServico());
                }
            }
        }
        Map.Entry<Integer,Double> min=null;
        for(Map.Entry<Integer,Double>entry : list.entrySet()){
            if(min == null || min.getValue()>entry.getValue()){
                min=entry;
            }
        }
        System.out.println("oi");
        for (Integer b: listaU.keySet()){
            if (listaU.get(b) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(b)).getServico() instanceof Pessoas) {
                    if(((Fornecedor) listaU.get(b)).getServico().getPrecoServico()==min.getValue()){
                        forn=((Fornecedor) listaU.get(b));
                        System.out.println("Nome  "+forn.getNome());
                        System.out.println("O SEU PRECO   "+forn.getServico().getPrecoServico());
                    }
                }
            }
        }
        return forn;
    }

    public Fornecedor printFornPessmaisRapido(int c[]){
        Map<Integer,Double>lista= new HashMap<>();
        int asd[];
        double res;

        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Pessoas) {
                    asd = ((Fornecedor) listaU.get(a)).getFornCoords();
                    res = CalcDistancia(c, asd);
                    lista.put(a, res);
                }
            }
        }

        Map.Entry<Integer,Double> min=null;
        for(Map.Entry<Integer,Double>entry : lista.entrySet()){
            if(min == null || min.getValue()>entry.getValue()){
                min=entry;
            }
        }

        for (Integer b: listaU.keySet()){
            if(b==(min.getKey())){
                forn=((Fornecedor) listaU.get(b));
            }
        }
        return  forn;
    }

    public Fornecedor printListaFornBus() {
        System.out.println("Fornecedores: ");
        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor){
                if(((Fornecedor) listaU.get(a)).getServico()instanceof Bus){
                    System.out.println(" -" + a + " " + listaU.get(a).getNome());
                }
            }
        }
        int opc=buf.nextInt();
        for(Integer a: listaU.keySet()) {
            if (listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Bus) {
                    if (a == opc) {
                        forn = ((Fornecedor) listaU.get(a));
                        System.out.println("Fornecedor Escolhido!!");
                    }
                }
            }
        }
        return forn;
    }

    public Fornecedor printFornBusmaisBarato(){
        Map<Integer,Double>list= new HashMap<>();

        for(Integer a : listaU.keySet()){
            if (listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Bus) {
                    list.put(a,((Fornecedor) listaU.get(a)).getServico().getPrecoServico());
                }
            }
        }
        Map.Entry<Integer,Double> min=null;
        for(Map.Entry<Integer,Double>entry : list.entrySet()){
            if(min == null || min.getValue()>entry.getValue()){
                min=entry;
            }
        }
        System.out.println("oi");
        for (Integer b: listaU.keySet()){
            if (listaU.get(b) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(b)).getServico() instanceof Bus) {
                    if(((Fornecedor) listaU.get(b)).getServico().getPrecoServico()==min.getValue()){
                        forn=((Fornecedor) listaU.get(b));
                        System.out.println("Nome  "+forn.getNome());
                        System.out.println("O SEU PRECO   "+forn.getServico().getPrecoServico());
                    }
                }
            }
        }
        return forn;
    }

    public Fornecedor printFornBusmaisRapido(int c[]){
        Map<Integer,Double>lista= new HashMap<>();
        int asd[];
        double res;

        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Bus) {
                    asd = ((Fornecedor) listaU.get(a)).getFornCoords();
                    res = CalcDistancia(c, asd);
                    lista.put(a, res);
                }
            }
        }

        Map.Entry<Integer,Double> min=null;
        for(Map.Entry<Integer,Double>entry : lista.entrySet()){
            if(min == null || min.getValue()>entry.getValue()){
                min=entry;
            }
        }

        for (Integer b: listaU.keySet()){
            if(b==(min.getKey())){
                forn=((Fornecedor) listaU.get(b));
            }
        }
        return  forn;
    }

    public Fornecedor printListaFornBig() {
        System.out.println("Fornecedores: ");
        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor){
                if(((Fornecedor) listaU.get(a)).getServico()instanceof Big){
                    System.out.println(" -" + a + " " + listaU.get(a).getNome());
                }
            }
        }
        int opc=buf.nextInt();
        for(Integer a: listaU.keySet()) {
            if (listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Big) {
                    if (a == opc) {
                        forn = ((Fornecedor) listaU.get(a));
                        System.out.println("Fornecedor Escolhido!!");
                    }
                }
            }
        }
        return forn;
    }

    public Fornecedor printFornBigmaisBarato(){
        Map<Integer,Double>list= new HashMap<>();

        for(Integer a : listaU.keySet()){
            if (listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Big) {
                    list.put(a,((Fornecedor) listaU.get(a)).getServico().getPrecoServico());
                }
            }
        }
        Map.Entry<Integer,Double> min=null;
        for(Map.Entry<Integer,Double>entry : list.entrySet()){
            if(min == null || min.getValue()>entry.getValue()){
                min=entry;
            }
        }
        System.out.println("oi");
        for (Integer b: listaU.keySet()){
            if (listaU.get(b) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(b)).getServico() instanceof Big) {
                    if(((Fornecedor) listaU.get(b)).getServico().getPrecoServico()==min.getValue()){
                        forn=((Fornecedor) listaU.get(b));
                        System.out.println("Nome  "+forn.getNome());
                        System.out.println("O SEU PRECO   "+forn.getServico().getPrecoServico());
                    }
                }
            }
        }
        return forn;
    }

    public Fornecedor printFornBigmaisRapido(int c[]){
        Map<Integer,Double>lista= new HashMap<>();
        int asd[];
        double res;

        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Big) {
                    asd = ((Fornecedor) listaU.get(a)).getFornCoords();
                    res = CalcDistancia(c, asd);
                    lista.put(a, res);
                }
            }
        }

        Map.Entry<Integer,Double> min=null;
        for(Map.Entry<Integer,Double>entry : lista.entrySet()){
            if(min == null || min.getValue()>entry.getValue()){
                min=entry;
            }
        }

        for (Integer b: listaU.keySet()){
            if(b==(min.getKey())){
                forn=((Fornecedor) listaU.get(b));
            }
        }
        return  forn;
    }

    public Fornecedor printListaFornUrgentes() {
        System.out.println("Fornecedores: ");
        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor){
                if(((Fornecedor) listaU.get(a)).getServico()instanceof Urgentes){
                    System.out.println(" -" + a + " " + listaU.get(a).getNome());
                }
            }
        }
        int opc=buf.nextInt();
        for(Integer a: listaU.keySet()) {
            if (listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Urgentes) {
                    if (a == opc) {
                        forn = ((Fornecedor) listaU.get(a));
                        System.out.println("Fornecedor Escolhido!!");
                    }
                }
            }
        }
        return forn;
    }

    public Fornecedor printFornUrgentesmaisBarato(){
        Map<Integer,Double>list= new HashMap<>();

        for(Integer a : listaU.keySet()){
            if (listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Urgentes) {
                    list.put(a,((Fornecedor) listaU.get(a)).getServico().getPrecoServico());
                }
            }
        }
        Map.Entry<Integer,Double> min=null;
        for(Map.Entry<Integer,Double>entry : list.entrySet()){
            if(min == null || min.getValue()>entry.getValue()){
                min=entry;
            }
        }
        System.out.println("oi");
        for (Integer b: listaU.keySet()){
            if (listaU.get(b) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(b)).getServico() instanceof Urgentes) {
                    if(((Fornecedor) listaU.get(b)).getServico().getPrecoServico()==min.getValue()){
                        forn=((Fornecedor) listaU.get(b));
                        System.out.println("Nome  "+forn.getNome());
                        System.out.println("O SEU PRECO   "+forn.getServico().getPrecoServico());
                    }
                }
            }
        }
        return forn;
    }

    public Fornecedor printFornUrgentesmaisRapido(int c[]){
        Map<Integer,Double>lista= new HashMap<>();
        int asd[];
        double res;

        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Urgentes) {
                    asd = ((Fornecedor) listaU.get(a)).getFornCoords();
                    res = CalcDistancia(c, asd);
                    lista.put(a, res);
                }
            }
        }

        Map.Entry<Integer,Double> min=null;
        for(Map.Entry<Integer,Double>entry : lista.entrySet()){
            if(min == null || min.getValue()>entry.getValue()){
                min=entry;
            }
        }

        for (Integer b: listaU.keySet()){
            if(b==(min.getKey())){
                forn=((Fornecedor) listaU.get(b));
            }
        }
        return  forn;
    }

    public Fornecedor printListaFornRefeicoes() {
        System.out.println("Fornecedores: ");
        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor){
                if(((Fornecedor) listaU.get(a)).getServico()instanceof Refeicoes){
                    System.out.println(" -" + a + " " + listaU.get(a).getNome());
                }
            }
        }
        int opc=buf.nextInt();
        for(Integer a: listaU.keySet()) {
            if (listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Refeicoes) {
                    if (a == opc) {
                        forn = ((Fornecedor) listaU.get(a));
                        System.out.println("Fornecedor Escolhido!!");
                    }
                }
            }
        }
        return forn;
    }

    public Fornecedor printFornRefmaisBarato(){
        Map<Integer,Double>list= new HashMap<>();

        for(Integer a : listaU.keySet()){
            if (listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Refeicoes) {
                    list.put(a,((Fornecedor) listaU.get(a)).getServico().getPrecoServico());
                }
            }
        }
        Map.Entry<Integer,Double> min=null;
        for(Map.Entry<Integer,Double>entry : list.entrySet()){
            if(min == null || min.getValue()>entry.getValue()){
                min=entry;
            }
        }
        System.out.println("oi");
        for (Integer b: listaU.keySet()){
            if (listaU.get(b) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(b)).getServico() instanceof Refeicoes) {
                    if(((Fornecedor) listaU.get(b)).getServico().getPrecoServico()==min.getValue()){
                        forn=((Fornecedor) listaU.get(b));
                        System.out.println("Nome  "+forn.getNome());
                        System.out.println("O SEU PRECO   "+forn.getServico().getPrecoServico());
                    }
                }
            }
        }
        return forn;
    }

    public Fornecedor printFornRefmaisRapido(int c[]){
        Map<Integer,Double>lista= new HashMap<>();
        int asd[];
        double res;

        for(Integer a: listaU.keySet()){
            if(listaU.get(a) instanceof Fornecedor) {
                if (((Fornecedor) listaU.get(a)).getServico() instanceof Refeicoes) {
                    asd = ((Fornecedor) listaU.get(a)).getFornCoords();
                    res = CalcDistancia(c, asd);
                    lista.put(a, res);
                }
            }
        }

        Map.Entry<Integer,Double> min=null;
        for(Map.Entry<Integer,Double>entry : lista.entrySet()){
            if(min == null || min.getValue()>entry.getValue()){
                min=entry;
            }
        }

        for (Integer b: listaU.keySet()){
            if(b==(min.getKey())){
                forn=((Fornecedor) listaU.get(b));
            }
        }
        return  forn;
    }

    public boolean save(){

        try{
            File fc=new File("Utilizadores.txt");
            if(!fc.exists()){
                fc.createNewFile();
            }
            ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(fc));
            out.writeObject(listaU);
            out.flush();
            out.close();
        }catch (IOException E){
            System.out.println("Erro no Output do dados de utilizadores.");
            return false;
        }
        return true;
    }

    public void read(){

        try{
            File fc= new File("Utilizadores.txt");
            if(!fc.exists()){
                return;
            }
            ObjectInputStream in=new ObjectInputStream(new FileInputStream(fc));
            listaU=(HashMap) in.readObject();
            in.close();


        }catch (ClassNotFoundException C){
            System.out.println("Classe nao encontrada");
            C.printStackTrace();
        }catch (IOException E){
            System.out.println("Erro no Input dos dados de utilizadores");
            E.printStackTrace();
        }
        for(int k: listaU.keySet()){
            nU=k;
        }
    }

}


