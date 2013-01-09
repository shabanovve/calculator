package com.example.calculator2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, Const {

	private Button[] buttons;// Grouping all buttons in array
	private TextView display;
	private Controller contr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
		contr = new Controller();
	}

	private void initViews() {
		buttons = new Button[BUTTONSAMOUNT];
		buttons[ZERO] = (Button) findViewById(R.id.buttonZero);
		buttons[ONE] = (Button) findViewById(R.id.buttonOne);
		buttons[TWO] = (Button) findViewById(R.id.buttonTwo);
		buttons[THREE] = (Button) findViewById(R.id.buttonThree);
		buttons[FOUR] = (Button) findViewById(R.id.buttonFour);
		buttons[FIVE] = (Button) findViewById(R.id.buttonFive);
		buttons[SIX] = (Button) findViewById(R.id.buttonSix);
		buttons[SEVEN] = (Button) findViewById(R.id.buttonSeven);
		buttons[EIGHT] = (Button) findViewById(R.id.buttonEight);
		buttons[NINE] = (Button) findViewById(R.id.buttonNine);
		buttons[POINT] = (Button) findViewById(R.id.buttonPoint);
		buttons[EQUAL] = (Button) findViewById(R.id.buttonEquals);
		buttons[DIVIDE] = (Button) findViewById(R.id.buttonDivide);
		buttons[MULTIPLY] = (Button) findViewById(R.id.buttonMultiply);
		buttons[PLUS] = (Button) findViewById(R.id.buttonPlus);
		buttons[MINUS] = (Button) findViewById(R.id.buttonMinus);
		buttons[RESET] = (Button) findViewById(R.id.buttonReset);
		display = (TextView) findViewById(R.id.textView1);
		for (int i = 0; i < BUTTONSAMOUNT; i++) {
			buttons[i].setOnClickListener(this);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		int buttonIndex = IndexOfPressedButton(v);

		if (ZERO <= buttonIndex && buttonIndex <= NINE) {// number is dialing
			double d = contr.inputFigure(buttonIndex);
			display.setText(new Double(d).toString());
		}

		if (DIVIDE <= buttonIndex && buttonIndex <= MINUS) {// operation defined
			contr.setOperation(buttonIndex);
		}

		switch (buttonIndex) {
		case POINT:
			contr.inputPoint();
			break;

		case EQUAL: {
			double d = contr.endInput();
			display.setText(new Double(d).toString());
		}
			break;
			
		case RESET:{
			contr.reset();
			display.setText(""+ZERO);
			
		}
			break;

		}
		


	}

	private int IndexOfPressedButton(View v) {
		int index = 0;
		for (int i = 0; i < BUTTONSAMOUNT; i++) {
			if (v == buttons[i]) {
				index = i;
			}
		}
		return index;
	}

}
