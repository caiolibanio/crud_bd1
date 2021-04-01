package crud;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//exemploPersist();
		//exemploSelect();
		//exemploUpdate();
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
		List<Aluno> listaAlunos = AlunoDAO.getInstance().selectHql("Maria");
	}
	
	public static void exemploUpdate() {
		//Aluno aluno_bd = AlunoDAO.getInstance().getById(12);
		Aluno aluno = new Aluno();
		aluno.setMatricula(12);
		aluno.setNome("Pedro");
		Aluno aluno_atualizado = AlunoDAO.getInstance().update(aluno);
	}
	
	public static void exemploDelete() {
		AlunoDAO.getInstance().removeById(12);
	}

}
