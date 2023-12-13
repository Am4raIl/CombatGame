public class Fera extends Combatente {
    public Fera(String nome) {
        super(nome);
    }

    public double morder() {
        return 25;
    }

    public double usarGarra() {
        return 20;
    }

    public int esquivar() {
        return 0; 
    }

    @Override
    public double atacar(Combatente adversario) {
        double danoCausado;
        if (Math.random() > 0.6) {
            nomeAtaque = "Mordida";
            danoCausado = adversario.defender(this.morder());
        } else {
            nomeAtaque = "Garra";
            danoCausado = adversario.defender(this.usarGarra());
        }
        return danoCausado;
    }


    @Override
    public double defender(double poderOfensivo) {
        double danoCausado = 0;
        double chanceEsquiva = 0.6; // Aumente a chance de esquiva para 60%
        double chanceDefesa = Math.random();

        if (chanceDefesa <= chanceEsquiva) {
            // Esquiva
            System.out.println(getNome() + " se esquivou do ataque!");
            danoCausado = poderOfensivo * 0.5; // Redução de 50% de dano na esquiva
        } else {
            // Não fez nada
            System.out.println(getNome() + " não fez nada para se defender!");
            danoCausado = poderOfensivo;
        }

        danoCausado = Math.min(danoCausado, energia);
        energia -= danoCausado;
        return danoCausado;
    }
}