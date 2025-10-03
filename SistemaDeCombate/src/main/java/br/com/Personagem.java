package br.com;

    public abstract class Personagem {
        private String nome;
        private int vida;
        private int ataque;
        private int defesa;

        public Personagem(String nome, int vida, int ataque, int defesa) {
            this.nome = nome;
            this.vida = vida;
            this.ataque = ataque;
            this.defesa = defesa;
        }

        // Método abstrato
        public abstract void habilidadeEspecial();

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public int getVida() {
            return vida;
        }

        public void setVida(int vida) {
            this.vida = vida;
        }

        public int getAtaque() {
            return ataque;
        }

        public int getDefesa() {
            return defesa;
        }
        // Interface Atacante
        public interface Atacante {
            void atacar(Personagem alvo);
        }

        // Interface Defensor
        public interface Defensor {
            void defender();
        }
    }