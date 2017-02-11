package net.sytes.codeline.entities;

public class UsersReceiver {

	private User from;
	private User to;
	
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	public User getTo() {
		return to;
	}
	public void setTo(User to) {
		this.to = to;
	}
	
	@Override
	public String toString() {
		return "UsersReceiver [from=" + from + ", to=" + to + "]";
	}
	
}
