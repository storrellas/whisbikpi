package com.whisbi.kpi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "TBT_ODS_KPI_NEW")
class ClientKpi{

	private static final Logger log = LoggerFactory.getLogger(WhisbikpispringApplication.class);
	
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
