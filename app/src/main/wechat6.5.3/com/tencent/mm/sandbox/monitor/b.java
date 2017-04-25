package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import com.tencent.mm.protocal.d;

public final class b {

    static class a {
        public String lcr;
        public boolean nfh;
        public final String platform = (d.cmW + "_" + d.lWh + "_" + Build.CPU_ABI);
        public String tag;
        public long timestamp;
        public String username;

        public a(String str, String str2, long j, String str3, boolean z) {
            this.username = str;
            this.tag = str2;
            this.timestamp = j;
            this.lcr = str3;
            this.nfh = false;
            this.nfh = z;
        }

        public final String toString() {
            return this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.lcr;
        }
    }
}
