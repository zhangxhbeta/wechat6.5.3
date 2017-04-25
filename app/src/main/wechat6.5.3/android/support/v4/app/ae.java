package android.support.v4.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class ae extends android.support.v4.app.ag.a {
    private static final b sW;
    public static final android.support.v4.app.ag.a.a sX = new android.support.v4.app.ag.a.a() {
    };
    private final Bundle mExtras;
    private final String sS;
    private final CharSequence sT;
    private final CharSequence[] sU;
    private final boolean sV;

    public static final class a {
        public Bundle mExtras = new Bundle();
        public final String sS;
        public CharSequence sT;
        public CharSequence[] sU;
        public boolean sV = true;

        public a(String str) {
            this.sS = str;
        }
    }

    interface b {
        Bundle getResultsFromIntent(Intent intent);
    }

    static class c implements b {
        c() {
        }

        public final Bundle getResultsFromIntent(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static class d implements b {
        d() {
        }

        public final Bundle getResultsFromIntent(Intent intent) {
            return null;
        }
    }

    static class e implements b {
        e() {
        }

        public final Bundle getResultsFromIntent(Intent intent) {
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                ClipDescription description = clipData.getDescription();
                if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals("android.remoteinput.results")) {
                    return (Bundle) clipData.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
                }
            }
            return null;
        }
    }

    private ae(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.sS = str;
        this.sT = charSequence;
        this.sU = charSequenceArr;
        this.sV = z;
        this.mExtras = bundle;
    }

    public final String getResultKey() {
        return this.sS;
    }

    public final CharSequence getLabel() {
        return this.sT;
    }

    public final CharSequence[] getChoices() {
        return this.sU;
    }

    public final boolean getAllowFreeFormInput() {
        return this.sV;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return sW.getResultsFromIntent(intent);
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            sW = new c();
        } else if (VERSION.SDK_INT >= 16) {
            sW = new e();
        } else {
            sW = new d();
        }
    }
}
