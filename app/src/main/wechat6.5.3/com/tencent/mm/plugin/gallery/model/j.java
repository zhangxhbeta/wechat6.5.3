package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public final class j {
    private static int coo = 0;
    private static final int geo;
    private static final int gep;

    static {
        int i;
        int i2 = 960;
        r2 = new int[2];
        Display defaultDisplay = ((WindowManager) aa.getContext().getSystemService("window")).getDefaultDisplay();
        r2[0] = defaultDisplay.getWidth();
        r2[1] = defaultDisplay.getHeight();
        if (r2[0] > 960) {
            i = r2[0];
        } else {
            i = 960;
        }
        geo = i;
        if (r2[1] > 960) {
            i2 = r2[1];
        }
        gep = i2;
    }

    public static Bitmap a(long j, int i, String str, String str2) {
        if (c.aqn() == null) {
            return null;
        }
        Bitmap a;
        switch (i) {
            case 1:
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                a = a(str, str2, j, 12288, decodeResultLogger);
                if (a == null) {
                    v.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s], [%s]", new Object[]{str, str2});
                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                        g.iuh.Y(12712, KVStatHelper.getKVStatString(str2, 1, decodeResultLogger));
                        return a;
                    }
                }
                break;
            case 2:
                a = f(j, str2);
                if (a == null) {
                    return a(str, str2, j, 12288, null);
                }
                break;
            default:
                return null;
        }
        return a;
    }

    private static int aqJ() {
        if (coo > 0) {
            return coo;
        }
        int a = b.a(aa.getContext(), 150.0f);
        coo = a;
        return a;
    }

    private static Bitmap a(String str, String str2, long j, int i, DecodeResultLogger decodeResultLogger) {
        v.d("MicroMsg.MediaManager", "current thread %s", new Object[]{Thread.currentThread().getName()});
        if (be.kS(str)) {
            v.e("MicroMsg.MediaManager", "filePath is null or nill");
            return null;
        }
        Bitmap bitmap;
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap a = d.a(str, aqJ(), aqJ(), false, null, 0);
        String str3 = "MicroMsg.MediaManager";
        String str4 = "getImageThumb[%s]FromThumbFilePath, bmp size[%d, %d]: total time:[%dms]";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(a == null ? 0 : a.getWidth());
        objArr[2] = Integer.valueOf(a == null ? 0 : a.getHeight());
        objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        v.v(str3, str4, objArr);
        if (a == null) {
            v.w("MicroMsg.MediaManager", "get bitmap from thumb failed, try to get thumb from orig image:[%s]", new Object[]{str2});
            if (be.kS(str2)) {
                v.e("MicroMsg.MediaManager", "get bit from orig image faield:[%s]", new Object[]{str2});
            } else {
                currentTimeMillis = System.currentTimeMillis();
                a = d.a(str2, aqJ(), aqJ(), false, null, 0);
                str3 = "MicroMsg.MediaManager";
                str4 = "getImageThumb[%s]FromOrigFilePath[%s], bmp size[%d, %d]:total time:[%dms]";
                objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = Integer.valueOf(a == null ? 0 : a.getWidth());
                objArr[3] = Integer.valueOf(a == null ? 0 : a.getHeight());
                objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                v.v(str3, str4, objArr);
                bitmap = a;
                return m(str2, bitmap);
            }
        }
        bitmap = a;
        return m(str2, bitmap);
    }

    private static Bitmap m(String str, Bitmap bitmap) {
        if (bitmap != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap b = d.b(bitmap, (float) ExifHelper.JQ(str));
            v.d("MicroMsg.MediaManager", "do rotate finish, width[%d] height[%d] rotate[%d] use[%dms]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(r1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            if (b != null) {
                return b;
            }
        }
        return null;
    }

    public static Bitmap tY(String str) {
        Object obj = 1;
        if (be.kS(str)) {
            v.e("MicroMsg.MediaManager", "filepath is null or nil");
            return null;
        }
        try {
            if (e.aR(str)) {
                int i = geo;
                int i2 = gep;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                if (options.outWidth <= 0 || options.outHeight <= 0) {
                    v.d("MicroMsg.MediaManager", "get bitmap fail, file is not a image file = " + str);
                    return null;
                }
                int i3;
                Object obj2 = (!d.aZ(options.outWidth, options.outHeight) || options.outWidth <= 480) ? null : 1;
                if (!d.aY(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                    obj = null;
                }
                if (!(obj2 == null && r2 == null)) {
                    i2 = options.outHeight;
                    i = options.outWidth;
                }
                int JQ = ExifHelper.JQ(str);
                if (JQ == 90 || JQ == 270) {
                    i3 = i2;
                    i2 = i;
                } else {
                    i3 = i;
                }
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                Bitmap a = d.a(str, i2, i3, false, decodeResultLogger, 0);
                if (a == null) {
                    v.e("MicroMsg.MediaManager", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                    if (decodeResultLogger.getDecodeResult() >= 2000) {
                        g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 1, decodeResultLogger));
                    }
                    return null;
                }
                a = d.b(a, (float) JQ);
                v.i("MicroMsg.MediaManager", "bmp height = " + a.getHeight() + ",bmp width = " + a.getWidth());
                return a;
            }
            v.e("MicroMsg.MediaManager", "getSuitableBmp fail, file does not exist, filePath = " + str);
            return null;
        } catch (Exception e) {
            v.e("MicroMsg.MediaManager", "decode bitmap err: " + e.getMessage());
            return null;
        }
    }

    @TargetApi(8)
    private static Bitmap f(long j, String str) {
        Bitmap thumbnail;
        try {
            thumbnail = Thumbnails.getThumbnail(aa.getContext().getContentResolver(), j, 1, null);
        } catch (Throwable e) {
            v.e("MicroMsg.MediaManager", "exception: %s", new Object[]{be.e(e)});
            thumbnail = null;
        }
        if (thumbnail == null) {
            v.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", new Object[]{Long.valueOf(j), str});
            if (VERSION.SDK_INT >= 8) {
                thumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            }
            if (thumbnail == null && !be.kS(str)) {
                v.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", new Object[]{Long.valueOf(j), str});
                aa.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str)));
            }
        }
        return thumbnail;
    }
}
