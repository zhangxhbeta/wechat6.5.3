package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class ag {
    public String aZy = "-1";
    public String dhC;
    public boolean dhD;
    public boolean nuZ;
    public String nva = SQLiteDatabase.KeyEmpty;
    public long time;

    public static String a(String str, long j, boolean z, String str2, boolean z2, String str3) {
        int i = 1;
        StringBuilder append = new StringBuilder().append(str).append(":").append(j).append(":").append(z ? 1 : 0).append(":").append(str2).append(":").append(str3.replace(":", "*#*")).append(":");
        if (!z2) {
            i = 0;
        }
        return append.append(i).append("\n").toString();
    }

    public final String bvQ() {
        int i = 1;
        StringBuilder append = new StringBuilder().append(this.dhC).append(":").append(this.time).append(":").append(this.dhD ? 1 : 0).append(":").append(this.aZy).append(":").append(this.nva).append(":");
        if (!this.nuZ) {
            i = 0;
        }
        return append.append(i).append("\n").toString();
    }

    public ag(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
            return;
        }
        try {
            String substring;
            int i;
            if (str.endsWith("\n")) {
                substring = str.substring(0, str.length() - 1);
            } else {
                this.nva = str.replace(":", "*#*");
                substring = str;
            }
            String[] split = substring.split(":", 6);
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
            if (split.length > i + 3) {
                this.aZy = split[i + 3];
            }
            if (split.length > i + 4) {
                this.nva = split[i + 4].replace("*#*", ":");
            }
            if (split.length > i + 5) {
                this.nuZ = split[i + 5].equals("1");
            }
        } catch (Throwable e) {
            this.time = 0;
            v.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", str, be.e(e));
        }
    }

    public static ag Mv(String str) {
        return new ag(str);
    }
}
