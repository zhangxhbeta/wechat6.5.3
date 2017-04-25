package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends n implements b {
    private Cursor duo;
    private int isB = Integer.MAX_VALUE;
    private a oEI;
    private int oEJ = Integer.MAX_VALUE;
    private int oEK = Integer.MAX_VALUE;
    private int oEL = Integer.MAX_VALUE;
    private int oEM = Integer.MAX_VALUE;
    private int oEN = Integer.MAX_VALUE;
    private HashMap<String, Integer> oEO = null;
    private SparseArray<String> oEP = null;

    public static class a {
        public String oDA = "@all.contact.without.chatroom";
        public boolean oEQ = false;
        public boolean oER = false;
        public boolean oES = false;
        public boolean oET = false;
        public boolean oEU = false;
        public String oEV;
        public String oEW;
        public boolean oEX = false;
        public String oEY = SQLiteDatabase.KeyEmpty;
        public String oEZ = SQLiteDatabase.KeyEmpty;
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, a aVar) {
        super(mMBaseSelectContactUI, list, z, z2);
        v.i("MicroMsg.AlphabetContactAdapter", "create!");
        this.oEI = aVar;
        ak.yW();
        com.tencent.mm.model.c.wH().a(this);
        amB();
    }

    private void amB() {
        this.oEJ = Integer.MAX_VALUE;
        this.isB = Integer.MAX_VALUE;
        this.oEK = Integer.MAX_VALUE;
        this.oEL = Integer.MAX_VALUE;
        this.oEM = Integer.MAX_VALUE;
        this.oEN = Integer.MAX_VALUE;
        if (this.oEO != null) {
            this.oEO.clear();
        } else {
            this.oEO = new HashMap();
        }
        if (this.oEP != null) {
            this.oEP.clear();
        } else {
            this.oEP = new SparseArray();
        }
        List arrayList = new ArrayList();
        Cursor f;
        int count;
        Cursor rawQuery;
        int count2;
        String[] v;
        int[] u;
        if (this.oEI.oEU) {
            ak.yW();
            f = com.tencent.mm.model.c.wH().f(be.g(this.oEI.oEW.split(",")), false);
            arrayList.add(f);
            count = f.getCount();
            v.d("MicroMsg.AlphabetContactAdapter", "ap: recent like count %d", Integer.valueOf(count));
            if (count > 0) {
                this.oEN = 0;
                count = (count + 1) + 0;
                at(this.oEN, "☆");
            } else {
                this.oEN = Integer.MAX_VALUE;
                count = 0;
            }
            ak.yW();
            aa wH = com.tencent.mm.model.c.wH();
            rawQuery = wH.cie.rawQuery("select * ,rowid from rcontact where (" + aa.nux + ") and (" + aa.cc(be.g(this.oEI.oEV.split(","))) + ")" + aa.bvA(), null);
            arrayList.add(rawQuery);
            count2 = rawQuery.getCount();
            if (count2 > 0) {
                this.oEK = count;
                count += count2 + 1;
                at(this.oEK, "☆");
            } else {
                this.oEK = Integer.MAX_VALUE;
            }
            List g = be.g(this.oEI.oEV.split(","));
            ak.yW();
            arrayList.add(com.tencent.mm.model.c.wH().f(g, true));
            v = m.v(g);
            u = m.u(g);
            if (!(v == null || u == null)) {
                count2 = count;
                for (count = 0; count < v.length; count++) {
                    if (count < u.length) {
                        at(u[count] + count2, v[count]);
                        count2++;
                    }
                }
                f.getCount();
            }
        } else {
            Cursor bvF;
            int i;
            aa wH2;
            String str;
            String str2;
            List list;
            boolean z;
            List cC;
            if (!this.oEI.oEX || this.oEI.oEY == null) {
                if (this.oEI.oEQ) {
                    cC = g.cC(this.ejp);
                    if (cC.size() == 0) {
                        ak.yW();
                        bvF = com.tencent.mm.model.c.wH().bvF();
                    } else {
                        ak.yW();
                        bvF = com.tencent.mm.model.c.wH().bY(cC);
                    }
                    arrayList.add(bvF);
                    count = bvF.getCount();
                    if (count > 0) {
                        this.isB = 0;
                        count = (count + 1) + 0;
                        at(this.isB, "↑");
                    } else {
                        this.isB = Integer.MAX_VALUE;
                    }
                }
                count = 0;
            } else {
                cC = be.g(this.oEI.oEY.split(";"));
                ak.yW();
                bvF = com.tencent.mm.model.c.wH().bY(cC);
                arrayList.add(bvF);
                count = bvF.getCount();
                if (count > 0) {
                    this.oEJ = 0;
                    count = (count + 1) + 0;
                    at(this.isB, "↑");
                } else {
                    this.oEJ = Integer.MAX_VALUE;
                    count = 0;
                }
            }
            if (this.oEI.oER) {
                ak.yW();
                rawQuery = com.tencent.mm.model.c.wH().cd(this.ejp);
                arrayList.add(rawQuery);
                count2 = rawQuery.getCount();
                if (count2 > 0) {
                    this.oEK = count;
                    count += count2 + 1;
                    at(this.oEK, "☆");
                    i = count;
                    ak.yW();
                    wH2 = com.tencent.mm.model.c.wH();
                    str = this.oEI.oDA;
                    str2 = SQLiteDatabase.KeyEmpty;
                    list = this.ejp;
                    if (this.oHp) {
                        z = true;
                    } else {
                        z = false;
                    }
                    f = wH2.a(str, str2, list, false, z);
                    arrayList.add(f);
                    v = m.a(this.oEI.oDA, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, this.ejp);
                    u = m.a(this.oEI.oDA, SQLiteDatabase.KeyEmpty, this.ejp, SQLiteDatabase.KeyEmpty);
                    if (!(v == null || u == null)) {
                        count2 = i;
                        for (count = 0; count < v.length; count++) {
                            if (count < u.length) {
                                at(u[count] + count2, v[count]);
                                count2++;
                            }
                        }
                        i += f.getCount() + v.length;
                    }
                    if (this.oEI.oES) {
                        ak.yW();
                        bvF = com.tencent.mm.model.c.wH().c("@all.chatroom.contact", SQLiteDatabase.KeyEmpty, this.ejp);
                        arrayList.add(bvF);
                        count = bvF.getCount();
                        if (count <= 0) {
                            this.oEL = i;
                            i += count + 1;
                            at(this.oEL, this.oGZ.getActivity().getString(2131230838));
                        } else {
                            this.oEL = Integer.MAX_VALUE;
                        }
                    }
                    if (this.oEI.oET) {
                        ak.yW();
                        bvF = com.tencent.mm.model.c.wH().c("@verify.contact", SQLiteDatabase.KeyEmpty, this.ejp);
                        arrayList.add(bvF);
                        if (bvF.getCount() <= 0) {
                            this.oEM = i;
                            at(this.oEM, this.oGZ.getActivity().getString(2131230868));
                        } else {
                            this.oEM = Integer.MAX_VALUE;
                        }
                    }
                } else {
                    this.oEK = Integer.MAX_VALUE;
                }
            }
            i = count;
            ak.yW();
            wH2 = com.tencent.mm.model.c.wH();
            str = this.oEI.oDA;
            str2 = SQLiteDatabase.KeyEmpty;
            list = this.ejp;
            if (this.oHp) {
                z = false;
            } else {
                z = true;
            }
            f = wH2.a(str, str2, list, false, z);
            arrayList.add(f);
            v = m.a(this.oEI.oDA, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, this.ejp);
            u = m.a(this.oEI.oDA, SQLiteDatabase.KeyEmpty, this.ejp, SQLiteDatabase.KeyEmpty);
            count2 = i;
            for (count = 0; count < v.length; count++) {
                if (count < u.length) {
                    at(u[count] + count2, v[count]);
                    count2++;
                }
            }
            i += f.getCount() + v.length;
            if (this.oEI.oES) {
                ak.yW();
                bvF = com.tencent.mm.model.c.wH().c("@all.chatroom.contact", SQLiteDatabase.KeyEmpty, this.ejp);
                arrayList.add(bvF);
                count = bvF.getCount();
                if (count <= 0) {
                    this.oEL = Integer.MAX_VALUE;
                } else {
                    this.oEL = i;
                    i += count + 1;
                    at(this.oEL, this.oGZ.getActivity().getString(2131230838));
                }
            }
            if (this.oEI.oET) {
                ak.yW();
                bvF = com.tencent.mm.model.c.wH().c("@verify.contact", SQLiteDatabase.KeyEmpty, this.ejp);
                arrayList.add(bvF);
                if (bvF.getCount() <= 0) {
                    this.oEM = Integer.MAX_VALUE;
                } else {
                    this.oEM = i;
                    at(this.oEM, this.oGZ.getActivity().getString(2131230868));
                }
            }
        }
        v.d("MicroMsg.AlphabetContactAdapter", "headerPosMap=%s", this.oEO.toString());
        this.duo = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
    }

    private void at(int i, String str) {
        this.oEO.put(str, Integer.valueOf(i));
        this.oEP.put(i, str);
    }

    public final int Pd(String str) {
        if (str.equals("↑")) {
            return 0;
        }
        if (this.oEO == null || !this.oEO.containsKey(str)) {
            return -1;
        }
        return ((Integer) this.oEO.get(str)).intValue() + this.oGZ.aQr().getHeaderViewsCount();
    }

    public final int getCount() {
        return this.duo.getCount() + this.oEO.size();
    }

    protected final com.tencent.mm.ui.contact.a.a gK(int i) {
        if (i == this.oEN) {
            return au(i, this.oGZ.getActivity().getString(2131230885));
        }
        if (i == this.oEJ) {
            return au(i, this.oEI.oEZ);
        }
        if (i == this.isB) {
            return au(i, this.oGZ.getActivity().getString(2131230866));
        }
        if (i == this.oEK) {
            return au(i, this.oGZ.getActivity().getString(2131230852));
        }
        if (i == this.oEL) {
            return au(i, this.oGZ.getActivity().getString(2131230838));
        }
        if (i == this.oEM) {
            return au(i, this.oGZ.getActivity().getString(2131230868));
        }
        if (this.oEP.indexOfKey(i) >= 0) {
            return au(i, (String) this.oEP.get(i));
        }
        int i2 = i;
        int i3 = 0;
        while (i3 <= this.oEP.size()) {
            if (this.oEP.indexOfKey(i2) >= 0) {
                i3++;
            }
            i2--;
            if (i2 < 0) {
                break;
            }
        }
        if (this.duo.moveToPosition(i - i3)) {
            v.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i3));
            u uVar = new u();
            uVar.b(this.duo);
            com.tencent.mm.ui.contact.a.a dVar = new d(i);
            dVar.euW = uVar;
            dVar.oHa = aQk();
            return dVar;
        }
        v.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i3));
        return null;
    }

    private static com.tencent.mm.ui.contact.a.a au(int i, String str) {
        com.tencent.mm.ui.contact.a.a fVar = new f(i);
        fVar.oJx = str;
        return fVar;
    }

    public final void finish() {
        super.finish();
        v.i("MicroMsg.AlphabetContactAdapter", "finish!");
        if (this.duo != null) {
            this.duo.close();
            this.duo = null;
        }
        ak.yW();
        com.tencent.mm.model.c.wH().b(this);
    }

    public final void a(int i, j jVar, Object obj) {
        amB();
        notifyDataSetChanged();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.oEN, this.oEJ, this.isB, this.oEK, this.oEL, this.oEM};
        for (int i2 = 0; i2 < 6; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        if (this.oEP.indexOfKey(i) < 0) {
            return false;
        }
        return true;
    }
}
