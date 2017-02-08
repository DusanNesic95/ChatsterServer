package net.sytes.codeline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOMAIN")
public class Domain {

	private int domainId;
	private String domainName;
	private String domainCode;
	
	@Id
	@GeneratedValue
	@Column(name="DOMAIN_ID")
	public int getDomainId() {
		return domainId;
	}
	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}
	
	@Column(name="DOMAIN_NAME")
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	@Column(name="DOMAIN_CODE")
	public String getDomainCode() {
		return domainCode;
	}
	public void setDomainCode(String domainCode) {
		this.domainCode = domainCode;
	}
	
	@Override
	public String toString() {
		return "Domain [domainId=" + domainId + ", domainName=" + domainName + ", domainCode=" + domainCode + "]";
	}
	
}
