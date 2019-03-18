package triangleproblem;

//import java.util.*;

public class TriangleProblem {
	
	public boolean Judge(int x)
	{
		if (x > 83) return false;
		if (x < 0) return false;
		if (x >= 50) x -= 50;
		if (x >= 20) x -= 20;
		if (x > 13) return false;
		if (x % 5 == 4) return false;
		return true;
	}
	
	/*
	public static void main(String[] args){
		Scanner cin= new Scanner(System.in);
		int x = cin.nextInt();
		cin.close();
		
		if (testMoney(x))
			System.out.println("YES\n");
		else
			System.out.println("NO\n");
	}
	*/
}
