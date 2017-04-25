package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.wearable.b;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.p;
import com.google.android.gms.wearable.q.a;
import com.tencent.mmdb.FileUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ao extends k<x> {
    final ExecutorService aFD = Executors.newCachedThreadPool();
    private final y<a> aFE = new y();
    private final y<p.a> aFF = new y();
    private final y<b.a> aFG = new y();
    private final y<c.b> aFH = new y();
    private final y<j.a> aFI = new y();
    private final y<m.b> aFJ = new y();
    private final y<m.c> aFK = new y();
    private final Map<String, y<com.google.android.gms.wearable.a.a>> aFL = new HashMap();

    class AnonymousClass1 implements Callable<Boolean> {
        final /* synthetic */ ParcelFileDescriptor aFM;
        final /* synthetic */ ao aFN;
        final /* synthetic */ byte[] aFx;

        AnonymousClass1(ao aoVar, ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
            this.aFN = aoVar;
            this.aFM = parcelFileDescriptor;
            this.aFx = bArr;
        }

        private java.lang.Boolean mC() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0082 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r1 = 3;
            r0 = "WearableClient";
            r0 = android.util.Log.isLoggable(r0, r1);
            if (r0 == 0) goto L_0x0017;
        L_0x000a:
            r0 = new java.lang.StringBuilder;
            r1 = "processAssets: writing data to FD : ";
            r0.<init>(r1);
            r1 = r4.aFM;
            r0.append(r1);
        L_0x0017:
            r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream;
            r0 = r4.aFM;
            r1.<init>(r0);
            r0 = r4.aFx;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r1.write(r0);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r1.flush();	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0 = "WearableClient";	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = 3;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            if (r0 == 0) goto L_0x003d;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        L_0x0030:
            r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = "processAssets: wrote data: ";	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0.<init>(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = r4.aFM;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0.append(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        L_0x003d:
            r0 = 1;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00ab }
            r3 = 3;	 Catch:{ IOException -> 0x00ab }
            r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00ab }
            if (r2 == 0) goto L_0x0059;	 Catch:{ IOException -> 0x00ab }
        L_0x004c:
            r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00ab }
            r3 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00ab }
            r2.<init>(r3);	 Catch:{ IOException -> 0x00ab }
            r3 = r4.aFM;	 Catch:{ IOException -> 0x00ab }
            r2.append(r3);	 Catch:{ IOException -> 0x00ab }
        L_0x0059:
            r1.close();	 Catch:{ IOException -> 0x00ab }
        L_0x005c:
            return r0;
        L_0x005d:
            r0 = move-exception;
            r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = "processAssets: writing data failed: ";	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0.<init>(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = r4.aFM;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0.append(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0 = "WearableClient";
            r2 = 3;
            r0 = android.util.Log.isLoggable(r0, r2);
            if (r0 == 0) goto L_0x0082;
        L_0x0075:
            r0 = new java.lang.StringBuilder;
            r2 = "processAssets: closing: ";
            r0.<init>(r2);
            r2 = r4.aFM;
            r0.append(r2);
        L_0x0082:
            r1.close();
        L_0x0085:
            r0 = 0;
            r0 = java.lang.Boolean.valueOf(r0);
            goto L_0x005c;
        L_0x008b:
            r0 = move-exception;
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00a7 }
            r3 = 3;	 Catch:{ IOException -> 0x00a7 }
            r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00a7 }
            if (r2 == 0) goto L_0x00a3;	 Catch:{ IOException -> 0x00a7 }
        L_0x0096:
            r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a7 }
            r3 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00a7 }
            r2.<init>(r3);	 Catch:{ IOException -> 0x00a7 }
            r3 = r4.aFM;	 Catch:{ IOException -> 0x00a7 }
            r2.append(r3);	 Catch:{ IOException -> 0x00a7 }
        L_0x00a3:
            r1.close();	 Catch:{ IOException -> 0x00a7 }
        L_0x00a6:
            throw r0;
        L_0x00a7:
            r1 = move-exception;
            goto L_0x00a6;
        L_0x00a9:
            r0 = move-exception;
            goto L_0x0085;
        L_0x00ab:
            r1 = move-exception;
            goto L_0x005c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.ao.1.mC():java.lang.Boolean");
        }

        public final /* synthetic */ Object call() {
            return mC();
        }
    }

    public ao(Context context, Looper looper, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar, h hVar) {
        super(context, looper, 14, hVar, bVar, cVar);
    }

    protected final void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            if (i == 0) {
                this.aFE.u(iBinder);
                this.aFF.u(iBinder);
                this.aFH.u(iBinder);
                this.aFI.u(iBinder);
                this.aFJ.u(iBinder);
                this.aFK.u(iBinder);
                synchronized (this.aFL) {
                    for (y u : this.aFL.values()) {
                        u.u(iBinder);
                    }
                }
            }
            super.a(i, iBinder, bundle, i2);
        }
        if (i == 0) {
            this.aFE.u(iBinder);
            this.aFF.u(iBinder);
            this.aFH.u(iBinder);
            this.aFI.u(iBinder);
            this.aFJ.u(iBinder);
            this.aFK.u(iBinder);
            synchronized (this.aFL) {
                while (r2.hasNext()) {
                    u.u(iBinder);
                }
            }
        }
        super.a(i, iBinder, bundle, i2);
    }

    public final void a(e eVar) {
        int i = 7887000;
        if (!je()) {
            try {
                Bundle bundle = this.mContext.getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", FileUtils.S_IWUSR).metaData;
                if (bundle != null) {
                    i = bundle.getInt("com.google.android.wearable.api.version", 7887000);
                }
                if (i < com.google.android.gms.common.b.akq) {
                    new StringBuilder("Android Wear out of date. Requires API version ").append(com.google.android.gms.common.b.akq).append(" but found ").append(i);
                    Context context = this.mContext;
                    Context context2 = this.mContext;
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, 65536) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
                    }
                    a(eVar, new ConnectionResult(6, PendingIntent.getActivity(context, 0, intent, 0)));
                    return;
                }
            } catch (NameNotFoundException e) {
                a(eVar, new ConnectionResult(16, null));
                return;
            }
        }
        super.a(eVar);
    }

    public final void disconnect() {
        this.aFE.a(this);
        this.aFF.a(this);
        this.aFH.a(this);
        this.aFI.a(this);
        this.aFJ.a(this);
        this.aFK.a(this);
        synchronized (this.aFL) {
            for (y a : this.aFL.values()) {
                a.a(this);
            }
        }
        super.disconnect();
    }

    protected final /* synthetic */ IInterface f(IBinder iBinder) {
        return x.a.t(iBinder);
    }

    protected final String jO() {
        return com.google.android.gms.common.k.kx().a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn") ? "com.google.android.wearable.app.cn" : "com.google.android.gms";
    }

    public final boolean je() {
        return !com.google.android.gms.common.k.kx().a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn");
    }

    protected final String jf() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected final String jg() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }
}
