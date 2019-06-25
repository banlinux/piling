package com.sil.databasemodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PILE_DETAIL")
public class PileDetail implements Serializable {
	@Id
	@Column(name="PILE_NO")
	private String pile_no;
	@Column(name="SITE_NO")
	private String site_no;
	@Column(name="CONTRACT_NO")
	private String contract_no;

	@Column(name="PILE_DIA")
	private String pile_dia;
	@Column(name="CAGE_LENGTH")
	private String cage_length;
	
	@Column(name="CONCRETE_VOLUME")
	private String concrete_volume;
	@Column(name="CAGE_DETAIL")
	private String cage_detail;
	
	@Column(name="DRAWING_NO")
	private String drawing_no;
	@Column(name="BORING_LENGTH")
	private String boring_length;
	public String getPile_no() {
		return pile_no;
	}
	public void setPile_no(String pile_no) {
		this.pile_no = pile_no;
	}
	public String getSite_no() {
		return site_no;
	}
	public void setSite_no(String site_no) {
		this.site_no = site_no;
	}
	public String getContract_no() {
		return contract_no;
	}
	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}
	public String getPile_dia() {
		return pile_dia;
	}
	public void setPile_dia(String pile_dia) {
		this.pile_dia = pile_dia;
	}
	public String getCage_length() {
		return cage_length;
	}
	public void setCage_length(String cage_length) {
		this.cage_length = cage_length;
	}
	public String getConcrete_volume() {
		return concrete_volume;
	}
	public void setConcrete_volume(String concrete_volume) {
		this.concrete_volume = concrete_volume;
	}
	public String getCage_detail() {
		return cage_detail;
	}
	public void setCage_detail(String cage_detail) {
		this.cage_detail = cage_detail;
	}
	public String getDrawing_no() {
		return drawing_no;
	}
	public void setDrawing_no(String drawing_no) {
		this.drawing_no = drawing_no;
	}
	public String getBoring_length() {
		return boring_length;
	}
	public void setBoring_length(String boring_length) {
		this.boring_length = boring_length;
	}
	
	
	
	
}
