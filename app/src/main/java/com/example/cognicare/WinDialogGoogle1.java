package com.example.cognicare;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialogGoogle1 extends Dialog {

    private final String message;
    private final Activity activity;

    public WinDialogGoogle1(@NonNull Context context, String message) {
        super(context);
        this.message = message;
        this.activity = ((Activity) context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layout_1);

        final TextView messageTV = findViewById(R.id.messageTV);
        final Button exitBtn = findViewById(R.id.exitBtn);

        messageTV.setText(message);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(new Intent(activity, GameTypeActivityGoogle.class));
                activity.finish();
            }
        });
    }
}
