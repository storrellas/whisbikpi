package com.whisbi.kpi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBT_ODS_KPI_NEW")
class ClientKpi {

	@Id
	private ClientKpiKey id;
	
	public void setId(ClientKpiKey id) {	
		this.id = id;
	}
	
	public ClientKpiKey getId() {
		return id;
	}
	
}
