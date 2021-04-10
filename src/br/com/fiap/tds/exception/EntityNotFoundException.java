package br.com.fiap.tds.exception;

public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = -3099123070991256668L;
	
	public EntityNotFoundException() {
		super("Entidade não encontrada");
	}
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}
}
