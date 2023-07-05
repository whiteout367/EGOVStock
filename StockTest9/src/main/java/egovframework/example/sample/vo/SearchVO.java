package egovframework.example.sample.vo;

public class SearchVO {
	 private String searchType;
	 private String keyword;
	 
	 private int firstIndex;
	 
	 private int recordCountPerPage;
	
	 public int getFirstIndex() {
		 return firstIndex;
	 }

	 public void setFirstIndex(int firstIndex) {
		 this.firstIndex = firstIndex;
	 }

	 public int getRecordCountPerPage() {
		 return recordCountPerPage;
	 }

	 public void setRecordCountPerPage(int recordCountPerPage) {
		 this.recordCountPerPage = recordCountPerPage;
	 }
	
	  public String getSearchType() {
		 return searchType;
	 }
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
