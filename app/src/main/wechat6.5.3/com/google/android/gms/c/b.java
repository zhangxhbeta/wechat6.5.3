package com.google.android.gms.c;

import android.support.v7.a.a.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public interface b {

    public static final class a extends ay<a> {
        private static volatile a[] awL;
        public String awM;
        public a[] awN;
        public a[] awO;
        public a[] awP;
        public String awQ;
        public String awR;
        public long awS;
        public boolean awT;
        public a[] awU;
        public int[] awV;
        public boolean awW;
        public int type;

        public a() {
            this.type = 1;
            this.awM = SQLiteDatabase.KeyEmpty;
            this.awN = kE();
            this.awO = kE();
            this.awP = kE();
            this.awQ = SQLiteDatabase.KeyEmpty;
            this.awR = SQLiteDatabase.KeyEmpty;
            this.awS = 0;
            this.awT = false;
            this.awU = kE();
            this.awV = bh.aAX;
            this.awW = false;
            this.aAK = null;
            this.aAV = -1;
        }

        private static a[] kE() {
            if (awL == null) {
                synchronized (bc.aAU) {
                    if (awL == null) {
                        awL = new a[0];
                    }
                }
            }
            return awL;
        }

        public final /* synthetic */ be a(aw awVar) {
            while (true) {
                int lg = awVar.lg();
                int b;
                Object obj;
                int i;
                switch (lg) {
                    case 0:
                        break;
                    case 8:
                        lg = awVar.lj();
                        switch (lg) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = lg;
                                break;
                            default:
                                continue;
                        }
                    case k.MG /*18*/:
                        this.awM = awVar.readString();
                        continue;
                    case k.Kr /*26*/:
                        b = bh.b(awVar, 26);
                        lg = this.awN == null ? 0 : this.awN.length;
                        obj = new a[(b + lg)];
                        if (lg != 0) {
                            System.arraycopy(this.awN, 0, obj, 0, lg);
                        }
                        while (lg < obj.length - 1) {
                            obj[lg] = new a();
                            awVar.a(obj[lg]);
                            awVar.lg();
                            lg++;
                        }
                        obj[lg] = new a();
                        awVar.a(obj[lg]);
                        this.awN = obj;
                        continue;
                    case 34:
                        b = bh.b(awVar, 34);
                        lg = this.awO == null ? 0 : this.awO.length;
                        obj = new a[(b + lg)];
                        if (lg != 0) {
                            System.arraycopy(this.awO, 0, obj, 0, lg);
                        }
                        while (lg < obj.length - 1) {
                            obj[lg] = new a();
                            awVar.a(obj[lg]);
                            awVar.lg();
                            lg++;
                        }
                        obj[lg] = new a();
                        awVar.a(obj[lg]);
                        this.awO = obj;
                        continue;
                    case 42:
                        b = bh.b(awVar, 42);
                        lg = this.awP == null ? 0 : this.awP.length;
                        obj = new a[(b + lg)];
                        if (lg != 0) {
                            System.arraycopy(this.awP, 0, obj, 0, lg);
                        }
                        while (lg < obj.length - 1) {
                            obj[lg] = new a();
                            awVar.a(obj[lg]);
                            awVar.lg();
                            lg++;
                        }
                        obj[lg] = new a();
                        awVar.a(obj[lg]);
                        this.awP = obj;
                        continue;
                    case 50:
                        this.awQ = awVar.readString();
                        continue;
                    case 58:
                        this.awR = awVar.readString();
                        continue;
                    case FileUtils.S_IXUSR /*64*/:
                        this.awS = awVar.lh();
                        continue;
                    case 72:
                        this.awW = awVar.li();
                        continue;
                    case 80:
                        int b2 = bh.b(awVar, 80);
                        Object obj2 = new int[b2];
                        i = 0;
                        b = 0;
                        while (i < b2) {
                            if (i != 0) {
                                awVar.lg();
                            }
                            int lj = awVar.lj();
                            switch (lj) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    lg = b + 1;
                                    obj2[b] = lj;
                                    break;
                                default:
                                    lg = b;
                                    break;
                            }
                            i++;
                            b = lg;
                        }
                        if (b != 0) {
                            lg = this.awV == null ? 0 : this.awV.length;
                            if (lg != 0 || b != obj2.length) {
                                Object obj3 = new int[(lg + b)];
                                if (lg != 0) {
                                    System.arraycopy(this.awV, 0, obj3, 0, lg);
                                }
                                System.arraycopy(obj2, 0, obj3, lg, b);
                                this.awV = obj3;
                                break;
                            }
                            this.awV = obj2;
                            break;
                        }
                        continue;
                    case 82:
                        i = awVar.bV(awVar.lj());
                        b = awVar.getPosition();
                        lg = 0;
                        while (awVar.ln() > 0) {
                            switch (awVar.lj()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    lg++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (lg != 0) {
                            awVar.bX(b);
                            b = this.awV == null ? 0 : this.awV.length;
                            Object obj4 = new int[(lg + b)];
                            if (b != 0) {
                                System.arraycopy(this.awV, 0, obj4, 0, b);
                            }
                            while (awVar.ln() > 0) {
                                int lj2 = awVar.lj();
                                switch (lj2) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        lg = b + 1;
                                        obj4[b] = lj2;
                                        b = lg;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.awV = obj4;
                        }
                        awVar.bW(i);
                        continue;
                    case 90:
                        b = bh.b(awVar, 90);
                        lg = this.awU == null ? 0 : this.awU.length;
                        obj = new a[(b + lg)];
                        if (lg != 0) {
                            System.arraycopy(this.awU, 0, obj, 0, lg);
                        }
                        while (lg < obj.length - 1) {
                            obj[lg] = new a();
                            awVar.a(obj[lg]);
                            awVar.lg();
                            lg++;
                        }
                        obj[lg] = new a();
                        awVar.a(obj[lg]);
                        this.awU = obj;
                        continue;
                    case 96:
                        this.awT = awVar.li();
                        continue;
                    default:
                        if (!a(awVar, lg)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(ax axVar) {
            int i = 0;
            axVar.ae(1, this.type);
            if (!this.awM.equals(SQLiteDatabase.KeyEmpty)) {
                axVar.c(2, this.awM);
            }
            if (this.awN != null && this.awN.length > 0) {
                for (be beVar : this.awN) {
                    if (beVar != null) {
                        axVar.a(3, beVar);
                    }
                }
            }
            if (this.awO != null && this.awO.length > 0) {
                for (be beVar2 : this.awO) {
                    if (beVar2 != null) {
                        axVar.a(4, beVar2);
                    }
                }
            }
            if (this.awP != null && this.awP.length > 0) {
                for (be beVar22 : this.awP) {
                    if (beVar22 != null) {
                        axVar.a(5, beVar22);
                    }
                }
            }
            if (!this.awQ.equals(SQLiteDatabase.KeyEmpty)) {
                axVar.c(6, this.awQ);
            }
            if (!this.awR.equals(SQLiteDatabase.KeyEmpty)) {
                axVar.c(7, this.awR);
            }
            if (this.awS != 0) {
                axVar.c(8, this.awS);
            }
            if (this.awW) {
                axVar.q(9, this.awW);
            }
            if (this.awV != null && this.awV.length > 0) {
                for (int ae : this.awV) {
                    axVar.ae(10, ae);
                }
            }
            if (this.awU != null && this.awU.length > 0) {
                while (i < this.awU.length) {
                    be beVar3 = this.awU[i];
                    if (beVar3 != null) {
                        axVar.a(11, beVar3);
                    }
                    i++;
                }
            }
            if (this.awT) {
                axVar.q(12, this.awT);
            }
            super.a(axVar);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.type != aVar.type) {
                return false;
            }
            if (this.awM == null) {
                if (aVar.awM != null) {
                    return false;
                }
            } else if (!this.awM.equals(aVar.awM)) {
                return false;
            }
            if (!bc.equals(this.awN, aVar.awN) || !bc.equals(this.awO, aVar.awO) || !bc.equals(this.awP, aVar.awP)) {
                return false;
            }
            if (this.awQ == null) {
                if (aVar.awQ != null) {
                    return false;
                }
            } else if (!this.awQ.equals(aVar.awQ)) {
                return false;
            }
            if (this.awR == null) {
                if (aVar.awR != null) {
                    return false;
                }
            } else if (!this.awR.equals(aVar.awR)) {
                return false;
            }
            return (this.awS == aVar.awS && this.awT == aVar.awT && bc.equals(this.awU, aVar.awU) && bc.equals(this.awV, aVar.awV) && this.awW == aVar.awW) ? a((ay) aVar) : false;
        }

        public final int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.awQ == null ? 0 : this.awQ.hashCode()) + (((((((((this.awM == null ? 0 : this.awM.hashCode()) + ((this.type + 527) * 31)) * 31) + bc.hashCode(this.awN)) * 31) + bc.hashCode(this.awO)) * 31) + bc.hashCode(this.awP)) * 31)) * 31;
            if (this.awR != null) {
                i2 = this.awR.hashCode();
            }
            hashCode = ((((((this.awT ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.awS ^ (this.awS >>> 32)))) * 31)) * 31) + bc.hashCode(this.awU)) * 31) + bc.hashCode(this.awV)) * 31;
            if (!this.awW) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + lp();
        }

        protected final int kF() {
            int i;
            int i2 = 0;
            int kF = super.kF() + ax.af(1, this.type);
            if (!this.awM.equals(SQLiteDatabase.KeyEmpty)) {
                kF += ax.d(2, this.awM);
            }
            if (this.awN != null && this.awN.length > 0) {
                i = kF;
                for (be beVar : this.awN) {
                    if (beVar != null) {
                        i += ax.b(3, beVar);
                    }
                }
                kF = i;
            }
            if (this.awO != null && this.awO.length > 0) {
                i = kF;
                for (be beVar2 : this.awO) {
                    if (beVar2 != null) {
                        i += ax.b(4, beVar2);
                    }
                }
                kF = i;
            }
            if (this.awP != null && this.awP.length > 0) {
                i = kF;
                for (be beVar22 : this.awP) {
                    if (beVar22 != null) {
                        i += ax.b(5, beVar22);
                    }
                }
                kF = i;
            }
            if (!this.awQ.equals(SQLiteDatabase.KeyEmpty)) {
                kF += ax.d(6, this.awQ);
            }
            if (!this.awR.equals(SQLiteDatabase.KeyEmpty)) {
                kF += ax.d(7, this.awR);
            }
            if (this.awS != 0) {
                kF += ax.d(8, this.awS);
            }
            if (this.awW) {
                kF += ax.cc(9) + 1;
            }
            if (this.awV != null && this.awV.length > 0) {
                int i3 = 0;
                for (int ca : this.awV) {
                    i3 += ax.ca(ca);
                }
                kF = (kF + i3) + (this.awV.length * 1);
            }
            if (this.awU != null && this.awU.length > 0) {
                while (i2 < this.awU.length) {
                    be beVar3 = this.awU[i2];
                    if (beVar3 != null) {
                        kF += ax.b(11, beVar3);
                    }
                    i2++;
                }
            }
            return this.awT ? kF + (ax.cc(12) + 1) : kF;
        }
    }
}
