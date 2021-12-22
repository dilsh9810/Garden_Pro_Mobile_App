package com.example.plant_suggestion_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import BackendServices.ApiClient;
import BackendServices.RegisterRequest;
import BackendServices.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import org.w3c.dom.Text;

public class Registration_Activity extends AppCompatActivity {

    EditText username, email, password, passwordn;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_);

        //match id of the UI components to the variable

        username = findViewById(R.id.txtusername);
        email = findViewById(R.id.txtuseremail);
        password = findViewById(R.id.txtuserpassword);
        passwordn = findViewById(R.id.txtconfirmpassword);
        register = findViewById(R.id.btnreg);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().length() == 0 && email.getText().length() == 0 && password.getText().length() == 0) {
                    username.setError("Please enter username");
                    email.setError("Please enter email");
                    password.setError("Please enter password");

                } else if (username.getText().length() > 0 && email.getText().length() > 0 && password.getText().length() > 0 && passwordn.getText().length() == 0)
                {

                    passwordn.setError("Please confirm the password");

                }
                else
                {
                    RegisterRequest registerRequest = new RegisterRequest();

                    registerRequest.setUsername(username.getText().toString());
                    registerRequest.setEmail(email.getText().toString());
                    registerRequest.setPassword(password.getText().toString());

                    registerUser(registerRequest);


                }

            }
        });

    }

    public void registerUser(RegisterRequest registerRequest)
    {

            Call<RegisterResponse> registerResponseCall = ApiClient.getService().registerUser(registerRequest);
            registerResponseCall.enqueue(new Callback<RegisterResponse>() {

                @Override
                public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                    if(response.isSuccessful()){

                        Toast.makeText(Registration_Activity.this,"Registration Successful",Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(Registration_Activity.this,Login_Activity.class);
                        startActivity(i);

                        finish();

                    }

                    else
                    {
                        Toast.makeText(Registration_Activity.this,"An error occured please try again",Toast.LENGTH_SHORT).show();

                    }


                }

                @Override
                public void onFailure(Call<RegisterResponse> call, Throwable t) {

                    String message = t.getLocalizedMessage();
                    Toast.makeText(Registration_Activity.this, message, Toast.LENGTH_SHORT).show();

                }
            });



        }
    }


