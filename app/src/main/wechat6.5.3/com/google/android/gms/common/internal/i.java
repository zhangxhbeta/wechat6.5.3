package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;

public final class i implements OnClickListener {
    private final Intent OH;
    private final Fragment aoD;
    private final int aoE;
    private final Activity pP;

    public i(Activity activity, Intent intent, int i) {
        this.pP = activity;
        this.aoD = null;
        this.OH = intent;
        this.aoE = 2;
    }

    public i(Fragment fragment, Intent intent, int i) {
        this.pP = null;
        this.aoD = fragment;
        this.OH = intent;
        this.aoE = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.OH != null && this.aoD != null) {
                this.aoD.startActivityForResult(this.OH, this.aoE);
            } else if (this.OH != null) {
                this.pP.startActivityForResult(this.OH, this.aoE);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
        }
    }
}
