package com.example.appgrade_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.appgrade_v2.R.id.addRow;
import static com.example.appgrade_v2.R.id.submitRow;

public class MainActivity extends AppCompatActivity {
    ImageButton buttonAdd;
    RelativeLayout layoutList;
    Button butSubmit;

    List<String> gradelist = new ArrayList<>();
    ArrayList<Clicker> clickerList = new ArrayList<>();
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutList = findViewById(R.id.layout_list);
        buttonAdd = findViewById(R.id.addRow);
        butSubmit = findViewById(R.id.submitRow);

        gradelist.add("Grade Level");
        gradelist.add("Grade 1");
        gradelist.add("Grade 2");
        gradelist.add("Grade 3");
        gradelist.add("Grade 4");
        gradelist.add("Grade 5");
        gradelist.add("Grade 6");
        gradelist.add("Grade 7");
        gradelist.add("Grade 8");
        gradelist.add("Grade 9");
        gradelist.add("Grade 10");

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addView();
            }
        });

        butSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(checkifValidAndRead()){
                    Intent intent = new Intent(MainActivity.this,ActivityClicker.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list",clickerList);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });

    }

    /*@Override
    public void onClick(View v) {

                addView();
       }*/



    private boolean checkifValidAndRead() {
        clickerList.clear();
        boolean result = true;

        for(int i=0;i<layoutList.getChildCount();i++){

            View subject = layoutList.getChildAt(i);
            EditText editTextName = (EditText)subject.findViewById(R.id.edit_subject);
            AppCompatSpinner gradeLevel = (AppCompatSpinner)subject.findViewById(R.id.grade_lvl);

            Clicker clicker = new Clicker();

            if(!editTextName.getText().toString().equals("")){
                clicker.setSubject(editTextName.getText().toString());
            }else{
                result = false;
                break;
            }
            if(gradeLevel.getSelectedItemPosition()!=0){
                clicker.setGradelvl(gradelist.get(gradeLevel.getSelectedItemPosition()));
            }else{
                result = false;
                break;
            }

            clickerList.add(clicker);

        }

        if(clickerList.size()==0){
            result = false;
            Toast.makeText(this,"Add Subject First!", Toast.LENGTH_SHORT).show();
        }else if(!result){
            Toast.makeText(this,"Enter All Details Correctly!",Toast.LENGTH_SHORT).show();
        }

        return result;
    }

    private void addView() {

        final View subject = getLayoutInflater().inflate(R.layout.row_add_subject,null,false);

        EditText editText = (EditText)subject.findViewById(R.id.edit_subject);
        AppCompatSpinner gradeLevel = (AppCompatSpinner)subject.findViewById(R.id.grade_lvl);
        ImageView imageClose = (ImageView)subject.findViewById(R.id.option);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, gradelist);
        gradeLevel.setAdapter(arrayAdapter);

        imageClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                removeView(subject);
            }
        });

        layoutList.addView(subject);

    }

    private void removeView(View view){

        layoutList.removeView(view);

    }

}