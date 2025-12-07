package bulanik1;

import java.net.URISyntaxException;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Program {
    public static void main(String[] args) throws URISyntaxException {
        Scanner in = new Scanner(System.in);

        System.out.print("g Kuvveti (-1g - +4g): ");
        double g = in.nextDouble();

        System.out.print("Agirlik (600 - 11000 Kg): ");
        double agirlik = in.nextDouble();

        System.out.print("Rotor Acisal Hizi (360 - 410 RPM): ");
        double rotor = in.nextDouble();

        Helikopter helikopter = new Helikopter(g, agirlik, rotor);
        System.out.println(helikopter);

        // GUI thread üzerinde grafiği aç
        JFuzzyChart.get().chart(helikopter.getModel().getFunctionBlock("Helikopter"));
    
        JFuzzyChart.get().chart(helikopter.getModel().getVariable("HavadaKalma").getDefuzzifier(),"Havada Kalma Durumu", true);
		for(Rule r : helikopter.getModel().getFunctionBlock("Helikopter").getFuzzyRuleBlock("Kurallar").getRules()){
			if(r.getDegreeOfSupport() > 0)
				System.out.println(r);
		}

        in.close();
    }
}