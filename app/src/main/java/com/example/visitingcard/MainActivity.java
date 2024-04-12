package com.example.visitingcard;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
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
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
    Uri uri;
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
        ImageView imgBack = findViewById(R.id.imgBack);


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

        pickMedia= registerForActivityResult(new ActivityResultContracts.PickVisualMedia(),url->
        {
            if(url!=null) {
                imgProfile.setImageURI(url);
                uri = url;
                //Use of Picasso
                //Picasso.get().load(uri).into(imgProfile);
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
                //String ImgButton = txtButton.getText().toString();
                //String ImgProfile = imgProfile.getDrawable().toString();



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
                    //Toast
                    /*Toast.makeText(MainActivity.this,Name+" "+Designation+" "+Company+" "+AboutMe+" "+Contact
                            +" "+Whatsapp+" "+Email+" "+ Address+" "+Java+" "+Kotlin+" "+Swift+" "+Dart+" "+Service,
                            Toast.LENGTH_SHORT).show();*/

                    Intent intent = new Intent(MainActivity.this,DigiCardActivity.class);

                    intent.putExtra("name",Name);
                    intent.putExtra("designation",Designation);
                    intent.putExtra("company",Company);
                    intent.putExtra("aboutMe",AboutMe);
                    intent.putExtra("contact",Contact);
                    intent.putExtra("email",Email);
                    intent.putExtra("whatsapp",Whatsapp);
                    intent.putExtra("address",Address);
                    intent.putExtra("service",Service);
                    intent.putExtra("skill",Java+" "+Kotlin+" "+Swift+" "+Dart);
                    intent.putExtra("urlImage",uri.toString());
                    startActivity(intent);
                }
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog();
            }
        });

        getOnBackPressedDispatcher().addCallback(MainActivity.this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                exit();
            }
        });
    }

    //AlertDialog
    void exit()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).
                setCancelable(false).setTitle("Do you want to exit?").
                setMessage("Digi Card").
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).
                setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        alertDialog.show();
    }

    void customDialog()
    {
        Dialog cusdialog = new Dialog(MainActivity.this);
        cusdialog.setContentView(R.layout.dialog);
        Button btnYes =cusdialog.findViewById(R.id.btnYes);
        Button btnNo =cusdialog.findViewById(R.id.btnNo);
        cusdialog.show();

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cusdialog.dismiss();
            }
        });

    }
}