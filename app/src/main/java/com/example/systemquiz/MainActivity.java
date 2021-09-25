package com.example.systemquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView op1,op2,op3,op4;
    private TextView quesno,ques,score;
    private TextView check1,check2;
    int currIn;
    int mscore=0;
    int qn=1;
    ProgressBar progressBar;
    int currQ,currOpA,currOpB,currOpC,currOpD;

    private ansClass[] qb= new ansClass[]
            {
               new ansClass(R.string.q1,R.string.q1op1,R.string.q1op2,R.string.q1op3,R.string.q1op4,R.string.q1ans),
               new ansClass(R.string.q2,R.string.q2op1,R.string.q2op2,R.string.q2op3,R.string.q2op4,R.string.q2ans),
               new ansClass(R.string.q3,R.string.q3op1,R.string.q3op2,R.string.q3op3,R.string.q3op4,R.string.q4ans),
               new ansClass(R.string.q4,R.string.q4op1,R.string.q4op2,R.string.q4op3,R.string.q4op4,R.string.q4ans),
               new ansClass(R.string.q5,R.string.q5op1,R.string.q5op2,R.string.q5op3,R.string.q5op4,R.string.q5ans),
               new ansClass(R.string.q6,R.string.q6op1,R.string.q6op2,R.string.q6op3,R.string.q6op4,R.string.q6ans),
               new ansClass(R.string.q7,R.string.q7op1,R.string.q7op2,R.string.q7op3,R.string.q7op4,R.string.q7ans),

            };
    final int P_BAR = (int) Math.ceil(100/ qb.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        op1=findViewById(R.id.opa);
        op2=findViewById(R.id.opb);
        op3=findViewById(R.id.opc);
        op4=findViewById(R.id.opd);

        ques= findViewById(R.id.ques);
        score= findViewById(R.id.score);
        quesno=findViewById(R.id.quesno);

        check1= findViewById(R.id.selop);
        check2= findViewById(R.id.corAns);
        progressBar= findViewById(R.id.pbar);


        currQ= qb[currIn].getQuesi();
        ques.setText(currQ);
        currOpA=qb[currIn].getOpA();
        op1.setText(currOpA);
        currOpB=qb[currIn].getOpB();
        op2.setText(currOpB);
        currOpC=qb[currIn].getOpC();
        op3.setText(currOpC);
        currOpD=qb[currIn].getOpD();
        op4.setText(currOpD);

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(currOpA);
                updateQues();

            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(currOpB);
                updateQues();

            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(currOpC);
                updateQues();

            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns(currOpD);
                updateQues();

            }
        });

    }

    private void checkAns(int usrSel) {
        int corrans= qb[currIn].getAnsi();
        check1.setText(usrSel);
        check2.setText(corrans);

        String m = check1.getText().toString().trim();
        String n = check2.getText().toString().trim();

        if(m.equals(n))
        {
            Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
            mscore=mscore+1;
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

        }

    }

    @SuppressLint("SetTextI18n")
    private void updateQues() {
        currIn=(currIn+1)% qb.length;


        if (currIn==0)
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score" + mscore + "points");
            alert.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    score.setText("Score" + mscore + "/" + qb.length);
                    quesno.setText(qn + "/" + qb.length + "Question");
                }
            });
            alert.show();
        }
        currQ= qb[currIn].getQuesi();
        ques.setText(currQ);
        currOpA=qb[currIn].getOpA();
        op1.setText(currOpA);
        currOpB=qb[currIn].getOpB();
        op2.setText(currOpB);
        currOpC=qb[currIn].getOpC();
        op3.setText(currOpC);
        currOpD=qb[currIn].getOpD();
        op4.setText(currOpD);

        qn=qn+1;
        if (qn<= qb.length)
        {
            quesno.setText(qn + "/" + qb.length + "Question");
        }
        score.setText("Score" + mscore + "/" + qb.length);
        progressBar.incrementProgressBy(P_BAR);

    }

}