package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
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
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.j.n;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map.Entry;

public final class c extends j<ab> implements com.tencent.mm.sdk.h.j.b {
    private static long oKs = 2000;
    private String bkp;
    protected f euc;
    protected com.tencent.mm.ui.base.MMSlideDelView.c eud;
    protected e eue;
    protected d euf = MMSlideDelView.bCp();
    private boolean oKg = false;
    private boolean oKh = false;
    public String oKn = SQLiteDatabase.KeyEmpty;
    private final int oKp;
    private final int oKq;
    private boolean oKt = false;
    ah oKu = new ah(ak.vA().htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c oLz;

        {
            this.oLz = r1;
        }

        public final boolean oU() {
            if (this.oLz.oKt) {
                this.oLz.bIe();
            }
            return false;
        }
    }, false);
    private ColorStateList[] oLy = new ColorStateList[5];
    private float ohi = -1.0f;
    private float ohj = -1.0f;
    private float ohk = -1.0f;
    HashMap<String, a> ohm;

    private class a {
        public int eKg;
        public boolean lCM;
        public CharSequence nickName;
        public int oKA;
        public int oKB;
        public boolean oKE;
        public boolean oKG;
        public boolean oKI;
        public int oKJ;
        public CharSequence oKy;
        public CharSequence oKz;
        public boolean oLA;
        final /* synthetic */ c oLz;
        public boolean ohn;

        private a(c cVar) {
            this.oLz = cVar;
        }
    }

    public static class b {
        public ImageView dtX;
        public NoMeasuredTextView oLB;
        public NoMeasuredTextView oLC;
        public NoMeasuredTextView oLD;
        public TextView oLE;
        public ImageView oht;
        public View ohv;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ab) obj;
        if (obj == null) {
            obj = new ab();
        }
        obj.cu(SQLiteDatabase.KeyEmpty);
        obj.cv(SQLiteDatabase.KeyEmpty);
        obj.b(cursor);
        return obj;
    }

    public c(Context context, String str, com.tencent.mm.ui.j.a aVar) {
        super(context, new ab());
        this.nDK = aVar;
        this.bkp = str;
        this.ohm = new HashMap();
        this.oLy[0] = com.tencent.mm.bd.a.M(context, 2131689792);
        this.oLy[1] = com.tencent.mm.bd.a.M(context, 2131690164);
        this.oLy[3] = com.tencent.mm.bd.a.M(context, 2131689909);
        this.oLy[2] = com.tencent.mm.bd.a.M(context, 2131690161);
        this.oLy[2] = com.tencent.mm.bd.a.M(context, 2131690161);
        this.oLy[4] = com.tencent.mm.bd.a.M(context, 2131689816);
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
        ak.yW();
        com.tencent.mm.model.c.wK().a(this);
    }

    public final void a(f fVar) {
        this.euc = fVar;
    }

    public final void a(e eVar) {
        this.eue = eVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.eud = cVar;
    }

    public final void onPause() {
        if (this.euf != null) {
            this.euf.avm();
        }
        this.oKg = false;
    }

    public final void onResume() {
        boolean z = true;
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
        if (this.oKh) {
            super.a(null, null);
            this.oKh = false;
        }
    }

    protected final void Om() {
        Ol();
    }

    public final void Ol() {
        avc();
        ak.yW();
        setCursor(com.tencent.mm.model.c.wK().b(m.crA, null, this.bkp));
        if (this.nDK != null) {
            this.nDK.Oi();
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        View inflate;
        int i2;
        a aVar;
        ab abVar = (ab) getItem(i);
        String str = abVar.field_username;
        b bVar2 = null;
        if (view != null) {
            bVar2 = (b) view.getTag();
        }
        if (view == null || bVar2 == null) {
            bVar = new b();
            if (com.tencent.mm.bd.a.dt(this.context)) {
                inflate = View.inflate(this.context, 2130903431, null);
            } else {
                inflate = View.inflate(this.context, 2130903430, null);
            }
            bVar.dtX = (ImageView) inflate.findViewById(2131755508);
            bVar.oLB = (NoMeasuredTextView) inflate.findViewById(2131756539);
            bVar.oLB.G(this.ohi);
            bVar.oLB.setTextColor(this.oLy[3]);
            bVar.oLB.oaP = true;
            bVar.oLC = (NoMeasuredTextView) inflate.findViewById(2131756540);
            bVar.oLC.G(this.ohk);
            bVar.oLC.setTextColor(this.oLy[4]);
            bVar.oLC.oaP = false;
            bVar.oLC.vP();
            bVar.oLD = (NoMeasuredTextView) inflate.findViewById(2131756541);
            bVar.oLD.G(this.ohj);
            bVar.oLD.setTextColor(this.oLy[0]);
            bVar.oLD.oaP = true;
            bVar.oLE = (TextView) inflate.findViewById(2131755330);
            bVar.oLE.setBackgroundResource(s.eN(this.context));
            bVar.oht = (ImageView) inflate.findViewById(2131756543);
            bVar.ohv = inflate.findViewById(2131756538);
            inflate.findViewById(2131756544).setVisibility(8);
            inflate.findViewById(2131756545).setVisibility(8);
            inflate.setTag(bVar);
        } else {
            bVar = bVar2;
            inflate = view;
        }
        a aVar2 = (a) this.ohm.get(str);
        ak.yW();
        com.tencent.mm.i.a LX = com.tencent.mm.model.c.wH().LX(str);
        if (aVar2 == null) {
            a aVar3 = new a();
            if (LX != null) {
                aVar3.oKB = (int) LX.chr;
            } else {
                aVar3.oKB = -1;
            }
            aVar3.oKG = LX != null;
            boolean z = LX != null && LX.tN();
            aVar3.oKI = z;
            z = LX != null && LX.tM();
            aVar3.oKE = z;
            aVar3.oLA = abVar.field_unReadCount > 0;
            aVar3.eKg = 0;
            if (k(abVar) == 34 && abVar.field_isSend == 0 && !t.kS(abVar.field_content) && !new com.tencent.mm.modelvoice.n(abVar.field_content).dhD) {
                aVar3.eKg = 1;
            }
            aVar3.nickName = com.tencent.mm.pluginsdk.ui.d.e.a(this.context, l.a(LX, str, false), bVar.oLB.gl.getTextSize());
            aVar3.oKy = i(abVar);
            int textSize = (int) bVar.oLD.gl.getTextSize();
            z = aVar3.oKE && aVar3.oLA;
            aVar3.oKz = c(abVar, textSize, z);
            aVar3.oKJ = abVar.field_attrflag;
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
            aVar3.oKA = i2;
            ak.yW();
            com.tencent.mm.model.c.wK();
            aVar3.ohn = ac.g(abVar);
            aVar3.lCM = u.bsU();
            this.ohm.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.oKy == null) {
            aVar.oKy = i(abVar);
        }
        if (aVar.oKE && aVar.oLA) {
            bVar.oLD.setTextColor(this.oLy[0]);
        } else {
            bVar.oLD.setTextColor(this.oLy[aVar.eKg]);
        }
        h.dJ(bVar.oLD.getWidth());
        h.dK((int) bVar.oLD.gl.getTextSize());
        h.a(bVar.oLD.gl);
        if (aVar.oKA != -1) {
            bVar.oLD.wC(aVar.oKA);
            bVar.oLD.jv(true);
        } else {
            bVar.oLD.jv(false);
        }
        bVar.oLD.setText(aVar.oKz);
        bVar.oLB.jw(false);
        bVar.oLB.setText(aVar.nickName);
        LayoutParams layoutParams = bVar.oLC.getLayoutParams();
        if (aVar.oKy.length() > 9) {
            if (layoutParams.width != this.oKq) {
                layoutParams.width = this.oKq;
                bVar.oLC.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.oKp) {
            layoutParams.width = this.oKp;
            bVar.oLC.setLayoutParams(layoutParams);
        }
        bVar.oLC.setText(aVar.oKy);
        if (aVar.oKE) {
            bVar.oht.setVisibility(0);
        } else {
            bVar.oht.setVisibility(8);
        }
        com.tencent.mm.pluginsdk.ui.a.b.m(bVar.dtX, str);
        bVar.oLE.setVisibility(4);
        bVar.ohv.setVisibility(4);
        if (aVar.oKG && aVar.oKB != 0) {
            i2 = abVar.field_unReadCount;
            if (aVar.oKE) {
                View view2 = bVar.ohv;
                if (i2 > 0) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                view2.setVisibility(i2);
            } else if (i2 > 99) {
                bVar.oLE.setText(2131235710);
                bVar.oLE.setVisibility(0);
            } else if (i2 > 0) {
                bVar.oLE.setText(String.valueOf(i2));
                bVar.oLE.setVisibility(0);
            }
        }
        if (!aVar.ohn || abVar.field_conversationTime == -1) {
            inflate.findViewById(2131756537).setBackgroundResource(2130838046);
        } else {
            inflate.findViewById(2131756537).setBackgroundResource(2130838045);
        }
        a.nHA.a(inflate, String.valueOf(aVar.nickName), abVar.field_unReadCount, String.valueOf(aVar.oKy), String.valueOf(aVar.oKz));
        return inflate;
    }

    private static int k(ab abVar) {
        int i = 1;
        String str = abVar.field_msgType;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    private CharSequence c(ab abVar, int i, boolean z) {
        CharSequence replace;
        if (t.kS(abVar.field_editingMsg) || (abVar.field_atCount > 0 && abVar.field_unReadCount > 0)) {
            CharSequence charSequence = abVar.field_digest;
            if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(com.tencent.mm.pluginsdk.ui.d.e.b(this.context, charSequence, (float) i));
            }
            String str;
            if (k(abVar) == 47 || k(abVar) == 1048625) {
                String OE = OE(abVar.field_digest);
                str = SQLiteDatabase.KeyEmpty;
                if (OE != null) {
                    return "[" + OE + "]";
                }
                if (abVar.field_digest != null && abVar.field_digest.contains(":")) {
                    str = abVar.field_digest.substring(0, abVar.field_digest.indexOf(":"));
                    OE = OE(abVar.field_digest.substring(abVar.field_digest.indexOf(":") + 1).replace(" ", SQLiteDatabase.KeyEmpty));
                    if (OE != null) {
                        OE = "[" + OE + "]";
                        return t.kS(str) ? OE : str + ": " + OE;
                    }
                }
                OE = this.context.getString(2131231031);
                abVar.cu(t.kS(str) ? OE : str + ": " + OE);
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
                    if (z && abVar.field_unReadCount > 1) {
                        replace = this.context.getString(2131233700, new Object[]{Integer.valueOf(abVar.field_unReadCount), replace});
                    }
                    return com.tencent.mm.pluginsdk.ui.d.e.a(this.context, replace, i);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(2131233697));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, replace, i));
                return spannableStringBuilder;
            }
            str = h.a(abVar.field_isSend, abVar.field_username, abVar.field_content, k(abVar), this.context);
            replace = str.replace('\n', ' ');
            if (abVar.field_atCount > 0) {
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

    private CharSequence i(ab abVar) {
        if (abVar.field_status == 1) {
            return this.context.getString(2131233725);
        }
        return abVar.field_conversationTime == Long.MAX_VALUE ? SQLiteDatabase.KeyEmpty : o.c(this.context, abVar.field_conversationTime, true);
    }

    private void bId() {
        if (this.ohm != null) {
            for (Entry value : this.ohm.entrySet()) {
                ((a) value.getValue()).oKy = null;
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            v.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, i iVar) {
        v.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.oKg), Boolean.valueOf(this.oKh), str);
        if (!(t.kS(str) || this.ohm == null)) {
            this.ohm.remove(str);
        }
        if (this.oKg) {
            v.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.oKt), Boolean.valueOf(this.oKu.btC()));
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
            final /* synthetic */ c oLz;

            {
                this.oLz = r1;
            }

            public final void run() {
                if (ak.uz()) {
                    long Ni = t.Ni();
                    super.a(null, null);
                    v.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(t.ay(Ni) * 3), Long.valueOf(c.oKs), Boolean.valueOf(this.oLz.oKt));
                    c.oKs = (Ni + c.oKs) / 2;
                    this.oLz.oKt = false;
                    this.oLz.oKu.ea(c.oKs);
                    return;
                }
                this.oLz.oKu.QI();
                v.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
            }
        });
    }
}
