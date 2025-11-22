package br.com.plataforma.util;

import br.com.plataforma.model.Cursos;

public class Upskilling extends Cursos {
    public Upskilling(String nome, String area) {
        super(nome, area);
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
