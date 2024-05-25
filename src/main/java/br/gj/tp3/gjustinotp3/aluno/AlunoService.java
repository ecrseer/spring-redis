package br.gj.tp3.gjustinotp3.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvaAluno(Aluno al) {
        return this.alunoRepository.save(al);

    }

}
