package com.cepheid.cloud.skel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Assumption : Entities are Movie Tapes/DVD/CD's
@Entity
@Table(name = "item")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Item extends AbstractEntity {

	@NotBlank
	private String state;

	@OneToMany(targetEntity = Description.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Description> descriptions = new ArrayList<Description>();

	@NotBlank
	private Integer barcode;

	@NotBlank
	private String name;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public final String getState() {
		return state;
	}

	public final void setState(String state) {
		this.state = state;
	}

	public final Integer getBarcode() {
		return barcode;
	}

	public final void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + "]";
	}

	public final List<Description> getDescriptions() {
		return descriptions;
	}

	public final void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}

}
