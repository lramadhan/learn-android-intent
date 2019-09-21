package com.belajar.intentdicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMoveActivity, btnMoveWithData, btnMoveWithObject, btnDialNumber, btnMoveForResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveWithData = findViewById(R.id.btn_move_with_data);
        btnMoveWithObject = findViewById(R.id.btn_move_with_object);
        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnMoveForResult = findViewById(R.id.btn_move_for_result);
        tvResult = findViewById(R.id.tv_result);

        btnMoveActivity.setOnClickListener(this);
        btnMoveWithData.setOnClickListener(this);
        btnMoveWithObject.setOnClickListener(this);
        btnDialNumber.setOnClickListener(this);
        btnMoveForResult.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
            break;
            case R.id.btn_move_with_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Ramadhan");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 11);
                startActivity(moveWithDataIntent);
            break;
            case R.id.btn_move_with_object:
                Person person = new Person();
                person.setName("Ramadhan");
                person.setAge(15);
                person.setCity("Tasikmalaya");
                person.setEmail("hanafiah.ramadhan@gmail.com");

                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
                startActivity(moveWithObjectIntent);
            break;
            case R.id.btn_dial_number:
                String phoneNumber = "087778930200";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
            break;
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Memilih: %s", selectedValue));
            }
        }
    }
}
