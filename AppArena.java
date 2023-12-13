import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AppArena {
    public Combatente realizarLuta(Combatente combatente1, Combatente combatente2) {
        System.out.println("Início de Combate: " + combatente1.getNome() + "[" + combatente1.getEnergia() + "] vs. [" + combatente2.getEnergia() + "]" + combatente2.getNome());
        int turno = (int) (Math.random() * 2); // 0 ou 1
        Combatente vencedor = null;

        while (combatente1.isAlive() && combatente2.isAlive()) {
            Combatente atacante, defensor;
            if (turno == 0) {
                atacante = combatente1;
                defensor = combatente2;
            } else {
                atacante = combatente2;
                defensor = combatente1;
            }
            turno = 1 - turno; // Alternar turno (0 para 1 e vice-versa)
            double danoCausado = atacante.atacar(defensor);

            System.out.println(atacante.getNome() + " atacou " + defensor.getNome() + " com " + atacante.getNomeAtaque() +
                    " causando " + String.format("%.2f", danoCausado) + " de dano. " + combatente1.getNome() +
                    "[" + String.format("%.1f", combatente1.getEnergia()) + "] vs. [" +
                    String.format("%.1f", combatente2.getEnergia()) + "]" + combatente2.getNome());

        }

        if (combatente1.isAlive()) {
            vencedor = combatente1;
            Combatente perdedor = combatente2;
            if (vencedor instanceof Gladiador && !((Gladiador) vencedor).temArma()) {
                if (perdedor instanceof Gladiador && ((Gladiador) perdedor).temArma()) {
                    ((Gladiador) vencedor).pegarArma(((Gladiador) perdedor).getArmas());
                }
            }
        } else {
            vencedor = combatente2;
            Combatente perdedor = combatente1;
            if (vencedor instanceof Gladiador && !((Gladiador) vencedor).temArma()) {
                if (perdedor instanceof Gladiador && ((Gladiador) perdedor).temArma()) {
                    ((Gladiador) vencedor).pegarArma(((Gladiador) perdedor).getArmas());
                }
            }
        }

        System.out.println("Vencedor: " + vencedor.getNome() + "\n");
        return vencedor;
    }

    public void iniciarTorneio() {
        int numCombatantes = 16; // Número fixo de combatentes
        List<Combatente> combatentes = new ArrayList<>();

        String[] classes = {"Fera", "Gladiador"};
        Random random = new Random();

        for (int i = 0; i < numCombatantes; i++) {
            String classeEscolhida = classes[random.nextInt(classes.length)];
            Combatente novoCombatente;

            if (classeEscolhida.equals("Lutador")) {
                novoCombatente = new Lutador("Lutador " + (i + 1));
            } else if (classeEscolhida.equals("Fera")) {
                novoCombatente = new Fera("Fera " + (i + 1));
            } else {
                novoCombatente = new Gladiador("Gladiador " + (i + 1));
            }

            combatentes.add(novoCombatente);
        }

        while (combatentes.size() > 1) {
            List<Combatente> vencedores = new ArrayList<>();
            int tamanho = combatentes.size();
            for (int i = 0; i < tamanho - 1; i += 2) {
                Combatente combatente1 = combatentes.get(i);
                Combatente combatente2 = combatentes.get(i + 1);
                Combatente vencedor = realizarLuta(combatente1, combatente2);
                vencedores.add(vencedor);
            }
            combatentes = vencedores;
        }

        System.out.println("Campeão do Torneio: " + combatentes.get(0).getNome());
    }

    public static void main(String[] args) {
        AppArena arena = new AppArena();
        arena.iniciarTorneio();
    }
}
