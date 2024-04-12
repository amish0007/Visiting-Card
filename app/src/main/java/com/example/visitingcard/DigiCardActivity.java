package com.example.visitingcard;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.fonts.FontFamily;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ConcurrentSkipListSet;

public class DigiCardActivity extends AppCompatActivity {

    TextView dTxtName,dTxtDesignation,dTxtCompany,dTxtMobile,dTxtWhatsapp,dTxtEmail,dTxtAddress,
    dTxtSkill,dTxtService,dTxtAboutMe,dTxtSkills;
    ImageView dImgProfile;
    LinearLayout lnrSec1;

    FloatingActionButton dEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digi_card);
        init();
        getData();
        dEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editColor();
                //editFontStyle();
            }
        });
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
        dTxtSkills = findViewById(R.id.dTxtSkills);
        dImgProfile = findViewById(R.id.dImgProfile);
        dEdit = findViewById(R.id.dEdit);
        lnrSec1 = findViewById(R.id.lnrSec1);

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
        String dImage = intent.getStringExtra("urlImage");

        Picasso.get().load(dImage).into(dImgProfile);
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

    void editColor()
    {
        Dialog dialog = new Dialog(DigiCardActivity.this);
        dialog.setContentView(R.layout.edit_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        LinearLayout closeEditLayout = dialog.findViewById(R.id.closeEditLayout);

        closeEditLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });

        LinearLayout BgBlack = dialog.findViewById(R.id.BgBlack);
        LinearLayout BgRed = dialog.findViewById(R.id.BgRed);
        LinearLayout BgBlue = dialog.findViewById(R.id.BgBlue);
        LinearLayout BgGreen = dialog.findViewById(R.id.BgGreen);
        LinearLayout BgPurple = dialog.findViewById(R.id.BgPurple);
        LinearLayout BgYellow = dialog.findViewById(R.id.BgYellow);

        LinearLayout FontBlack = dialog.findViewById(R.id.FontBlack);
        LinearLayout FontRed = dialog.findViewById(R.id.FontRed);
        LinearLayout FontBlue = dialog.findViewById(R.id.FontBlue);
        LinearLayout FontGreen = dialog.findViewById(R.id.FontGreen);
        LinearLayout FontPurple = dialog.findViewById(R.id.FontPurple);
        LinearLayout FontYellow = dialog.findViewById(R.id.FontYellow);

        TextView FontItalic = dialog.findViewById(R.id.FontItalic);
        TextView FontBebasNeue =dialog.findViewById(R.id.FontBebasNeue);
        TextView FontCaveat = dialog.findViewById(R.id.FontCaveat);
        TextView FontPlayfair = dialog.findViewById(R.id.FontPlayfair);
        TextView FontTac_One = dialog.findViewById(R.id.FontTac_One);

        BgBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "onClick: ====== " );
                lnrSec1.setBackgroundColor(getColor(R.color.black));
                dialog.dismiss();
            }
        });

        BgRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnrSec1.setBackgroundColor(getColor(R.color.red));
                dialog.dismiss();
            }
        });
        BgBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnrSec1.setBackgroundColor(getColor(R.color.Blue));
                dialog.dismiss();
            }
        });
        BgGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnrSec1.setBackgroundColor(getColor(R.color.green));
                dialog.dismiss();
            }
        });
        BgPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnrSec1.setBackgroundColor(getColor(R.color.purple));
                dialog.dismiss();
            }
        });
        BgYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnrSec1.setBackgroundColor(getColor(R.color.yellow));
                dialog.dismiss();
            }
        });

        FontBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dTxtName.setTextColor(getColor(R.color.black));
                dTxtDesignation.setTextColor(getColor(R.color.black));
                dTxtCompany.setTextColor(getColor(R.color.black));
                dTxtMobile.setTextColor(getColor(R.color.black));
                dTxtWhatsapp.setTextColor(getColor(R.color.black));
                dTxtEmail.setTextColor(getColor(R.color.black));
                dTxtAddress.setTextColor(getColor(R.color.black));
                dTxtSkill.setTextColor(getColor(R.color.black));
                dTxtService.setTextColor(getColor(R.color.black));
                dTxtAboutMe.setTextColor(getColor(R.color.black));
                dialog.dismiss();
            }
        });

        FontRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dTxtName.setTextColor(getColor(R.color.red));
                dTxtDesignation.setTextColor(getColor(R.color.red));
                dTxtCompany.setTextColor(getColor(R.color.red));
                dTxtMobile.setTextColor(getColor(R.color.red));
                dTxtWhatsapp.setTextColor(getColor(R.color.red));
                dTxtEmail.setTextColor(getColor(R.color.red));
                dTxtAddress.setTextColor(getColor(R.color.red));
                dTxtSkill.setTextColor(getColor(R.color.red));
                dTxtService.setTextColor(getColor(R.color.red));
                dTxtAboutMe.setTextColor(getColor(R.color.red));
                dialog.dismiss();
            }
        });
        FontBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dTxtName.setTextColor(getColor(R.color.Blue));
                dTxtDesignation.setTextColor(getColor(R.color.Blue));
                dTxtCompany.setTextColor(getColor(R.color.Blue));
                dTxtMobile.setTextColor(getColor(R.color.Blue));
                dTxtWhatsapp.setTextColor(getColor(R.color.Blue));
                dTxtEmail.setTextColor(getColor(R.color.Blue));
                dTxtAddress.setTextColor(getColor(R.color.Blue));
                dTxtSkill.setTextColor(getColor(R.color.Blue));
                dTxtService.setTextColor(getColor(R.color.Blue));
                dTxtAboutMe.setTextColor(getColor(R.color.Blue));
                dialog.dismiss();
            }
        });
        FontGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dTxtName.setTextColor(getColor(R.color.green));
                dTxtDesignation.setTextColor(getColor(R.color.green));
                dTxtCompany.setTextColor(getColor(R.color.green));
                dTxtMobile.setTextColor(getColor(R.color.green));
                dTxtWhatsapp.setTextColor(getColor(R.color.green));
                dTxtEmail.setTextColor(getColor(R.color.green));
                dTxtAddress.setTextColor(getColor(R.color.green));
                dTxtSkill.setTextColor(getColor(R.color.green));
                dTxtService.setTextColor(getColor(R.color.green));
                dTxtAboutMe.setTextColor(getColor(R.color.green));
                dialog.dismiss();
            }
        });
        FontPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dTxtName.setTextColor(getColor(R.color.purple));
                dTxtDesignation.setTextColor(getColor(R.color.purple));
                dTxtCompany.setTextColor(getColor(R.color.purple));
                dTxtMobile.setTextColor(getColor(R.color.purple));
                dTxtWhatsapp.setTextColor(getColor(R.color.purple));
                dTxtEmail.setTextColor(getColor(R.color.purple));
                dTxtAddress.setTextColor(getColor(R.color.purple));
                dTxtSkill.setTextColor(getColor(R.color.purple));
                dTxtService.setTextColor(getColor(R.color.purple));
                dTxtAboutMe.setTextColor(getColor(R.color.purple));
                dialog.dismiss();
            }
        });
        FontYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dTxtName.setTextColor(getColor(R.color.yellow));
                dTxtDesignation.setTextColor(getColor(R.color.yellow));
                dTxtCompany.setTextColor(getColor(R.color.yellow));
                dTxtMobile.setTextColor(getColor(R.color.yellow));
                dTxtWhatsapp.setTextColor(getColor(R.color.yellow));
                dTxtEmail.setTextColor(getColor(R.color.yellow));
                dTxtAddress.setTextColor(getColor(R.color.yellow));
                dTxtSkill.setTextColor(getColor(R.color.yellow));
                dTxtService.setTextColor(getColor(R.color.yellow));
                dTxtAboutMe.setTextColor(getColor(R.color.yellow));
                dialog.dismiss();
            }
        });

       FontItalic.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Typeface italic = ResourcesCompat.getFont(DigiCardActivity.this,R.font.italic);
               dTxtName.setTypeface(italic);
               dTxtDesignation.setTypeface(italic);
               dTxtCompany.setTypeface(italic);
               dTxtMobile.setTypeface(italic);
               dTxtWhatsapp.setTypeface(italic);
               dTxtEmail.setTypeface(italic);
               dTxtAddress.setTypeface(italic);
               dTxtSkill.setTypeface(italic);
               dTxtService.setTypeface(italic);
               dTxtAboutMe.setTypeface(italic);
               dialog.dismiss();
           }
       });
        FontBebasNeue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface bebasneue = ResourcesCompat.getFont(DigiCardActivity.this,R.font.bebas_neue);
                dTxtName.setTypeface(bebasneue);
                dTxtDesignation.setTypeface(bebasneue);
                dTxtCompany.setTypeface(bebasneue);
                dTxtMobile.setTypeface(bebasneue);
                dTxtWhatsapp.setTypeface(bebasneue);
                dTxtEmail.setTypeface(bebasneue);
                dTxtAddress.setTypeface(bebasneue);
                dTxtSkill.setTypeface(bebasneue);
                dTxtService.setTypeface(bebasneue);
                dTxtAboutMe.setTypeface(bebasneue);
                dialog.dismiss();
            }
        });
        FontCaveat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface caveat = ResourcesCompat.getFont(DigiCardActivity.this,R.font.caveat);
                dTxtName.setTypeface(caveat);
                dTxtDesignation.setTypeface(caveat);
                dTxtCompany.setTypeface(caveat);
                dTxtMobile.setTypeface(caveat);
                dTxtWhatsapp.setTypeface(caveat);
                dTxtEmail.setTypeface(caveat);
                dTxtAddress.setTypeface(caveat);
                dTxtSkill.setTypeface(caveat);
                dTxtService.setTypeface(caveat);
                dTxtAboutMe.setTypeface(caveat);
                dialog.dismiss();
            }
        });
        FontPlayfair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface playfair = ResourcesCompat.getFont(DigiCardActivity.this,R.font.playfair);
                dTxtName.setTypeface(playfair);
                dTxtDesignation.setTypeface(playfair);
                dTxtCompany.setTypeface(playfair);
                dTxtMobile.setTypeface(playfair);
                dTxtWhatsapp.setTypeface(playfair);
                dTxtEmail.setTypeface(playfair);
                dTxtAddress.setTypeface(playfair);
                dTxtSkill.setTypeface(playfair);
                dTxtService.setTypeface(playfair);
                dTxtAboutMe.setTypeface(playfair);
                dialog.dismiss();
            }
        });
        FontTac_One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Typeface tac_one = ResourcesCompat.getFont(DigiCardActivity.this,R.font.tac_one);
                dTxtName.setTypeface(tac_one);
                dTxtDesignation.setTypeface(tac_one);
                dTxtCompany.setTypeface(tac_one);
                dTxtMobile.setTypeface(tac_one);
                dTxtWhatsapp.setTypeface(tac_one);
                dTxtEmail.setTypeface(tac_one);
                dTxtAddress.setTypeface(tac_one);
                dTxtSkill.setTypeface(tac_one);
                dTxtService.setTypeface(tac_one);
                dTxtAboutMe.setTypeface(tac_one);
                dialog.dismiss();
            }
        });
    }

}