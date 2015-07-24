package ir.FSco.HamyarNet_Charge_Viewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by hamid on 05/20/2015.
 */
public class about_us extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
    }

    public void back_main(View view){
        Intent back_main = new Intent(this,main.class);
        startActivity(back_main);
    }
}
