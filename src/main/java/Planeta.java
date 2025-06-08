public class Planeta {
    private String nome;
    private double massa;
    private double diametro;
    private double distanciaSol;
    private boolean temAtmosfera;

    public Planeta(String nome, double massa, double diametro, double distanciaSol, boolean temAtmosfera) {
        this.nome = nome;
        this.massa = massa;                 //em 10^24 kg
        this.diametro = diametro;           //em km
        this.distanciaSol = distanciaSol;   //em milhoes de km
        this.temAtmosfera = temAtmosfera;
    }

    public String getNome() { return nome; }
    public double getMassa() { return massa; }
    public double getDiametro() { return diametro; }
    public double getDistanciaSol() { return distanciaSol; }
    public boolean isTemAtmosfera() { return temAtmosfera; }
}
