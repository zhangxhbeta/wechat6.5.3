package com.tencent.pb.common.b.a;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Arrays;

public interface a {

    public static final class a extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;
        public int[] ppO;
        public String[] ppP;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                int b;
                Object obj;
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        b = com.google.a.a.g.b(aVar, 32);
                        mG = this.ppO == null ? 0 : this.ppO.length;
                        obj = new int[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.ppO, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.mH();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.mH();
                        this.ppO = obj;
                        continue;
                    case 34:
                        int cp = aVar.cp(aVar.mH());
                        b = aVar.getPosition();
                        mG = 0;
                        while (aVar.mK() > 0) {
                            aVar.mH();
                            mG++;
                        }
                        aVar.cr(b);
                        b = this.ppO == null ? 0 : this.ppO.length;
                        Object obj2 = new int[(mG + b)];
                        if (b != 0) {
                            System.arraycopy(this.ppO, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mH();
                            b++;
                        }
                        this.ppO = obj2;
                        aVar.cq(cp);
                        continue;
                    case 802:
                        b = com.google.a.a.g.b(aVar, 802);
                        mG = this.ppP == null ? 0 : this.ppP.length;
                        obj = new String[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.ppP, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.readString();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.readString();
                        this.ppP = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public a() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.ppO = com.google.a.a.g.aGA;
            this.ppP = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.ppO != null && this.ppO.length > 0) {
                for (int ak : this.ppO) {
                    bVar.ak(4, ak);
                }
            }
            if (this.ppP != null && this.ppP.length > 0) {
                while (i < this.ppP.length) {
                    String str = this.ppP[i];
                    if (str != null) {
                        bVar.e(100, str);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int mU() {
            int i;
            int i2;
            int i3 = 0;
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.ppO != null && this.ppO.length > 0) {
                i = 0;
                for (int cy : this.ppO) {
                    i += com.google.a.a.b.cy(cy);
                }
                mU = (mU + i) + (this.ppO.length * 1);
            }
            if (this.ppP == null || this.ppP.length <= 0) {
                return mU;
            }
            i2 = 0;
            i = 0;
            while (i3 < this.ppP.length) {
                String str = this.ppP[i3];
                if (str != null) {
                    i++;
                    i2 += com.google.a.a.b.au(str);
                }
                i3++;
            }
            return (mU + i2) + (i * 2);
        }
    }

    public static final class aa extends com.google.a.a.e {
        public String lEs;
        public ao ppS;
        public int prl;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        if (this.ppS == null) {
                            this.ppS = new ao();
                        }
                        aVar.a(this.ppS);
                        continue;
                    case 24:
                        this.prl = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public aa() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.ppS = null;
            this.prl = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.ppS != null) {
                bVar.a(2, this.ppS);
            }
            if (this.prl != 0) {
                bVar.aj(3, this.prl);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.ppS != null) {
                mU += com.google.a.a.b.b(2, this.ppS);
            }
            if (this.prl != 0) {
                return mU + com.google.a.a.b.al(3, this.prl);
            }
            return mU;
        }
    }

    public static final class ab extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;
        public String ppQ;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case 34:
                        this.ppQ = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ab() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.ppQ = SQLiteDatabase.KeyEmpty;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (!this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(4, this.ppQ);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                return mU;
            }
            return mU + com.google.a.a.b.f(4, this.ppQ);
        }
    }

    public static final class ac extends com.google.a.a.e {
        public int prm;

        public ac() {
            this.prm = 0;
            this.aGz = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.prm = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.prm != 0) {
                bVar.ak(1, this.prm);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            return this.prm != 0 ? mU + com.google.a.a.b.am(1, this.prm) : mU;
        }
    }

    public static final class ad extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;
        public ao ppS;
        public an pqu;
        public aq[] pre;
        public n[] prf;
        public ar[] prg;
        public int prh;
        public int[] pri;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                int b;
                Object obj;
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case 34:
                        b = com.google.a.a.g.b(aVar, 34);
                        mG = this.prf == null ? 0 : this.prf.length;
                        obj = new n[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prf, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new n();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new n();
                        aVar.a(obj[mG]);
                        this.prf = obj;
                        continue;
                    case 42:
                        if (this.pqu == null) {
                            this.pqu = new an();
                        }
                        aVar.a(this.pqu);
                        continue;
                    case 48:
                        this.prh = aVar.mH();
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        b = com.google.a.a.g.b(aVar, 56);
                        mG = this.pri == null ? 0 : this.pri.length;
                        obj = new int[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pri, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.mH();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.mH();
                        this.pri = obj;
                        continue;
                    case 58:
                        int cp = aVar.cp(aVar.mH());
                        b = aVar.getPosition();
                        mG = 0;
                        while (aVar.mK() > 0) {
                            aVar.mH();
                            mG++;
                        }
                        aVar.cr(b);
                        b = this.pri == null ? 0 : this.pri.length;
                        Object obj2 = new int[(mG + b)];
                        if (b != 0) {
                            System.arraycopy(this.pri, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mH();
                            b++;
                        }
                        this.pri = obj2;
                        aVar.cq(cp);
                        continue;
                    case 1602:
                        b = com.google.a.a.g.b(aVar, 1602);
                        mG = this.pre == null ? 0 : this.pre.length;
                        obj = new aq[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pre, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new aq();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new aq();
                        aVar.a(obj[mG]);
                        this.pre = obj;
                        continue;
                    case 1610:
                        b = com.google.a.a.g.b(aVar, 1610);
                        mG = this.prg == null ? 0 : this.prg.length;
                        obj = new ar[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prg, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new ar();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new ar();
                        aVar.a(obj[mG]);
                        this.prg = obj;
                        continue;
                    case 1618:
                        if (this.ppS == null) {
                            this.ppS = new ao();
                        }
                        aVar.a(this.ppS);
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ad() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.prf = n.bLZ();
            this.pqu = null;
            this.prh = 0;
            this.pri = com.google.a.a.g.aGA;
            this.pre = aq.bMe();
            this.prg = ar.bMf();
            this.ppS = null;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.prf != null && this.prf.length > 0) {
                for (com.google.a.a.e eVar : this.prf) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.pqu != null) {
                bVar.a(5, this.pqu);
            }
            if (this.prh != 0) {
                bVar.aj(6, this.prh);
            }
            if (this.pri != null && this.pri.length > 0) {
                for (int aj : this.pri) {
                    bVar.aj(7, aj);
                }
            }
            if (this.pre != null && this.pre.length > 0) {
                for (com.google.a.a.e eVar2 : this.pre) {
                    if (eVar2 != null) {
                        bVar.a(200, eVar2);
                    }
                }
            }
            if (this.prg != null && this.prg.length > 0) {
                while (i < this.prg.length) {
                    com.google.a.a.e eVar3 = this.prg[i];
                    if (eVar3 != null) {
                        bVar.a(201, eVar3);
                    }
                    i++;
                }
            }
            if (this.ppS != null) {
                bVar.a(202, this.ppS);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int i;
            int i2 = 0;
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.prf != null && this.prf.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar : this.prf) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                mU = i;
            }
            if (this.pqu != null) {
                mU += com.google.a.a.b.b(5, this.pqu);
            }
            if (this.prh != 0) {
                mU += com.google.a.a.b.al(6, this.prh);
            }
            if (this.pri != null && this.pri.length > 0) {
                int i3 = 0;
                for (int cu : this.pri) {
                    i3 += com.google.a.a.b.cu(cu);
                }
                mU = (mU + i3) + (this.pri.length * 1);
            }
            if (this.pre != null && this.pre.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar2 : this.pre) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(200, eVar2);
                    }
                }
                mU = i;
            }
            if (this.prg != null && this.prg.length > 0) {
                while (i2 < this.prg.length) {
                    com.google.a.a.e eVar3 = this.prg[i2];
                    if (eVar3 != null) {
                        mU += com.google.a.a.b.b(201, eVar3);
                    }
                    i2++;
                }
            }
            if (this.ppS != null) {
                return mU + com.google.a.a.b.b(202, this.ppS);
            }
            return mU;
        }
    }

    public static final class ae extends com.google.a.a.e {
        public ap[] prn;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        int b = com.google.a.a.g.b(aVar, 10);
                        mG = this.prn == null ? 0 : this.prn.length;
                        Object obj = new ap[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prn, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new ap();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new ap();
                        aVar.a(obj[mG]);
                        this.prn = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ae() {
            this.prn = ap.bMd();
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.prn != null && this.prn.length > 0) {
                for (com.google.a.a.e eVar : this.prn) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.prn != null && this.prn.length > 0) {
                for (com.google.a.a.e eVar : this.prn) {
                    if (eVar != null) {
                        mU += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return mU;
        }
    }

    public static final class af extends com.google.a.a.e {
        public int ret;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.ret = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public af() {
            this.ret = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.ret != 0) {
                bVar.aj(1, this.ret);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.ret != 0) {
                return mU + com.google.a.a.b.al(1, this.ret);
            }
            return mU;
        }
    }

    public static final class ag extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;
        public ao ppS;
        public an pqu;
        public aq[] pre;
        public n[] prf;
        public ar[] prg;
        public int prh;
        public int[] pri;
        public n[] prj;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                int b;
                Object obj;
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case 34:
                        b = com.google.a.a.g.b(aVar, 34);
                        mG = this.prf == null ? 0 : this.prf.length;
                        obj = new n[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prf, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new n();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new n();
                        aVar.a(obj[mG]);
                        this.prf = obj;
                        continue;
                    case 42:
                        b = com.google.a.a.g.b(aVar, 42);
                        mG = this.pre == null ? 0 : this.pre.length;
                        obj = new aq[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pre, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new aq();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new aq();
                        aVar.a(obj[mG]);
                        this.pre = obj;
                        continue;
                    case 50:
                        if (this.pqu == null) {
                            this.pqu = new an();
                        }
                        aVar.a(this.pqu);
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        this.prh = aVar.mH();
                        continue;
                    case FileUtils.S_IXUSR /*64*/:
                        b = com.google.a.a.g.b(aVar, 64);
                        mG = this.pri == null ? 0 : this.pri.length;
                        obj = new int[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pri, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.mH();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.mH();
                        this.pri = obj;
                        continue;
                    case 66:
                        int cp = aVar.cp(aVar.mH());
                        b = aVar.getPosition();
                        mG = 0;
                        while (aVar.mK() > 0) {
                            aVar.mH();
                            mG++;
                        }
                        aVar.cr(b);
                        b = this.pri == null ? 0 : this.pri.length;
                        Object obj2 = new int[(mG + b)];
                        if (b != 0) {
                            System.arraycopy(this.pri, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mH();
                            b++;
                        }
                        this.pri = obj2;
                        aVar.cq(cp);
                        continue;
                    case 74:
                        b = com.google.a.a.g.b(aVar, 74);
                        mG = this.prg == null ? 0 : this.prg.length;
                        obj = new ar[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prg, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new ar();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new ar();
                        aVar.a(obj[mG]);
                        this.prg = obj;
                        continue;
                    case 82:
                        if (this.ppS == null) {
                            this.ppS = new ao();
                        }
                        aVar.a(this.ppS);
                        continue;
                    case 90:
                        b = com.google.a.a.g.b(aVar, 90);
                        mG = this.prj == null ? 0 : this.prj.length;
                        obj = new n[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prj, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new n();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new n();
                        aVar.a(obj[mG]);
                        this.prj = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ag() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.prf = n.bLZ();
            this.pre = aq.bMe();
            this.pqu = null;
            this.prh = 0;
            this.pri = com.google.a.a.g.aGA;
            this.prg = ar.bMf();
            this.ppS = null;
            this.prj = n.bLZ();
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.prf != null && this.prf.length > 0) {
                for (com.google.a.a.e eVar : this.prf) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.pre != null && this.pre.length > 0) {
                for (com.google.a.a.e eVar2 : this.pre) {
                    if (eVar2 != null) {
                        bVar.a(5, eVar2);
                    }
                }
            }
            if (this.pqu != null) {
                bVar.a(6, this.pqu);
            }
            if (this.prh != 0) {
                bVar.aj(7, this.prh);
            }
            if (this.pri != null && this.pri.length > 0) {
                for (int aj : this.pri) {
                    bVar.aj(8, aj);
                }
            }
            if (this.prg != null && this.prg.length > 0) {
                for (com.google.a.a.e eVar22 : this.prg) {
                    if (eVar22 != null) {
                        bVar.a(9, eVar22);
                    }
                }
            }
            if (this.ppS != null) {
                bVar.a(10, this.ppS);
            }
            if (this.prj != null && this.prj.length > 0) {
                while (i < this.prj.length) {
                    com.google.a.a.e eVar3 = this.prj[i];
                    if (eVar3 != null) {
                        bVar.a(11, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int mU() {
            int i;
            int i2 = 0;
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.prf != null && this.prf.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar : this.prf) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                mU = i;
            }
            if (this.pre != null && this.pre.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar2 : this.pre) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(5, eVar2);
                    }
                }
                mU = i;
            }
            if (this.pqu != null) {
                mU += com.google.a.a.b.b(6, this.pqu);
            }
            if (this.prh != 0) {
                mU += com.google.a.a.b.al(7, this.prh);
            }
            if (this.pri != null && this.pri.length > 0) {
                int i3 = 0;
                for (int cu : this.pri) {
                    i3 += com.google.a.a.b.cu(cu);
                }
                mU = (mU + i3) + (this.pri.length * 1);
            }
            if (this.prg != null && this.prg.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar22 : this.prg) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(9, eVar22);
                    }
                }
                mU = i;
            }
            if (this.ppS != null) {
                mU += com.google.a.a.b.b(10, this.ppS);
            }
            if (this.prj != null && this.prj.length > 0) {
                while (i2 < this.prj.length) {
                    com.google.a.a.e eVar3 = this.prj[i2];
                    if (eVar3 != null) {
                        mU += com.google.a.a.b.b(11, eVar3);
                    }
                    i2++;
                }
            }
            return mU;
        }
    }

    public static final class ah extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ah() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                return mU + com.google.a.a.b.h(3, this.ktz);
            }
            return mU;
        }
    }

    public static final class ai extends com.google.a.a.e {
        public byte[] buffer;
        public int mQu;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.mQu = aVar.mH();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.buffer = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ai() {
            this.mQu = 0;
            this.buffer = com.google.a.a.g.aGG;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            bVar.ak(1, this.mQu);
            if (!Arrays.equals(this.buffer, com.google.a.a.g.aGG)) {
                bVar.a(2, this.buffer);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU() + com.google.a.a.b.am(1, this.mQu);
            if (Arrays.equals(this.buffer, com.google.a.a.g.aGG)) {
                return mU;
            }
            return mU + com.google.a.a.b.b(2, this.buffer);
        }
    }

    public static final class aj extends com.google.a.a.e {
        private static volatile aj[] pro;
        public int gGl;
        public int lYf;
        public String prp;
        public int prq;

        public aj() {
            this.gGl = 0;
            this.prp = SQLiteDatabase.KeyEmpty;
            this.lYf = 0;
            this.prq = 0;
            this.aGz = -1;
        }

        public static aj[] bMb() {
            if (pro == null) {
                synchronized (com.google.a.a.c.aGy) {
                    if (pro == null) {
                        pro = new aj[0];
                    }
                }
            }
            return pro;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.gGl = aVar.mH();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.prp = aVar.readString();
                        continue;
                    case 24:
                        this.lYf = aVar.mH();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.prq = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.gGl != 0) {
                bVar.ak(1, this.gGl);
            }
            if (!this.prp.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(2, this.prp);
            }
            if (this.lYf != 0) {
                bVar.ak(3, this.lYf);
            }
            if (this.prq != 0) {
                bVar.ak(4, this.prq);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.gGl != 0) {
                mU += com.google.a.a.b.am(1, this.gGl);
            }
            if (!this.prp.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(2, this.prp);
            }
            if (this.lYf != 0) {
                mU += com.google.a.a.b.am(3, this.lYf);
            }
            return this.prq != 0 ? mU + com.google.a.a.b.am(4, this.prq) : mU;
        }
    }

    public static final class ak extends com.google.a.a.e {
        public int cZF;
        public long prr;
        public int prs;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.prr = aVar.mI();
                        continue;
                    case 16:
                        this.cZF = aVar.mH();
                        continue;
                    case 24:
                        this.prs = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ak() {
            this.prr = 0;
            this.cZF = 0;
            this.prs = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.prr != 0) {
                bVar.e(1, this.prr);
            }
            if (this.cZF != 0) {
                bVar.ak(2, this.cZF);
            }
            if (this.prs != 0) {
                bVar.ak(3, this.prs);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.prr != 0) {
                mU += com.google.a.a.b.g(1, this.prr);
            }
            if (this.cZF != 0) {
                mU += com.google.a.a.b.am(2, this.cZF);
            }
            if (this.prs != 0) {
                return mU + com.google.a.a.b.am(3, this.prs);
            }
            return mU;
        }
    }

    public static final class al extends com.google.a.a.e {
        public int hGO;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.hGO = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public al() {
            this.hGO = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.hGO != 0) {
                bVar.aj(1, this.hGO);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.hGO != 0) {
                return mU + com.google.a.a.b.al(1, this.hGO);
            }
            return mU;
        }
    }

    public static final class am extends com.google.a.a.e {
        private static volatile am[] prt;
        public int pru;
        public int prv;
        public byte[] prw;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.pru = aVar.mH();
                        continue;
                    case 16:
                        this.prv = aVar.mH();
                        continue;
                    case android.support.v7.a.a.k.Kr /*26*/:
                        this.prw = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static am[] bMc() {
            if (prt == null) {
                synchronized (com.google.a.a.c.aGy) {
                    if (prt == null) {
                        prt = new am[0];
                    }
                }
            }
            return prt;
        }

        public am() {
            this.pru = 0;
            this.prv = 0;
            this.prw = com.google.a.a.g.aGG;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.pru != 0) {
                bVar.aj(1, this.pru);
            }
            if (this.prv != 0) {
                bVar.aj(2, this.prv);
            }
            if (!Arrays.equals(this.prw, com.google.a.a.g.aGG)) {
                bVar.a(3, this.prw);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.pru != 0) {
                mU += com.google.a.a.b.al(1, this.pru);
            }
            if (this.prv != 0) {
                mU += com.google.a.a.b.al(2, this.prv);
            }
            if (Arrays.equals(this.prw, com.google.a.a.g.aGG)) {
                return mU;
            }
            return mU + com.google.a.a.b.b(3, this.prw);
        }
    }

    public static final class an extends com.google.a.a.e {
        public int cGs;
        public int cGt;
        public int prA;
        public int prB;
        public int prC;
        public int prD;
        public int prE;
        public int prF;
        public int prG;
        public int prx;
        public int pry;
        public int prz;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.prx = aVar.mH();
                        continue;
                    case 16:
                        this.cGs = aVar.mH();
                        continue;
                    case 24:
                        this.cGt = aVar.mH();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.pry = aVar.mH();
                        continue;
                    case 40:
                        this.prz = aVar.mH();
                        continue;
                    case 48:
                        this.prA = aVar.mH();
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        this.prB = aVar.mH();
                        continue;
                    case FileUtils.S_IXUSR /*64*/:
                        this.prC = aVar.mH();
                        continue;
                    case 72:
                        this.prD = aVar.mH();
                        continue;
                    case 80:
                        this.prE = aVar.mH();
                        continue;
                    case 88:
                        this.prF = aVar.mH();
                        continue;
                    case 96:
                        this.prG = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public an() {
            this.prx = 0;
            this.cGs = 0;
            this.cGt = 0;
            this.pry = 0;
            this.prz = 0;
            this.prA = 0;
            this.prB = 0;
            this.prC = 0;
            this.prD = 0;
            this.prE = 0;
            this.prF = 0;
            this.prG = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.prx != 0) {
                bVar.aj(1, this.prx);
            }
            if (this.cGs != 0) {
                bVar.aj(2, this.cGs);
            }
            if (this.cGt != 0) {
                bVar.aj(3, this.cGt);
            }
            if (this.pry != 0) {
                bVar.aj(4, this.pry);
            }
            if (this.prz != 0) {
                bVar.aj(5, this.prz);
            }
            if (this.prA != 0) {
                bVar.aj(6, this.prA);
            }
            if (this.prB != 0) {
                bVar.aj(7, this.prB);
            }
            if (this.prC != 0) {
                bVar.aj(8, this.prC);
            }
            if (this.prD != 0) {
                bVar.aj(9, this.prD);
            }
            if (this.prE != 0) {
                bVar.aj(10, this.prE);
            }
            if (this.prF != 0) {
                bVar.aj(11, this.prF);
            }
            if (this.prG != 0) {
                bVar.aj(12, this.prG);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.prx != 0) {
                mU += com.google.a.a.b.al(1, this.prx);
            }
            if (this.cGs != 0) {
                mU += com.google.a.a.b.al(2, this.cGs);
            }
            if (this.cGt != 0) {
                mU += com.google.a.a.b.al(3, this.cGt);
            }
            if (this.pry != 0) {
                mU += com.google.a.a.b.al(4, this.pry);
            }
            if (this.prz != 0) {
                mU += com.google.a.a.b.al(5, this.prz);
            }
            if (this.prA != 0) {
                mU += com.google.a.a.b.al(6, this.prA);
            }
            if (this.prB != 0) {
                mU += com.google.a.a.b.al(7, this.prB);
            }
            if (this.prC != 0) {
                mU += com.google.a.a.b.al(8, this.prC);
            }
            if (this.prD != 0) {
                mU += com.google.a.a.b.al(9, this.prD);
            }
            if (this.prE != 0) {
                mU += com.google.a.a.b.al(10, this.prE);
            }
            if (this.prF != 0) {
                mU += com.google.a.a.b.al(11, this.prF);
            }
            if (this.prG != 0) {
                return mU + com.google.a.a.b.al(12, this.prG);
            }
            return mU;
        }
    }

    public static final class ao extends com.google.a.a.e {
        public byte[] aKC;
        public int bdW;
        public String name;
        public byte[] prH;
        public long prI;
        public byte[] prJ;
        public byte[] prK;
        public byte[] prL;
        public as prM;
        public byte[] prN;
        public String prO;
        public String prP;
        public long prQ;
        public byte[] prR;
        public byte[] prS;
        public byte[] prT;
        public byte[] prU;
        public int prV;
        public byte[] prW;
        public byte[] prX;
        public int prY;
        public m[] prZ;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.name = aVar.readString();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.prH = aVar.readBytes();
                        continue;
                    case 24:
                        this.bdW = aVar.mH();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.prI = aVar.mI();
                        continue;
                    case 42:
                        this.prJ = aVar.readBytes();
                        continue;
                    case 50:
                        this.prK = aVar.readBytes();
                        continue;
                    case 58:
                        this.prL = aVar.readBytes();
                        continue;
                    case 66:
                        if (this.prM == null) {
                            this.prM = new as();
                        }
                        aVar.a(this.prM);
                        continue;
                    case 74:
                        this.prN = aVar.readBytes();
                        continue;
                    case 802:
                        this.prO = aVar.readString();
                        continue;
                    case 810:
                        this.prP = aVar.readString();
                        continue;
                    case 1600:
                        this.prQ = aVar.mI();
                        continue;
                    case 1610:
                        this.prR = aVar.readBytes();
                        continue;
                    case 1618:
                        this.prS = aVar.readBytes();
                        continue;
                    case 1626:
                        this.prT = aVar.readBytes();
                        continue;
                    case 1634:
                        this.prU = aVar.readBytes();
                        continue;
                    case 1760:
                        this.prV = aVar.mH();
                        continue;
                    case 1770:
                        this.prW = aVar.readBytes();
                        continue;
                    case 1778:
                        this.prX = aVar.readBytes();
                        continue;
                    case 1786:
                        this.aKC = aVar.readBytes();
                        continue;
                    case 1792:
                        this.prY = aVar.mH();
                        continue;
                    case 1802:
                        int b = com.google.a.a.g.b(aVar, 1802);
                        mG = this.prZ == null ? 0 : this.prZ.length;
                        Object obj = new m[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prZ, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new m();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new m();
                        aVar.a(obj[mG]);
                        this.prZ = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ao() {
            this.name = SQLiteDatabase.KeyEmpty;
            this.prH = com.google.a.a.g.aGG;
            this.bdW = 0;
            this.prI = 0;
            this.prJ = com.google.a.a.g.aGG;
            this.prK = com.google.a.a.g.aGG;
            this.prL = com.google.a.a.g.aGG;
            this.prM = null;
            this.prN = com.google.a.a.g.aGG;
            this.prO = SQLiteDatabase.KeyEmpty;
            this.prP = SQLiteDatabase.KeyEmpty;
            this.prQ = 0;
            this.prR = com.google.a.a.g.aGG;
            this.prS = com.google.a.a.g.aGG;
            this.prT = com.google.a.a.g.aGG;
            this.prU = com.google.a.a.g.aGG;
            this.prV = 0;
            this.prW = com.google.a.a.g.aGG;
            this.prX = com.google.a.a.g.aGG;
            this.aKC = com.google.a.a.g.aGG;
            this.prY = 0;
            this.prZ = m.bLY();
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.name.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.name);
            }
            if (!Arrays.equals(this.prH, com.google.a.a.g.aGG)) {
                bVar.a(2, this.prH);
            }
            if (this.bdW != 0) {
                bVar.aj(3, this.bdW);
            }
            if (this.prI != 0) {
                bVar.e(4, this.prI);
            }
            if (!Arrays.equals(this.prJ, com.google.a.a.g.aGG)) {
                bVar.a(5, this.prJ);
            }
            if (!Arrays.equals(this.prK, com.google.a.a.g.aGG)) {
                bVar.a(6, this.prK);
            }
            if (!Arrays.equals(this.prL, com.google.a.a.g.aGG)) {
                bVar.a(7, this.prL);
            }
            if (this.prM != null) {
                bVar.a(8, this.prM);
            }
            if (!Arrays.equals(this.prN, com.google.a.a.g.aGG)) {
                bVar.a(9, this.prN);
            }
            if (!this.prO.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(100, this.prO);
            }
            if (!this.prP.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e((int) MMGIFException.D_GIF_ERR_OPEN_FAILED, this.prP);
            }
            if (this.prQ != 0) {
                bVar.e(200, this.prQ);
            }
            if (!Arrays.equals(this.prR, com.google.a.a.g.aGG)) {
                bVar.a(201, this.prR);
            }
            if (!Arrays.equals(this.prS, com.google.a.a.g.aGG)) {
                bVar.a(202, this.prS);
            }
            if (!Arrays.equals(this.prT, com.google.a.a.g.aGG)) {
                bVar.a(203, this.prT);
            }
            if (!Arrays.equals(this.prU, com.google.a.a.g.aGG)) {
                bVar.a(204, this.prU);
            }
            if (this.prV != 0) {
                bVar.aj(220, this.prV);
            }
            if (!Arrays.equals(this.prW, com.google.a.a.g.aGG)) {
                bVar.a(221, this.prW);
            }
            if (!Arrays.equals(this.prX, com.google.a.a.g.aGG)) {
                bVar.a(222, this.prX);
            }
            if (!Arrays.equals(this.aKC, com.google.a.a.g.aGG)) {
                bVar.a(223, this.aKC);
            }
            if (this.prY != 0) {
                bVar.ak(224, this.prY);
            }
            if (this.prZ != null && this.prZ.length > 0) {
                for (com.google.a.a.e eVar : this.prZ) {
                    if (eVar != null) {
                        bVar.a(225, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.name.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.name);
            }
            if (!Arrays.equals(this.prH, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(2, this.prH);
            }
            if (this.bdW != 0) {
                mU += com.google.a.a.b.al(3, this.bdW);
            }
            if (this.prI != 0) {
                mU += com.google.a.a.b.g(4, this.prI);
            }
            if (!Arrays.equals(this.prJ, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(5, this.prJ);
            }
            if (!Arrays.equals(this.prK, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(6, this.prK);
            }
            if (!Arrays.equals(this.prL, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(7, this.prL);
            }
            if (this.prM != null) {
                mU += com.google.a.a.b.b(8, this.prM);
            }
            if (!Arrays.equals(this.prN, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(9, this.prN);
            }
            if (!this.prO.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(100, this.prO);
            }
            if (!this.prP.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f((int) MMGIFException.D_GIF_ERR_OPEN_FAILED, this.prP);
            }
            if (this.prQ != 0) {
                mU += com.google.a.a.b.g(200, this.prQ);
            }
            if (!Arrays.equals(this.prR, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(201, this.prR);
            }
            if (!Arrays.equals(this.prS, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(202, this.prS);
            }
            if (!Arrays.equals(this.prT, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(203, this.prT);
            }
            if (!Arrays.equals(this.prU, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(204, this.prU);
            }
            if (this.prV != 0) {
                mU += com.google.a.a.b.al(220, this.prV);
            }
            if (!Arrays.equals(this.prW, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(221, this.prW);
            }
            if (!Arrays.equals(this.prX, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(222, this.prX);
            }
            if (!Arrays.equals(this.aKC, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(223, this.aKC);
            }
            if (this.prY != 0) {
                mU += com.google.a.a.b.am(224, this.prY);
            }
            if (this.prZ == null || this.prZ.length <= 0) {
                return mU;
            }
            int i = mU;
            for (com.google.a.a.e eVar : this.prZ) {
                if (eVar != null) {
                    i += com.google.a.a.b.b(225, eVar);
                }
            }
            return i;
        }
    }

    public static final class ap extends com.google.a.a.e {
        private static volatile ap[] psa;
        public int kty;
        public long ktz;
        public String lEs;
        public int ppV;
        public aq[] pre;
        public String psb;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case 34:
                        int b = com.google.a.a.g.b(aVar, 34);
                        mG = this.pre == null ? 0 : this.pre.length;
                        Object obj = new aq[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pre, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new aq();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new aq();
                        aVar.a(obj[mG]);
                        this.pre = obj;
                        continue;
                    case 40:
                        this.ppV = aVar.mH();
                        continue;
                    case 50:
                        this.psb = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static ap[] bMd() {
            if (psa == null) {
                synchronized (com.google.a.a.c.aGy) {
                    if (psa == null) {
                        psa = new ap[0];
                    }
                }
            }
            return psa;
        }

        public ap() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.pre = aq.bMe();
            this.ppV = 0;
            this.psb = SQLiteDatabase.KeyEmpty;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.pre != null && this.pre.length > 0) {
                for (com.google.a.a.e eVar : this.pre) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.ppV != 0) {
                bVar.ak(5, this.ppV);
            }
            if (!this.psb.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(6, this.psb);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.pre != null && this.pre.length > 0) {
                int i = mU;
                for (com.google.a.a.e eVar : this.pre) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                mU = i;
            }
            if (this.ppV != 0) {
                mU += com.google.a.a.b.am(5, this.ppV);
            }
            if (this.psb.equals(SQLiteDatabase.KeyEmpty)) {
                return mU;
            }
            return mU + com.google.a.a.b.f(6, this.psb);
        }
    }

    public static final class aq extends com.google.a.a.e {
        private static volatile aq[] psc;
        public int bhB;
        public int gGl;
        public int kDL;
        public int lYf;
        public int pqb;
        public byte[] pqg;
        public String prp;
        public int psd;
        public int pse;
        public al psf;
        public int psg;
        public String psh;
        public am[] psi;
        public int psj;
        public int[] psk;
        public int psl;
        public int psm;
        public int psn;
        public int pso;
        public ak psp;
        public String psq;
        public int psr;
        public q pss;
        public int pst;
        public String psu;
        public int psv;
        public int psw;
        public int psx;
        public int psy;
        public int status;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                int b;
                Object obj;
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.lYf = aVar.mH();
                        continue;
                    case 16:
                        this.psd = aVar.mH();
                        continue;
                    case 24:
                        this.status = aVar.mH();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.bhB = aVar.mH();
                        continue;
                    case 40:
                        this.gGl = aVar.mH();
                        continue;
                    case 48:
                        this.pse = aVar.mH();
                        continue;
                    case 58:
                        if (this.psf == null) {
                            this.psf = new al();
                        }
                        aVar.a(this.psf);
                        continue;
                    case FileUtils.S_IXUSR /*64*/:
                        this.psg = aVar.mH();
                        continue;
                    case 74:
                        this.psh = aVar.readString();
                        continue;
                    case 82:
                        b = com.google.a.a.g.b(aVar, 82);
                        mG = this.psi == null ? 0 : this.psi.length;
                        obj = new am[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.psi, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new am();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new am();
                        aVar.a(obj[mG]);
                        this.psi = obj;
                        continue;
                    case 88:
                        this.psj = aVar.mH();
                        continue;
                    case 96:
                        b = com.google.a.a.g.b(aVar, 96);
                        mG = this.psk == null ? 0 : this.psk.length;
                        obj = new int[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.psk, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.mH();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.mH();
                        this.psk = obj;
                        continue;
                    case 98:
                        int cp = aVar.cp(aVar.mH());
                        b = aVar.getPosition();
                        mG = 0;
                        while (aVar.mK() > 0) {
                            aVar.mH();
                            mG++;
                        }
                        aVar.cr(b);
                        b = this.psk == null ? 0 : this.psk.length;
                        Object obj2 = new int[(mG + b)];
                        if (b != 0) {
                            System.arraycopy(this.psk, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mH();
                            b++;
                        }
                        this.psk = obj2;
                        aVar.cq(cp);
                        continue;
                    case MMGIFException.D_GIF_ERR_NO_SCRN_DSCR /*104*/:
                        this.psl = aVar.mH();
                        continue;
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                        this.psm = aVar.mH();
                        continue;
                    case 120:
                        this.psn = aVar.mH();
                        continue;
                    case FileUtils.S_IWUSR /*128*/:
                        this.pso = aVar.mH();
                        continue;
                    case 138:
                        if (this.psp == null) {
                            this.psp = new ak();
                        }
                        aVar.a(this.psp);
                        continue;
                    case 802:
                        this.prp = aVar.readString();
                        continue;
                    case 810:
                        this.psq = aVar.readString();
                        continue;
                    case 816:
                        this.psr = aVar.mH();
                        continue;
                    case 1602:
                        this.pqg = aVar.readBytes();
                        continue;
                    case 1610:
                        if (this.pss == null) {
                            this.pss = new q();
                        }
                        aVar.a(this.pss);
                        continue;
                    case 1616:
                        this.pst = aVar.mH();
                        continue;
                    case 1626:
                        this.psu = aVar.readString();
                        continue;
                    case 1632:
                        this.psv = aVar.mH();
                        continue;
                    case 1640:
                        this.psw = aVar.mH();
                        continue;
                    case 1648:
                        this.kDL = aVar.mH();
                        continue;
                    case 1656:
                        this.psx = aVar.mH();
                        continue;
                    case 1664:
                        this.psy = aVar.mH();
                        continue;
                    case 1920:
                        this.pqb = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static aq[] bMe() {
            if (psc == null) {
                synchronized (com.google.a.a.c.aGy) {
                    if (psc == null) {
                        psc = new aq[0];
                    }
                }
            }
            return psc;
        }

        public aq() {
            this.lYf = 0;
            this.psd = 0;
            this.status = 0;
            this.bhB = 0;
            this.gGl = -1;
            this.pse = 0;
            this.psf = null;
            this.psg = 0;
            this.psh = SQLiteDatabase.KeyEmpty;
            this.psi = am.bMc();
            this.psj = 0;
            this.psk = com.google.a.a.g.aGA;
            this.psl = 0;
            this.psm = 0;
            this.psn = 0;
            this.pso = 0;
            this.psp = null;
            this.prp = SQLiteDatabase.KeyEmpty;
            this.psq = SQLiteDatabase.KeyEmpty;
            this.psr = 0;
            this.pqg = com.google.a.a.g.aGG;
            this.pss = null;
            this.pst = -1;
            this.psu = SQLiteDatabase.KeyEmpty;
            this.psv = 0;
            this.psw = 0;
            this.kDL = 0;
            this.psx = 0;
            this.psy = 0;
            this.pqb = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.lYf != 0) {
                bVar.ak(1, this.lYf);
            }
            if (this.psd != 0) {
                bVar.ak(2, this.psd);
            }
            if (this.status != 0) {
                bVar.ak(3, this.status);
            }
            if (this.bhB != 0) {
                bVar.ak(4, this.bhB);
            }
            if (this.gGl != -1) {
                bVar.aj(5, this.gGl);
            }
            if (this.pse != 0) {
                bVar.ak(6, this.pse);
            }
            if (this.psf != null) {
                bVar.a(7, this.psf);
            }
            if (this.psg != 0) {
                bVar.ak(8, this.psg);
            }
            if (!this.psh.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(9, this.psh);
            }
            if (this.psi != null && this.psi.length > 0) {
                for (com.google.a.a.e eVar : this.psi) {
                    if (eVar != null) {
                        bVar.a(10, eVar);
                    }
                }
            }
            if (this.psj != 0) {
                bVar.ak(11, this.psj);
            }
            if (this.psk != null && this.psk.length > 0) {
                while (i < this.psk.length) {
                    bVar.ak(12, this.psk[i]);
                    i++;
                }
            }
            if (this.psl != 0) {
                bVar.ak(13, this.psl);
            }
            if (this.psm != 0) {
                bVar.ak(14, this.psm);
            }
            if (this.psn != 0) {
                bVar.ak(15, this.psn);
            }
            if (this.pso != 0) {
                bVar.ak(16, this.pso);
            }
            if (this.psp != null) {
                bVar.a(17, this.psp);
            }
            if (!this.prp.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(100, this.prp);
            }
            if (!this.psq.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e((int) MMGIFException.D_GIF_ERR_OPEN_FAILED, this.psq);
            }
            if (this.psr != 0) {
                bVar.ak(MMGIFException.D_GIF_ERR_READ_FAILED, this.psr);
            }
            if (!Arrays.equals(this.pqg, com.google.a.a.g.aGG)) {
                bVar.a(200, this.pqg);
            }
            if (this.pss != null) {
                bVar.a(201, this.pss);
            }
            if (this.pst != -1) {
                bVar.aj(202, this.pst);
            }
            if (!this.psu.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(203, this.psu);
            }
            if (this.psv != 0) {
                bVar.aj(204, this.psv);
            }
            if (this.psw != 0) {
                bVar.ak(205, this.psw);
            }
            if (this.kDL != 0) {
                bVar.ak(206, this.kDL);
            }
            if (this.psx != 0) {
                bVar.ak(207, this.psx);
            }
            if (this.psy != 0) {
                bVar.ak(208, this.psy);
            }
            if (this.pqb != 0) {
                bVar.ak(240, this.pqb);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int i;
            int i2 = 0;
            int mU = super.mU();
            if (this.lYf != 0) {
                mU += com.google.a.a.b.am(1, this.lYf);
            }
            if (this.psd != 0) {
                mU += com.google.a.a.b.am(2, this.psd);
            }
            if (this.status != 0) {
                mU += com.google.a.a.b.am(3, this.status);
            }
            if (this.bhB != 0) {
                mU += com.google.a.a.b.am(4, this.bhB);
            }
            if (this.gGl != -1) {
                mU += com.google.a.a.b.al(5, this.gGl);
            }
            if (this.pse != 0) {
                mU += com.google.a.a.b.am(6, this.pse);
            }
            if (this.psf != null) {
                mU += com.google.a.a.b.b(7, this.psf);
            }
            if (this.psg != 0) {
                mU += com.google.a.a.b.am(8, this.psg);
            }
            if (!this.psh.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(9, this.psh);
            }
            if (this.psi != null && this.psi.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar : this.psi) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(10, eVar);
                    }
                }
                mU = i;
            }
            if (this.psj != 0) {
                mU += com.google.a.a.b.am(11, this.psj);
            }
            if (this.psk != null && this.psk.length > 0) {
                i = 0;
                while (i2 < this.psk.length) {
                    i += com.google.a.a.b.cy(this.psk[i2]);
                    i2++;
                }
                mU = (mU + i) + (this.psk.length * 1);
            }
            if (this.psl != 0) {
                mU += com.google.a.a.b.am(13, this.psl);
            }
            if (this.psm != 0) {
                mU += com.google.a.a.b.am(14, this.psm);
            }
            if (this.psn != 0) {
                mU += com.google.a.a.b.am(15, this.psn);
            }
            if (this.pso != 0) {
                mU += com.google.a.a.b.am(16, this.pso);
            }
            if (this.psp != null) {
                mU += com.google.a.a.b.b(17, this.psp);
            }
            if (!this.prp.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(100, this.prp);
            }
            if (!this.psq.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f((int) MMGIFException.D_GIF_ERR_OPEN_FAILED, this.psq);
            }
            if (this.psr != 0) {
                mU += com.google.a.a.b.am(MMGIFException.D_GIF_ERR_READ_FAILED, this.psr);
            }
            if (!Arrays.equals(this.pqg, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(200, this.pqg);
            }
            if (this.pss != null) {
                mU += com.google.a.a.b.b(201, this.pss);
            }
            if (this.pst != -1) {
                mU += com.google.a.a.b.al(202, this.pst);
            }
            if (!this.psu.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(203, this.psu);
            }
            if (this.psv != 0) {
                mU += com.google.a.a.b.al(204, this.psv);
            }
            if (this.psw != 0) {
                mU += com.google.a.a.b.am(205, this.psw);
            }
            if (this.kDL != 0) {
                mU += com.google.a.a.b.am(206, this.kDL);
            }
            if (this.psx != 0) {
                mU += com.google.a.a.b.am(207, this.psx);
            }
            if (this.psy != 0) {
                mU += com.google.a.a.b.am(208, this.psy);
            }
            if (this.pqb != 0) {
                return mU + com.google.a.a.b.am(240, this.pqb);
            }
            return mU;
        }
    }

    public static final class ar extends com.google.a.a.e {
        private static volatile ar[] psz;
        public String inG;
        public int lYf;
        public long psA;
        public String username;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.lYf = aVar.mH();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.username = aVar.readString();
                        continue;
                    case android.support.v7.a.a.k.Kr /*26*/:
                        this.inG = aVar.readString();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.psA = aVar.mI();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static ar[] bMf() {
            if (psz == null) {
                synchronized (com.google.a.a.c.aGy) {
                    if (psz == null) {
                        psz = new ar[0];
                    }
                }
            }
            return psz;
        }

        public ar() {
            this.lYf = 0;
            this.username = SQLiteDatabase.KeyEmpty;
            this.inG = SQLiteDatabase.KeyEmpty;
            this.psA = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.lYf != 0) {
                bVar.ak(1, this.lYf);
            }
            if (!this.username.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(2, this.username);
            }
            if (!this.inG.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(3, this.inG);
            }
            if (this.psA != 0) {
                bVar.e(4, this.psA);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.lYf != 0) {
                mU += com.google.a.a.b.am(1, this.lYf);
            }
            if (!this.username.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(2, this.username);
            }
            if (!this.inG.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(3, this.inG);
            }
            if (this.psA != 0) {
                return mU + com.google.a.a.b.g(4, this.psA);
            }
            return mU;
        }
    }

    public static final class as extends com.google.a.a.e {
        public int psB;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.psB = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public as() {
            this.psB = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.psB != 0) {
                bVar.ak(1, this.psB);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.psB != 0) {
                return mU + com.google.a.a.b.am(1, this.psB);
            }
            return mU;
        }
    }

    public static final class at extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public int psC;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.kty = aVar.mH();
                        continue;
                    case 16:
                        this.ktz = aVar.mI();
                        continue;
                    case 24:
                        this.psC = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public at() {
            this.kty = 0;
            this.ktz = 0;
            this.psC = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.kty != 0) {
                bVar.aj(1, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(2, this.ktz);
            }
            if (this.psC != 0) {
                bVar.ak(3, this.psC);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(1, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(2, this.ktz);
            }
            if (this.psC != 0) {
                return mU + com.google.a.a.b.am(3, this.psC);
            }
            return mU;
        }
    }

    public static final class au extends com.google.a.a.e {
        private static volatile au[] psD;
        public int eWB;
        public int psE;
        public int psF;
        public int psG;
        public int psH;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.eWB = aVar.mH();
                        continue;
                    case 16:
                        this.psE = aVar.mH();
                        continue;
                    case 24:
                        this.psF = aVar.mH();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.psG = aVar.mH();
                        continue;
                    case 40:
                        this.psH = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static au[] bMg() {
            if (psD == null) {
                synchronized (com.google.a.a.c.aGy) {
                    if (psD == null) {
                        psD = new au[0];
                    }
                }
            }
            return psD;
        }

        public au() {
            this.eWB = 0;
            this.psE = 0;
            this.psF = 0;
            this.psG = 0;
            this.psH = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.eWB != 0) {
                bVar.aj(1, this.eWB);
            }
            if (this.psE != 0) {
                bVar.aj(2, this.psE);
            }
            if (this.psF != 0) {
                bVar.aj(3, this.psF);
            }
            if (this.psG != 0) {
                bVar.aj(4, this.psG);
            }
            if (this.psH != 0) {
                bVar.aj(5, this.psH);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.eWB != 0) {
                mU += com.google.a.a.b.al(1, this.eWB);
            }
            if (this.psE != 0) {
                mU += com.google.a.a.b.al(2, this.psE);
            }
            if (this.psF != 0) {
                mU += com.google.a.a.b.al(3, this.psF);
            }
            if (this.psG != 0) {
                mU += com.google.a.a.b.al(4, this.psG);
            }
            if (this.psH != 0) {
                return mU + com.google.a.a.b.al(5, this.psH);
            }
            return mU;
        }
    }

    public static final class av extends com.google.a.a.e {
        public ai psI;
        public int type;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.type = aVar.mH();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        if (this.psI == null) {
                            this.psI = new ai();
                        }
                        aVar.a(this.psI);
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public av() {
            this.type = 0;
            this.psI = null;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.type != 0) {
                bVar.aj(1, this.type);
            }
            if (this.psI != null) {
                bVar.a(2, this.psI);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.type != 0) {
                mU += com.google.a.a.b.al(1, this.type);
            }
            if (this.psI != null) {
                return mU + com.google.a.a.b.b(2, this.psI);
            }
            return mU;
        }
    }

    public static final class aw extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;
        public int ppV;
        public aq[] pre;
        public int psJ;
        public String psK;
        public String[] psL;
        public long psM;
        public String psb;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                int b;
                Object obj;
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.ppV = aVar.mH();
                        continue;
                    case 40:
                        this.psJ = aVar.mH();
                        continue;
                    case 50:
                        this.psb = aVar.readString();
                        continue;
                    case 58:
                        b = com.google.a.a.g.b(aVar, 58);
                        mG = this.pre == null ? 0 : this.pre.length;
                        obj = new aq[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pre, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new aq();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new aq();
                        aVar.a(obj[mG]);
                        this.pre = obj;
                        continue;
                    case 66:
                        this.psK = aVar.readString();
                        continue;
                    case 74:
                        b = com.google.a.a.g.b(aVar, 74);
                        mG = this.psL == null ? 0 : this.psL.length;
                        obj = new String[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.psL, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.readString();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.readString();
                        this.psL = obj;
                        continue;
                    case 80:
                        this.psM = aVar.mI();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public aw() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.ppV = 0;
            this.psJ = 0;
            this.psb = SQLiteDatabase.KeyEmpty;
            this.pre = aq.bMe();
            this.psK = SQLiteDatabase.KeyEmpty;
            this.psL = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.psM = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.ppV != 0) {
                bVar.ak(4, this.ppV);
            }
            if (this.psJ != 0) {
                bVar.aj(5, this.psJ);
            }
            if (!this.psb.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(6, this.psb);
            }
            if (this.pre != null && this.pre.length > 0) {
                for (com.google.a.a.e eVar : this.pre) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (!this.psK.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(8, this.psK);
            }
            if (this.psL != null && this.psL.length > 0) {
                while (i < this.psL.length) {
                    String str = this.psL[i];
                    if (str != null) {
                        bVar.e(9, str);
                    }
                    i++;
                }
            }
            if (this.psM != 0) {
                bVar.e(10, this.psM);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int i;
            int i2 = 0;
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.ppV != 0) {
                mU += com.google.a.a.b.am(4, this.ppV);
            }
            if (this.psJ != 0) {
                mU += com.google.a.a.b.al(5, this.psJ);
            }
            if (!this.psb.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(6, this.psb);
            }
            if (this.pre != null && this.pre.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar : this.pre) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(7, eVar);
                    }
                }
                mU = i;
            }
            if (!this.psK.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(8, this.psK);
            }
            if (this.psL != null && this.psL.length > 0) {
                i = 0;
                int i3 = 0;
                while (i2 < this.psL.length) {
                    String str = this.psL[i2];
                    if (str != null) {
                        i3++;
                        i += com.google.a.a.b.au(str);
                    }
                    i2++;
                }
                mU = (mU + i) + (i3 * 1);
            }
            if (this.psM != 0) {
                return mU + com.google.a.a.b.g(10, this.psM);
            }
            return mU;
        }
    }

    public static final class b extends com.google.a.a.e {
        public int bhB;
        public String ppQ;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.ppQ = aVar.readString();
                        continue;
                    case 16:
                        this.bhB = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public b() {
            this.ppQ = SQLiteDatabase.KeyEmpty;
            this.bhB = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.ppQ);
            }
            if (this.bhB != 0) {
                bVar.aj(2, this.bhB);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.ppQ);
            }
            if (this.bhB != 0) {
                return mU + com.google.a.a.b.al(2, this.bhB);
            }
            return mU;
        }
    }

    public static final class c extends com.google.a.a.e {
        public u[] ppR;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        int b = com.google.a.a.g.b(aVar, 10);
                        mG = this.ppR == null ? 0 : this.ppR.length;
                        Object obj = new u[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.ppR, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new u();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new u();
                        aVar.a(obj[mG]);
                        this.ppR = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public c() {
            this.ppR = u.bMa();
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.ppR != null && this.ppR.length > 0) {
                for (com.google.a.a.e eVar : this.ppR) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.ppR != null && this.ppR.length > 0) {
                for (com.google.a.a.e eVar : this.ppR) {
                    if (eVar != null) {
                        mU += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return mU;
        }
    }

    public static final class d extends com.google.a.a.e {
        public String ppQ;
        public ao ppS;
        public int[] ppT;
        public av ppU;
        public int ppV;
        public int ppW;
        public at ppX;
        public String ppY;
        public String[] ppZ;
        public l[] pqa;
        public int pqb;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                int b;
                Object obj;
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        if (this.ppS == null) {
                            this.ppS = new ao();
                        }
                        aVar.a(this.ppS);
                        continue;
                    case 16:
                        b = com.google.a.a.g.b(aVar, 16);
                        mG = this.ppT == null ? 0 : this.ppT.length;
                        obj = new int[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.ppT, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.mH();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.mH();
                        this.ppT = obj;
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        int cp = aVar.cp(aVar.mH());
                        b = aVar.getPosition();
                        mG = 0;
                        while (aVar.mK() > 0) {
                            aVar.mH();
                            mG++;
                        }
                        aVar.cr(b);
                        b = this.ppT == null ? 0 : this.ppT.length;
                        Object obj2 = new int[(mG + b)];
                        if (b != 0) {
                            System.arraycopy(this.ppT, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mH();
                            b++;
                        }
                        this.ppT = obj2;
                        aVar.cq(cp);
                        continue;
                    case android.support.v7.a.a.k.Kr /*26*/:
                        if (this.ppU == null) {
                            this.ppU = new av();
                        }
                        aVar.a(this.ppU);
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.ppV = aVar.mH();
                        continue;
                    case 40:
                        this.ppW = aVar.mH();
                        continue;
                    case 50:
                        if (this.ppX == null) {
                            this.ppX = new at();
                        }
                        aVar.a(this.ppX);
                        continue;
                    case 58:
                        this.ppQ = aVar.readString();
                        continue;
                    case 66:
                        this.ppY = aVar.readString();
                        continue;
                    case 802:
                        b = com.google.a.a.g.b(aVar, 802);
                        mG = this.ppZ == null ? 0 : this.ppZ.length;
                        obj = new String[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.ppZ, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.readString();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.readString();
                        this.ppZ = obj;
                        continue;
                    case 1618:
                        b = com.google.a.a.g.b(aVar, 1618);
                        mG = this.pqa == null ? 0 : this.pqa.length;
                        obj = new l[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pqa, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new l();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new l();
                        aVar.a(obj[mG]);
                        this.pqa = obj;
                        continue;
                    case 1920:
                        this.pqb = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public d() {
            this.ppS = null;
            this.ppT = com.google.a.a.g.aGA;
            this.ppU = null;
            this.ppV = 0;
            this.ppW = 0;
            this.ppX = null;
            this.ppQ = SQLiteDatabase.KeyEmpty;
            this.ppY = SQLiteDatabase.KeyEmpty;
            this.ppZ = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.pqa = l.bLX();
            this.pqb = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.ppS != null) {
                bVar.a(1, this.ppS);
            }
            if (this.ppT != null && this.ppT.length > 0) {
                for (int ak : this.ppT) {
                    bVar.ak(2, ak);
                }
            }
            if (this.ppU != null) {
                bVar.a(3, this.ppU);
            }
            if (this.ppV != 0) {
                bVar.ak(4, this.ppV);
            }
            if (this.ppW != 0) {
                bVar.ak(5, this.ppW);
            }
            if (this.ppX != null) {
                bVar.a(6, this.ppX);
            }
            if (!this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(7, this.ppQ);
            }
            if (!this.ppY.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(8, this.ppY);
            }
            if (this.ppZ != null && this.ppZ.length > 0) {
                for (String str : this.ppZ) {
                    if (str != null) {
                        bVar.e(100, str);
                    }
                }
            }
            if (this.pqa != null && this.pqa.length > 0) {
                while (i < this.pqa.length) {
                    com.google.a.a.e eVar = this.pqa[i];
                    if (eVar != null) {
                        bVar.a(202, eVar);
                    }
                    i++;
                }
            }
            if (this.pqb != 0) {
                bVar.ak(240, this.pqb);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int i;
            int i2;
            int i3 = 0;
            int mU = super.mU();
            if (this.ppS != null) {
                mU += com.google.a.a.b.b(1, this.ppS);
            }
            if (this.ppT != null && this.ppT.length > 0) {
                i = 0;
                for (int i22 : this.ppT) {
                    i += com.google.a.a.b.cy(i22);
                }
                mU = (mU + i) + (this.ppT.length * 1);
            }
            if (this.ppU != null) {
                mU += com.google.a.a.b.b(3, this.ppU);
            }
            if (this.ppV != 0) {
                mU += com.google.a.a.b.am(4, this.ppV);
            }
            if (this.ppW != 0) {
                mU += com.google.a.a.b.am(5, this.ppW);
            }
            if (this.ppX != null) {
                mU += com.google.a.a.b.b(6, this.ppX);
            }
            if (!this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(7, this.ppQ);
            }
            if (!this.ppY.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(8, this.ppY);
            }
            if (this.ppZ != null && this.ppZ.length > 0) {
                i = 0;
                i22 = 0;
                for (String str : this.ppZ) {
                    if (str != null) {
                        i22++;
                        i += com.google.a.a.b.au(str);
                    }
                }
                mU = (mU + i) + (i22 * 2);
            }
            if (this.pqa != null && this.pqa.length > 0) {
                while (i3 < this.pqa.length) {
                    com.google.a.a.e eVar = this.pqa[i3];
                    if (eVar != null) {
                        mU += com.google.a.a.b.b(202, eVar);
                    }
                    i3++;
                }
            }
            if (this.pqb != 0) {
                return mU + com.google.a.a.b.am(240, this.pqb);
            }
            return mU;
        }
    }

    public static final class e extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;
        public ao ppS;
        public av ppU;
        public int ppW;
        public String[] ppZ;
        public l[] pqa;
        public int pqb;
        public int pqc;
        public q pqd;
        public int pqe;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                int b;
                Object obj;
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case 34:
                        if (this.ppU == null) {
                            this.ppU = new av();
                        }
                        aVar.a(this.ppU);
                        continue;
                    case 40:
                        this.pqc = aVar.mH();
                        continue;
                    case 48:
                        this.ppW = aVar.mH();
                        continue;
                    case 1602:
                        if (this.ppS == null) {
                            this.ppS = new ao();
                        }
                        aVar.a(this.ppS);
                        continue;
                    case 1610:
                        b = com.google.a.a.g.b(aVar, 1610);
                        mG = this.ppZ == null ? 0 : this.ppZ.length;
                        obj = new String[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.ppZ, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.readString();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.readString();
                        this.ppZ = obj;
                        continue;
                    case 1618:
                        b = com.google.a.a.g.b(aVar, 1618);
                        mG = this.pqa == null ? 0 : this.pqa.length;
                        obj = new l[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pqa, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new l();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new l();
                        aVar.a(obj[mG]);
                        this.pqa = obj;
                        continue;
                    case 1626:
                        if (this.pqd == null) {
                            this.pqd = new q();
                        }
                        aVar.a(this.pqd);
                        continue;
                    case 1632:
                        this.pqe = aVar.mH();
                        continue;
                    case 1920:
                        this.pqb = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public e() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.ppU = null;
            this.pqc = 0;
            this.ppW = 0;
            this.ppS = null;
            this.ppZ = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.pqa = l.bLX();
            this.pqd = null;
            this.pqe = 0;
            this.pqb = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.ppU != null) {
                bVar.a(4, this.ppU);
            }
            if (this.pqc != 0) {
                bVar.aj(5, this.pqc);
            }
            if (this.ppW != 0) {
                bVar.ak(6, this.ppW);
            }
            if (this.ppS != null) {
                bVar.a(200, this.ppS);
            }
            if (this.ppZ != null && this.ppZ.length > 0) {
                for (String str : this.ppZ) {
                    if (str != null) {
                        bVar.e(201, str);
                    }
                }
            }
            if (this.pqa != null && this.pqa.length > 0) {
                while (i < this.pqa.length) {
                    com.google.a.a.e eVar = this.pqa[i];
                    if (eVar != null) {
                        bVar.a(202, eVar);
                    }
                    i++;
                }
            }
            if (this.pqd != null) {
                bVar.a(203, this.pqd);
            }
            if (this.pqe != 0) {
                bVar.ak(204, this.pqe);
            }
            if (this.pqb != 0) {
                bVar.ak(240, this.pqb);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int i = 0;
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.ppU != null) {
                mU += com.google.a.a.b.b(4, this.ppU);
            }
            if (this.pqc != 0) {
                mU += com.google.a.a.b.al(5, this.pqc);
            }
            if (this.ppW != 0) {
                mU += com.google.a.a.b.am(6, this.ppW);
            }
            if (this.ppS != null) {
                mU += com.google.a.a.b.b(200, this.ppS);
            }
            if (this.ppZ != null && this.ppZ.length > 0) {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.ppZ) {
                    if (str != null) {
                        i3++;
                        i2 += com.google.a.a.b.au(str);
                    }
                }
                mU = (mU + i2) + (i3 * 2);
            }
            if (this.pqa != null && this.pqa.length > 0) {
                while (i < this.pqa.length) {
                    com.google.a.a.e eVar = this.pqa[i];
                    if (eVar != null) {
                        mU += com.google.a.a.b.b(202, eVar);
                    }
                    i++;
                }
            }
            if (this.pqd != null) {
                mU += com.google.a.a.b.b(203, this.pqd);
            }
            if (this.pqe != 0) {
                mU += com.google.a.a.b.am(204, this.pqe);
            }
            if (this.pqb != 0) {
                return mU + com.google.a.a.b.am(240, this.pqb);
            }
            return mU;
        }
    }

    public static final class f extends com.google.a.a.e {
        public int bhB;
        public int kty;
        public long ktz;
        public String lEs;
        public int pqf;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.bhB = aVar.mH();
                        continue;
                    case 40:
                        this.pqf = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public f() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.bhB = 0;
            this.pqf = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.bhB != 0) {
                bVar.aj(4, this.bhB);
            }
            if (this.pqf != 0) {
                bVar.aj(5, this.pqf);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.bhB != 0) {
                mU += com.google.a.a.b.al(4, this.bhB);
            }
            if (this.pqf != 0) {
                return mU + com.google.a.a.b.al(5, this.pqf);
            }
            return mU;
        }
    }

    public static final class g extends com.google.a.a.e {
        public int bhB;
        public int kty;
        public long ktz;
        public String lEs;
        public String ppQ;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.bhB = aVar.mH();
                        continue;
                    case 42:
                        this.ppQ = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public g() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.bhB = 0;
            this.ppQ = SQLiteDatabase.KeyEmpty;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.bhB != 0) {
                bVar.aj(4, this.bhB);
            }
            if (!this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(5, this.ppQ);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.bhB != 0) {
                mU += com.google.a.a.b.al(4, this.bhB);
            }
            if (this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                return mU;
            }
            return mU + com.google.a.a.b.f(5, this.ppQ);
        }
    }

    public static final class h extends com.google.a.a.e {
        public int action;
        public int gFG;
        public long gFH;
        public String lEs;

        public h() {
            this.action = 0;
            this.gFG = 0;
            this.gFH = 0;
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.aGz = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.action = aVar.mH();
                        continue;
                    case 16:
                        this.gFG = aVar.mH();
                        continue;
                    case 24:
                        this.gFH = aVar.mI();
                        continue;
                    case 34:
                        this.lEs = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(com.google.a.a.b bVar) {
            bVar.ak(1, this.action);
            bVar.aj(2, this.gFG);
            bVar.f(3, this.gFH);
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(4, this.lEs);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = ((super.mU() + com.google.a.a.b.am(1, this.action)) + com.google.a.a.b.al(2, this.gFG)) + com.google.a.a.b.h(3, this.gFH);
            return !this.lEs.equals(SQLiteDatabase.KeyEmpty) ? mU + com.google.a.a.b.f(4, this.lEs) : mU;
        }
    }

    public static final class i extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;
        public av ppU;
        public int ppW;
        public byte[] pqg;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case 34:
                        if (this.ppU == null) {
                            this.ppU = new av();
                        }
                        aVar.a(this.ppU);
                        continue;
                    case 40:
                        this.ppW = aVar.mH();
                        continue;
                    case 1602:
                        this.pqg = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public i() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.ppU = null;
            this.ppW = 0;
            this.pqg = com.google.a.a.g.aGG;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.ppU != null) {
                bVar.a(4, this.ppU);
            }
            if (this.ppW != 0) {
                bVar.ak(5, this.ppW);
            }
            if (!Arrays.equals(this.pqg, com.google.a.a.g.aGG)) {
                bVar.a(200, this.pqg);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.ppU != null) {
                mU += com.google.a.a.b.b(4, this.ppU);
            }
            if (this.ppW != 0) {
                mU += com.google.a.a.b.am(5, this.ppW);
            }
            if (Arrays.equals(this.pqg, com.google.a.a.g.aGG)) {
                return mU;
            }
            return mU + com.google.a.a.b.b(200, this.pqg);
        }
    }

    public static final class j extends com.google.a.a.e {
        public int gGl;
        public int kty;
        public long ktz;
        public String lEs;
        public int ppW;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.gGl = aVar.mH();
                        continue;
                    case 40:
                        this.ppW = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public j() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.gGl = -1;
            this.ppW = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.gGl != -1) {
                bVar.aj(4, this.gGl);
            }
            if (this.ppW != 0) {
                bVar.ak(5, this.ppW);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.gGl != -1) {
                mU += com.google.a.a.b.al(4, this.gGl);
            }
            if (this.ppW != 0) {
                return mU + com.google.a.a.b.am(5, this.ppW);
            }
            return mU;
        }
    }

    public static final class k extends com.google.a.a.e {
        public int gGl;
        public int kty;
        public long ktz;
        public String lEs;
        public int pqh;
        public byte[] pqi;
        public au[] pqj;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.gGl = aVar.mH();
                        continue;
                    case 40:
                        this.pqh = aVar.mH();
                        continue;
                    case 50:
                        this.pqi = aVar.readBytes();
                        continue;
                    case 58:
                        int b = com.google.a.a.g.b(aVar, 58);
                        mG = this.pqj == null ? 0 : this.pqj.length;
                        Object obj = new au[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pqj, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new au();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new au();
                        aVar.a(obj[mG]);
                        this.pqj = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public k() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.gGl = -1;
            this.pqh = 0;
            this.pqi = com.google.a.a.g.aGG;
            this.pqj = au.bMg();
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.gGl != -1) {
                bVar.aj(4, this.gGl);
            }
            if (this.pqh != 0) {
                bVar.aj(5, this.pqh);
            }
            if (!Arrays.equals(this.pqi, com.google.a.a.g.aGG)) {
                bVar.a(6, this.pqi);
            }
            if (this.pqj != null && this.pqj.length > 0) {
                for (com.google.a.a.e eVar : this.pqj) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.gGl != -1) {
                mU += com.google.a.a.b.al(4, this.gGl);
            }
            if (this.pqh != 0) {
                mU += com.google.a.a.b.al(5, this.pqh);
            }
            if (!Arrays.equals(this.pqi, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(6, this.pqi);
            }
            if (this.pqj == null || this.pqj.length <= 0) {
                return mU;
            }
            int i = mU;
            for (com.google.a.a.e eVar : this.pqj) {
                if (eVar != null) {
                    i += com.google.a.a.b.b(7, eVar);
                }
            }
            return i;
        }
    }

    public static final class l extends com.google.a.a.e {
        private static volatile l[] pqk;
        public String cID;
        public int lYf;
        public String pql;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.lYf = aVar.mH();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.cID = aVar.readString();
                        continue;
                    case android.support.v7.a.a.k.Kr /*26*/:
                        this.pql = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static l[] bLX() {
            if (pqk == null) {
                synchronized (com.google.a.a.c.aGy) {
                    if (pqk == null) {
                        pqk = new l[0];
                    }
                }
            }
            return pqk;
        }

        public l() {
            this.lYf = 0;
            this.cID = SQLiteDatabase.KeyEmpty;
            this.pql = SQLiteDatabase.KeyEmpty;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.lYf != 0) {
                bVar.ak(1, this.lYf);
            }
            if (!this.cID.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(2, this.cID);
            }
            if (!this.pql.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(3, this.pql);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.lYf != 0) {
                mU += com.google.a.a.b.am(1, this.lYf);
            }
            if (!this.cID.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(2, this.cID);
            }
            if (this.pql.equals(SQLiteDatabase.KeyEmpty)) {
                return mU;
            }
            return mU + com.google.a.a.b.f(3, this.pql);
        }
    }

    public static final class m extends com.google.a.a.e {
        private static volatile m[] pqm;
        public byte[] bgX;
        public int pqn;
        public int pqo;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.pqn = aVar.mH();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.bgX = aVar.readBytes();
                        continue;
                    case 24:
                        this.pqo = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static m[] bLY() {
            if (pqm == null) {
                synchronized (com.google.a.a.c.aGy) {
                    if (pqm == null) {
                        pqm = new m[0];
                    }
                }
            }
            return pqm;
        }

        public m() {
            this.pqn = 0;
            this.bgX = com.google.a.a.g.aGG;
            this.pqo = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.pqn != 0) {
                bVar.aj(1, this.pqn);
            }
            if (!Arrays.equals(this.bgX, com.google.a.a.g.aGG)) {
                bVar.a(2, this.bgX);
            }
            if (this.pqo != 0) {
                bVar.ak(3, this.pqo);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.pqn != 0) {
                mU += com.google.a.a.b.al(1, this.pqn);
            }
            if (!Arrays.equals(this.bgX, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(2, this.bgX);
            }
            if (this.pqo != 0) {
                return mU + com.google.a.a.b.am(3, this.pqo);
            }
            return mU;
        }
    }

    public static final class n extends com.google.a.a.e {
        private static volatile n[] pqp;
        public int port;
        public int pqq;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.pqq = aVar.mH();
                        continue;
                    case 16:
                        this.port = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static n[] bLZ() {
            if (pqp == null) {
                synchronized (com.google.a.a.c.aGy) {
                    if (pqp == null) {
                        pqp = new n[0];
                    }
                }
            }
            return pqp;
        }

        public n() {
            this.pqq = 0;
            this.port = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.pqq != 0) {
                bVar.ak(1, this.pqq);
            }
            if (this.port != 0) {
                bVar.aj(2, this.port);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.pqq != 0) {
                mU += com.google.a.a.b.am(1, this.pqq);
            }
            if (this.port != 0) {
                return mU + com.google.a.a.b.al(2, this.port);
            }
            return mU;
        }
    }

    public static final class o extends com.google.a.a.e {
        public long bao;
        public int kty;
        public long ktz;
        public String lEs;
        public ao ppS;
        public int ppV;
        public at ppX;
        public int pqr;
        public ar[] pqs;
        public aq[] pqt;
        public an pqu;
        public int pqv;
        public byte[] pqw;
        public byte[] pqx;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                int b;
                Object obj;
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.pqr = aVar.mH();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.lEs = aVar.readString();
                        continue;
                    case 24:
                        this.kty = aVar.mH();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.ktz = aVar.mI();
                        continue;
                    case 40:
                        this.ppV = aVar.mH();
                        continue;
                    case 50:
                        if (this.ppS == null) {
                            this.ppS = new ao();
                        }
                        aVar.a(this.ppS);
                        continue;
                    case 58:
                        b = com.google.a.a.g.b(aVar, 58);
                        mG = this.pqs == null ? 0 : this.pqs.length;
                        obj = new ar[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pqs, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new ar();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new ar();
                        aVar.a(obj[mG]);
                        this.pqs = obj;
                        continue;
                    case 66:
                        b = com.google.a.a.g.b(aVar, 66);
                        mG = this.pqt == null ? 0 : this.pqt.length;
                        obj = new aq[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pqt, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new aq();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new aq();
                        aVar.a(obj[mG]);
                        this.pqt = obj;
                        continue;
                    case 74:
                        if (this.pqu == null) {
                            this.pqu = new an();
                        }
                        aVar.a(this.pqu);
                        continue;
                    case 82:
                        if (this.ppX == null) {
                            this.ppX = new at();
                        }
                        aVar.a(this.ppX);
                        continue;
                    case 808:
                        this.bao = aVar.mI();
                        continue;
                    case 816:
                        this.pqv = aVar.mH();
                        continue;
                    case 826:
                        this.pqw = aVar.readBytes();
                        continue;
                    case 1602:
                        this.pqx = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public o() {
            this.pqr = 0;
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.ppV = 0;
            this.ppS = null;
            this.pqs = ar.bMf();
            this.pqt = aq.bMe();
            this.pqu = null;
            this.ppX = null;
            this.bao = 0;
            this.pqv = 0;
            this.pqw = com.google.a.a.g.aGG;
            this.pqx = com.google.a.a.g.aGG;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.pqr != 0) {
                bVar.aj(1, this.pqr);
            }
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(2, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(3, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(4, this.ktz);
            }
            if (this.ppV != 0) {
                bVar.ak(5, this.ppV);
            }
            if (this.ppS != null) {
                bVar.a(6, this.ppS);
            }
            if (this.pqs != null && this.pqs.length > 0) {
                for (com.google.a.a.e eVar : this.pqs) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (this.pqt != null && this.pqt.length > 0) {
                while (i < this.pqt.length) {
                    com.google.a.a.e eVar2 = this.pqt[i];
                    if (eVar2 != null) {
                        bVar.a(8, eVar2);
                    }
                    i++;
                }
            }
            if (this.pqu != null) {
                bVar.a(9, this.pqu);
            }
            if (this.ppX != null) {
                bVar.a(10, this.ppX);
            }
            if (this.bao != 0) {
                bVar.e((int) MMGIFException.D_GIF_ERR_OPEN_FAILED, this.bao);
            }
            if (this.pqv != 0) {
                bVar.ak(MMGIFException.D_GIF_ERR_READ_FAILED, this.pqv);
            }
            if (!Arrays.equals(this.pqw, com.google.a.a.g.aGG)) {
                bVar.a((int) MMGIFException.D_GIF_ERR_NOT_GIF_FILE, this.pqw);
            }
            if (!Arrays.equals(this.pqx, com.google.a.a.g.aGG)) {
                bVar.a(200, this.pqx);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int i = 0;
            int mU = super.mU();
            if (this.pqr != 0) {
                mU += com.google.a.a.b.al(1, this.pqr);
            }
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(2, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(3, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(4, this.ktz);
            }
            if (this.ppV != 0) {
                mU += com.google.a.a.b.am(5, this.ppV);
            }
            if (this.ppS != null) {
                mU += com.google.a.a.b.b(6, this.ppS);
            }
            if (this.pqs != null && this.pqs.length > 0) {
                int i2 = mU;
                for (com.google.a.a.e eVar : this.pqs) {
                    if (eVar != null) {
                        i2 += com.google.a.a.b.b(7, eVar);
                    }
                }
                mU = i2;
            }
            if (this.pqt != null && this.pqt.length > 0) {
                while (i < this.pqt.length) {
                    com.google.a.a.e eVar2 = this.pqt[i];
                    if (eVar2 != null) {
                        mU += com.google.a.a.b.b(8, eVar2);
                    }
                    i++;
                }
            }
            if (this.pqu != null) {
                mU += com.google.a.a.b.b(9, this.pqu);
            }
            if (this.ppX != null) {
                mU += com.google.a.a.b.b(10, this.ppX);
            }
            if (this.bao != 0) {
                mU += com.google.a.a.b.g(MMGIFException.D_GIF_ERR_OPEN_FAILED, this.bao);
            }
            if (this.pqv != 0) {
                mU += com.google.a.a.b.am(MMGIFException.D_GIF_ERR_READ_FAILED, this.pqv);
            }
            if (!Arrays.equals(this.pqw, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b((int) MMGIFException.D_GIF_ERR_NOT_GIF_FILE, this.pqw);
            }
            if (Arrays.equals(this.pqx, com.google.a.a.g.aGG)) {
                return mU;
            }
            return mU + com.google.a.a.b.b(200, this.pqx);
        }
    }

    public static final class p extends com.google.a.a.e {
        public aj[] pqy;

        public p() {
            this.pqy = aj.bMb();
            this.aGz = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        int b = com.google.a.a.g.b(aVar, 10);
                        mG = this.pqy == null ? 0 : this.pqy.length;
                        Object obj = new aj[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pqy, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new aj();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new aj();
                        aVar.a(obj[mG]);
                        this.pqy = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.pqy != null && this.pqy.length > 0) {
                for (com.google.a.a.e eVar : this.pqy) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.pqy != null && this.pqy.length > 0) {
                for (com.google.a.a.e eVar : this.pqy) {
                    if (eVar != null) {
                        mU += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return mU;
        }
    }

    public static final class q extends com.google.a.a.e {
        public String nkk;
        public String pqA;
        public String pqB;
        public int pqC;
        public String pqD;
        public long pqE;
        public int pqF;
        public long pqG;
        public int pqH;
        public String pql;
        public long pqz;
        public String username;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.pqz = aVar.mI();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.pqA = aVar.readString();
                        continue;
                    case android.support.v7.a.a.k.Kr /*26*/:
                        this.pqB = aVar.readString();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.pqC = aVar.mH();
                        continue;
                    case 42:
                        this.username = aVar.readString();
                        continue;
                    case 50:
                        this.pqD = aVar.readString();
                        continue;
                    case 58:
                        this.pql = aVar.readString();
                        continue;
                    case FileUtils.S_IXUSR /*64*/:
                        this.pqE = aVar.mI();
                        continue;
                    case 72:
                        this.pqF = aVar.mH();
                        continue;
                    case 82:
                        this.nkk = aVar.readString();
                        continue;
                    case 88:
                        this.pqG = aVar.mI();
                        continue;
                    case 96:
                        this.pqH = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public q() {
            this.pqz = 0;
            this.pqA = SQLiteDatabase.KeyEmpty;
            this.pqB = SQLiteDatabase.KeyEmpty;
            this.pqC = 1;
            this.username = SQLiteDatabase.KeyEmpty;
            this.pqD = SQLiteDatabase.KeyEmpty;
            this.pql = SQLiteDatabase.KeyEmpty;
            this.pqE = 0;
            this.pqF = 0;
            this.nkk = SQLiteDatabase.KeyEmpty;
            this.pqG = 0;
            this.pqH = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.pqz != 0) {
                bVar.e(1, this.pqz);
            }
            if (!this.pqA.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(2, this.pqA);
            }
            if (!this.pqB.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(3, this.pqB);
            }
            if (this.pqC != 1) {
                bVar.aj(4, this.pqC);
            }
            if (!this.username.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(5, this.username);
            }
            if (!this.pqD.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(6, this.pqD);
            }
            if (!this.pql.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(7, this.pql);
            }
            if (this.pqE != 0) {
                bVar.e(8, this.pqE);
            }
            if (this.pqF != 0) {
                bVar.ak(9, this.pqF);
            }
            if (!this.nkk.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(10, this.nkk);
            }
            if (this.pqG != 0) {
                bVar.e(11, this.pqG);
            }
            if (this.pqH != 0) {
                bVar.ak(12, this.pqH);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.pqz != 0) {
                mU += com.google.a.a.b.g(1, this.pqz);
            }
            if (!this.pqA.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(2, this.pqA);
            }
            if (!this.pqB.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(3, this.pqB);
            }
            if (this.pqC != 1) {
                mU += com.google.a.a.b.al(4, this.pqC);
            }
            if (!this.username.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(5, this.username);
            }
            if (!this.pqD.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(6, this.pqD);
            }
            if (!this.pql.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(7, this.pql);
            }
            if (this.pqE != 0) {
                mU += com.google.a.a.b.g(8, this.pqE);
            }
            if (this.pqF != 0) {
                mU += com.google.a.a.b.am(9, this.pqF);
            }
            if (!this.nkk.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(10, this.nkk);
            }
            if (this.pqG != 0) {
                mU += com.google.a.a.b.g(11, this.pqG);
            }
            if (this.pqH != 0) {
                return mU + com.google.a.a.b.am(12, this.pqH);
            }
            return mU;
        }
    }

    public static final class r extends com.google.a.a.e {
        public byte[] data;
        public String fwh;
        public String iconUrl;
        public int pqI;
        public byte[] pqJ;
        public byte[] pqK;
        public byte[] pqL;
        public int pqM;
        public int pqN;
        public byte[] pqO;
        public byte[] pqP;
        public byte[] pqQ;
        public byte[] pqR;
        public byte[] pqS;
        public byte[] pqT;
        public byte[] pqU;
        public byte[] pqV;
        public byte[] pqW;
        public byte[] pqX;
        public int status;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 8:
                        this.pqI = aVar.mH();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.pqJ = aVar.readBytes();
                        continue;
                    case android.support.v7.a.a.k.Kr /*26*/:
                        this.iconUrl = aVar.readString();
                        continue;
                    case 34:
                        this.pqK = aVar.readBytes();
                        continue;
                    case 42:
                        this.pqL = aVar.readBytes();
                        continue;
                    case 48:
                        this.pqM = aVar.mH();
                        continue;
                    case 58:
                        this.data = aVar.readBytes();
                        continue;
                    case FileUtils.S_IXUSR /*64*/:
                        this.pqN = aVar.mH();
                        continue;
                    case 74:
                        this.pqO = aVar.readBytes();
                        continue;
                    case 82:
                        this.fwh = aVar.readString();
                        continue;
                    case 90:
                        this.pqP = aVar.readBytes();
                        continue;
                    case 98:
                        this.pqQ = aVar.readBytes();
                        continue;
                    case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                        this.pqR = aVar.readBytes();
                        continue;
                    case 114:
                        this.pqS = aVar.readBytes();
                        continue;
                    case 122:
                        this.pqT = aVar.readBytes();
                        continue;
                    case 130:
                        this.pqU = aVar.readBytes();
                        continue;
                    case 138:
                        this.pqV = aVar.readBytes();
                        continue;
                    case 146:
                        this.pqW = aVar.readBytes();
                        continue;
                    case 154:
                        this.pqX = aVar.readBytes();
                        continue;
                    case 160:
                        this.status = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public r() {
            this.pqI = 0;
            this.pqJ = com.google.a.a.g.aGG;
            this.iconUrl = SQLiteDatabase.KeyEmpty;
            this.pqK = com.google.a.a.g.aGG;
            this.pqL = com.google.a.a.g.aGG;
            this.pqM = 0;
            this.data = com.google.a.a.g.aGG;
            this.pqN = 0;
            this.pqO = com.google.a.a.g.aGG;
            this.fwh = SQLiteDatabase.KeyEmpty;
            this.pqP = com.google.a.a.g.aGG;
            this.pqQ = com.google.a.a.g.aGG;
            this.pqR = com.google.a.a.g.aGG;
            this.pqS = com.google.a.a.g.aGG;
            this.pqT = com.google.a.a.g.aGG;
            this.pqU = com.google.a.a.g.aGG;
            this.pqV = com.google.a.a.g.aGG;
            this.pqW = com.google.a.a.g.aGG;
            this.pqX = com.google.a.a.g.aGG;
            this.status = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.pqI != 0) {
                bVar.ak(1, this.pqI);
            }
            if (!Arrays.equals(this.pqJ, com.google.a.a.g.aGG)) {
                bVar.a(2, this.pqJ);
            }
            if (!this.iconUrl.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(3, this.iconUrl);
            }
            if (!Arrays.equals(this.pqK, com.google.a.a.g.aGG)) {
                bVar.a(4, this.pqK);
            }
            if (!Arrays.equals(this.pqL, com.google.a.a.g.aGG)) {
                bVar.a(5, this.pqL);
            }
            if (this.pqM != 0) {
                bVar.ak(6, this.pqM);
            }
            if (!Arrays.equals(this.data, com.google.a.a.g.aGG)) {
                bVar.a(7, this.data);
            }
            if (this.pqN != 0) {
                bVar.ak(8, this.pqN);
            }
            if (!Arrays.equals(this.pqO, com.google.a.a.g.aGG)) {
                bVar.a(9, this.pqO);
            }
            if (!this.fwh.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(10, this.fwh);
            }
            if (!Arrays.equals(this.pqP, com.google.a.a.g.aGG)) {
                bVar.a(11, this.pqP);
            }
            if (!Arrays.equals(this.pqQ, com.google.a.a.g.aGG)) {
                bVar.a(12, this.pqQ);
            }
            if (!Arrays.equals(this.pqR, com.google.a.a.g.aGG)) {
                bVar.a(13, this.pqR);
            }
            if (!Arrays.equals(this.pqS, com.google.a.a.g.aGG)) {
                bVar.a(14, this.pqS);
            }
            if (!Arrays.equals(this.pqT, com.google.a.a.g.aGG)) {
                bVar.a(15, this.pqT);
            }
            if (!Arrays.equals(this.pqU, com.google.a.a.g.aGG)) {
                bVar.a(16, this.pqU);
            }
            if (!Arrays.equals(this.pqV, com.google.a.a.g.aGG)) {
                bVar.a(17, this.pqV);
            }
            if (!Arrays.equals(this.pqW, com.google.a.a.g.aGG)) {
                bVar.a(18, this.pqW);
            }
            if (!Arrays.equals(this.pqX, com.google.a.a.g.aGG)) {
                bVar.a(19, this.pqX);
            }
            if (this.status != 0) {
                bVar.ak(20, this.status);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.pqI != 0) {
                mU += com.google.a.a.b.am(1, this.pqI);
            }
            if (!Arrays.equals(this.pqJ, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(2, this.pqJ);
            }
            if (!this.iconUrl.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(3, this.iconUrl);
            }
            if (!Arrays.equals(this.pqK, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(4, this.pqK);
            }
            if (!Arrays.equals(this.pqL, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(5, this.pqL);
            }
            if (this.pqM != 0) {
                mU += com.google.a.a.b.am(6, this.pqM);
            }
            if (!Arrays.equals(this.data, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(7, this.data);
            }
            if (this.pqN != 0) {
                mU += com.google.a.a.b.am(8, this.pqN);
            }
            if (!Arrays.equals(this.pqO, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(9, this.pqO);
            }
            if (!this.fwh.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(10, this.fwh);
            }
            if (!Arrays.equals(this.pqP, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(11, this.pqP);
            }
            if (!Arrays.equals(this.pqQ, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(12, this.pqQ);
            }
            if (!Arrays.equals(this.pqR, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(13, this.pqR);
            }
            if (!Arrays.equals(this.pqS, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(14, this.pqS);
            }
            if (!Arrays.equals(this.pqT, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(15, this.pqT);
            }
            if (!Arrays.equals(this.pqU, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(16, this.pqU);
            }
            if (!Arrays.equals(this.pqV, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(17, this.pqV);
            }
            if (!Arrays.equals(this.pqW, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(18, this.pqW);
            }
            if (!Arrays.equals(this.pqX, com.google.a.a.g.aGG)) {
                mU += com.google.a.a.b.b(19, this.pqX);
            }
            if (this.status != 0) {
                return mU + com.google.a.a.b.am(20, this.status);
            }
            return mU;
        }
    }

    public static final class s extends com.google.a.a.e {
        public int lYf;
        public int of;
        public int ppV;
        public int pqY;
        public int pqZ;
        public int ret;
        public String userName;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.userName = aVar.readString();
                        continue;
                    case 24:
                        this.of = aVar.mH();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.pqY = aVar.mH();
                        continue;
                    case 40:
                        this.ret = aVar.mH();
                        continue;
                    case 48:
                        this.pqZ = aVar.mH();
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        this.ppV = aVar.mH();
                        continue;
                    case FileUtils.S_IXUSR /*64*/:
                        this.lYf = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public s() {
            this.userName = SQLiteDatabase.KeyEmpty;
            this.of = 0;
            this.pqY = 0;
            this.ret = 0;
            this.pqZ = 0;
            this.ppV = 0;
            this.lYf = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.userName.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(2, this.userName);
            }
            if (this.of != 0) {
                bVar.aj(3, this.of);
            }
            if (this.pqY != 0) {
                bVar.ak(4, this.pqY);
            }
            if (this.ret != 0) {
                bVar.aj(5, this.ret);
            }
            if (this.pqZ != 0) {
                bVar.aj(6, this.pqZ);
            }
            if (this.ppV != 0) {
                bVar.ak(7, this.ppV);
            }
            if (this.lYf != 0) {
                bVar.ak(8, this.lYf);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.userName.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(2, this.userName);
            }
            if (this.of != 0) {
                mU += com.google.a.a.b.al(3, this.of);
            }
            if (this.pqY != 0) {
                mU += com.google.a.a.b.am(4, this.pqY);
            }
            if (this.ret != 0) {
                mU += com.google.a.a.b.al(5, this.ret);
            }
            if (this.pqZ != 0) {
                mU += com.google.a.a.b.al(6, this.pqZ);
            }
            if (this.ppV != 0) {
                mU += com.google.a.a.b.am(7, this.ppV);
            }
            if (this.lYf != 0) {
                return mU + com.google.a.a.b.am(8, this.lYf);
            }
            return mU;
        }
    }

    public static final class t extends com.google.a.a.e {
        public byte[] body;
        public s pra;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        if (this.pra == null) {
                            this.pra = new s();
                        }
                        aVar.a(this.pra);
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.body = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public t() {
            this.pra = null;
            this.body = com.google.a.a.g.aGG;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.pra != null) {
                bVar.a(1, this.pra);
            }
            if (!Arrays.equals(this.body, com.google.a.a.g.aGG)) {
                bVar.a(2, this.body);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.pra != null) {
                mU += com.google.a.a.b.b(1, this.pra);
            }
            if (Arrays.equals(this.body, com.google.a.a.g.aGG)) {
                return mU;
            }
            return mU + com.google.a.a.b.b(2, this.body);
        }
    }

    public static final class u extends com.google.a.a.e {
        private static volatile u[] prb;
        public String prc;
        public String prd;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.prc = aVar.readString();
                        continue;
                    case android.support.v7.a.a.k.MG /*18*/:
                        this.prd = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static u[] bMa() {
            if (prb == null) {
                synchronized (com.google.a.a.c.aGy) {
                    if (prb == null) {
                        prb = new u[0];
                    }
                }
            }
            return prb;
        }

        public u() {
            this.prc = SQLiteDatabase.KeyEmpty;
            this.prd = SQLiteDatabase.KeyEmpty;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.prc.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.prc);
            }
            if (!this.prd.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(2, this.prd);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.prc.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.prc);
            }
            if (this.prd.equals(SQLiteDatabase.KeyEmpty)) {
                return mU;
            }
            return mU + com.google.a.a.b.f(2, this.prd);
        }
    }

    public static final class v extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;
        public ao ppS;
        public aq[] pre;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case 34:
                        int b = com.google.a.a.g.b(aVar, 34);
                        mG = this.pre == null ? 0 : this.pre.length;
                        Object obj = new aq[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pre, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new aq();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new aq();
                        aVar.a(obj[mG]);
                        this.pre = obj;
                        continue;
                    case 42:
                        if (this.ppS == null) {
                            this.ppS = new ao();
                        }
                        aVar.a(this.ppS);
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public v() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.pre = aq.bMe();
            this.ppS = null;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.pre != null && this.pre.length > 0) {
                for (com.google.a.a.e eVar : this.pre) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.ppS != null) {
                bVar.a(5, this.ppS);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.pre != null && this.pre.length > 0) {
                int i = mU;
                for (com.google.a.a.e eVar : this.pre) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                mU = i;
            }
            if (this.ppS != null) {
                return mU + com.google.a.a.b.b(5, this.ppS);
            }
            return mU;
        }
    }

    public static final class w extends com.google.a.a.e {
        public String ppQ;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.ppQ = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public w() {
            this.ppQ = SQLiteDatabase.KeyEmpty;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.ppQ);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                return mU;
            }
            return mU + com.google.a.a.b.f(1, this.ppQ);
        }
    }

    public static final class x extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;
        public String ppQ;
        public ao ppS;
        public int ppV;
        public int pqn;
        public aq[] pqt;
        public an pqu;
        public n[] prf;
        public ar[] prg;
        public int prh;
        public int[] pri;
        public n[] prj;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                int b;
                Object obj;
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case FileUtils.S_IRGRP /*32*/:
                        this.ppV = aVar.mH();
                        continue;
                    case 42:
                        b = com.google.a.a.g.b(aVar, 42);
                        mG = this.prf == null ? 0 : this.prf.length;
                        obj = new n[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prf, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new n();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new n();
                        aVar.a(obj[mG]);
                        this.prf = obj;
                        continue;
                    case 50:
                        b = com.google.a.a.g.b(aVar, 50);
                        mG = this.prg == null ? 0 : this.prg.length;
                        obj = new ar[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prg, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new ar();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new ar();
                        aVar.a(obj[mG]);
                        this.prg = obj;
                        continue;
                    case 58:
                        if (this.pqu == null) {
                            this.pqu = new an();
                        }
                        aVar.a(this.pqu);
                        continue;
                    case 66:
                        this.ppQ = aVar.readString();
                        continue;
                    case 74:
                        b = com.google.a.a.g.b(aVar, 74);
                        mG = this.pqt == null ? 0 : this.pqt.length;
                        obj = new aq[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pqt, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new aq();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new aq();
                        aVar.a(obj[mG]);
                        this.pqt = obj;
                        continue;
                    case 80:
                        this.prh = aVar.mH();
                        continue;
                    case 88:
                        b = com.google.a.a.g.b(aVar, 88);
                        mG = this.pri == null ? 0 : this.pri.length;
                        obj = new int[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pri, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.mH();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.mH();
                        this.pri = obj;
                        continue;
                    case 90:
                        int cp = aVar.cp(aVar.mH());
                        b = aVar.getPosition();
                        mG = 0;
                        while (aVar.mK() > 0) {
                            aVar.mH();
                            mG++;
                        }
                        aVar.cr(b);
                        b = this.pri == null ? 0 : this.pri.length;
                        Object obj2 = new int[(mG + b)];
                        if (b != 0) {
                            System.arraycopy(this.pri, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mH();
                            b++;
                        }
                        this.pri = obj2;
                        aVar.cq(cp);
                        continue;
                    case 98:
                        if (this.ppS == null) {
                            this.ppS = new ao();
                        }
                        aVar.a(this.ppS);
                        continue;
                    case MMGIFException.D_GIF_ERR_NO_SCRN_DSCR /*104*/:
                        this.pqn = aVar.mH();
                        continue;
                    case 114:
                        b = com.google.a.a.g.b(aVar, 114);
                        mG = this.prj == null ? 0 : this.prj.length;
                        obj = new n[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prj, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new n();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new n();
                        aVar.a(obj[mG]);
                        this.prj = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public x() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.ppV = 0;
            this.prf = n.bLZ();
            this.prg = ar.bMf();
            this.pqu = null;
            this.ppQ = SQLiteDatabase.KeyEmpty;
            this.pqt = aq.bMe();
            this.prh = 0;
            this.pri = com.google.a.a.g.aGA;
            this.ppS = null;
            this.pqn = 0;
            this.prj = n.bLZ();
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.ppV != 0) {
                bVar.ak(4, this.ppV);
            }
            if (this.prf != null && this.prf.length > 0) {
                for (com.google.a.a.e eVar : this.prf) {
                    if (eVar != null) {
                        bVar.a(5, eVar);
                    }
                }
            }
            if (this.prg != null && this.prg.length > 0) {
                for (com.google.a.a.e eVar2 : this.prg) {
                    if (eVar2 != null) {
                        bVar.a(6, eVar2);
                    }
                }
            }
            if (this.pqu != null) {
                bVar.a(7, this.pqu);
            }
            if (!this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(8, this.ppQ);
            }
            if (this.pqt != null && this.pqt.length > 0) {
                for (com.google.a.a.e eVar22 : this.pqt) {
                    if (eVar22 != null) {
                        bVar.a(9, eVar22);
                    }
                }
            }
            if (this.prh != 0) {
                bVar.aj(10, this.prh);
            }
            if (this.pri != null && this.pri.length > 0) {
                for (int aj : this.pri) {
                    bVar.aj(11, aj);
                }
            }
            if (this.ppS != null) {
                bVar.a(12, this.ppS);
            }
            if (this.pqn != 0) {
                bVar.ak(13, this.pqn);
            }
            if (this.prj != null && this.prj.length > 0) {
                while (i < this.prj.length) {
                    com.google.a.a.e eVar3 = this.prj[i];
                    if (eVar3 != null) {
                        bVar.a(14, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int mU() {
            int i;
            int i2 = 0;
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.ppV != 0) {
                mU += com.google.a.a.b.am(4, this.ppV);
            }
            if (this.prf != null && this.prf.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar : this.prf) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(5, eVar);
                    }
                }
                mU = i;
            }
            if (this.prg != null && this.prg.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar2 : this.prg) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(6, eVar2);
                    }
                }
                mU = i;
            }
            if (this.pqu != null) {
                mU += com.google.a.a.b.b(7, this.pqu);
            }
            if (!this.ppQ.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(8, this.ppQ);
            }
            if (this.pqt != null && this.pqt.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar22 : this.pqt) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(9, eVar22);
                    }
                }
                mU = i;
            }
            if (this.prh != 0) {
                mU += com.google.a.a.b.al(10, this.prh);
            }
            if (this.pri != null && this.pri.length > 0) {
                int i3 = 0;
                for (int cu : this.pri) {
                    i3 += com.google.a.a.b.cu(cu);
                }
                mU = (mU + i3) + (this.pri.length * 1);
            }
            if (this.ppS != null) {
                mU += com.google.a.a.b.b(12, this.ppS);
            }
            if (this.pqn != 0) {
                mU += com.google.a.a.b.am(13, this.pqn);
            }
            if (this.prj != null && this.prj.length > 0) {
                while (i2 < this.prj.length) {
                    com.google.a.a.e eVar3 = this.prj[i2];
                    if (eVar3 != null) {
                        mU += com.google.a.a.b.b(14, eVar3);
                    }
                    i2++;
                }
            }
            return mU;
        }
    }

    public static final class y extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;
        public ao ppS;
        public int pqc;
        public int pqn;
        public an pqu;
        public aq[] pre;
        public n[] prf;
        public ar[] prg;
        public int prh;
        public int[] pri;
        public n[] prj;
        public int prk;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                int b;
                Object obj;
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    case 34:
                        b = com.google.a.a.g.b(aVar, 34);
                        mG = this.prf == null ? 0 : this.prf.length;
                        obj = new n[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prf, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new n();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new n();
                        aVar.a(obj[mG]);
                        this.prf = obj;
                        continue;
                    case 42:
                        b = com.google.a.a.g.b(aVar, 42);
                        mG = this.pre == null ? 0 : this.pre.length;
                        obj = new aq[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pre, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new aq();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new aq();
                        aVar.a(obj[mG]);
                        this.pre = obj;
                        continue;
                    case 50:
                        if (this.pqu == null) {
                            this.pqu = new an();
                        }
                        aVar.a(this.pqu);
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        this.prh = aVar.mH();
                        continue;
                    case FileUtils.S_IXUSR /*64*/:
                        b = com.google.a.a.g.b(aVar, 64);
                        mG = this.pri == null ? 0 : this.pri.length;
                        obj = new int[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.pri, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = aVar.mH();
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = aVar.mH();
                        this.pri = obj;
                        continue;
                    case 66:
                        int cp = aVar.cp(aVar.mH());
                        b = aVar.getPosition();
                        mG = 0;
                        while (aVar.mK() > 0) {
                            aVar.mH();
                            mG++;
                        }
                        aVar.cr(b);
                        b = this.pri == null ? 0 : this.pri.length;
                        Object obj2 = new int[(mG + b)];
                        if (b != 0) {
                            System.arraycopy(this.pri, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mH();
                            b++;
                        }
                        this.pri = obj2;
                        aVar.cq(cp);
                        continue;
                    case 72:
                        this.pqc = aVar.mH();
                        continue;
                    case 82:
                        b = com.google.a.a.g.b(aVar, 82);
                        mG = this.prg == null ? 0 : this.prg.length;
                        obj = new ar[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prg, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new ar();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new ar();
                        aVar.a(obj[mG]);
                        this.prg = obj;
                        continue;
                    case 90:
                        if (this.ppS == null) {
                            this.ppS = new ao();
                        }
                        aVar.a(this.ppS);
                        continue;
                    case 96:
                        this.pqn = aVar.mH();
                        continue;
                    case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                        b = com.google.a.a.g.b(aVar, MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
                        mG = this.prj == null ? 0 : this.prj.length;
                        obj = new n[(b + mG)];
                        if (mG != 0) {
                            System.arraycopy(this.prj, 0, obj, 0, mG);
                        }
                        while (mG < obj.length - 1) {
                            obj[mG] = new n();
                            aVar.a(obj[mG]);
                            aVar.mG();
                            mG++;
                        }
                        obj[mG] = new n();
                        aVar.a(obj[mG]);
                        this.prj = obj;
                        continue;
                    case 800:
                        this.prk = aVar.mH();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public y() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.prf = n.bLZ();
            this.pre = aq.bMe();
            this.pqu = null;
            this.prh = 0;
            this.pri = com.google.a.a.g.aGA;
            this.pqc = 0;
            this.prg = ar.bMf();
            this.ppS = null;
            this.pqn = 0;
            this.prj = n.bLZ();
            this.prk = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            if (this.prf != null && this.prf.length > 0) {
                for (com.google.a.a.e eVar : this.prf) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.pre != null && this.pre.length > 0) {
                for (com.google.a.a.e eVar2 : this.pre) {
                    if (eVar2 != null) {
                        bVar.a(5, eVar2);
                    }
                }
            }
            if (this.pqu != null) {
                bVar.a(6, this.pqu);
            }
            if (this.prh != 0) {
                bVar.aj(7, this.prh);
            }
            if (this.pri != null && this.pri.length > 0) {
                for (int aj : this.pri) {
                    bVar.aj(8, aj);
                }
            }
            if (this.pqc != 0) {
                bVar.aj(9, this.pqc);
            }
            if (this.prg != null && this.prg.length > 0) {
                for (com.google.a.a.e eVar22 : this.prg) {
                    if (eVar22 != null) {
                        bVar.a(10, eVar22);
                    }
                }
            }
            if (this.ppS != null) {
                bVar.a(11, this.ppS);
            }
            if (this.pqn != 0) {
                bVar.ak(12, this.pqn);
            }
            if (this.prj != null && this.prj.length > 0) {
                while (i < this.prj.length) {
                    com.google.a.a.e eVar3 = this.prj[i];
                    if (eVar3 != null) {
                        bVar.a(13, eVar3);
                    }
                    i++;
                }
            }
            if (this.prk != 0) {
                bVar.ak(100, this.prk);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int i;
            int i2 = 0;
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                mU += com.google.a.a.b.h(3, this.ktz);
            }
            if (this.prf != null && this.prf.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar : this.prf) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                mU = i;
            }
            if (this.pre != null && this.pre.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar2 : this.pre) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(5, eVar2);
                    }
                }
                mU = i;
            }
            if (this.pqu != null) {
                mU += com.google.a.a.b.b(6, this.pqu);
            }
            if (this.prh != 0) {
                mU += com.google.a.a.b.al(7, this.prh);
            }
            if (this.pri != null && this.pri.length > 0) {
                int i3 = 0;
                for (int cu : this.pri) {
                    i3 += com.google.a.a.b.cu(cu);
                }
                mU = (mU + i3) + (this.pri.length * 1);
            }
            if (this.pqc != 0) {
                mU += com.google.a.a.b.al(9, this.pqc);
            }
            if (this.prg != null && this.prg.length > 0) {
                i = mU;
                for (com.google.a.a.e eVar22 : this.prg) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(10, eVar22);
                    }
                }
                mU = i;
            }
            if (this.ppS != null) {
                mU += com.google.a.a.b.b(11, this.ppS);
            }
            if (this.pqn != 0) {
                mU += com.google.a.a.b.am(12, this.pqn);
            }
            if (this.prj != null && this.prj.length > 0) {
                while (i2 < this.prj.length) {
                    com.google.a.a.e eVar3 = this.prj[i2];
                    if (eVar3 != null) {
                        mU += com.google.a.a.b.b(13, eVar3);
                    }
                    i2++;
                }
            }
            if (this.prk != 0) {
                return mU + com.google.a.a.b.am(100, this.prk);
            }
            return mU;
        }
    }

    public static final class z extends com.google.a.a.e {
        public int kty;
        public long ktz;
        public String lEs;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mG = aVar.mG();
                switch (mG) {
                    case 0:
                        break;
                    case 10:
                        this.lEs = aVar.readString();
                        continue;
                    case 16:
                        this.kty = aVar.mH();
                        continue;
                    case 24:
                        this.ktz = aVar.mI();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mG)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public z() {
            this.lEs = SQLiteDatabase.KeyEmpty;
            this.kty = 0;
            this.ktz = 0;
            this.aGz = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                bVar.e(1, this.lEs);
            }
            if (this.kty != 0) {
                bVar.aj(2, this.kty);
            }
            if (this.ktz != 0) {
                bVar.f(3, this.ktz);
            }
            super.a(bVar);
        }

        protected final int mU() {
            int mU = super.mU();
            if (!this.lEs.equals(SQLiteDatabase.KeyEmpty)) {
                mU += com.google.a.a.b.f(1, this.lEs);
            }
            if (this.kty != 0) {
                mU += com.google.a.a.b.al(2, this.kty);
            }
            if (this.ktz != 0) {
                return mU + com.google.a.a.b.h(3, this.ktz);
            }
            return mU;
        }
    }
}
