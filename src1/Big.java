
/**
 * Escreva a descrição da classe Big aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Big extends Servico
{
    private int Peso;

    public Big(int numeroServico, int distanciaMax, int autonomia, double preco , int peso) {
        super(numeroServico, distanciaMax, autonomia,preco);
        this.Peso = peso;
    }

    public String getClassName(){return this.getClass().getSimpleName();}

    public int getPeso() {
        return this.Peso;
    }

    public void setPeso(int ps){this.Peso=ps;}

    public Big clone(){
        Big b = new Big(super.getNumeroServico(),super.getDistanciaMaxima(),super.getAutonmia(),super.getPrecoServico(),this.Peso);
        return b;
    }
}
