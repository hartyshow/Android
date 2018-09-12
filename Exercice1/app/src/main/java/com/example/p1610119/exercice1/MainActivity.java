package com.example.p1610119.exercice1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private LinearLayout backTitleLinearLayout;
    private ImageButton closeImageButton;

    private LinearLayout shareLinearLayout;
    private LinearLayout commentLinearLayout;

    private LinearLayout likeLinearLayout;
    private ImageView likeImageView;
    private TextView likeTextView;

    private EditText commentEditText;
    private ImageButton sendImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backTitleLinearLayout = findViewById(R.id.back_title);
        backTitleLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backClick(view);
            }
        });

        closeImageButton = findViewById(R.id.close);
        closeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeClick(view);
            }
        });

        shareLinearLayout = findViewById(R.id.share);
        shareLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareClick(view);
            }
        });

        commentLinearLayout = findViewById(R.id.comment);
        commentLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commentClick(view);
            }
        });

        likeLinearLayout = findViewById(R.id.like);
        likeImageView = findViewById(R.id.likeImageView);
        likeTextView = findViewById(R.id.likeTextView);
        likeLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeClick(view);
            }
        });

        commentEditText = findViewById(R.id.commentEditText);

        sendImageButton = findViewById(R.id.send);
        sendImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendClick(view);
            }
        });
    }

    private void sendClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder .setTitle("Contenu du commentaire")
                .setMessage(commentEditText.getText())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }

    private void closeClick(View view) {

    }

    private void backClick(View view) {

    }

    private void shareClick(View view) {
        Toast.makeText(this, "Le film a bien été partagé !", Toast.LENGTH_SHORT).show();
    }

    private void commentClick(View view) {
        commentEditText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(commentEditText, InputMethodManager.SHOW_IMPLICIT);
    }

    private void likeClick(View view) {

        if (likeTextView.getText().toString().equals("Dislike")) {
            likeImageView.setImageResource(R.drawable.ic_like);
            likeTextView.setText("Like");
            likeLinearLayout.setBackground(getResources().getDrawable(R.drawable.border));
        }
        else {
            likeImageView.setImageResource(R.drawable.ic_unlike);
            likeTextView.setText("Dislike");
            likeLinearLayout.setBackground(getResources().getDrawable(R.drawable.border_fonce));
        }
    }
}
