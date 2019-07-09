package com.fliperamaestudio.fliperamaestudio.controller;

import com.fliperamaestudio.fliperamaestudio.model.Produto;
import com.fliperamaestudio.fliperamaestudio.model.Vendidos;
import com.fliperamaestudio.fliperamaestudio.repository.ProdutoRepository;
import com.fliperamaestudio.fliperamaestudio.repository.VendidosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("controleEstoque")
public class EstoqueController {

    private final VendidosRepository vendidosRepository;
    private final ProdutoRepository produtoRepository;

    public EstoqueController(VendidosRepository vendidosRepository, ProdutoRepository produtoRepository) {
        this.vendidosRepository = vendidosRepository;
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

    @PutMapping("/atualizaEstoque")
    public String atualizaEstoque(@RequestParam int id,
                                  @RequestParam(defaultValue = "0") int venda,
                                  @RequestParam(defaultValue = "0") int entrada) {

        var retorno = produtoRepository.findById(id);

        var produto = retorno.get();

        produto.setQtd( produto.getQtd()-venda + entrada);

        var vendidos = new Vendidos(LocalDateTime.now(), produto.getNome(), venda);

        vendidosRepository.save(vendidos);

        produtoRepository.save(produto);



        return "redirect:/controleEstoque";
    }


    @DeleteMapping("/excluirItem")
    public String excluirItem(@RequestParam int id) {

        produtoRepository.deleteById(id);

        return "redirect:/controleEstoque";
    }
}
