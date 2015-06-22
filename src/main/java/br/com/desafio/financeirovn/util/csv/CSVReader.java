package br.com.desafio.financeirovn.util.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.financeirovn.exception.FinanceiroException;

public abstract class CSVReader<T> {

    protected String FILE;
    protected int numeroLinha = 0;
    protected List<T> dados = new ArrayList<>();

    public CSVReader(String periodo, String arquivo) throws Exception {
	this.FILE = "database/" + periodo + formataNomeArquivo(arquivo)
		+ ".csv";

	carregarDados();
    }

    private String formataNomeArquivo(String nomeArquivo) {
	String auxiliar = Normalizer
		.normalize(nomeArquivo, Normalizer.Form.NFD);
	auxiliar = auxiliar.replaceAll("[^0-9a-zA-Z]+?", "");

	return auxiliar.toLowerCase();
    }

    private void carregarDados() throws FinanceiroException {

	BufferedReader arquivo;

	try {
	    arquivo = new BufferedReader(new FileReader(FILE));
	    while (arquivo.ready()) {
		String linha = arquivo.readLine();
		numeroLinha++;
		processaLinha(linha);
	    }
	    arquivo.close();
	} catch (IOException e) {
	    throw new FinanceiroException(e);
	}

    }

    protected abstract void processaLinha(String linha)
	    throws FinanceiroException;

    public List<T> getDados() {
	return dados;
    }
}
