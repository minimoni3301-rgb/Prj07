package ex02;

import java.util.Scanner;

//입력:번호,제품코드,수량,단가
//      num, pcode, amount, price

// P01:새우깡, P02:빅파이, P03:짱구, P04:초코파이, P05:수박맛초코파이

// 출력:번호,제품명,수량,단가,금액(수량*단가)
//      num, pname, amount, price, kum

/* csv format- comma seperator variable
1,P01,10,1250.0
2,P02,15,2000.0
3,P03,30,1500.0
5,P04,25,2000.0
4,P05,28,1900.0
*/

// 반드시 만들어야하는 기능 목록표(설계도) = interface (규격화)
interface Ipo {
	void input();
	void process();
	void output();
	
}

// data 중심의 class : DTO (date transfer object) 
//                     VO  (Value object)
class ProductDto {
	
	//입력:번호,제품코드,수량,단가
    //  num, pcode, amount, price
	
	// 출력:번호,제품명,수량,단가,금액(수량*단가)
    //  num, pname, amount, price, kum
	
	private int num;
	private String pcode;
	private int amount;
	private double price;
	
	private String pname;
	private double kum;
	
	
	// constructor
	
	public ProductDto() {}
	// 입력받는 애들만 넣기.
	public ProductDto(int num, String pcode, int amount, double price
			) {
		this.num = num;
		this.pcode = pcode;
		this.amount = amount;
		this.price = price;	
	}
	
	// Getter,Setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getKum() {
		return kum;
	}
	public void setKum(double kum) {
		this.kum = kum;
	}
	
	// toString 
	@Override
	public String toString() {
		return "ProductDto [num=" + num + ", pcode=" + pcode + ", amount=" + amount + ", price=" + price + ", pname="
				+ pname + ", kum=" + kum + "]";
	}
	
	
}





// 기능 중심의 class 
// implements Ipo : ipo가 지정한 메서드를 무조건 똑같이 만들겠다! 
class Product implements Ipo {

	
	  //field
	
	private ProductDto p;
	
	
	@Override
	public void input() {
		//키보드 준비 
		// in은 Scanner 변수 선언 
		Scanner in = new Scanner(System.in);
		
		// num, pcode, amount, price
		// 사용자가 어떤 형식으로 입력해야할지 띄워주는 역할 
		System.out.println("입력:번호,제품코드,수량,단가");
		
		// line는 String 변수선언, 키보드로 입력된 내용을 문자열로 읽고, 
		// line String 변수에 저장하겠다! 
		String     line   = in.nextLine(); 
		// "2,P02,15,2000.0"
		//          0    1    2     3
 		// []li : "2", "P02" "15" "2000.0"
		String   [] li      = line.trim().split(","); 
		// 쪼갠 글자들을 알맞은 데이터 타입으로 변환하기 
		int         num     = Integer.parseInt(li[0].trim());
		String      pcode   = li[1].trim();
		int         amout   = Integer.parseInt(li[2].trim());
		double      price   = Double.parseDouble(li[3].trim());
		
		p = new ProductDto(num, pcode, amout, price);
	}

	@Override
	public void process() {
		// 제품명
		// P01:새우깡, P02:빅파이, P03:짱구, P04:초코파이, P05:수박맛초코파이
		
		// pcode랑 pname을 쓸거니까 먼저 가지고 온다 
		String pcode = p.getPcode();
		
		// pname을 String으로 미리 정의해두는 것 바로 pname을 쓰면 정수인지 실수인지 문자열인지 알 수 없음.
		//String pname; -> 이렇게 해도 상관 x
		String pname = "";
		
		//내가 적은 거 
		if (pcode.equals("P01")) {
			pname = "새우깡";
		} else if (pcode.equals("PO2")) {
			pname = "빅파이";
		} else if (pcode.equals("P03")) {
		    pname = "짱구";
		} else if (pcode.equals("PO4")) {
			pname = "초코파이";
		} else {pname = "수박맛초코파이";} 
		
		p.setPname(pname);
		
		
		/*강사님 내용
		
		 if(p.getPcode().equals("P01")) {
			 p.setPname("새우깡");
		 } else if (p.getPcode().equals("P02")) {
			 p.setPname("빅파이");}
			 else if (p.getPcode().equals("P03")) {
				 p.setPname("짱구");}
			 else if (p.getPcode().equals("P04")) {
			  p.setPname("초코파이");}
			 else if (p.getPcode().equals("P05")) {
				 p.setPname("수박맛초코파이");
			 } 
		 p.setPname(pname);}*/
			 
			 

		
			
		 
	
		/*
		String pname = "새우깡";
		p.setPname(pname);
		*/
		
		// 금액
		// (수량*단가)
		
	  double kum = p.getAmount() * p.getPrice();
	  p.setKum(kum);}
	    
		
		
		
		
		/*double kum = 10000.0;
		p.setKum(kum);
		*/

	
	
	/* 
	1,P01,10,1250.0
	2,P02,15,2000.0
	3,P03,30,1500.0
	5,P04,25,2000.0
	4,P05,28,1900.0
	*/

	@Override
	public void output() {
		
		System.out.println("번호 제품명 수량 단가 금액");
		String fmt = "%d %s %d %.3f %.3f";
		String msg = String.format(fmt,p.getNum(),p.getPname(),p.getAmount(),
				                       p.getPrice(), p.getKum());
		System.out.println(msg);
		
	}
	
  //field
	
}












public class TestProduct {

	public static void main(String[] args) {
		
		
		Product p1 = new Product();
		p1.input();
		p1.process();
		p1.output();

	}

}
