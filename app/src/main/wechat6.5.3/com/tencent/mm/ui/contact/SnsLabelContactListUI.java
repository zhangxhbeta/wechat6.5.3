package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.gp;
import com.tencent.mm.e.a.lx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.q;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class SnsLabelContactListUI extends MMActivity {
    private ListView gQL;
    private awa jaB;
    private a oIK;
    private ArrayList<String> oIL = new ArrayList();
    private int oIM;
    private String oIN;
    private b oIO;

    private static class a extends BaseAdapter {
        private Context context = null;
        private aa jMH = null;
        private Map<Integer, com.tencent.mm.i.a> oIQ = new HashMap();
        private ColorStateList oIR;
        private ColorStateList oIS;

        public a(Context context, List<String> list) {
            this.context = context;
            this.oIQ.clear();
            ak.yW();
            this.jMH = com.tencent.mm.model.c.wH();
            int i = 0;
            for (String str : list) {
                com.tencent.mm.i.a aVar = new com.tencent.mm.i.a();
                aVar.setUsername(str);
                int i2 = i + 1;
                this.oIQ.put(Integer.valueOf(i), aVar);
                i = i2;
            }
            try {
                XmlPullParser xml = context.getResources().getXml(2131690159);
                XmlPullParser xml2 = context.getResources().getXml(2131690160);
                this.oIR = ColorStateList.createFromXml(context.getResources(), xml);
                this.oIS = ColorStateList.createFromXml(context.getResources(), xml2);
            } catch (Throwable e) {
                v.a("MicroMsg.SnsLabelContactListUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            } catch (Throwable e2) {
                v.a("MicroMsg.SnsLabelContactListUI", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }

        public final int getCount() {
            return this.oIQ.size();
        }

        public final Object getItem(int i) {
            if (i < 0) {
                return null;
            }
            com.tencent.mm.i.a aVar = (com.tencent.mm.i.a) this.oIQ.get(Integer.valueOf(i));
            if (aVar.field_showHead != 0) {
                return aVar;
            }
            u LX = this.jMH.LX(aVar.field_username);
            if (LX == null) {
                return aVar;
            }
            this.oIQ.put(Integer.valueOf(i), LX);
            return LX;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = View.inflate(this.context, 2130903416, null);
                c cVar2 = new c();
                cVar2.gKV = (TextView) view.findViewById(2131755332);
                cVar2.eST = (MaskLayout) view.findViewById(2131756021);
                cVar2.exG = (TextView) view.findViewById(2131756022);
                cVar2.oIU = (TextView) view.findViewById(2131756493);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            getItem(i);
            com.tencent.mm.i.a aVar = (com.tencent.mm.i.a) getItem(i);
            cVar.gKV.setVisibility(8);
            cVar.exG.setTextColor(!m.fn(aVar.field_username) ? this.oIR : this.oIS);
            com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) cVar.eST.view, aVar.field_username, true);
            cVar.oIU.setVisibility(8);
            cVar.eST.setVisibility(0);
            cVar.exG.setText(e.a(this.context, aVar.tU(), cVar.exG.getTextSize()));
            cVar.exG.setVisibility(0);
            return view;
        }
    }

    private static class c {
        MaskLayout eST;
        TextView exG;
        TextView gKV;
        TextView oIU;

        private c() {
        }
    }

    private class b extends com.tencent.mm.sdk.c.c<lx> {
        final /* synthetic */ SnsLabelContactListUI oIP;

        private b(SnsLabelContactListUI snsLabelContactListUI) {
            this.oIP = snsLabelContactListUI;
            this.nhz = lx.class.getName().hashCode();
        }

        /* synthetic */ b(SnsLabelContactListUI snsLabelContactListUI, byte b) {
            this(snsLabelContactListUI);
            this.nhz = lx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            lx lxVar = (lx) bVar;
            if (!(lxVar instanceof lx)) {
                return false;
            }
            this.oIP.jaB = lxVar.bnc.bgg;
            if (this.oIP.jaB != null) {
                this.oIP.bHY();
                this.oIP.NI();
            } else {
                this.oIP.NI();
                g.a(this.oIP, this.oIP.getString(2131235435), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                    final /* synthetic */ b oIT;

                    {
                        this.oIT = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oIT.oIP.finish();
                    }
                });
            }
            return true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oIO = new b();
        com.tencent.mm.sdk.c.a.nhr.e(this.oIO);
        this.oIM = getIntent().getIntExtra("sns_label_sns_info", -1);
        if (this.oIM == -1) {
            finish();
            return;
        }
        com.tencent.mm.sdk.c.b gpVar = new gp();
        gpVar.bge.bcm = this.oIM;
        com.tencent.mm.sdk.c.a.nhr.z(gpVar);
        this.jaB = gpVar.bgf.bgg;
        if (this.jaB == null) {
            return;
        }
        if ((this.jaB.mTr == 3 && this.jaB.mTw != null && this.jaB.mTw.size() > 0) || (this.jaB.mTr == 5 && this.jaB.mIw != null && this.jaB.mIw.size() > 0)) {
            bHY();
            NI();
        }
    }

    private void bHY() {
        Iterator it;
        if (this.jaB.mTr == 3) {
            this.oIN = getString(2131235433);
            it = this.jaB.mTw.iterator();
            while (it.hasNext()) {
                this.oIL.add(((arf) it.next()).mQy);
            }
        } else if (this.jaB.mTr == 5) {
            this.oIN = getString(2131235434);
            it = this.jaB.mIw.iterator();
            while (it.hasNext()) {
                this.oIL.add(((arf) it.next()).mQy);
            }
        }
    }

    protected final void NI() {
        Fd(this.oIN);
        findViewById(2131759528).setVisibility(8);
        this.gQL = (ListView) findViewById(2131755317);
        ((TextView) findViewById(2131755319)).setVisibility(8);
        findViewById(2131755320).setVisibility(8);
        this.gQL.setBackgroundColor(getResources().getColor(com.tencent.mm.bi.a.a.white));
        ((View) this.gQL.getParent()).setBackgroundColor(getResources().getColor(com.tencent.mm.bi.a.a.white));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLabelContactListUI oIP;

            {
                this.oIP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oIP.finish();
                return true;
            }
        });
        iU(false);
        if (this.oIL != null && this.oIL.size() != 0) {
            this.oIK = new a(this, this.oIL);
            this.gQL.setAdapter(this.oIK);
            this.gQL.setVisibility(0);
            this.gQL.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ SnsLabelContactListUI oIP;

                {
                    this.oIP = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    Intent intent = new Intent();
                    com.tencent.mm.i.a aVar = (com.tencent.mm.i.a) this.oIP.oIK.getItem(i);
                    q.e eVar = j.ak.lyj;
                    if (eVar == null) {
                        this.oIP.finish();
                        return;
                    }
                    Intent e = eVar.e(intent, aVar.field_username);
                    if (e == null) {
                        this.oIP.finish();
                    } else {
                        com.tencent.mm.ay.c.b(this.oIP.nDR.nEl, "sns", ".ui.SnsUserUI", e);
                    }
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        if (this.oIK != null) {
            this.oIK.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.oIO);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903088;
    }
}
