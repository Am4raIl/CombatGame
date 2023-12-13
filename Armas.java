public class Armas {
    private double durabilidadeEspada;

    public Armas() {
        durabilidadeEspada = 50; 
    }

    public double niitoryu() {
        durabilidadeEspada -= 10; 
        return 30; 
    }

    public double santoryu() {
        durabilidadeEspada -= 20; 
        return 40; 
    }

    public double getDurabilidadeEspada() {
        return durabilidadeEspada;
    }
}
