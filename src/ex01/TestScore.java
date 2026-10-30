package ex01;



/*  1번
num,name,kor,eng,mat
번호,이름,국어,영어,수학
1,사나,70,80,90
2,모모,0,70,100
3,쯔위,70,90,90
4,정연,80,90,70
5,원영,90,90,89
6,유진,100,100,100


입력 : 번호, 이름, 국어, 영어 ,수학
        num,  name,  kor,  eng,  mat

출력 : 번호, 이름, 국어, 영어, 수학, 총점, 평균, 등급 
       num,  name,  kor,  eng,  mat,  tot, avg,  grade
*/

class Score {
	
	//fields
	// 입력 : 번호, 이름, 국어, 영어 ,수학
	private int    num;
	private String name;
	private int    kor;
	private int    eng;
	private int    mat; 
	
	// 출력 : 총점, 평균, 등급 
	private int    tot;
	private double avg;
	private char   grade;
	
	
	// Constructor 생성자 (new할때 private 변수에 값을 넣는 것), (new할때 초기화 - 입력)
	public Score() {}
	//입력 받을거만 생성자에 넣음
	public Score(int num, String name, int kor, int eng, int mat) //변수만들때 미리 값을 넣고싶을때 생성자 사용 
			 {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
		this.tot = 0;
		this.avg = 0.0;
		this.grade = 'F';
	
	}
	
	
	//Getter, Setter
	
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
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	
	
	
	// toString : 값 중간 확인용
	@Override
	public String toString() {
		return "Score [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", avg=" + avg + ", grade=" + grade + "]";
	}
	
	
	
	// method 
	
	// tot계산 
	public int calctot() {
		tot = kor + eng + mat;
		return tot;
	}
	// avg 계산 
	public double calcAvg() {
	    //avg = tot/3.0 이렇게 하면 tot 값이 '0' 으로 들어가있어서 계산이 안됨 (총점을 계산을 하지 않았을 경우)
		//avg = calctot()/3.0;  이건 가능
		avg = (kor + eng + mat)/3.0;
		return avg;
	}
	public char calcGrade() {
	
		//내가 쓴 답은 'grade ='A' 값에 Sysout을 씀 
		
		if (calcAvg() >= 90 && calcAvg() <=100) {
			grade = 'A';
		} else {
			if (calcAvg() >=80 && calcAvg() <90) {
				grade = 'B';
			} else {
				if (calcAvg() >=70 && calcAvg() <80) {
					grade = 'C';
				} else {
					if (calcAvg() >=60 && calcAvg() <70) {
						grade = 'D';
					} else {
						if (calcAvg() >=0 && calcAvg() <60) {
							grade = 'F';
						}
					}
				}
			}
		}
		return grade;
	}
	
	/* 더 짧게 쓸수 있는 방법
	 avg = calcAvg(); 
	 
	 if (avg >= 90.0 && avg <= 100.0) {
        grade = 'A';
    } else if (avg >= 80.0 && avg < 90.0) {
        grade = 'B';
    } else if (avg >= 70.0 && avg < 80.0) {
        grade = 'C';
    } else if (avg >= 60.0 && avg < 70.0) {
        grade = 'D';
    } else {
        // 위의 모든 조건이 아니면 무조건 F이므로 굳이 0~60 조건을 또 쓸 필요가 없습니다.
        grade = 'F'; 
    }
    
    return grade;
}
	 
	 
	 
	 */
	
	
	
	
	
	
	
	
	
	
	
}

public class TestScore {

	public static void main(String[] args) {
		
		Score score1 = new Score (1,"사나",70,80,90);
		System.out.println(score1.toString());  //score1 넣어도 동일하게 값이 나옴. 같은말 
		
		                             //총점을 계산하는 함수를 만든 것 
		System.out.println("총점:" + score1.calctot());
		
		                             // 평균을 계산하는 함수를 만든 것
		System.out.println("평균:" + score1.calcAvg());
		
		System.out.println("학점:" + score1.calcGrade());
		
		
		// 5,원영,90,90,89
		Score score2 = new Score ();
		score2.setNum(5);  // score2.num=5 은 private라서 접근 불가
		score2.setName("원영");
		score2.setKor(90);
		score2.setEng(90);
		score2.setMat(89); 
		score2.calctot();
		score2.calcGrade();
		
		System.out.println(score2);
		//출력 : 번호, 이름, 국어, 영어, 수학, 총점, 평균, 등급 
	    //num,  name,  kor,  eng,  mat,  tot, avg,  grade
		
		System.out.println("번호,이름,국어,영어,수학,총점,평균,등급");
		System.out.printf("%d %s %d %d %d %d %.3f %c", 
				score2.getNum(), score2.getName(), score2.getKor(), score2.getEng(), score2.getMat(),score2.calctot(),score2.getAvg(),score2.getGrade());
	}

}









