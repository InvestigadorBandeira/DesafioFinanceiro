package br.com.desafio.financeirovn.util;

import java.util.Collections;
import java.util.Comparator;

import br.com.desafio.financeirovn.model.Lancamento;

public enum OrdenarLancamentos implements Comparator<Lancamento> {

    PorData {
	@Override
	public int compare(Lancamento lancamento1, Lancamento lancamento2) {
	    return lancamento1.getData().compareTo(lancamento2.getData());
	}
    };

    public Comparator<Lancamento> asc() {
	return this;
    }

    public Comparator<Lancamento> desc() {
	return Collections.reverseOrder(this);
    }
}
