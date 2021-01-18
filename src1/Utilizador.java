import java.util.*;
import java.io.Serializable;

public abstract class Utilizador implements Serializable
{
    private String email;
    private String nome;
    private String password;
    private String morada;
    private String data;
    private ArrayList<Viagem>listadeviagens;
    private ArrayList<Servico>listadeservicos;
    
    public Utilizador(String email, String nome, String password, String morada, String data, ArrayList<Viagem>listav, ArrayList<Servico>listas){
        this.email=email;
        this.nome=nome;
        this.password=password;
        this.morada=morada;
        this.data=data;
        this.listadeviagens=listav;
        this.listadeservicos=listas;
    }
    
    public String getEmail(){return this.email;}
    
    public String getNome(){return this.nome; }
   
    public String getPassword(){return this.password;}
    
    public String getMorada(){return this.morada;}
    
    public String getData(){return this.data;}

    public ArrayList<Viagem>getListadeviagens(){return this.listadeviagens;}
    
    public ArrayList<Servico>getListadeServicos(){return this.listadeservicos;}
    
    public void setEmail(String email){this.email=email;}
    
    public void setNome(String nome){this.nome=nome;}
    
    public void setPassword(String password){this.password=password;}
    
    public void setMorada(String morada){this.morada=morada;}
    
    public void setData(String data){this.data=data;}

    public  void setListadeviagens(ArrayList<Viagem>list){this.listadeviagens=list;}
    
    public  void setListadeServicos(ArrayList<Servico>list){this.listadeservicos=list;}
    
    public abstract Utilizador clone();
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.email).append(": ")
          .append(this.nome).append(", ")
          .append(this.password).append(", ")
          .append(this.morada).append("* - ")
          .append(this.data);     
        return sb.toString();
    }
   
    @Override
    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        Utilizador a = (Utilizador) o;
        return this.email.equals(a.getEmail()) &&
               this.nome.equals(a.getNome()) &&
               this.password.equals(a.getPassword()) &&
               this.morada.equals(a.getMorada()) &&
               this.data.equals(a.getData());
    }
}
