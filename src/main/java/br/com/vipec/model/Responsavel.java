package br.com.vipec.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nomeCompleto;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @OneToMany(mappedBy = "responsavel")
    private Set<Aluno> alunos = new HashSet<>();

    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(columnDefinition = "integer", name = "contato_id")
    private Contato contato;

    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(columnDefinition = "integer", name = "endereco_id")
    private Endereco endereco;

    @Column(nullable = true)
    private LocalDate dataDeNascimento;

    protected Responsavel() {
    }

    public Responsavel(String nomeCompleto, String cpf, String rg, Set<Aluno> alunos, Contato contato,
            Endereco endereco, LocalDate dataDeNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.rg = rg;
        this.alunos = alunos;
        this.contato = contato;
        this.endereco = endereco;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

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
        Responsavel other = (Responsavel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
