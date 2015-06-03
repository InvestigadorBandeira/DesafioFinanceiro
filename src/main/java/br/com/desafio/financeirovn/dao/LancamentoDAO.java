package br.com.desafio.financeirovn.dao;

import java.text.Normalizer;
import java.util.List;

import br.com.desafio.financeirovn.dao.xml.XmlDAO;
import br.com.desafio.financeirovn.dao.xml.db.Lancamentos;
import br.com.desafio.financeirovn.model.Conta;
import br.com.desafio.financeirovn.model.Lancamento;
import br.com.desafio.financeirovn.util.Formatar;

public class LancamentoDAO {

    private XmlDAO dao;
    private String nomeConta;

    public LancamentoDAO() {
    }

    public void salvar(Conta conta) {
	configuraNome(conta.getNome());
	List<Lancamento> dados;

	for (Lancamento lan : conta.getLancamentos()) {
	    String anoMes = Formatar.anoMes(lan.getData());
	    dao = new XmlDAO(new Lancamentos(), anoMes + nomeConta);
	    dados = ((Lancamentos) dao.instance()).getLancamentos();
	    dados.add(lan);
	    dao.salvar();
	}
    }

    private void configuraNome(String nome) {
	String auxiliar = Normalizer.normalize(nome, Normalizer.Form.NFD);
	auxiliar = auxiliar.replaceAll("[^0-9a-zA-Z]+?", "");

	this.nomeConta = auxiliar.toLowerCase();
    }
}
