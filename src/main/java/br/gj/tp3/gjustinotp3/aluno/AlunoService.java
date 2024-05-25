package br.gj.tp3.gjustinotp3.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvaAluno(Aluno al) {
        return this.alunoRepository.save(al);
    }

    @Cacheable(value = "alunos")
    public List<Aluno> retornaTodosAlunos(){
        return this.alunoRepository.findAll();
    }

}
