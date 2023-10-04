import java.util.Scanner;
public class Assignment2{
	public static void main(String[]args){
		//第一題
		Scanner input = new Scanner(System.in);
		int inputNumber = input.nextInt();

		//處理輸入值不是三位數的情況
		if(inputNumber<100 && inputNumber>=10){
			inputNumber = inputNumber*10;
		}else if(inputNumber < 10){
			inputNumber = inputNumber*100;
		}

		while(inputNumber != 495){

			//取出輸入值的百位數、十位數、個位數
			int hundreds = inputNumber/100;
			int tens = (inputNumber - (inputNumber/100) *100) /10;
			int units = inputNumber - (inputNumber/100) *100 - ((inputNumber - (inputNumber/100) *100) /10) *10;

			//比較百位數、十位數、個位數數字的大小
			int max = hundreds, mid = tens, min = units;
	      	int temp1 = 0, temp2 = 0;
	      	if(max <= mid) {
	    	  max=tens;
	    	  mid=hundreds;
	      	}
	      	if(min>=max) {
	    	  temp1=max;
	    	  temp2=mid;
	    	  max=units;
	    	  mid=temp1;
	    	  min=temp2;
	      	}
	      	if(min<max && min>=mid) {
	    	  temp1=mid;
	    	  mid=min;
	    	  min=temp1;
	      	}

	      	//計算出下一個數字
			inputNumber = (max*100 + mid*10 + min) - (min*100 + mid*10 + max);

			//處理輸出格式
			if(inputNumber == 495){
				System.out.printf("%d",inputNumber);
			}else{
				System.out.printf("%d,",inputNumber);
			}
		}
		System.out.println();

		//第二題
		int bounndaryCount = input.nextInt();//級距個數
		int buy = input.nextInt();//需購買的公斤數
		int sum = 0;//總金額
		int boundary = 0;//級距
		int previousBoundary = 0;//上一個級距

		//輸入級距跟級距單價，並計算總金額
		for(int i=0; i<bounndaryCount; i++){
			previousBoundary = boundary;
			boundary = input.nextInt();
			int money = input.nextInt();//該級距的單價

			//計算總金額
			if(buy >= boundary){
				sum = sum + (boundary-previousBoundary)*money;
			}else if(buy > previousBoundary && buy < boundary){
				sum = sum + (buy-previousBoundary) *money;
			}
		}
		System.out.print(sum);
		input.close();
	}
}
