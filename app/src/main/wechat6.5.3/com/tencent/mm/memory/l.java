package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.v;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l {
    private static int cnA = -1;
    private static j cny = new j();
    private static m cnz = new m();

    public abstract Bitmap a(String str, Options options, DecodeResultLogger decodeResultLogger);

    public abstract Bitmap a(String str, Rect rect, Options options, DecodeResultLogger decodeResultLogger);

    public abstract void e(Bitmap bitmap);

    public static l wk() {
        if (cnA == -1) {
            if (wl()) {
                cnA = 1;
            } else {
                cnA = 2;
            }
        }
        switch (cnA) {
            case 1:
                return cny;
            case 2:
                return cnz;
            default:
                return cnz;
        }
    }

    public static boolean wl() {
        boolean dW = d.dW(19);
        boolean buu = be.buu();
        v.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", Boolean.valueOf(dW), Boolean.valueOf(buu), Boolean.valueOf(dW));
        return dW;
    }

    protected static void f(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                inputStream = new i((FileInputStream) inputStream);
            } else {
                inputStream = new BufferedInputStream(inputStream, 65536);
            }
        }
        try {
            inputStream.reset();
        } catch (Throwable e) {
            v.a("MicroMsg.PlatformBitmapFactory", e, "reset stream error: %s", e.getMessage());
        }
    }
}
