package com.dephiros.Campaign_parameters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by andy on 3/20/14.
 * http://stackoverflow.com/questions/10986320/android-app-a-wants-to-track-google-play-referral-data-for-android-app-b-install
 */
public class ReferralReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // Workaround for Android security issue: http://code.google.com/p/android/issues/detail?id=16006
        try {
            final Bundle extras = intent.getExtras();
            if (extras != null) {
                extras.containsKey(null);
            }
        } catch (final Exception e) {
            return;
        }

        // Return if this is not the right intent.
        if (!intent.getAction().equals("com.android.vending.INSTALL_REFERRER")) { //$NON-NLS-1$
            return;
        }

        String referrer = intent.getStringExtra("referrer"); //$NON-NLS-1$
        if( referrer == null || referrer.length() == 0) {
            return;
        }

        try {    // Remove any url encoding
            referrer = URLDecoder.decode(referrer, "UTF-8"); //$NON-NLS-1$
        } catch (UnsupportedEncodingException e) { return; }

        
    }
}
