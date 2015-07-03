package br.com.desafio.financeirovn.util.csv;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.desafio.financeirovn.exception.FinanceiroException;
import br.com.desafio.financeirovn.model.Lancamento;
import br.com.desafio.financeirovn.model.TipoLancamento;
import br.com.desafio.financeirovn.util.Formatar;

public class LancamentoCSVReader extends CSVReader<Lancamento> {

    public LancamentoCSVReader(String periodo, String arquivo) {
	super(periodo, arquivo);
    }

    @Override
    protected void processaLinha(String linha) throws FinanceiroException {
	String[] registro = linha.split(";");

	if (registro.length != 3)
	    throw new FinanceiroException("Linha " + numeroLinha
		    + " fora do padrão de Lançamentos.\nArquivo: " + FILE);

	Lancamento lancamento = new Lancamento();
	lancamento.setData(getData(registro[0]));
	lancamento.setTipo(getTipo(registro[1]));
	lancamento.setValor(new BigDecimal(registro[2]));

	dados.add(lancamento);
    }

    private TipoLancamento getTipo(String registro) throws FinanceiroException {
	if ("ENTRADA".equals(registro))
	    return TipoLancamento.ENTRADA;
	else if ("SAIDA".equals(registro))
	    return TipoLancamento.SAIDA;
	else
	    throw new FinanceiroException("Tipo errado na linha " + numeroLinha
		    + ".\nTipos: ENTRADA ou SAIDA\nArquivo: " + FILE);
    }

    private Calendar getData(String registro) throws FinanceiroException {
	Calendar data = Formatar.textoData(registro);

	if (data == null)
	    throw new FinanceiroException("Data errada na linha " + numeroLinha
		    + ".\nArquivo: " + FILE);

	return data;
    }
}
