package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.m.a.a;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.util.Map;
import junit.framework.Assert;

public final class c {
    a nQq;

    c(a aVar) {
        this.nQq = aVar;
    }

    public final int a(d dVar) {
        boolean z = true;
        Assert.assertTrue(dVar != null);
        if (dVar.nQs == null) {
            z = false;
        }
        Assert.assertTrue(z);
        Drawable a = a(this.nQq.lFi, dVar.nQr.getContext());
        if (a == null) {
            return -1;
        }
        dVar.nQr.setBackgroundDrawable(a);
        dVar.nQs.setVisibility(this.nQq.lFc ? 0 : 8);
        return 0;
    }

    private static Drawable a(Map<String, String> map, Context context) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str = (String) map.get(displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        if (str == null) {
            b bVar = new b();
            displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            String str2 = SQLiteDatabase.KeyEmpty;
            str = displayMetrics.density < 1.0f ? str2 + "LDPI" : displayMetrics.density >= 1.5f ? str2 + "HDPI" : str2 + "MDPI";
            str = (String) map.get(str + (configuration.orientation == 2 ? "_L" : "_P"));
        }
        if (t.ma(str).length() <= 0) {
            return null;
        }
        a.a Hn = a.Hn(str);
        if (Hn == a.a.ERROR) {
            return null;
        }
        str = a.Hm(str);
        if (t.ma(str).length() <= 0) {
            return null;
        }
        try {
            Bitmap a;
            float density;
            if (Hn == a.a.ASSET) {
                InputStream open = context.getAssets().open(str);
                density = com.tencent.mm.bd.a.getDensity(context);
                b bVar2 = new b();
                a = d.a(open, density);
            } else {
                float density2 = com.tencent.mm.bd.a.getDensity(context);
                b bVar3 = new b();
                density = 160.0f * density2;
                a = d.d(str, density2);
                if (a != null) {
                    a.setDensity((int) density);
                }
            }
            if (a == null) {
                v.e("MicroMsg.ADListView.Message", "get Bitmap failed type:" + Hn + " path:" + str);
                return null;
            }
            byte[] ninePatchChunk = a.getNinePatchChunk();
            if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new NinePatchDrawable(a, ninePatchChunk, new Rect(), null);
            }
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, displayMetrics2.widthPixels, (displayMetrics2.widthPixels * a.getHeight()) / a.getWidth(), true);
            if (createScaledBitmap != null) {
                if (a != createScaledBitmap) {
                    v.i("MicroMsg.ADListView.Message", "recycle bitmap:%s", a);
                    a.recycle();
                }
                a = createScaledBitmap;
            }
            Drawable bitmapDrawable = new BitmapDrawable(a);
            bitmapDrawable.setTargetDensity(displayMetrics2);
            return bitmapDrawable;
        } catch (Throwable e) {
            v.a("MicroMsg.ADListView.Message", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }
}
