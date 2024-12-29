package br.com.devdan.dao;

import br.com.devdan.dao.generics.IGenericDAO;
import br.com.devdan.domain.Venda;
import br.com.devdan.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
