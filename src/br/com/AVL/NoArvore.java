package br.com.AVL;

public class NoArvore {
    private NoArvore esquerda;
    private NoArvore direita;
    private NoArvore pai;
    private String name;
    private int balance;

    @Override
    public String toString() {
        return "NoArvore{" +
                "name = '" + name + '\'' +
                '}';
    }

    public NoArvore getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvore esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvore getDireita() {
        return direita;
    }

    public void setDireita(NoArvore direita) {
        this.direita = direita;
    }

    public NoArvore getPai() {
        return pai;
    }

    public void setPai(NoArvore pai) {
        this.pai = pai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public NoArvore (String name){
        setEsquerda(null);
        setDireita(null);
        setPai(null);
        setName(name);
        setBalance(0);
    }
}
