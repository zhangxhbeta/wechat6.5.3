package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.mv;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.dd;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI extends MMActivity {
    private long cLn;
    private String cZU;
    private p dwg;
    private o ePs;
    private com.tencent.mm.model.c eRX;
    private b eRY;
    private String eRZ;
    private String eSa;
    private String eSb;
    private String eSc;
    private String eSd;
    private String eSe;
    private String eSf;
    private TextView eSg;
    private TextView eSh;
    private ImageView eSi;
    private TextView eSj;
    private TextView eSk;
    private GridView eSl;

    public class a {
        String cID;
        final /* synthetic */ SeeAccessVerifyInfoUI eSm;
        String eSo;
        String username;

        a(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, String str, String str2, String str3) {
            this.eSm = seeAccessVerifyInfoUI;
            this.username = str;
            this.cID = str2;
            this.eSo = str3;
        }
    }

    public class b extends BaseAdapter {
        final /* synthetic */ SeeAccessVerifyInfoUI eSm;
        private com.tencent.mm.ae.a.a.c eSp = null;
        List<a> eyh = new ArrayList();
        Context mContext;

        public b(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, Context context) {
            this.eSm = seeAccessVerifyInfoUI;
            this.mContext = context;
            adz();
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPs = true;
            aVar.cPO = true;
            aVar.cPH = 2131165440;
            this.eSp = aVar.GU();
        }

        private void adz() {
            String[] strArr = null;
            if (be.kS(this.eSm.eSa)) {
                v.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
                return;
            }
            String[] split = this.eSm.eSa.split(",");
            if (be.kS(this.eSm.eRZ)) {
                v.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
                return;
            }
            String[] split2 = this.eSm.eRZ.split(",");
            if (be.kS(this.eSm.eSb)) {
                v.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
            } else {
                strArr = this.eSm.eSb.split(",");
            }
            this.eyh.clear();
            int i = 0;
            while (i < split.length) {
                List list = this.eyh;
                SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = this.eSm;
                String str = split[i];
                String str2 = (split2.length <= i || be.kS(split2[i])) ? split[i] : split2[i];
                String str3 = (strArr == null || strArr.length <= i || be.kS(strArr[i])) ? "" : strArr[i];
                list.add(new a(seeAccessVerifyInfoUI, str, str2, str3));
                i++;
            }
        }

        public final int getCount() {
            return this.eyh.size();
        }

        public final Object getItem(int i) {
            return this.eyh.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            c bP;
            if (view == null) {
                view = View.inflate(this.mContext, 2130904283, null);
                bP = this.eSm.bP(view);
            } else {
                c cVar = (c) view.getTag();
                bP = cVar == null ? this.eSm.bP(view) : cVar;
            }
            bP.dtX.setVisibility(0);
            bP.eSr.setVisibility(0);
            n.GL().a(((a) this.eyh.get(i)).eSo, bP.dtX, this.eSp);
            bP.eSr.setText(e.a(this.mContext, be.ma(((a) this.eyh.get(i)).cID), bP.eSr.getTextSize()));
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b eSq;

                public final void onClick(View view) {
                    String tU;
                    String str = ((a) this.eSq.eyh.get(i)).cID;
                    String str2 = null;
                    if (this.eSq.eSm.ePs != null) {
                        str2 = this.eSq.eSm.ePs.er(((a) this.eSq.eyh.get(i)).username);
                    }
                    if (be.kS(str2)) {
                        tU = com.tencent.mm.model.c.wH().LX(be.ma(((a) this.eSq.eyh.get(i)).username)).tU();
                    } else {
                        tU = str2;
                    }
                    SeeAccessVerifyInfoUI.a(this.eSq.eSm, ((a) this.eSq.eyh.get(i)).username, tU, str, true);
                }
            });
            return view;
        }
    }

    class c {
        public ImageView dtX;
        final /* synthetic */ SeeAccessVerifyInfoUI eSm;
        public TextView eSr;

        c(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI) {
            this.eSm = seeAccessVerifyInfoUI;
        }
    }

    static /* synthetic */ void a(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, String str, String str2, String str3, boolean z) {
        if (be.kS(str2)) {
            ak.yW();
            ba Nw = com.tencent.mm.model.c.wI().Nw(str);
            if (!(Nw == null || be.kS(Nw.field_encryptUsername))) {
                str2 = Nw.field_conRemark;
            }
        }
        if (!be.kS(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (seeAccessVerifyInfoUI.ePs != null) {
                intent.putExtra("Contact_RoomNickname", seeAccessVerifyInfoUI.ePs.er(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeAccessVerifyInfoUI.eSe);
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(str);
            if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                mv mvVar = new mv();
                mvVar.bof.intent = intent;
                mvVar.bof.username = str;
                com.tencent.mm.sdk.c.a.nhr.z(mvVar);
            }
            if (LX != null && LX.bvm()) {
                g.iuh.Y(10298, LX.field_username + ",14");
            }
            if (z) {
                intent.putExtra("Contact_Scene", 34);
            } else {
                intent.putExtra("Contact_Scene", 14);
            }
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeAccessVerifyInfoUI.eSe);
            com.tencent.mm.plugin.chatroom.a.drp.d(intent, seeAccessVerifyInfoUI);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
        Fd(getString(2131230791));
        this.cLn = getIntent().getLongExtra("msgLocalId", 0);
        this.eSc = getIntent().getStringExtra("invitertitle");
        this.eSd = getIntent().getStringExtra("inviterusername");
        this.eSe = getIntent().getStringExtra("chatroom");
        this.eSf = getIntent().getStringExtra("invitationreason");
        this.cZU = getIntent().getStringExtra("ticket");
        this.eSa = getIntent().getStringExtra("username");
        this.eRZ = getIntent().getStringExtra("nickname");
        this.eSb = getIntent().getStringExtra("headimgurl");
        this.eRX = ak.yW();
        this.ePs = this.eRX.wO().LC(be.ma(this.eSe));
        this.eRY = new b(this, this);
        NI();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SeeAccessVerifyInfoUI eSm;

            {
                this.eSm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eSm.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        v.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904319;
    }

    protected final void NI() {
        CharSequence charSequence = null;
        this.eSg = (TextView) findViewById(2131759027);
        this.eSh = (TextView) findViewById(2131759028);
        this.eSj = (TextView) findViewById(2131758940);
        this.eSi = (ImageView) findViewById(2131758936);
        this.eSk = (TextView) findViewById(2131759030);
        this.eSl = (GridView) findViewById(2131759029);
        this.eSl.setAdapter(this.eRY);
        this.eSi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SeeAccessVerifyInfoUI eSm;

            {
                this.eSm = r1;
            }

            public final void onClick(View view) {
                u LX = com.tencent.mm.model.c.wH().LX(be.ma(this.eSm.eSd));
                String str = LX.field_nickname;
                String str2 = null;
                if (this.eSm.ePs != null) {
                    str2 = this.eSm.ePs.er(this.eSm.eSd);
                }
                if (be.kS(str2)) {
                    str2 = LX.tU();
                }
                SeeAccessVerifyInfoUI.a(this.eSm, this.eSm.eSd, str2, str, false);
            }
        });
        this.eSl.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SeeAccessVerifyInfoUI eSm;

            {
                this.eSm = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.eSl.postDelayed(new Runnable(this) {
            final /* synthetic */ SeeAccessVerifyInfoUI eSm;

            {
                this.eSm = r1;
            }

            public final void run() {
                int height = (int) ((((float) this.eSm.eSj.getHeight()) + this.eSm.getResources().getDimension(2131492966)) + this.eSm.getResources().getDimension(2131493160));
                if (this.eSm.eRY.getCount() / 4 > 0) {
                    height *= (this.eSm.eRY.getCount() / 4) + 1;
                }
                this.eSm.eSl.setLayoutParams(new LayoutParams(this.eSm.eSl.getWidth(), height));
            }
        }, 100);
        if (this.eSi != null) {
            com.tencent.mm.pluginsdk.ui.a.b.m(this.eSi, be.ma(this.eSd));
        }
        if (this.eSj != null) {
            TextView textView = this.eSj;
            String ma = be.ma(this.eSd);
            TextView textView2 = this.eSj;
            if (textView2 != null) {
                u LX = com.tencent.mm.model.c.wH().LX(be.ma(ma));
                if (LX == null) {
                    v.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
                } else {
                    ma = !be.kS(LX.field_conRemark) ? LX.field_conRemark : this.ePs != null ? this.ePs.er(ma) : null;
                    if (be.kS(ma)) {
                        ma = LX.field_conRemark;
                    }
                    if (be.kS(ma)) {
                        ma = LX.tT();
                    }
                    charSequence = e.a(this, be.ma(ma), textView2.getTextSize());
                }
            }
            textView.setText(charSequence);
        }
        if (this.eSg != null) {
            this.eSg.setText(e.a(this, be.ma(this.eSc)));
        }
        if (!(this.eSh == null || be.kS(this.eSf))) {
            this.eSh.setText(e.a(this, "\"" + be.ma(this.eSf) + "\""));
        }
        if (this.eSk != null) {
            this.eSk.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SeeAccessVerifyInfoUI eSm;

                {
                    this.eSm = r1;
                }

                public final void onClick(View view) {
                    SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = this.eSm;
                    ActionBarActivity actionBarActivity = this.eSm.nDR.nEl;
                    this.eSm.getString(2131231164);
                    seeAccessVerifyInfoUI.dwg = com.tencent.mm.ui.base.g.a(actionBarActivity, this.eSm.getString(2131230792), false, null);
                    new com.tencent.mm.plugin.chatroom.c.b(this.eSm.eSd, this.eSm.eSe, this.eSm.cZU, new LinkedList(be.g(this.eSm.eSa.split(",")))).Bt().a(this.eSm).b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.v.a.a<dd>>(this) {
                        final /* synthetic */ AnonymousClass5 eSn;

                        {
                            this.eSn = r1;
                        }

                        public final /* synthetic */ Object aq(Object obj) {
                            com.tencent.mm.v.a.a aVar = (com.tencent.mm.v.a.a) obj;
                            if (this.eSn.eSm.dwg != null && this.eSn.eSm.dwg.isShowing()) {
                                this.eSn.eSm.dwg.dismiss();
                            }
                            com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(aVar.biS);
                            if (dm != null) {
                                dm.a(this.eSn.eSm, null, null);
                            } else if (aVar.errType == 0 && aVar.errCode == 0) {
                                if (aVar.aZJ.getType() == 774) {
                                    ak.yW();
                                    at ek = com.tencent.mm.model.c.wJ().ek(this.eSn.eSm.cLn);
                                    ek.bwA();
                                    ak.yW();
                                    com.tencent.mm.model.c.wJ().b(ek.field_msgSvrId, ek);
                                    this.eSn.eSm.eSk.setBackgroundResource(2130837800);
                                    this.eSn.eSm.eSk.setTextColor(this.eSn.eSm.getResources().getColor(2131689777));
                                    this.eSn.eSm.eSk.setText(this.eSn.eSm.getString(2131233277));
                                    this.eSn.eSm.eSk.setEnabled(false);
                                    g.iuh.a(219, 23, 1, true);
                                }
                            } else if (aVar.aZJ.getType() == 774) {
                                v.i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[]{Integer.valueOf(774), Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), be.ma(aVar.biS)});
                                com.tencent.mm.ui.base.g.A(this.eSn.eSm.nDR.nEl, this.eSn.eSm.getString(2131230790), this.eSn.eSm.getString(2131231164));
                            }
                            return phb;
                        }
                    });
                }
            });
        }
        if (this.eSk != null) {
            ak.yW();
            if (com.tencent.mm.model.c.wJ().ek(this.cLn).bwB()) {
                this.eSk.setBackgroundResource(2130837800);
                this.eSk.setTextColor(getResources().getColor(2131689777));
                this.eSk.setText(getString(2131233277));
                this.eSk.setEnabled(false);
            }
        }
    }

    protected final c bP(View view) {
        c cVar = new c(this);
        cVar.dtX = (ImageView) view.findViewById(2131758936);
        cVar.eSr = (TextView) view.findViewById(2131758940);
        return cVar;
    }
}
