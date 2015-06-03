package br.com.desafio.financeirovn.dao.xml.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.desafio.financeirovn.model.Lancamento;
import br.com.desafio.financeirovn.util.OrdenarLancamentos;

public class Lancamentos {

    private List<Lancamento> lancamentos = new ArrayList<>();

    public List<Lancamento> getLancamentos() {
	Collections.sort(lancamentos, OrdenarLancamentos.PorData);
	return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
	this.lancamentos = lancamentos;
    }

}
