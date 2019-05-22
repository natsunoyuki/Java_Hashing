//例外クラス, Exceptionを継承すること

public class BookException extends Exception {
	
    //Exception classを継承したクラスではこのフィールドをもつことが推奨
	private static final long serialVersionUID = 1L;
    
	//BookException classに指示は何もないので、
	//このコードでは、Library classがBookを追加する際に、削除する際に発生するエラー
	//を処理する例外です。
	
	//BookException コンストラクタ
	//引数はString m、エラーメッセージになること
	//super()でスパークラスに渡すこと
    public BookException(String m) {
    	super(m);//call the constructor of super class and pass String m
    }//end constructor BookException(String m)
    
} //end class BookException
