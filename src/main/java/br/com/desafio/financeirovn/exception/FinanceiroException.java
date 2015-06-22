package br.com.desafio.financeirovn.exception;

public class FinanceiroException extends Exception {

    public FinanceiroException() {
	super();
    }

    public FinanceiroException(String message, Throwable cause,
	    boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public FinanceiroException(String message, Throwable cause) {
	super(message, cause);
    }

    public FinanceiroException(String message) {
	super(message);
    }

    public FinanceiroException(Throwable cause) {
	super(cause);
    }

}
