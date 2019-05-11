package com.example.ayedis_ecommerce;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ayedis_ecommerce.Model.UserCustomer;
import com.example.ayedis_ecommerce.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import io.paperdb.Paper;

public class Login extends AppCompatActivity
{

    private EditText InputPhone, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;
    private String parentDB = "UserCustomer";
//    private CheckBox rmbMeCheckbox;
    private TextView userSellerLink, notUserSellerLink;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton = (Button) findViewById(R.id.loginButton);
        InputPhone = (EditText) findViewById(R.id.inPhone);
        InputPassword = (EditText) findViewById(R.id.inPassword);
        userSellerLink = (TextView) findViewById(R.id.userseller_link);
        notUserSellerLink = (TextView) findViewById(R.id.not_userseller_link);
        loadingBar = new ProgressDialog(this);

//        rmbMeCheckbox = (CheckBox) findViewById(R.id.remembermeCheckbox);
//        Paper.init(this);

        LoginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LoginUserCustomer();
            }
        });

        userSellerLink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login User Seller");
                userSellerLink.setVisibility(View.INVISIBLE);
                notUserSellerLink.setVisibility(View.VISIBLE);
                parentDB = "UserSeller";
            }
        });

        notUserSellerLink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LoginButton.setText("Login");
                userSellerLink.setVisibility(View.VISIBLE);
                notUserSellerLink.setVisibility(View.INVISIBLE);
                parentDB = "UserCustomer";
            }
        });
    }

    private void LoginUserCustomer()
    {
        String phone = InputPhone.getText().toString();
        String password = InputPassword.getText().toString();

        if (TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "No Tlp dilengkapi ya...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Passwordnya dilengkapi ya...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Tunggu dulu ya, sedang kami proses :)");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            UserCustomerLogin(phone, password);
        }
    }

    private void UserCustomerLogin(final String phone, final String password)
    {
//        if (rmbMeCheckbox.isChecked())
//        {
//            Paper.book().write(Prevalent.UserCustomerPhoneKey, phone);
//            Paper.book().write(Prevalent.UserCustomerPasswordKey, password);
//        }

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.child(parentDB).child(phone).exists())
                {
                    UserCustomer userCustomerData = dataSnapshot.child(parentDB).child(phone).getValue(UserCustomer.class);

                    if (userCustomerData.getPhone().equals(phone))
                    {
                        if (userCustomerData.getPassword().equals(password))
                        {
                            if (parentDB.equals("UserSeller"))
                            {
                                Toast.makeText(Login.this, "Anda berhasil masuk :)", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(Login.this, Category.class);
                                startActivity(intent);
                            }
                            else if (parentDB.equals("UserCustomer"))
                            {
                                Toast.makeText(Login.this, "Anda berhasil masuk :)", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(Login.this, Home.class);
                                Prevalent.onlineUserCustomer = userCustomerData;
                                startActivity(intent);
                            }
                        }
                        else
                        {
                            loadingBar.dismiss();
                            Toast.makeText(Login.this, "Aduh, sepertinya password anda salah :( :(", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(Login.this, "Sepertinya no Hp " + phone + " belum terdaftar.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
