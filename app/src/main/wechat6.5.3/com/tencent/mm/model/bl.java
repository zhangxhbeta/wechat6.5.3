package com.tencent.mm.model;

import com.tencent.mm.protocal.c.afj;
import com.tencent.mm.protocal.c.afk;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class bl {
    public static final int cvl;
    public static final int cvm;
    public static final int cvn = (cvl + 2);
    private static bl cvq;
    private long cvo = 0;
    private Map<Integer, a> cvp = new HashMap();

    private abstract class a {
        final /* synthetic */ bl cvr;

        public abstract boolean a(bj bjVar);

        private a(bl blVar) {
            this.cvr = blVar;
        }

        public bj c(int i, Object... objArr) {
            int i2 = 1;
            if (objArr != null && objArr.length > 0) {
                i2 = be.n(objArr[0], 1);
            }
            bj bjVar = new bj();
            bjVar.key = i;
            bjVar.cvi = String.valueOf(i2);
            bjVar.cvj = 0;
            return bjVar;
        }

        public void a(bj bjVar, Object... objArr) {
            int i = 1;
            if (objArr != null && objArr.length > 0) {
                i = be.n(objArr[0], 1);
            }
            bjVar.cvi = (i + be.getInt(bjVar.cvi, 0));
        }
    }

    static {
        int hashCode = "kv_key_start".hashCode();
        cvl = hashCode;
        cvm = hashCode + 1;
    }

    private bl() {
        this.cvp.put(Integer.valueOf(cvm), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 3600000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(23, bjVar.cvi + "_3");
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(cvn), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 3600000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(23, bjVar.cvi + "_43");
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(24), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 3600000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(25), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final bj c(int i, Object... objArr) {
                bj bjVar = new bj();
                bjVar.key = i;
                bjVar.cvi = objArr[0];
                bjVar.cvj = 0;
                return bjVar;
            }

            public final void a(bj bjVar, Object... objArr) {
                bjVar.cvi = objArr[0];
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 3600000 || bjVar.cvi.length() <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = SQLiteDatabase.KeyEmpty;
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(26), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 3600000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10071), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 86400000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, "1");
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10076), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 3600000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(19), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 86400000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10112), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10113), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10114), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10115), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10240), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10241), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(15), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(16), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(27), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(38), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10090), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10237), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10238), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
        this.cvp.put(Integer.valueOf(10239), new a(this) {
            final /* synthetic */ bl cvr;

            {
                this.cvr = r2;
            }

            public final boolean a(bj bjVar) {
                if (System.currentTimeMillis() - bjVar.cvj <= 1800000 || be.getInt(bjVar.cvi, 0) <= 0) {
                    return false;
                }
                bl.p(bjVar.key, bjVar.cvi);
                bjVar.cvi = "0";
                bjVar.cvj = System.currentTimeMillis();
                return true;
            }
        });
    }

    public static bl zQ() {
        if (cvq == null) {
            cvq = new bl();
        }
        return cvq;
    }

    public static void p(int i, String str) {
        LinkedList linkedList = new LinkedList();
        afj com_tencent_mm_protocal_c_afj = new afj();
        com_tencent_mm_protocal_c_afj.itH = i;
        com_tencent_mm_protocal_c_afj.itR = str;
        linkedList.add(com_tencent_mm_protocal_c_afj);
        a(linkedList);
    }

    public static void a(LinkedList<afj> linkedList) {
        if (ak.uz() && !ak.uG()) {
            com.tencent.mm.ba.a com_tencent_mm_protocal_c_afk = new afk();
            com_tencent_mm_protocal_c_afk.eeu = linkedList;
            com_tencent_mm_protocal_c_afk.eet = linkedList.size();
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(36, com_tencent_mm_protocal_c_afk));
        }
    }

    public final void b(int i, Object... objArr) {
        a aVar = (a) this.cvp.get(Integer.valueOf(i));
        if (aVar != null) {
            bk zS = zS();
            for (bj bjVar : zS.cvk) {
                if (bjVar.key == i) {
                    aVar.a(bjVar, objArr);
                    break;
                }
            }
            zS.cvk.add(aVar.c(i, objArr));
            a(zS);
        }
    }

    public final void zR() {
        if (System.currentTimeMillis() - this.cvo >= 60000) {
            this.cvo = System.currentTimeMillis();
            try {
                bk zS = zS();
                int i = 0;
                for (bj bjVar : zS.cvk) {
                    int i2;
                    a aVar = (a) this.cvp.get(Integer.valueOf(bjVar.key));
                    if (aVar == null || !aVar.a(bjVar)) {
                        i2 = i;
                    } else {
                        i2 = 1;
                    }
                    i = i2;
                }
                if (i != 0) {
                    a(zS);
                }
            } catch (Throwable e) {
                v.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", be.e(e));
            }
        }
    }

    private static bk zS() {
        if (!(ak.yW() == null || !ak.uz() || ak.uG())) {
            ak.yW();
            if (c.vf() != null) {
                ak.yW();
                byte[] KG = be.KG((String) c.vf().get(8215, null));
                if (KG.length <= 0) {
                    return new bk();
                }
                try {
                    bk bkVar = new bk();
                    bkVar.az(KG);
                    return bkVar;
                } catch (Throwable e) {
                    v.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", be.e(e));
                }
            }
        }
        return new bk();
    }

    private static void a(bk bkVar) {
        if (bkVar != null && ak.yW() != null && ak.uz()) {
            ak.yW();
            if (c.vf() != null && !ak.uG()) {
                try {
                    ak.yW();
                    c.vf().set(8215, be.bn(bkVar.toByteArray()));
                } catch (Throwable e) {
                    v.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", be.e(e));
                }
            }
        }
    }
}
