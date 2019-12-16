package application;

import java.util.Arrays;

public class AnalyseRegression {
	
	//Arrays für xy , xx , Ln(y) und XLn(y) werden erstellt
		private double [] getXY(int [] x, double [] y,int countX) {
		
				int count = 0;
				double xy [] = new double[countX];
			
					while (count < x.length) {
				
						xy [count] = y [count] * x[count];
						count ++;	
				}
				
				return xy;
		}
	
	
		private double[] getXX(int [] x, int countX) {
		
			int count = 0;
			double xx [] = new double[countX];
		
				while (count < x.length) {
			
					xx [count] = x [count] * x[count];
					count ++;
			
				}
			return xx;
		}
		
		private double[] getLnY(double [] y, int countX) {
			
			int count = 0;
			double LnY [] = new double[countX];
		
				while (count < y.length) {
			
					LnY [count] = Math.log(y [count]);
					count ++;
			
				}
			return LnY;
		}
		
		public double[] getXLnY(int [] x,double [] y, int countX) {
			
			int count = 0;
			double XLnY [] = new double[countX];
		
			while (count < y.length) {
			
				XLnY [count] = Math.log(y [count]) * x [count];
					count ++;
			
				}
			return XLnY;
		}
		
		//Konstanten m und n der Linearfunktion werden berechnent
		public double [] AnalyseLinear (int [] x, double [] y, int countX) {
				double Avgx = Arrays.stream(x).average().orElse(Double.NaN);
				double Avgy = Arrays.stream(y).average().orElse(Double.NaN);
				double Avgxy = Arrays.stream(getXY(x,y,countX)).average().orElse(Double.NaN);
				double Avgxx = Arrays.stream(getXX(x,countX)).average().orElse(Double.NaN);
				
				double Zähler = Avgxy - Avgx * Avgy;
				double Nenner = Avgxx - Avgx * Avgx;
				double m = Zähler / Nenner;
				double n = Avgy - m * Avgx;
				
				double [] Result = {m,n};
			
			return Result;
}
		//Konstanten k und d der Exponentialfunktion werden berechnet
		public double [] AnalyseExponential (int [] x, double [] y, int countX) {
				double Avgx = Arrays.stream(x).average().orElse(Double.NaN);
				double AvgLny = Arrays.stream(getLnY(y, countX)).average().orElse(Double.NaN);
				double AvgxLny = Arrays.stream(getXLnY(x,y,countX)).average().orElse(Double.NaN);
				double Avgxx = Arrays.stream(getXX(x,countX)).average().orElse(Double.NaN);
			
				double Zähler = AvgxLny - AvgLny * Avgx;
				double Nenner = Avgxx - Avgx * Avgx;
				double e = 2.718281828459045235360287471352662497757247093699959574966967627724076630353547594571382178525166427427466391932003059921817413596629043572900334295260595630738132328627943490763233829880753195251019011573834187930702154089149934884167509244761460668082264800168477411853742345442437107539077744992069;
				double k = Zähler / Nenner;
				double d = Math.pow(e, AvgLny - k * Avgx);
			
				double [] Result = {k,d};

		
			return Result;
			
		}

	
}