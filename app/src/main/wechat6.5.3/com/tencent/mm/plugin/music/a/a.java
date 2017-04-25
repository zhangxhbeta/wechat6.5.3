package com.tencent.mm.plugin.music.a;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.LinkedList;

public final class a {
    public long cOf;
    private int fWe = 0;
    public ArrayList<a> hCk = new ArrayList();
    public LinkedList<Long> hCl = new LinkedList();
    public String hCm;
    public String hCn;
    public String hCo;
    public String hCp;
    public String hCq;
    private boolean hCr = false;
    public String title;

    public static final class a {
        public String content;
        public boolean hCs;
        public long timestamp;

        public final String toString() {
            return String.format("[%d %s]", new Object[]{Long.valueOf(this.timestamp), this.content});
        }
    }

    public static String cj(String str, String str2) {
        if (be.kS(str) || be.kS(str2)) {
            return str;
        }
        if (str2.length() >= str.length() - 1) {
            return "";
        }
        v.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", new Object[]{str, str2, str.substring(str2.length(), str.length() - 1)});
        return str.substring(str2.length(), str.length() - 1);
    }

    public static long wX(String str) {
        int i = 0;
        try {
            int i2;
            String[] split = str.split(":");
            int i3 = be.getInt(split[0], 0);
            if (split.length > 1) {
                String[] split2 = split[1].split("\\.");
                i2 = be.getInt(split2[0], 0);
                if (split2.length > 1) {
                    i = be.getInt(split2[1], 0);
                }
            } else {
                i2 = 0;
            }
            return (long) ((i * 10) + ((i2 * BaseReportManager.MAX_READ_COUNT) + ((i3 * 60) * BaseReportManager.MAX_READ_COUNT)));
        } catch (Throwable e) {
            v.a("MicroMsg.Music.LyricObj", e, "", new Object[0]);
            v.w("MicroMsg.Music.LyricObj", "strToLong error: %s", new Object[]{e.getLocalizedMessage()});
            return 0;
        }
    }

    public final a nt(int i) {
        if (i < 0 || i >= this.hCk.size()) {
            return null;
        }
        return (a) this.hCk.get(i);
    }
}
