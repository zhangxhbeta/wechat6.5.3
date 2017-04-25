package com.tencent.mm.plugin.clean.b;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Calendar;

public final class a {
    public long aYG;
    public String bdZ;
    public long dhI;
    public String filePath;
    public long size;
    public int type;
    private String userName;

    public a(String str, String str2, int i, String str3, long j, long j2) {
        this.size = (long) e.aQ(str2);
        v.v("MicroMsg.AnalyseItem", "add mst %d %d %s %s %d", new Object[]{Long.valueOf(this.size), Integer.valueOf(i), be.ed(this.size), str3, Long.valueOf(j)});
        this.bdZ = str;
        this.type = i;
        this.filePath = str2;
        this.userName = str3;
        this.aYG = j;
        this.dhI = j2;
    }

    public final String toString() {
        switch (this.type) {
            case 1:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"IMG", be.ed(this.size), this.filePath});
            case 2:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"VOICE", be.ed(this.size), this.filePath});
            case 3:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"VIDEO", be.ed(this.size), this.filePath});
            case 4:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"ATTACH", be.ed(this.size), this.filePath});
            default:
                return "";
        }
    }

    public final long adE() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.dhI);
        return (long) (instance.get(2) + (instance.get(1) * 100));
    }
}
