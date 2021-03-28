package crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Aluno")
public class Aluno {

	@Id
	private int matricula;
	@Column
	private String nome;
	@Column
	private String cpf;
	
	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	
}
