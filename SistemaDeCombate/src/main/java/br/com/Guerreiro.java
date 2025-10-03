package br.com;

public class Guerreiro extends Personagem implements Personagem.Atacante, Personagem.Defensor {

    public Guerreiro(String nome) {
        super(nome, 150, 30, 25);
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = this.getAtaque() - alvo.getDefesa();
        if (dano > 0) {
            alvo.setVida(alvo.getVida() - dano);
            System.out.println("⚔️ " + getNome() + " ataca " + alvo.getNome() +
                    " causando " + dano + " de dano!");
        } else {
            System.out.println("⚔️ " + getNome() + " ataca " + alvo.getNome() +
                    " mas não causa dano!");
        }
    }

    @Override
    public void defender() {
        System.out.println("🛡 " + getNome() + " levanta o escudo!");
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println("💥 " + getNome() + " usa FÚRIA DE BATALHA! Ataque +50%");
    }
}