package br.com.devdan.test;

import br.com.devdan.dao.IClienteDAO;
import br.com.devdan.domain.Cliente;
import br.com.devdan.exceptions.TipoChaveNaoEncontradaException;
import br.com.devdan.services.ClienteService;
import br.com.devdan.services.IClienteService;
import br.com.devdan.test.dao.ClienteDAOMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Dan");
        cliente.setCidade("Natal");
        cliente.setEnd("End");
        cliente.setEstado("RN");
        cliente.setNumero(10);
        cliente.setTel(8499999999L);

    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Danyllo");
        clienteService.alterar(cliente);

        Assert.assertEquals("Danyllo", cliente.getNome());
    }
}
