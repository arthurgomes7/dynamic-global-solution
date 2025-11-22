package br.com.plataforma;

import br.com.plataforma.util.Upskilling;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do Curso que quer iniciar: ");
        String nomeCurso = scanner.nextLine();

        System.out.print("Certo, agora digite o nome da Área do curso: ");
        String areaCurso = scanner.nextLine();

        Upskilling upskilling = new Upskilling(nomeCurso, areaCurso);

        upskilling.informacoesCurso();

        upskilling.listarModulos();
        System.out.println();

        upskilling.adicionarAula("Introdução");
        upskilling.adicionarAula("Conceitos Básicos");
        upskilling.adicionarAula("Programação Prática");
        upskilling.adicionarAula("Projeto Final");

        System.out.println("Aulas adicionadas com sucesso!\n");

        System.out.println("Assistindo aulas");
        upskilling.assistirProximaAula();
        upskilling.assistirProximaAula();
        upskilling.assistirProximaAula();
        System.out.println();

        upskilling.voltarUltimaAulaAssistida();
        System.out.println();

        System.out.println("Histórico de aulas");
        upskilling.listarHistorico();
        System.out.println();

        System.out.println("Avaliação do curso");
        upskilling.avaliar();
        upskilling.avaliar();
        System.out.printf("Média das Notas : %.2f/10%n", upskilling.avaliacoes());
        System.out.println();

        upskilling.pularAula(3);
        upskilling.voltarAula();
    }
}
