package hakaton.mljfs.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class BuildingFilterBean {

	private @QueryParam("type") int type;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;

	public int getType() {
		return type;
	}

	public void setType(int year) {
		this.type = year;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
