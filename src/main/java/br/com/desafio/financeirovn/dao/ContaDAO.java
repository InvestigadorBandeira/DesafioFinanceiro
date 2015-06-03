package br.com.desafio.financeirovn.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.desafio.financeirovn.dao.xml.db.Contas;
import br.com.desafio.financeirovn.model.Conta;
import br.com.desafio.financeirovn.model.Lancamento;

public class ContaDAO extends AbstractDAO<String> {

    public ContaDAO() {
	super(new Contas(), "Contas");
    }

    @Override
    protected void setDados() {
	dados = ((Contas) dao.instance()).getContas();
    }

    // refatorar
    public Conta filtrarPorData(Conta conta, Calendar dataInicial,
	    Calendar dataFinal) {

	Conta auxiliar = new Conta();
	auxiliar.setNome(conta.getNome());

	List<Lancamento> lancamentos = new ArrayList<>();

	for (Lancamento lancamento : conta.getLancamentos()) {
	    Calendar data = lancamento.getData();

	    if (data.equals(dataInicial) || data.equals(dataFinal)
		    || (data.after(dataInicial) && data.before(dataFinal)))
		lancamentos.add(lancamento);
	}

	auxiliar.setLancamentos(lancamentos);

	return auxiliar;
    }
}
