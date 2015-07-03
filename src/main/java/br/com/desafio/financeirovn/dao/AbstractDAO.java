package br.com.desafio.financeirovn.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.desafio.financeirovn.exception.FinanceiroException;
import br.com.desafio.financeirovn.util.csv.CSVReader;
import br.com.desafio.financeirovn.util.csv.CSVWriter;

public abstract class AbstractDAO<T> implements DAO<T> {

    protected CSVReader<T> reader;
    protected CSVWriter<T> writer;
    protected String periodo;
    protected String arquivo;
    protected List<T> dados;

    public AbstractDAO(String periodo, String arquivo) {
	this.periodo = periodo;
	this.arquivo = arquivo;
    }

    @Override
    public List<T> getDados() {
	if (dados == null)
	    try {
		dados = reader.getDados();
	    } catch (FinanceiroException e) {
		dados = new ArrayList<>();
	    }

	return dados;
    }

    @Override
    public void salvar() {
	try {
	    writer.salvarDados(dados);
	    configurar();
	} catch (FinanceiroException e) {
	    e.printStackTrace();
	}
    }

    protected abstract void configurar();

}
