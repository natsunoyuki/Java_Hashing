//Class representing Library object

//ArrayList<>を使うから、必ずjava.utilから
//importすること
import java.util.ArrayList;
import java.util.Iterator;

public class Library {
    //private variables 
	private String name; //図書館の名前
	private ArrayList<Book> listitem; //Book objectを格納ArrayList
	
	//Library コンストラクタ
	//引数からnameを設定、
	//また新しいArrayListを宣言する
	public Library(String name) {
		this.name = name;
		listitem = new ArrayList<Book>();
	}//end Library(String name)
	
	//listitemにbookを追加すること
	public void addBook(Book book) throws BookException {
		//新しい本を追加するときに、もし図書館にその本が存在するなら、
		//追加できない。エラーをスローしましょう。
		
		if(book.getAuthor().equals("") || book.getTitle().equals("")) {
			//もしBookの情報にempty stringが入力された場合、エラーを発生
			String mess = "書籍の情報はたりないので、追加できませんでした!\n";
	    	throw new BookException(mess);
	    	//in case of error,
	    	//code ends at throw and does not 
	    	//continue so return is not needed.
		}
		
		if(listitem.size() == 0) {
			//if listitem is empty, directly add the new book
			listitem.add(book);
		}else {
			//if not, check for book duplicates. We cannot use .contains(book) as book is a new 
			//book object, so we are forced to check by author and title name one by one.
		    Iterator<Book> i = listitem.iterator();
		    while(i.hasNext()) {
		    	Book temp = i.next(); //cannot use i.next() twice!!!
			    if(temp.getAuthor().equals(book.getAuthor()) && temp.getTitle().equals(book.getTitle())){
			    	String mess = String.format("%s:%sはすでに存在しているので、追加できません！\n",book.getTitle(),book.getAuthor());
			    	throw new BookException(mess);
		    	}
		    }//end while()
		    
		    //もし重複しない本なら、追加します！
		    listitem.add(book);
		    
		}//end if else
		    	
	}//end addBook(Book book)
	
	//指定されたindexのdelnoのBook objectをlistitemから削除するころ
	public void removeBook(int delno) throws BookException {
		//存在しない本を削除するのはエラーが発生するので、
		//ちゃんとエラーを処理しましょう
		if(listitem.size() <= delno) {
		    //if delno is larger than the length of listitem
			//the index does not exist and so throw an error
			String mess = String.format("\n指定された%dには書が存在しません!削除できません!\n",delno);
			throw new BookException(mess);
		}else {
			listitem.remove(delno);
		}//end if-else
		
	}	//end removeBook(int delno)
	
	//Bookのinformationを全て表示すること
	public void printBook() {
		
		System.out.printf("%s　所蔵図書一覧\n",this.name);
		System.out.println("　  タイトル　:　著者");
		
		//Iteratorを使って、ArrayList<Book>のlistitemに格納されたBook object
		//の情報を表示すること
		Iterator<Book> i = listitem.iterator();
		
		int counter = -1; //本の数を示すため
		while(i.hasNext()) {
			//iは次のBookを持っているなら、処理を続けること
			counter++;
			System.out.print(counter + " ");
			//Book objectのprintBook()メソッドを使ってその本の情報を示す
			i.next().printBook();
			System.out.println();
		}//end while()
		
	}//end printBook()
	
}//end Library class
