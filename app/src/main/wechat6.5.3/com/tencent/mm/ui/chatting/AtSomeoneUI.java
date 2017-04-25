package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI extends MMActivity {
    private String bdo;
    private o ePs;
    private String eSt;
    private String eSu;
    private p eSv;
    private ListView eyT;
    private String mTitle;
    private a oln;

    private static class b {
        public MaskLayout eST;
        public TextView exG;

        private b() {
        }
    }

    private static class a extends j<u> {
        private o ePs;
        String eSD;
        private List<String> ejp;
        private String[] ohb;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            ak.yW();
            Object LS = c.wH().LS(u.f(cursor));
            if (LS != null) {
                return LS;
            }
            u uVar = new u();
            uVar.b(cursor);
            ak.yW();
            c.wH().K(uVar);
            return uVar;
        }

        public a(Context context, u uVar, o oVar, String[] strArr, List<String> list) {
            super(context, uVar);
            this.ePs = oVar;
            this.ohb = strArr;
            this.ejp = list;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            CharSequence a;
            if (view == null) {
                view = View.inflate(this.context, 2130903135, null);
                b bVar2 = new b();
                bVar2.eST = (MaskLayout) view.findViewById(2131755465);
                bVar2.exG = (TextView) view.findViewById(2131755466);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            u uVar = (u) getItem(i);
            bVar.exG.setTextColor(com.tencent.mm.bd.a.M(this.context, !m.fn(uVar.field_username) ? 2131690159 : 2131690160));
            com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) bVar.eST.view, uVar.field_username);
            if (uVar.field_verifyFlag == 0) {
                bVar.eST.bCM();
            } else if (com.tencent.mm.model.ab.a.csb != null) {
                String eJ = com.tencent.mm.model.ab.a.csb.eJ(uVar.field_verifyFlag);
                if (eJ != null) {
                    bVar.eST.d(com.tencent.mm.modelbiz.j.hL(eJ), com.tencent.mm.ui.base.MaskLayout.a.nZN);
                } else {
                    bVar.eST.bCM();
                }
            } else {
                bVar.eST.bCM();
            }
            if (t.kS(uVar.field_conRemark)) {
                a = AtSomeoneUI.a(this.ePs, uVar.field_username);
            } else {
                a = uVar.field_conRemark;
            }
            if (t.kS(a)) {
                a = uVar.tT();
            }
            bVar.exG.setText(e.a(this.context, a, bVar.exG.getTextSize()));
            return view;
        }

        public final void Ol() {
            List list;
            ak.yW();
            aa wH = c.wH();
            String[] strArr = this.ohb;
            String str = "@all.chatroom";
            String str2 = this.eSD;
            CharSequence charSequence = this.eSD;
            if (this.ePs == null || charSequence == null || this.ohb == null) {
                list = null;
            } else {
                list = new ArrayList();
                for (String str3 : this.ohb) {
                    String er = this.ePs.er(str3);
                    if (er != null && er.contains(charSequence)) {
                        list.add(str3);
                    }
                }
            }
            setCursor(wH.a(strArr, str, str2, list, this.ejp));
            super.notifyDataSetChanged();
        }

        protected final void Om() {
            avc();
            Ol();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eSt = getIntent().getStringExtra("Block_list");
        this.eSu = getIntent().getStringExtra("Chatroom_member_list");
        this.bdo = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.ePs = ak.yW().wO().LC(this.bdo);
        NI();
    }

    protected final void NI() {
        Fd(this.mTitle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AtSomeoneUI olo;

            {
                this.olo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.olo.setResult(0);
                this.olo.finish();
                return true;
            }
        });
        this.eSv = new p(true, true);
        this.eSv.oUs = new com.tencent.mm.ui.tools.p.b(this) {
            final /* synthetic */ AtSomeoneUI olo;

            {
                this.olo = r1;
            }

            public final void ml(String str) {
                a a = this.olo.oln;
                a.eSD = str;
                a.a(null, null);
            }

            public final boolean mk(String str) {
                return false;
            }

            public final void Of() {
            }

            public final void Og() {
            }

            public final void Oh() {
            }
        };
        a(this.eSv);
        this.eyT = (ListView) findViewById(2131755469);
        u uVar = new u();
        o oVar = this.ePs;
        String[] strArr = null;
        if (!t.kS(this.eSu)) {
            strArr = this.eSu.split(",");
            v.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        List linkedList = new LinkedList();
        if (!t.kS(this.eSt)) {
            linkedList = t.g(this.eSt.split(","));
        }
        ak.yW();
        ax Nr = c.wN().Nr("@t.qq.com");
        if (Nr != null) {
            linkedList.add(Nr.name);
        }
        this.oln = new a(this, uVar, oVar, strArr, linkedList);
        this.eyT.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AtSomeoneUI olo;

            {
                this.olo = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                u uVar = (u) this.olo.oln.getItem(i);
                Intent intent = new Intent();
                String a = AtSomeoneUI.a(this.olo.ePs, uVar.field_username);
                if (t.kS(a)) {
                    a = uVar.tT();
                }
                intent.putExtra("select_raw_user_name", uVar.field_username);
                intent.putExtra("Select_Conv_User", a);
                this.olo.setResult(-1, intent);
                this.olo.finish();
            }
        });
        this.eyT.setAdapter(this.oln);
    }

    protected void onPause() {
        super.onPause();
        if (this.eSv != null) {
            this.eSv.bJs();
        }
    }

    protected void onDestroy() {
        this.oln.avc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903136;
    }

    protected static String a(o oVar, String str) {
        if (oVar == null) {
            return null;
        }
        return oVar.er(str);
    }
}
