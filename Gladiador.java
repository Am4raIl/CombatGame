public class Gladiador extends Lutador {
    private Armas armas;
    private boolean armaQuebrada;

    public Gladiador(String nome) {
        super(nome);
        armas = new Armas();
        armaQuebrada = false;
    }

    public boolean temArma() {
        return !armaQuebrada && armas.getDurabilidadeEspada() > 0;
    }

    public void pegarArma(Armas arma) {
        armas = arma;
        armaQuebrada = false;
        System.out.println(getNome() + " pegou as armas do oponente!");
    }

    @Override
    public double atacar(Combatente adversario) {
        double danoCausado;

        if (armas.getDurabilidadeEspada() > 0) {
            if (Math.random() > 0.35) {
                nomeAtaque = "Niitoryu";
                danoCausado = adversario.defender(armas.niitoryu());
            } else {
                nomeAtaque = "Santoryu";
                danoCausado = adversario.defender(armas.santoryu());
            }

            if (armas.getDurabilidadeEspada() <= 0 && !armaQuebrada) {
                armaQuebrada = true;
                System.out.println("A arma desse Gladiador quebrou! Esse foi seu último golpe!");
            }
        } else {
            if (Math.random() > 0.5) {
                nomeAtaque = "Magueri";
                danoCausado = adversario.defender(this.magueri());
            } else {
                nomeAtaque = "Guedan Barai";
                danoCausado = adversario.defender(this.guedanBarai());
            }
        }

        return danoCausado;
    }

    public Armas getArmas() {
        return armas;
    }
}
