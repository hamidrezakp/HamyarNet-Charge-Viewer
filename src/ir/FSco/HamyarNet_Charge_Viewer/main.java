package ir.FSco.HamyarNet_Charge_Viewer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/Android/obb/ir.FSco.HamyarNet_Charge_Viewer/set.db");
        if(!file.exists()){
            Intent goto_setting = new Intent(this,setting.class);
            startActivity(goto_setting);
        }
        try {
            get_data_server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reload_menu:
                try {
                    get_data_server();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }

            case R.id.setting_menu:
                Intent goto_setting = new Intent(this,setting.class);
                startActivity(goto_setting);
                return true;

            case R.id.about_us:
                Intent goto_about_us = new Intent(this,about_us.class);
                startActivity(goto_about_us);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public String[] read_data() throws IOException {
        FileReader fileReader = new FileReader(Environment.getExternalStorageDirectory().getPath() + "/Android/obb/ir.FSco.HamyarNet_Charge_Viewer/set.db");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);

    }

    protected class DownloadPage extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {

            String responseStr = null;

            try {
                for (String url : urls) {
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    HttpGet get = new HttpGet(url);
                    get.addHeader("Cookie", "IBS_SESSID=hlpjpnm8hdrf84n7igk0m5n9v6; session_id=f49f028f0c3b87719638136ce5cd5f23090eca5e");
                    HttpResponse httpResponse = httpClient.execute(get);
                    HttpEntity httpEntity = httpResponse.getEntity();
                    responseStr = EntityUtils.toString(httpEntity);
                }
            } catch (UnsupportedEncodingException e) {

            } catch (ClientProtocolException e) {

            } catch (IOException e) {

            }
            return responseStr;
        }

        protected void onPostExecute(String s) {
            TextView gig = (TextView) findViewById(R.id.gig);
            TextView charge = (TextView) findViewById(R.id.charge);
            TextView createdin = (TextView) findViewById(R.id.createdin);
            TextView expirein = (TextView) findViewById(R.id.expirein);
            TextView savedcharge = (TextView) findViewById(R.id.savedcharge);
            TextView savedgig = (TextView) findViewById(R.id.savedgig);
            TextView freenight = (TextView) findViewById(R.id.freenight);
            TextView username = (TextView) findViewById(R.id.usernamelbl);
            if (s == null ){
                return;
            }
            Scanner scanner = new Scanner(s);
            List<String> lines = new ArrayList<String>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
            for (int n = 0; n < lines.size(); n++) {
                String line = lines.get(n).toString();
                if (line.contains("            <td class=\"List_Col\" valign=\"Middle\" >                           ") && line.contains("</sub>")) {
                    gig.setText(getBetween(line, "            <td class=\"List_Col\" valign=\"Middle\" >                           ", "<sub>") + getBetween(line, "<sub>", "</sub>"));

                }
                if (line.contains("                    <td class=\"Form_Content_Row_Right_2Col_light\">") && line.contains("RIALS</td>")) {
                    charge.setText(getBetween(line, "                    <td class=\"Form_Content_Row_Right_2Col_light\">", "</td>"));
                }
                if (line.contains("                    <td class=\"Form_Content_Row_Right_2Col_light\">") && line.contains("</td>")) {
                    createdin.setText(getBetween(line, "                    <td class=\"Form_Content_Row_Right_2Col_light\">", "</td>"));
                }
                if (line.contains("</td>                    <td class=\"Form_Content_Row_Right_2Col_light\">") && lines.get(n - 1).toString().contains("                <td class=\"Form_Content_Row_Begin\"><img border=\"0\" src=\"/IBSng/images/row/begin_of_row_light.gif\"></td>")) {
                    expirein.setText(getBetween(line, "</td>                    <td class=\"Form_Content_Row_Right_2Col_light\">", "</td>"));
                }
                if (line.contains("Renew :</td>                    <td class=\"Form_Content_Row_Right_2Col_dark\">")) {
                    savedcharge.setText(getBetween(line, "Renew :</td>                    <td class=\"Form_Content_Row_Right_2Col_dark\">", "</td>"));
                }
                if (line.contains("                    <td class=\"Form_Content_Row_Right_2Col_dark\">") && line.contains("<span>GB</span></td>")) {
                    savedgig.setText(getBetween(line, "                    <td class=\"Form_Content_Row_Right_2Col_dark\">", " &nbsp;<span>GB</span></td>") + " GIG");
                }
                if (line.contains("            <td class=\"List_Col\" valign=\"Middle\" >                           ") && lines.get(n - 1).contains("                    </td>           ") && lines.get(n - 2).contains("        </td>            <td class=\"List_Col\" valign=\"Middle\" >                           -")) {
                    if (line.matches(".*\\d.*")) {
                        freenight.setText("NO!");
                    } else {
                        freenight.setText("YES!");
                    }
                }

                if (line.contains(":</td>                    <td class=\"Form_Content_Row_Right_2Col_light\">") && !lines.get(n + 2).contains("                    <td class=\"Form_Content_Col_Space\">&nbsp;</td>")) {
                    username.setText(getBetween(line, "<td class=\"Form_Content_Row_Right_2Col_light\">", "</td>"));
                }
            }


        }

    }

    public static String getBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    public void get_data_server() throws IOException {
        encrypt dec = new encrypt();
        String[] data = read_data();
        String username = dec.decrypt(data[0]);
        String password = dec.decrypt(data[1]);
        DownloadPage task = new DownloadPage();
        task.execute(new String[] { "http://accounting.hamyar.net/IBSng/user/index.php?normal_username="+username+"&normal_password="+password });
    }


}
