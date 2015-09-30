package com.hat.testintent;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by anting.hu on 2015/9/30.
 */
public class ActivityOther extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        TextView tv = (TextView)findViewById(R.id.id_textView);
        switch (MainActivity.mPassType) {
            case APPLICATION:
                MyApp app = (MyApp) getApplication();
                tv.setText(app.getName());
                break;
            case CLIPBOARD:
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                tv.setText(cm.getText().toString());
                break;
        }
    }
}
