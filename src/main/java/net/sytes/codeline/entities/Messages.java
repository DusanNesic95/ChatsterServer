package net.sytes.codeline.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGES")
public class Messages {

	private int messagesId;
	private User fromUserId;
	private User toUserId;
	private Date timeOfSending;
	private String content;
	
	@Id
	@GeneratedValue
	@Column(name="MESSAGES_ID")
	public int getMessagesId() {
		return messagesId;
	}
	public void setMessagesId(int messagesId) {
		this.messagesId = messagesId;
	}
	
	@JoinColumn(name="FROM_USER_ID", referencedColumnName="USER_ID")
	@ManyToOne
	public User getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(User fromUserId) {
		this.fromUserId = fromUserId;
	}
	
	@JoinColumn(name="TO_USER_ID", referencedColumnName="USER_ID")
	@ManyToOne
	public User getToUserId() {
		return toUserId;
	}
	public void setToUserId(User toUserId) {
		this.toUserId = toUserId;
	}
	
	@Column(name="TIME_OF_SENDING")
	public Date getTimeOfSending() {
		return timeOfSending;
	}
	public void setTimeOfSending(Date timeOfSending) {
		this.timeOfSending = timeOfSending;
	}
	
	@Column(name="CONTENT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Messages [messagesId=" + messagesId + ", fromUserId=" + fromUserId + ", toUserId=" + toUserId
				+ ", timeOfSending=" + timeOfSending + ", content=" + content + "]";
	}
	
}
