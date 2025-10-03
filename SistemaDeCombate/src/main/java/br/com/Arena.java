package br.com;

import br.com.Personagem.Atacante;

public class Arena {

    public void iniciarCombate(Personagem p1, Personagem p2, Personagem p3) {
        System.out.println("\n🏟 COMBATE INICIADO! 🏟");
        System.out.println(p1.getNome() + " vs " + p2.getNome() + " vs " + p3.getNome());
        System.out.println("================================\n");

        int turno = 1;

        // Enquanto pelo menos 2 ainda estiverem vivos
        while (quantosVivos(p1, p2, p3) > 1) {
            System.out.println("--- Turno " + turno + " ---");

            // p1 ataca p2 (ou p3 se p2 já morreu)
            if (p1.getVida() > 0 && p1 instanceof Atacante) {
                Personagem alvo = (p2.getVida() > 0) ? p2 : p3;
                ((Atacante) p1).atacar(alvo);
            }

            // p2 ataca p3 (ou p1 se p3 já morreu)
            if (p2.getVida() > 0 && p2 instanceof Atacante) {
                Personagem alvo = (p3.getVida() > 0) ? p3 : p1;
                ((Atacante) p2).atacar(alvo);
            }

            // p3 ataca p1 (ou p2 se p1 já morreu)
            if (p3.getVida() > 0 && p3 instanceof Atacante) {
                Personagem alvo = (p1.getVida() > 0) ? p1 : p2;
                ((Atacante) p3).atacar(alvo);
            }

            // Status dos personagens
            System.out.println(p1.getNome() + ": " + p1.getVida() + " HP");
            System.out.println(p2.getNome() + ": " + p2.getVida() + " HP");
            System.out.println(p3.getNome() + ": " + p3.getVida() + " HP\n");

            turno++;
        }

        // Determina vencedor (quem ainda está vivo)
        Personagem vencedor = (p1.getVida() > 0) ? p1 : (p2.getVida() > 0 ? p2 : p3);
        System.out.println("🏆 " + vencedor.getNome() + " VENCEU!");
    }

    // Método auxiliar para contar quantos ainda estão vivos
    private int quantosVivos(Personagem... personagens) {
        int vivos = 0;
        for (Personagem p : personagens) {
            if (p.getVida() > 0) vivos++;
        }
        return vivos;
    }
}

