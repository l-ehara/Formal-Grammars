import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Testes t = new Testes();
    boolean sair = false;
    Scanner in = new Scanner(System.in);
    String terminal;

    List<String> nTerminais =  new ArrayList<>();
    List<String> Terminais =  new ArrayList<>();

    public void menu(){
        do {
            System.out.println("---MENU---");
            System.out.println("1 - Inserir simbolos não terminais (MAX 2) ");
            System.out.println("2 - Inserir simbolos não terminais (MAX 2) ");
            System.out.println("3 - Retornar o formalismo que representa a gramática");
            System.out.println("4 - A gramática é válida? Se sim, que tipo ela é?");
            System.out.println("5 - Produções");
            System.out.println("6 - IFOS do projeto");
            System.out.println("7 - Sair do programa");
            String op = in.nextLine();

            switch (op) {

                case "1":
                    System.out.println("Insira um símbolo não terminal: ");
                    String simbN = in.nextLine();
                    if (nTerminais.contains(simbN.toUpperCase())) {
                        System.err.println("ERRO: \n ---- Símbolo ja existente, tente outro ---- \n");
                        break;
                    } else if (nTerminais.size() == 2 || nTerminais.size() > 2) {
                        System.err.println("ERRO: \n ---- TAMANHO MÁXIMO ATINGIDO ----");
                        break;
                    } else nTerminais.add(simbN.toUpperCase());

                            break;

                case "2":
                    System.out.println("Insira um símbolo terminal: ");
                    String simbT = in.nextLine();
                    if(Terminais.contains(simbT.toLowerCase())) {
                        System.err.println(" ---- Símbolo ja existente, tente outro ---- \n");
                        break;
                    } else if (Terminais.size() == 2 || Terminais.size() > 2){
                        System.err.println("ERRO: \n ---- TAMANHO MÁXIMO ATINGIDO ----");
                    }
                        else Terminais.add(simbT.toLowerCase());
                    break;

                case "3":
                    if(nTerminais.isEmpty()) {
                        System.err.println("ERRO: \n ---- Ainda não foram inseridos símbolos não terminais ---- ");
                    } else if (Terminais.isEmpty()){
                        System.err.println("ERRO: \n ---- Ainda não foram inseridos símbolos terminais ---- ");
                    } else System.out.println("G = ("+ nTerminais.toString() + " , " + Terminais.toString() + ", P, S)");
                    break;

                case "4":
                    break;

                case "5":
                    if(nTerminais.isEmpty()) {
                        System.err.println("ERRO: \n ---- Ainda não foram inseridos símbolos não terminais ---- ");
                    } else if (Terminais.isEmpty()) {
                        System.err.println("ERRO: \n ---- Ainda não foram inseridos símbolos terminais ---- ");
                    } else if(Terminais.size() == 1 && nTerminais.size() == 1)
                    System.out.println("P: \n{S->" + Terminais.get(0) + nTerminais.get(0) + "|" + Terminais.get(0) + "\n" +
                           nTerminais.get(0) + "->" + Terminais.get(0) + "S" + "}");
                    System.out.println("Sentenças possíveis: \n " + Terminais.get(0) + "\n" + Terminais.get(0)+Terminais.get(0) + "\n" + Terminais.get(0)+Terminais.get(0)+Terminais.get(0) );
                    break;

                case"6":
                    System.out.println(" \n O símbolo que engloba o conjunto de produções será por padrão 'P'\n O símbolo de início de produções será por padrão 'S' \n Definimos uma quandidade máxima de símbolos não terminais e terminais. ");
                    break;
                case "7":
                    System.out.println("Obrigado por utilizar o sistema!");
                    sair = true;

            }
        } while (sair == false);
    }

}


