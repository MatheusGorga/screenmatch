package br.com.alura.screenmatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.alura.screenmatch.domain.filme.Filme;
import br.com.alura.screenmatch.domain.filme.FilmeRepository;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;
    

    @GetMapping
    public String carregaPaginaListagem(Model model){
       model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";
    }


    @GetMapping("/formulario")
    public String carregaPaginaFormulario(){
        return "filmes/formulario";
    }


    @PostMapping
    public String cadastraFilme(DadosCadastroFilme dados ){

        var filme = new Filme(dados);
        repository.save(filme);

        return "redirect:/filmes";
        
    }
}
