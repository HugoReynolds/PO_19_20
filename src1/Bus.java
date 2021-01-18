 


/**
 * Escreva a descrição da classe Bus aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Bus extends Servico
{
    private int NumeroPessoas;

    public Bus(int numeroServico, int distanciaMax, int autonomia, double preco , int npessoas) {
        super(numeroServico, distanciaMax, autonomia,preco);
        this.NumeroPessoas = npessoas;
    }

    public String getClassName(){return this.getClass().getSimpleName();}

    public int getNumeroPessoas() {
        return NumeroPessoas;
    }

    public void setNumeroPessoas(int np){this.NumeroPessoas=np;}

    public Bus clone(){
        Bus b = new Bus(super.getNumeroServico(),super.getDistanciaMaxima(),super.getAutonmia(),super.getPrecoServico(),this.NumeroPessoas);
        return b;
    }
}
