// 201720708 신재훈
package project;
import java.util.Scanner;

@SuppressWarnings("serial")
class ArithmeticException extends Exception{     // 0으로 나누려고 할 때 Arithmetic Exception is received 라고 출력함
	private String reason = "Arithmetic Exception";
	ArithmeticException(){
		System.out.println("0으로 나눌 수 없습니다.");
		System.out.println(reason + " is received.");
	}
}

@SuppressWarnings("serial")
class ArrayIndexOutOfBoundsException extends Exception{    // 선언한 배열의 크기보다 큰 원소를 접근하면 NegativeIndexOutOfBoundsException is received 라고 출력함
	private String reason = "ArrayIndexOutOfBoundsException";
	ArrayIndexOutOfBoundsException(){
		System.out.println(reason + " is received.");
	}
}

@SuppressWarnings("serial")
class NegativeArraySizeException extends Exception{   // 배열의 크기가 음수로 된 경우에 NegativeArraySizeException is received를 출력함
	private String reason = "NegativeArraySizeException";
	NegativeArraySizeException(){
		System.out.println(reason + " is received.");
	}
}

@SuppressWarnings("serial")
class NullPointerException extends Exception{  // 생성되는 않은 배열을 호출해서 객체의 멤버를 접근하는 경우 NullpointerException is received라고 출력함
	private String reason = "NullpointerException";
	NullPointerException(){
		System.out.println(reason + " is received.");
	}
}

@SuppressWarnings("serial")
class InputMismatchException extends Exception{     // 나누려는 값이 정수가 아니라 문자면 InputMismatchException is received 라고 출력함
	private String reason = "InputMismatchException";
	InputMismatchException(){
		System.out.println(reason + " is received.");
	}
}



class Calculation{
	int input_num, num, index_number, total;  // 변수 선언
	
	void totalGrade() {
		Scanner scan = new Scanner(System.in); 
		
		
		try {  // try catch문을 이용하여 예외 발생시 처리
			while(true) {

				System.out.println("배열의 크기를 입력하세요.");  // 사용자로부터 배열의 크기를 직접 입력받음
				input_num = scan.nextInt();
				
				
				if(input_num < 0) { // 배열의 크기가 음수일 때 예외 처리
					throw new NegativeArraySizeException();
				}
				
				int[] arr = new int[input_num];  // 사용자로부터 입력 받은 값으로부터 배열의 크기가 결정됨
				
				for(int i=0; i < arr.length; i++) {  // for 문을 이용하여 사용자로부터 배열에 저장할 값들을 입력받아 배열에 저장
					System.out.println("배열에 저장할 숫자를 입력하세요.");
					arr[i] = scan.nextInt();
				}
				

				System.out.println("나누기를 할 숫자를 입력하세요.");  // 나누기를 할 값을 사용자로부터 입력받음
				while (!scan.hasNextInt()) {    // 나누는 값이 숫자가 아닌 경우 에러 처리를 하고 다시 입력 받도록 함.
		            scan.next();
		            new InputMismatchException();
		            System.out.println("문자는 입력할 수 없습니다.");
		            System.out.println("total 값은 " + total + "입니다.");
				}
				num = scan.nextInt();
				
				
				System.out.println("나눌 숫자의 인덱스 값을 입력하세요.");  // 나눌숫자의 배열의 인덱스값을 입력받음
				index_number = scan.nextInt();

				
				if(input_num < 1) {  // 만약 배열이 1이하로 선언되고 객체의 멤버를 접근하려 한다면 널포인터 에러 처리
					throw new NullPointerException();
				}
				
				if (index_number > input_num) { // 선언한 배열의 크기보다 큰 원소를 접근하면 NegativeIndexOutOfBoundsException 처리
					throw new ArrayIndexOutOfBoundsException();
				}
				

				if(num == 0) {  // 만약 나누는 값이 0이라면 ArithmeticException 처리
					throw new ArithmeticException();
				}

				total = (arr[index_number]/num);  // 최종 나누기를 한 값 
				System.out.println("total 값은 " + total + "입니다.");
			}
		}  // 위에서 언급한 예외 처리문
		catch(ArithmeticException x){  
			System.out.println(x);
			System.out.println("total 값은 " + total + "입니다.");
		}
		catch(ArrayIndexOutOfBoundsException x){
			System.out.println(x);
			System.out.println("total 값은 " + total + "입니다.");
		}
		catch(NegativeArraySizeException x){
			System.out.println(x);
			System.out.println("total 값은 " + total + "입니다.");
		}
		catch(NullPointerException x) {
			System.out.println(x);
			System.out.println("total 값은 " + total + "입니다.");
		}
	}
}



public class project {
	public static void main(String[] args) {
		Calculation calculation = new Calculation();
		calculation.totalGrade();
	}
}
