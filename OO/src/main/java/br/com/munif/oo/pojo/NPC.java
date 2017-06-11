package br.com.munif.oo.pojo;

import java.util.Random;

public class NPC extends Personagem {

    static Random r = new Random();

    static String[] possiveisNomes = {"Allac", "Blueno", "Colle", "Dina", "Ellen"};

    private String[] talk = {
            "Olá, esta um dia frio hoje",
            "Estou perdido nesta casa...",
            "Poderiamos sair para a floresta caçar alguns monstros",
            "Estou achando que irá chover",
    };

    public NPC(Lugar lugar) {
        super(possiveisNomes[r.nextInt(possiveisNomes.length)],
                lugar);
    }

    @Override
    public void chora() {
        System.out.println("ChuaChuaCHua");
    }

    public String getTalk() {
        return talk[r.nextInt(talk.length)];
    }
}
