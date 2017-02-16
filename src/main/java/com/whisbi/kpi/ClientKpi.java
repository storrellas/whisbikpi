package com.whisbi.kpi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBT_ODS_KPI_NEW")
class ClientKpi {

	@Override
	public String toString() {
		return "ClientKpi [id=" + id.toString() + "]";
	}

	@Id
	private ClientKpiKey id;
	
	public void setId(ClientKpiKey id) {	
		this.id = id;
	}
	
	public ClientKpiKey getId() {
		return id;
	}
	
}
