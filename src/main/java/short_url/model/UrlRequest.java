package short_url.model;

import java.util.Date;

public class UrlRequest {

	private String urlLong;
	private String password;
	private Date dateStart;
	private Date dateEnd;
	private Integer maxClics;

	public String getUrlLong() {
		return urlLong;
	}

	public void setUrlLong(String urlLong) {
		this.urlLong = urlLong;
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

	public void setMaxCLics(Integer maxClics) {
		this.maxClics = maxClics;
	}

}
