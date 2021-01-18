
/**
 * Escreva a descrição da classe Refeicoes aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Refeicoes extends Servico
{
    private double temperatura;
    private static int PrecoFixo=20;

    public Refeicoes(int numeroServico, int distanciaMax, int autonomia, double preco , double temp) {
        super(numeroServico, distanciaMax, autonomia,preco);
        this.temperatura=temp;
    }

    public String getClassName(){return this.getClass().getSimpleName();}

    public int getPrecoFixo(){return PrecoFixo;}

    public double getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(double temp){this.temperatura=temp;}

    public Refeicoes clone(){
        Refeicoes r = new Refeicoes(super.getNumeroServico(),super.getDistanciaMaxima(),super.getAutonmia(),super.getPrecoServico(),this.temperatura);
        return r;
    }

}
