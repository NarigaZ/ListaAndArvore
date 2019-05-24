package br.com.Lista.FileManager;

import java.io.*;

public class FileManager {

    static FileReader arq;
    static BufferedReader lerArq;
    static FileWriter arqs;
    static PrintWriter gravarArq;

    public static void OpenArq(String nome) {
        try {
            arq = new FileReader(nome);
            lerArq = new BufferedReader(arq);
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }

    public static String Llinha() {
        try {
            return lerArq.readLine();
        } catch (IOException e) {
        }
        return null;
    }

    public static void ArqClose() {
        try {
            arq.close();
        } catch (IOException e) {
        }
    }

    public static void GravArq(String nome) {
        try {
            String name = ".\\Files\\" + nome + ".txt";
            arqs = new FileWriter(name);
            gravarArq = new PrintWriter(arqs);
        } catch (IOException e) {
        }
    }

    public static void ArqsClose(String[] vetorOrdenado, int tamanho) {
        try {
            for (int j = 0; j < tamanho; j++) {
                gravarArq.println(vetorOrdenado[j] + "[" + vetorOrdenado[j].length() + "]");
            }
            arqs.close();
            System.out.println("Arquivo Gravado com Sucesso!");
        } catch (IOException e) {
        }
    }


}
