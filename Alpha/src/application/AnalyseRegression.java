package application;

public class AnalyseRegression {
	
	MainWindowController Controller = new MainWindowController();
	
	
		private double [] getXY(double [] arrayy, int [] x) {
		
				int count = 0;
				double xy [] = new double[Controller.countX];
			
					while (count < x.length) {
				
						xy [count] = arrayy [count] * x[count];
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
		
		private double[] getXLnY(double [] y,int [] x) {
			
			int count = 0;
			double XLnY [] = new double[Controller.countX];
		
			while (count < y.length) {
			
				XLnY [count] = Math.log(y [count]) * x [count];
					count ++;
			
				}
			return XLnY;
		}
		
		
		public double analyse (double [] arrayy, int[] x) {
		
			return 0;
}

	
}