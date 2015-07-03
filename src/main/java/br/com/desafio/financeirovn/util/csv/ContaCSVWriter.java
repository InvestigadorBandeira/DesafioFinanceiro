package br.com.desafio.financeirovn.util.csv;

import br.com.desafio.financeirovn.exception.FinanceiroException;
import br.com.desafio.financeirovn.model.Conta;

public class ContaCSVWriter extends CSVWriter<Conta> {

    public ContaCSVWriter(String periodo, String arquivo) {
	super(periodo, arquivo);
    }

    @Override
    protected String formataDado(Conta dado) throws FinanceiroException {
	String registro = dado.getNome();

	if (registro == null || registro.isEmpty())
	    throw new FinanceiroException("Nome de conta não deve ser vazio.");

	return registro + "\n";
    }

}
