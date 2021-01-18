import java.util.ArrayList;

public class Cliente extends Utilizador
{
    public Cliente(String email, String nome, String password, String morada, String data, ArrayList<Viagem>listv, ArrayList<Servico>lists){
        super(email, nome, password, morada, data,listv,lists);
    }
    
    public Cliente clone(){
        return new Cliente(super.getEmail(),super.getNome(),super.getPassword(),super.getMorada(), super.getData(),super.getListadeviagens(),super.getListadeServicos());
    }
    
}

