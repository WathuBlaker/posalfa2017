package br.com.munif.oo.pojo;

import br.com.munif.oo.Descritivel;

public abstract class Personagem implements Descritivel {

    protected String nome;

    private Lugar lugar;

    private Integer hp;

    public abstract void chora();

    public Personagem(String nome, Lugar lugar) {
        this.nome = nome;
        this.lugar = lugar;
        lugar.getPersonagens().add(this);
    }

    public String getNome() {
        return nome;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        if (this.lugar != null) {
            this.lugar.getPersonagens().remove(this);
        }
        this.lugar = lugar;
        this.lugar.getPersonagens().add(this);
    }

    @Override
    public String descreve() {
        return "Personagem com nome " + nome + " em " + lugar.getDescricao();
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    

}
