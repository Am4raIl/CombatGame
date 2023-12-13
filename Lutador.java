public class Lutador extends Combatente implements Karate{
    public Lutador(String nome) {
        super(nome);
    }

    public double magueri() {
        return 20;
    }

    public double guedanBarai() {
        return 15;
    }

    public int esquivar() {
        return 0;
    }

    public int fazerGuarda() {
        return 0;
    }

    @Override
    public double atacar(Combatente adversario) {
        double danoCausado;
        if (Math.random() > 0.5) {
            nomeAtaque = "Magueri";
            danoCausado = adversario.defender(this.magueri());
        } else {
            nomeAtaque = "Guedan Barai";
            danoCausado = adversario.defender(this.guedanBarai());
        }
        return danoCausado;
    }
}