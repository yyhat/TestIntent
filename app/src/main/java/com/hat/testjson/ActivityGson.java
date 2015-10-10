package com.hat.testjson;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.hat.testintent.R;
import com.hat.tools.GsonParserUtils;
import com.hat.tools.JsonParserUtils;
import com.hat.tools.UtilRaw;

import java.util.List;

/**
 * Created by anting.hu on 2015/10/8.
 */
public class ActivityGson extends Activity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dom);
        mTextView = (TextView)findViewById(R.id.textView);

        List<Person> persons = GsonParserUtils.getPersons(UtilRaw.readFile(ActivityGson.this, R.raw.person_json), Person.class);
        String content="";
        for(int i=0; i<persons.size(); i++)
        {
            content += persons.get(i).toString() + "\n";
        }

        mTextView.setText(content);
    }
}
