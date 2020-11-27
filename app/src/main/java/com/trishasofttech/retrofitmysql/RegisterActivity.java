package com.trishasofttech.retrofitmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
EditText etname,etmobile;
Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnsave = findViewById(R.id.btnsave);
        etmobile = findViewById(R.id.etmobile);
        etname = findViewById(R.id.etname);
        btnsave = findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//building retrofit object
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ApiBaseUrl.Base_Url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                //Defining retrofit api service
                ApiService service = retrofit.create(ApiService.class);
                /*add the data into constructor*/
                SignUpResponse user = new SignUpResponse(etname.getText().toString(), etmobile.getText().toString());
//defining the call
                Call<SignUpResponse> call = service.createUser(
                        user.getName(),
                        user.getMobile()
                  );
                //calling the api
                /*call.enqueue(new Callback<SignUpResponse>() {
                    @Override
                    public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {

                        Toast.makeText(RegisterActivity.this,"response.body().toString()",
                                Toast.LENGTH_LONG).show();
                        //displaying the message from the response as toast
                        //Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<SignUpResponse> call, Throwable t) {

                    }


                });*/
                call.enqueue(new retrofit2.Callback<SignUpResponse>() {
                    @Override
                    public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                        Toast.makeText(RegisterActivity.this, "fgbvdgl", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<SignUpResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}