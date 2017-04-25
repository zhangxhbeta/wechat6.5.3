package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public abstract class k implements g {
    private static int gei = 100;
    public static String geq = "date_added";
    public static String ger = "datetaken";
    public static String ges = "date_mix";
    protected ContentResolver cYl = this.mContext.getContentResolver();
    protected Context mContext = aa.getContext();

    protected abstract Uri aqF();

    protected abstract String[] aqG();

    protected abstract String aqH();

    protected abstract String aqI();

    protected abstract String[] getProjection();

    protected abstract String getSelection();

    protected abstract int getType();

    protected abstract String tX(String str);

    protected k() {
    }

    public ArrayList<a> aqE() {
        Cursor query;
        ArrayList<a> arrayList = new ArrayList();
        try {
            query = this.cYl.query(aqF(), getProjection(), getSelection(), null, aqH());
        } catch (Exception e) {
            v.e("MicroMsg.MediaQueryBase", "query album list failed : [%s]", new Object[]{e.getMessage()});
            query = null;
        }
        if (query == null) {
            v.d("MicroMsg.MediaQueryBase", "no media folder now");
            return arrayList;
        }
        if (query.moveToFirst()) {
            do {
                Long valueOf = Long.valueOf(0);
                try {
                    valueOf = Long.valueOf(be.getLong(query.getString(query.getColumnIndexOrThrow("_id")), 0));
                } catch (NumberFormatException e2) {
                } catch (IllegalArgumentException e3) {
                }
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                String string2 = query.getString(query.getColumnIndexOrThrow(aqI()));
                if (be.kS(string2) && getType() == 2) {
                    v.e("MicroMsg.MediaQueryBase", "null or nill album name, ignore this folder");
                } else {
                    int i = query.getInt(3);
                    v.i("MicroMsg.MediaQueryBase", string + "====" + string2 + "=====" + valueOf + ", " + i);
                    if (i == 0 || (be.kS(string) && be.kS(null))) {
                        v.e("MicroMsg.MediaQueryBase", "query album failed, " + i + ", " + string + "," + null);
                    } else {
                        if (be.kS(string) || !e.aR(string)) {
                            string = null;
                        }
                        if (!be.kS(null)) {
                            e.aR(null);
                        }
                        if (string == null) {
                            v.e("MicroMsg.MediaQueryBase", "this item has no thumb path and orignal path");
                        } else {
                            MediaItem a = MediaItem.a(getType(), valueOf.longValue(), string, null, query.getString(query.getColumnIndexOrThrow("mime_type")));
                            a aVar = new a(string2, i);
                            aVar.gdX = a;
                            arrayList.add(aVar);
                        }
                    }
                }
            } while (query.moveToNext());
        }
        query.close();
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem> a(java.lang.String r21, int r22, com.tencent.mm.plugin.gallery.model.g.c r23) {
        /*
        r20 = this;
        r12 = new java.util.ArrayList;
        r12.<init>();
        r8 = 0;
        r0 = r20;
        r2 = r0.cYl;	 Catch:{ Exception -> 0x0041 }
        r3 = r20.aqF();	 Catch:{ Exception -> 0x0041 }
        r4 = r20.aqG();	 Catch:{ Exception -> 0x0041 }
        r5 = r20.tX(r21);	 Catch:{ Exception -> 0x0041 }
        r6 = 0;
        r7 = r20.aqH();	 Catch:{ Exception -> 0x0041 }
        r2 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0041 }
        r13 = r2;
    L_0x0020:
        if (r13 != 0) goto L_0x0057;
    L_0x0022:
        r2 = "MicroMsg.MediaQueryBase";
        r3 = new java.lang.StringBuilder;
        r4 = "query album failed: ";
        r3.<init>(r4);
        r0 = r21;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.d(r2, r3);
        r0 = r23;
        r0.C(r12);
        r2 = r12;
    L_0x0040:
        return r2;
    L_0x0041:
        r2 = move-exception;
        r3 = "MicroMsg.MediaQueryBase";
        r4 = "query media items in album failed : [%s]";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r2 = r2.getMessage();
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
        r13 = r8;
        goto L_0x0020;
    L_0x0057:
        r2 = 0;
        r3 = r13.moveToFirst();
        if (r3 == 0) goto L_0x01a8;
    L_0x005e:
        r11 = 0;
        r2 = 0;
        r2 = java.lang.Long.valueOf(r2);
        r3 = "_id";
        r3 = r13.getColumnIndexOrThrow(r3);	 Catch:{ NumberFormatException -> 0x0234, IllegalArgumentException -> 0x0231 }
        r3 = r13.getString(r3);	 Catch:{ NumberFormatException -> 0x0234, IllegalArgumentException -> 0x0231 }
        r4 = 0;
        r4 = com.tencent.mm.sdk.platformtools.be.getLong(r3, r4);	 Catch:{ NumberFormatException -> 0x0234, IllegalArgumentException -> 0x0231 }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0234, IllegalArgumentException -> 0x0231 }
    L_0x007a:
        r3 = "_data";
        r3 = r13.getColumnIndexOrThrow(r3);
        r14 = r13.getString(r3);
        r3 = ges;
        r3 = r13.getColumnIndexOrThrow(r3);
        r15 = r13.getString(r3);
        r3 = ges;
        r3 = r13.getColumnIndexOrThrow(r3);
        r16 = r13.getLong(r3);
        r3 = geq;
        r3 = r13.getColumnIndexOrThrow(r3);
        r18 = r13.getString(r3);
        r3 = ger;
        r3 = r13.getColumnIndexOrThrow(r3);
        r19 = r13.getString(r3);
        if (r15 == 0) goto L_0x00c3;
    L_0x00af:
        r3 = "";
        r3 = r15.equals(r3);
        if (r3 != 0) goto L_0x00c3;
    L_0x00b8:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x01b5;
    L_0x00c3:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 1;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
        r4 = 0;
        r3 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1));
        if (r3 == 0) goto L_0x00e1;
    L_0x00d5:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 4;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
    L_0x00e1:
        if (r18 == 0) goto L_0x00fb;
    L_0x00e3:
        r3 = "";
        r0 = r18;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x00fb;
    L_0x00ee:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r18;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0121;
    L_0x00fb:
        if (r19 == 0) goto L_0x0121;
    L_0x00fd:
        r3 = "";
        r0 = r19;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x0121;
    L_0x0108:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r19;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x0121;
    L_0x0115:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 3;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
    L_0x0121:
        if (r19 == 0) goto L_0x013b;
    L_0x0123:
        r3 = "";
        r0 = r19;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x013b;
    L_0x012e:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r19;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0161;
    L_0x013b:
        if (r18 == 0) goto L_0x0161;
    L_0x013d:
        r3 = "";
        r0 = r18;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x0161;
    L_0x0148:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r18;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x0161;
    L_0x0155:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 2;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
    L_0x0161:
        r3 = r20.getType();
        r4 = r2.longValue();
        r3 = com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem.s(r3, r4);
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r14);
        if (r2 != 0) goto L_0x0180;
    L_0x0173:
        r2 = new java.io.File;
        r2.<init>(r14);
        r2 = r2.exists();
        if (r2 == 0) goto L_0x0180;
    L_0x017e:
        r3.gdY = r14;
    L_0x0180:
        r0 = r18;
        r4 = bG(r15, r0);
        r3.geb = r4;
        r2 = r3.gdY;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 == 0) goto L_0x0204;
    L_0x0190:
        r2 = r3.gdZ;
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r2 == 0) goto L_0x0204;
    L_0x0198:
        r2 = "MicroMsg.MediaQueryBase";
        r3 = "thumb file and orignal file both not exist";
        com.tencent.mm.sdk.platformtools.v.e(r2, r3);
        r2 = r11;
    L_0x01a2:
        r3 = r13.moveToNext();
        if (r3 != 0) goto L_0x005e;
    L_0x01a8:
        r13.close();
        if (r2 != 0) goto L_0x01b2;
    L_0x01ad:
        r0 = r23;
        r0.C(r12);
    L_0x01b2:
        r2 = r12;
        goto L_0x0040;
    L_0x01b5:
        if (r19 == 0) goto L_0x01cf;
    L_0x01b7:
        r3 = "";
        r0 = r19;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x01cf;
    L_0x01c2:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r19;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x01dc;
    L_0x01cf:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 6;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
        goto L_0x0161;
    L_0x01dc:
        if (r18 == 0) goto L_0x01f6;
    L_0x01de:
        r3 = "";
        r0 = r18;
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x01f6;
    L_0x01e9:
        r3 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r0 = r18;
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0161;
    L_0x01f6:
        r3 = com.tencent.mm.plugin.report.service.g.iuh;
        r4 = 363; // 0x16b float:5.09E-43 double:1.793E-321;
        r6 = 5;
        r8 = 1;
        r10 = 1;
        r3.a(r4, r6, r8, r10);
        goto L_0x0161;
    L_0x0204:
        r2 = "mime_type";
        r2 = r13.getColumnIndexOrThrow(r2);
        r2 = r13.getString(r2);
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r4 == 0) goto L_0x0218;
    L_0x0215:
        r2 = "";
    L_0x0218:
        r3.mMimeType = r2;
        r12.add(r3);
        r2 = r12.size();
        r3 = gei;
        r2 = r2 % r3;
        if (r2 != 0) goto L_0x0237;
    L_0x0226:
        r0 = r23;
        r0.C(r12);
        r12.clear();
        r2 = 1;
        goto L_0x01a2;
    L_0x0231:
        r3 = move-exception;
        goto L_0x007a;
    L_0x0234:
        r3 = move-exception;
        goto L_0x007a;
    L_0x0237:
        r2 = r11;
        goto L_0x01a2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.k.a(java.lang.String, int, com.tencent.mm.plugin.gallery.model.g$c):java.util.ArrayList<com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static long bG(java.lang.String r9, java.lang.String r10) {
        /*
        r8 = 0;
        r0 = 0;
        r4 = java.lang.System.currentTimeMillis();
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r9);
        if (r2 != 0) goto L_0x0034;
    L_0x000d:
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ NumberFormatException -> 0x0028 }
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.be.getLong(r9, r6);	 Catch:{ NumberFormatException -> 0x0028 }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ NumberFormatException -> 0x0028 }
        r0 = r2.convert(r6, r3);	 Catch:{ NumberFormatException -> 0x0028 }
        r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x0034;
    L_0x001f:
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r4 / r2;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0034;
    L_0x0027:
        return r0;
    L_0x0028:
        r2 = move-exception;
        r3 = "MicroMsg.MediaQueryBase";
        r6 = "";
        r7 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r6, r7);
    L_0x0034:
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r10);
        if (r2 != 0) goto L_0x0027;
    L_0x003a:
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ NumberFormatException -> 0x004d }
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.be.getLong(r10, r6);	 Catch:{ NumberFormatException -> 0x004d }
        r3 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ NumberFormatException -> 0x004d }
        r0 = r2.convert(r6, r3);	 Catch:{ NumberFormatException -> 0x004d }
        r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x0027;
    L_0x004c:
        goto L_0x0027;
    L_0x004d:
        r2 = move-exception;
        r3 = "MicroMsg.MediaQueryBase";
        r4 = "";
        r5 = new java.lang.Object[r8];
        com.tencent.mm.sdk.platformtools.v.a(r3, r2, r4, r5);
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.k.bG(java.lang.String, java.lang.String):long");
    }
}
