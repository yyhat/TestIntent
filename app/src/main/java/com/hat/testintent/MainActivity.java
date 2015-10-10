package com.hat.testintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hat.testjson.ActivityDomXml;
import com.hat.testjson.ActivityGson;
import com.hat.testjson.ActivityJson;
import com.hat.testjson.ActivityPullXml;
import com.hat.testjson.ActivitySaxXml;

public class MainActivity extends Activity {

    public static IntentPassDataType mPassType = IntentPassDataType.APPLICATION;

    String[] mVal = new String[]{
            "Intent全局传递数据",
            "Intent剪切板传递数据",
            "Intent传递数据",
            "练习Intent返回结果",
            "Dom解析XML",
            "Sax解析XML",
            "Pull解析XML",
            "Android json解析JSON",
            "GSON解析JSON"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, mVal));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                             @Override
                                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                 switch (position) {
                                                     case 0:
                                                     case 1:
                                                     case 2:
                                                     case 3: {
                                                         mPassType = IntentPassDataType.values()[position];
                                                         Intent intent = new Intent(MainActivity.this, ActivityFirst.class);
                                                         startActivity(intent);
                                                         break;
                                                     }
                                                     case 4: {
                                                         Intent intent = new Intent(MainActivity.this, ActivityDomXml.class);
                                                         startActivity(intent);
                                                     }
                                                     break;
                                                     case 5: {
                                                         Intent intent = new Intent(MainActivity.this, ActivitySaxXml.class);
                                                         startActivity(intent);
                                                     }
                                                     break;
                                                     case 6: {
                                                         Intent intent = new Intent(MainActivity.this, ActivityPullXml.class);
                                                         startActivity(intent);
                                                     }
                                                     break;
                                                     case 7: {
                                                         Intent intent = new Intent(MainActivity.this, ActivityJson.class);
                                                         startActivity(intent);
                                                     }
                                                     break;
                                                     case 8: {
                                                         Intent intent = new Intent(MainActivity.this, ActivityGson.class);
                                                         startActivity(intent);
                                                     }
                                                     break;
                                                 }
                                             }
                                         }

        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
