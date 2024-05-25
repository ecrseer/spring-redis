package br.gj.tp3.gjustinotp3.aluno;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    AlunoService alunoService;

    public AlunoController(AlunoService service) {
        this.alunoService = service;
    }

    @GetMapping("/todos")
    public List<Aluno> mostraTodos() {
        return this.alunoService.retornaTodosAlunos();
    }

    @PostMapping("/cadastra")
    public Aluno cadastra(@RequestBody Aluno al){
        return this.alunoService.salvaAluno(al);
    }
}
