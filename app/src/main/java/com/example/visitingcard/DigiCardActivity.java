package com.example.visitingcard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DigiCardActivity extends AppCompatActivity {

    TextView dTxtName,dTxtDesignation,dTxtCompany,dTxtMobile,dTxtWhatsapp,dTxtEmail,dTxtAddress,
    dTxtSkill,dTxtService,dTxtAboutMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digi_card);
        init();
        getData();

    }

    void init()
    {
        dTxtName = findViewById(R.id.dTxtName);
        dTxtDesignation = findViewById(R.id.dTxtDesignation);
        dTxtCompany = findViewById(R.id.dTxtCompany);
        dTxtMobile = findViewById(R.id.dTxtMobile);
        dTxtWhatsapp = findViewById(R.id.dTxtWhatsapp);
        dTxtEmail = findViewById(R.id.dTxtEmail);
        dTxtAddress = findViewById(R.id.dTxtAddress);
        dTxtSkill = findViewById(R.id.dTxtSkill);
        dTxtService = findViewById(R.id.dTxtService);
        dTxtAboutMe = findViewById(R.id.dTxtAboutMe);
    }
    void getData()
    {
        Intent intent = getIntent();

        String dName = intent.getStringExtra("name");
        String dDesignation = intent.getStringExtra("designation");
        String dCompany = intent.getStringExtra("company");
        String dNumber = intent.getStringExtra("contact");
        String dWhatsapp = intent.getStringExtra("whatsapp");
        String dEmail = intent.getStringExtra("email");
        String dAddress = intent.getStringExtra("address");
        String dSkill = intent.getStringExtra("skill");
        String dService = intent.getStringExtra("service");
        String dAboutMe = intent.getStringExtra("aboutMe");

        dTxtName.setText(" "+dName);
        dTxtDesignation.setText(" "+dDesignation);
        dTxtCompany.setText(" "+dCompany);
        dTxtMobile.setText("Mobile Number:- "+dNumber);
        dTxtWhatsapp.setText("Whatsapp Number:- "+dWhatsapp);
        dTxtEmail.setText("Email ID:- "+dEmail);
        dTxtAddress.setText("Address:- "+dAddress);
        dTxtSkill.setText(" "+dSkill);
        dTxtService.setText(" "+dService);
        dTxtAboutMe.setText(" "+dAboutMe);
    }
}