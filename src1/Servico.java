
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Servico implements Serializable
{
    private int NumeroServico;
    private int DistanciaMaxima;
    private double PrecoS;
    private int autonomia;


    public Servico(int numeroServico, int distanciaMax, int autonomia, double preco) {
        this.NumeroServico = numeroServico;
        this.DistanciaMaxima = distanciaMax;
        this.PrecoS=preco;
        this.autonomia=autonomia;
    }

    public String getClassName(){return this.getClass().getSimpleName();}

    public int getNumeroServico(){return this.NumeroServico;}

    public int getDistanciaMaxima(){return this.DistanciaMaxima;}

    public double getPrecoServico(){return this.PrecoS;}

    public int getAutonmia(){return this.autonomia;}
    
    public void setDistanciaMaxima(int distanciamax) {this.DistanciaMaxima = distanciamax;}

    public void setPrecoServico(double prec){this.PrecoS=prec;}

    public void setAutonomia(int autonomia){this.autonomia=autonomia;}
    
    public abstract Servico clone();
}
