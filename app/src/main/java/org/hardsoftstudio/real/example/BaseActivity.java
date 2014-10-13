package org.hardsoftstudio.real.example;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Marcel on 13/10/2014.
 */
public class BaseActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_git) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/skimarxall/RealTextView")));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
