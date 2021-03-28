package crud;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		exemploPersist();
		exemploSelect();
		exemploUpdate();
		exemploDelete();
	}
	
	public static void exemploPersist() {
		Aluno aluno = new Aluno();
		aluno.setCpf("123456");
		aluno.setMatricula(12);
		aluno.setNome("Maria");
		AlunoDAO.getInstance().persist(aluno);
	}
	
	public static void exemploSelect() {
		Aluno cliente_bd = AlunoDAO.getInstance().getById(12);
	}
	
	public static void exemploUpdate() {
		Aluno cliente_bd = AlunoDAO.getInstance().getById(12);
		cliente_bd.setNome("Joao");
		Aluno cliente_atualizado = AlunoDAO.getInstance().update(cliente_bd);
	}
	
	public static void exemploDelete() {
		Aluno cliente_bd = AlunoDAO.getInstance().getById(12);
		AlunoDAO.getInstance().remove(cliente_bd);
	}

}
