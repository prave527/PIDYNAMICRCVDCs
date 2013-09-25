package com.demo.dbtables;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TMP_RECEIVER database table.
 * 
 */
@Entity
@Table(name="TMP_RECEIVER")
public class TmpReceiver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "MYGEN")
	@TableGenerator(name="MYGEN", table="TMP_KEYGEN")
	private long id;

	private String filename;

	private String receiver;

    public TmpReceiver() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

}
