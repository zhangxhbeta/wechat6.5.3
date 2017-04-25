package com.tencent.mm.jni.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.e.a.ll;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    private static SparseArray<b> ciM = new SparseArray();
    private static final byte[] ciN = new byte[0];
    private static ac mHandler = new ac(Looper.getMainLooper());

    private static class a implements Runnable {
        private WakerLock ciO = null;

        public a(WakerLock wakerLock) {
            this.ciO = wakerLock;
        }

        public final void run() {
            int i = 1;
            b bVar = (b) a.ciM.get(this.ciO.hashCode());
            String str = "MicroMsg.WakeLockManager";
            String str2 = "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(this.ciO.hashCode());
            objArr[1] = Integer.valueOf(this.ciO.innerWakeLockHashCode());
            objArr[2] = this.ciO.getCreatePosStackLine();
            Collection<a> values = bVar.ciR.values();
            StringBuilder stringBuilder = new StringBuilder();
            for (a aVar : values) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuilder.append(',');
                }
                if (aVar.ciT != 0) {
                    stringBuilder.append('{').append(aVar.ciS).append(',').append(SystemClock.elapsedRealtime() - aVar.ciT).append('}');
                }
            }
            if (stringBuilder.length() == 0) {
                stringBuilder.append("<empty>");
            }
            objArr[3] = stringBuilder.toString();
            v.w(str, str2, objArr);
            this.ciO.unLock();
        }
    }

    private static class b {
        volatile boolean ciP = false;
        a ciQ = null;
        Map<String, a> ciR = new HashMap();

        private static class a {
            public String ciS = null;
            public long ciT = 0;

            public a(String str, long j) {
                this.ciS = str;
                this.ciT = j;
            }
        }

        public b(WakerLock wakerLock) {
            this.ciQ = new a(wakerLock);
        }
    }

    private static class c {
        private static long aRU = 0;
        private static int ciU = 0;
        private static long ciV = 0;
        private static HashMap<String, a> ciW = null;
        private static final byte[] ciX = new byte[0];
        private static BroadcastReceiver ciY = null;

        private static class a implements Externalizable {
            public String ciS;
            public String ciZ;
            public boolean cja;
            public int cjb;
            public int cjc;
            public long cjd;
            public long cje;
            public AtomicInteger cjf;
            public String mProcessName;

            private a() {
                this.mProcessName = SQLiteDatabase.KeyEmpty;
                this.ciS = SQLiteDatabase.KeyEmpty;
                this.ciZ = SQLiteDatabase.KeyEmpty;
                this.cja = false;
                this.cjb = 0;
                this.cjc = 0;
                this.cjd = 0;
                this.cje = 0;
                this.cjf = new AtomicInteger(0);
            }

            public final void readExternal(ObjectInput objectInput) {
                this.mProcessName = objectInput.readUTF();
                this.ciS = objectInput.readUTF();
                this.cjb = objectInput.readInt();
                this.cjc = objectInput.readInt();
                this.cjd = objectInput.readLong();
                this.ciZ = SQLiteDatabase.KeyEmpty;
                this.cja = false;
                this.cje = 0;
                this.cjf = new AtomicInteger(0);
            }

            public final void writeExternal(ObjectOutput objectOutput) {
                objectOutput.writeUTF(this.mProcessName);
                objectOutput.writeUTF(this.ciS);
                objectOutput.writeInt(this.cjb);
                objectOutput.writeInt(this.cjc);
                objectOutput.writeLong(this.cjd);
            }
        }

        public static void uw() {
            ObjectInputStream objectInputStream;
            IntentFilter intentFilter;
            Throwable th;
            ObjectInputStream objectInputStream2 = null;
            if (ciU == 0) {
                ciU = Process.myPid();
                ciY = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        String action = intent.getAction();
                        if (!be.kS(action)) {
                            int intExtra = intent.getIntExtra("pid", 0);
                            if (intExtra != 0) {
                                String stringExtra = intent.getStringExtra("processName");
                                if (!be.kS(stringExtra) && stringExtra.equals(be.p(aa.getContext(), intExtra))) {
                                    String stringExtra2 = intent.getStringExtra("traceMsg");
                                    long longExtra = intent.getLongExtra("tick", 0);
                                    if ("com.tencent.mm.ACTION.note_tracemsg_lock".equals(action)) {
                                        c.a(stringExtra, stringExtra2, longExtra);
                                    } else if ("com.tencent.mm.ACTION.note_tracemsg_unlock".equals(action)) {
                                        c.b(stringExtra, stringExtra2, longExtra);
                                    }
                                }
                            }
                        }
                    }
                };
                synchronized (ciX) {
                    try {
                        ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(new File(aa.getContext().getCacheDir(), "wakelock/wakelock_stats.bin")));
                        try {
                            aRU = objectInputStream3.readLong();
                            ciW = (HashMap) objectInputStream3.readObject();
                            try {
                                objectInputStream3.close();
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            objectInputStream = objectInputStream3;
                            try {
                                v.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                                aRU = SystemClock.elapsedRealtime();
                                ciW = new HashMap();
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                intentFilter = new IntentFilter();
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                                aa.getContext().registerReceiver(ciY, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
                                v.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", aa.getProcessName());
                            } catch (Throwable th2) {
                                objectInputStream2 = objectInputStream;
                                th = th2;
                                if (objectInputStream2 != null) {
                                    try {
                                        objectInputStream2.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            objectInputStream2 = objectInputStream3;
                            if (objectInputStream2 != null) {
                                objectInputStream2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        objectInputStream = null;
                        v.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                        aRU = SystemClock.elapsedRealtime();
                        ciW = new HashMap();
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                        aa.getContext().registerReceiver(ciY, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
                        v.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", aa.getProcessName());
                    } catch (Throwable th4) {
                        th = th4;
                        if (objectInputStream2 != null) {
                            objectInputStream2.close();
                        }
                        throw th;
                    }
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                aa.getContext().registerReceiver(ciY, intentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
                v.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", aa.getProcessName());
            }
        }

        public static void detach() {
            if (ciU > 0) {
                aa.getContext().unregisterReceiver(ciY);
                uy();
                ciU = 0;
                v.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", aa.getProcessName());
            }
        }

        public static void dN(String str) {
            j(str, true);
        }

        public static void dO(String str) {
            j(str, false);
        }

        private static void j(String str, boolean z) {
            int myPid = Process.myPid();
            String processName = aa.getProcessName();
            if (myPid == ciU) {
                if (z) {
                    a(processName, str, SystemClock.elapsedRealtime());
                } else {
                    b(processName, str, SystemClock.elapsedRealtime());
                }
            } else if (z) {
                r2 = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
                r2.putExtra("pid", myPid);
                r2.putExtra("processName", processName);
                r2.putExtra("traceMsg", str);
                r2.putExtra("tick", SystemClock.elapsedRealtime());
                aa.getContext().sendBroadcast(r2, "com.tencent.mm.permission.MM_MESSAGE");
            } else {
                r2 = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
                r2.putExtra("pid", myPid);
                r2.putExtra("processName", processName);
                r2.putExtra("traceMsg", str);
                r2.putExtra("tick", SystemClock.elapsedRealtime());
                aa.getContext().sendBroadcast(r2, "com.tencent.mm.permission.MM_MESSAGE");
            }
        }

        private static void a(String str, String str2, long j) {
            String str3 = str + "_" + str2;
            synchronized (ciX) {
                a aVar = (a) ciW.get(str3);
                if (aVar == null) {
                    aVar = new a();
                    aVar.mProcessName = str;
                    aVar.ciS = str2;
                    aVar.cjd = 0;
                    aVar.cjb = 0;
                    aVar.cjc = 0;
                    ciW.put(str3, aVar);
                }
                if (aVar.cjf.getAndIncrement() == 0) {
                    aVar.cje = j;
                    aVar.ciZ = ak.getNetTypeString(aa.getContext());
                    aVar.cja = com.tencent.mm.sdk.b.b.foreground;
                }
            }
        }

        private static void b(String str, String str2, long j) {
            String str3 = str + "_" + str2;
            long j2 = 0;
            synchronized (ciX) {
                a aVar = (a) ciW.get(str3);
                if (aVar != null && aVar.cjf.get() > 0) {
                    aVar.cjb++;
                    if (aVar.cjf.decrementAndGet() == 0) {
                        j2 = j - aVar.cje;
                        aVar.cjd += j2;
                        aVar.cjc++;
                    }
                }
                long j3 = j2;
            }
            ux();
            j2 = SystemClock.elapsedRealtime();
            if (j3 >= 14000 || j2 - ciV >= 3600000) {
                v.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
                uy();
                ciV = j2;
            }
        }

        private static void ux() {
            synchronized (ciX) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - aRU >= 21600000) {
                    if (!ciW.isEmpty()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Entry value : ciW.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar.cjc > 0) {
                                stringBuilder.setLength(0);
                                stringBuilder.append(aVar.mProcessName).append(',').append(aVar.ciS.replace(",", "##")).append(',').append(aVar.cjc).append(',').append(aVar.cjb).append(',').append(aVar.cjd).append(',').append(aVar.cja ? 1 : 0).append(',').append(aVar.ciZ);
                                String stringBuilder2 = stringBuilder.toString();
                                com.tencent.mm.sdk.c.b llVar = new ll();
                                llVar.bmP.bmQ = stringBuilder2;
                                com.tencent.mm.sdk.c.a.nhr.z(llVar);
                                v.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", stringBuilder.toString());
                            }
                        }
                        ciW.clear();
                    }
                    aRU = elapsedRealtime;
                }
            }
        }

        private static void uy() {
            Throwable e;
            synchronized (ciX) {
                ObjectOutputStream objectOutputStream = null;
                try {
                    File file = new File(aa.getContext().getCacheDir(), "wakelock");
                    if (FileOp.jS(file.getAbsolutePath())) {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(file, "wakelock_stats.bin")));
                        try {
                            objectOutputStream2.writeLong(aRU);
                            objectOutputStream2.writeObject(ciW);
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e2) {
                            }
                        } catch (IOException e3) {
                            e = e3;
                            objectOutputStream = objectOutputStream2;
                            try {
                                v.a("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                            } catch (Throwable th) {
                                e = th;
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            throw e;
                        }
                    } else {
                        throw new IOException("failed to call FileOp.mkdirs(" + file.getAbsolutePath() + ")");
                    }
                } catch (IOException e6) {
                    e = e6;
                    v.a("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                }
            }
        }
    }

    public static void ut() {
        c.uw();
    }

    public static void uu() {
        c.detach();
    }

    public static void a(WakerLock wakerLock, String str) {
        synchronized (ciN) {
            b bVar = (b) ciM.get(wakerLock.hashCode());
            if (bVar == null) {
                bVar = new b(wakerLock);
                ciM.put(wakerLock.hashCode(), bVar);
            }
            if (!bVar.ciR.containsKey(str)) {
                bVar.ciR.put(str, new a(str, SystemClock.elapsedRealtime()));
            }
            c.dN(str);
            ac acVar = mHandler;
            if (!bVar.ciP) {
                bVar.ciP = true;
                acVar.postDelayed(bVar.ciQ, 60000);
            }
        }
    }

    public static void c(WakerLock wakerLock) {
        synchronized (ciN) {
            b bVar = (b) ciM.get(wakerLock.hashCode());
            if (bVar != null) {
                ac acVar = mHandler;
                if (bVar.ciP) {
                    bVar.ciP = false;
                    acVar.removeCallbacks(bVar.ciQ);
                }
                for (a aVar : bVar.ciR.values()) {
                    c.dO(aVar.ciS);
                }
                bVar.ciR.clear();
            }
        }
    }
}
