package ex03;

import java.time.LocalDate;
import java.util.Scanner;

//입력  : 사번,이름,입사일,월급,부서번호
//        num,name,hiredate,salary,deptno
//출력  : 사번,이름,입사일,월급,보너스,수령액,부서명
//        num,name,hiredate,salary,bouns,pay,daptname


interface Ipo {
	 void input();
	 void process();
	 void output();


//입력 1줄 -> 결과 1줄
//입력  : 사번,이름,입사일,월급,부서번호
//num,name,hiredate,salary,deptno
//출력  : 사번,이름,입사일,월급,보너스,수령액,부서명
//num,name,hiredate,salary,bouns,pay,daptname

class EmpVo {
	
	// field 
	// 입력
	private     int          num;
	private     String       name;
	private     String       hiredate;
	private     double       salary;
	private     int          deptno ;
	// 출력
	private     double       bonus;
	private     double       pay;
	private     String       daptname;
	
	
	
	
	//생성자
	public EmpVo()  {}
	
	public EmpVo(int num, String name, String hiredate, double salary, int deptno) {
		super();
		this.num          = num;
		this.name         = name;
		this.hiredate     = hiredate;
		this.salary       = salary;
		this.deptno       = deptno;
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

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public String getDaptname() {
		return daptname;
	}

	public void setDaptname(String daptname) {
		this.daptname = daptname;
	}
	
	
	
	//toString 

	@Override
	public String toString() {
		return "EmpVo [num=" + num + ", name=" + name + ", hiredate=" + hiredate + ", salary=" + salary + ", deptno="
				+ deptno + ", bonus=" + bonus + ", pay=" + pay + ", daptname=" + daptname + "]";
	}

}

//입력  : 사번,이름,입사일,월급,부서번호
//num,name,hiredate,salary,deptno
//출력  : 사번,이름,입사일,월급,보너스,수령액,부서명
//num,name,hiredate,salary,bouns,pay,daptname



// class Emp
class Emp implements Ipo{

	
	private EmpVo empVo;
	
	
	@Override
	public void input() {
		
        Scanner in           =   new Scanner(System.in);
		
		System.out.println("사번,이름,입사일,월급,부서번호");
		// before "    100,사나,20110101,300.0,10    "
		String line          =   in.nextLine().trim(); //  여기 trim은 "  문자열  " 여기 앞뒤만 날려준다. 중간은 xx
		// after "100,사나,20110101,300.0,10"
		String [] li         =   line.split(",");
		// 여기 trim은 문자열"" 안의 공백을 날린다. ez) "   사나" 
		int      num         =   Integer.parseInt(li[0]);
		String   name        =   li[1].trim();
		String   hiredate    =   li[2].trim();
		double   salary      =   Double.parseDouble(li[3].trim());
		int      deptno      =   Integer.parseInt(li[4].trim());
		
		empVo = new EmpVo(num, name, hiredate, salary, deptno);
		
	}
	
	
	
	
	//금액은 소수이하 두자리로 반올림
	//보너스   =  근무연수에 따라 월급의 0.5% 로 계산한다
	//수령액   =  월급 + 보너스 
	//부서명   =  10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스	
	

	@Override
	public void process() {
	
		//보너스   =  근무연수에 따라 월급의 0.5% 로 계산한다
		//int hireYears = 올해연도 - 입사연도;
		int thisYear      =   LocalDate.now().getYear();                   // 올해연도 
		String hiredate   =   empVo.getHiredate();                          //입사연도
		int hireYear      =   Integer.parseInt(hiredate.substring(0, 4+1));// 입사일의 연도 부분
		int hireYears     =   thisYear - hireYear;
		System.out.println(hiteYear);
		double salry      =   empVo.getSalary();
		double bonus      =   hireYear * salary * 0.005;//근무연수 * 월급 * 0.5
		
		// 수령액         = 월급 + 보너스
	    double pay        = salary + bonus;
	    
	    // 부서명  =  10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스
		String deptname = "";
		int    deptno   = empVo.getDeptno();
		switch (deptno)
		{
		case 10 : deprname = :"인사"; break;
		
		
		}
		}
		empVo.setBonus(bonus);
		empVo.setPay(pay);
		empVo.setDaptname(deptname);
		
	}
	
	
	@Override
	public void output() {
		System.out.println();
		
	}
	

}


public class TestEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}}
