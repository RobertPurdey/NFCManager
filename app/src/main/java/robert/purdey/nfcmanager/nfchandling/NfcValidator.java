package robert.purdey.nfcmanager.nfchandling;

import android.nfc.NfcAdapter;

/**
 * Purpose:
 *      Validates phone is NFC capable
 *
 * Developers:
 *  Danny Lieu & Robert Purdey
 *
 * Date:
 *  Nov 11 2017
 *
 * Revisions:
 */
public class NfcValidator
{
    // validates android phone has NFC enabled

    /**
     * Purpose:
     *      Checks if the phone has NFC enabled.
     *
     * Returns:
     *      False - NFC is NOT enabled
     *      True  - NFC is enabled
     */
    public static boolean validateNfcEnabled(NfcAdapter nfcAdapter)
    {
        boolean isValid = false;

        if (nfcAdapter != null && nfcAdapter.isEnabled() )
            isValid = true;

        return isValid;
    }
}
