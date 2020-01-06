package br.com.vipec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno extends Pessoa {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column( length = 11, nullable = false, unique = true )
    private String cpf;

    @Column( nullable = true )
    private Contato contato;

    @Column( nullable = false )
    private LocalDate dataDeNascimento;
    
    protected Aluno() {
    }

        


}
