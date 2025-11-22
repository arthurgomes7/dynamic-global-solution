package br.com.plataforma.util;

import br.com.plataforma.model.Cursos;

public class CursoPadrao extends Cursos {
    private String mercadoArea;

    public CursoPadrao(String nome, String area, String mercadoArea) {
        super(nome, area);
        System.out.println("Mercado do curso: " + mercadoArea);
    }

    @Override
    public void informacoesCurso() {
        super.informacoesCurso();
    }

    @Override
    public void avaliar() {
        super.avaliar();
        System.out.printf("O curso %s, agradece seu feedback\n\n", this.getNome());
    }

    @Override
    public double avaliacoes() {
        return super.avaliacoes();
    }

    @Override
    public void pularAula() {
        super.pularAula();
    }



    @Override
    public void voltarAula() {
        super.voltarAula();
    }
}
