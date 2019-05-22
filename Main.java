import java.util.Scanner; //Scannerを使うから、java.utilからimport
import java.util.InputMismatchException;
public class Main {

//190404　ナツメ　ユウキ	
	
	//main driver class to run BookException,
	//Library and Book classes
	public static void main(String[] args) {
		
		int i = 0; //ユーザの選択用(メニュー)
		String name = ""; //ユーザの入力用(本の名前)
		String author = ""; //ユーザの入力用(本の著者)
		int delno; //本を削除用
		
		//new Scanner objectを作ること
		Scanner in = new Scanner(System.in);
		
		//new Library object with name "九段下図書館"
		Library library = new Library("九段下図書館");
		
		//ユーザが4を入力するまでに、走らせること
		while(true) {
			//ユーザにメニュを示すこと
			printMenu();
			
			//ユーザから選択すること
			try {
			    System.out.print("メニュー番号:");
			    i = in.nextInt();
			    
			    //use if-else instead of switch as I want to break out of while loop
			    //of course switch can be used by changing condition of while loop
			    if(i==4) {
				    //4なら、program loopが終了
				    System.out.println("ご利用ありがとうございました。");
				    break;
			    }else if(i < 1 || i >= 5) {
			    	//1-4じゃないなら、再入力すること
				    System.out.println("1-4を入力してください。");
			    }else if(i==1) {
			    	//もし番号が正しく入力されるなら、次の処理に
			    	
			    	//1なら、は本の登録
			    	
			    	//本の名前を入力すること
			    	System.out.print("書名:");
			    	//remember to read-off the "\n" remaining in the input stream!!!
			    	in.nextLine();
			    	name = in.nextLine();
			    	//本の著者を入力すること
			    	System.out.print("著者:");
			    	author = in.nextLine();
			    	System.out.println();
			    	
			    	//libraryに新し本をaddBook()で追加すること
			    	library.addBook(new Book(name,author));
			    
			    }else if(i == 2) {
			        //2なら、BookをLibraryから削除すること
			    	System.out.print("削除No.:");
			    	
			    	
			    	//this part produces the following bug when a non-int is input
			    	//the catch(InputMismatchException IME) statement is executed
			    	//and 1-4を入力してください。 is printed on the screen
			    	/*
			    	if(in.hasNextInt()) {
			    		delno = in.nextInt();
				    	library.removeBook(delno);
				    	System.out.println();
			    	}else {
			    		System.out.println("数字のみを入力してください。");
			    		in.nextLine();
			    	}//end if-else
			    	*/
			    	
			    	//this code seems to work instead...
			    	//in case the user inputs non-int, the conversion from int throws
			    	//a NumberFormatException error
			    	String temp = in.next();
			    	delno = Integer.parseInt(temp);
			    	library.removeBook(delno);
			    	System.out.println();
   
			    }else if(i==3) {
			        //3なら、書籍一覧すること
			    	printDottedLine(29);
			    	library.printBook();
			    	printDottedLine(29);
			    	System.out.println();
			    }//end if
			    
		    }catch(InputMismatchException IME) {
		    	//メニュー番号を読み込むときに、文字とかが入力されたなら、再入力すること
		    	System.out.println("1-4を入力してください。");
		    	//remember to read-off the "\n" remaining in the input stream!!!
		    	in.nextLine();
		    }catch(BookException BE) {
		    	//全部はoutにします。errとoutが並行に使うなら、変なoutputになりえます
		    	System.out.println(BE.getMessage());
		    }catch(NumberFormatException NFE) {
		    	//catch the NumberFormatException error thrown if user
		    	//tries to select book to be removed using non-int
		    	System.out.println("\n数字のみを入力してください。\n");
		    }//end try-catch
			
		}//end while()
		
		in.close(); //必ずinをclose()すること!!!!

	} //end main()
	
	
	//other methods used in the code:
	
	//メニュを表示するメソッド
	public static void printMenu() {
		System.out.println("*******メニュー*******");
		System.out.println("1.書籍登録");
		System.out.println("2.書籍削除");
		System.out.println("3.書籍一覧");
		System.out.println("4.終了");
		System.out.println("*******************");
	}//end printMenu() 

	//Nつの"="を表示するメソッド
	public static void printDottedLine(int N) {
		String string = "=";
		for(int i=0; i < N - 1; i++) {
			string += "=";
		}
		System.out.println(string);
	}//end printDottedLine();
	
}//end Main
