package br.com.devdan.services;

import br.com.devdan.dao.IProdutoDAO;
import br.com.devdan.domain.Produto;
import br.com.devdan.services.generics.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}
