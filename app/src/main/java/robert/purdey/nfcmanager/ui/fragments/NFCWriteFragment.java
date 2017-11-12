package robert.purdey.nfcmanager.ui.fragments;

import android.support.v4.app.Fragment;

/**
 * Purpose:
 *      Contains callback to send back formatted data to an activity
 *
 * Developers:
 *  Danny Lieu & Robert Purdey
 *
 * Date:
 *  Nov 11 2017
 *
 * Revisions:
 */
public abstract class NFCWriteFragment extends Fragment
{
    abstract protected String getFormattedData();
}