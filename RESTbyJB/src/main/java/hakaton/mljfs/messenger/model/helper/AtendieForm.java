package hakaton.mljfs.messenger.model.helper;

public class AtendieForm {
	private String email;
	private int event;
	
	public AtendieForm(){
		
	}

	public AtendieForm(String email, int event) {		
		this.email = email;
		this.event = event;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEvent() {
		return event;
	}

	public void setEvent(int event) {
		this.event = event;
	}
	
	
	
	
	
}
