package ex03;

import java.util.Scanner;

//입력 1줄 -> 결과 1줄
//입력  : 사번,이름,입사일,월급,부서번호
//출력  : 사번,이름,입사일,월급,보너스,수령액,부서명

//금액은 소수이하 두자리로 반올림
//보너스   =  근무연수에 따라 월급의 0.5% 로 계산한다
//수령액   =  월급 + 보너스 
//부서명   =  10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스

//모든기능은 class에 구현한다.
//입력data
//사번,이름,입사일,월급,부서번호
 


/*
100,사나,20110101,300.0,10      
200,모모,20120301,270.0,20      
300,정연,20091003,250.0,30      
400,나연,20110105,220.0,40      
500,미나,20180401,170.0,60      
600,쯔위,20150801,200.0,50      
*/

 interface Ipo {
	 void input();
	 void process();
	 void output();
	 
 }
 
//data 중심의 class 만들기 
class Data {
	
	//입력  : 사번,이름,입사일,월급,부서번호
	//        num, name, day, pay, partnum
	//출력  : 사번,이름,입사일,월급,보너스,수령액,부서명
	//         num, name, day, pay,bonus,realpay,partname
	
	private int num;
	private String name;
	private int day;
	private double pay;
	private int partnum;
	
	private double bonus;
	private int realpay;
	private String partname;

	
	
	
	// 생성자 
	public Data() { }
	
	public Data(int num, String name, int day, double pay, int partnum) {
		super();
		this.num = num;
		this.name = name;
		this.day = day;
		this.pay = pay;
		this.partnum = partnum;
	}

	
	
	
	
	
	//Getter,Setter 

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public int getPartnum() {
		return partnum;
	}

	public void setPartnum(int partnum) {
		this.partnum = partnum;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public int getRealpay() {
		return realpay;
	}

	public void setRealpay(int realpay) {
		this.realpay = realpay;
	}

	public String getPartname() {
		return partname;
	}

	public void setPartname(String partname) {
		this.partname = partname;
	}
	
	
	
	
	//toString 
	
	
	@Override
	public String toString() {
		return "Data [num=" + num + ", name=" + name + ", day=" + day + ", pay=" + pay + ", partnum=" + partnum
				+ ", bouns=" + bonus + ", realpay=" + realpay + ", partname=" + partname + "]";
	}

}



// 기능 중심의 class
class Employ implements Ipo{

	
	// field 
	
	private Data e;
	
	
	@Override
	public void input() {
		// 키보드 준비 
		// Scanner는 외부기능이라 import 필수
		Scanner in = new Scanner(System.in);
		
		//입력  : 사번,이름,입사일,월급,부서번호
		System.out.println("사번,이름,입사일,월급,부서번호");
		
		String line = in.nextLine();
		//"100,사나,20110101,300.0,10"

		String [] li = line.trim().split(",");
		//"100","사나","20110101","300.0","10"
		
		int     num     = Integer.parseInt(li[0].trim());
		String name     = li[1].trim();
		int     day     = Integer.parseInt(li[2].trim());  //나는 trim을 안붙였음.. 변환뒤에 
		double  pay     = Double.parseDouble(li[3].trim());
		int     partnum = Integer.parseInt(li[4].trim());
		
		e = new Data(num, name, day, pay, partnum); // new date 입력하고 컨트롤 스페이스 하면 자동으로 입력 
		
		
	}

	@Override
	public void process() {
		//출력     : 사번,이름,입사일,월급,보너스,수령액,부서명
		//금액은 소수이하 두자리로 반올림
		
		//보너스   =  근무연수에 따라 월급의 0.5% 로 계산한다
		
		double bonus = e.getDay()*(e.getPay() * 0.005);// 0.005를 곱해야 0.5% 나는 0.5곱했음 
	    
		e.setBonus(bonus);
		
		//수령액   =  월급 + 보너스
		
		int realpay = (int) (e.getPay() + e.getBonus());
		
		e.setRealpay(realpay);
		
		//부서명   =  10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스
		
		String partname="";
		
		if (e.getPartnum() == 10){
		partname = "인사";
		} else if (e.getPartnum() == 20){
		partname = "자재";	
		} else if (e.getPartnum() == 30) {
		partname = "총무";
		} else if (e.getPartnum() == 40) {
		partname = "연구개발";
		} else if (e.getPartnum() == 50) {
		partname = "생산";
		} else if (e.getPartnum() == 60) {
		partname ="서비스";
		}
		
		e.setPartname(partname);
		
	}

	@Override
	public void output() {
		System.out.println("사번 이름 입사일 월급 보너스 수령액 부서명");
		String a = "%d %s %d %.2f %.2f %d %s";
		String b = String.format(a,e.getNum(),e.getName(),e.getDay(),e.getPay(),
				   e.getBonus(), e.getRealpay(),e.getPartname() );
		
		System.out.println(b);
	}
	
}

public class TestJob {

	public static void main(String[] args) {
		
		
		Employ p1 = new Employ(); 
		p1.input();
		p1.process();
		p1.output();
		
		

	}

}
