package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.j.n;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class a extends j<ab> implements com.tencent.mm.sdk.h.j.b {
    private static long oKs = 2000;
    private String dwS;
    protected List<String> ejp = null;
    protected com.tencent.mm.ui.base.MMSlideDelView.f euc;
    protected com.tencent.mm.ui.base.MMSlideDelView.c eud;
    protected com.tencent.mm.ui.base.MMSlideDelView.e eue;
    protected com.tencent.mm.ui.base.MMSlideDelView.d euf = MMSlideDelView.bCp();
    private boolean gYJ = false;
    boolean jFG = false;
    private boolean oKd = true;
    private f oKe;
    private com.tencent.mm.pluginsdk.ui.d oKf;
    private boolean oKg = false;
    private boolean oKh = false;
    private boolean oKi = false;
    private boolean oKj = false;
    private c oKk;
    private com.tencent.mm.sdk.c.c oKl = null;
    private b oKm = null;
    public String oKn = SQLiteDatabase.KeyEmpty;
    final e oKo = new e(this);
    private final int oKp;
    private final int oKq;
    private a oKr;
    private boolean oKt = false;
    private ah oKu = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ a oKv;

        {
            this.oKv = r1;
        }

        public final boolean oU() {
            if (this.oKv.oKt) {
                this.oKv.bIe();
            }
            return false;
        }
    }, false);
    private float ohi = -1.0f;
    private float ohj = -1.0f;
    private float ohk = -1.0f;
    private ColorStateList[] ohl = new ColorStateList[5];
    private HashMap<String, d> ohm;

    private class a {
        public String aGX;
        public String content;
        final /* synthetic */ a oKv;
        public int oKw;
        public String oKx;

        private a(a aVar) {
            this.oKv = aVar;
        }
    }

    public interface b {
    }

    private class d {
        public int eKg;
        public boolean lCM;
        public CharSequence nickName;
        public int oKA;
        public int oKB;
        public int oKC;
        public boolean oKD;
        public boolean oKE;
        public boolean oKF;
        public boolean oKG;
        public boolean oKH;
        public boolean oKI;
        public int oKJ;
        final /* synthetic */ a oKv;
        public CharSequence oKy;
        public CharSequence oKz;
        public boolean ohn;
        public boolean onP;

        private d(a aVar) {
            this.oKv = aVar;
        }
    }

    private class e {
        String bdo;
        boolean cit;
        u euW;
        Integer oKK;
        final /* synthetic */ a oKv;

        public e(a aVar) {
            this.oKv = aVar;
            this.cit = false;
            this.bdo = null;
            this.cit = false;
            this.euW = null;
            this.oKK = null;
        }
    }

    public interface f {
    }

    public static class g {
        public ImageView dtX;
        public TextView eul;
        public ImageView oKL;
        public NoMeasuredTextView ohq;
        public NoMeasuredTextView ohr;
        public NoMeasuredTextView ohs;
        public ImageView oht;
        public ImageView ohu;
        public View ohv;
    }

    private class c implements com.tencent.mm.sdk.h.j.b {
        final /* synthetic */ a oKv;

        public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                v.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
                return;
            }
            String str = (String) obj;
            if (!this.oKv.oKg && str != null && !str.equals(SQLiteDatabase.KeyEmpty) && this.oKv.ohm != null && this.oKv.ohm.containsKey(Integer.valueOf(i))) {
                this.oKv.ohm.remove(Integer.valueOf(i));
                this.oKv.oKj = true;
            }
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ab) obj;
        if (this.gYJ) {
            if (cursor.getString(0) != null && cursor.getString(0).equals("1")) {
                if (obj == null) {
                    obj = new ab();
                }
                obj.cu(SQLiteDatabase.KeyEmpty);
                obj.cv(SQLiteDatabase.KeyEmpty);
                obj.b(cursor);
                return obj;
            } else if (cursor.getString(0).equals("2")) {
                ak.yW();
                com.tencent.mm.e.b.ab LS = com.tencent.mm.model.c.wH().LS(u.f(cursor));
                if (LS == null) {
                    LS = new u();
                    LS.b(cursor);
                    ak.yW();
                    com.tencent.mm.model.c.wH().K(LS);
                }
                if (obj == null) {
                    obj = new ab();
                }
                obj.dh(2);
                obj.s(-1);
                obj.di(1);
                obj.setContent(this.context.getString(2131232999));
                obj.setUsername(LS.field_username);
                obj.df(0);
                obj.ct(Integer.toString(1));
                obj.cu(SQLiteDatabase.KeyEmpty);
                obj.cv(SQLiteDatabase.KeyEmpty);
                return obj;
            }
        }
        if (obj == null) {
            obj = new ab();
        }
        obj.cu(SQLiteDatabase.KeyEmpty);
        obj.cv(SQLiteDatabase.KeyEmpty);
        obj.b(cursor);
        return obj;
    }

    public a(Context context, com.tencent.mm.ui.j.a aVar) {
        super(context, new ab());
        this.nDK = aVar;
        this.ohl[0] = com.tencent.mm.bd.a.M(context, 2131689792);
        this.ohl[1] = com.tencent.mm.bd.a.M(context, 2131690164);
        this.ohl[3] = com.tencent.mm.bd.a.M(context, 2131689909);
        this.ohl[2] = com.tencent.mm.bd.a.M(context, 2131690161);
        this.ohl[2] = com.tencent.mm.bd.a.M(context, 2131690161);
        this.ohl[4] = com.tencent.mm.bd.a.M(context, 2131689816);
        this.ohm = new HashMap();
        if (com.tencent.mm.bd.a.dt(context)) {
            this.oKq = context.getResources().getDimensionPixelSize(2131493010);
            this.oKp = context.getResources().getDimensionPixelSize(2131493011);
        } else {
            this.oKq = context.getResources().getDimensionPixelSize(2131493009);
            this.oKp = context.getResources().getDimensionPixelSize(2131493012);
        }
        this.ohi = (float) com.tencent.mm.bd.a.N(context, 2131493169);
        this.ohj = (float) com.tencent.mm.bd.a.N(context, 2131493128);
        this.ohk = (float) com.tencent.mm.bd.a.N(context, com.tencent.mm.bi.a.b.peS);
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.f fVar) {
        this.euc = fVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.e eVar) {
        this.eue = eVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.eud = cVar;
    }

    public void detach() {
    }

    private CharSequence i(ab abVar) {
        if (abVar.field_status == 1) {
            return this.context.getString(2131233725);
        }
        return abVar.field_conversationTime == Long.MAX_VALUE ? SQLiteDatabase.KeyEmpty : o.c(this.context, abVar.field_conversationTime, true);
    }

    protected final void Om() {
        Ol();
    }

    public final void onPause() {
        if (this.euf != null) {
            this.euf.avm();
        }
        this.oKg = false;
    }

    private void bId() {
        if (this.ohm != null) {
            for (Entry value : this.ohm.entrySet()) {
                ((d) value.getValue()).oKy = null;
            }
        }
    }

    public final void onResume() {
        boolean z = true;
        v.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", Boolean.valueOf(this.oKg), Boolean.valueOf(this.oKi), Boolean.valueOf(this.oKh), Boolean.valueOf(this.oKj));
        this.oKg = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = n.a("MM/dd", time).toString();
        if (this.oKn.equals(charSequence)) {
            z = false;
        }
        this.oKn = charSequence;
        if (z) {
            bId();
        }
        if (this.oKi && this.oKm != null) {
            this.oKi = false;
        }
        if (this.oKh || this.oKj) {
            super.a(null, null);
            this.oKh = false;
            this.oKj = false;
        }
    }

    public final void onDestroy() {
        this.oKu.QI();
        this.oKm = null;
        this.oKk = null;
        if (this.ohm != null) {
            this.ohm.clear();
            this.ohm = null;
        }
        avc();
        this.nDK = null;
        detach();
    }

    public void Ol() {
        v.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", Boolean.valueOf(this.gYJ));
        if (this.gYJ) {
            Cursor[] cursorArr = new Cursor[2];
            cursorArr[0] = ak.yW().cqW.a(m.crA, this.ejp, this.dwS);
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            if (this.ejp != null && this.ejp.size() > 0) {
                arrayList.addAll(this.ejp);
            }
            while (cursorArr[0].moveToNext()) {
                try {
                    String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                    arrayList.add(string);
                    if (!string.endsWith("@chatroom")) {
                        arrayList2.add(string);
                    }
                    v.d("MicroMsg.ConversationAdapter", "block user " + string);
                } catch (Throwable e) {
                    v.a("MicroMsg.ConversationAdapter", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            arrayList.add("officialaccounts");
            arrayList.add("helper_entry");
            cursorArr[1] = ak.yW().cqX.b(this.dwS, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
            setCursor(new MergeCursor(cursorArr));
        } else {
            ak.yW();
            setCursor(com.tencent.mm.model.c.wK().a(m.crA, this.ejp, com.tencent.mm.j.a.cht, false));
        }
        if (!(this.oKe == null || this.dwS == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        View view2;
        ab abVar = (ab) getItem(i);
        String str = abVar.field_username;
        e eVar = this.oKo;
        eVar.bdo = str;
        eVar.euW = null;
        eVar.oKK = null;
        eVar.cit = false;
        if (!t.kS(str)) {
            eVar.cit = true;
        }
        this.oKr = new a();
        if (view == null) {
            View inflate;
            g gVar2 = new g();
            if (com.tencent.mm.bd.a.dt(this.context)) {
                inflate = View.inflate(this.context, 2130903431, null);
            } else {
                inflate = View.inflate(this.context, 2130903430, null);
            }
            gVar2.dtX = (ImageView) inflate.findViewById(2131755508);
            com.tencent.mm.pluginsdk.ui.a.b.m(gVar2.dtX, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) gVar2.dtX.getDrawable();
            if (this.oKf != null) {
                this.oKf.a(aVar);
            }
            gVar2.ohq = (NoMeasuredTextView) inflate.findViewById(2131756539);
            gVar2.ohr = (NoMeasuredTextView) inflate.findViewById(2131756540);
            gVar2.ohs = (NoMeasuredTextView) inflate.findViewById(2131756541);
            gVar2.eul = (TextView) inflate.findViewById(2131755330);
            gVar2.eul.setBackgroundResource(s.eN(this.context));
            gVar2.oht = (ImageView) inflate.findViewById(2131756543);
            gVar2.ohv = inflate.findViewById(2131756538);
            gVar2.ohu = (ImageView) inflate.findViewById(2131756544);
            gVar2.oKL = (ImageView) inflate.findViewById(2131756545);
            inflate.setTag(gVar2);
            gVar2.ohs.G(this.ohj);
            gVar2.ohr.G(this.ohk);
            gVar2.ohq.G(this.ohi);
            gVar2.ohs.setTextColor(this.ohl[0]);
            gVar2.ohr.setTextColor(this.ohl[4]);
            gVar2.ohq.setTextColor(this.ohl[3]);
            gVar2.ohs.oaP = true;
            gVar2.ohr.oaP = false;
            gVar2.ohq.oaP = true;
            gVar2.ohr.vP();
            gVar = gVar2;
            view2 = inflate;
        } else {
            gVar = (g) view.getTag();
            view2 = view;
        }
        d dVar = (d) this.ohm.get(str);
        if (dVar == null) {
            String str2;
            int i2;
            d dVar2 = new d();
            e eVar2 = this.oKo;
            if (eVar2.cit && eVar2.euW == null) {
                ak.yW();
                eVar2.euW = com.tencent.mm.model.c.wH().LX(eVar2.bdo);
            }
            com.tencent.mm.e.b.ab abVar2 = eVar2.euW;
            if (abVar2 != null) {
                dVar2.oKC = abVar2.bCs;
                dVar2.oKB = (int) abVar2.chr;
            } else {
                dVar2.oKC = -1;
                dVar2.oKB = -1;
            }
            dVar2.oKG = abVar2 != null;
            boolean z = abVar2 != null && abVar2.tN();
            dVar2.oKI = z;
            z = abVar2 != null && abVar2.bCh == 0;
            dVar2.oKH = z;
            dVar2.onP = m.dE(str);
            z = dVar2.onP && dVar2.oKH && abVar.field_unReadCount > 0;
            dVar2.oKF = z;
            dVar2.eKg = 0;
            if (py(abVar.field_msgType) == 34 && abVar.field_isSend == 0 && !t.kS(abVar.field_content)) {
                str2 = abVar.field_content;
                if (str.equals("qmessage") || str.equals("floatbottle")) {
                    String[] split = str2.split(":");
                    if (split != null && split.length > 3) {
                        str2 = split[1] + ":" + split[2] + ":" + split[3];
                    }
                }
                if (!new com.tencent.mm.modelvoice.n(str2).dhD) {
                    dVar2.eKg = 1;
                }
            }
            str2 = l.a(abVar2, str, dVar2.onP);
            if (dVar2.onP && str2 == null) {
                dVar2.nickName = this.context.getString(2131231879);
            } else {
                dVar2.nickName = com.tencent.mm.pluginsdk.ui.d.e.a(this.context, l.a(abVar2, str, dVar2.onP), gVar.ohq.gl.getTextSize());
            }
            dVar2.oKy = i(abVar);
            dVar2.oKz = a(abVar, (int) gVar.ohs.gl.getTextSize(), dVar2.oKF);
            dVar2.oKJ = abVar.field_attrflag;
            switch (abVar.field_status) {
                case 0:
                    i2 = -1;
                    break;
                case 1:
                    i2 = 2131165723;
                    break;
                case 2:
                    i2 = -1;
                    break;
                case 5:
                    i2 = 2131165722;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            dVar2.oKA = i2;
            dVar2.oKD = m.a(abVar);
            ak.yW();
            com.tencent.mm.model.c.wK();
            dVar2.ohn = ac.g(abVar);
            z = abVar2 != null && abVar2.tM();
            dVar2.oKE = z;
            dVar2.lCM = com.tencent.mm.sdk.platformtools.u.bsU();
            this.ohm.put(str, dVar2);
            dVar = dVar2;
        }
        if (dVar.oKy == null) {
            dVar.oKy = i(abVar);
        }
        if (dVar.oKF || m.fc(abVar.field_parentRef)) {
            gVar.ohs.setTextColor(this.ohl[0]);
        } else {
            gVar.ohs.setTextColor(this.ohl[dVar.eKg]);
        }
        h.dJ(gVar.ohs.getWidth());
        h.dK((int) gVar.ohs.gl.getTextSize());
        h.a(gVar.ohs.gl);
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            gVar.ohq.bCU();
            gVar.ohq.jw(true);
        } else {
            gVar.ohq.jw(false);
        }
        int i3 = dVar.oKA;
        if (i3 != -1) {
            gVar.ohs.wC(i3);
            gVar.ohs.jv(true);
        } else {
            gVar.ohs.jv(false);
        }
        gVar.ohq.setText(dVar.nickName);
        LayoutParams layoutParams = gVar.ohr.getLayoutParams();
        if (dVar.oKy.length() > 9) {
            if (layoutParams.width != this.oKq) {
                layoutParams.width = this.oKq;
                gVar.ohr.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.oKp) {
            layoutParams.width = this.oKp;
            gVar.ohr.setLayoutParams(layoutParams);
        }
        v.v("MicroMsg.ConversationAdapter", "layout update time width %d", Integer.valueOf(layoutParams.width));
        gVar.ohr.setText(dVar.oKy);
        gVar.ohs.setText(dVar.oKz);
        if (dVar.onP && dVar.oKH) {
            gVar.oht.setVisibility(0);
        } else if (dVar.oKE) {
            gVar.oht.setVisibility(0);
        } else {
            gVar.oht.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.m(gVar.dtX, str);
        if (this.oKd) {
            if (abVar == null || gVar == null || dVar == null) {
                v.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                gVar.eul.setVisibility(4);
                gVar.ohv.setVisibility(4);
                if (m.fc(abVar.field_username)) {
                    gVar.ohv.setVisibility(abVar.field_unReadCount > 0 ? 0 : 4);
                    gVar.ohq.setTextColor(this.ohl[3]);
                } else {
                    NoMeasuredTextView noMeasuredTextView = gVar.ohq;
                    ColorStateList colorStateList = (dVar.oKG && dVar.oKC == 1) ? this.ohl[2] : this.ohl[3];
                    noMeasuredTextView.setTextColor(colorStateList);
                    if (!dVar.oKG || dVar.oKB == 0) {
                        v.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
                    } else if (m.fc(abVar.field_parentRef)) {
                        gVar.ohv.setVisibility(abVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.oKE && dVar.oKI) {
                        gVar.ohv.setVisibility(abVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (dVar.onP && dVar.oKH) {
                        gVar.ohv.setVisibility(abVar.field_unReadCount > 0 ? 0 : 4);
                    } else {
                        i3 = abVar.field_unReadCount;
                        if (i3 > 99) {
                            gVar.eul.setText(2131235710);
                            gVar.eul.setVisibility(0);
                        } else if (i3 > 0) {
                            gVar.eul.setText(abVar.field_unReadCount);
                            gVar.eul.setVisibility(0);
                        }
                        this.oKr.oKw = i3;
                    }
                }
            }
        }
        if (!dVar.oKD && dVar.ohn && ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.wK().f(abVar);
        }
        if (!dVar.ohn || abVar.field_conversationTime == -1) {
            view2.findViewById(2131756537).setBackgroundResource(2130838046);
        } else {
            view2.findViewById(2131756537).setBackgroundResource(2130838045);
        }
        com.tencent.mm.ay.c.brh();
        com.tencent.mm.sdk.c.b pdVar = new pd();
        pdVar.bqt.bqv = true;
        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
        if (!(0 == ac.a(abVar, 7, 0) || abVar.field_username.equals(pdVar.bqu.bqx))) {
            abVar.t(ac.a(abVar, 6, abVar.field_conversationTime));
            ak.yW();
            com.tencent.mm.model.c.wK().a(abVar, abVar.field_username, true);
        }
        if (com.tencent.mm.pluginsdk.j.a.lxG == null || !com.tencent.mm.pluginsdk.j.a.lxG.CB(abVar.field_username)) {
            gVar.ohu.setVisibility(8);
        } else {
            gVar.ohu.setVisibility(0);
            if (abVar.field_username.equals(pdVar.bqu.bqx)) {
                gVar.ohu.setImageResource(2131165967);
            } else {
                gVar.ohu.setImageResource(2131165966);
            }
        }
        if (com.tencent.mm.pluginsdk.j.a.lxQ == null || !com.tencent.mm.pluginsdk.j.a.lxQ.vJ(abVar.field_username)) {
            gVar.oKL.setVisibility(8);
        } else {
            gVar.oKL.setVisibility(0);
        }
        this.oKr.content = String.valueOf(dVar.oKz);
        this.oKr.aGX = String.valueOf(dVar.nickName);
        this.oKr.oKx = String.valueOf(dVar.oKy);
        a aVar2 = this.oKr;
        a.nHA.a(view2, aVar2.aGX, aVar2.oKw, aVar2.oKx, aVar2.content);
        a(str, gVar);
        return view2;
    }

    protected void a(String str, g gVar) {
    }

    private static int py(String str) {
        int i = 1;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private CharSequence a(ab abVar, int i, boolean z) {
        CharSequence replace;
        if (t.kS(abVar.field_editingMsg) || (abVar.field_atCount > 0 && abVar.field_unReadCount > 0)) {
            CharSequence charSequence = abVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(com.tencent.mm.pluginsdk.ui.d.e.b(this.context, charSequence, (float) i));
            }
            int i2;
            String str;
            String str2 = abVar.field_username;
            if (str2.equals("qqmail")) {
                ak.yW();
                if (t.f((Integer) com.tencent.mm.model.c.vf().get(17, null)) == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    return this.context.getString(2131235097);
                }
            }
            if (str2.equals("tmessage")) {
                ak.yW();
                ax Nr = com.tencent.mm.model.c.wN().Nr("@t.qq.com");
                if (Nr == null || !Nr.aeX()) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                if (i2 == 0) {
                    return this.context.getString(2131235097);
                }
            }
            if (str2.equals("qmessage")) {
                if ((k.xJ() & 64) != 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    return this.context.getString(2131235097);
                }
            }
            if (abVar.field_msgType != null && (abVar.field_msgType.equals("47") || abVar.field_msgType.equals("1048625"))) {
                str2 = OE(abVar.field_digest);
                str = SQLiteDatabase.KeyEmpty;
                if (str2 != null) {
                    return "[" + str2 + "]";
                }
                if (abVar.field_digest != null && abVar.field_digest.contains(":")) {
                    str = abVar.field_digest.substring(0, abVar.field_digest.indexOf(":"));
                    str2 = OE(abVar.field_digest.substring(abVar.field_digest.indexOf(":") + 1).replace(" ", SQLiteDatabase.KeyEmpty));
                    if (str2 != null) {
                        str2 = "[" + str2 + "]";
                        return t.kS(str) ? str2 : str + ": " + str2;
                    }
                }
                str2 = this.context.getString(2131231031);
                abVar.cu(t.kS(str) ? str2 : str + ": " + str2);
            }
            if (!t.kS(abVar.field_digest)) {
                if (t.kS(abVar.field_digestUser)) {
                    str = abVar.field_digest;
                } else {
                    str = (abVar.field_isSend == 0 && m.dE(abVar.field_username)) ? l.D(abVar.field_digestUser, abVar.field_username) : l.er(abVar.field_digestUser);
                    try {
                        str = String.format(abVar.field_digest, new Object[]{str});
                    } catch (Exception e) {
                    }
                }
                replace = str.replace('\n', ' ');
                if (abVar.field_atCount > 0 || abVar.field_unReadCount <= 0) {
                    if (!z && abVar.field_unReadCount > 1) {
                        replace = this.context.getString(2131233700, new Object[]{Integer.valueOf(abVar.field_unReadCount), replace});
                    } else if (abVar.field_unReadCount > 1 && m.fc(abVar.field_parentRef)) {
                        replace = this.context.getString(2131233700, new Object[]{Integer.valueOf(abVar.field_unReadCount), replace});
                    }
                    return com.tencent.mm.pluginsdk.ui.d.e.a(this.context, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(2131233697));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, replace, i));
                return spannableStringBuilder;
            }
            str = h.a(abVar.field_isSend, abVar.field_username, abVar.field_content, py(abVar.field_msgType), this.context);
            replace = str.replace('\n', ' ');
            if (abVar.field_atCount > 0) {
            }
            if (!z) {
            }
            replace = this.context.getString(2131233700, new Object[]{Integer.valueOf(abVar.field_unReadCount), replace});
            return com.tencent.mm.pluginsdk.ui.d.e.a(this.context, replace, i);
        }
        replace = new SpannableStringBuilder(this.context.getString(2131233701));
        replace.setSpan(new ForegroundColorSpan(-5569532), 0, replace.length(), 33);
        replace.append(" ").append(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, abVar.field_editingMsg, i));
        return replace;
    }

    private static String OE(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return com.tencent.mm.pluginsdk.j.a.bmr().rk(str);
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            v.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, i iVar) {
        v.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.oKg), Boolean.valueOf(this.oKh), str);
        if (!(t.kS(str) || this.ohm == null)) {
            this.ohm.remove(str);
        }
        if (this.oKg) {
            v.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.oKt), Boolean.valueOf(this.oKu.btC()));
            this.oKt = true;
            if (this.oKu.btC()) {
                bIe();
                return;
            }
            return;
        }
        this.oKh = true;
    }

    private void bIe() {
        ad.o(new Runnable(this) {
            final /* synthetic */ a oKv;

            {
                this.oKv = r1;
            }

            public final void run() {
                if (ak.uz()) {
                    long Ni = t.Ni();
                    super.a(null, null);
                    v.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(t.ay(Ni) * 3), Long.valueOf(a.oKs), Boolean.valueOf(this.oKv.oKt));
                    a.oKs = (Ni + a.oKs) / 2;
                    this.oKv.oKt = false;
                    this.oKv.oKu.ea(a.oKs);
                    return;
                }
                this.oKv.oKu.QI();
                v.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
            }
        });
    }
}
