package short_url.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "url")
public class Url implements Serializable {

	private static final long serialVersionUID = 7623621780015365850L;

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false, name = "url_long")
	private String urlLong;

	@Column(nullable = false, name = "url_short")
	private String urlShort;

	@Column(name = "password")
	private String password;

	@Column(name = "date_start")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateStart;

	@Column(name = "date_end")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateEnd;

	@Column(name = "max_clics")
	private Integer maxClics;

	@Column(name = "nb_clics")
	private int nbClics = 0;

	public Url() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlLong() {
		return urlLong;
	}

	public void setUrlLong(String urlLong) {
		this.urlLong = urlLong;
	}

	public String getUrlShort() {
		return urlShort;
	}

	public void setUrlShort(String urlShort) {
		this.urlShort = urlShort;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Integer getMaxClics() {
		return maxClics;
	}

	public void setMaxClics(Integer maxClics) {
		this.maxClics = maxClics;
	}

	public int getNbClics() {
		return nbClics;
	}

	public void setNbClics(int nbClics) {
		this.nbClics = nbClics;
	}

	@Override
	public String toString() {
		return "Url [id=" + id + ", urlLong=" + urlLong + ", urlShort=" + urlShort + ", password=" + password
				+ ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", maxClics=" + maxClics + ", nbClics="
				+ nbClics + "]";
	}

}
