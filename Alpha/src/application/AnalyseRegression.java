package application;

import java.util.Arrays;

public class AnalyseRegression {
	
	int [] x = {1,2,3,4,5,6,7};
	double [] y = {0.38,1.15,2.71,3.92,5.93,8.56,11.24};
	
	MainWindowController Controller = new MainWindowController();
	
	
		private double [] getXY(int [] x, double [] y) {
		
				int count = 0;
				double xy [] = new double[Controller.countX];
			
					while (count < x.length) {
				
						xy [count] = y [count] * x[count];
						count ++;	
				}
				
				return xy;
		}
	
	
		private double[] getXX(int [] x) {
		
			int count = 0;
			double xx [] = new double[Controller.countX];
		
				while (count < x.length) {
			
					xx [count] = x [count] * x[count];
					count ++;
			
				}
			return xx;
		}
		
		private double[] getLnY(double [] y) {
			
			int count = 0;
			double LnY [] = new double[Controller.countX];
		
				while (count < y.length) {
			
					LnY [count] = Math.log(y [count]);
					count ++;
			
				}
			return LnY;
		}
		
		public double[] getXLnY(int [] x,double [] y) {
			
			int count = 0;
			double XLnY [] = new double[Controller.countX];
		
			while (count < y.length) {
			
				XLnY [count] = Math.log(y [count]) * x [count];
					count ++;
			
				}
			return XLnY;
		}
		
		
		public double AnalyseLinear () {
				double Avgx = Arrays.stream(x).average().orElse(Double.NaN);
				double Avgy = Arrays.stream(y).average().orElse(Double.NaN);
				double Avgxy = Arrays.stream(getXY(x,y)).average().orElse(Double.NaN);
				double Avgxx = Arrays.stream(getXX(x)).average().orElse(Double.NaN);
				
				double Zähler = Avgxy - Avgx * Avgy;
				double Nenner = Avgxx - Avgx * Avgx;
				double m = Zähler / Nenner;
				
				System.out.println(m);
			
			return m;
}

	
}