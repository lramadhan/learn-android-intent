package com.belajar.intentdicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = findViewById(R.id.tv_object_received);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Hallo, saya " + person.getName() + " dari " + person.getCity() + ", berumur " + person.getAge() + ". Hubungi saya ke " + person.getEmail();
        tvObject.setText(text);
    }
}
