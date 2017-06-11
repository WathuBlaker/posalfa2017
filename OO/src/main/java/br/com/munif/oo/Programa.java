package br.com.munif.oo;

import br.com.munif.oo.pojo.*;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Programa {

    static Mapa mapa = Mapa.getInstancia();
    static Personagem jogador = new Jogador("Maria", mapa.getLugarInicialJogador());
    static NPC npc;
    static Monster monster;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String... args) {

        System.out.println("----> " + Descritivel.NOME_JOGO + " <----");
        jogador.setHp(20);

        while (true) {


            Lugar lc = jogador.getLugar();
            System.out.println(jogador.getNome() + "!");
            npc = new NPC(mapa.getLugarInicialNPC());
            monster = new Monster(mapa.getLugarInicialMonstro());


            System.out.println("Voce está no(a):" +
                    lc.getDescricao() + " com " + npc.getNome() + "\n " +
                    "e " + monster.getNome() + " Apareceu...");

            System.out.println("Mensagens:" + lc.getMensagens());


            if (lc.getLeste() != null) {
                System.out.println("1) Para leste " + lc.getLeste().getDescricao());
            }
            if (lc.getOeste() != null) {
                System.out.println("2) Para Oeste " + lc.getOeste().getDescricao());
            }
            if (lc.getNorte() != null) {
                System.out.println("3) Para Norte " + lc.getNorte().getDescricao());
            }
            if (lc.getSul() != null) {
                System.out.println("4) Para Sul " + lc.getSul().getDescricao());
            }


            System.out.println("5) Escrever");
            System.out.println("6) Conversar com " + npc.getNome());
            System.out.println("7) Confrontar " + monster.getNome());

            int opcao = scanner.nextInt();
            if (opcao == 1 && lc.getLeste() != null) {
                jogador.setLugar(lc.getLeste());
            } else if (opcao == 2 && lc.getOeste() != null) {
                jogador.setLugar(lc.getOeste());
            } else if (opcao == 3 && lc.getNorte() != null) {
                jogador.setLugar(lc.getNorte());
            } else if (opcao == 4 && lc.getSul() != null) {
                jogador.setLugar(lc.getSul());
            } else if (opcao == 5) {
                System.out.println("Digite a mensagem:");
                String mensagem = scanner.next();
                lc.getMensagens().add(mensagem);

            } else if (opcao == 6) {
                System.out.println("---------------------------");
                System.out.println(npc.getTalk());
                System.out.println("---------------------------");
            } else if (opcao == 7) {

                monster.setHp(random.nextInt(8) + 7);

                while (!confronto()) {
                }
                System.out.println("----------------------------------");
                if (jogador.getHp() <= 0) {

                }
            } else {
                System.out.println("Opcao inválida");
            }
        }
    }

    public static Boolean confronto() {

        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");

        while (monster.getHp() > 0) {
            if (jogador.getHp() <= 0) {
                System.err.println(jogador.getNome() + " Morreu...");
                int opcao = scanner.nextInt();

                System.err.println("GAME OVER");
                try {
                    Thread.sleep(1000);
                    System.exit(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("------------------------------------------");
            String jog = "";
            String mon = "";

            for (int i = 0; i < jogador.getHp(); i++) {
                jog += "-";
            }

            System.out.println(jogador.getNome() + " HP: " + jogador.getHp() + jog);
            for (int i = 0; i < monster.getHp(); i++) {
                mon += "-";
            }

            System.out.println(monster.getNome() + " HP: " + monster.getHp() + mon);
            System.out.println("1) Atacar");
            System.out.println("2) Fugir");


            try {
                int opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Atacou");
                        monster.setHp(monster.getHp() - (random.nextInt(1) + 6));
                        Thread.sleep(1000);
                        System.err.println("Monstro atacou - " + monster.getAtack());
                        jogador.setHp(jogador.getHp() - (random.nextInt(2) + 10));
                        Thread.sleep(1000);
                        break;
                    case 2:
                        System.err.println("Monstro atacou - " + monster.getAtack());
                        jogador.setHp(jogador.getHp() + (random.nextInt(2) + 10));
                        Thread.sleep(1000);
                        System.out.println("jogador fugiu...");
                        Thread.sleep(1000);
                        return true;
                    default:
                        System.out.println("Monstro atacou - " + monster.getAtack());
                        jogador.setHp(jogador.getHp() + (random.nextInt(2) + 10));
                        Thread.sleep(1000);
                        System.out.println("Ataque inválido");
                        Thread.sleep(1000);
                        break;
                }
            } catch (Exception e) {

            }
            System.out.println("----------------------------------");
            if (monster.getHp() <= 0) {
                int win = (random.nextInt(1) + 30);
                System.out.println("Monstro derrotado. + " + win + " de HP");
                jogador.setHp(jogador.getHp() + win);
                return true;
            }


            return false;
        }

        return false;
    }

    public static void mostraDescricao(Descritivel des) {
        JOptionPane.showConfirmDialog(null, des.descreve());
    }
}
