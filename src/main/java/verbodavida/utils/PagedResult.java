package verbodavida.utils;

import java.math.BigInteger;
import java.util.List;

public class PagedResult<T> {
	
	private BigInteger sizeDB;
	
	private List<T> dataList;

	public BigInteger getSizeDB() {
		return sizeDB;
	}

	public void setSizeDB(BigInteger sizeDB) {
		this.sizeDB = sizeDB;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public PagedResult(BigInteger sizeDB, List<T> dataList) {
		this.sizeDB = sizeDB;
		this.dataList = dataList;
	}
	
	
	
}
