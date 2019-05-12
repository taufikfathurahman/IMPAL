package com.example.ayedis_ecommerce;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Signup extends AppCompatActivity
{

    private Button CreateAccountButton;
    private EditText InputUserName, InputPassword, InputPhoneNumber, InputAddress;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        CreateAccountButton = (Button) findViewById(R.id.signupButton);
        InputUserName = (EditText) findViewById(R.id.sgUserName);
        InputPassword = (EditText) findViewById(R.id.sgPassword);
        InputPhoneNumber = (EditText) findViewById(R.id.sgTlp);
        InputAddress = (EditText) findViewById(R.id.sgAlamat);
        loadingBar = new ProgressDialog(this);

        CreateAccountButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CreateAccount();
            }
        });
    }

    private void CreateAccount()
    {
        String username = InputUserName.getText().toString();
        String password = InputPassword.getText().toString();
        String phone = InputPhoneNumber.getText().toString();
        String address = InputAddress.getText().toString();

        if (TextUtils.isEmpty(username))
        {
            Toast.makeText(this, "Emailnya dilengkapi ya...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Passwordnya dilengkapi ya...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "No Tlp dilengkapi ya...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(address))
        {
            Toast.makeText(this, "Alamatnya dilengkapi ya...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Tunggu dulu ya, sedang kami proses :)");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            ValidatePhoneNumber(username, password, phone, address);
        }
    }

    private void ValidatePhoneNumber(final String username, final String password, final String phone, final String address)
    {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (!(dataSnapshot.child("UserCustomer").child(phone).exists()))
                {
                    HashMap<String, Object> userdataMap = new HashMap<>();
                    userdataMap.put("username", username);
                    userdataMap.put("password", password);
                    userdataMap.put("phone", phone);
                    userdataMap.put("address", address);

                    RootRef.child("UserCustomer").child(phone).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(Signup.this, "Selamat, akun berhasil dibuat :)", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(Signup.this, Login.class);
                                startActivity(intent);
                            }
                            else
                                {
                                    loadingBar.dismiss();
                                    Toast.makeText(Signup.this, "Sepertinya koneksi internet anda bermasalah, silahkan coba lagi...", Toast.LENGTH_SHORT).show();
                                }
                        }
                    });
                }
                else
                {
                    Toast.makeText(Signup.this, "Sepertinya no " + phone + " sudah ada yang menggunakan.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(Signup.this, "Silahkan coba lagi dengan nomor berbeda.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Signup.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
