package br.com.desafio.financeirovn.dao;

import br.com.desafio.financeirovn.model.Lancamento;
import br.com.desafio.financeirovn.util.csv.LancamentoCSVReader;
import br.com.desafio.financeirovn.util.csv.LancamentoCSVWriter;

public class LancamentoDAO extends AbstractDAO<Lancamento> {

    public LancamentoDAO(String periodo, String arquivo) {
	super(periodo, arquivo);
	configurar();
    }

    @Override
    protected void configurar() {
	dados = null;
	reader = new LancamentoCSVReader(periodo, arquivo);
	writer = new LancamentoCSVWriter(periodo, arquivo);
    }

}
