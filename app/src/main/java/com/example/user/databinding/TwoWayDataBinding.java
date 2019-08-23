package com.example.user.databinding;

import android.os.Bundle;

import com.example.user.databinding.databinding.ActivityTwoWayDataBindingBinding;
import com.example.user.databinding.model.ModelClass;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.view.View;

public class TwoWayDataBinding extends AppCompatActivity {


    ActivityTwoWayDataBindingBinding twoWayDataBindingBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_two_way_data_binding);
        twoWayDataBindingBinding = DataBindingUtil.setContentView(this,R.layout.activity_two_way_data_binding);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ModelClass modelClass = new ModelClass();
        //modelClass.setFirst_name("Jos");

        twoWayDataBindingBinding.setName(modelClass);

    }

}
