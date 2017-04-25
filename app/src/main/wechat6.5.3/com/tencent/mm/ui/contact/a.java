package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.m.a.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.j;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.q;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a extends e<String, f> implements com.tencent.mm.sdk.h.j.b {
    public static final ColorStateList gQF = com.tencent.mm.bd.a.M(aa.getContext(), 2131690159);
    public static final ColorStateList gQG = com.tencent.mm.bd.a.M(aa.getContext(), 2131689792);
    com.tencent.mm.ui.applet.b cHD = null;
    private String dwS = SQLiteDatabase.KeyEmpty;
    protected List<String> ejp = null;
    protected MMSlideDelView.f euc;
    protected c eud;
    protected d euf = MMSlideDelView.bCp();
    boolean eyB = false;
    OnClickListener fQr = new OnClickListener(this) {
        final /* synthetic */ a oDV;

        {
            this.oDV = r1;
        }

        public final void onClick(View view) {
            v.v("MicroMsg.AddressAdapter", "on delView clicked");
            this.oDV.euf.avn();
            if (this.oDV.hGa != null) {
                this.oDV.hGa.aE(((ViewStub) this.oDV.oDR.get(view)).getTag());
            }
        }
    };
    protected MMSlideDelView.e hGa;
    protected String oDA = null;
    protected String oDB = null;
    private List<Object> oDC;
    private List<String> oDD;
    private int oDE = 0;
    protected int[] oDF;
    String[] oDG;
    protected com.tencent.mm.ui.contact.AddressUI.a oDH;
    private Set<Integer> oDI = new HashSet();
    private int oDJ = 0;
    private boolean oDK = true;
    a oDL;
    private boolean oDM = false;
    boolean oDN = false;
    private String oDO;
    private LinkedList<View> oDP = new LinkedList();
    private boolean oDQ;
    private HashMap<View, ViewStub> oDR = new HashMap();
    private SparseArray<String> oDS = new SparseArray();
    private SparseArray<Integer> oDT = new SparseArray();
    private HashSet<String> oDU = new HashSet();
    public HashMap<String, f> oDz = new HashMap();
    private String[] ohb = null;
    StringBuilder sb = new StringBuilder(32);
    private int type;

    public interface a {
    }

    protected static class b {
        public TextView gKV;
        public TextView gKW;
        public AddressView gQK;
        public TextView oDW;
        public View oDX;
    }

    public final /* synthetic */ void o(Object obj, int i) {
        ck((String) obj, i);
    }

    public final /* synthetic */ com.tencent.mm.m.a.a tZ() {
        return new f();
    }

    public final void ck(String str, int i) {
        if (i == 5) {
            this.oDU.add(str);
        }
        super.o(str, i);
    }

    public final void pause() {
        this.oDU.clear();
        super.pause();
    }

    public final void notifyDataSetChanged() {
        this.oDO = k.xF();
        if (this.oDF == null) {
            bHk();
        }
        if (getCount() != 0) {
            this.oDJ = byV();
            v.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", Integer.valueOf(this.oDJ));
            super.notifyDataSetChanged();
        }
    }

    public a(Context context, String str, String str2, int i) {
        super(context);
        this.context = context;
        this.oDA = str;
        this.oDB = str2;
        this.type = i;
        this.oDM = true;
        this.oDC = new LinkedList();
        this.oDD = new LinkedList();
        this.oDO = k.xF();
        this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    }

    public final void l(Fragment fragment) {
        this.oDH = (com.tencent.mm.ui.contact.AddressUI.a) fragment;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.euc = fVar;
    }

    public final void a(MMSlideDelView.e eVar) {
        this.hGa = eVar;
    }

    public final void a(c cVar) {
        this.eud = cVar;
    }

    public final void cB(List<String> list) {
        if (this.type != 2) {
            list.add(k.xF());
        }
        ak.yW();
        ax Nr = com.tencent.mm.model.c.wN().Nr("@t.qq.com");
        if (Nr != null) {
            list.add(Nr.name);
        }
        if (this.type == 3 || this.type == 5 || this.type == 4 || this.type == 1 || this.type == 0) {
            for (String add : m.yp()) {
                list.add(add);
            }
        }
        list.add("blogapp");
        this.ejp = list;
    }

    public final void k(String str, String[] strArr) {
        this.oDK = true;
        String trim = str.trim();
        if (trim.startsWith("@")) {
            trim = (this.oDA == null || this.oDA.length() <= 0) ? trim.substring(1) + "%@t.qq.com" : trim.substring(1) + "%" + this.oDA;
        }
        v.d("MicroMsg.AddressAdapter", "dkvoice [" + trim + "]");
        this.dwS = trim;
        this.ohb = null;
        ck(null, 0);
    }

    public final int getPositionForSection(int i) {
        if (this.oDF != null && i >= 0 && i < this.oDF.length) {
            i = this.oDF[i];
        }
        return this.oDJ + i;
    }

    private boolean bHj() {
        return this.oDA.equals("@micromsg.qq.com") || this.oDA.equals("@all.contact.without.chatroom");
    }

    protected final void bHk() {
        int count = getCount();
        if (count != 0) {
            int i;
            int i2;
            this.oDJ = byV();
            if (this.ohb != null) {
                this.oDF = m.a(this.oDA, this.oDB, this.ejp, this.ohb);
                this.oDG = m.a(this.oDA, this.oDB, this.ohb, this.ejp);
            } else if (ub()) {
                long currentTimeMillis = System.currentTimeMillis();
                HashSet hashSet = new HashSet();
                this.oDF = new int[30];
                this.oDG = new String[30];
                i = this.oDJ;
                int i3 = 0;
                while (i < count) {
                    f fVar = (f) en(i);
                    if (fVar != null) {
                        String b = b(fVar, i);
                        if (hashSet.add(b)) {
                            this.oDF[i3] = i - this.oDJ;
                            this.oDG[i3] = b;
                            i2 = i3 + 1;
                        }
                        i2 = i3;
                    } else {
                        v.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
                        i2 = i3;
                    }
                    i++;
                    i3 = i2;
                }
                v.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - currentTimeMillis) + "favourCount : " + this.oDJ);
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.oDF = m.a(this.oDA, this.oDB, this.ejp, this.dwS);
                this.oDG = m.a(this.oDA, this.oDB, this.dwS, this.ejp);
                v.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - currentTimeMillis2));
            }
            this.oDI.clear();
            for (int i4 : this.oDF) {
                this.oDI.add(Integer.valueOf(i4 - 1));
            }
        }
    }

    public final void bHl() {
        this.euf.avn();
    }

    public final void clearCache() {
        this.oDR.clear();
        this.oDP.clear();
        this.oDQ = false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2 = -1;
        if (!this.oDQ) {
            for (int i3 = 0; i3 < 8; i3++) {
                this.oDP.add(q.em(this.context).inflate(2130903090, null));
            }
            this.oDQ = true;
        }
        f fVar = (f) en(i);
        if (view == null) {
            View view2;
            if (this.oDP.size() > 0) {
                View view3 = (View) this.oDP.getFirst();
                this.oDP.removeFirst();
                view2 = view3;
            } else {
                view2 = View.inflate(this.context, 2130903090, null);
            }
            bVar = new b();
            bVar.gKV = (TextView) view2.findViewById(2131755332);
            bVar.gKW = (TextView) view2.findViewById(2131755334);
            bVar.gQK = (AddressView) view2.findViewById(2131755336);
            bVar.oDW = (TextView) view2.findViewById(2131755335);
            bVar.oDX = view2.findViewById(2131755333);
            this.oDH.ePu.a(bVar.gQK);
            view2.setTag(bVar);
            view = view2;
        } else {
            bVar = (b) view.getTag();
        }
        if (fVar != null) {
            CharSequence b;
            String eJ;
            Context context;
            long longValue;
            String str;
            Object obj;
            f fVar2 = (f) en(i - 1);
            f fVar3 = (f) en(i + 1);
            int a = fVar2 == null ? -1 : a(fVar2, i - 1);
            int a2 = a(fVar, i);
            if (fVar3 != null) {
                i2 = a(fVar3, i + 1);
            }
            if (this.oDK) {
                if (i == 0) {
                    b = b(fVar, i);
                    if (!t.kS(b)) {
                        bVar.gKV.setVisibility(0);
                        bVar.gKV.setText(b);
                        if (!this.oDK || a2 == r3) {
                            bVar.oDX.setBackgroundResource(2130838468);
                        }
                        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.gQK, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.gQK.setMaskBitmap(null);
                        } else if (com.tencent.mm.model.ab.a.csb != null) {
                            eJ = com.tencent.mm.model.ab.a.csb.eJ(fVar.field_verifyFlag);
                            if (eJ != null) {
                                bVar.gQK.setMaskBitmap(j.hL(eJ));
                            } else {
                                bVar.gQK.setMaskBitmap(null);
                            }
                        } else {
                            bVar.gQK.setMaskBitmap(null);
                        }
                        bVar.gQK.updateTextColors();
                        b = fVar.nnS;
                        if (b == null) {
                            try {
                                context = this.context;
                                if (fVar.field_conRemark != null || fVar.field_conRemark.trim().equals(SQLiteDatabase.KeyEmpty)) {
                                    b = com.tencent.mm.i.a.dJ(fVar.field_username);
                                    if (b == null) {
                                        if (fVar.field_nickname != null || fVar.field_nickname.length() <= 0) {
                                            b = fVar.field_alias;
                                            if (be.kS(b)) {
                                                b = fVar.field_username;
                                                if (b != null) {
                                                    b = null;
                                                } else if (!b.toLowerCase().endsWith("@t.qq.com")) {
                                                    b = "@" + b.replace("@t.qq.com", SQLiteDatabase.KeyEmpty);
                                                } else if (b.toLowerCase().endsWith("@qqim")) {
                                                    b = b.replace("@qqim", SQLiteDatabase.KeyEmpty);
                                                    longValue = Long.valueOf(b).longValue();
                                                    if (longValue < 0) {
                                                        b = new o(longValue).toString();
                                                    }
                                                }
                                                if (b == null || b.length() == 0) {
                                                    b = fVar.field_username;
                                                }
                                            }
                                        } else {
                                            b = fVar.field_nickname;
                                        }
                                    }
                                } else {
                                    b = fVar.field_conRemark;
                                }
                                str = fVar.field_username;
                                if (b == null || b.length() <= 0) {
                                    obj = str;
                                }
                                str = SQLiteDatabase.KeyEmpty;
                                if (str.length() > 0 && !str.equals(b)) {
                                    this.sb.append(b);
                                    this.sb.append("(");
                                    this.sb.append(str);
                                    this.sb.append(")");
                                    b = this.sb.toString();
                                    this.sb.delete(0, this.sb.length());
                                }
                                b = com.tencent.mm.pluginsdk.ui.d.e.a(context, b, com.tencent.mm.bd.a.N(this.context, 2131493169));
                            } catch (Exception e) {
                                b = null;
                            }
                            if (b == null) {
                                b = SQLiteDatabase.KeyEmpty;
                            }
                            bVar.gQK.setName(b);
                        } else {
                            bVar.gQK.setName(b);
                        }
                        bVar.gQK.setDescription(t.ma(fVar.field_remarkDesc));
                    }
                } else if (i > 0 && a2 != a) {
                    b = b(fVar, i);
                    if (!t.kS(b)) {
                        bVar.gKV.setVisibility(0);
                        bVar.gKV.setText(b);
                        bVar.oDX.setBackgroundResource(2130838468);
                        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.gQK, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.gQK.setMaskBitmap(null);
                        } else if (com.tencent.mm.model.ab.a.csb != null) {
                            bVar.gQK.setMaskBitmap(null);
                        } else {
                            eJ = com.tencent.mm.model.ab.a.csb.eJ(fVar.field_verifyFlag);
                            if (eJ != null) {
                                bVar.gQK.setMaskBitmap(null);
                            } else {
                                bVar.gQK.setMaskBitmap(j.hL(eJ));
                            }
                        }
                        bVar.gQK.updateTextColors();
                        b = fVar.nnS;
                        if (b == null) {
                            bVar.gQK.setName(b);
                        } else {
                            context = this.context;
                            if (fVar.field_conRemark != null) {
                            }
                            b = com.tencent.mm.i.a.dJ(fVar.field_username);
                            if (b == null) {
                                if (fVar.field_nickname != null) {
                                }
                                b = fVar.field_alias;
                                if (be.kS(b)) {
                                    b = fVar.field_username;
                                    if (b != null) {
                                        b = null;
                                    } else if (!b.toLowerCase().endsWith("@t.qq.com")) {
                                        b = "@" + b.replace("@t.qq.com", SQLiteDatabase.KeyEmpty);
                                    } else if (b.toLowerCase().endsWith("@qqim")) {
                                        b = b.replace("@qqim", SQLiteDatabase.KeyEmpty);
                                        longValue = Long.valueOf(b).longValue();
                                        if (longValue < 0) {
                                            b = new o(longValue).toString();
                                        }
                                    }
                                    b = fVar.field_username;
                                }
                            }
                            str = fVar.field_username;
                            obj = str;
                            str = SQLiteDatabase.KeyEmpty;
                            this.sb.append(b);
                            this.sb.append("(");
                            this.sb.append(str);
                            this.sb.append(")");
                            b = this.sb.toString();
                            this.sb.delete(0, this.sb.length());
                            b = com.tencent.mm.pluginsdk.ui.d.e.a(context, b, com.tencent.mm.bd.a.N(this.context, 2131493169));
                            if (b == null) {
                                b = SQLiteDatabase.KeyEmpty;
                            }
                            bVar.gQK.setName(b);
                        }
                        bVar.gQK.setDescription(t.ma(fVar.field_remarkDesc));
                    }
                }
            }
            bVar.gKV.setVisibility(8);
            bVar.oDX.setBackgroundResource(2130838468);
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.gQK, fVar.field_username);
            if (fVar.field_verifyFlag != 0) {
                bVar.gQK.setMaskBitmap(null);
            } else if (com.tencent.mm.model.ab.a.csb != null) {
                eJ = com.tencent.mm.model.ab.a.csb.eJ(fVar.field_verifyFlag);
                if (eJ != null) {
                    bVar.gQK.setMaskBitmap(j.hL(eJ));
                } else {
                    bVar.gQK.setMaskBitmap(null);
                }
            } else {
                bVar.gQK.setMaskBitmap(null);
            }
            bVar.gQK.updateTextColors();
            b = fVar.nnS;
            if (b == null) {
                context = this.context;
                if (fVar.field_conRemark != null) {
                }
                b = com.tencent.mm.i.a.dJ(fVar.field_username);
                if (b == null) {
                    if (fVar.field_nickname != null) {
                    }
                    b = fVar.field_alias;
                    if (be.kS(b)) {
                        b = fVar.field_username;
                        if (b != null) {
                            b = null;
                        } else if (!b.toLowerCase().endsWith("@t.qq.com")) {
                            b = "@" + b.replace("@t.qq.com", SQLiteDatabase.KeyEmpty);
                        } else if (b.toLowerCase().endsWith("@qqim")) {
                            b = b.replace("@qqim", SQLiteDatabase.KeyEmpty);
                            longValue = Long.valueOf(b).longValue();
                            if (longValue < 0) {
                                b = new o(longValue).toString();
                            }
                        }
                        b = fVar.field_username;
                    }
                }
                str = fVar.field_username;
                obj = str;
                str = SQLiteDatabase.KeyEmpty;
                this.sb.append(b);
                this.sb.append("(");
                this.sb.append(str);
                this.sb.append(")");
                b = this.sb.toString();
                this.sb.delete(0, this.sb.length());
                b = com.tencent.mm.pluginsdk.ui.d.e.a(context, b, com.tencent.mm.bd.a.N(this.context, 2131493169));
                if (b == null) {
                    b = SQLiteDatabase.KeyEmpty;
                }
                bVar.gQK.setName(b);
            } else {
                bVar.gQK.setName(b);
            }
            bVar.gQK.setDescription(t.ma(fVar.field_remarkDesc));
        }
        bVar.gQK.updatePositionFlag();
        bVar.gQK.setContentDescription(bVar.gQK.getNickName() == null ? SQLiteDatabase.KeyEmpty : bVar.gQK.getNickName().toString());
        return view;
    }

    private int a(f fVar, int i) {
        if (i < this.oDJ) {
            return 32;
        }
        if (fVar != null) {
            return fVar.field_showHead;
        }
        v.e("MicroMsg.AddressAdapter", "contact is null, position:%d", Integer.valueOf(i));
        return -1;
    }

    private String b(f fVar, int i) {
        if (i < this.oDJ) {
            return getString(2131230852);
        }
        if (fVar.field_showHead == 31) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (fVar.field_showHead == 123) {
            return "#";
        }
        if (fVar.field_showHead == 33) {
            return getString(2131230834);
        }
        if (fVar.field_showHead == 43) {
            return getString(2131234604);
        }
        if (fVar.field_showHead == 32) {
            return getString(2131230852);
        }
        String str = (String) this.oDS.get(fVar.field_showHead);
        if (str != null) {
            return str;
        }
        str = String.valueOf((char) fVar.field_showHead);
        this.oDS.put(fVar.field_showHead, str);
        return str;
    }

    public final int getCount() {
        return super.getCount();
    }

    private String getString(int i) {
        String str = (String) this.oDS.get(i);
        if (str != null) {
            return str;
        }
        str = this.context.getString(i);
        this.oDS.put(i, str);
        return str;
    }

    public final com.tencent.mm.m.a.d<String> byW() {
        long currentTimeMillis = System.currentTimeMillis();
        List linkedList = new LinkedList();
        linkedList.add("weixin");
        ak.yW();
        Cursor a = com.tencent.mm.model.c.wH().a(this.oDA, this.oDB, this.ejp, linkedList, bHj(), this.oDM);
        v.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        return (com.tencent.mm.m.a.d) a;
    }

    public final ArrayList<f> e(ArrayList<String> arrayList) {
        long currentTimeMillis = System.currentTimeMillis();
        List arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add((String) arrayList.get(i));
        }
        ArrayList<f> arrayList3 = new ArrayList(arrayList2.size());
        ak.yW();
        Cursor bX = com.tencent.mm.model.c.wH().bX(arrayList2);
        while (bX.moveToNext()) {
            f fVar = new f();
            fVar.b(bX);
            arrayList3.add(fVar);
        }
        bX.close();
        v.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList3;
    }

    public final SparseArray<String>[] a(HashSet<com.tencent.mm.ui.e.b<String, f>> hashSet, SparseArray<String>[] sparseArrayArr) {
        Cursor aH;
        SparseArray<String>[] sparseArrayArr2 = new SparseArray[sparseArrayArr.length];
        List linkedList = new LinkedList();
        linkedList.add("weixin");
        long currentTimeMillis = System.currentTimeMillis();
        ak.yW();
        com.tencent.mm.storage.aa wH = com.tencent.mm.model.c.wH();
        String str = this.oDA;
        String str2 = this.oDB;
        List list = this.ejp;
        boolean bHj = bHj();
        boolean z = this.oDM;
        str = "select username from rcontact " + com.tencent.mm.storage.aa.e(str, str2, list) + com.tencent.mm.storage.aa.cb(linkedList) + com.tencent.mm.storage.aa.bvz();
        v.v("MicroMsg.ContactStorage", str);
        if (bHj) {
            g[] gVarArr = new g[2];
            String str3 = "select username from rcontact " + com.tencent.mm.storage.aa.g(list, z) + com.tencent.mm.storage.aa.bvA();
            v.v("MicroMsg.ContactStorage", "favourSql " + str);
            Cursor aH2 = wH.cie.aH(str3, true);
            aH = wH.cie.aH(str, true);
            if ((aH2 instanceof g) && (aH instanceof g)) {
                gVarArr[0] = (g) aH2;
                gVarArr[1] = (g) aH;
                aH = new com.tencent.mm.m.a.e(gVarArr);
            } else {
                aH = com.tencent.mm.bg.c.bxW();
            }
        } else {
            aH = wH.cie.rawQuery(str, null);
        }
        int i;
        if (aH instanceof com.tencent.mm.m.a.e) {
            com.tencent.mm.m.a.d[] dVarArr = ((com.tencent.mm.m.a.e) aH).chG;
            int length = dVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                i = 0;
                dVarArr[i2].eo(5000);
                sparseArrayArr2[i2] = new SparseArray();
                while (dVarArr[i2].moveToNext()) {
                    sparseArrayArr2[i2].put(i, dVarArr[i2].getString(0));
                    i++;
                }
            }
            this.oDJ = dVarArr[0].getCount();
        } else {
            i = 0;
            sparseArrayArr2[0] = new SparseArray();
            while (aH.moveToNext()) {
                sparseArrayArr2[0].put(i, aH.getString(0));
                i++;
            }
        }
        aH.close();
        v.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - currentTimeMillis));
        return sparseArrayArr2;
    }

    public final void bHm() {
        super.o(null, 1);
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            v.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
            return;
        }
        ak.yW();
        if (jVar != com.tencent.mm.model.c.wH()) {
            return;
        }
        if (m.eB((String) obj) || this.oDU.contains((String) obj)) {
            v.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
            return;
        }
        super.o((String) obj, 2);
        if (this.oDN && this.oDH != null) {
            this.oDH.oEr = true;
            v.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
        }
    }
}
