package robert.purdey.nfcmanager.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import robert.purdey.nfcmanager.R;
import robert.purdey.nfcmanager.nfchandling.NFCWriter;
/**
 * Purpose:
 *      Guides the user through writing data to an NFC tag.
 *
 * Developers:
 *  Danny Lieu & Robert Purdey
 *
 * Date:
 *  Nov 11 2017
 *
 * Revisions:
 */
public class NFCWriteActivity extends AppCompatActivity
{

    /* Handles writing the user data to the NFC tag */
    protected NFCWriter nfcWriter = new NFCWriter();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfcwrite);
    }

    public void onClickWrite(View v)
    {
        // validate user input
        // if valid
            // attempt writing to NFC
            // if failed to write
                // display error
            // else
                // display success
        // else
            // display user error msg
    }
}
