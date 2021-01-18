import java.util.ArrayList;

public class Fornecedor extends Utilizador
{
    private int[] coords;
    private Servico ser;
    
    public Fornecedor(String email, String nome, String password, String morada, String data, ArrayList<Viagem>list, ArrayList<Servico>lists, int[]Coords, Servico servico){
        super(email, nome, password, morada, data,list,lists);
        this.coords=Coords;
        this.ser=servico;
    }
    
    public int[] getFornCoords(){return this.coords;}
    
    public void setFornCoords(int[] a){this.coords=a;}
    
    public Servico getServico(){return this.ser;}
    
    public Fornecedor clone(){
        return new Fornecedor(super.getEmail(),super.getNome(),super.getPassword(),super.getMorada(),super.getData(),super.getListadeviagens(),super.getListadeServicos(),this.getFornCoords(), this.getServico());
    }
}
