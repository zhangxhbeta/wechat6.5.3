package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.protocal.c.azi;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class e extends BaseAdapter {
    public static int lJW = 44;
    public static int lJX = 5;
    boolean bhx;
    private List<String> bir = new ArrayList();
    o ePs;
    c eRX;
    boolean eRm;
    com.tencent.mm.ae.a.a.c eSp = null;
    private List<u> elf = new ArrayList();
    private LinkedList<azi> klq;
    a lJY;
    private ArrayList<u> lJZ = new ArrayList();
    boolean lKa = false;
    public boolean lKb = false;
    public boolean lKc = false;
    private List<j> lKd = new ArrayList();
    private Set<String> lKe = new HashSet();
    int lKf = 0;
    int lKg = 0;
    d lKh;
    public boolean lKi = false;
    public boolean lKj = false;
    public boolean lKk = false;
    private boolean lKl = true;
    boolean lKm = false;
    int lKn = 12;
    private boolean lKo = false;
    boolean lKp = false;
    String lKq;
    private String lKr;
    private boolean lKs = false;
    private final int lKt;
    public boolean lKu = false;
    private boolean lKv = true;
    private boolean lKw = false;
    boolean lKx = true;
    public boolean lKy = false;
    private Context mContext;
    String username;

    public interface a {
        void bpj();
    }

    class b {
        public ImageView dtX;
        public int eKg;
        public TextView eSr;
        public TextView euh;
        public ImageView euk;
        public ImageView iNg;
        final /* synthetic */ e lKA;
        public ImageView lKz;

        b(e eVar) {
            this.lKA = eVar;
        }
    }

    public e(Context context) {
        this.mContext = context;
        this.eRm = false;
        this.lKt = context.getResources().getDimensionPixelSize(2131492962);
        this.eRX = ak.yW();
    }

    public final boolean bpk() {
        if (this.lKa) {
            return this.lKc;
        }
        return m.dE(this.username);
    }

    public final void bt(List<String> list) {
        this.lKl = true;
        this.bir = list;
    }

    public final void W(ArrayList<u> arrayList) {
        this.lKl = false;
        this.lJZ = arrayList;
    }

    private void bpl() {
        if (this.lJZ != null) {
            v.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", Integer.valueOf(this.lJZ.size()));
            this.lKe.clear();
            this.elf.clear();
            if (this.lJZ.size() > 0) {
                Iterator it = this.lJZ.iterator();
                while (it.hasNext()) {
                    u uVar = (u) it.next();
                    this.elf.add(uVar);
                    this.lKe.add(uVar.field_username);
                }
            }
            this.lKg = this.elf.size();
        }
    }

    public final boolean tV(int i) {
        if (this.eRm) {
            return false;
        }
        if (i >= this.lKg) {
            return true;
        }
        this.eRm = true;
        bpj();
        return true;
    }

    private void bpj() {
        if (this.lJY != null) {
            this.lJY.bpj();
        }
    }

    private b cs(View view) {
        b bVar = new b(this);
        bVar.lKz = (ImageView) view.findViewById(2131756321);
        bVar.dtX = (ImageView) view.findViewById(2131758936);
        bVar.iNg = (ImageView) view.findViewById(2131758937);
        bVar.euh = (TextView) view.findViewById(2131758939);
        bVar.eSr = (TextView) view.findViewById(2131758940);
        bVar.euk = (ImageView) view.findViewById(2131758938);
        bVar.dtX.setScaleType(ScaleType.CENTER_CROP);
        view.setTag(bVar);
        return bVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        j jVar;
        ab abVar;
        int i2;
        b cs;
        int dimensionPixelSize;
        if (i < this.lKg) {
            if (this.lKa) {
                jVar = (j) getItem(i);
                abVar = null;
                i2 = 0;
            } else {
                jVar = null;
                abVar = (u) getItem(i);
                i2 = 0;
            }
        } else if (i == this.lKg && this.lKj) {
            jVar = null;
            abVar = null;
            i2 = 3;
        } else if (i == this.lKg + 1 && this.lKi) {
            jVar = null;
            abVar = null;
            i2 = 4;
        } else if (i == this.lKg + 1 && this.lKk && !this.lKi) {
            jVar = null;
            abVar = null;
            i2 = 5;
        } else if (i == this.lKg + 2 && this.lKk && this.lKi) {
            jVar = null;
            abVar = null;
            i2 = 5;
        } else {
            jVar = null;
            abVar = null;
            i2 = 2;
        }
        if (view == null) {
            view = View.inflate(this.mContext, 2130904283, null);
            cs = cs(view);
        } else {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                cs = cs(view);
            } else {
                cs = bVar;
            }
        }
        if (lJX == 4 || this.lKy) {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493162);
            cs.dtX.getLayoutParams().height = dimensionPixelSize;
            cs.dtX.getLayoutParams().width = dimensionPixelSize;
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493160);
            cs.dtX.getLayoutParams().height = dimensionPixelSize;
            cs.dtX.getLayoutParams().width = dimensionPixelSize;
        }
        cs.lKz.setVisibility(8);
        if (i2 == 0) {
            CharSequence er;
            cs.dtX.setVisibility(0);
            if (this.bhx) {
                if (be.kS(abVar.field_conRemark)) {
                    String str = abVar.field_username;
                    if (this.ePs == null) {
                        Object obj = null;
                    } else {
                        er = this.ePs.er(str);
                    }
                } else {
                    er = abVar.field_conRemark;
                }
                if (be.kS(er)) {
                    er = abVar.field_conRemark;
                }
                if (be.kS(er)) {
                    er = abVar.tT();
                }
                er = com.tencent.mm.pluginsdk.ui.d.e.a(this.mContext, er, cs.euh.getTextSize());
            } else if (this.lKa) {
                er = com.tencent.mm.pluginsdk.ui.d.e.a(this.mContext, jVar.field_userName, cs.euh.getTextSize());
            } else {
                er = com.tencent.mm.pluginsdk.ui.d.e.a(this.mContext, abVar.tU(), cs.euh.getTextSize());
            }
            if (er instanceof SpannableString) {
                cs.euh.setVisibility(8);
                cs.eSr.setVisibility(0);
                cs.eSr.setText(er);
            } else {
                cs.euh.setVisibility(0);
                cs.eSr.setVisibility(8);
                cs.euh.setText(er);
            }
            cs.dtX.setContentDescription(SQLiteDatabase.KeyEmpty);
            if (this.lKa) {
                n.GL().a(jVar.field_headImageUrl, cs.dtX, this.eSp);
                cs.dtX.setBackgroundDrawable(null);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.m(cs.dtX, abVar.field_username);
                com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) cs.dtX.getDrawable();
                if (this.lKh != null) {
                    this.lKh.a(aVar);
                }
            }
            if (this.lKa) {
                if (!this.eRm || (this.lKq != null && this.lKq.equals(jVar.field_userId))) {
                    cs.iNg.setVisibility(8);
                } else {
                    cs.iNg.setVisibility(0);
                }
            } else if (!this.eRm || (this.lKq != null && this.lKq.equals(abVar.field_username))) {
                cs.iNg.setVisibility(8);
            } else {
                cs.iNg.setVisibility(0);
            }
        } else if (i2 == 3) {
            cs.euh.setVisibility(i == 0 ? 8 : 4);
            r6 = cs.eSr;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            cs.iNg.setVisibility(8);
            if (this.eRm) {
                cs.dtX.setVisibility(4);
            } else {
                cs.dtX.setVisibility(0);
                if (this.lKa) {
                    n.GL().a(SQLiteDatabase.KeyEmpty, cs.dtX, this.eSp);
                    cs.dtX.setBackgroundDrawable(null);
                }
                cs.dtX.setImageResource(2130837697);
                cs.dtX.setContentDescription(this.mContext.getString(2131230817));
            }
        } else if (i2 == 4) {
            cs.euh.setVisibility(1 == i ? 8 : 4);
            r6 = cs.eSr;
            if (1 == i) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            cs.iNg.setVisibility(8);
            if (this.eRm || this.lKg == 0) {
                cs.dtX.setVisibility(4);
            } else {
                cs.dtX.setVisibility(0);
                if (this.lKa) {
                    n.GL().a(SQLiteDatabase.KeyEmpty, cs.dtX, this.eSp);
                    cs.dtX.setBackgroundDrawable(null);
                }
                cs.dtX.setImageResource(2130837698);
                cs.dtX.setContentDescription(this.mContext.getString(2131232276));
            }
        } else if (i2 == 5) {
            r6 = cs.euh;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            r6 = cs.eSr;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            cs.iNg.setVisibility(8);
            if (this.eRm) {
                cs.dtX.setVisibility(4);
            } else {
                cs.dtX.setVisibility(0);
                if (this.lKa) {
                    n.GL().a(SQLiteDatabase.KeyEmpty, cs.dtX, this.eSp);
                    cs.dtX.setBackgroundDrawable(null);
                }
                cs.dtX.setImageResource(2130837699);
                cs.dtX.setContentDescription(this.mContext.getString(2131233894));
            }
        } else if (i2 == 2) {
            if (this.lKa) {
                n.GL().a(SQLiteDatabase.KeyEmpty, cs.dtX, this.eSp);
            }
            cs.euh.setVisibility(4);
            cs.eSr.setVisibility(4);
            cs.iNg.setVisibility(8);
            cs.dtX.setVisibility(4);
            cs.dtX.setImageResource(2130838689);
            cs.dtX.setBackgroundResource(2130838689);
        }
        if (!this.lKa) {
            cs.euk.setVisibility(8);
        } else if (jVar != null) {
            ImageView imageView = cs.euk;
            String str2 = jVar.field_userId;
            if (!(this.lKa || this.klq == null || this.klq.isEmpty())) {
                Iterator it = this.klq.iterator();
                while (it.hasNext()) {
                    if (str2.equals(((azi) it.next()).gln)) {
                        imageView.setVisibility(0);
                        if (this.lKs) {
                            imageView.setImageResource(2130839348);
                        } else {
                            imageView.setImageResource(2130839274);
                        }
                    }
                }
            }
            if (this.lKp && this.lKr != null && !be.kS(this.lKr) && this.lKr.equals(str2)) {
                imageView.setBackgroundResource(2130838071);
                imageView.setVisibility(0);
            } else if (!this.lKo || this.lKq == null || be.kS(this.lKq) || !this.lKq.equals(str2)) {
                imageView.setVisibility(8);
            } else {
                imageView.setBackgroundResource(2130838072);
                imageView.setVisibility(0);
            }
        } else {
            cs.euk.setVisibility(8);
        }
        cs.eKg = i2;
        return view;
    }

    public final boolean tW(int i) {
        return i < this.lKg;
    }

    public final void notifyChanged() {
        if (this.bir != null || this.lJZ != null) {
            if (!be.kS(this.username) && this.bhx) {
                if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
                    this.klq = com.tencent.mm.pluginsdk.j.a.lxG.CC(this.username);
                }
                boolean z = com.tencent.mm.pluginsdk.j.a.lxQ != null && com.tencent.mm.pluginsdk.j.a.lxQ.vJ(this.username);
                this.lKs = z;
            }
            if (!this.lKl) {
                bpl();
            } else if (this.bir != null) {
                v.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", Integer.valueOf(this.bir.size()));
                this.lKe.clear();
                this.elf.clear();
                this.lKd.clear();
                if (this.bir.size() > 0) {
                    j ig;
                    String str;
                    u uVar;
                    for (String str2 : this.bir) {
                        if (this.lKa) {
                            ig = com.tencent.mm.modelbiz.u.DC().ig(str2);
                            if (!(ig == null || be.kS(ig.field_userId) || !ig.field_userId.equals(str2))) {
                                this.lKd.add(ig);
                                this.lKe.add(str2);
                            }
                        } else {
                            ab LX = c.wH().LX(str2);
                            if (!(LX == null || be.kS(LX.field_username) || !LX.field_username.equals(str2))) {
                                this.elf.add(LX);
                                this.lKe.add(str2);
                            }
                        }
                    }
                    if (this.lKe.size() < this.bir.size()) {
                        for (String str22 : this.bir) {
                            if (!this.lKe.contains(str22)) {
                                if (this.lKa) {
                                    ig = new j();
                                    ig.field_userId = str22;
                                    this.lKd.add(ig);
                                } else {
                                    this.elf.add(new u(str22));
                                }
                                this.lKe.add(str22);
                            }
                        }
                    }
                    if (this.lKv && !be.kS(this.lKq) && this.bir.contains(this.lKq)) {
                        if (!this.lKa) {
                            for (u uVar2 : this.elf) {
                                if (this.lKq.equals(uVar2.field_username)) {
                                    this.elf.remove(uVar2);
                                    this.elf.add(0, uVar2);
                                    break;
                                }
                            }
                        }
                        for (j jVar : this.lKd) {
                            if (this.lKq.equals(jVar.field_userId)) {
                                this.lKd.remove(jVar);
                                this.lKd.add(0, jVar);
                                break;
                            }
                        }
                    }
                    if (this.lKw) {
                        if (this.lKa) {
                            String ii = com.tencent.mm.modelbiz.u.DC().ii(this.username);
                            for (j jVar2 : this.lKd) {
                                if (ii.equals(jVar2.field_userId)) {
                                    this.lKd.remove(jVar2);
                                    this.lKd.add(1, jVar2);
                                    break;
                                }
                            }
                        }
                        String ah = be.ah((String) c.vf().get(2, null), SQLiteDatabase.KeyEmpty);
                        if (this.bir.contains(ah)) {
                            this.lKe.remove(ah);
                            for (u uVar22 : this.elf) {
                                if (ah.equals(uVar22.field_username)) {
                                    this.elf.remove(uVar22);
                                    break;
                                }
                            }
                        }
                        ab LX2 = c.wH().LX(ah);
                        if (LX2 == null || be.kS(LX2.field_username) || !LX2.field_username.equals(ah)) {
                            this.elf.add(1, new u(ah));
                        } else {
                            this.elf.add(1, LX2);
                        }
                        this.lKe.add(ah);
                        if (this.lKx && this.elf.size() >= 3) {
                            int i;
                            int size = this.elf.size();
                            LinkedList linkedList = new LinkedList();
                            for (i = 0; i < size; i++) {
                                uVar22 = (u) this.elf.get(i);
                                if (uVar22.field_showHead > 0) {
                                    linkedList.add(uVar22.field_showHead);
                                } else if (!be.kS(uVar22.field_conRemark)) {
                                    linkedList.add(uVar22.field_conRemark);
                                } else if (!be.kS(uVar22.field_conRemarkPYShort)) {
                                    linkedList.add(uVar22.field_conRemarkPYShort);
                                } else if (!be.kS(uVar22.field_conRemarkPYFull)) {
                                    linkedList.add(uVar22.field_conRemarkPYFull);
                                } else if (!be.kS(uVar22.pE())) {
                                    linkedList.add(uVar22.pE());
                                } else if (!be.kS(uVar22.field_username)) {
                                    linkedList.add(uVar22.field_username);
                                }
                            }
                            v.v("MicroMsg.ContactsListArchAdapter", "klem, order list:%s", linkedList.toString());
                            List arrayList = new ArrayList();
                            arrayList.add(this.elf.get(0));
                            arrayList.add(this.elf.get(1));
                            List linkedList2 = new LinkedList();
                            linkedList2.add(linkedList.get(0));
                            linkedList2.add(linkedList.get(0));
                            int size2 = this.elf.size();
                            for (i = 2; i < size2; i++) {
                                str22 = (String) linkedList.get(i);
                                int size3 = arrayList.size();
                                int i2 = 1;
                                while (i2 < size3 && str22.compareToIgnoreCase((String) linkedList2.get(i2)) >= 0) {
                                    i2++;
                                }
                                linkedList2.add(i2, str22);
                                arrayList.add(i2, this.elf.get(i));
                            }
                            this.elf.clear();
                            this.elf = arrayList;
                        }
                    }
                }
                if (this.lKa) {
                    this.lKg = this.lKd.size();
                } else if (!this.bhx) {
                    this.lKg = this.elf.size();
                } else if (be.kS(this.lKq) || !(this.lKq == null || this.lKq.equals(k.xF()))) {
                    this.lKg = this.elf.size() >= lJW ? lJW : this.elf.size();
                } else {
                    this.lKg = this.elf.size() >= lJW + -1 ? lJW - 1 : this.elf.size();
                }
            }
            if (this.lKg == 0) {
                this.lKf = lJX;
            } else if (this.lKj && this.lKi && this.lKk) {
                this.lKf = (((this.lKg + 2) / lJX) + 1) * lJX;
            } else if ((this.lKj && this.lKi && !this.lKk) || ((this.lKj && !this.lKi && this.lKk) || (!this.lKj && this.lKi && this.lKk))) {
                this.lKf = (((this.lKg + 1) / lJX) + 1) * lJX;
            } else if ((this.lKj && !this.lKi && !this.lKk) || ((!this.lKj && this.lKi && !this.lKk) || (!this.lKj && !this.lKi && this.lKk))) {
                this.lKf = ((this.lKg / lJX) + 1) * lJX;
            } else if (!(this.lKj || this.lKi || this.lKk)) {
                this.lKf = (((this.lKg - 1) / lJX) + 1) * lJX;
            }
            v.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.lKg + " realySize : " + this.lKf);
            bpj();
        }
    }

    public final int getCount() {
        if (this.lKm) {
            return Math.min(this.lKn, this.lKf);
        }
        return this.lKf;
    }

    public final Object getItem(int i) {
        if (i >= this.lKg) {
            return null;
        }
        if (this.lKa) {
            return this.lKd.get(i);
        }
        return this.elf.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
