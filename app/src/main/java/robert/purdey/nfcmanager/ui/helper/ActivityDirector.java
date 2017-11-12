package robert.purdey.nfcmanager.ui.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import robert.purdey.nfcmanager.ui.activities.MainActivity;
import robert.purdey.nfcmanager.ui.activities.NFCWriteActivity;

/**
 * Purpose:
 *      Provides helper functions to switch activities
 *
 * Developers:
 *  Danny Lieu & Robert Purdey
 *
 * Date:
 *  Nov 11 2017
 *
 * Revisions:
 */
public class ActivityDirector
{
    /**
     * Starts Main Menu Activity
     *
     * @param context
     */
    public static void startMainActivity(Context context)
    {
        startActivity(context, MainActivity.class);
    }

    /**
     * Starts Write Activity
     *
     * @param context
     */
    public static void startNFCWriteActivity(Context context)
    {
        startActivity(context, NFCWriteActivity.class);
    }

    /**
     * Starts Read Activity
     *
     * @param context
     */
    public static void startReadActivity(Context context)
    {
        //startActivity(context, ReadActivity.class);
    }

    /**
     * Starts Tasks Activity
     *
     * @param context
     */
    public static void startTasksActivity(Context context)
    {
        //startActivity(context, TasksActivity.class);
    }

    /**
     * Starts Other Activity
     *
     * @param context
     */
    public static void startOtherActivity(Context context)
    {
        //startActivity(context, OtherActivity.class);
    }


    /**
     * Starts Score Game Activity loading the game for the id passed in as gameId
     *
     * @param context
     * @param gameId - id of game to score
     */
    public static void startWriteActivity(Context context, long gameId)
    {
       // Intent intent = new Intent(context, ScoreGameActivity.class);
        //intent.putExtra(ScoreGameActivity.GAME_PKEY_TAG, gameId);

      //  context.startActivity(intent);
    }

    /**
     * starts an Activity
     *
     * @param context
     * @param activityClass activity class to start
     */
    public static void startActivity(Context context, Class<? extends Activity> activityClass)
    {
        Intent intent = new Intent(context, activityClass);
        context.startActivity(intent);
    }
}
