package com.whisbi.kpi;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ClientKpiKey implements Serializable {

	public ClientKpiKey(String kpi_guid, String cookieguid, String branch,
			String kpi, String clientbrowser, String clientdevice,
			String clientos) {
		super();
		this._kpi_guid = kpi_guid;
		this._cookieguid = cookieguid;
		this._branch = branch;
		this._kpi = kpi;
		this._clientbrowser = clientbrowser;
		this._clientdevice = clientdevice;
		this._clientos = clientos;
	}
    public ClientKpiKey() {}

    @Column(name = "KpiGuid")
	private String _kpi_guid;
    @Column(name = "CookieGuid")
    private String _cookieguid;
	@Column(name = "BranchGuid")
    private String _branch;
	@Column(name = "KpiCode")
    private String _kpi;
	@Column(name = "Browser")
    private String _clientbrowser;
	@Column(name = "Device")
    private String _clientdevice;
	@Column(name = "OS")
    private String _clientos;



    public String get_kpi_guid() {
		return _kpi_guid;
	}
	public void set_kpi_guid(String _kpi_guid) {
		this._kpi_guid = _kpi_guid;
	}

	public String get_cookieguid() {
		return _cookieguid;
	}
	public void set_cookieguid(String _cookieguid) {
		this._cookieguid = _cookieguid;
	}

	public String get_branch() {
		return _branch;
	}
	public void set_branch(String _branch) {
		this._branch = _branch;
	}

	public String get_kpi() {
		return _kpi;
	}
	public void set_kpi(String _kpi) {
		this._kpi = _kpi;
	}

	public String get_clientbrowser() {
		return _clientbrowser;
	}
	public void set_clientbrowser(String _clientbrowser) {
		this._clientbrowser = _clientbrowser;
	}

	public String get_clientdevice() {
		return _clientdevice;
	}
	public void set_clientdevice(String _clientdevice) {
		this._clientdevice = _clientdevice;
	}

	public String get_clientos() {
		return _clientos;
	}
	public void set_clientos(String _clientos) {
		this._clientos = _clientos;
	}

	
}
