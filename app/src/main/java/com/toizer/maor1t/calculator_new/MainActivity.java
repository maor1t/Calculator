package com.toizer.maor1t.calculator_new;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {



    private EditText et;
    private int NumberBf;
    private String Operation;
    private BtnClickListener btnclick ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et =(EditText)findViewById(R.id.editText);

        int idbtns[] = {R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.minus,R.id.plus,R.id.Double,R.id.divide,R.id.clear,R.id.equals};

        btnclick = new BtnClickListener();

        for(int id:idbtns){
            View v =(View)findViewById(id);
            v.setOnClickListener(btnclick);

        }

    }
public void mMath(String str){
    NumberBf = Integer.parseInt(et.getText().toString());
    Operation =str;
    et.setText("");

}

    public void getKeyboard(String str){
       String currentET = et.getText().toString();
        currentET += str;
        et.setText(currentET);
    }

    public void   mResult(){
        float NumF = Float.parseFloat(et.getText().toString());
        float result =0;
        if(Operation.equals("+")){
            result = NumF + NumberBf;
        }

        if(Operation.equals("-")){
            result = NumF - NumberBf;
        }

        if(Operation.equals("*")){
            result = NumF * NumberBf;
        }

        if(Operation.equals("/")){
            result = NumF / NumberBf;
        }
        et.setText(String.valueOf(result));
    }


    private class BtnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            try{
                switch (v.getId()){

                    case R.id.clear:
                        et.setText("");
                        NumberBf = 0;
                        Operation ="";
                        break;

                    case R.id.plus:
                        mMath("+");
                        break;

                    case R.id.minus:
                        mMath("-");
                        break;

                    case R.id.divide:
                        mMath("/");
                        break;

                    case R.id.Double:
                        mMath("*");

                        break;

                    case R.id.equals:
                        mResult();
                        break;
                    default:
                        String number =((Button) v).getText().toString();
                        getKeyboard(number);
                        break;
                }

                }catch (Exception e){

            }

            }

    }
}



