package com.example.ayedis_ecommerce;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ayedis_ecommerce.Model.UserCustomer;
import com.example.ayedis_ecommerce.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity
{

    private Button tmpLoginButton, tmpSignupButton;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tmpLoginButton = (Button) findViewById(R.id.loginButton);
        tmpSignupButton = (Button) findViewById(R.id.signupButton);

        loadingBar = new ProgressDialog(this);

//        Paper.init(this);

        tmpLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        tmpSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });

//        String UserCustomerPhoneKey = Paper.book().read(Prevalent.UserCustomerPhoneKey);
//        String UserCustomerPasswordKey = Paper.book().read(Prevalent.UserCustomerPasswordKey);

//        if (UserCustomerPhoneKey != "" && UserCustomerPasswordKey != "")
//        {
//            if (!TextUtils.isEmpty(UserCustomerPhoneKey) && !TextUtils.isEmpty(UserCustomerPasswordKey))
//            {
//                AllowAccess(UserCustomerPhoneKey, UserCustomerPasswordKey);
//
//                loadingBar.setTitle("Anda telah login");
//                loadingBar.setMessage("Tunggu dulu ya, sedang kami proses :)");
//                loadingBar.setCanceledOnTouchOutside(false);
//                loadingBar.show();
//            }
//        }
    }

//    private void AllowAccess(final String phone, final String password)
//    {
//        final DatabaseReference RootRef;
//        RootRef = FirebaseDatabase.getInstance().getReference();
//
//        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.child("UserCustomer").child(phone).exists())
//                {
//                    UserCustomer userCustomerData = dataSnapshot.child("UserCustomer").child(phone).getValue(UserCustomer.class);
//
//                    if (userCustomerData.getPhone().equals(phone))
//                    {
//                        if (userCustomerData.getPassword().equals(password))
//                        {
//                            Toast.makeText(MainActivity.this, "Anda berhasil masuk :)", Toast.LENGTH_SHORT).show();
//                            loadingBar.dismiss();
//
//                            Intent intent = new Intent(MainActivity.this, HomePage.class);
//                            startActivity(intent);
//                        }
//                        else
//                        {
//                            loadingBar.dismiss();
//                            Toast.makeText(MainActivity.this, "Aduh, sepertinya password anda salah :( :(", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//                else
//                {
//                    Toast.makeText(MainActivity.this, "Sepertinya no Hp " + phone + " belum terdaftar.", Toast.LENGTH_SHORT).show();
//                    loadingBar.dismiss();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
}
