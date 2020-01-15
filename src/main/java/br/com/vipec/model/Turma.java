package br.com.vipec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Turma
 */
@Entity
public class Turma {

    @Id
    @Column(length = 4, nullable = false)
    private String codigo;

    public Turma() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}