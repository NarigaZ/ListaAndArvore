package br.com.Lista;

public class NoLista {
    String name;
    NoLista proximoNo;

    NoLista(String name) {
        this(name, null);
    }// Fim do construtor de um argumento ListaNo

    // construtor cria ListaNo que referencia

    // Object e o próximo ListaNo
    NoLista(String name, NoLista node) {
        this.name = name;
        proximoNo = node;
    }// fim do construtor de dois argumentos ListaNo

    //seta um objeto data
    public void setName(String name) {
        this.name = name;
    }

    // retorna referência aos dados no nó
    String getName() {
        return name; // retorna Object nesse nó
    }// fim do método getObject
    // retorna referência ao próximo nó na lista

    NoLista getProximoNo() {
        return proximoNo; // obtém próximo nó
    }// fim do método getNext

    public void setProximoNo(NoLista novo) {
        // TODO Auto-generated method stub
        this.proximoNo = novo;
    }
}// fim da classe ListaNo

