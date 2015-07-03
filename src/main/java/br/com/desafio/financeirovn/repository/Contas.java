package br.com.desafio.financeirovn.repository;

import java.util.List;

import br.com.desafio.financeirovn.dao.ContaDAO;
import br.com.desafio.financeirovn.model.Conta;

public class Contas {

    private ContaDAO dao;

    public Contas() {
	dao = new ContaDAO();
    }

    public void salvar(Conta conta) {
	dao.getDados().add(conta);
	dao.salvar();
    }

    public List<Conta> buscaTodos() {
	return dao.getDados();
    }
}
