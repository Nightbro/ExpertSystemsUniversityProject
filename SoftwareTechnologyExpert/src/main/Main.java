package main;

import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Main {

	public static void main(String[] args) {
		FIS fis = FIS.load("rules/rules.fcl");
		
		if (fis == null) {
			System.out.println("Something went wrong");
			return;
		}
		
		Scanner scanner = new Scanner(System.in);
		JFuzzyChart.get().chart(fis);
		
        // Read input values from the user
        System.out.print("What is your previous development experience (1 (i dont know anything about programing) - 100(I develop for more then 10 years)): ");
        double relevantExperience = scanner.nextDouble();

       
		fis.setVariable("relevant_experience", relevantExperience);
		
		fis.evaluate();
		
		System.out.println("Python suggestion: " + fis.getVariable("python").defuzzify());
		
        scanner.close();
	}

}
