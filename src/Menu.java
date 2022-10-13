import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    boolean sair = false;

    boolean vazia = false;
    Scanner in = new Scanner(System.in);

    List<String> nTerminais =  new ArrayList<>();
    List<String> Terminais =  new ArrayList<>();

    public void menu(){
        do {
            System.out.println("---MENU---");
            System.out.println("1 - Inserir simbolos não terminais (LETRAS) (MAX 2) ");
            System.out.println("2 - Inserir simbolos terminais (LETRAS) (MAX 2) ");
            System.out.println("3 - Retornar o formalismo que representa a gramática");
            System.out.println("4 - Definir se a gramática aceita sentença vazia (Não aceita por padrão)");
            System.out.println("5 - Produções");
            System.out.println("6 - INFOS do projeto");
            System.out.println("7 - Sair do programa");
            String op = in.nextLine();

            switch (op) {

                case "1":
                    System.out.println("Insira um símbolo não terminal: ");
                    String simbN = in.nextLine().toUpperCase();
                    if (nTerminais.contains(simbN.toUpperCase())) {
                        System.err.println("ERRO: \n ---- Símbolo ja existente, tente outro ---- \n");
                        break;
                    } else if (simbN.length() != 1) {
                        System.err.println("---- Símbolos devem respeitar o tamanho de 1 caracter ---- ");
                    } else if (nTerminais.size() == 2 || nTerminais.size() > 2) {
                        System.err.println("ERRO: \n ---- TAMANHO MÁXIMO ATINGIDO ----");
                        break;
                    } else if (!simbN.matches("[a-zA-Z]+")) {
                        System.err.println("---- O símbolo deve ser uma letra ----");
                        break;
                    } else nTerminais.add(simbN);

                    break;

                case "2":
                    System.out.println("Insira um símbolo terminal: ");
                    String simbT = in.nextLine().toLowerCase();
                    if (Terminais.contains(simbT.toLowerCase())) {
                        System.err.println(" ---- Símbolo ja existente, tente outro ---- \n");
                        break;
                    } else if (Terminais.size() == 2 || Terminais.size() > 2) {
                        System.err.println("ERRO: \n ---- TAMANHO MÁXIMO ATINGIDO ----");
                    } else if (!simbT.matches("[a-zA-Z]+")) {
                        System.err.println("---- O símbolo deve ser uma letra ----");
                        break;
                    } else if (simbT.length() != 1) {
                        System.err.println("---- Símbolos devem respeitar o tamanho de 1 caracter ---- ");
                    } else Terminais.add(simbT);
                    break;

                case "3":
                    if (nTerminais.isEmpty() || Terminais.isEmpty()) {
                        System.err.println("ERRO: \n ---- Ainda não foram inseridos símbolos suficientes ---- ");
                    } else if (vazia == false) {
                        System.out.println("G = (" + nTerminais.toString() + ", " + Terminais.toString() + ", P, S)");
                    } else if (vazia == true) {
                        System.out.println("G = (" + nTerminais.toString() + ", " + Terminais.toString() + ", ε, P, S)");

                    }
                    break;

                case "4":
                    System.out.println("Digite 1 se a gramática aceita sentança vazia \n" +
                            "Digite 2 se a gramática não aceita sentença vazia");
                    if (in.nextLine().equals("1")){
                        vazia = true;
                    }
                    break;

                case "5":
                    if (nTerminais.isEmpty()) {
                        System.err.println("ERRO: \n ---- Ainda não foram inseridos símbolos não terminais ---- ");
                    } else if (Terminais.isEmpty()) {
                        System.err.println("ERRO: \n ---- Ainda não foram inseridos símbolos terminais ---- ");
                    } else if (nTerminais.size() > Terminais.size()) {
                        System.err.println("ERRO: \n ---- Existem mais símbolos não terminais que terminais ---- ");

                    } else if (Terminais.size() == 1 && nTerminais.size() == 1 && vazia) {
                        System.out.println("P: \n{S->" + "ε" + "|" + Terminais.get(0) + nTerminais.get(0) + "|" + Terminais.get(0) + "\n" +
                                nTerminais.get(0) + "->" + Terminais.get(0) + "S" + "}");
                        System.out.println("Exemplos de sentenças possíveis:\n ε \n " + "S -> " + Terminais.get(0) + nTerminais.get(0) + "->" + Terminais.get(0) + Terminais.get(0) + "S" + "->" + Terminais.get(0) + Terminais.get(0) + Terminais.get(0));
                        System.out.println("É uma gramática regular");

                    }else if (Terminais.size() == 1 && nTerminais.size() == 1 && !vazia) {
                        System.out.println("P: \n{S->" + Terminais.get(0) + nTerminais.get(0) + "|" + Terminais.get(0) + "\n" +
                                nTerminais.get(0) + "->" + Terminais.get(0) + "S" + "}");
                        System.out.println("Exemplos de sentenças possíveis:\n" + "S -> " + Terminais.get(0) + nTerminais.get(0) + "->" + Terminais.get(0) + Terminais.get(0) + "S" + "->" + Terminais.get(0) + Terminais.get(0) + Terminais.get(0) + "\n" +
                                "S -> " + Terminais.get(0));
                        System.out.println("É uma gramática livre de contexto");

                    } else if (Terminais.size() == 2 && nTerminais.size() == 1 && vazia) {
                        System.out.println("P: \n{S->" + "ε" + "|" + Terminais.get(0) + "|" + Terminais.get(1) + "|" + Terminais.get(1) + nTerminais.get(0) + "|" + Terminais.get(0) + nTerminais.get(0) + "\n" +
                                nTerminais.get(0) + "->" + Terminais.get(0) + "|" +Terminais.get(1) + "S" + "|" + Terminais.get(1) + "|" + Terminais.get(0) + "S" + "}");
                        System.out.println("Exemplos de sentenças possíveis:\n" + "ε\n" + "S ->" + Terminais.get(0) +nTerminais.get(0) + "->" + Terminais.get(0) + Terminais.get(0) + "S" + "->" + Terminais.get(0) + Terminais.get(0) + Terminais.get(1) + nTerminais.get(0) +
                                "->" + Terminais.get(0) + Terminais.get(0) + Terminais.get(1) + Terminais.get(0));
                        System.out.println("É uma gramática regular");

                    } else if (Terminais.size() == 2 && nTerminais.size() == 1 && !vazia) {
                        System.out.println("P: \n{S->" + Terminais.get(0) + "|" + Terminais.get(1) + "|" + Terminais.get(1) + nTerminais.get(0) + "|" + Terminais.get(0) + nTerminais.get(0) + "\n" +
                                nTerminais.get(0) + "->" + Terminais.get(0) + "|" +Terminais.get(1) + "S" + "|" + Terminais.get(1) + "|" + Terminais.get(0) + "S" + "}");
                        System.out.println("Exemplos de sentenças possíveis:\n" + "S ->" + Terminais.get(0) +nTerminais.get(0) + "->" + Terminais.get(0) + Terminais.get(0) + "S" + "->" + Terminais.get(0) + Terminais.get(0) + Terminais.get(1) + "\n" +
                                "S->" + Terminais.get(1) + nTerminais.get(0) + "->" + Terminais.get(1) + Terminais.get(0));
                        System.out.println("É uma gramática livre de contexto");


                    }else if (Terminais.size() == 2 && nTerminais.size() == 2 && vazia) {

                        System.out.println("P: \n{S->" + "ε" + "|" + Terminais.get(0) + nTerminais.get(0) + "|" + Terminais.get(1) + nTerminais.get(1) +  "\n" + nTerminais.get(0) + "->" + Terminais.get(1) +
                                "S" +"|" + Terminais.get(1) + nTerminais.get(0)  + "|" + Terminais.get(1) + "\n" + nTerminais.get(1) + "->" + Terminais.get(0) + "S" + "|" + Terminais.get(1) +
                                "|" + Terminais.get(0) + "}");
                        System.out.println("Exemplos de sentenças possíveis:\n" + "ε" + "\n" + "S->" + Terminais.get(1) + nTerminais.get(1) + "->" + Terminais.get(1) + Terminais.get(0) + "S" + "->" + Terminais.get(1) + Terminais.get(0) + Terminais.get(1) + nTerminais.get(1) +
                                "->" + Terminais.get(1) + Terminais.get(0) + Terminais.get(1) + Terminais.get(1));
                        System.out.println("É uma gramática regular");

                    }else if (Terminais.size() == 2 && nTerminais.size() == 2 && !vazia) {

                        System.out.println("P: \n{S->" + "|" + Terminais.get(0) + nTerminais.get(0) + "|" + Terminais.get(1) + nTerminais.get(1) +  "\n" + nTerminais.get(0) + "->" + Terminais.get(1) +
                                "S" +"|" + Terminais.get(1) + nTerminais.get(0)  + "|" + Terminais.get(1) + "\n" + nTerminais.get(1) + "->" + Terminais.get(0) + "S" + "|" + Terminais.get(1) +
                                "|" + Terminais.get(0) + "}");
                        System.out.println("Exemplos de sentenças possíveis:\n" + "S->" + Terminais.get(0) + nTerminais.get(0) + "->" + Terminais.get(0) + Terminais.get(1) + "S" + "->" + Terminais.get(0) + Terminais.get(1) + Terminais.get(1) + nTerminais.get(1) +
                                "->" + Terminais.get(0) + Terminais.get(1) + Terminais.get(1) + Terminais.get(0) + "\n" +
                                "S ->" + Terminais.get(1) + nTerminais.get(1) + "->" + Terminais.get(1) + Terminais.get(0));
                        System.out.println("É uma gramática livre de contexto");

                    } break;



                case"6":
                    System.out.println(" \n O símbolo que engloba o conjunto de produções será por padrão 'P'\n O símbolo de início de produções será por padrão 'S' \n Definimos uma quandidade máxima de símbolos não terminais e terminais. ");
                    break;

                case "7":
                    System.out.println("Obrigado por utilizar o sistema!");
                    sair = true;
                    break;


                default:
                    System.err.println("ERRO: \n ---- Opcao inválida! Redigite. ----");
            }
        } while (!sair);
    }

}


