package com.tencent.mm.ae.a.a;

import android.graphics.drawable.Drawable;
import com.tencent.mm.ae.a.c.b;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class c {
    public final String aZy;
    public final float alpha;
    public final String bdZ;
    public final boolean cPA;
    public final boolean cPB;
    public final boolean cPC;
    public final int cPD;
    public final boolean cPE;
    public final boolean cPF;
    public final boolean cPG;
    public final int cPH;
    public final Drawable cPI;
    private final int cPJ;
    private final Drawable cPK;
    public final int cPL;
    public final Drawable cPM;
    public final SFSContext cPN;
    public final boolean cPO;
    public final boolean cPP;
    public final float cPQ;
    public final boolean cPR;
    public final boolean cPS;
    public final Object[] cPT;
    public final b cPi;
    public final boolean cPq;
    public final boolean cPr;
    public final boolean cPs;
    public final boolean cPt;
    public final String cPu;
    public final String cPv;
    public final String cPw;
    public final int cPx;
    public final int cPy;
    public final int cPz;
    public final int density;
    public final ac handler;

    public static class a {
        public String aZy = SQLiteDatabase.KeyEmpty;
        float alpha = 0.0f;
        public String bdZ;
        public boolean cPA = false;
        public boolean cPB = false;
        public boolean cPC;
        public int cPD;
        public boolean cPE;
        public boolean cPF = false;
        boolean cPG = false;
        public int cPH = 0;
        public Drawable cPI = null;
        int cPJ = 0;
        Drawable cPK = null;
        public int cPL = 0;
        public Drawable cPM = null;
        public SFSContext cPN = null;
        public boolean cPO = true;
        public boolean cPP = false;
        public float cPQ = 0.0f;
        public boolean cPR = false;
        public boolean cPS = true;
        public Object[] cPT = null;
        public b cPi = null;
        public boolean cPq = true;
        public boolean cPr = false;
        public boolean cPs = false;
        public boolean cPt = true;
        public String cPu = SQLiteDatabase.KeyEmpty;
        public String cPv = SQLiteDatabase.KeyEmpty;
        String cPw = SQLiteDatabase.KeyEmpty;
        public int cPx = 5;
        public int cPy = 0;
        public int cPz = 0;
        int density = 0;
        ac handler = null;

        public final a aI(int i, int i2) {
            this.cPy = i;
            this.cPz = i2;
            return this;
        }

        public final c GU() {
            return new c();
        }
    }

    private c(a aVar) {
        this.cPq = aVar.cPq;
        this.cPs = aVar.cPs;
        this.cPr = aVar.cPr;
        this.cPt = aVar.cPt;
        this.cPu = aVar.cPu;
        this.cPv = aVar.cPv;
        this.cPw = aVar.cPw;
        this.cPx = aVar.cPx;
        this.cPy = aVar.cPy;
        this.cPz = aVar.cPz;
        this.cPA = aVar.cPA;
        this.aZy = aVar.aZy;
        this.density = aVar.density;
        this.alpha = aVar.alpha;
        this.cPB = aVar.cPB;
        this.cPC = aVar.cPC;
        this.cPD = aVar.cPD;
        this.bdZ = aVar.bdZ;
        this.cPE = aVar.cPE;
        this.cPF = aVar.cPF;
        this.cPG = aVar.cPG;
        this.cPH = aVar.cPH;
        this.cPI = aVar.cPI;
        this.cPJ = aVar.cPJ;
        this.cPK = aVar.cPK;
        this.cPL = aVar.cPL;
        this.cPM = aVar.cPM;
        this.cPO = aVar.cPO;
        this.cPP = aVar.cPP;
        this.cPQ = aVar.cPQ;
        this.cPR = aVar.cPR;
        this.cPS = aVar.cPS;
        this.cPN = aVar.cPN;
        this.handler = aVar.handler;
        this.cPT = aVar.cPT;
        this.cPi = aVar.cPi;
    }
}
