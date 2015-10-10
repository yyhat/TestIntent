package com.hat.testjson;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.hat.testintent.R;
import com.hat.tools.JsonParserUtils;
import com.hat.tools.PullParserUtils;
import com.hat.tools.UtilRaw;

import java.util.List;

/**
 * Created by anting.hu on 2015/10/8.
 * 解析json
 */
public class ActivityJson extends Activity{
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dom);
        mTextView = (TextView)findViewById(R.id.textView);

        List<Person> persons = JsonParserUtils.parserJsonByJSON(UtilRaw.readFile(ActivityJson.this, R.raw.person_json));
        String content="";
        for(int i=0; i<persons.size(); i++)
        {
            content += persons.get(i).toString() + "\n";
        }

        mTextView.setText(content);
    }
}
