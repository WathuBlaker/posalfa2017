package br.com.munif.oo.pojo;

import java.util.Random;

/**
 * Created by Samuel on 11/06/2017.
 */
public class Monster extends Personagem {
    private String atack;
    private Integer hit;

    static Random r = new Random();

    static String[] possiveisAtaques = {"fogo", "gelo", "ar", "terra", "grito", "fugir"};
    static String[] possiveisNomes = {"Spider", "Mouse", "Bee", "Orc", "Shark"};

    public Monster(Lugar lugar) {
        super(possiveisNomes[r.nextInt(possiveisNomes.length)],
                lugar);
    }

    public String getAtack() {
        atack = possiveisAtaques[r.nextInt(possiveisAtaques.length)];
        return atack;
    }

    public Integer getHit() {
        Random ran = new Random();
        hit = ran.nextInt(3) + 2;
        return hit;
    }

    @Override
    public void chora() {
        System.out.println("Grwaaaa");
    }
}
