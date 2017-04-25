package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.d;
import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.support.Log;
import com.tencent.mmdb.support.Log.LogCallback;

public final class a extends d {
    public final void execute(ProcessProfile processProfile) {
        if (!k.du("mmdb")) {
            k.b("mmdb", getClass().getClassLoader());
        }
        Log.setLogger(new LogCallback(this) {
            final /* synthetic */ a lxv;

            {
                this.lxv = r1;
            }

            public final void println(int i, String str, String str2) {
                com.tencent.mm.sdk.platformtools.v.a bsZ = v.bsZ();
                int myPid = Process.myPid();
                int myTid = Process.myTid();
                switch (i) {
                    case 2:
                        bsZ.logV(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    case 3:
                        bsZ.logD(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    case 4:
                        bsZ.logI(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    case 5:
                        bsZ.logW(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    case 6:
                        bsZ.logE(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    case 7:
                        bsZ.logF(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, myPid, (long) myTid, (long) myPid, str2);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public final String name() {
        return "boot-db-prepare";
    }
}
