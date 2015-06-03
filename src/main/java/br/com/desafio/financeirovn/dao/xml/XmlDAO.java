package br.com.desafio.financeirovn.dao.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import br.com.desafio.financeirovn.model.Conta;
import br.com.desafio.financeirovn.model.Lancamento;
import br.com.desafio.financeirovn.util.CalendarConverter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class XmlDAO {

    private String DATABASE;
    private Object instance = null;
    private XStream xml;

    public XmlDAO(Object instance, String database) {
	DATABASE = "database/" + database + ".xml";

	this.instance = instance;
	configuraXStream();
	carregar();
    }

    private void configuraXStream() {
	xml = new XStream(new JettisonMappedXmlDriver());
	xml.alias("conta", Conta.class);
	xml.alias("lancamento", Lancamento.class);
	xml.alias("database", instance.getClass());
	xml.registerConverter(new CalendarConverter());
    }

    public synchronized Object instance() {
	if (instance == null)
	    carregar();
	return instance;
    }

    private void carregar() {
	try {
	    BufferedReader input = new BufferedReader(new FileReader(DATABASE));
	    instance = xml.fromXML(input);
	    input.close();
	} catch (FileNotFoundException e) {
	    // instance = new Database();
	} catch (IOException e) {
	    throw new RuntimeException(
		    "(OPCAO CARREGAR)\nArquivo de banco de dados não pôde ser fechado.\nMensagem: "
			    + e.getMessage());
	}
    }

    public void salvar() {
	try {
	    FileOutputStream output = new FileOutputStream(new File(DATABASE));
	    output.write(xml.toXML(instance).getBytes());
	    output.close();
	    // backup();
	} catch (FileNotFoundException e) {
	    throw new RuntimeException(
		    "(OPCAO SALVAR)\nArquivo de banco de dados não pôde ser criado.\nMensagem: "
			    + e.getMessage());
	} catch (IOException e) {
	    throw new RuntimeException(
		    "(OPCAO SALVAR)\nArquivo de banco de dados não pôde ser editado/fechado.\nMensagem: "
			    + e.getMessage());
	}
    }

}
