package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            m.lO();
            Uri data = getIntent().getData();
            if (!d.M(this).d(data)) {
                CharSequence charSequence = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                m.lN();
                AlertDialog create = new Builder(this).create();
                create.setTitle("Preview failure");
                create.setMessage(charSequence);
                create.setButton(-1, "Continue", new OnClickListener(this) {
                    final /* synthetic */ PreviewActivity aCi;

                    {
                        this.aCi = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                create.show();
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                new StringBuilder("Invoke the launch activity for package name: ").append(getPackageName());
                m.lO();
                startActivity(launchIntentForPackage);
                return;
            }
            new StringBuilder("No launch activity found for package name: ").append(getPackageName());
            m.lO();
        } catch (Exception e) {
            new StringBuilder("Calling preview threw an exception: ").append(e.getMessage());
            m.lL();
        }
    }
}
