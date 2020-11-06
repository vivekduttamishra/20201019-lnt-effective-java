package in.conceptarchitect.booksapi.services;

public class ServiceInfo {

	String service;
	String url;
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ServiceInfo(String service, String url) {
		super();
		this.service = service;
		this.url = url;
	}
	
	

}
