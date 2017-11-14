package robert.purdey.nfcmanager.nfchandling;

import android.content.Context;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;

import java.io.IOException;

/**
 * Purpose:
 *      Handles writing data to an NFC tag.
 *
 * Developers:
 *  Danny Lieu & Robert Purdey
 *
 * Date:
 *  Nov 11 2017
 *
 * Revisions:
 */
public class NfcWriter
{

    /**
     * Coordinates writing to the NFC tag.
     *
     * @param context - activity handling the tap
     * @param tag - NFC tag to write to
     * @param recordToWrite the record to write to the NFC tag
     *
     * @return true if tag is written to, false otherwise
     */
    public boolean writeTag(Context context, Tag tag, NdefRecord recordToWrite)
    {
        boolean isValid = false;

        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(context);

        if (validateCanWrite(nfcAdapter, "Test") )
        {
            if (writeToTag(context, tag, recordToWrite) )
            {
                // success
                isValid = true;
            }
        }

        return isValid;
    }

    /**
     * Handles writing the NdefRecord to the tag.
     *
     * Exceptions are caught and handled.
     *
     * @param context - activity handling the tap
     * @param tag - NFC tag to write to
     * @param recordToWrite the record to write to the NFC tag
     *
     * @return true if the tag is written to, false otherwise.
     */
    private boolean writeToTag(Context context, Tag tag, NdefRecord recordToWrite)
    {
        String message      = "test message";
        NdefMessage ndefMsg = new NdefMessage(recordToWrite);

        try {
            // If the tag is already formatted, just write the message to it
            Ndef ndef = Ndef.get(tag);
            if(ndef != null) {
                ndef.connect();

                // Make sure the tag is writable
                if(!ndef.isWritable()) {
                    // read only error
                    return false;
                }

                // get byte size
                if(ndef.getMaxSize() > message.length() )
                {
                    // bad space error
                    return false;
                }
                // attempt to write message
                try {
                    // Write the data to the tag
                    ndef.writeNdefMessage(ndefMsg);

                    // write successful
                    return true;
                } catch (TagLostException tle) {
                    // tag lost error
                    return false;
                } catch (IOException ioe) {
                    // input output exception
                    return false;
                } catch (FormatException fe) {
                    // format exception
                    return false;
                }
            // If the tag is not formatted, format it with the message
            } else {
                NdefFormatable format = NdefFormatable.get(tag);
                if(format != null) {
                    // attempt to write message
                    try {
                        format.connect();
                        format.format(ndefMsg);

                        // written success
                        return true;
                    } catch (TagLostException tle) {
                        // tag lost error
                        return false;
                    } catch (IOException ioe) {
                        // input output exception
                        return false;
                    } catch (FormatException fe) {
                        // format exception
                        return false;
                    }
                } else {
                    // no ndef found
                    return false;
                }
            }
        } catch(Exception e) {
            // unknown error
        }

        return false;
    }

    // validate nfc tag can be written to
    private boolean validateCanWrite(NfcAdapter nfcAdapter, String payload)
    {
        boolean isValid = true;

        // Validate phone enabled nfc
        if (NfcValidator.validateNfcEnabled(nfcAdapter) == false)
            isValid = false;

        // Validate payload will fit on nfc

        // validate nfc can be written to

        return isValid;
    }
}
