package br.com.vipec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Pessoa
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column( length = 100, nullable = false)
    private String nomeCompleto;

    // @Column( length = 11, nullable = false, unique = true )
    // private String cpf;

    @Column( nullable = false )
    private String rg;

    // @Column( nullable = true )
    // private LocalDate dataDeNascimento;

    // @Column( nullable = true )
    // private Endereco endereco;

    // @Column( nullable = true )
    // private Contato telefone;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nome) {
        this.nomeCompleto = nome;
    }

    // public String getCpf() {
    //     return cpf;
    // }

    // public void setCpf(String cpf) {
    //     this.cpf = cpf;
    // }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    // public LocalDate getDataDeNascimento() {
    //     return dataDeNascimento;
    // }

    // public void setDataDeNascimento(LocalDate dataDeNascimento) {
    //     this.dataDeNascimento = dataDeNascimento;
    // }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    // public Endereco getEndereco() {
    //     return endereco;
    // }

    // public void setEndereco(Endereco endereco) {
    //     this.endereco = endereco;
    // }

    // public Contato getTelefone() {
    //     return telefone;
    // }

    // public void setTelefone(Contato telefone) {
    //     this.telefone = telefone;
    // }

    
}