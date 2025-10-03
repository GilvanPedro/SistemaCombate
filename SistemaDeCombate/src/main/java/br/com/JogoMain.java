package br.com;

public class JogoMain {
    public static void main(String[] args) {

        Guerreiro conan = new Guerreiro("Conan");
        Mago gandalf = new Mago("Gandalf");
        Arqueiro sergio = new Arqueiro("Sérgio");

        conan.habilidadeEspecial();
        gandalf.habilidadeEspecial();
        sergio.habilidadeEspecial();

        Arena arena = new Arena();
        arena.iniciarCombate(conan, gandalf, sergio);
    }
}
