package com.example.ssd.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectimage);

        final CheckBox cb1 = (CheckBox)findViewById(R.id.CheckBox01);
        final CheckBox cb2 = (CheckBox)findViewById(R.id.CheckBox02);

        OnClickListener ocl = new OnClickListener(){
            @Override
            public void onClick(View v){
                if(!((CheckBox)v).isChecked()){
                    Toast.makeText(MainActivity.this, "\""+((Button)v).getText()+"\"被取消",
                            Toast.LENGTH_SHORT).show();
                }
            }
        };

        OnCheckedChangeListener occl = new OnCheckedChangeListener(){
            @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    Toast.makeText(MainActivity.this, "\""+buttonView.getText()+"\"被选择",
                            Toast.LENGTH_SHORT).show();
                }
            }

        };

        cb1.setOnCheckedChangeListener(occl);
        cb2.setOnCheckedChangeListener(occl);
        cb1.setOnClickListener(ocl);
        cb2.setOnClickListener(ocl);
    }

}























