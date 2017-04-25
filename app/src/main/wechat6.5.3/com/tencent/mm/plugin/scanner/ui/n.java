package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Looper;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import com.tencent.mm.e.a.ml;
import com.tencent.mm.plugin.scanner.b.l;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class n extends m {
    public n(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point, displayMetrics, i);
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        v.d("MicroMsg.ScanModeLicenceForIdCardPayAuth", "onDecodeSuccess");
        Vibrator vibrator = (Vibrator) aa.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(new long[]{0, 50}, 1);
        }
        Bitmap bitmap = ((l) this.iAG).iDZ;
        ml mlVar = new ml();
        mlVar.bnF.bnG = "identity";
        mlVar.bnF.bnH = 1;
        if (this.iAG instanceof l) {
            mlVar.bnF.bnJ = bitmap;
        }
        a.nhr.a(mlVar, Looper.getMainLooper());
        this.iAM.aLx().finish();
    }
}
