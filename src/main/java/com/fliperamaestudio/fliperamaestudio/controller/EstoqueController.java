package com.fliperamaestudio.fliperamaestudio.controller;

import com.fliperamaestudio.fliperamaestudio.model.Produto;
import com.fliperamaestudio.fliperamaestudio.repository.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("controleEstoque")
public class EstoqueController {

    private final ProdutoRepository produtoRepository;

    public EstoqueController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public String retornEstoque(Model model) {

        var estoque = produtoRepository.findAll();
        model.addAttribute("estoque", estoque);


        return "controleEstoque";
    }

    @GetMapping("/cadastroProduto")
    public String returnCadastroProduto() {
        return "cadastroProduto";
    }

    @PostMapping("/cadastroProduto")
    public String cadastrarProduto(@RequestParam String nome,
                                   @RequestParam double preco,
                                   @RequestParam int qtd) {

        var produto = new Produto(nome, preco, qtd);
        produtoRepository.save(produto);


        return "redirect:/controleEstoque";

    }

    @PostMapping("/atualizaEstoque")
    public String atualizaEstoque(@RequestParam int id,
                                  @RequestParam int qtd){

        var retorno = produtoRepository.findById(id);

        var produto = retorno.get();

        produto.setQtd(qtd);

        produtoRepository.deleteById(id);

        produtoRepository.save(produto);




        return "redirect:/controleEstoque";
    }


    @PostMapping("/excluirItem")
    public String excluirItem(@RequestParam int id){

        produtoRepository.deleteById(id);

        return "redirect:/controleEstoque";
    }
}
