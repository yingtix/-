package triangleproblem;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

@RunWith(Parameterized.class)

public class TriangleProblemTest {
	
	Boolean answer;
	int input;
	
	@Parameters
	public static Collection<Object[]> initTestData(){
		Collection<Object[]> a = new ArrayList<>();
		
		for(int i=0; i<100; i++) {
			Integer[] b = {1, i};
			int temp = i;
			if (temp >= 70) temp -= 70;
			else if (temp >= 50) temp -= 50;
			else if (temp >= 20) temp -= 20;
			if (temp > 13 || temp % 5 == 4)
				b[0] = 0;
			a.add(b);
		}

		return a;
	}
	
	public TriangleProblemTest(int output, int input)
	{
		if(output == 1) this.answer = true; else this.answer = false;
		this.input = input;
	}
	@Test
	//≤‚ ‘judge∑Ω∑®
	public void testJudge() {
		Assert.assertEquals(answer, new TriangleProblem().Judge(input));
	}
}
