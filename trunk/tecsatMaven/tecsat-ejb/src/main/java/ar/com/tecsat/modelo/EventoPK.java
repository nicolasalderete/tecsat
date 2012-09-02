package ar.com.tecsat.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the evento database table.
 * 
 */
@Embeddable
public class EventoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cli_id", unique=true, nullable=false)
	private int cliId;

	@Column(name="dis_id", unique=true, nullable=false)
	private int disId;

    @Temporal( TemporalType.DATE)
	@Column(name="time_stamp", unique=true, nullable=false)
	private java.util.Date timeStamp;

    public EventoPK() {
    }
	public int getCliId() {
		return this.cliId;
	}
	public void setCliId(int cliId) {
		this.cliId = cliId;
	}
	public int getDisId() {
		return this.disId;
	}
	public void setDisId(int disId) {
		this.disId = disId;
	}
	public java.util.Date getTimeStamp() {
		return this.timeStamp;
	}
	public void setTimeStamp(java.util.Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventoPK)) {
			return false;
		}
		EventoPK castOther = (EventoPK)other;
		return 
			(this.cliId == castOther.cliId)
			&& (this.disId == castOther.disId)
			&& this.timeStamp.equals(castOther.timeStamp);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cliId;
		hash = hash * prime + this.disId;
		hash = hash * prime + this.timeStamp.hashCode();
		
		return hash;
    }
}