package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Reference implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Reference_ID;
	private Date Year;
	private String Amount;
	private String SignedBy;
	private Date SigningDate;
	private String KeywordsTags;
	private String PreviewPicture;
	private String ReferenceFile;
	
	public Reference() {
		super();
	}
	
	public Reference(Date year, String amount, String signedBy, Date signingDate, String keywordsTags,
			String previewPicture, String referenceFile) {
		super();
		Year = year;
		Amount = amount;
		SignedBy = signedBy;
		SigningDate = signingDate;
		KeywordsTags = keywordsTags;
		PreviewPicture = previewPicture;
		ReferenceFile = referenceFile;
	}
	public Integer getReference_ID() {
		return Reference_ID;
	}
	public void setReference_ID(Integer reference_ID) {
		Reference_ID = reference_ID;
	}
	public Date getYear() {
		return Year;
	}
	public void setYear(Date year) {
		Year = year;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getSignedBy() {
		return SignedBy;
	}
	public void setSignedBy(String signedBy) {
		SignedBy = signedBy;
	}
	public Date getSigningDate() {
		return SigningDate;
	}
	public void setSigningDate(Date signingDate) {
		SigningDate = signingDate;
	}
	public String getKeywordsTags() {
		return KeywordsTags;
	}
	public void setKeywordsTags(String keywordsTags) {
		KeywordsTags = keywordsTags;
	}
	public String getPreviewPicture() {
		return PreviewPicture;
	}
	public void setPreviewPicture(String previewPicture) {
		PreviewPicture = previewPicture;
	}
	public String getReferenceFile() {
		return ReferenceFile;
	}
	public void setReferenceFile(String referenceFile) {
		ReferenceFile = referenceFile;
	}
	
	
	

}
