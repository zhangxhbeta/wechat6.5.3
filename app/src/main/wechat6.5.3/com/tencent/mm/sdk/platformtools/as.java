package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import java.lang.ref.WeakReference;

public final class as {
    private static final String nkO = Media.EXTERNAL_CONTENT_URI.toString();
    private static final String[] nkP = new String[]{"_display_name", "_data", "date_added"};
    private static ContentObserver nkQ;
    private static WeakReference<a> nkR;

    public interface a {
        void aFf();
    }

    public static Bitmap V(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        try {
            drawingCache = Bitmap.createBitmap(drawingCache, 0, i, activity.getWindowManager().getDefaultDisplay().getWidth(), activity.getWindowManager().getDefaultDisplay().getHeight() - i);
        } catch (Throwable e) {
            v.a("MicroMsg.ScreenShotUtil", e, "", new Object[0]);
        }
        decorView.destroyDrawingCache();
        return drawingCache;
    }

    public static void a(a aVar) {
        v.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback callback[%s], stack[%s]", new Object[]{aVar, be.bur()});
        if (aVar == null) {
            if (nkQ != null) {
                aa.getContext().getContentResolver().unregisterContentObserver(nkQ);
                nkQ = null;
            }
            if (nkR != null) {
                nkR.clear();
                nkR = null;
                return;
            }
            return;
        }
        nkR = new WeakReference(aVar);
        if (nkQ == null) {
            nkQ = new ContentObserver(new Handler(Looper.myLooper())) {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onChange(boolean r13, android.net.Uri r14) {
                    /*
                    r12 = this;
                    r8 = 0;
                    r0 = "MicroMsg.ScreenShotUtil";
                    r1 = new java.lang.StringBuilder;
                    r2 = "summerscreenshot onChange: ";
                    r1.<init>(r2);
                    r1 = r1.append(r13);
                    r2 = ", uri:";
                    r1 = r1.append(r2);
                    r2 = r14.toString();
                    r1 = r1.append(r2);
                    r1 = r1.toString();
                    com.tencent.mm.sdk.platformtools.v.d(r0, r1);
                    r0 = com.tencent.mm.sdk.platformtools.as.nkR;
                    if (r0 == 0) goto L_0x0036;
                L_0x002c:
                    r0 = com.tencent.mm.sdk.platformtools.as.nkR;
                    r0 = r0.get();
                    if (r0 != 0) goto L_0x006b;
                L_0x0036:
                    r0 = "MicroMsg.ScreenShotUtil";
                    r1 = "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]";
                    r2 = 1;
                    r2 = new java.lang.Object[r2];
                    r3 = 0;
                    r4 = com.tencent.mm.sdk.platformtools.as.nkR;
                    r2[r3] = r4;
                    com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
                    r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
                    r0 = r0.getContentResolver();
                    r0.unregisterContentObserver(r12);
                    com.tencent.mm.sdk.platformtools.as.nkQ = null;
                    r0 = com.tencent.mm.sdk.platformtools.as.nkR;
                    if (r0 == 0) goto L_0x0067;
                L_0x005d:
                    r0 = com.tencent.mm.sdk.platformtools.as.nkR;
                    r0.clear();
                    com.tencent.mm.sdk.platformtools.as.nkR = null;
                L_0x0067:
                    super.onChange(r13, r14);
                    return;
                L_0x006b:
                    r6 = 0;
                    r0 = r14.toString();
                    r1 = com.tencent.mm.sdk.platformtools.as.nkO;
                    r0 = r0.matches(r1);
                    if (r0 == 0) goto L_0x0067;
                L_0x007b:
                    r0 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ Exception -> 0x015d, all -> 0x0181 }
                    r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x015d, all -> 0x0181 }
                    r2 = com.tencent.mm.sdk.platformtools.as.nkP;	 Catch:{ Exception -> 0x015d, all -> 0x0181 }
                    r3 = 0;
                    r4 = 0;
                    r5 = "date_added DESC limit 1";
                    r1 = r14;
                    r3 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x015d, all -> 0x0181 }
                    if (r3 == 0) goto L_0x01be;
                L_0x0093:
                    r0 = r3.moveToFirst();	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    if (r0 == 0) goto L_0x01be;
                L_0x0099:
                    r0 = "_data";
                    r0 = r3.getColumnIndex(r0);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r2 = r3.getString(r0);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r0 = "date_added";
                    r0 = r3.getColumnIndex(r0);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r0 = r3.getLong(r0);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
                    r4 = r4 / r10;
                    r9 = "MicroMsg.ScreenShotUtil";
                    r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r11 = "summerscreenshot path: ";
                    r10.<init>(r11);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r10 = r10.append(r2);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r11 = ", dateAdded: ";
                    r10 = r10.append(r11);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r10 = r10.append(r0);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r11 = ", currentTime: ";
                    r10 = r10.append(r11);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r10 = r10.append(r4);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r10 = r10.toString();	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    com.tencent.mm.sdk.platformtools.v.d(r9, r10);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r4 = r4 - r0;
                    r4 = java.lang.Math.abs(r4);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r10 = 10;
                    r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
                    if (r4 > 0) goto L_0x01be;
                L_0x00ed:
                    r4 = com.tencent.mm.sdk.platformtools.be.kS(r2);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    if (r4 != 0) goto L_0x01be;
                L_0x00f3:
                    r4 = r2.toLowerCase();	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    r5 = "screenshot";
                    r4 = r4.contains(r5);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    if (r4 != 0) goto L_0x0112;
                L_0x0100:
                    r4 = "截屏";
                    r4 = r2.contains(r4);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    if (r4 != 0) goto L_0x0112;
                L_0x0109:
                    r4 = "截图";
                    r4 = r2.contains(r4);	 Catch:{ Exception -> 0x01b7, all -> 0x01b2 }
                    if (r4 == 0) goto L_0x01be;
                L_0x0112:
                    if (r3 == 0) goto L_0x0117;
                L_0x0114:
                    r3.close();
                L_0x0117:
                    r3 = com.tencent.mm.sdk.platformtools.be.kS(r2);
                    if (r3 != 0) goto L_0x0067;
                L_0x011d:
                    r3 = "MicroMsg.ScreenShotUtil";
                    r4 = new java.lang.StringBuilder;
                    r5 = "summerscreenshot added path: ";
                    r4.<init>(r5);
                    r2 = r4.append(r2);
                    r4 = ", time: ";
                    r2 = r2.append(r4);
                    r0 = r2.append(r0);
                    r0 = r0.toString();
                    com.tencent.mm.sdk.platformtools.v.i(r3, r0);
                    r0 = com.tencent.mm.sdk.platformtools.as.nkR;
                    if (r0 == 0) goto L_0x0189;
                L_0x0144:
                    r0 = com.tencent.mm.sdk.platformtools.as.nkR;
                    r0 = r0.get();
                    if (r0 == 0) goto L_0x0189;
                L_0x014e:
                    r0 = com.tencent.mm.sdk.platformtools.as.nkR;
                    r0 = r0.get();
                    r0 = (com.tencent.mm.sdk.platformtools.as.a) r0;
                    r0.aFf();
                    goto L_0x0067;
                L_0x015d:
                    r0 = move-exception;
                    r1 = r8;
                L_0x015f:
                    r2 = "MicroMsg.ScreenShotUtil";
                    r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b4 }
                    r4 = "summerscreenshot fail e:";
                    r3.<init>(r4);	 Catch:{ all -> 0x01b4 }
                    r0 = r0.getMessage();	 Catch:{ all -> 0x01b4 }
                    r0 = r3.append(r0);	 Catch:{ all -> 0x01b4 }
                    r0 = r0.toString();	 Catch:{ all -> 0x01b4 }
                    com.tencent.mm.sdk.platformtools.v.w(r2, r0);	 Catch:{ all -> 0x01b4 }
                    if (r1 == 0) goto L_0x01ba;
                L_0x017b:
                    r1.close();
                    r0 = r6;
                    r2 = r8;
                    goto L_0x0117;
                L_0x0181:
                    r0 = move-exception;
                    r3 = r8;
                L_0x0183:
                    if (r3 == 0) goto L_0x0188;
                L_0x0185:
                    r3.close();
                L_0x0188:
                    throw r0;
                L_0x0189:
                    r0 = com.tencent.mm.sdk.platformtools.aa.getContext();
                    r0 = r0.getContentResolver();
                    r0.unregisterContentObserver(r12);
                    com.tencent.mm.sdk.platformtools.as.nkQ = null;
                    r0 = com.tencent.mm.sdk.platformtools.as.nkR;
                    if (r0 == 0) goto L_0x01a7;
                L_0x019d:
                    r0 = com.tencent.mm.sdk.platformtools.as.nkR;
                    r0.clear();
                    com.tencent.mm.sdk.platformtools.as.nkR = null;
                L_0x01a7:
                    r0 = "MicroMsg.ScreenShotUtil";
                    r1 = "summerscreenshot unregisterContentObserver callback is null 2";
                    com.tencent.mm.sdk.platformtools.v.i(r0, r1);
                    goto L_0x0067;
                L_0x01b2:
                    r0 = move-exception;
                    goto L_0x0183;
                L_0x01b4:
                    r0 = move-exception;
                    r3 = r1;
                    goto L_0x0183;
                L_0x01b7:
                    r0 = move-exception;
                    r1 = r3;
                    goto L_0x015f;
                L_0x01ba:
                    r0 = r6;
                    r2 = r8;
                    goto L_0x0117;
                L_0x01be:
                    r0 = r6;
                    r2 = r8;
                    goto L_0x0112;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.as.1.onChange(boolean, android.net.Uri):void");
                }
            };
            aa.getContext().getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, nkQ);
        }
    }
}
