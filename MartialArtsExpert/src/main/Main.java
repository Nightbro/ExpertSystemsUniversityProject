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
        System.out.print("Enter the physical fitness level (1-100): ");
        double physicalFitness = scanner.nextDouble();

        System.out.print("Enter the preferred combat style (1-5 (1 striking, 5: grapling) :");
        double combatStyle = scanner.nextDouble();

        System.out.print("How is your self defence? (from 1 to 100): ");
        double selfDefense = scanner.nextDouble();

        System.out.print("How competitive you are (from 1 to 100): ");
        double competitionLevel = scanner.nextDouble();
        
		
		
		fis.setVariable("physical_fitness", physicalFitness);
		fis.setVariable("combat_style", combatStyle);
		fis.setVariable("self_defense", selfDefense);
		fis.setVariable("competition_level", competitionLevel);
		
		fis.evaluate();
		
		System.out.println("Martial Art Suggestion: " + fis.getVariable("martial_art").defuzzify());
		
		
		
		//for(Rule r: 
			//fis.getFunctionBlock("martial_art")
			//.getFuzzyRuleBlock("martial_art_rules").getRules())
			//System.out.println(r);
		
		
        // Clean up resources
        scanner.close();
	}

}
