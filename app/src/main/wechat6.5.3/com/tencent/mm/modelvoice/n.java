package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class n {
    public String dhC;
    public boolean dhD;
    public long time;

    public static String b(String str, long j, boolean z) {
        return str + ":" + j + ":" + (z ? 1 : 0) + "\n";
    }

    public n(String str) {
        try {
            int i;
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            String[] split = str.split(":");
            if (split.length == 4 && u.ew(split[0])) {
                i = 1;
            } else {
                i = 0;
            }
            if (split.length > i) {
                this.dhC = split[i];
            }
            if (split.length > i + 1) {
                this.time = be.getLong(split[i + 1], 0);
            }
            if (split.length > i + 2) {
                this.dhD = split[i + 2].equals("1");
            }
        } catch (Exception e) {
            if (this.dhC == null) {
                this.dhC = SQLiteDatabase.KeyEmpty;
            }
            this.dhD = false;
            this.time = 0;
            v.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
        }
    }
}
