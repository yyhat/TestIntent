package com.hat.testintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by anting.hu on 2015/9/30.
 */
public class ActivityIntentResultFirst extends Activity {

    final static int REQUEST_CODE = 1;

    private EditText et1;
    private EditText et2;
    private TextView result_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_result_first);
        Button btn = (Button)findViewById(R.id.calResultBtn);

        et1 = (EditText)findViewById(R.id.para1_et);
        et2 = (EditText)findViewById(R.id.para2_et);
        result_tv = (TextView)findViewById(R.id.result_tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a  = Integer.parseInt(et1.getText().toString());
                int b  = Integer.parseInt(et2.getText().toString());

                Intent intent = new Intent(ActivityIntentResultFirst.this, ActivityIntentResultSecond.class);
                intent.putExtra("para1", a);
                intent.putExtra("para2", b);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 2)
        {
            if(requestCode == REQUEST_CODE)
            {
                int result  = data.getIntExtra("three", 0);
                result_tv.setText(result+"");
            }
        }
    }
}
