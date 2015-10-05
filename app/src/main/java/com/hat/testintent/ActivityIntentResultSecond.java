package com.hat.testintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by anting.hu on 2015/9/30.
 */
public class ActivityIntentResultSecond extends Activity {

    EditText resultEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_result_second);

        Intent intent = getIntent();
        int a = intent.getIntExtra("para1", 0);
        int b = intent.getIntExtra("para2", 0);
        TextView tv = (TextView)findViewById(R.id.tip_tv);
        tv.setText(a + "+" + b + "=");

        resultEditText = (EditText)findViewById(R.id.calResult_et);

        Button btn = (Button)findViewById(R.id.returnBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = Integer.parseInt(resultEditText.getText().toString());
                Intent resultIntent = new Intent();
                resultIntent.putExtra("three", result);
                setResult(2, resultIntent);
                finish();
            }
        });
    }
}
