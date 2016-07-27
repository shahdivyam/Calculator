package com.example.divyamshah15.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myCalculator";

    private EditText etVarOne,etVarTwo;

    private TextView tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
    private TextView tvClear,tvEqual,tvAdd,tvSub,tvMul,tvDiv,tvOp;
    private TextView tvAnswer, tvDelete;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVarOne = (EditText) findViewById(R.id.et_1);
        etVarTwo = (EditText) findViewById(R.id.et_2);

        tv0 = (TextView) findViewById(R.id.tv_0);
        tv1 = (TextView) findViewById(R.id.tv_1);
        tv2 = (TextView) findViewById(R.id.tv_2);
        tv3 = (TextView) findViewById(R.id.tv_3);
        tv4 = (TextView) findViewById(R.id.tv_4);
        tv5 = (TextView) findViewById(R.id.tv_5);
        tv6 = (TextView) findViewById(R.id.tv_6);
        tv7 = (TextView) findViewById(R.id.tv_7);
        tv8 = (TextView) findViewById(R.id.tv_8);
        tv9 = (TextView) findViewById(R.id.tv_9);

        tvOp = (TextView) findViewById(R.id.tv_op);
        tvClear = (TextView) findViewById(R.id.tv_clear);
        tvAnswer = (TextView) findViewById(R.id.tv_answer);
        tvEqual = (TextView) findViewById(R.id.tv_equal);
        tvAdd = (TextView) findViewById(R.id.tv_plus);
        tvSub = (TextView) findViewById(R.id.tv_minus);
        tvMul =(TextView) findViewById(R.id.tv_mul);
        tvDiv =(TextView) findViewById(R.id.tv_div);

        tvDelete = (TextView) findViewById(R.id.tv_del);

        View.OnClickListener numberDelete= new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                if(etVarTwo.getText().toString().isEmpty()==true&&etVarOne.getText().toString().isEmpty()==false){
                    String varOne = etVarOne.getText().toString();
                    if(varOne.length()!=0) {
                        varOne = varOne.substring(0, varOne.length() - 1);
                        etVarOne.setText(varOne);
                    }
                }
                else{
                    String varTwo = etVarTwo.getText().toString();

                    varTwo = varTwo.substring(0,varTwo.length()-1);
                    etVarTwo.setText(varTwo);
                }
            }
            catch(IndexOutOfBoundsException e){

            }

            }
        };

        View.OnClickListener numberInput = new View.OnClickListener(){
                public void onClick(View v){
                    if(tvOp.getText().toString().isEmpty()==true){
                        String soFar = etVarOne.getText().toString();
                        String add= "";
                        switch(v.getId()){
                          case R.id.tv_0:
                              add="0";
                              break;
                            case R.id.tv_1:
                                add="1";
                                break;
                            case R.id.tv_2:
                                add="2";
                                break;
                            case R.id.tv_3:
                                add="3";
                                break;
                            case R.id.tv_4:
                                add="4";
                                break;
                            case R.id.tv_5:
                                add="5";
                                break;
                            case R.id.tv_6:
                                add="6";
                                break;
                            case R.id.tv_7:
                                add="7";
                                break;
                            case R.id.tv_8:
                                add="8";
                                break;
                            case R.id.tv_9:
                                add="9";
                                break;

                        }
                        soFar+=add;
                        etVarOne.setText(soFar);
                    }
                    else{
                        String soFar = etVarTwo.getText().toString();
                        String add= "";
                        switch(v.getId()){
                            case R.id.tv_0:
                                add="0";
                                break;
                            case R.id.tv_1:
                                add="1";
                                break;
                            case R.id.tv_2:
                                add="2";
                                break;
                            case R.id.tv_3:
                                add="3";
                                break;
                            case R.id.tv_4:
                                add="4";
                                break;
                            case R.id.tv_5:
                                add="5";
                                break;
                            case R.id.tv_6:
                                add="6";
                                break;
                            case R.id.tv_7:
                                add="7";
                                break;
                            case R.id.tv_8:
                                add="8";
                                break;
                            case R.id.tv_9:
                                add="9";
                                break;

                        }
                        soFar+=add;
                        etVarTwo.setText(soFar);
                        int num1=0,num2=0,num3=0;
                        try {
                             num1 = etVarOne.getText().toString().isEmpty() ? 0 : Integer.parseInt(etVarOne.getText().toString());
                             num3 = 0;
                             num2 = etVarTwo.getText().toString().isEmpty() ? 0 : Integer.parseInt(etVarTwo.getText().toString());
                        }
                        catch(NumberFormatException e){
                            Toast.makeText(MainActivity.this, "Number too large", Toast.LENGTH_SHORT).show();
                        }
                        try{
                            if(tvOp.getText().toString()=="+"){
                                num3 = num1+num2;
                            }
                            if(tvOp.getText().toString()=="-"){
                                num3 = num1-num2;
                            }
                            if(tvOp.getText().toString()=="X"){
                                num3 = num1*num2;
                            }
                            if(tvOp.getText().toString()=="/"){
                                num3 = num1/num2;
                            }
                            tvAnswer.setText(String.valueOf(num3));
                        }
                        catch(ArithmeticException e){
                            Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        }


                    }
                }
        };
        View.OnClickListener clear = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    etVarOne.setText("");
                    etVarTwo.setText("");
                    tvOp.setText("");
                    tvAnswer.setText("");

            }
        };
        View.OnClickListener operations = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etVarOne.getText().toString().isEmpty()==false&&etVarTwo.getText().toString().isEmpty()==false&&tvAnswer.getText().toString().isEmpty()==false){
                    etVarOne.setText(tvAnswer.getText().toString());
                    etVarTwo.setText("");
                }

                if(v.getId()==tvAdd.getId()){
                    tvOp.setText("+");
                }
                else if(v.getId()==tvSub.getId()){
                    tvOp.setText("-");
                }
                else if(v.getId()==tvMul.getId()){
                    tvOp.setText("X");
                }
                else if(v.getId()==tvDiv.getId()){
                    tvOp.setText("/");
                }
            }
        };
        View.OnClickListener equals = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num1=0,num2=0;
                try {
                    if (etVarOne.getText().toString().isEmpty() == false && etVarTwo.getText().toString().isEmpty() == false && tvAnswer.getText().toString().isEmpty() == false) {
                        num1 = Integer.parseInt(tvAnswer.getText().toString());
                        num2 = Integer.parseInt(etVarTwo.getText().toString());
                        etVarOne.setText(String.valueOf(num1));
                    } else {
                        num1 = etVarOne.getText().toString().isEmpty() ? 0 : Integer.parseInt(etVarOne.getText().toString());
                        num2 = etVarTwo.getText().toString().isEmpty() ? 0 : Integer.parseInt(etVarTwo.getText().toString());
                    }
                }
                catch(NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Number too large", Toast.LENGTH_SHORT).show();
                }
                int num3 = 0;
                if(etVarTwo.getText().toString().isEmpty()==true){
                    num3=num1;
                }
                    try{
                    if(tvOp.getText().toString()=="+"){
                        num3 = num1+num2;
                    }
                    if(tvOp.getText().toString()=="-"){
                        num3 = num1-num2;
                    }
                    if(tvOp.getText().toString()=="X"){
                        num3 = num1*num2;
                    }
                    if(tvOp.getText().toString()=="/"){
                        num3 = num1/num2;
                    }
                    tvAnswer.setText(String.valueOf(num3));
                    }
                    catch(ArithmeticException e){
                        Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    }




            }
        };

        tvClear.setOnClickListener(clear);
        tvDelete.setOnClickListener(numberDelete);

        tvAdd.setOnClickListener(operations);
        tvSub.setOnClickListener(operations);
        tvMul.setOnClickListener(operations);
        tvDiv.setOnClickListener(operations);

        tv0.setOnClickListener(numberInput);
        tv1.setOnClickListener(numberInput);
        tv1.setOnClickListener(numberInput);
        tv2.setOnClickListener(numberInput);
        tv3.setOnClickListener(numberInput);
        tv4.setOnClickListener(numberInput);
        tv5.setOnClickListener(numberInput);
        tv6.setOnClickListener(numberInput);
        tv7.setOnClickListener(numberInput);
        tv8.setOnClickListener(numberInput);
        tv9.setOnClickListener(numberInput);

        tvEqual.setOnClickListener(equals);


    }



}
