package poo2.exemplo.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.mvc.model.Aluno;

@Repository
@Transactional
public class AlunoDao extends EntityDao<Aluno>{

	@SuppressWarnings("unchecked")
	public Aluno getByCpf(String cpf) {
		List<Aluno> alunos = super.getSession().createQuery("from Aluno a "
				+ "left join fetch a.matricula mt "
				+ "left join fetch mt.disciplinas disc "
				+ "where a.cpf = :cpf")
				.setParameter("cpf", cpf).list();
		if(alunos.size() == 1)
			return alunos.get(0);
		else
			return null;
	}

       /* @SuppressWarnings("unchecked")
        public Aluno getByNome (String nome){
                    List<Aluno> alunos = super.getSession().createQuery("from Aluno a "
				+ "left join fetch a.matricula mt "
				+ "left join fetch mt.disciplinas disc "
				+ "where a.aluno = :aluno")
				.setParameter("aluno", nome).list();
		if(alunos.size() == 1)
			return alunos.get(0);
		else
			return null;
    }*/

    /**
     *
     * @param nomeAluno
     * @return
     */


        @SuppressWarnings("unchecked")
	public Aluno getByNOME(String nomeAluno) {
		List<Aluno> alunos = super.getSession().createQuery("from Aluno a "
				+ "where a.aluno = :aluno")
				.setParameter("aluno", nomeAluno).list();
		if(alunos.size() == 1)
			return alunos.get(0);
		else
			return null;
	}
 }