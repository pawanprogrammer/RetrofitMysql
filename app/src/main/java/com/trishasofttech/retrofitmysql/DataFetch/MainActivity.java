package com.trishasofttech.retrofitmysql.DataFetch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.trishasofttech.retrofitmysql.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvmsg = findViewById(R.id.tvmsg);
        fetchData();
    }

    private void fetchData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<List<Details_Pojo>> call = api.getstatus();
        call.enqueue(new Callback<List<Details_Pojo>>() {
            @Override
            public void onResponse(Call<List<Details_Pojo>> call, Response<List<Details_Pojo>> response) {
                List<Details_Pojo> adslist = response.body();

                String name = adslist.get(0).getName();
                String phone = adslist.get(0).getMobile();

                tvmsg.setText(name+ "\n"+ phone);


            }

            @Override
            public void onFailure(Call<List<Details_Pojo>> call, Throwable t) {

                Toast.makeText(MainActivity.this, ""+t.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}