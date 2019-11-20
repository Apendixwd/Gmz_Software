package application;

import java.util.Arrays;

public class AnalyseRegression {
	
	MainWindowController Controller = new MainWindowController();
			
	
	//Arrays für xy , xx , Ln(y) und XLn(y) werden erstellt
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
		
		//Konstanten m und n der Linearfunktion werden berechnent
		public double [] AnalyseLinear () {
				double Avgx = Arrays.stream(Controller.x).average().orElse(Double.NaN);
				double Avgy = Arrays.stream(Controller.y).average().orElse(Double.NaN);
				double Avgxy = Arrays.stream(getXY(Controller.x,Controller.y)).average().orElse(Double.NaN);
				double Avgxx = Arrays.stream(getXX(Controller.x)).average().orElse(Double.NaN);
				
				double Zähler = Avgxy - Avgx * Avgy;
				double Nenner = Avgxx - Avgx * Avgx;
				double m = Zähler / Nenner;
				double n = Avgy - m * Avgx;
				
				double [] Result = {m,n};
			
			return Result;
}
		//Konstanten k und d der Exponentialfunktion werden berechnet
		public double [] AnalyseExponential () {
				double Avgx = Arrays.stream(Controller.x).average().orElse(Double.NaN);
				double AvgLny = Arrays.stream(getLnY(Controller.y)).average().orElse(Double.NaN);
				double AvgxLny = Arrays.stream(getXLnY(Controller.x,Controller.y)).average().orElse(Double.NaN);
				double Avgxx = Arrays.stream(getXX(Controller.x)).average().orElse(Double.NaN);
			
				double Zähler = AvgxLny - AvgLny * Avgx;
				double Nenner = Avgxx - Avgx * Avgx;
				double e = 2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264800168477411853742345442437107539077744992069;
				double k = Zähler / Nenner;
				double d = Math.pow(e, AvgLny - k * Avgx);
			
				double [] Result = {k,d};

		
			return Result;
			
		}

	
}