package com.whisbi.kpi;

public class InteractionKpi {

	public enum room_user_type {
		user,
		agent,
		viewer,
		presenter
	};
	public enum room_type {
		lead,
		whisbinar
	};
	public enum interaction_type {
		user_enters,
		user_leaves,
		set_name,
		like,
		presenter_rate,
		write_chat,
		session_rate,
		ban,
		mode_change,
		banner_click,
		has_watched_video,
		create_lead
	};
	interaction_type _interaction_type;
	String _session_guid;
	int _user_id;
	String _interaction_value;
	room_user_type _user_type;
	room_type _room_type;
	
	
	public InteractionKpi(interaction_type interaction_type,
			String session_guid, int user_id, String interaction_value,
			room_user_type user_type, room_type room_type) {
		this._interaction_type = interaction_type;
		this._session_guid = session_guid;
		this._user_id = user_id;
		this._interaction_value = interaction_value;
		this._user_type = user_type;
		this._room_type = room_type;
	}

	public interaction_type get_interaction_type() {
		return _interaction_type;
	}
	public void set_interaction_type(interaction_type _interaction_type) {
		this._interaction_type = _interaction_type;
	}
	public String get_session_guid() {
		return _session_guid;
	}
	public void set_session_guid(String _session_guid) {
		this._session_guid = _session_guid;
	}
	public int get_user_id() {
		return _user_id;
	}
	public void set_user_id(int _user_id) {
		this._user_id = _user_id;
	}
	public String get_interaction_value() {
		return _interaction_value;
	}
	public void set_interaction_value(String _interaction_value) {
		this._interaction_value = _interaction_value;
	}
	public room_user_type get_user_type() {
		return _user_type;
	}
	public void set_user_type(room_user_type _user_type) {
		this._user_type = _user_type;
	}
	public room_type get_room_type() {
		return _room_type;
	}
	public void set_room_type(room_type _room_type) {
		this._room_type = _room_type;
	}
	
}
