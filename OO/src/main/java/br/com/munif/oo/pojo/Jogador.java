package br.com.munif.oo.pojo;

public class Jogador extends Personagem {

    public Jogador(String nome, Lugar lugar) {
        super(nome, lugar);
    }

    @Override
    public void chora() {
        System.out.println("Buabuaba");
    }

    public String getNome() {
        return nome;
    }

}
