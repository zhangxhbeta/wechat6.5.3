package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.modelbiz.a.k;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.p;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI extends MMActivity {
    private String bdo;
    private String eSt;
    private String eSu;
    private p eSv;
    private ListView eyT;
    private long ezh;
    private String mTitle;
    private a ogY;
    private c ogZ;

    private static class b {
        public MaskLayout eST;
        public TextView exG;

        private b() {
        }
    }

    private static class a extends j<com.tencent.mm.modelbiz.a.j> {
        String eSD;
        private com.tencent.mm.ae.a.a.c eSp = null;
        private List<String> ejp;
        private c ogZ;
        private String[] ohb;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            com.tencent.mm.modelbiz.a.j jVar = new com.tencent.mm.modelbiz.a.j();
            jVar.b(cursor);
            return jVar;
        }

        public a(Context context, com.tencent.mm.modelbiz.a.j jVar, c cVar, String[] strArr, List<String> list) {
            super(context, jVar);
            this.ogZ = cVar;
            this.ohb = strArr;
            this.ejp = list;
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPv = e.ic(this.ogZ.field_brandUserName);
            aVar.cPs = true;
            aVar.cPO = true;
            aVar.cPH = 2131165440;
            this.eSp = aVar.GU();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
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
            com.tencent.mm.modelbiz.a.j jVar = (com.tencent.mm.modelbiz.a.j) getItem(i);
            bVar.exG.setTextColor(com.tencent.mm.bd.a.M(this.context, 2131690159));
            n.GL().a(jVar.field_headImageUrl, (ImageView) bVar.eST.view, this.eSp);
            bVar.eST.bCM();
            bVar.exG.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, BizChatAtSomeoneUI.a(this.ogZ, jVar.field_userId), bVar.exG.getTextSize()));
            return view;
        }

        public final void Ol() {
            String str;
            avc();
            k DC = u.DC();
            String[] strArr = this.ohb;
            String str2 = this.eSD;
            List list = this.ejp;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select *  from BizChatUserInfo where ");
            StringBuilder append = stringBuilder.append(k.a(strArr, list));
            if (str2 == null || str2.equals(SQLiteDatabase.KeyEmpty)) {
                str = SQLiteDatabase.KeyEmpty;
            } else {
                str = " and (" + "userName like '%" + str2 + "%' )";
            }
            append.append(str);
            StringBuilder append2 = stringBuilder.append(" order by ");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" case when length(BizChatUserInfo.userNamePY) > 0 then upper(").append("BizChatUserInfo.userNamePY) ");
            stringBuffer.append(" else upper(BizChatUserInfo.userName) end asc, ");
            stringBuffer.append(" upper(BizChatUserInfo.userNamePY) asc, ");
            stringBuffer.append(" upper(BizChatUserInfo.userName) asc ");
            append2.append(stringBuffer.toString());
            setCursor(DC.cie.rawQuery(stringBuilder.toString(), null));
            super.notifyDataSetChanged();
        }

        protected final void Om() {
            Ol();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eSt = getIntent().getStringExtra("Block_list");
        this.eSu = getIntent().getStringExtra("Chatroom_member_list");
        this.bdo = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.ezh = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.ogZ = u.DA().Z(this.ezh);
        if (this.ogZ == null) {
            v.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
            finish();
            return;
        }
        NI();
    }

    protected final void NI() {
        Fd(this.mTitle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BizChatAtSomeoneUI oha;

            {
                this.oha = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oha.setResult(0);
                this.oha.finish();
                return true;
            }
        });
        this.eSv = new p(true, true);
        this.eSv.oUs = new com.tencent.mm.ui.tools.p.b(this) {
            final /* synthetic */ BizChatAtSomeoneUI oha;

            {
                this.oha = r1;
            }

            public final void ml(String str) {
                a a = this.oha.ogY;
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
        com.tencent.mm.modelbiz.a.j jVar = new com.tencent.mm.modelbiz.a.j();
        c cVar = this.ogZ;
        String[] strArr = null;
        if (!t.kS(this.eSu)) {
            strArr = this.eSu.split(";");
            v.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        List linkedList = new LinkedList();
        if (!t.kS(this.eSt)) {
            linkedList = t.g(this.eSt.split(";"));
        }
        this.ogY = new a(this, jVar, cVar, strArr, linkedList);
        this.eyT.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BizChatAtSomeoneUI oha;

            {
                this.oha = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                com.tencent.mm.modelbiz.a.j jVar = (com.tencent.mm.modelbiz.a.j) this.oha.ogY.getItem(i);
                String a = BizChatAtSomeoneUI.a(this.oha.ogZ, jVar.field_userId);
                intent.putExtra("select_raw_user_name", jVar.field_userId);
                intent.putExtra("Select_Conv_User", a);
                this.oha.setResult(-1, intent);
                this.oha.finish();
            }
        });
        this.eyT.setAdapter(this.ogY);
        this.eyT.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ BizChatAtSomeoneUI oha;

            {
                this.oha = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                n.GL().ba(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    protected void onPause() {
        super.onPause();
        if (this.eSv != null) {
            this.eSv.bJs();
        }
    }

    protected void onDestroy() {
        this.ogY.avc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903136;
    }

    protected static String a(c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        return cVar.er(str);
    }
}
