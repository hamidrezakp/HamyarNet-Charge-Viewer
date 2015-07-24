package ir.FSco.HamyarNet_Charge_Viewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hamid on 05/19/2015.
 */
public class setting extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
    }

    public void goto_main(View v) {
        Intent goto_main = new Intent(this, main.class);
        startActivity(goto_main);
    }

    public void save_setting(View v) throws IOException {
        EditText username = (EditText)findViewById(R.id.user);
        EditText password = (EditText)findViewById(R.id.psw);
        if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),getString(R.string.setting_fill_error),Toast.LENGTH_SHORT).show();
            return;
        }
        save_date(username.getText().toString(),password.getText().toString());
        Intent goto_main = new Intent(this, main.class);
        startActivity(goto_main);

    }

    public void save_date(String username, String password) throws IOException {
        File folder = new File(Environment.getExternalStorageDirectory() + "/Android/obb/ir.FSco.HamyarNet_Charge_Viewer/");
        if (!folder.exists()){
            folder.mkdir();
        }
        File file = new File(Environment.getExternalStorageDirectory().getPath() + "/Android/obb/ir.FSco.HamyarNet_Charge_Viewer/set.db");

        if(!file.exists()) {
            file.createNewFile();
        }else{
            file.delete();
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        encrypt enc = new encrypt();
        String data = enc.encrypt(username) + "\n" + enc.encrypt(password);
        bw.write(data);
        bw.close();
        fw.close();

    }


}




