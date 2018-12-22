package ControlLayer;

public class PersonException extends Exception {
	private static final long serialVersionUID = 1L;
	String personException;

	public PersonException() {
		super();
		personException = "Person class error";

	}

	public PersonException(String err) {
		super(err);
		personException = err;
	}

	public String getPersonException() {
		return personException;
	}

	public void setPersonException(String personException) {
		this.personException = personException;
	}
}
