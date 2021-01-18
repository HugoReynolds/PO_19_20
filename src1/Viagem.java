
/**
 * Escreva a descrição da classe Viagem aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Viagem extends Servico
{
    double precoF;
    double distanciaPercorrida;
    
    public Viagem(double precoF, double distanciaPercorrida ,int numeroServico, int distanciaMax, int autonomia, double preco){
        super(numeroServico,distanciaMax,autonomia,preco);
        this.distanciaPercorrida=distanciaPercorrida;
        this.precoF=super.getPrecoServico()*this.distanciaPercorrida;
        this.precoF=precoF;
    }

    public double getPrecoF() {
        return this.precoF;
    }

    public void setPrecoF(double pre){this.precoF=pre;}

    public double getDistanciaPercorrida() {
        return this.distanciaPercorrida;
    }

    public void setDistanciaPercorrida(double pre){this.distanciaPercorrida=pre;}

    public Viagem clone(){
        Viagem v= new Viagem(this.precoF,this.distanciaPercorrida,super.getNumeroServico(),super.getDistanciaMaxima(),super.getAutonmia(),super.getPrecoServico());
        return v;
    }

}
