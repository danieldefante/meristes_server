package verbodavida.utils;

public class BeanConsultGroup {

	private int page;
	
	private int size;
	
	public int getPageResolver() {
		return page * getSize();
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public BeanConsultGroup(int page, int size) {
		setPage(page);
		setSize(size);
	}
	
}
