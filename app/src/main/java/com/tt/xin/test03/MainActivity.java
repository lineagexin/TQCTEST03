package com.tt.xin.test03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int systemA, systemB, systemC;
    private String strA, strB, strC, resault;
    View btn;
    EditText edt;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        getNum();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myA, myB, myC;
                int a = 0;
                int b = 0;

                myA = edt.getText().toString().substring(0, 1);
                myB = edt.getText().toString().substring(1, 2);
                myC = edt.getText().toString().substring(2, 3);
                if (myA.equals(myB) || myB.equals(myC) || myC.equals(myA)) {
                    resault="輸入錯誤,請輸入三個不重複的數字";
                    tv.setText(resault);
                    edt.setText("");
                } else {
                    if (myA.equals(strA) && myB.equals(strB)
                            && myC.equals(strC)) {
                        tv.setText("Input的數字:" + myA + myB + myC
                                + "  恭喜你答對囉~答案 : " + strA + strB + strC);
                    } else {
                        if (myA.equals(strA)) {
                            a += 1;
                        } else if (myA.equals(strB)) {
                            b += 1;
                        } else if (myA.equals(strC)) {
                            b += 1;
                        }
                        if (myB.equals(strB)) {
                            a += 1;
                        } else if (myB.equals(strA)) {
                            b += 1;
                        } else if (myB.equals(strC)) {
                            b += 1;
                        }
                        if (myC.equals(strC)) {
                            a += 1;
                        } else if (myC.equals(strA)) {
                            b += 1;
                        } else if (myC.equals(strB)) {
                            b += 1;
                        }
                        resault = "Input的數字:" + myA + myB + myC + "=" + a + "A"+ b + "B";
                        tv.setText(resault);
                        edt.setText("");
                    }
                }
            }

        });
    }

    private void getNum() {
        systemA = (int) (Math.random() * 10);
        systemB = (int) (Math.random() * 10);
        systemC = (int) (Math.random() * 10);
        if (systemB == systemA) {
            systemB = (int) (Math.random() * 10);
        }
        if (systemC == systemB || systemC == systemA) {
            systemC = (int) (Math.random() * 10);
        }
        strA = String.valueOf(systemA);
        strB = String.valueOf(systemB);
        strC = String.valueOf(systemC);
    }


    private void findview() {
        btn=findViewById(R.id.button);
        edt= (EditText) findViewById(R.id.editText);
        tv= (TextView) findViewById(R.id.textView);
    }
}
