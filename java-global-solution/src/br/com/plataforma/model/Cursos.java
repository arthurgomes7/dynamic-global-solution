package br.com.plataforma.model;

import java.util.*;

public abstract class Cursos {
    private String nome;
    private String area;
    private double notaCurso;
    private LinkedList<Double> avaliacoes = new LinkedList<>();
    private Queue<String> filaAulas = new ArrayDeque<>();
    private Deque<String> historicoAulas = new ArrayDeque<>();
    private String[] modulos = {"Introdução", "Conteúdo Básico", "Avançado", "Projeto Final"};


    /**
     * Método construtor padrão para a inserção de dados obrigatórios
     * @param nome
     * @param area
     */
    public Cursos(String nome, String area) {
        this.nome = nome;
        this.area = area;
    }

    /**
     * Método imprime uma mensagem informando todos os dados do curso em questao, caso ainda nao haja avaliação o mesmo
     * retorna sem a linha de "Avaliações"
     */
    public void informacoesCurso(){
        if (!avaliacoes.isEmpty()){
            System.out.printf("""
                \nNome do curso: %s
                Área do curso: %s
                Avaliação do curso: %.2f%n%n""",
                    this.nome, this.area, this.avaliacoes());
            return;
        }
        System.out.printf("""
                \nNome do curso: %s
                Área do curso: %s%n%n""",
                this.nome, this.area);
    }

    /**
     * Método imprime uma mensagem informando o avanço de 1 aula
     */
    public void pularAula(){
        System.out.printf("Aula do Curso: %s, pulada!\n", this.nome);
    }

    /**
     * Método imprime uma mensagem informando o avanço de 2 ou mais aulas
     * @param quantidadeAulas
     */
    public void pularAula(int quantidadeAulas){
        System.out.printf("%d Aulas do Curso: %s puladas!\n", quantidadeAulas, this.nome);
    }

    /**
     * Método imprime uma mensagem informando o retorno de 1 aula
     */
    public void voltarAula(){
        System.out.printf("Você voltou uma aula do curso: %s%n", this.nome);
    }

    /**
     * Método imprime uma mensagem informando o retorno de 2 ou mais aulas
     * @param quantidadeAulas
     */
    public void voltarAula(int quantidadeAulas){
        System.out.printf("Você voltou %d aulas do curso: %s%n", quantidadeAulas, this.nome);
    }

    /**
     * Método para o usuario avaliar o curso em questao, a nota é inserida em um array que armazena todas avaliações
     */
    public void avaliar() {
        var scanner = new Scanner(System.in);
        System.out.print("Avalie o curso: ");
        double avaliacao = scanner.nextDouble();
        if (avaliacao >= 0 && avaliacao <= 10){
            avaliacoes.add(avaliacao);
            return;
        }
        System.out.println("Avaliação inválida, tente novamente");
    }

    /**
     * Método retorna a soma das avalicoes do Array avaliacoes e divide pelo tamanho do mesmo, dessa forma rentorna a média
     * @return
     */
    public double avaliacoes() {
        if (avaliacoes.isEmpty()){
            return 0;
        }
        double notaFinal = 0;
        for (Double avaliacao : avaliacoes) {
            notaFinal += avaliacao;
        }
        return notaFinal / avaliacoes.size();
    }

    /**
     * Método para a consulta do nome da Curso, que por motivos de encapsulamento se encontra como "Private"
     * @return
     */
    public String getNome() {
        return nome;
    }

    public void listarModulos() {
        System.out.println("Módulos do curso:");
        for (String m : modulos) {
            System.out.println("- " + m);
        }
    }

    public void adicionarAula(String aula) {
        filaAulas.add(aula);
    }

    public void assistirProximaAula() {
        String aula = filaAulas.poll();
        if (aula == null) {
            System.out.println("Nenhuma aula pendente!");
        } else {
            System.out.println("Assistindo aula: " + aula);
            historicoAulas.push(aula);
        }
    }

    public void voltarUltimaAulaAssistida() {
        if (historicoAulas.isEmpty()) {
            System.out.println("Nenhuma aula assistida para voltar.");
            return;
        }

        String aula = historicoAulas.pop();
        System.out.println("Voltando para a aula: " + aula);
        filaAulas.add(aula);
    }

    public void listarHistorico() {
        System.out.println("Histórico de aulas assistidas:");
        for (String aula : historicoAulas) {
            System.out.println("- " + aula);
        }
    }
}
