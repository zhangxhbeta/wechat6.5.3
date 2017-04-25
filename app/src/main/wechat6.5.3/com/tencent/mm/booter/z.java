package com.tencent.mm.booter;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Locale;

public final class z {
    public static z bYz = new z();
    public q bYA = new q(t.cng + "staytime.cfg");
    public a bYB;
    public long bYC;
    public long bYD;
    public String bYE;
    public long bYF = -1;
    public int bYG = 20;
    public int bYH = 24;
    public int bYI = 30;
    public int bYJ = 10800;
    public boolean hasInit = false;

    class a {
        public int aWI;
        public String bYK;
        public int bYL;
        public int bYM;
        public long bYN;
        public int bYO;
        final /* synthetic */ z bYP;
        public long time;
        public int type;

        public a(z zVar) {
            this.bYP = zVar;
        }

        public final String toString() {
            return String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d%s|", new Object[]{Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.bYL), Integer.valueOf(this.aWI), Integer.valueOf(this.bYM), Long.valueOf(this.bYN), Integer.valueOf(this.bYO), this.bYK});
        }
    }

    private z() {
    }

    public final void cY(String str) {
        if (str == null || this.bYB == null) {
            boolean z;
            String str2 = "MicroMsg.StayTimeReport";
            String str3 = "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (this.bYB == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            v.i(str2, str3, objArr);
        } else if (str.equals(this.bYB.bYK)) {
            a aVar = this.bYB;
            aVar.time += com.tencent.mm.platformtools.t.az(this.bYC) / 1000;
            this.bYA.set(5, ((String) this.bYA.get(5, SQLiteDatabase.KeyEmpty)) + this.bYB.toString());
            long j = this.bYA.getLong(4, 0);
            int i = this.bYA.getInt(6, 0) + 1;
            this.bYA.setInt(6, i);
            v.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", this.bYB.bYK, Integer.valueOf(this.bYB.type), Long.valueOf(this.bYB.time), Integer.valueOf(this.bYB.bYO), Integer.valueOf(i));
            if (com.tencent.mm.platformtools.t.ax(j) > ((long) this.bYJ) || i > this.bYI) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                v.i("MicroMsg.StayTimeReport", "report %d: %s", Integer.valueOf(13062), ((String) this.bYA.get(5, SQLiteDatabase.KeyEmpty)) + "," + j + "," + com.tencent.mm.platformtools.t.Nh());
                g.iuh.Y(13062, r0);
                this.bYA.setInt(6, 0);
                this.bYA.set(5, SQLiteDatabase.KeyEmpty);
            }
            this.bYB = null;
        } else {
            v.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", str, this.bYB.bYK);
        }
    }
}
