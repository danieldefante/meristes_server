package verbodavida.utils;

public class PagedResult {
	
	private Long sizeDB;
	
	private Object data;

	public Long getSizeDB() {
		return sizeDB;
	}

	public void setSizeDB(Long sizeDB) {
		this.sizeDB = sizeDB;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public PagedResult(Long sizeDB, Object data) {
		this.sizeDB = sizeDB;
		this.data = data;
	}
	
	
	
}
