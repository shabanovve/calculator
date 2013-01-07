package com.example.calculator2;

public class Controller {
	private double[] number;//inputed number
	private int integerPart=0;
	private double divisionalPart=0;
	private double digit = 0.1;

	private int indexOfNumber=0;
	private int operation=0;
	private Model model;
	private boolean pointPressed = false;
	
	

	public Controller() {
		number = new double[2];
		for(int i=0;i<number.length;i++){
			
		}
		model= new Model();
	}

	public double inputFigure(int buttonIndex) {
		if (!pointPressed){
			integerPart=integerPart*10+buttonIndex;
		}else{
			divisionalPart=divisionalPart+buttonIndex*digit;
			digit=digit/10;
		}
		number[indexOfNumber]=integerPart+divisionalPart;
		return number[indexOfNumber];
	}

	public void inputPoint() {
		pointPressed = true;		
	}

	public void setOperation(int buttonIndex) {
		this.operation=buttonIndex;
		indexOfNumber=1;
		integerPart=0;
		divisionalPart=0;
		digit=0.1;
	}

	public double endInput() {
		double d = model.calculation(number, operation);
		number[0]=d;
		return d;
	}

	public void reset() {
		number[0]=0;
		number[1]=0;
		integerPart=0;
		divisionalPart=0;
		digit = 0.1;
		operation=0;
		indexOfNumber=0;
		pointPressed=false;
		
	}

}
