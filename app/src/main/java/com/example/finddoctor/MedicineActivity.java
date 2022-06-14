package com.example.finddoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MedicineActivity extends AppCompatActivity implements View.OnClickListener{

    TextView questionTextView, nilai, hasil;
    Button ansA, ansB, ansC;
    Button backbutton, quizbutton, submitBtn;
    LottieAnimationView gambarhasil;
    Dialog dialog;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        dialog = new Dialog(this);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        submitBtn = findViewById(R.id.submit_btn);
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundResource(R.drawable.buttonquizputih);
        ansB.setBackgroundResource(R.drawable.buttonquizputih);
        ansC.setBackgroundResource(R.drawable.buttonquizputih);


        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals("")){
                return;
            }
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
            selectedAnswer="";


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundResource(R.drawable.buttonquizhijau);

        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Perbaiki pola makan";



        }else{
            passStatus = "Perbanyak konsumsi sayuran";


        }
        dialog.setContentView(R.layout.activity_result);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        nilai = dialog.findViewById(R.id.nilaiquiz);
        hasil = dialog.findViewById(R.id.hasilnya);
        gambarhasil = dialog.findViewById(R.id.animasiresult);
        gambarhasil = dialog.findViewById(R.id.animasiresult);
        backbutton = dialog.findViewById(R.id.backButton);
        quizbutton = dialog.findViewById(R.id.quizButton);

        hasil.setText(passStatus);
        nilai.setText(score+" / 3");
        dialog.show();
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });
        quizbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


//        new AlertDialog.Builder(this)
//                .setTitle(passStatus)
//                .setMessage("Score is "+ score+" out of "+ totalQuestion)
//                .setIcon(R.drawable.senpaibulet)
//                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
//                .setCancelable(false)
//                .show();


    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

}