package com.hat.testintent;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by anting.hu on 2015/9/30.
 */
public class ActivityFirst extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button btn = (Button)findViewById(R.id.id_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (MainActivity.mPassType)
                {
                    case APPLICATION: {
                        MyApp app = (MyApp) getApplication();
                        app.setName("Application传输数据");
                        Intent intent = new Intent(ActivityFirst.this, ActivityOther.class);
                        startActivity(intent);
                    }
                        break;
                    case CLIPBOARD: {
                        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        cm.setText("剪切板传输数据");
                        Intent intent = new Intent(ActivityFirst.this, ActivityOther.class);
                        startActivity(intent);
                    }
                        break;
                }

            }
        });
    }
}
