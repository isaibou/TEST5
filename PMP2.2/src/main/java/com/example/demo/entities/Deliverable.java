package com.example.demo.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Deliverable implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer Deliverable_ID;
	private String Name;
	private String Version;
	private Date Date;
	private String PreviewFile;
	private String File;
	private String DocumentLink;
	public Deliverable() {
		super();
	}
	public Deliverable(String name, String version, java.util.Date date, String previewFile, String file,
			String documentLink) {
		super();
		Name = name;
		Version = version;
		Date = date;
		PreviewFile = previewFile;
		File = file;
		DocumentLink = documentLink;
	}
	public Integer getDeliverable_ID() {
		return Deliverable_ID;
	}
	public void setDeliverable_ID(Integer deliverable_ID) {
		Deliverable_ID = deliverable_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getPreviewFile() {
		return PreviewFile;
	}
	public void setPreviewFile(String previewFile) {
		PreviewFile = previewFile;
	}
	public String getFile() {
		return File;
	}
	public void setFile(String file) {
		File = file;
	}
	public String getDocumentLink() {
		return DocumentLink;
	}
	public void setDocumentLink(String documentLink) {
		DocumentLink = documentLink;
	}
	
	
	
}