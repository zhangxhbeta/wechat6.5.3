package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public final class d implements i {
    private String fKF;
    private int height;
    private String url;
    private int width;

    public d(String str, String str2, int i, int i2) {
        this.fKF = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
    }

    public final String MU() {
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return stringBuilder.append(c.wP()).append("/").append(g.m(this.url.getBytes())).toString();
    }

    public final String MV() {
        return this.url;
    }

    public final String MW() {
        return this.fKF;
    }

    public final String MX() {
        return this.fKF;
    }

    public final boolean MY() {
        return true;
    }

    public final boolean MZ() {
        return false;
    }

    public final Bitmap Na() {
        return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838793);
    }

    public final Bitmap a(Bitmap bitmap, a aVar) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (a.NET == aVar) {
            try {
                v.v("MicroMsg.DefaultPicStrategy", "handlerBitmap get from net url:%s", this.url);
                if (this.width > 0 && this.height > 0) {
                    bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, this.width, this.height, true);
                }
                File file = new File(MU());
                file.createNewFile();
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            v.a("MicroMsg.DefaultPicStrategy", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = null;
                    v.a("MicroMsg.DefaultPicStrategy", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Throwable e4) {
                v.a("MicroMsg.DefaultPicStrategy", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return bitmap;
    }

    public final void Nb() {
    }

    public final void H(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}
