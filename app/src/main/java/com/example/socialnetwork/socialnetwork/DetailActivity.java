package com.example.socialnetwork.socialnetwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "user";
    private TextView tvUserName;
    private TextView tvAge;
    private TextView tvGender;
    private TextView tvSexualOrientation;
    private ImageView ivPhoto;
    private TextView tvCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");

        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvSexualOrientation = (TextView) findViewById(R.id.tvSexualOrientation);
        tvCity = (TextView) findViewById(R.id.tvCity);
        tvAge = (TextView) findViewById(R.id.tvAge);
        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        tvGender = (TextView) findViewById(R.id.tvGender);


        Intent intent = getIntent();
        User user = intent.getParcelableExtra(EXTRA_USER);
        setData(user);


    }

    private void setData(User user) {
        tvUserName.setText(user.getUsername());
        tvAge.setText(String.format("%d anos", user.getAge()));
        tvCity.setText(user.getCity());
        tvSexualOrientation.setText(user.getSexualOrientation());
        Glide.with(this).load(user.getPhotoUrl()).apply(RequestOptions.circleCropTransform()).into(ivPhoto);
        tvGender.setText(user.getGender());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
