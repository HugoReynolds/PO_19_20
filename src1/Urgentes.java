 


/**
 * Escreva a descrição da classe Urgentes aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Urgentes extends Servico
{
    private double temperatura;

    public Urgentes(int numeroServico, int distanciaMax, int autonomia, double preco , double temp) {
        super(numeroServico, distanciaMax, autonomia,preco);
        this.temperatura = temp;
    }

    public String getClassName(){return this.getClass().getSimpleName();}

    public double getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(double temp){this.temperatura=temp;}

    public Urgentes clone(){
        Urgentes u = new Urgentes(super.getNumeroServico(),super.getDistanciaMaxima(),super.getAutonmia(),super.getPrecoServico(),this.temperatura);
        return u;
    }
}
