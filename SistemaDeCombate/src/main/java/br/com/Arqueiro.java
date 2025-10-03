package br.com;

public class Arqueiro extends Personagem implements Personagem.Atacante{
    private int flechas;

    public Arqueiro(String nome) {
        super(nome, 100, 30, 12);
        this.flechas = 20;
    }

    @Override
    public void atacar(Personagem alvo) {
        if (flechas >= 1) {
            int dano = this.getAtaque();
            alvo.setVida(alvo.getVida() - dano);
            flechas -= 1;

            System.out.println("🔮 " + getNome() + " lança BOLA DE FOGO em "
                    + alvo.getNome() + "! Dano: " + dano);
        } else {
            System.out.println("❌ " + getNome() + " está sem flechas para atacar!");
        }
    }

    @Override
    public void habilidadeEspecial() {
        flechas = 20;
        System.out.println("✨ " + getNome() + " recupera todas as suas flechas perdidas no chão!");
    }
}