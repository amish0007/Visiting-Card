package com.example.visitingcard;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtName = findViewById(R.id.edtName);
        EditText edtDesignation = findViewById(R.id.edtDesignation);
        EditText edtCompany = findViewById(R.id.edtCompany);
        EditText edtAboutMe = findViewById(R.id.edtAboutMe);
        EditText edtContact = findViewById(R.id.edtContact);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtAddress = findViewById(R.id.edtAddress);
        EditText edtService = findViewById(R.id.edtService);
        TextView txtButton= findViewById(R.id.txtButton);
        CircleImageView imgProfile = findViewById(R.id.imgProfile);
        TextView txtNext = findViewById(R.id.txtNext);
        TextInputLayout edtNameLayout = findViewById(R.id.edtNameLayout);
        TextInputLayout edtDesignationLayout = findViewById(R.id.edtDesignationLayout);
        TextInputLayout edtCompanyLayout = findViewById(R.id.edtCompanyLayout);
        TextInputLayout edtAboutMeLayout = findViewById(R.id.edtAboutMeLayout);
        TextInputLayout edtContactLayout = findViewById(R.id.edtContactLayout);
        TextInputLayout edtEmailLayout = findViewById(R.id.edtEmailLayout);
        TextInputLayout edtAddressLayout = findViewById(R.id.edtAddressLayout);
        TextInputLayout edtServiceLayout = findViewById(R.id.edtServiceLayout);
        RadioGroup rdGroup = findViewById(R.id.rdGroup);
        TextInputLayout edtWhatsappLayout = findViewById(R.id.edtWhatsappLayout);
        EditText edtWhatsapp = findViewById(R.id.edtWhatsapp);
        CheckBox CbJava = findViewById(R.id.CbJava);
        CheckBox CbKotlin = findViewById(R.id.CbKotlin);
        CheckBox CbSwift = findViewById(R.id.CbSwift);
        CheckBox CbDart = findViewById(R.id.CbDart);

        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.rdYes)
                {
                    edtWhatsappLayout.setVisibility(View.VISIBLE);
                    edtWhatsapp.setVisibility(View.VISIBLE);
                }
                else {
                    edtWhatsappLayout.setVisibility(View.GONE);
                    edtWhatsapp.setVisibility(View.GONE);
                }
            }
        });

        pickMedia= registerForActivityResult(new ActivityResultContracts.PickVisualMedia(),uri->
        {
            if(uri!=null) {
                imgProfile.setImageURI(uri);
            }
        });

        txtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickMedia.launch(new PickVisualMediaRequest.Builder()
                        .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                        .build());
            }
        });

        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = edtName.getText().toString();
                String Designation = edtDesignation.getText().toString();
                String Company = edtCompany.getText().toString();
                String AboutMe = edtAboutMe.getText().toString();
                String Contact = edtContact.getText().toString();
                String Email = edtEmail.getText().toString();
                String Address = edtAddress.getText().toString();
                String Service = edtService.getText().toString();
                String Whatsapp = edtWhatsapp.getText().toString();
                String Java="",Kotlin="",Swift="",Dart="";



                if (CbJava.isChecked())
                {
                    Java = "Java";
                }
                if (CbKotlin.isChecked())
                {
                    Kotlin = "Kotlin";
                }
                if (CbSwift.isChecked())
                {
                    Swift= "Swift";
                }
                if (CbDart.isChecked())
                {
                    Dart = "Dart";
                }

                if(Name.isEmpty())
                {
                    edtNameLayout.setEnabled(true);
                    edtNameLayout.setError("Enter Name");
                }
                else if (Designation.isEmpty())
                {
                    edtDesignationLayout.setEnabled(true);
                    edtDesignationLayout.setError("Enter Designation");
                }
                else if (Company.isEmpty())
                {
                    edtCompanyLayout.setEnabled(true);
                    edtCompanyLayout.setError("Enter Company");
                }
                else if (AboutMe.isEmpty())
                {
                    edtAboutMeLayout.setEnabled(true);
                    edtAboutMeLayout.setError("Enter About Me");
                }
                else if (Contact.isEmpty())
                {
                    edtContactLayout.setEnabled(true);
                    edtContactLayout.setError("Enter Contact");
                }
                else if(Whatsapp.isEmpty() && rdGroup.getCheckedRadioButtonId() == R.id.rdYes)
                {
                    edtWhatsappLayout.setEnabled(true);
                    edtWhatsappLayout.setError("Enter Whatsapp Number");
                }
                else if(rdGroup.getCheckedRadioButtonId() != R.id.rdYes && rdGroup.getCheckedRadioButtonId() != R.id.rdNo)
                {
                    Toast.makeText(MainActivity.this,"Please Select Yes or No",Toast.LENGTH_SHORT).show();
                }
                else if (Email.isEmpty())
                {
                    edtEmailLayout.setEnabled(true);
                    edtEmailLayout.setError("Enter Email ID");
                }
                else if (Address.isEmpty())
                {
                    edtAddressLayout.setEnabled(true);
                    edtAddressLayout.setError("Enter Address");
                }
                else if (Service.isEmpty())
                {
                    edtServiceLayout.setEnabled(true);
                    edtServiceLayout.setError("Enter Service");
                }
                else
                {
                    edtNameLayout.setEnabled(false);
                    edtDesignationLayout.setEnabled(false);
                    edtCompanyLayout.setEnabled(false);
                    edtAboutMeLayout.setEnabled(false);
                    edtContactLayout.setEnabled(false);
                    edtEmailLayout.setEnabled(false);
                    edtAddressLayout.setEnabled(false);
                    edtServiceLayout.setEnabled(false);
                    edtWhatsappLayout.setEnabled(false);
                    Toast.makeText(MainActivity.this,Name+" "+Designation+" "+Company+" "+AboutMe+" "+Contact
                            +" "+Whatsapp+" "+Email+" "+ Address+" "+Java+" "+Kotlin+" "+Swift+" "+Dart+" "+Service,
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
/*
void init()
    {
        EditText edtName = findViewById(R.id.edtName);
        EditText edtDesignation = findViewById(R.id.edtDesignation);
        EditText edtCompany = findViewById(R.id.edtCompany);
        EditText edtAboutMe = findViewById(R.id.edtAboutMe);
        EditText edtContact = findViewById(R.id.edtContact);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtAddress = findViewById(R.id.edtAddress);
        EditText edtService = findViewById(R.id.edtService);
        TextView txtButton= findViewById(R.id.txtButton);
        CircleImageView imgProfile = findViewById(R.id.imgProfile);
        TextView txtNext = findViewById(R.id.txtNext);
    }
 */
