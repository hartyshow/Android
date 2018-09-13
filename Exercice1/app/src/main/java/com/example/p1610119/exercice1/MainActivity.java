package com.example.p1610119.exercice1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button goToFilmDetailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToFilmDetailsButton = findViewById(R.id.goToFilmDetailsButton);
        goToFilmDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFilmDetailsClick(view);
            }
        });
    }

    public void goToFilmDetailsClick (View view) {
        Intent intent = new Intent(MainActivity.this, FilmDetailsActivity.class);
        startActivity(intent);
    }

}
