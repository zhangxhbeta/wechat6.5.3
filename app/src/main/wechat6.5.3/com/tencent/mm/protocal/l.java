package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.en;
import com.tencent.mm.protocal.c.eo;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class l {

    public interface a {
        boolean aRf();

        byte[] zf();

        int zg();
    }

    public interface b {
        boolean aRf();

        int y(byte[] bArr);
    }

    public static class c {
        public byte[] aKD = new byte[0];
        public int lWM = 0;
        public int lWN = 0;
        public String lWO = SQLiteDatabase.KeyEmpty;
        public String lWP = SQLiteDatabase.KeyEmpty;
        public int lWQ = 0;
        public boolean lWR = true;
        public ad lWS = new ad(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0);
        public long lWT = 0;

        public void cW(int i) {
            this.lWM = i;
        }

        public int getCmdId() {
            return 0;
        }

        public boolean aRf() {
            return false;
        }

        public boolean Cd() {
            return this.lWR;
        }
    }

    public static class d {
        public long lWT = 0;
        public int lWU = -99;
        public String lWV = SQLiteDatabase.KeyEmpty;

        public int getCmdId() {
            return 0;
        }

        public boolean aRf() {
            return false;
        }
    }

    public static en a(c cVar) {
        en enVar = new en();
        enVar.mfB = cVar.lWN;
        enVar.mfA = com.tencent.mm.ba.b.aT(cVar.lWP.getBytes()).uz(16);
        enVar.mfC = com.tencent.mm.ba.b.aT(cVar.lWO.getBytes()).uz(132);
        enVar.maG = cVar.lWQ;
        enVar.mfz = com.tencent.mm.ba.b.aT(cVar.aKD).uz(36);
        enVar.fvo = cVar.lWM;
        return enVar;
    }

    public static void a(d dVar, eo eoVar) {
        if (eoVar.mfD != null) {
            dVar.lWV = eoVar.mfD.mQy;
            return;
        }
        dVar.lWV = SQLiteDatabase.KeyEmpty;
        v.e("MicroMsg.MMBase", "ErrMsg is Null!!!!!!");
    }
}
