package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class RedirectToChattingByPhoneStubUI extends Activity implements e {
    private p fHW = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getString(2131231182);
        this.fHW = g.a((Context) this, SQLiteDatabase.KeyEmpty, false, null);
        ad.g(new Runnable(this) {
            final /* synthetic */ RedirectToChattingByPhoneStubUI fHX;

            {
                this.fHX = r1;
            }

            public final void run() {
                this.fHX.ale();
            }
        }, 500);
        ak.vy().a((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, (e) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, (e) this);
        if (this.fHW != null) {
            this.fHW.dismiss();
            this.fHW = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        finish();
    }

    public final boolean ale() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            v.e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        v.v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        return hideSoftInputFromWindow;
    }
}
