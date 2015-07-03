package br.com.desafio.financeirovn.repository;

import java.util.Calendar;
import java.util.List;

import br.com.desafio.financeirovn.dao.LancamentoDAO;
import br.com.desafio.financeirovn.model.Conta;
import br.com.desafio.financeirovn.model.Lancamento;
import br.com.desafio.financeirovn.util.Formatar;

public class Lancamentos {

    private LancamentoDAO dao;

    public void salvar(Lancamento lancamento, Conta conta) {
	String periodo = Formatar.anoMes(lancamento.getData());

	dao = new LancamentoDAO(periodo, conta.getNome());

	dao.getDados().add(lancamento);
	dao.salvar();
    }

    public void salvarTodos(List<Lancamento> lancamentos, Conta conta) {
	for (Lancamento lancamento : lancamentos) {
	    String periodo = Formatar.anoMes(lancamento.getData());
	    dao = new LancamentoDAO(periodo, conta.getNome());
	    dao.getDados().add(lancamento);
	    dao.salvar();
	}
    }

    public List<Lancamento> buscaPorMes(Calendar mes, Conta conta) {
	String periodo = Formatar.anoMes(mes);

	dao = new LancamentoDAO(periodo, conta.getNome());
	return dao.getDados();
    }

}
