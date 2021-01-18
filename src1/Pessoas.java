
/**
 * Escreva a descrição da classe Pessoas aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Pessoas extends Servico
{
   private int NumeroPessoas;

   public Pessoas(int numeroServico, int distanciaMax, int autonomia, double preco , int npessoas) {
        super(numeroServico, distanciaMax, autonomia,preco);
        this.NumeroPessoas = npessoas;
    }

    public String getClassName(){return this.getClass().getSimpleName();}

    public int getNumeroPessoas() {
        return NumeroPessoas;
    }

    public void setNumeroPessoas(int np){this.NumeroPessoas=np;}

    public Pessoas clone(){
        Pessoas s = new Pessoas(super.getNumeroServico(),super.getDistanciaMaxima(),super.getAutonmia(),super.getPrecoServico(),this.NumeroPessoas);
        return s;
    }
}
