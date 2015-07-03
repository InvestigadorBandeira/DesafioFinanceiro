package br.com.desafio.financeirovn.util.csv;

import br.com.desafio.financeirovn.exception.FinanceiroException;
import br.com.desafio.financeirovn.model.Conta;

public class ContaCSVReader extends CSVReader<Conta> {

    public ContaCSVReader(String periodo, String arquivo) {
	super("", arquivo);
    }

    @Override
    protected void processaLinha(String linha) throws FinanceiroException {
	String[] registro = linha.split(";");

	if (registro.length != 1)
	    throw new FinanceiroException("Linha " + numeroLinha
		    + " fora do padrão de Contas.\n Arquivo: " + FILE);

	Conta conta = new Conta();
	conta.setNome(registro[0]);
	dados.add(conta);
    }

}
