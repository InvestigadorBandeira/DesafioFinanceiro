package br.com.desafio.financeirovn.dao;

import br.com.desafio.financeirovn.model.Conta;
import br.com.desafio.financeirovn.util.csv.ContaCSVReader;
import br.com.desafio.financeirovn.util.csv.ContaCSVWriter;

public class ContaDAO extends AbstractDAO<Conta> {

    public ContaDAO() {
	super("", "Contas");
	configurar();
    }

    @Override
    protected void configurar() {
	dados = null;
	reader = new ContaCSVReader(periodo, arquivo);
	writer = new ContaCSVWriter(periodo, arquivo);
    }

}
