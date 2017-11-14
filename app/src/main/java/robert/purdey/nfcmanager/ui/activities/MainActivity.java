package robert.purdey.nfcmanager.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import robert.purdey.nfcmanager.R;
import robert.purdey.nfcmanager.ui.helper.ActivityDirector;

/**
 * Purpose:
 *      Directs user to sections of the application:
 *        1. NFC Writing
 *        2. NFC Reading
 *        3. NFC Tasks
 *        4. Other NFC functions
 *
 * Developers:
 *  Danny Lieu & Robert Purdey
 *
 * Date:
 *  Nov 11 2017
 *
 * Revisions:
 */
public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Opens NFC Write activity
     *
     * @param v
     */
    public void onClickWrite(View v)
    {
        ActivityDirector.startWriteActivity(this);
    }
}
