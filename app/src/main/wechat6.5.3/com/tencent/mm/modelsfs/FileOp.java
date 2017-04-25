package com.tencent.mm.modelsfs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class FileOp {
    private static ReentrantReadWriteLock cXO = new ReentrantReadWriteLock();
    private static TreeMap<String, SFSContextRec> cXP = new TreeMap();
    private static File cXQ;
    private static final EnumSet<com.tencent.mm.modelsfs.g.a> cXR = EnumSet.of(com.tencent.mm.modelsfs.g.a.PATHNAME, com.tencent.mm.modelsfs.g.a.PERIOD);

    static class SFSContextRec implements Parcelable {
        public static final Creator<SFSContextRec> CREATOR = new Creator<SFSContextRec>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SFSContextRec(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SFSContextRec[i];
            }
        };
        String cXU;
        String[] cXV;
        boolean cXW;
        boolean cXX;
        SFSContext cXY;
        Builder cXZ;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.cXU);
            parcel.writeStringArray(this.cXV);
            parcel.writeByte((byte) (this.cXW ? 1 : 0));
            parcel.writeParcelable(this.cXZ, i);
        }

        SFSContextRec(Parcel parcel) {
            boolean z;
            this.cXU = parcel.readString();
            this.cXV = parcel.createStringArray();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.cXW = z;
            this.cXY = null;
            this.cXX = false;
            this.cXZ = (Builder) parcel.readParcelable(Builder.class.getClassLoader());
        }
    }

    class a {
        File cXS;
        File[] cXT = null;
        int pos = 0;

        a(File file) {
            this.cXS = file;
        }
    }

    public static void init(boolean z) {
        Context context = aa.getContext();
        cXQ = new File(context.getFilesDir(), "fileop_mapping");
        if (z) {
            cXQ.delete();
            return;
        }
        v.i("MicroMsg.FileOp", "Initializing FileOp mapping slave.");
        if (cXQ.exists()) {
            byte[] c = c(cXQ.getAbsolutePath(), 0, -1);
            if (c != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(c, 0, c.length);
                obtain.setDataPosition(0);
                Bundle readBundle = obtain.readBundle(SFSContextRec.class.getClassLoader());
                obtain.recycle();
                cXO.writeLock().lock();
                for (String str : readBundle.keySet()) {
                    SFSContextRec sFSContextRec = (SFSContextRec) cXP.put(str, (SFSContextRec) readBundle.getParcelable(str));
                    if (!(sFSContextRec == null || sFSContextRec.cXY == null)) {
                        sFSContextRec.cXY.release();
                    }
                    v.i("MicroMsg.FileOp", "Load mapping from file: " + str);
                }
                cXO.writeLock().unlock();
            }
        }
        BroadcastReceiver anonymousClass1 = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                SFSContextRec sFSContextRec;
                String str;
                if (intent.getAction().equals("com.tencent.mm.FileOp.registerSFS")) {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("rec");
                    if (byteArrayExtra != null) {
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
                        obtain.setDataPosition(0);
                        sFSContextRec = (SFSContextRec) SFSContextRec.CREATOR.createFromParcel(obtain);
                        if (sFSContextRec != null) {
                            str = sFSContextRec.cXU;
                            FileOp.cXO.writeLock().lock();
                            sFSContextRec = (SFSContextRec) FileOp.cXP.put(str, sFSContextRec);
                            FileOp.cXO.writeLock().unlock();
                            if (!(sFSContextRec == null || sFSContextRec.cXY == null)) {
                                sFSContextRec.cXY.release();
                            }
                            v.i("MicroMsg.FileOp", "Load mapping from broadcast: " + str);
                        }
                    }
                } else if (intent.getAction().equals("com.tencent.mm.FileOp.unregisterSFS")) {
                    str = intent.getStringExtra("prefix");
                    FileOp.cXO.writeLock().lock();
                    sFSContextRec = (SFSContextRec) FileOp.cXP.remove(str);
                    FileOp.cXO.writeLock().unlock();
                    if (!(sFSContextRec == null || sFSContextRec.cXY == null)) {
                        sFSContextRec.cXY.release();
                    }
                    v.i("MicroMsg.FileOp", "Unload mapping from broadcast: " + str);
                } else if (intent.getAction().equals("com.tencent.mm.FileOp.clearSFS")) {
                    FileOp.cXO.writeLock().lock();
                    for (SFSContextRec sFSContextRec2 : FileOp.cXP.values()) {
                        if (!(sFSContextRec2 == null || sFSContextRec2.cXY == null)) {
                            sFSContextRec2.cXY.release();
                        }
                    }
                    FileOp.cXP.clear();
                    FileOp.cXO.writeLock().unlock();
                    v.i("MicroMsg.FileOp", "Clear mapping from broadcast.");
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.FileOp.registerSFS");
        intentFilter.addAction("com.tencent.mm.FileOp.unregisterSFS");
        intentFilter.addAction("com.tencent.mm.FileOp.clearSFS");
        context.registerReceiver(anonymousClass1, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
    }

    private static void IL() {
        Bundle bundle = new Bundle();
        for (SFSContextRec sFSContextRec : cXP.values()) {
            bundle.putParcelable(sFSContextRec.cXU, sFSContextRec);
        }
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        String absolutePath = cXQ.getAbsolutePath();
        byte[] marshall = obtain.marshall();
        b(absolutePath, marshall, marshall.length);
        obtain.recycle();
    }

    public static void a(String str, String[] strArr, Builder builder) {
        SFSContextRec sFSContextRec = null;
        if (builder == null) {
            jJ(str);
            return;
        }
        if (new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/disable-sfs").exists()) {
            v.i("MicroMsg.FileOp", "SFS disabled.");
            return;
        }
        if (builder != null) {
            SFSContextRec sFSContextRec2 = new SFSContextRec();
            sFSContextRec2.cXU = str;
            String[] strArr2 = (strArr == null || strArr.length == 0) ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
            sFSContextRec2.cXV = strArr2;
            sFSContextRec2.cXW = false;
            sFSContextRec2.cXY = null;
            sFSContextRec2.cXZ = builder;
            sFSContextRec = sFSContextRec2;
        }
        cXO.writeLock().lock();
        SFSContextRec sFSContextRec3 = (SFSContextRec) cXP.put(str, sFSContextRec);
        cXO.writeLock().unlock();
        if (!(sFSContextRec3 == null || sFSContextRec3.cXY == null)) {
            sFSContextRec3.cXY.release();
        }
        Parcel obtain = Parcel.obtain();
        sFSContextRec.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        Context context = aa.getContext();
        context.sendBroadcast(new Intent("com.tencent.mm.FileOp.registerSFS").putExtra("rec", marshall).setPackage(context.getPackageName()), "com.tencent.mm.permission.MM_MESSAGE");
        IL();
        v.i("MicroMsg.FileOp", "Register SFS for prefix: " + str);
    }

    public static void jJ(String str) {
        cXO.writeLock().lock();
        SFSContextRec sFSContextRec = (SFSContextRec) cXP.remove(str);
        cXO.writeLock().unlock();
        if (!(sFSContextRec == null || sFSContextRec.cXY == null)) {
            sFSContextRec.cXY.release();
        }
        Context context = aa.getContext();
        context.sendBroadcast(new Intent("com.tencent.mm.FileOp.unregisterSFS").putExtra("prefix", str).setPackage(context.getPackageName()), "com.tencent.mm.permission.MM_MESSAGE");
        IL();
        v.i("MicroMsg.FileOp", "Unregister SFS for prefix: " + str);
    }

    public static Map<String, Statistics> IM() {
        cXO.readLock().lock();
        Map treeMap = new TreeMap();
        for (SFSContextRec sFSContextRec : cXP.values()) {
            if (!(sFSContextRec == null || sFSContextRec.cXX)) {
                if (sFSContextRec.cXY == null) {
                    synchronized (sFSContextRec) {
                        if (sFSContextRec.cXY == null) {
                            try {
                                sFSContextRec.cXY = sFSContextRec.cXZ.create();
                            } catch (Exception e) {
                                v.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", sFSContextRec.cXU, e.getMessage());
                                sFSContextRec.cXX = true;
                            }
                        }
                    }
                }
                SFSContext sFSContext = sFSContextRec.cXY;
                if (sFSContext.mNativePtr == 0) {
                    throw new IllegalArgumentException("Reuse already released SFSContext.");
                }
                treeMap.put(sFSContextRec.cXZ.mName, SFSContext.nativeStatistics(sFSContext.mNativePtr));
            }
        }
        cXO.readLock().unlock();
        return treeMap;
    }

    private static boolean a(String str, SFSContextRec sFSContextRec) {
        if (sFSContextRec.cXV == null) {
            return false;
        }
        String substring = str.substring(sFSContextRec.cXU.length());
        int lastIndexOf = substring.lastIndexOf(47);
        if (lastIndexOf == -1) {
            return false;
        }
        String substring2 = substring.substring(lastIndexOf + 1);
        if (substring2.length() == 0) {
            return false;
        }
        for (String a : sFSContextRec.cXV) {
            if (g.a(a, 0, substring2, 0, cXR)) {
                return true;
            }
        }
        return false;
    }

    private static boolean jK(String str) {
        boolean z;
        cXO.readLock().lock();
        Entry floorEntry = cXP.floorEntry(str);
        if (floorEntry != null && str.startsWith((String) floorEntry.getKey())) {
            SFSContextRec sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (sFSContextRec.cXV == null && !sFSContextRec.cXW) {
                z = false;
                cXO.readLock().unlock();
                return z;
            }
        }
        z = true;
        cXO.readLock().unlock();
        return z;
    }

    private static boolean jL(String str) {
        boolean z;
        cXO.readLock().lock();
        Entry floorEntry = cXP.floorEntry(str);
        if (floorEntry == null || !str.startsWith((String) floorEntry.getKey()) || a(str, (SFSContextRec) floorEntry.getValue())) {
            z = true;
        } else {
            z = false;
        }
        cXO.readLock().unlock();
        return z;
    }

    private static SFSContextRec jM(String str) {
        cXO.readLock().lock();
        Entry floorEntry = cXP.floorEntry(str);
        if (floorEntry == null) {
            return null;
        }
        SFSContextRec sFSContextRec;
        if (str.startsWith((String) floorEntry.getKey())) {
            sFSContextRec = (SFSContextRec) floorEntry.getValue();
            if (a(str, sFSContextRec)) {
                sFSContextRec = null;
            }
        } else {
            sFSContextRec = null;
        }
        if (sFSContextRec == null || sFSContextRec.cXX) {
            return null;
        }
        if (sFSContextRec.cXY != null) {
            return sFSContextRec;
        }
        synchronized (sFSContextRec) {
            if (sFSContextRec.cXY == null) {
                try {
                    sFSContextRec.cXY = sFSContextRec.cXZ.create();
                } catch (Exception e) {
                    v.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", sFSContextRec.cXU, e.getMessage());
                    sFSContextRec.cXX = true;
                    return null;
                }
            }
        }
        return sFSContextRec;
    }

    public static java.io.InputStream openRead(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.mm.modelsfs.FileOp.openRead(java.lang.String):java.io.InputStream. bs: [B:7:0x0017, B:22:0x0062]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        if (r7 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r7.length();
        if (r0 != 0) goto L_0x0011;
    L_0x0008:
        r0 = new java.io.FileNotFoundException;
        r1 = "path == null";
        r0.<init>(r1);
        throw r0;
    L_0x0011:
        r1 = jM(r7);
        if (r1 != 0) goto L_0x0062;
    L_0x0017:
        r0 = com.tencent.mm.modelsfs.f.jW(r7);	 Catch:{ all -> 0x0057 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0057 }
    L_0x001d:
        r2 = com.tencent.mm.modelsfs.f.jY(r7);	 Catch:{ all -> 0x0057 }
        r4 = com.tencent.mm.modelsfs.f.jX(r7);	 Catch:{ all -> 0x0057 }
        r0 = new com.tencent.mm.modelsfs.b;	 Catch:{ all -> 0x0057 }
        r0.<init>(r4, r2);	 Catch:{ all -> 0x0057 }
    L_0x002a:
        r2 = cXO;
        r2 = r2.readLock();
        r2.unlock();
        r2 = "MicroMsg.FileOp";
        r3 = "openRead: %s [%s, %s]";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r7;
        r5 = 1;
        r6 = "ok";
        r4[r5] = r6;
        r5 = 2;
        if (r1 != 0) goto L_0x007f;
    L_0x0048:
        r1 = "regular";
    L_0x004b:
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);
        return r0;
    L_0x0051:
        r0 = new java.io.FileInputStream;	 Catch:{ all -> 0x0057 }
        r0.<init>(r7);	 Catch:{ all -> 0x0057 }
        goto L_0x002a;
    L_0x0057:
        r0 = move-exception;
        r1 = cXO;
        r1 = r1.readLock();
        r1.unlock();
        throw r0;
    L_0x0062:
        r0 = r1.cXU;	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r0.length();	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r7.substring(r0);	 Catch:{ FileNotFoundException -> 0x0073 }
        r2 = r1.cXY;	 Catch:{ FileNotFoundException -> 0x0073 }
        r0 = r2.openRead(r0);	 Catch:{ FileNotFoundException -> 0x0073 }
        goto L_0x002a;
    L_0x0073:
        r0 = move-exception;
        r2 = r1.cXW;	 Catch:{ all -> 0x0057 }
        if (r2 != 0) goto L_0x0079;	 Catch:{ all -> 0x0057 }
    L_0x0078:
        throw r0;	 Catch:{ all -> 0x0057 }
    L_0x0079:
        r0 = new java.io.FileInputStream;	 Catch:{ all -> 0x0057 }
        r0.<init>(r7);	 Catch:{ all -> 0x0057 }
        goto L_0x002a;
    L_0x007f:
        r1 = "SFS";
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelsfs.FileOp.openRead(java.lang.String):java.io.InputStream");
    }

    public static OutputStream gt(String str) {
        return jN(str);
    }

    public static OutputStream Z(String str, String str2) {
        return aa(str, str2);
    }

    public static OutputStream jN(String str) {
        if (str == null || str.length() == 0) {
            throw new FileNotFoundException("path == null");
        }
        String str2 = SQLiteDatabase.KeyEmpty;
        if (f.jW(str)) {
            str2 = f.jZ(str);
            str = f.jX(str);
        }
        return aa(str, str2);
    }

    private static OutputStream aa(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new FileNotFoundException("path == null");
        }
        OutputStream fileOutputStream;
        SFSContextRec jM = jM(str);
        if (jM == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    fileOutputStream = new FileOutputStream(str);
                } else {
                    fileOutputStream = new c(str, str2);
                }
            } catch (Throwable th) {
                cXO.readLock().unlock();
            }
        } else {
            fileOutputStream = jM.cXY.Z(str.substring(jM.cXU.length()), str2);
        }
        cXO.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "openWrite: %s [%s, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = "ok";
        objArr[2] = jM == null ? "regular" : "SFS";
        v.d(str3, str4, objArr);
        return fileOutputStream;
    }

    public static boolean jO(String str) {
        InputStream openRead;
        IOException e;
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream = null;
        if (str == null || str.length() == 0) {
            return false;
        }
        SFSContextRec jM = jM(str);
        if (jM == null) {
            cXO.readLock().unlock();
            return true;
        }
        try {
            OutputStream fileOutputStream;
            openRead = jM.cXY.openRead(str.substring(jM.cXU.length()));
            try {
                String parent = new File(str).getParent();
                if (!be.kS(parent)) {
                    new File(parent).mkdirs();
                }
                fileOutputStream = new FileOutputStream(str);
            } catch (IOException e2) {
                e = e2;
                inputStream = openRead;
                try {
                    v.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    cXO.readLock().unlock();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    openRead = inputStream;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    cXO.readLock().unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                cXO.readLock().unlock();
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openRead.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e7) {
                        }
                    }
                }
                openRead.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                }
                cXO.readLock().unlock();
                return true;
            } catch (IOException e9) {
                e = e9;
                outputStream = fileOutputStream;
                inputStream = openRead;
                v.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                cXO.readLock().unlock();
                return false;
            } catch (Throwable th4) {
                th = th4;
                outputStream = fileOutputStream;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                cXO.readLock().unlock();
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            inputStream = null;
            v.e("MicroMsg.FileOp", "Failed export '%s' to native: %s", str, e.getMessage());
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            cXO.readLock().unlock();
            return false;
        } catch (Throwable th5) {
            th = th5;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            cXO.readLock().unlock();
            throw th;
        }
    }

    public static long jP(String str) {
        long j = 0;
        if (str != null) {
            String str2;
            SFSContextRec jM = jM(str);
            String jX;
            if (jM != null) {
                FileEntry kb = jM.cXY.kb(str.substring(jM.cXU.length()));
                if (kb != null) {
                    j = kb.size;
                } else if (jM.cXW) {
                    if (f.jW(str)) {
                        jX = f.jX(str);
                    } else {
                        jX = str;
                    }
                    j = new File(jX).length();
                }
            } else {
                if (f.jW(str)) {
                    jX = f.jX(str);
                } else {
                    jX = str;
                }
                j = new File(jX).length();
            }
            cXO.readLock().unlock();
            String str3 = "MicroMsg.FileOp";
            String str4 = "readFileLength: %s [%d, %s]";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Long.valueOf(j);
            if (jM == null) {
                str2 = "regular";
            } else {
                str2 = "SFS";
            }
            objArr[2] = str2;
            v.d(str3, str4, objArr);
        }
        return j;
    }

    public static long jQ(String str) {
        long j = 0;
        if (!(str == null || str.length() == 0)) {
            String str2;
            SFSContextRec jM = jM(str);
            if (jM != null) {
                FileEntry kb = jM.cXY.kb(str.substring(jM.cXU.length()));
                if (kb != null) {
                    j = kb.timestamp * 1000;
                } else if (jM.cXW) {
                    j = new File(str).lastModified();
                }
            } else {
                j = new File(str).lastModified();
            }
            cXO.readLock().unlock();
            String str3 = "MicroMsg.FileOp";
            String str4 = "getFileTime: %s [%d, %s]";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Long.valueOf(j);
            if (jM == null) {
                str2 = "regular";
            } else {
                str2 = "SFS";
            }
            objArr[2] = str2;
            v.d(str3, str4, objArr);
        }
        return j;
    }

    public static byte[] c(String str, int i, int i2) {
        InputStream openRead;
        IOException e;
        Throwable th;
        if (str == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 < 0 ? 2048 : i2);
        try {
            openRead = openRead(str);
            if (i > 0) {
                try {
                    openRead.skip((long) i);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        v.w("MicroMsg.FileOp", "readFromFile failed: " + str + ", " + e.getMessage());
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e3) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                }
            }
            byte[] bArr = new byte[1024];
            if (i2 < 0) {
                i2 = Integer.MAX_VALUE;
            }
            while (true) {
                int read = openRead.read(bArr, 0, Math.min(i2, 1024));
                if (read != -1 && i2 > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                    i2 -= read;
                } else if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e5) {
                    }
                }
            }
            if (openRead != null) {
                openRead.close();
            }
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
            }
            v.d("MicroMsg.FileOp", "readFromFile: %s [%d]", str, Integer.valueOf(bArr.length));
            return bArr;
        } catch (IOException e7) {
            e = e7;
            openRead = null;
            v.w("MicroMsg.FileOp", "readFromFile failed: " + str + ", " + e.getMessage());
            if (openRead != null) {
                openRead.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            throw th;
        }
    }

    public static String aV(String str) {
        IOException e;
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(openRead(str));
            try {
                char[] cArr = new char[512];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        stringBuilder.append(cArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                        }
                    }
                }
                inputStreamReader.close();
                return stringBuilder.toString();
            } catch (IOException e3) {
                e = e3;
                try {
                    v.e("MicroMsg.FileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            inputStreamReader = null;
            v.e("MicroMsg.FileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
            throw e;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
    }

    public static int l(String str, byte[] bArr) {
        return b(str, bArr, bArr.length);
    }

    public static int b(String str, byte[] bArr, int i) {
        if (bArr == null) {
            return -2;
        }
        if (bArr.length < i + 0) {
            return -3;
        }
        OutputStream outputStream = null;
        try {
            outputStream = jN(str);
            outputStream.write(bArr, 0, i);
            if (outputStream == null) {
                return 0;
            }
            try {
                outputStream.close();
                return 0;
            } catch (IOException e) {
                return 0;
            }
        } catch (IOException e2) {
            v.e("MicroMsg.FileOp", "writeFile '%s' Failed: %s", str, e2.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                }
            }
        }
    }

    public static String jR(String str) {
        return new File(f.jX(str)).getParentFile().getAbsolutePath();
    }

    public static boolean jS(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String jX = f.jX(str);
        if (!jK(jX)) {
            return true;
        }
        File file = new File(jX);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static long p(String str, String str2) {
        OutputStream jN;
        IOException e;
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream = null;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return -1;
        }
        InputStream openRead;
        try {
            openRead = openRead(str);
            try {
                jN = jN(str2);
            } catch (IOException e2) {
                e = e2;
                inputStream = openRead;
                try {
                    v.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    openRead = inputStream;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                long j = 0;
                while (true) {
                    int read = openRead.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    jN.write(bArr, 0, read);
                    j += (long) read;
                }
                v.d("MicroMsg.FileOp", "copyFile: %s -> %s", str, str2);
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e7) {
                    }
                }
                if (jN == null) {
                    return j;
                }
                try {
                    jN.close();
                    return j;
                } catch (IOException e8) {
                    return j;
                }
            } catch (IOException e9) {
                e = e9;
                outputStream = jN;
                inputStream = openRead;
                v.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return -1;
            } catch (Throwable th4) {
                th = th4;
                outputStream = jN;
                if (openRead != null) {
                    openRead.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            inputStream = null;
            v.e("MicroMsg.FileOp", "copyFile '%s' -> '%s' failed: %s", str, str2, e.getMessage());
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            return -1;
        } catch (Throwable th5) {
            th = th5;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public static boolean aR(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean nativeExists;
        String str2;
        SFSContextRec jM = jM(str);
        if (jM != null) {
            SFSContext sFSContext = jM.cXY;
            String substring = str.substring(jM.cXU.length());
            if (sFSContext.mNativePtr == 0) {
                throw new IllegalArgumentException("Reuse already released SFSContext.");
            }
            if (f.jW(substring)) {
                f.jY(substring);
                substring = f.jX(substring);
            }
            nativeExists = SFSContext.nativeExists(sFSContext.mNativePtr, substring);
            if (!nativeExists && jM.cXW) {
                nativeExists = new File(str).exists();
            }
        } else {
            nativeExists = new File(str).exists();
        }
        cXO.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "fileExists: %s [%b, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(nativeExists);
        if (jM == null) {
            str2 = "regular";
        } else {
            str2 = "SFS";
        }
        objArr[2] = str2;
        v.d(str3, str4, objArr);
        return nativeExists;
    }

    public static boolean deleteFile(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean hc;
        String str2;
        SFSContextRec jM = jM(str);
        String jX;
        if (jM != null) {
            hc = jM.cXY.hc(str.substring(jM.cXU.length()));
            if (!hc && jM.cXW) {
                if (f.jW(str)) {
                    jX = f.jX(str);
                } else {
                    jX = str;
                }
                hc = new File(jX).delete();
            }
        } else {
            if (f.jW(str)) {
                jX = f.jX(str);
            } else {
                jX = str;
            }
            hc = new File(jX).delete();
        }
        cXO.readLock().unlock();
        String str3 = "MicroMsg.FileOp";
        String str4 = "deleteFile: %s [%b, %s]";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(hc);
        if (jM == null) {
            str2 = "regular";
        } else {
            str2 = "SFS";
        }
        objArr[2] = str2;
        v.d(str3, str4, objArr);
        return hc;
    }

    public static boolean n(String str, String str2, String str3) {
        return ab(str + str2, str + str3);
    }

    public static boolean ab(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            return false;
        }
        if (jL(str) && jL(str2)) {
            if (f.jW(str)) {
                str = f.jX(str);
            }
            if (f.jW(str2)) {
                str2 = f.jX(str2);
            }
            if (new File(str).renameTo(new File(str2))) {
                return true;
            }
        }
        if (p(str, str2) < 0) {
            return false;
        }
        deleteFile(str);
        return true;
    }

    public static List<FileEntry> A(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return Collections.emptyList();
        }
        List<FileEntry> arrayList;
        SFSContextRec jM = jM(str);
        if (jM != null) {
            str = str.substring(jM.cXU.length());
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            try {
                List<FileEntry> ka = jM.cXY.ka(str);
                arrayList = new ArrayList();
                for (FileEntry fileEntry : ka) {
                    if (fileEntry.name.substring(str.length()).indexOf(47) == -1) {
                        arrayList.add(fileEntry);
                    }
                }
                for (FileEntry fileEntry2 : arrayList) {
                    fileEntry2.name = jM.cXU + fileEntry2.name;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.FileOp", e, "listFiles failed with SFS: " + str, new Object[0]);
                arrayList = new ArrayList();
            }
        } else {
            arrayList = new ArrayList();
        }
        if (jM == null || jM.cXV != null || jM.cXW) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(new File(str));
            do {
                File[] listFiles = ((File) arrayDeque.pop()).listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.isFile()) {
                            FileEntry fileEntry3 = new FileEntry();
                            fileEntry3.name = file.getAbsolutePath();
                            if (z) {
                                fileEntry3.size = file.length();
                                fileEntry3.timestamp = file.lastModified();
                            }
                            arrayList.add(fileEntry3);
                        } else {
                            file.isDirectory();
                        }
                    }
                }
            } while (!arrayDeque.isEmpty());
            cXO.readLock().unlock();
            v.d("MicroMsg.FileOp", "listFiles: %s [%d]", str, Integer.valueOf(arrayList.size()));
            return arrayList;
        }
        cXO.readLock().unlock();
        v.d("MicroMsg.FileOp", "listFiles: %s [%d]", str, Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public static boolean B(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return false;
        }
        boolean z2;
        SFSContextRec jM = jM(str);
        if (jM != null) {
            try {
                if (str.equals(jM.cXU)) {
                    SFSContext sFSContext = jM.cXY;
                    if (sFSContext.mNativePtr == 0) {
                        throw new IllegalArgumentException("Reuse already released SFSContext.");
                    } else if (SFSContext.nativeClear(sFSContext.mNativePtr) != 0) {
                        throw new IOException(SFSContext.nativeErrorMessage());
                    }
                }
                for (FileEntry fileEntry : jM.cXY.ka(str.substring(jM.cXU.length()))) {
                    jM.cXY.hc(fileEntry.name);
                }
                z2 = true;
            } catch (Throwable e) {
                v.a("MicroMsg.FileOp", e, "deleteDirIncludedFiles failed: " + str, new Object[0]);
                z2 = false;
            }
        } else {
            File file = new File(str);
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(new a(file));
            do {
                a aVar = (a) arrayDeque.getLast();
                if (aVar.cXT == null) {
                    aVar.cXT = aVar.cXS.listFiles();
                }
                if (aVar.cXT != null) {
                    File[] fileArr = aVar.cXT;
                    for (int i = aVar.pos; i < fileArr.length; i++) {
                        File file2 = fileArr[i];
                        if (file2.isFile()) {
                            file2.delete();
                        } else if (file2.isDirectory()) {
                            aVar.pos = i;
                            arrayDeque.add(new a(file2));
                            break;
                        }
                    }
                    if (!z) {
                        aVar.cXS.delete();
                    }
                    arrayDeque.removeLast();
                } else if (!z) {
                    aVar.cXS.delete();
                }
            } while (!arrayDeque.isEmpty());
            z2 = true;
        }
        cXO.readLock().unlock();
        return z2;
    }

    public static boolean jT(String str) {
        boolean z = false;
        if (str == null || str.length() == 0) {
            return z;
        }
        if (!aR(str)) {
            try {
                try {
                    jN(str).close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                v.e("MicroMsg.FileOp", "createNewFile '%s' failed: %s", str, e2.getMessage());
                return z;
            }
        }
        return true;
    }

    public static void jU(String str) {
        if (str != null && str.length() != 0 && jK(str)) {
            try {
                new File(str, ".nomedia").createNewFile();
            } catch (IOException e) {
                v.e("MicroMsg.FileOp", "markNoMedia '%s' failed: %s", str, e.getMessage());
            }
        }
    }

    public static String jV(String str) {
        if (!aR(str)) {
            return null;
        }
        return g.m((str + "-" + jP(str)).getBytes());
    }
}
