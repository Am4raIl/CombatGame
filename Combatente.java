public abstract class Combatente {
    public String nome;
    public double energia;
    protected String nomeAtaque;

    public Combatente(String nome) {
        this.nome = nome;
        energia = 100;
    }

    public abstract double atacar(Combatente adversario);

    public String getNome() {
        return nome;
    }

    public double getEnergia() {
        return energia;
    }

    public boolean isAlive() {
        return energia > 0;
    }

    public double defender(double poderOfensivo) {
        double danoCausado = 0;
        double chanceEsquiva = 0.3;
        double chanceGuarda = 0.4;

        double chanceDefesa = Math.random();
        if (chanceDefesa <= chanceEsquiva) {
            // Esquiva
            System.out.println(getNome() + " se esquivou do ataque!");
            danoCausado = poderOfensivo * 0.5; // Redução de 50% de dano na esquiva
        } else if (chanceDefesa <= chanceEsquiva + chanceGuarda) {
            // Guarda
            System.out.println(getNome() + " fez guarda contra o ataque!");
            danoCausado = poderOfensivo * 0.7; // Redução de 30% de dano na guarda
        } else {
            // Não fez nada
            System.out.println(getNome() + " não fez nada para se defender!");
            danoCausado = poderOfensivo;
        }

        danoCausado = Math.min(danoCausado, energia);
        energia -= danoCausado;
        return danoCausado;
    }

    public String getNomeAtaque() {
        return nomeAtaque;
    }
}