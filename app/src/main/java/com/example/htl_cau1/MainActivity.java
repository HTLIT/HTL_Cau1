package com.example.htl_cau1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btntinh, btnclr;
    EditText soa, sob, soc;
    TextView kqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        addEvent();
    }

    private void Anhxa() {
        soa = (EditText) findViewById(R.id.a_edittext);
        sob = (EditText) findViewById(R.id.b_edittext);
        soc = (EditText) findViewById(R.id.c_edittext);
        btntinh = (Button) findViewById(R.id.btn_xuat);
        btnclr = (Button) findViewById(R.id.btn_clr);
        kqua = (TextView) findViewById(R.id.kq_text);
        soa.setError("Vui lòng nhập vào số a ");
        sob.setError("Vui lòng nhập vào số b ");
        soc.setError("Vui lòng nhập vào số c ");
    }

    private void addEvent() {
        btntinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float kq;
                int a = Integer.parseInt(soa.getText().toString());
                int b = Integer.parseInt(sob.getText().toString());
                int c = Integer.parseInt(soc.getText().toString());

                    if (a == 0) {
                        if (b == 0) {
                            kqua.setText("Phương trình vô nghiệm");
                        } else {
                            kqua.setText("Phương trình có một nghiệm: "
                                    + "x = " + (-c / b));
                        }
                        return;
                    }
                    // tính delta
                    float delta = b * b - 4 * a * c;
                    float x1;
                    float x2;
                    // tính nghiệm
                    if (delta > 0) {
                        x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                        x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                        kqua.setText("Phương trình có 2 nghiệm là: "
                                + "x1 = " + x1 + " và x2 = " + x2);
                    } else if (delta == 0) {
                        x1 = (-b / (2 * a));
                        kqua.setText("Phương trình có nghiệm kép: "
                                + "x1 = x2 = " + x1);
                    } else {
                        kqua.setText("Phương trình vô nghiệm!");
                    }
                }



        });
        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soa.setText("");
                sob.setText("");
                soc.setText("");
                kqua.setText("");
                
            }
        });

    }
}
