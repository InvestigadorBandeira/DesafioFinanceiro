package br.com.desafio.financeirovn.util.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.List;

import br.com.desafio.financeirovn.exception.FinanceiroException;

public abstract class CSVWriter<T> {

    protected String FILE;

    public CSVWriter(String periodo, String arquivo) {
	formataNomeArquivo(periodo, arquivo);
    }

    private void formataNomeArquivo(String periodo, String arquivo) {
	String auxiliar = Normalizer.normalize(arquivo, Normalizer.Form.NFD);
	auxiliar = auxiliar.replaceAll("[^0-9a-zA-Z]+?", "").toLowerCase();

	this.FILE = "database/" + periodo + auxiliar + ".csv";
    }

    public void salvarDados(List<T> dados) throws FinanceiroException {

	BufferedWriter arquivo;

	try {
	    arquivo = new BufferedWriter(new FileWriter(FILE));
	    for (T dado : dados)
		arquivo.write(formataDado(dado));
	    arquivo.close();
	} catch (IOException e) {
	    throw new FinanceiroException(e);
	}

    }

    protected abstract String formataDado(T dado) throws FinanceiroException;
}
