package com.kondal.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// is line ko humlog activity khte kyuki jo java file hai
        // wo xml file se add ho jati hai
        // in class it contain variable, methods, object and logic except you should not found anythings
        // in the java class
        // yha pe java mm yhi chij allow hai to hmm kya krenge akk variable lenge aur jo particular id
        // ka refrence hai wo iss particular variable mm replace krdunga takki mai iss variable ke upper jitne
        // bhi action perform kru wo sare runtime kmm execute ho jaye
        // aur kis type ka variable lenna ji type ki id le rkhi hai humlogo nn isse hmm object bhi khh skte hai




        // jitne bhi view (chijhe) hmne use kri thi xml mm aur hmm runtime mm jroort pregi usko hmne variable bna liya hai

        EditText editWeight = findViewById(R.id.editWeight);
        EditText editHeightFt = findViewById(R.id.editHeight);
        EditText editHeightIN = findViewById(R.id.editHeightIN);
        AppCompatButton btncalculate = findViewById(R.id.btnCalculate);
        TextView txtResult = findViewById(R.id.textResult);
        LinearLayout llmain = findViewById(R.id.LinM);

        // sbse phla kam kya krna hai humko button ko onclick bnana hai
        // hoga kya runtime mm user sbse phle value dalega aur button pe click krega tbb hi hmmm logic
        // implement krna hogga
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // sbse phle value lenna sikhna hai
                // value kha se lenna hai edittext mm se oo kaise lenge
             int wt=  Integer.parseInt(editWeight.getText().toString()) ;// we get value in text formate not in number so we need to convert into integer
                // so we can't convert direct first we need to convert into string use.toString
             int ft= Integer.parseInt(editHeightFt.getText().toString());
             int In =Integer.parseInt(editHeightIN.getText().toString());
             // abb kya krna hai isko bmi ka formula mm place krna hai
                int totalIn = ft*12 + In; // to convert ft into inches and add it to inches got total inches
                // abb isko metre mm chahiye sbse phle centimetre mmm convert krna prega
                double totaLCm = totalIn *2.53;// yha int mm error dega kyuki float mm hogga wo bhi error
                // dega kyuki agr point ke bat 3-4 digit rha t0 better hogga nn
              double totalM = totaLCm/100;

              double BMI = wt/(totalM *totalM);
              if (BMI>25){
                  txtResult.setText("you are overweight");
               llmain.setBackground(getResources().getDrawable(R.color.overweight));
              }
              else if (BMI<18){
                  txtResult.setText("you are underWeigth");

                  llmain.setBackground(getResources().getDrawable(R.color.underweight));
              }
              else{
                  txtResult.setText("congratulation you are healthy person kindly maintain your diet");
                  llmain.setBackground(getResources().getDrawable(R.color.healthy));
              }

            }
        });


    }
}