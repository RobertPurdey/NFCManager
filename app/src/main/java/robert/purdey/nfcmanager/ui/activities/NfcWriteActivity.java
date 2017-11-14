package robert.purdey.nfcmanager.ui.activities;

import android.nfc.NdefRecord;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import robert.purdey.nfcmanager.R;
import robert.purdey.nfcmanager.nfchandling.NfcWriter;
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
public class NfcWriteActivity extends AppCompatActivity
{
    /* Handles writing the user data to the NFC tag */
    protected NfcWriter nfcWriter = new NfcWriter();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfcwrite);
    }

    public void onClickWrite(View v)
    {
        // get edit text field values
        String etxtLat  = ((EditText) findViewById(R.id.etxt_latitude)).getText().toString();
        String etxtLong = ((EditText) findViewById(R.id.etxt_longitude)).getText().toString();

        if (validateInputValue(etxtLat) && validateInputValue(etxtLong)) {
            NdefRecord ndefRecord = getFormattedData(etxtLat, etxtLong);

            // write to tag
            // todo: get tag
            //Tag tag = get tag
            //nfcWriter.writeTag(this, tag, ndefRecord);
        }
        // validate user input
        // if valid
        // todo: get uri from fragment ??

        //nfcWriter.writeTag(this, NdefRecord.createUri(geoUri) );
            // if failed to write
                // display error
            // else
                // display success
        // else
            // display user error msg
    }

    /**
     * Validates input value is a valid entry (not null and length > 0.
     *
     * @param inputVal - value to validate.
     *
     * @return true if valid, false otherwise.
     */
    private boolean validateInputValue(String inputVal)
    {
        return inputVal != null && inputVal.length() > 0;
    }
    /**
     * Creates a geo location uri formatted for an NFC tag
     *
     * @param latitude - latitude coordinate for the geo location to be added
     * @param longitude - longitude coordinate for the geo location to be added
     *
     * @return NdefRecord - Record ready to be written to an NFC tag
     */
    // todo: override once inheriting from NfcWriteFragment
    private NdefRecord getFormattedData(String latitude, String longitude)
    {

        String geoUri = "geo:" + latitude + "," + longitude;
        return NdefRecord.createUri(geoUri);
    }
}
