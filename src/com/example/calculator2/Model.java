package com.example.calculator2;

public class Model implements Const {

	public double calculation(double[] number, int operation) {
		double result = 0;
		switch (operation) {
		case MULTIPLY:
			result=number[0]*number[1];
			break;
			
		case DIVIDE:
			if(number[1]!=0) result=number[0]/number[1];
			break;
			
		case PLUS:
			result=number[0]+number[1];
			break;
			
		case MINUS:
			result=number[0]-number[1];
			break;

		}
		return result; 
	}
	
}
