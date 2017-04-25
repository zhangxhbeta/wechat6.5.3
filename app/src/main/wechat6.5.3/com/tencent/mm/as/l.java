package com.tencent.mm.as;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class l {
    public String dhC;
    private boolean dhD;
    private long time;

    public static String b(String str, long j, boolean z) {
        return str + ":" + j + ":" + (z ? 1 : 0) + "\n";
    }

    public l(String str) {
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        String[] split = str.split(":");
        try {
            if (split.length > 0) {
                this.dhC = split[0];
            }
            if (split.length > 1) {
                this.time = be.getLong(split[1], 0);
            }
            if (split.length > 2) {
                this.dhD = split[2].equals("1");
            }
        } catch (Exception e) {
            if (this.dhC == null) {
                this.dhC = SQLiteDatabase.KeyEmpty;
            }
            this.dhD = false;
            this.time = 0;
            v.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
        }
    }
}
