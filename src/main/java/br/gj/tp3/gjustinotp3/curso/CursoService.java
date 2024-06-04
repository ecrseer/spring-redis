package br.gj.tp3.gjustinotp3.curso;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @PostConstruct
    public void init() {
        this.cursoRepository.saveAll(
                List.of(new Curso("Economia"),
                        new Curso("Informatica"),
                        new Curso("Gastronomia"))
        );
    }

    public Curso salvaCurso(Curso curso) {
        return this.cursoRepository.save(curso);
    }

    @Cacheable(value = "cursos")
    public List<Curso> buscaTodosCursos() {
        return this.cursoRepository.findAll();
    }

    public Curso atualizaCurso(Curso curso) {
        Optional<Curso> cursoEncontrado = this.cursoRepository.findById(curso.getId());
        if (cursoEncontrado.isPresent()) {
            return this.cursoRepository.save(curso);
        } else {
            throw new RuntimeException("Curso nao encontrado");
        }
    }

    public Curso deletarCursoPorId(Long id) {
        Optional<Curso> encontrado = this.cursoRepository.findById(id);
        this.cursoRepository.deleteById(id);
        return encontrado.get();
    }


}
