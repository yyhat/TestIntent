package com.hat.tools;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

import com.hat.testintent.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by anting.hu on 2015/10/7.
 */
public class UtilRaw {
    public static String readFile(Context context, int rawId) {
        Resources res = context.getResources();
        InputStream in = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        sb.append("");
        try {
            in = res.openRawResource(rawId);
            String str;
            br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }
        } catch (Resources.NotFoundException e) {
            Toast.makeText(context, "文本文件不存在", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            Toast.makeText(context, "文本编码出现异常",  Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(context, "文件读取错误",  Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
