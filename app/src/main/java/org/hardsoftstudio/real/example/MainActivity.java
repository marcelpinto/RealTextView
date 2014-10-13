package org.hardsoftstudio.real.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity_main);
        findViewById(R.id.w_rbut_realexample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExampleMainActivity.class));
            }
        });
        findViewById(R.id.w_rbut_htmlexample).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HtmlExampleActivity.class));
            }
        });
    }

}
