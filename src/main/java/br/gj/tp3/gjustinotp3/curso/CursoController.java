package br.gj.tp3.gjustinotp3.curso;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curso")
public class CursoController {


    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }


    @PostMapping("/criar")
    public Curso salvar(@RequestBody Curso curso){
                return this.cursoService.salvaCurso(curso);
    }

    @GetMapping("buscar-todos")
    public List<Curso> buscarTodos(){
        return this.cursoService.buscaTodosCursos();
    }
}
