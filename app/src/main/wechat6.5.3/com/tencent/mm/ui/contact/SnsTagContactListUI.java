package com.tencent.mm.ui.contact;

import android.content.Context;
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
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.q;
import com.tencent.mm.pluginsdk.j.q.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class SnsTagContactListUI extends MMActivity {
    private ListView gQL;
    private a oIV;
    private List<Long> oIW = new ArrayList();

    private static class a extends BaseAdapter {
        private Context context = null;
        private aa jMH = null;
        private Map<Integer, com.tencent.mm.i.a> oIQ = new HashMap();
        private ColorStateList oIR;
        private ColorStateList oIS;
        private Map<Integer, String> oIY = new HashMap();

        public a(Context context, List<Long> list) {
            this.context = context;
            this.oIQ.clear();
            this.oIY.clear();
            ak.yW();
            this.jMH = c.wH();
            int i = 0;
            for (Long longValue : list) {
                long longValue2 = longValue.longValue();
                g gVar = j.ak.lyh;
                if (gVar != null) {
                    for (String str : gVar.dg(longValue2)) {
                        com.tencent.mm.i.a aVar = new com.tencent.mm.i.a();
                        aVar.setUsername(str);
                        this.oIY.put(Integer.valueOf(this.oIQ.size()), gVar.dh(longValue2));
                        int i2 = i + 1;
                        this.oIQ.put(Integer.valueOf(i), aVar);
                        i = i2;
                    }
                }
                i = i;
            }
            try {
                XmlPullParser xml = context.getResources().getXml(2131690159);
                XmlPullParser xml2 = context.getResources().getXml(2131690160);
                this.oIR = ColorStateList.createFromXml(context.getResources(), xml);
                this.oIS = ColorStateList.createFromXml(context.getResources(), xml2);
            } catch (Throwable e) {
                v.a("MicroMsg.SnsTagContactList", e, "", new Object[0]);
            } catch (Throwable e2) {
                v.a("MicroMsg.SnsTagContactList", e2, "", new Object[0]);
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
            b bVar;
            if (view == null) {
                view = View.inflate(this.context, 2130903416, null);
                b bVar2 = new b();
                bVar2.gKV = (TextView) view.findViewById(2131755332);
                bVar2.eST = (MaskLayout) view.findViewById(2131756021);
                bVar2.exG = (TextView) view.findViewById(2131756022);
                bVar2.oIU = (TextView) view.findViewById(2131756493);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (((com.tencent.mm.i.a) getItem(i - 1)) == null) {
                Object obj = "";
            } else {
                String xU = xU(i - 1);
            }
            com.tencent.mm.i.a aVar = (com.tencent.mm.i.a) getItem(i);
            if (i == 0) {
                bVar.gKV.setVisibility(0);
                bVar.gKV.setText(xU(i));
                bVar.gKV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else if (i <= 0 || xU(i).equals(r1)) {
                bVar.gKV.setVisibility(8);
            } else {
                bVar.gKV.setVisibility(0);
                bVar.gKV.setText(xU(i));
                bVar.gKV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            bVar.exG.setTextColor(!m.fn(aVar.field_username) ? this.oIR : this.oIS);
            com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) bVar.eST.view, aVar.field_username, true);
            bVar.oIU.setVisibility(8);
            bVar.eST.setVisibility(0);
            bVar.exG.setText(e.a(this.context, aVar.tU(), bVar.exG.getTextSize()));
            bVar.exG.setVisibility(0);
            return view;
        }

        private String xU(int i) {
            if (this.oIY.containsKey(Integer.valueOf(i))) {
                return (String) this.oIY.get(Integer.valueOf(i));
            }
            return "";
        }
    }

    private static class b {
        MaskLayout eST;
        TextView exG;
        TextView gKV;
        TextView oIU;

        private b() {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        vD(2131235542);
        findViewById(2131759528).setVisibility(8);
        this.gQL = (ListView) findViewById(2131755317);
        long[] longArrayExtra = getIntent().getLongArrayExtra("sns_tag_list");
        if (longArrayExtra == null) {
            finish();
            return;
        }
        for (long valueOf : longArrayExtra) {
            this.oIW.add(Long.valueOf(valueOf));
        }
        ((TextView) findViewById(2131755319)).setVisibility(8);
        findViewById(2131755320).setVisibility(8);
        this.gQL.setBackgroundColor(getResources().getColor(2131690127));
        ((View) this.gQL.getParent()).setBackgroundColor(getResources().getColor(2131690127));
        this.oIV = new a(this, this.oIW);
        this.gQL.setAdapter(this.oIV);
        this.gQL.setVisibility(0);
        this.gQL.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SnsTagContactListUI oIX;

            {
                this.oIX = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                com.tencent.mm.i.a aVar = (com.tencent.mm.i.a) this.oIX.oIV.getItem(i);
                q.e eVar = j.ak.lyj;
                if (eVar == null) {
                    this.oIX.finish();
                    return;
                }
                Intent e = eVar.e(intent, aVar.field_username);
                if (e == null) {
                    this.oIX.finish();
                } else {
                    com.tencent.mm.ay.c.b(this.oIX.nDR.nEl, "sns", ".ui.SnsUserUI", e);
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagContactListUI oIX;

            {
                this.oIX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oIX.finish();
                return true;
            }
        });
        iU(false);
    }

    public void onResume() {
        super.onResume();
        if (this.oIV != null) {
            this.oIV.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903088;
    }
}
