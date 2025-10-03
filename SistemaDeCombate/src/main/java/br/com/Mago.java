package br.com;

public class Mago extends Personagem implements Personagem.Atacante{
    private int mana;

    public Mago(String nome) {
        super(nome, 100, 40, 10);
        this.mana = 100;
    }

    @Override
    public void atacar(Personagem alvo) {
        if (mana >= 20) {
            int dano = this.getAtaque();
            alvo.setVida(alvo.getVida() - dano);
            mana -= 20;

            System.out.println("🔮 " + getNome() + " lança BOLA DE FOGO em "
                    + alvo.getNome() + "! Dano: " + dano);
        } else {
            System.out.println("❌ " + getNome() + " está sem mana para atacar!");
        }
    }

    @Override
    public void habilidadeEspecial() {
        mana = 100;
        System.out.println("✨ " + getNome() + " usa RECUPERAÇÃO MÁGICA e restaura toda a mana!");
    }
}
