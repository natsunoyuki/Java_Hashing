//Class representing Book object
public class Book {
    //private variables representing information of book
	private String title;   //本のタイトル
    private String author;  //本の著者
    
    //コンストラクタ
    public Book(String title, String author) {
    	this.title = title;
    	this.author = author;
    }//end constructor Book(String title, String author)
    
    //default constructor
    //private variablesにempty stringを設定すること
    /*
    public Book() {
    	this.title = "";
    	this.author = "";
    } //end default constructor Book()
    */
    
    //Bookのinformationを表示すること
    public void printBook() {
    	System.out.printf("%s:%s",this.title,this.author);
    }//end printBook()
    
    //getter methodでBookのtitleをとること
    public String getTitle() {
    	return this.title;
    }//end getTitle()
    
    //setter method、Bookのtitleを設定すること
    public void setTitle(String title) {
    	this.title = title;
    }//end setTitle()
    
    //getter methodでBookのauthorをとること
    public String getAuthor() {
    	return this.author;
    }//end getAuthor
    
    //setter method、Bookのauthorを設定すること
    public void setAuthor(String author) {
    	this.author = author;
    }//end setAuthor()
    
}//end Book class
