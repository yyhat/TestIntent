package com.hat.testjson;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.hat.testintent.R;
import com.hat.tools.DomParserUtils;

import java.util.List;

/**
 * Created by anting.hu on 2015/10/7.
 */
public class ActivityDomXml extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView mTextView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom);
        mTextView = (TextView)findViewById(R.id.textView);

        List<Person> persons = DomParserUtils.parserXmlByDom(ActivityDomXml.this, R.raw.person_xml);
        String content="";
        for(int i=0; i<persons.size(); i++)
        {
            content += persons.get(i).toString() + "\n";
        }

        mTextView.setText(content);
    }

}
