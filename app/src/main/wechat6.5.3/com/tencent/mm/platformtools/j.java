package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class j {
    private static Vector<WeakReference<a>> cyf = new Vector();
    private static LinkedList<a> doW = new LinkedList();

    public interface a {
        void k(String str, Bitmap bitmap);
    }

    private enum b {
        ;
        
        private static DisplayMetrics dpc;
        private Map<String, c> doY;
        private Map<String, WeakReference<Bitmap>> doZ;
        private ap dpa;
        private ap dpb;

        static class c {
            boolean dpg;
            int dph;
            int dpi;

            c() {
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("fail[").append(this.dpg).append("],");
                stringBuilder.append("tryTimes[").append(this.dph).append("],");
                stringBuilder.append("lastTS[").append(this.dpi).append("]");
                return stringBuilder.toString();
            }
        }

        private static class a implements com.tencent.mm.sdk.platformtools.ap.a {
            private Bitmap cxY;
            private int dpe;
            private i dpf;

            public a(i iVar) {
                this.dpe = 0;
                this.cxY = null;
                if (j.b(iVar)) {
                    this.dpf = iVar;
                    return;
                }
                throw new IllegalArgumentException("from net, picture strategy here must be validity");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean AZ() {
                /*
                r12 = this;
                r1 = 0;
                r11 = 0;
                r10 = 1;
                r0 = r12.dpf;
                if (r0 != 0) goto L_0x0011;
            L_0x0007:
                r0 = "MicroMsg.MMPictureLogic";
                r1 = "picStrategy == null";
                com.tencent.mm.sdk.platformtools.v.e(r0, r1);
            L_0x0010:
                return r10;
            L_0x0011:
                r0 = r12.dpf;	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r0.Nb();	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r5 = new java.io.File;	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r0 = r12.dpf;	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r0 = r0.MU();	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r5.<init>(r0);	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r4 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r0.<init>();	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r2 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r0 = r0.append(r2);	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r2 = "_tmp";
                r0 = r0.append(r2);	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r0 = r0.toString();	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r4.<init>(r0);	 Catch:{ Exception -> 0x029c, all -> 0x022e }
                r0 = r12.dpf;	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r0 = r0.MV();	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r2 = 0;
                r0 = com.tencent.mm.network.b.a(r0, r2);	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r2 = com.tencent.mm.ae.p.GP();	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                if (r2 == 0) goto L_0x0073;
            L_0x004f:
                r2 = r12.dpf;	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r2 = r2.MV();	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r2 = com.tencent.mm.ae.p.jf(r2);	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                if (r2 == 0) goto L_0x0073;
            L_0x005b:
                r2 = com.tencent.mm.protocal.d.lWh;	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r2 = com.tencent.mm.ae.p.fL(r2);	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r3 = "MicroMsg.MMPictureLogic";
                r6 = "webp referer:%s";
                r7 = 1;
                r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r8 = 0;
                r7[r8] = r2;	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                com.tencent.mm.sdk.platformtools.v.d(r3, r6, r7);	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r0.lM(r2);	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
            L_0x0073:
                r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
                r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
                r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r2 = "GET";
                r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                r2 = com.tencent.mm.network.b.a(r0);	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
                if (r2 != 0) goto L_0x02ab;
            L_0x0089:
                r3 = r0.getInputStream();	 Catch:{ Exception -> 0x02a1, all -> 0x0293 }
            L_0x008d:
                r0 = r0.dmc;	 Catch:{ Exception -> 0x02a6, all -> 0x0295 }
                r2 = r0.getContentType();	 Catch:{ Exception -> 0x02a6, all -> 0x0295 }
                r0 = "MicroMsg.MMPictureLogic";
                r6 = "contentType:%s";
                r7 = 1;
                r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r8 = 0;
                r7[r8] = r2;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                com.tencent.mm.sdk.platformtools.v.d(r0, r6, r7);	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                if (r3 != 0) goto L_0x00f0;
            L_0x00a4:
                r0 = "MicroMsg.MMPictureLogic";
                r1 = "download %s error, can not open http stream";
                r5 = 1;
                r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r6 = 0;
                r7 = r12.dpf;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r7 = r7.MV();	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r5[r6] = r7;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                com.tencent.mm.sdk.platformtools.v.w(r0, r1, r5);	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r0 = r12.dpf;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r1 = 0;
                r0.H(r2, r1);	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                if (r3 == 0) goto L_0x00c4;
            L_0x00c1:
                r3.close();	 Catch:{ IOException -> 0x00dd }
            L_0x00c4:
                r4.close();	 Catch:{ IOException -> 0x00c9 }
                goto L_0x0010;
            L_0x00c9:
                r0 = move-exception;
                r1 = "MicroMsg.MMPictureLogic";
                r2 = "exception:%s";
                r3 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
                r3[r11] = r0;
                com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);
                goto L_0x0010;
            L_0x00dd:
                r0 = move-exception;
                r1 = "MicroMsg.MMPictureLogic";
                r2 = "exception:%s";
                r3 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
                r3[r11] = r0;
                com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);
                goto L_0x00c4;
            L_0x00f0:
                r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
                r0 = new byte[r0];	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
            L_0x00f4:
                r6 = r3.read(r0);	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r7 = -1;
                if (r6 == r7) goto L_0x0157;
            L_0x00fb:
                r7 = r12.dpe;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r7 = r7 + r6;
                r12.dpe = r7;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r7 = 0;
                r4.write(r0, r7, r6);	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                goto L_0x00f4;
            L_0x0105:
                r0 = move-exception;
                r1 = r2;
                r2 = r3;
                r3 = r4;
            L_0x0109:
                r4 = "MicroMsg.MMPictureLogic";
                r5 = "exception:%s";
                r6 = 1;
                r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0298 }
                r7 = 0;
                r0 = com.tencent.mm.sdk.platformtools.be.e(r0);	 Catch:{ all -> 0x0298 }
                r6[r7] = r0;	 Catch:{ all -> 0x0298 }
                com.tencent.mm.sdk.platformtools.v.e(r4, r5, r6);	 Catch:{ all -> 0x0298 }
                r0 = "MicroMsg.MMPictureLogic";
                r4 = "get url:%s failed.";
                r5 = 1;
                r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0298 }
                r6 = 0;
                r7 = r12.dpf;	 Catch:{ all -> 0x0298 }
                r7 = r7.MV();	 Catch:{ all -> 0x0298 }
                r5[r6] = r7;	 Catch:{ all -> 0x0298 }
                com.tencent.mm.sdk.platformtools.v.w(r0, r4, r5);	 Catch:{ all -> 0x0298 }
                r0 = r12.dpf;	 Catch:{ all -> 0x0298 }
                r4 = 0;
                r0.H(r1, r4);	 Catch:{ all -> 0x0298 }
                if (r2 == 0) goto L_0x013c;
            L_0x0139:
                r2.close();	 Catch:{ IOException -> 0x021a }
            L_0x013c:
                if (r3 == 0) goto L_0x0010;
            L_0x013e:
                r3.close();	 Catch:{ IOException -> 0x0143 }
                goto L_0x0010;
            L_0x0143:
                r0 = move-exception;
                r1 = "MicroMsg.MMPictureLogic";
                r2 = "exception:%s";
                r3 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
                r3[r11] = r0;
                com.tencent.mm.sdk.platformtools.v.e(r1, r2, r3);
                goto L_0x0010;
            L_0x0157:
                r0 = "MicroMsg.MMPictureLogic";
                r6 = "get url[%s] ok, bufSize[%d]";
                r7 = 2;
                r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r8 = 0;
                r9 = r12.dpf;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r9 = r9.MV();	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r7[r8] = r9;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r8 = 1;
                r9 = r12.dpe;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r7[r8] = r9;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                com.tencent.mm.sdk.platformtools.v.i(r0, r6, r7);	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r0 = r12.dpf;	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                r6 = 1;
                r0.H(r2, r6);	 Catch:{ Exception -> 0x0105, all -> 0x0295 }
                if (r3 == 0) goto L_0x0180;
            L_0x017d:
                r3.close();	 Catch:{ IOException -> 0x01f2 }
            L_0x0180:
                r4.close();	 Catch:{ IOException -> 0x0206 }
            L_0x0183:
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026b }
                r0.<init>();	 Catch:{ Exception -> 0x026b }
                r3 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x026b }
                r0 = r0.append(r3);	 Catch:{ Exception -> 0x026b }
                r3 = "_tmp";
                r0 = r0.append(r3);	 Catch:{ Exception -> 0x026b }
                r0 = r0.toString();	 Catch:{ Exception -> 0x026b }
                r3 = com.tencent.mm.platformtools.j.b.lW(r0);	 Catch:{ Exception -> 0x026b }
                if (r3 == 0) goto L_0x0261;
            L_0x01a1:
                r0 = r12.dpf;	 Catch:{ Exception -> 0x026b }
                r2 = com.tencent.mm.platformtools.i.a.NET;	 Catch:{ Exception -> 0x026b }
                r0 = r0.a(r3, r2);	 Catch:{ Exception -> 0x026b }
            L_0x01a9:
                if (r0 == r3) goto L_0x01c7;
            L_0x01ab:
                r2 = r3.isRecycled();	 Catch:{ Exception -> 0x026b }
                if (r2 != 0) goto L_0x01c7;
            L_0x01b1:
                r2 = "MicroMsg.MMPictureLogic";
                r4 = "recycle bitmap:%s";
                r6 = 1;
                r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x026b }
                r7 = 0;
                r8 = r3.toString();	 Catch:{ Exception -> 0x026b }
                r6[r7] = r8;	 Catch:{ Exception -> 0x026b }
                com.tencent.mm.sdk.platformtools.v.i(r2, r4, r6);	 Catch:{ Exception -> 0x026b }
                r3.recycle();	 Catch:{ Exception -> 0x026b }
            L_0x01c7:
                r2 = com.tencent.mm.platformtools.j.b.doX;	 Catch:{ Exception -> 0x026b }
                r3 = r12.dpf;	 Catch:{ Exception -> 0x026b }
                r2.b(r3, r0);	 Catch:{ Exception -> 0x026b }
                r2 = new java.io.File;	 Catch:{ Exception -> 0x026b }
                r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x026b }
                r3.<init>();	 Catch:{ Exception -> 0x026b }
                r4 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x026b }
                r3 = r3.append(r4);	 Catch:{ Exception -> 0x026b }
                r4 = "_tmp";
                r3 = r3.append(r4);	 Catch:{ Exception -> 0x026b }
                r3 = r3.toString();	 Catch:{ Exception -> 0x026b }
                r2.<init>(r3);	 Catch:{ Exception -> 0x026b }
                r2.delete();	 Catch:{ Exception -> 0x026b }
            L_0x01ee:
                r12.cxY = r0;
                goto L_0x0010;
            L_0x01f2:
                r0 = move-exception;
                r3 = "MicroMsg.MMPictureLogic";
                r6 = "exception:%s";
                r7 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
                r7[r11] = r0;
                com.tencent.mm.sdk.platformtools.v.e(r3, r6, r7);
                goto L_0x0180;
            L_0x0206:
                r0 = move-exception;
                r3 = "MicroMsg.MMPictureLogic";
                r4 = "exception:%s";
                r6 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
                r6[r11] = r0;
                com.tencent.mm.sdk.platformtools.v.e(r3, r4, r6);
                goto L_0x0183;
            L_0x021a:
                r0 = move-exception;
                r1 = "MicroMsg.MMPictureLogic";
                r2 = "exception:%s";
                r4 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
                r4[r11] = r0;
                com.tencent.mm.sdk.platformtools.v.e(r1, r2, r4);
                goto L_0x013c;
            L_0x022e:
                r0 = move-exception;
                r4 = r1;
            L_0x0230:
                if (r1 == 0) goto L_0x0235;
            L_0x0232:
                r1.close();	 Catch:{ IOException -> 0x023b }
            L_0x0235:
                if (r4 == 0) goto L_0x023a;
            L_0x0237:
                r4.close();	 Catch:{ IOException -> 0x024e }
            L_0x023a:
                throw r0;
            L_0x023b:
                r1 = move-exception;
                r2 = "MicroMsg.MMPictureLogic";
                r3 = "exception:%s";
                r5 = new java.lang.Object[r10];
                r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
                r5[r11] = r1;
                com.tencent.mm.sdk.platformtools.v.e(r2, r3, r5);
                goto L_0x0235;
            L_0x024e:
                r1 = move-exception;
                r2 = "MicroMsg.MMPictureLogic";
                r3 = "exception:%s";
                r4 = new java.lang.Object[r10];
                r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
                r4[r11] = r1;
                com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
                goto L_0x023a;
            L_0x0261:
                r0 = r12.dpf;	 Catch:{ Exception -> 0x026b }
                r4 = com.tencent.mm.platformtools.i.a.NET;	 Catch:{ Exception -> 0x026b }
                r0.a(r4, r2);	 Catch:{ Exception -> 0x026b }
                r0 = r1;
                goto L_0x01a9;
            L_0x026b:
                r0 = move-exception;
                r2 = "MicroMsg.MMPictureLogic";
                r3 = "update pic for %s, error";
                r4 = new java.lang.Object[r10];
                r5 = r12.dpf;
                r5 = r5.MV();
                r4[r11] = r5;
                com.tencent.mm.sdk.platformtools.v.w(r2, r3, r4);
                r2 = "MicroMsg.MMPictureLogic";
                r3 = "exception:%s";
                r4 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
                r4[r11] = r0;
                com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
                r0 = r1;
                goto L_0x01ee;
            L_0x0293:
                r0 = move-exception;
                goto L_0x0230;
            L_0x0295:
                r0 = move-exception;
                r1 = r3;
                goto L_0x0230;
            L_0x0298:
                r0 = move-exception;
                r1 = r2;
                r4 = r3;
                goto L_0x0230;
            L_0x029c:
                r0 = move-exception;
                r2 = r1;
                r3 = r1;
                goto L_0x0109;
            L_0x02a1:
                r0 = move-exception;
                r2 = r1;
                r3 = r4;
                goto L_0x0109;
            L_0x02a6:
                r0 = move-exception;
                r2 = r3;
                r3 = r4;
                goto L_0x0109;
            L_0x02ab:
                r3 = r1;
                goto L_0x008d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.j.b.a.AZ():boolean");
            }

            public final boolean Ba() {
                try {
                    com.tencent.mm.model.ab.a.csa.aC(this.dpe, 0);
                } catch (Throwable e) {
                    v.e("MicroMsg.MMPictureLogic", "exception:%s", be.e(e));
                }
                b.a(b.doX, this.dpf.MV(), this.dpf.MW(), this.cxY);
                this.cxY = null;
                return false;
            }
        }

        private static class b implements com.tencent.mm.sdk.platformtools.ap.a {
            public Bitmap cxY;
            private i dpf;

            public b(i iVar) {
                this.cxY = null;
                if (j.b(iVar)) {
                    this.dpf = iVar;
                    return;
                }
                throw new IllegalArgumentException("from sdcard, picture strategy here must be validity");
            }

            public final boolean AZ() {
                boolean z = false;
                this.cxY = b.lW(this.dpf.MU());
                if (this.cxY != null) {
                    this.cxY = b.doX.a(this.dpf, this.cxY);
                }
                String str = "MicroMsg.MMPictureLogic";
                String str2 = "get url[%s] from[%s] result[%B]";
                Object[] objArr = new Object[3];
                objArr[0] = this.dpf.MV();
                objArr[1] = this.dpf.MU();
                if (this.cxY != null) {
                    z = true;
                }
                objArr[2] = Boolean.valueOf(z);
                v.v(str, str2, objArr);
                return true;
            }

            public final boolean Ba() {
                if (this.cxY == null) {
                    v.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", this.dpf.MV());
                    if (b.doX.dpa == null || b.doX.dpa.btK()) {
                        b.doX.dpa = new ap(1, "readerapp-pic-logic-download", 3);
                    }
                    b.doX.dpa.c(new a(this.dpf));
                } else {
                    b.a(b.doX, this.dpf.MV(), this.dpf.MW(), this.cxY);
                    this.cxY = null;
                }
                return false;
            }
        }

        private b(String str) {
            this.doY = new HashMap();
            this.doZ = new HashMap();
            this.dpa = null;
            this.dpb = null;
        }

        static {
            dpc = null;
        }

        private Bitmap d(i iVar) {
            Assert.assertTrue("picture strategy here must be validity", j.b(iVar));
            String MV = iVar.MV();
            c cVar = (c) this.doY.get(MV);
            if (cVar == null) {
                cVar = new c();
            }
            if (cVar.dpg) {
                if (cVar.dph < 3) {
                    cVar.dph++;
                } else if (t.ax((long) cVar.dpi) < 120) {
                    v.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", Integer.valueOf(120), MV);
                    return null;
                } else {
                    cVar.dph = 0;
                }
                cVar.dpg = false;
                cVar.dpi = (int) t.Nh();
                this.doY.put(MV, cVar);
            } else if (t.ax((long) cVar.dpi) < 120) {
                v.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", Integer.valueOf(120), MV);
                return null;
            } else {
                cVar.dph++;
                cVar.dpi = (int) t.Nh();
                this.doY.put(MV, cVar);
            }
            if (iVar.MY()) {
                Bitmap lW = lW(iVar.MU());
                if (lW != null) {
                    lW = a(iVar, lW);
                    this.doY.remove(MV);
                    return lW;
                }
                if (this.dpa == null || this.dpa.btK()) {
                    this.dpa = new ap(1, "readerapp-pic-logic-download", 3);
                }
                this.dpa.c(new a(iVar));
                return null;
            }
            if (this.dpb == null || this.dpb.btK()) {
                this.dpb = new ap(1, "readerapp-pic-logic-reader", 1);
            }
            this.dpb.c(new b(iVar));
            return null;
        }

        protected final Bitmap a(i iVar, Bitmap bitmap) {
            Assert.assertTrue("picture strategy here must be validity", j.b(iVar));
            if (bitmap != null) {
                Bitmap a = iVar.a(bitmap, com.tencent.mm.platformtools.i.a.DISK);
                if (!(a == bitmap || bitmap.isRecycled())) {
                    v.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                b(iVar, a);
                return a;
            }
            iVar.a(com.tencent.mm.platformtools.i.a.DISK, null);
            return bitmap;
        }

        private void b(i iVar, Bitmap bitmap) {
            Assert.assertTrue("picture strategy here must be validity", j.b(iVar));
            String MX = iVar.MX();
            Bitmap bitmap2 = this.doZ.containsKey(MX) ? (Bitmap) ((WeakReference) this.doZ.get(MX)).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.doZ.remove(MX);
                this.doZ.put(MX, new WeakReference(bitmap));
            }
        }

        public static Bitmap i(String str, int i, int i2) {
            Bitmap bitmap = null;
            if (t.kS(str)) {
                v.w("MicroMsg.MMPictureLogic", "error input, path is null");
            } else if (i <= 0 || i2 <= 0) {
                v.w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                bitmap = d.a(str, i, i2, decodeResultLogger, 0, new int[0]);
                if (bitmap == null && decodeResultLogger.getDecodeResult() >= 2000) {
                    g.iuh.Y(12712, KVStatHelper.getKVStatString(str, 8, decodeResultLogger));
                }
            }
            return bitmap;
        }

        public static Bitmap lW(String str) {
            if (dpc == null) {
                dpc = aa.getContext().getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = dpc;
            return i(str, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
    }

    static /* synthetic */ void j(String str, Bitmap bitmap) {
        Collection vector = new Vector();
        for (int i = 0; i < cyf.size(); i++) {
            WeakReference weakReference = (WeakReference) cyf.get(i);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.k(str, bitmap);
                } else {
                    vector.add(weakReference);
                }
            }
        }
        cyf.removeAll(vector);
    }

    public static boolean a(a aVar) {
        return cyf.add(new WeakReference(aVar));
    }

    public static boolean b(a aVar) {
        doW.remove(aVar);
        return doW.add(aVar);
    }

    public static boolean c(a aVar) {
        return doW.remove(aVar);
    }

    public static Bitmap a(i iVar) {
        if (!b(iVar)) {
            return null;
        }
        ak.yW();
        if (!c.wy()) {
            return iVar.Na();
        }
        if (iVar.MZ()) {
            return b.a(b.doX, iVar);
        }
        return b.b(b.doX, iVar);
    }

    public static Bitmap lW(String str) {
        return b.lW(str);
    }

    public static Bitmap i(String str, int i, int i2) {
        return b.i(str, i, i2);
    }

    private static boolean b(i iVar) {
        if (iVar == null || t.kS(iVar.MV())) {
            return false;
        }
        return true;
    }
}
