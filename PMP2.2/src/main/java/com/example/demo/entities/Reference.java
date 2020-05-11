package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


@Entity
public class Reference implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Reference_ID;
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date an;
	@NumberFormat(pattern = "#,###,###,###.##")
	private String Amount;
	@NotNull(message="entre SignedBy")
	private String SignedBy;
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date Signing;
	
	private String KeywordsTags;
	@NotNull(message="entre PreviewPicture")
	private String PreviewPicture;
	@NotNull(message="entre ReferenceFile")
	private String ReferenceFile;
	
	@ManyToOne
	@JoinColumn(name="PROJECT_ID")
	private Project project;
	
	public Reference() {
		super();
	}

	public Reference(Date an, String amount, String signedBy, Date signing, String keywordsTags, String previewPicture,
			String referenceFile) {
		super();
		this.an = an;
		Amount = amount;
		SignedBy = signedBy;
		Signing = signing;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getAn() {
		return an;
	}

	public void setAn(Date an) {
		this.an = an;
	}

	public Date getSigning() {
		return Signing;
	}

	public void setSigning(Date signing) {
		Signing = signing;
	}
	
	
	

}
