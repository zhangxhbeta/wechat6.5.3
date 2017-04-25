package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.j.n;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.tools.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class b extends com.tencent.mm.ui.e<String, ab> implements com.tencent.mm.sdk.h.j.b {
    String dwS;
    protected List<String> ejp = null;
    protected com.tencent.mm.ui.base.MMSlideDelView.f euc;
    protected com.tencent.mm.ui.base.MMSlideDelView.c eud;
    protected com.tencent.mm.ui.base.MMSlideDelView.e eue;
    protected com.tencent.mm.ui.base.MMSlideDelView.d euf = MMSlideDelView.bCp();
    boolean gVJ = false;
    boolean gYJ = false;
    boolean jFG = false;
    public boolean nBc = false;
    private boolean oKd = true;
    com.tencent.mm.pluginsdk.ui.d oKf;
    private boolean oKi = false;
    com.tencent.mm.sdk.c.c oKl = null;
    public String oKn = SQLiteDatabase.KeyEmpty;
    private final int oKp;
    private final int oKq;
    private boolean oLa = false;
    private pd oLb = null;
    b oLc = null;
    private HashSet<String> oLd;
    boolean oLe = false;
    HashSet<String> oLf;
    boolean oLg = false;
    private boolean oLh = false;
    public String oLi = SQLiteDatabase.KeyEmpty;
    final e oLj = new e(this);
    private float oLk = -1.0f;
    private a oLl;
    private float ohi = -1.0f;
    private float ohj = -1.0f;
    private float ohk = -1.0f;
    private ColorStateList[] ohl = new ColorStateList[5];
    HashMap<String, d> ohm;

    private class a {
        public String aGX;
        public String content;
        public int oKw;
        public String oKx;
        final /* synthetic */ b oLm;

        private a(b bVar) {
            this.oLm = bVar;
        }
    }

    public interface b {
        void bIj();
    }

    class c {
        public View eum = null;
        public TextView eun = null;
        public View nXh = null;
        final /* synthetic */ b oLm;
        boolean oLn = false;
        boolean oLo = false;
        boolean oLp = false;
        boolean oLq = false;
        boolean oLr = false;
        public ImageView oLs = null;
        public TextView oLt = null;
        public View oLu = null;
        String username = SQLiteDatabase.KeyEmpty;

        c(b bVar) {
            this.oLm = bVar;
        }
    }

    private class d {
        public String caJ;
        public int eKg;
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
        public CharSequence oKy;
        public CharSequence oKz;
        final /* synthetic */ b oLm;
        public boolean ohn;
        public boolean onP;

        private d(b bVar) {
            this.oLm = bVar;
        }
    }

    private class e {
        private String bdo;
        private boolean cit;
        private u euW;
        private Integer oKK;
        final /* synthetic */ b oLm;

        public e(b bVar) {
            this.oLm = bVar;
            this.cit = false;
            this.bdo = null;
            this.cit = false;
            this.euW = null;
            this.oKK = null;
        }

        public final void cH(String str) {
            this.bdo = str;
            this.euW = null;
            this.oKK = null;
            this.cit = false;
            if (!t.kS(str)) {
                this.cit = true;
            }
        }

        public final u bIk() {
            if (this.cit && this.euW == null && ak.uz()) {
                ak.yW();
                this.euW = com.tencent.mm.model.c.wH().LX(this.bdo);
            }
            return this.euW;
        }
    }

    public static class f {
        public ImageView dtX;
        public TextView eul;
        public ImageView oKL;
        public ImageView oLv;
        public ImageView oLw;
        public c oLx;
        public NoMeasuredTextView ohq;
        public NoMeasuredTextView ohr;
        public NoMeasuredTextView ohs;
        public ImageView oht;
        public ImageView ohu;
        public View ohv;
    }

    public final /* synthetic */ com.tencent.mm.m.a.a tZ() {
        return new ab();
    }

    public b(Context context, com.tencent.mm.ui.e.a aVar) {
        super(context, (byte) 0);
        super.a(aVar);
        this.ohl[0] = com.tencent.mm.bd.a.M(context, 2131689792);
        this.ohl[1] = com.tencent.mm.bd.a.M(context, 2131690164);
        this.ohl[3] = com.tencent.mm.bd.a.M(context, 2131689909);
        this.ohl[2] = com.tencent.mm.bd.a.M(context, 2131690161);
        this.ohl[2] = com.tencent.mm.bd.a.M(context, 2131690161);
        this.ohl[4] = com.tencent.mm.bd.a.M(context, 2131689816);
        if (com.tencent.mm.bd.a.dt(context)) {
            this.oKq = context.getResources().getDimensionPixelSize(2131493010);
            this.oKp = context.getResources().getDimensionPixelSize(2131493011);
        } else {
            this.oKq = context.getResources().getDimensionPixelSize(2131493009);
            this.oKp = context.getResources().getDimensionPixelSize(2131493012);
        }
        this.ohm = new HashMap();
        this.oLd = new HashSet();
        this.oLf = new HashSet();
        this.ohi = context.getResources().getDimension(2131493169);
        this.ohj = context.getResources().getDimension(2131493128);
        this.ohk = context.getResources().getDimension(com.tencent.mm.bi.a.b.peS);
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

    private CharSequence i(ab abVar) {
        if (abVar.field_status == 1) {
            return this.context.getString(2131233725);
        }
        return abVar.field_conversationTime == Long.MAX_VALUE ? SQLiteDatabase.KeyEmpty : o.c(this.context, abVar.field_conversationTime, true);
    }

    public final void bHn() {
        boolean z = true;
        if (this.ejp == null) {
            this.ejp = new ArrayList();
        }
        this.ejp.clear();
        boolean z2 = (k.xJ() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0;
        boolean xX = k.xX();
        if (!(z2 && xX)) {
            z = false;
        }
        if (z != this.oLh) {
            if (z) {
                ak.yW();
                a(5, com.tencent.mm.model.c.wK(), (Object) "floatbottle");
            } else {
                ak.yW();
                a(2, com.tencent.mm.model.c.wK(), (Object) "floatbottle");
            }
            this.oLh = z;
        }
        if (this.oLh) {
            this.ejp.add("floatbottle");
        }
    }

    public final void onPause() {
        v.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.nBc);
        if (this.nBc) {
            this.nBc = false;
            super.pause();
            if (this.euf != null) {
                this.euf.avm();
            }
        }
    }

    private void bId() {
        if (this.ohm != null) {
            for (Entry value : this.ohm.entrySet()) {
                ((d) value.getValue()).oKy = null;
            }
        }
    }

    public final void onResume() {
        v.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.nBc);
        if (!this.nBc) {
            boolean z;
            this.nBc = true;
            bHn();
            bIi();
            v.i(this.TAG, "newcursor resume syncNow ");
            this.nzO = true;
            iI(true);
            Time time = new Time();
            time.setToNow();
            String charSequence = n.a("MM/dd", time).toString();
            String bsY = com.tencent.mm.sdk.platformtools.u.bsY();
            if (this.oKn.equals(charSequence) && this.oLi.equals(bsY)) {
                z = false;
            } else {
                z = true;
            }
            this.oKn = charSequence;
            this.oLi = bsY;
            if (z) {
                bId();
            }
            if (this.oKi && this.oLc != null) {
                this.oLc.bIj();
                this.oKi = false;
                super.o(null, 1);
            }
            this.oLb = new pd();
            this.oLb.bqt.bqv = true;
            com.tencent.mm.sdk.c.a.nhr.z(this.oLb);
        }
    }

    public final void bIh() {
        super.o(null, 1);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        f fVar;
        this.oLl = new a();
        ab abVar = (ab) en(i);
        String str = abVar.field_username;
        this.oLj.cH(str);
        if (view == null) {
            View inflate;
            f fVar2 = new f();
            if (com.tencent.mm.bd.a.dt(this.context)) {
                inflate = View.inflate(this.context, 2130903433, null);
            } else if (com.tencent.mm.bd.a.du(this.context)) {
                inflate = View.inflate(this.context, 2130903434, null);
            } else {
                inflate = View.inflate(this.context, 2130903432, null);
            }
            fVar2.dtX = (ImageView) inflate.findViewById(2131755508);
            com.tencent.mm.pluginsdk.ui.a.b.m(fVar2.dtX, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) fVar2.dtX.getDrawable();
            if (this.oKf != null) {
                this.oKf.a(aVar);
            }
            fVar2.ohq = (NoMeasuredTextView) inflate.findViewById(2131756539);
            fVar2.ohr = (NoMeasuredTextView) inflate.findViewById(2131756540);
            fVar2.oLv = (ImageView) inflate.findViewById(2131756547);
            fVar2.ohs = (NoMeasuredTextView) inflate.findViewById(2131756541);
            fVar2.eul = (TextView) inflate.findViewById(2131755330);
            fVar2.oht = (ImageView) inflate.findViewById(2131756543);
            fVar2.ohv = inflate.findViewById(2131756538);
            fVar2.ohu = (ImageView) inflate.findViewById(2131756544);
            fVar2.oKL = (ImageView) inflate.findViewById(2131756545);
            fVar2.oLw = (ImageView) inflate.findViewById(2131756542);
            fVar2.eul.setBackgroundResource(s.eN(this.context));
            fVar2.oLx = new c(this);
            inflate.setTag(fVar2);
            fVar2.ohs.G((float) com.tencent.mm.bd.a.N(this.context, 2131493202));
            fVar2.ohr.G((float) com.tencent.mm.bd.a.N(this.context, com.tencent.mm.bi.a.b.peS));
            fVar2.ohq.G((float) com.tencent.mm.bd.a.N(this.context, 2131493169));
            this.oLk = fVar2.ohq.gl.getTextSize();
            fVar2.ohs.setTextColor(this.ohl[0]);
            fVar2.ohr.setTextColor(this.ohl[4]);
            fVar2.ohq.setTextColor(this.ohl[3]);
            fVar2.ohs.oaP = true;
            fVar2.ohr.oaP = false;
            fVar2.ohq.oaP = true;
            fVar2.ohr.vP();
            view2 = inflate;
            fVar = fVar2;
        } else {
            fVar = (f) view.getTag();
            view2 = view;
        }
        d j = j(abVar);
        if (j.oKz == null) {
            j.oKz = b(abVar, (int) fVar.ohs.gl.getTextSize(), j.oKF);
        }
        if (j.oKy == null) {
            j.oKy = i(abVar);
        }
        if (j.oKF) {
            fVar.ohs.setTextColor(this.ohl[0]);
        } else {
            fVar.ohs.setTextColor(this.ohl[j.eKg]);
        }
        h.dJ(fVar.ohs.getWidth());
        h.dK((int) fVar.ohs.gl.getTextSize());
        h.a(fVar.ohs.gl);
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            fVar.ohq.bCU();
            fVar.ohq.jw(true);
        } else {
            fVar.ohq.jw(false);
        }
        int i2 = j.oKA;
        if (i2 != -1) {
            fVar.ohs.wC(i2);
            fVar.ohs.jv(true);
            v.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", str, Integer.valueOf(j.oKA));
        } else {
            fVar.ohs.jv(false);
            fVar.ohs.invalidate();
        }
        fVar.ohq.setText(j.nickName);
        LayoutParams layoutParams = fVar.ohr.getLayoutParams();
        if (j.oKy.length() >= 9) {
            if (layoutParams.width != this.oKq) {
                layoutParams.width = this.oKq;
                fVar.ohr.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.oKp) {
            layoutParams.width = this.oKp;
            fVar.ohr.setLayoutParams(layoutParams);
        }
        fVar.ohr.setText(j.oKy);
        fVar.ohs.setText(j.oKz);
        fVar.oLv.setVisibility(8);
        fVar.oht.setVisibility(8);
        if (j.onP) {
            if (j.oKH) {
                fVar.oht.setVisibility(0);
            }
        } else if (j.oKE) {
            fVar.oht.setVisibility(0);
        }
        com.tencent.mm.pluginsdk.ui.a.b.m(fVar.dtX, str);
        if (this.oKd) {
            if (abVar == null || fVar == null || j == null) {
                v.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                fVar.eul.setVisibility(4);
                fVar.ohv.setVisibility(4);
                ColorStateList colorStateList = (!m.ez(abVar.field_username) && j.oKG && (j.oKC == 1 || j.oKC == 2 || j.oKC == 3)) ? this.ohl[2] : this.ohl[3];
                fVar.ohq.setTextColor(colorStateList);
                if (!j.oKG || j.oKB == 0) {
                    v.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
                } else {
                    i2 = a(abVar, j);
                    if (i2 == 1) {
                        fVar.ohv.setVisibility(0);
                    } else if (i2 == 2) {
                        i2 = abVar.field_unReadCount;
                        if (i2 > 99) {
                            fVar.eul.setText(2131235710);
                            fVar.eul.setVisibility(0);
                        } else if (i2 > 0) {
                            fVar.eul.setText(abVar.field_unReadCount);
                            fVar.eul.setVisibility(0);
                        }
                        this.oLl.oKw = i2;
                    }
                }
            }
        }
        if (!j.oKD && j.ohn && ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.wK().f(abVar);
        }
        if (!j.ohn || abVar.field_conversationTime == -1) {
            view2.findViewById(2131756537).setBackgroundResource(2130838046);
        } else {
            view2.findViewById(2131756537).setBackgroundResource(2130838045);
        }
        if (VERSION.SDK_INT >= 21) {
            view2.findViewById(2131756537).setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ b oLm;

                {
                    this.oLm = r1;
                }

                @TargetApi(21)
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    view.findViewById(2131756537).getBackground().setHotspot(motionEvent.getX(), motionEvent.getY());
                    return false;
                }
            });
        }
        com.tencent.mm.ay.c.brh();
        if (!(0 == ac.a(abVar, 7, 0) || abVar.field_username.equals(this.oLb.bqu.bqx))) {
            abVar.t(ac.a(abVar, 6, abVar.field_conversationTime));
            ak.yW();
            com.tencent.mm.model.c.wK().a(abVar, abVar.field_username, true);
        }
        if (com.tencent.mm.pluginsdk.j.a.lxG == null || !com.tencent.mm.pluginsdk.j.a.lxG.CB(abVar.field_username)) {
            fVar.ohu.setVisibility(8);
        } else {
            fVar.ohu.setVisibility(0);
            if (abVar.field_username.equals(this.oLb.bqu.bqx)) {
                fVar.ohu.setImageResource(2131165967);
            } else {
                fVar.ohu.setImageResource(2131165966);
            }
        }
        if (com.tencent.mm.pluginsdk.j.a.lxQ == null || !com.tencent.mm.pluginsdk.j.a.lxQ.vJ(abVar.field_username)) {
            fVar.oKL.setVisibility(8);
        } else {
            fVar.oKL.setVisibility(0);
        }
        if (m.dE(abVar.field_username) && com.tencent.mm.pluginsdk.j.a.lxR != null && com.tencent.mm.pluginsdk.j.a.lxR.wI(abVar.field_username)) {
            if (com.tencent.mm.pluginsdk.j.a.lxR.aCe() && com.tencent.mm.pluginsdk.j.a.lxR.ce(abVar.field_username, k.xF())) {
                fVar.oLw.setImageResource(2131165380);
            } else {
                fVar.oLw.setImageResource(2131165381);
            }
            fVar.oLw.setVisibility(0);
        } else {
            fVar.oLw.setVisibility(8);
        }
        this.oLl.content = String.valueOf(j.oKz);
        this.oLl.aGX = j.caJ;
        this.oLl.oKx = String.valueOf(j.oKy);
        a aVar2 = this.oLl;
        a.nHA.a(view2, aVar2.aGX, aVar2.oKw, aVar2.oKx, aVar2.content);
        return view2;
    }

    d j(ab abVar) {
        boolean z = true;
        String str = abVar.field_username;
        d dVar = (d) this.ohm.get(str);
        if (dVar != null) {
            return dVar;
        }
        boolean z2;
        int i;
        d dVar2 = new d();
        this.oLj.cH(str);
        com.tencent.mm.e.b.ab bIk = this.oLj.bIk();
        if (bIk != null) {
            dVar2.oKC = bIk.bCs;
            dVar2.oKB = (int) bIk.chr;
        } else {
            dVar2.oKC = -1;
            dVar2.oKB = -1;
        }
        if (bIk != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        dVar2.oKG = z2;
        if (bIk == null || !bIk.tN()) {
            z2 = false;
        } else {
            z2 = true;
        }
        dVar2.oKI = z2;
        if (bIk == null || bIk.bCh != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        dVar2.oKH = z2;
        dVar2.onP = m.dE(str);
        if (dVar2.onP && dVar2.oKH && abVar.field_unReadCount > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        dVar2.oKF = z2;
        dVar2.eKg = 0;
        if (py(abVar.field_msgType) == 34 && abVar.field_isSend == 0 && !t.kS(abVar.field_content)) {
            String str2 = abVar.field_content;
            if (str.equals("qmessage") || str.equals("floatbottle") || str.equals("officialaccounts") || abVar.el(2097152) || abVar.el(8388608)) {
                String[] split = str2.split(":");
                if (split != null && split.length > 3) {
                    str2 = split[1] + ":" + split[2] + ":" + split[3];
                }
            }
            if (!new com.tencent.mm.modelvoice.n(str2).dhD) {
                dVar2.eKg = 1;
            }
        }
        dVar2.caJ = l.a(bIk, str, dVar2.onP);
        a(dVar2);
        dVar2.oKy = i(abVar);
        switch (abVar.field_status) {
            case 0:
                i = -1;
                break;
            case 1:
            case 8:
                i = 2131165723;
                break;
            case 2:
                i = -1;
                break;
            case 5:
                i = 2131165722;
                break;
            default:
                i = -1;
                break;
        }
        dVar2.oKA = i;
        dVar2.oKD = m.a(abVar);
        ak.yW();
        com.tencent.mm.model.c.wK();
        dVar2.ohn = ac.g(abVar);
        if (bIk == null || !bIk.tM()) {
            z = false;
        }
        dVar2.oKE = z;
        this.ohm.put(str, dVar2);
        return dVar2;
    }

    private void a(d dVar) {
        if (dVar.onP && dVar.caJ == null) {
            dVar.nickName = this.context.getString(2131231879);
        } else {
            dVar.nickName = com.tencent.mm.pluginsdk.ui.d.e.a(this.context, dVar.caJ, com.tencent.mm.bd.a.N(this.context, 2131493169));
        }
    }

    static int a(ab abVar, d dVar) {
        if (abVar == null || abVar.field_unReadCount <= 0) {
            if (abVar == null || ((!abVar.el(8388608) && !abVar.el(2097152)) || abVar == null || abVar.field_unReadMuteCount <= 0)) {
                return 0;
            }
            return 1;
        } else if (m.fc(abVar.field_username)) {
            return 1;
        } else {
            if (m.fi(abVar.field_username)) {
                ak.yW();
                if (!com.tencent.mm.model.c.vf().b(com.tencent.mm.storage.t.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    return 1;
                }
            }
            if (m.fm(abVar.field_username)) {
                ak.yW();
                if (!com.tencent.mm.model.c.vf().b(com.tencent.mm.storage.t.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    return 1;
                }
            }
            if (dVar.oKE && dVar.oKI) {
                return 1;
            }
            if (dVar.onP && dVar.oKH) {
                return 1;
            }
            return 2;
        }
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

    public final void clearCache() {
        if (this.ohm != null) {
            this.ohm.clear();
            this.oLg = true;
        }
    }

    private CharSequence b(ab abVar, int i, boolean z) {
        CharSequence charSequence;
        if (t.kS(abVar.field_editingMsg) || (abVar.field_atCount > 0 && (abVar.field_unReadCount > 0 || abVar.field_unReadMuteCount > 0))) {
            if (py(abVar.field_msgType) == 10000) {
                boolean fc = m.fc(abVar.field_username);
                if (!fc) {
                    fc = abVar.el(2097152);
                }
                if (!fc) {
                    fc = abVar.el(8388608);
                }
                if (!fc) {
                    fc = abVar.el(16777216);
                }
                if (!fc) {
                    fc = m.fm(abVar.field_username);
                }
                if (!fc) {
                    return new SpannableString(com.tencent.mm.pluginsdk.ui.d.e.d(this.context, abVar.field_content, i));
                }
            }
            CharSequence charSequence2 = abVar.field_digest;
            if (charSequence2 != null && charSequence2.startsWith("<img src=\"original_label.png\"/>  ")) {
                return new SpannableString(com.tencent.mm.pluginsdk.ui.d.e.b(this.context, charSequence2, (float) i));
            }
            int i2;
            String str = abVar.field_username;
            if (str.equals("qqmail")) {
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
            if (str.equals("tmessage")) {
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
            if (str.equals("qmessage")) {
                if ((k.xJ() & 64) != 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    return this.context.getString(2131235097);
                }
            }
            if (abVar.field_msgType != null && abVar.field_msgType.equals("64")) {
                return abVar.field_content;
            }
            String str2;
            CharSequence charSequence3;
            SpannableStringBuilder spannableStringBuilder;
            if (abVar.field_msgType != null && (abVar.field_msgType.equals("47") || abVar.field_msgType.equals("1048625"))) {
                str = OE(abVar.field_digest);
                str2 = SQLiteDatabase.KeyEmpty;
                if (!t.kS(str)) {
                    return "[" + str + "]";
                }
                if (abVar.field_digest != null && abVar.field_digest.contains(":")) {
                    str2 = abVar.field_digest.substring(0, abVar.field_digest.indexOf(":"));
                    str = OE(abVar.field_digest.substring(abVar.field_digest.indexOf(":") + 1).replace(" ", SQLiteDatabase.KeyEmpty));
                    if (!t.kS(str)) {
                        charSequence3 = "[" + str + "]";
                        if (t.kS(str2)) {
                            return com.tencent.mm.pluginsdk.ui.d.e.a(this.context, (CharSequence) str2, i);
                        }
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                        spannableStringBuilder2.append(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, (CharSequence) str2, i));
                        spannableStringBuilder2.append(": ");
                        spannableStringBuilder2.append(charSequence3);
                        return spannableStringBuilder2;
                    }
                }
                str = this.context.getString(2131231031);
                abVar.cu(t.kS(str2) ? str : str2 + ": " + str);
            }
            if (!t.kS(abVar.field_digest)) {
                if (t.kS(abVar.field_digestUser)) {
                    str2 = abVar.field_digest;
                } else {
                    str2 = (abVar.field_isSend == 0 && m.dE(abVar.field_username)) ? l.D(abVar.field_digestUser, abVar.field_username) : l.er(abVar.field_digestUser);
                    try {
                        str2 = String.format(abVar.field_digest, new Object[]{str2});
                    } catch (Exception e) {
                    }
                }
                charSequence2 = str2.replace('\n', ' ');
                if (abVar.field_UnReadInvite <= 0) {
                    spannableStringBuilder = new SpannableStringBuilder(abVar.field_UnReadInvite >= 4096 ? this.context.getString(2131233698, new Object[]{Integer.valueOf(abVar.field_UnReadInvite)}) : this.context.getString(2131233696));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, charSequence2, i));
                    return spannableStringBuilder;
                } else if (abVar.field_atCount <= 0 && (abVar.field_unReadCount > 0 || abVar.field_unReadMuteCount > 0)) {
                    spannableStringBuilder = new SpannableStringBuilder(this.context.getString(abVar.field_atCount < 4096 ? 2131233697 : 2131233699));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, charSequence2, i));
                    return spannableStringBuilder;
                } else if (abVar.el(16777216) || (abVar.field_unReadCount <= 0 && abVar.field_unReadMuteCount <= 0)) {
                    if (z || (abVar.field_unReadCount <= 1 && abVar.field_unReadMuteCount <= 0)) {
                        charSequence = charSequence2;
                    } else {
                        charSequence = this.context.getString(2131233700, new Object[]{Integer.valueOf(abVar.field_unReadCount), charSequence2});
                    }
                    return com.tencent.mm.pluginsdk.ui.d.e.a(this.context, charSequence, i);
                } else {
                    charSequence3 = this.context.getString(2131230761);
                    charSequence2 = charSequence2.replace(charSequence3, SQLiteDatabase.KeyEmpty);
                    charSequence = new SpannableStringBuilder(charSequence3);
                    charSequence.setSpan(new ForegroundColorSpan(-5569532), 0, charSequence.length(), 33);
                    charSequence.append(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, charSequence2, i));
                    return charSequence;
                }
            }
            str2 = h.a(abVar.field_isSend, abVar.field_username, abVar.field_content, py(abVar.field_msgType), this.context);
            charSequence2 = str2.replace('\n', ' ');
            if (abVar.field_UnReadInvite <= 0) {
                if (abVar.field_atCount <= 0) {
                }
                if (abVar.el(16777216)) {
                }
                if (z) {
                }
                charSequence = charSequence2;
                return com.tencent.mm.pluginsdk.ui.d.e.a(this.context, charSequence, i);
            }
            if (abVar.field_UnReadInvite >= 4096) {
            }
            spannableStringBuilder = new SpannableStringBuilder(abVar.field_UnReadInvite >= 4096 ? this.context.getString(2131233698, new Object[]{Integer.valueOf(abVar.field_UnReadInvite)}) : this.context.getString(2131233696));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, charSequence2, i));
            return spannableStringBuilder;
        }
        charSequence = new SpannableStringBuilder(this.context.getString(2131233701));
        charSequence.setSpan(new ForegroundColorSpan(-5569532), 0, charSequence.length(), 33);
        charSequence.append(" ").append(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, abVar.field_editingMsg, i));
        return charSequence;
    }

    private static String OE(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return com.tencent.mm.pluginsdk.j.a.bmr().rk(str);
    }

    public final com.tencent.mm.m.a.d byW() {
        v.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
        ak.yW();
        return (com.tencent.mm.m.a.d) com.tencent.mm.model.c.wK().a(m.crA, this.ejp, com.tencent.mm.j.a.cht, true);
    }

    public final ArrayList<ab> e(ArrayList<String> arrayList) {
        v.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", Integer.valueOf(arrayList.size()));
        ArrayList<ab> arrayList2 = new ArrayList(arrayList.size());
        ak.yW();
        Cursor a = com.tencent.mm.model.c.wK().a((ArrayList) arrayList, m.crA, this.ejp, com.tencent.mm.j.a.cht);
        while (a.moveToNext()) {
            ab abVar = new ab();
            abVar.b(a);
            arrayList2.add(abVar);
        }
        a.close();
        return arrayList2;
    }

    public final SparseArray<String>[] a(HashSet<com.tencent.mm.ui.e.b<String, ab>> hashSet, SparseArray<String>[] sparseArrayArr) {
        if (sparseArrayArr != null && sparseArrayArr.length > 0) {
            com.tencent.mm.ui.e.b bVar;
            v.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", Integer.valueOf(hashSet.size()), Integer.valueOf(sparseArrayArr[0].size()));
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                bVar = (com.tencent.mm.ui.e.b) it.next();
                if (!(bVar == null || bVar.nAc == 5 || arrayList.contains(bVar.yt))) {
                    v.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + ((String) bVar.yt));
                    arrayList.add(bVar.yt);
                }
            }
            HashMap hashMap = new HashMap();
            ak.yW();
            Cursor a = com.tencent.mm.model.c.wK().a(arrayList, m.crA, this.ejp, com.tencent.mm.j.a.cht);
            while (a.moveToNext()) {
                af abVar = new ab();
                abVar.b(a);
                hashMap.put(abVar.field_username, abVar);
            }
            a.close();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                bVar = (com.tencent.mm.ui.e.b) it2.next();
                if (bVar != null) {
                    if (bVar.nAc != 5) {
                        v.d("MicroMsg.ConversationWithCacheAdapter", "evnet name," + ((String) bVar.yt) + "  event.newObj   ==" + (hashMap.get(bVar.yt) == null));
                        bVar.nAd = hashMap.get(bVar.yt);
                    } else {
                        bVar.nAd = null;
                    }
                }
            }
            arrayList.clear();
            hashMap.clear();
            HashMap hashMap2 = new HashMap();
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                bVar = (com.tencent.mm.ui.e.b) it3.next();
                if (bVar != null) {
                    a(bVar, sparseArrayArr[0], hashMap2);
                    if (bVar.nAc != 5) {
                        hashMap2.put(bVar.yt, bVar.nAd);
                    }
                }
            }
        }
        return sparseArrayArr;
    }

    private ab d(String str, HashMap<String, ab> hashMap) {
        if (hashMap == null || !hashMap.containsKey(str)) {
            return (ab) am(str);
        }
        return (ab) hashMap.get(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.util.SparseArray<java.lang.String> a(com.tencent.mm.ui.e.b<java.lang.String, com.tencent.mm.storage.ab> r16, android.util.SparseArray<java.lang.String> r17, java.util.HashMap<java.lang.String, com.tencent.mm.storage.ab> r18) {
        /*
        r15 = this;
        r0 = r16;
        r2 = r0.yt;
        r2 = (java.lang.String) r2;
        r6 = r17.size();
        r0 = r16;
        r3 = r0.nAd;
        r3 = (com.tencent.mm.storage.ab) r3;
        r7 = r17.size();
        r5 = 0;
    L_0x0015:
        if (r5 >= r7) goto L_0x0058;
    L_0x0017:
        r0 = r17;
        r4 = r0.get(r5);
        r4 = (java.lang.String) r4;
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x0055;
    L_0x0025:
        r4 = "MicroMsg.ConversationWithCacheAdapter";
        r7 = "resortPosition username %s,  size %d, position %d";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r2;
        r9 = 1;
        r10 = java.lang.Integer.valueOf(r6);
        r8[r9] = r10;
        r9 = 2;
        r10 = java.lang.Integer.valueOf(r5);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.v.d(r4, r7, r8);
        r0 = r16;
        r4 = r0.nAc;
        switch(r4) {
            case 2: goto L_0x0079;
            case 3: goto L_0x0049;
            case 4: goto L_0x0049;
            case 5: goto L_0x005b;
            default: goto L_0x0049;
        };
    L_0x0049:
        if (r5 >= 0) goto L_0x00eb;
    L_0x004b:
        r2 = "MicroMsg.ConversationWithCacheAdapter";
        r3 = "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0";
        com.tencent.mm.sdk.platformtools.v.e(r2, r3);
    L_0x0054:
        return r17;
    L_0x0055:
        r5 = r5 + 1;
        goto L_0x0015;
    L_0x0058:
        r4 = -1;
        r5 = r4;
        goto L_0x0025;
    L_0x005b:
        if (r5 < 0) goto L_0x0054;
    L_0x005d:
        r2 = r6 + -1;
        if (r5 >= r2) goto L_0x0071;
    L_0x0061:
        r2 = r5 + 1;
        r0 = r17;
        r2 = r0.get(r2);
        r0 = r17;
        r0.put(r5, r2);
        r5 = r5 + 1;
        goto L_0x005d;
    L_0x0071:
        r2 = r6 + -1;
        r0 = r17;
        r0.remove(r2);
        goto L_0x0054;
    L_0x0079:
        if (r3 != 0) goto L_0x00b1;
    L_0x007b:
        r3 = "MicroMsg.ConversationWithCacheAdapter";
        r4 = "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null";
        com.tencent.mm.sdk.platformtools.v.e(r3, r4);
        if (r5 < 0) goto L_0x0054;
    L_0x0086:
        r3 = "MicroMsg.ConversationWithCacheAdapter";
        r4 = "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r2;
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r7);
    L_0x0095:
        r2 = r6 + -1;
        if (r5 >= r2) goto L_0x00a9;
    L_0x0099:
        r2 = r5 + 1;
        r0 = r17;
        r2 = r0.get(r2);
        r0 = r17;
        r0.put(r5, r2);
        r5 = r5 + 1;
        goto L_0x0095;
    L_0x00a9:
        r2 = r6 + -1;
        r0 = r17;
        r0.remove(r2);
        goto L_0x0054;
    L_0x00b1:
        if (r5 >= 0) goto L_0x0049;
    L_0x00b3:
        r4 = 0;
        r5 = r4;
    L_0x00b5:
        if (r5 >= r6) goto L_0x00d1;
    L_0x00b7:
        r0 = r17;
        r4 = r0.get(r5);
        r4 = (java.lang.String) r4;
        r0 = r18;
        r4 = r15.d(r4, r0);
        r8 = r4.field_flag;
        r10 = r3.field_flag;
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 <= 0) goto L_0x00d1;
    L_0x00cd:
        r4 = r5 + 1;
        r5 = r4;
        goto L_0x00b5;
    L_0x00d1:
        r3 = r6;
    L_0x00d2:
        if (r3 <= r5) goto L_0x00e4;
    L_0x00d4:
        r4 = r3 + -1;
        r0 = r17;
        r4 = r0.get(r4);
        r0 = r17;
        r0.put(r3, r4);
        r3 = r3 + -1;
        goto L_0x00d2;
    L_0x00e4:
        r0 = r17;
        r0.put(r5, r2);
        goto L_0x0054;
    L_0x00eb:
        r0 = r18;
        r4 = r15.d(r2, r0);
        if (r3 != 0) goto L_0x011f;
    L_0x00f3:
        r3 = "MicroMsg.ConversationWithCacheAdapter";
        r4 = "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r2;
        com.tencent.mm.sdk.platformtools.v.e(r3, r4, r7);
    L_0x0102:
        r2 = r6 + -1;
        if (r5 >= r2) goto L_0x0116;
    L_0x0106:
        r2 = r5 + 1;
        r0 = r17;
        r2 = r0.get(r2);
        r0 = r17;
        r0.put(r5, r2);
        r5 = r5 + 1;
        goto L_0x0102;
    L_0x0116:
        r2 = r6 + -1;
        r0 = r17;
        r0.remove(r2);
        goto L_0x0054;
    L_0x011f:
        r8 = r4.field_flag;
        r10 = r3.field_flag;
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 == 0) goto L_0x0054;
    L_0x0127:
        r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r4 >= 0) goto L_0x0164;
    L_0x012b:
        r7 = 0;
        r6 = r5 + -1;
        r4 = 1;
        r14 = r4;
        r4 = r7;
        r7 = r6;
        r6 = r14;
    L_0x0133:
        r9 = 0;
        r8 = r4;
    L_0x0135:
        if (r8 > r7) goto L_0x018d;
    L_0x0137:
        r0 = r17;
        r4 = r0.get(r8);
        r4 = (java.lang.String) r4;
        r0 = r18;
        r4 = r15.d(r4, r0);
        r10 = r4.field_flag;
        r12 = r3.field_flag;
        r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r4 > 0) goto L_0x016e;
    L_0x014d:
        r3 = 1;
    L_0x014e:
        if (r3 == 0) goto L_0x0054;
    L_0x0150:
        if (r6 == 0) goto L_0x0171;
    L_0x0152:
        if (r5 <= r8) goto L_0x0185;
    L_0x0154:
        r3 = r5 + -1;
        r0 = r17;
        r3 = r0.get(r3);
        r0 = r17;
        r0.put(r5, r3);
        r5 = r5 + -1;
        goto L_0x0152;
    L_0x0164:
        r7 = r5 + 1;
        r6 = r6 + -1;
        r4 = 0;
        r14 = r4;
        r4 = r7;
        r7 = r6;
        r6 = r14;
        goto L_0x0133;
    L_0x016e:
        r8 = r8 + 1;
        goto L_0x0135;
    L_0x0171:
        r3 = r8 + -1;
    L_0x0173:
        if (r5 >= r3) goto L_0x0186;
    L_0x0175:
        r4 = r5 + 1;
        r0 = r17;
        r4 = r0.get(r4);
        r0 = r17;
        r0.put(r5, r4);
        r5 = r5 + 1;
        goto L_0x0173;
    L_0x0185:
        r3 = r8;
    L_0x0186:
        r0 = r17;
        r0.put(r3, r2);
        goto L_0x0054;
    L_0x018d:
        r3 = r9;
        goto L_0x014e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.b.a(com.tencent.mm.ui.e$b, android.util.SparseArray, java.util.HashMap):android.util.SparseArray<java.lang.String>");
    }

    public final void a(int i, j jVar, Object obj) {
        int i2 = 0;
        if (obj == null || !(obj instanceof String)) {
            v.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
            return;
        }
        String str = (String) obj;
        if (jVar instanceof ac) {
            v.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", Integer.valueOf(i), str);
            if (!(!str.contains("@") || str.endsWith("@chatroom") || str.endsWith("@micromsg.qq.com"))) {
                i2 = 1;
            }
            if (i2 == 0) {
                if (this.ohm != null) {
                    if (!obj.equals(SQLiteDatabase.KeyEmpty)) {
                        this.oLf.add(str);
                    } else if (i == 5) {
                        this.oLg = true;
                        super.o(null, 1);
                        return;
                    }
                }
                if (i == 3) {
                    i = 2;
                }
                super.o(str, i);
            }
        } else if (jVar instanceof aa) {
            v.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s, isIniting %b", Integer.valueOf(i), obj, Boolean.valueOf(this.gVJ));
            if (!this.gVJ) {
                this.oLe = true;
                if (i != 5 && i != 2 && this.ohm != null && this.ohm.containsKey(str) && this.oLd != null) {
                    this.oLd.add(str);
                }
            }
        }
    }

    private void bIi() {
        if (this.ohm != null && this.oLd != null && !this.oLd.isEmpty()) {
            v.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", Integer.valueOf(this.oLd.size()));
            Iterator it = this.oLd.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                String str = (String) it.next();
                if (!(str == null || str.equals(SQLiteDatabase.KeyEmpty) || !this.ohm.containsKey(str))) {
                    d dVar = (d) this.ohm.get(str);
                    if (dVar != null) {
                        this.oLj.cH(str);
                        boolean dE = m.dE(str);
                        com.tencent.mm.e.b.ab bIk = this.oLj.bIk();
                        if (bIk != null) {
                            String a = l.a(bIk, str, dE);
                            v.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", a, dVar.caJ);
                            if (!(a == null || a.equals(dVar.caJ))) {
                                dVar.caJ = a;
                                a(dVar);
                                i = 1;
                            }
                            boolean tM = bIk.tM();
                            dE = bIk.bCh == 0;
                            if (!(dVar.oKE == tM && dE == dVar.oKH)) {
                                dVar.oKE = tM;
                                dVar.oKH = dE;
                                dVar.oKI = bIk.tN();
                                v.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", str);
                                i2 = 1;
                                i = i2;
                            }
                        }
                    }
                }
                i2 = i;
                i = i2;
            }
            if (i != 0) {
                notifyDataSetChanged();
            }
            this.oLd.clear();
        }
    }

    public final boolean ub() {
        return super.ub();
    }

    public final boolean Pl(String str) {
        return this.ohm == null || !this.ohm.containsKey(str);
    }

    public final void xV(int i) {
        if (i >= 0 && i < getCount()) {
            ab abVar = (ab) en(i);
            if (abVar != null) {
                com.tencent.mm.pluginsdk.ui.a.b.box().bg(abVar.field_username);
            }
        }
    }
}
