package br.com.desafio.financeirovn.util.csv;

import br.com.desafio.financeirovn.exception.FinanceiroException;
import br.com.desafio.financeirovn.model.Lancamento;
import br.com.desafio.financeirovn.util.Formatar;

public class LancamentoCSVWriter extends CSVWriter<Lancamento> {

    public LancamentoCSVWriter(String periodo, String arquivo) {
	super(periodo, arquivo);
    }

    @Override
    protected String formataDado(Lancamento dado) throws FinanceiroException {
	StringBuilder registro = new StringBuilder("");

	registro.append(Formatar.dataTexto(dado.getData()));
	registro.append(";");
	registro.append(dado.getTipo());
	registro.append(";");
	registro.append(dado.getValor());
	registro.append("\n");

	return registro.toString();
    }

}
