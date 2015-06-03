package br.com.desafio.financeirovn.dao.xml.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contas {

    private List<String> contas = new ArrayList<>();

    public List<String> getContas() {
	Collections.sort(contas);
	return contas;
    }

    public void setContas(List<String> contas) {
	this.contas = contas;
    }

}
