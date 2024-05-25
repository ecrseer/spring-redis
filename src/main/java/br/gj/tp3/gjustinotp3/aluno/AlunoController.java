package br.gj.tp3.gjustinotp3.aluno;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    AlunoService alunoService;

    public AlunoController(AlunoService service) {
        this.alunoService = service;
    }

    @GetMapping("/td")
    public String teste() {
        Aluno teste = new Aluno("Olares",12);
        Aluno salvo = this.alunoService.salvaAluno(teste);
        return "ola alno"+salvo.getNome();
    }
}
