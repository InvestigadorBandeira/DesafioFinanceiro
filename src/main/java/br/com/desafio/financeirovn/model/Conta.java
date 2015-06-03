package br.com.desafio.financeirovn.model;

import java.util.List;

public class Conta {

    private String nome;
    private List<Lancamento> lancamentos;

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public List<Lancamento> getLancamentos() {
	return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
	this.lancamentos = lancamentos;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Conta other = (Conta) obj;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	return true;
    }
}
