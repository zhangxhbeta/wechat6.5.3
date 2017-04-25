package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.n;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;

public final class b extends j<com.tencent.mm.modelbiz.a.a> implements com.tencent.mm.sdk.h.j.b {
    private c eSp = null;
    protected f euc;
    protected MMSlideDelView.c eud;
    protected e eue;
    protected d euf = MMSlideDelView.bCp();
    private final String ezn;
    private final MMFragmentActivity ohh;
    private float ohi = -1.0f;
    private float ohj = -1.0f;
    private float ohk = -1.0f;
    private ColorStateList[] ohl = new ColorStateList[5];
    HashMap<String, a> ohm;

    private class a {
        String cFW;
        public boolean eJx;
        String gbB;
        public boolean ohn;
        public com.tencent.mm.modelbiz.a.a oho;
        final /* synthetic */ b ohp;

        private a(b bVar) {
            this.ohp = bVar;
            this.cFW = null;
            this.gbB = null;
        }
    }

    public static class b {
        public ImageView dtX;
        public TextView eul;
        public NoMeasuredTextView ohq;
        public NoMeasuredTextView ohr;
        public NoMeasuredTextView ohs;
        public ImageView oht;
        public ImageView ohu;
        public View ohv;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.modelbiz.a.a) obj;
        if (obj == null) {
            obj = new com.tencent.mm.modelbiz.a.a();
        }
        obj.b(cursor);
        return obj;
    }

    public b(Context context, com.tencent.mm.ui.j.a aVar, String str) {
        super(context, new com.tencent.mm.modelbiz.a.a());
        this.nDK = aVar;
        this.ohh = (MMFragmentActivity) context;
        this.ezn = str;
        this.ohm = new HashMap();
        this.ohl[0] = com.tencent.mm.bd.a.M(context, 2131689792);
        this.ohl[1] = com.tencent.mm.bd.a.M(context, 2131690164);
        this.ohl[3] = com.tencent.mm.bd.a.M(context, 2131689909);
        this.ohl[2] = com.tencent.mm.bd.a.M(context, 2131690161);
        this.ohl[2] = com.tencent.mm.bd.a.M(context, 2131690161);
        this.ohl[4] = com.tencent.mm.bd.a.M(context, 2131689816);
        this.ohi = (float) com.tencent.mm.bd.a.N(context, 2131493169);
        this.ohj = (float) com.tencent.mm.bd.a.N(context, 2131493128);
        this.ohk = (float) com.tencent.mm.bd.a.N(context, com.tencent.mm.bi.a.b.peS);
        com.tencent.mm.ae.a.a.c.a aVar2 = new com.tencent.mm.ae.a.a.c.a();
        aVar2.cPv = com.tencent.mm.modelbiz.a.e.ib(this.ezn);
        aVar2.cPs = true;
        aVar2.cPO = true;
        aVar2.cPH = 2131165440;
        this.eSp = aVar2.GU();
    }

    public final void Ol() {
        avc();
        setCursor(u.DB().hP(this.ezn));
        if (this.nDK != null) {
            this.nDK.Oi();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void a(f fVar) {
        this.euc = fVar;
    }

    public final void a(e eVar) {
        this.eue = eVar;
    }

    public final void a(MMSlideDelView.c cVar) {
        this.eud = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.euf != null) {
            this.euf.avm();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        b bVar2;
        int i2;
        com.tencent.mm.modelbiz.a.a aVar = (com.tencent.mm.modelbiz.a.a) getItem(i);
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            bVar = null;
        }
        if (view == null || bVar == null) {
            View inflate;
            b bVar3 = new b();
            if (com.tencent.mm.bd.a.dt(this.ohh)) {
                inflate = View.inflate(this.ohh, 2130903431, null);
            } else {
                inflate = View.inflate(this.ohh, 2130903430, null);
            }
            bVar3.dtX = (ImageView) inflate.findViewById(2131755508);
            bVar3.ohq = (NoMeasuredTextView) inflate.findViewById(2131756539);
            bVar3.ohr = (NoMeasuredTextView) inflate.findViewById(2131756540);
            bVar3.ohs = (NoMeasuredTextView) inflate.findViewById(2131756541);
            bVar3.eul = (TextView) inflate.findViewById(2131755330);
            bVar3.eul.setBackgroundResource(s.eN(this.ohh));
            bVar3.oht = (ImageView) inflate.findViewById(2131756543);
            bVar3.ohv = inflate.findViewById(2131756538);
            bVar3.ohu = (ImageView) inflate.findViewById(2131756544);
            inflate.setTag(bVar3);
            bVar3.ohs.G(this.ohj);
            bVar3.ohr.G(this.ohk);
            bVar3.ohq.G(this.ohi);
            bVar3.ohs.setTextColor(this.ohl[0]);
            bVar3.ohr.setTextColor(this.ohl[4]);
            bVar3.ohq.setTextColor(this.ohl[3]);
            bVar3.ohs.oaP = true;
            bVar3.ohr.oaP = false;
            bVar3.ohq.oaP = true;
            bVar3.ohr.vP();
            view = inflate;
            bVar2 = bVar3;
        } else {
            bVar2 = bVar;
        }
        long j = aVar.field_bizChatId;
        a aVar2 = (a) this.ohm.get(String.valueOf(j));
        if (aVar2 == null) {
            aVar2 = new a();
            u.DB();
            aVar2.ohn = com.tencent.mm.modelbiz.a.b.c(aVar);
            com.tencent.mm.modelbiz.a.c Z = u.DA().Z(j);
            if (Z.DN()) {
                aVar2.cFW = Z.field_chatName;
                aVar2.eJx = Z.fe(1);
                aVar2.gbB = Z.field_headImageUrl;
            } else {
                com.tencent.mm.modelbiz.a.j ig = u.DC().ig(Z.field_bizChatServId);
                if (ig != null) {
                    aVar2.cFW = ig.field_userName;
                    aVar2.eJx = ig.fe(1);
                    aVar2.gbB = ig.field_headImageUrl;
                }
            }
            if (be.kS(aVar2.cFW)) {
                aVar2.cFW = this.ohh.getString(2131234604);
            }
            aVar2.oho = aVar;
            this.ohm.put(String.valueOf(j), aVar2);
        }
        bVar2.ohu.setVisibility(8);
        bVar2.ohr.setText(aVar2.oho.field_status == 1 ? this.ohh.getString(2131233725) : o.c(this.ohh, aVar2.oho.field_lastMsgTime, true));
        n.GL().a(aVar2.gbB, bVar2.dtX, this.eSp);
        if (aVar2.eJx) {
            bVar2.oht.setVisibility(0);
        } else {
            bVar2.oht.setVisibility(8);
        }
        bVar2.ohq.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.ohh, aVar2.cFW, (int) bVar2.ohq.gl.getTextSize()));
        CharSequence a = a(aVar2.oho, (int) bVar2.ohs.gl.getTextSize(), aVar2.cFW);
        switch (aVar2.oho.field_status) {
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
        bVar2.ohq.jw(false);
        if (i2 != -1) {
            bVar2.ohs.wC(i2);
            bVar2.ohs.jv(true);
        } else {
            bVar2.ohs.jv(false);
        }
        bVar2.ohs.setText(a);
        bVar2.ohs.setTextColor(com.tencent.mm.bd.a.M(this.ohh, 2131690163));
        if (py(aVar2.oho.field_msgType) == 34 && aVar2.oho.field_isSend == 0 && !be.kS(aVar2.oho.field_content) && !new com.tencent.mm.modelvoice.n(aVar2.oho.field_content).dhD) {
            bVar2.ohs.setTextColor(com.tencent.mm.bd.a.M(this.ohh, 2131690164));
        }
        if (aVar2.eJx) {
            if (aVar2.oho.field_unReadCount > 0) {
                bVar2.ohv.setVisibility(0);
            } else {
                bVar2.ohv.setVisibility(4);
            }
            bVar2.eul.setVisibility(4);
        } else {
            bVar2.ohv.setVisibility(4);
            if (aVar2.oho.field_unReadCount > 99) {
                bVar2.eul.setText(2131235710);
                bVar2.eul.setVisibility(0);
                v.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            } else if (aVar2.oho.field_unReadCount > 0) {
                bVar2.eul.setText(aVar2.oho.field_unReadCount);
                bVar2.eul.setVisibility(0);
                v.v("MicroMsg.BizChatConversationAdapter", "has unread");
            } else {
                bVar2.eul.setVisibility(4);
                v.v("MicroMsg.BizChatConversationAdapter", "no unread");
            }
        }
        if (aVar2.ohn) {
            view.findViewById(2131756537).setBackgroundResource(2130838045);
        } else {
            view.findViewById(2131756537).setBackgroundResource(2130838046);
        }
        return view;
    }

    private static String OE(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return com.tencent.mm.pluginsdk.j.a.bmr().rk(str);
    }

    private CharSequence a(com.tencent.mm.modelbiz.a.a aVar, int i, String str) {
        if (be.kS(aVar.field_editingMsg) || (aVar.field_atCount > 0 && aVar.field_unReadCount > 0)) {
            String str2 = aVar.field_digest;
            if (aVar.field_msgType != null && (aVar.field_msgType.equals("47") || aVar.field_msgType.equals("1048625"))) {
                String OE = OE(aVar.field_digest);
                str2 = SQLiteDatabase.KeyEmpty;
                if (OE != null) {
                    return "[" + OE + "]";
                }
                if (aVar.field_digest != null && aVar.field_digest.contains(":")) {
                    str2 = aVar.field_digest.substring(0, aVar.field_digest.indexOf(":"));
                    OE = OE(aVar.field_digest.substring(aVar.field_digest.indexOf(":") + 1).replace(" ", SQLiteDatabase.KeyEmpty));
                    if (OE != null) {
                        OE = "[" + OE + "]";
                        return be.kS(str2) ? OE : str2 + ": " + OE;
                    }
                }
                OE = this.ohh.getString(2131231031);
                aVar.field_digest = be.kS(str2) ? OE : str2 + ": " + OE;
            }
            if (be.kS(aVar.field_digest)) {
                str2 = SQLiteDatabase.KeyEmpty;
            } else if (be.kS(aVar.field_digestUser)) {
                str2 = aVar.field_digest;
            } else {
                try {
                    str2 = String.format(aVar.field_digest, new Object[]{str});
                } catch (Exception e) {
                    str2 = aVar.field_digest;
                }
            }
            CharSequence replace = str2.replace('\n', ' ');
            if (aVar.field_atCount <= 0 || aVar.field_unReadCount <= 0) {
                return com.tencent.mm.pluginsdk.ui.d.e.a(this.ohh, replace, i);
            }
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.ohh.getString(2131233697));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.e.a(this.ohh, replace, i));
            return spannableStringBuilder;
        }
        spannableStringBuilder = new SpannableStringBuilder(this.ohh.getString(2131233701));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.e.a(this.ohh, aVar.field_editingMsg, i));
        return spannableStringBuilder;
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

    protected final void Om() {
        Ol();
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        super.a(i, jVar, obj);
    }

    public final void eu(long j) {
        if (this.ohm != null) {
            this.ohm.remove(String.valueOf(j));
        }
    }
}
