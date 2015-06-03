package br.com.desafio.financeirovn.model;

import java.math.BigDecimal;
import java.util.Calendar;

public class Lancamento {

    private Calendar data;
    private TipoLancamento tipo;
    private BigDecimal valor;

    public Calendar getData() {
	return data;
    }

    public void setData(Calendar data) {
	this.data = data;
    }

    public TipoLancamento getTipo() {
	return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
	this.tipo = tipo;
    }

    public BigDecimal getValor() {
	return valor;
    }

    public void setValor(BigDecimal valor) {
	this.valor = valor;
    }
}
