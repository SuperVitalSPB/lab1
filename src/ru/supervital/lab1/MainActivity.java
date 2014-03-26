package ru.supervital.lab1;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {

	Button btnGo1;
	Button btnGo2;
	EditText txtDec;
	TextView lblResultDec;
	EditText txtStr;
	TextView lblResultStr;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Убираем верхнюю панель с названием приложения
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		
        // Переходим в режим FULLSCREEN
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
		
		
		btnGo1 = (Button) findViewById(R.id.btnGo1);
		btnGo2 = (Button) findViewById(R.id.btnGo2);
		txtDec = (EditText) findViewById(R.id.txtDec);
		lblResultDec = (TextView) findViewById(R.id.lblResultBi);
		txtStr = (EditText) findViewById(R.id.txtStr);
		lblResultStr = (TextView) findViewById(R.id.lblResultStr);
		
		btnGo1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				btnGo1Click();
			}
		});
		

		btnGo2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				btnGo2Click();
			}
		});
		
		txtDec.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if( event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
					btnGo1Click();
					return true;
				}
				return false;			
			}
		});
		
		txtStr.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if( event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
					btnGo2Click();
					return true;
				}
				return false;			
			}
		});
	}

	public void btnGo1Click(){
		String sStr = txtDec.getText().toString();
		if (!sStr.equals(""))
			sStr = getCovertDecToBi(Integer.parseInt(sStr));
		lblResultDec.setText(sStr);
		txtDec.requestFocus();		
	};

	public void btnGo2Click(){
		String sStr = getModifyString(txtStr.getText().toString());
		lblResultStr.setText(sStr);
		txtStr.requestFocus();
	};
	
	public String getCovertDecToBi(Integer aDec){
		String sBuf = "";
		int i = aDec;
		if (i==0) sBuf = "0";
		else {
			while (i>=1) {
				if (i==1) {
					sBuf = sBuf + "1";
					break;
				} if (i % 2 == 0)
					sBuf = sBuf + "0";
				else
					sBuf = sBuf + "1";
				i = i / 2;
			}
		}
	    String res = new StringBuilder(sBuf).reverse().toString();
		return res;
	}
	
	public String getModifyString(String aStr){
		if (aStr.length()==0) return "";
		String res = "";
		res = res + aStr.charAt(0);
		for (int i = 1; i<aStr.length(); i++) {
			char rc = res.charAt(res.length()-1);
			char s = aStr.charAt(i);
			if (rc != s ) 
				res = res + s;
		}
		return res;
	}
	
}
