package com.whisbi.kpi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "TBT_ODS_WHISBINAR_SESSIONS_NEW")
class InteractionKpi{

	private static final Logger log = LoggerFactory.getLogger(WhisbikpispringApplication.class);
	
	@Override
	public String toString() {
		return "InteractionKpi [id=" + id.toString() + "]";
	}

	@Id
	private InteractionKpiKey id;
	
	public void setId(InteractionKpiKey id) {	
		this.id = id;
	}
	
	public InteractionKpiKey getId() {
		return id;
	}


}
