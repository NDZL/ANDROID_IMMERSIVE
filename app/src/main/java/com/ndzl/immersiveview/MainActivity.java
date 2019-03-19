package com.ndzl.immersiveview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;


/*
* adb shell wm overscan 0,0,0,-187
adb shell wm overscan 0,0,0,0
* */
public class MainActivity extends Activity {

    static boolean isNavbarVisible = true;

    Button btHideShowNavBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btHideShowNavBar = findViewById(R.id.btHideShowNavBar);
        btHideShowNavBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNavbarVisible){
                    isNavbarVisible=false;
                    View decorView = getWindow().getDecorView();
                    //int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
                    int uiOptions =  View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

                    decorView.setSystemUiVisibility(uiOptions);
                }
                else {
                    isNavbarVisible=true;
                    View decorView = getWindow().getDecorView();
                    int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
                    decorView.setSystemUiVisibility(uiOptions);
                }
                                                }
                                            }
        );
    }
}
