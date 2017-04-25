package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.s;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.j;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SnsTagUI extends MMActivity implements e {
    public static int[] jPE = new int[]{2131235537, 2131235540};
    public static int[] jTT = new int[]{2131235526, 2131235541};
    private ListView gMx;
    private a jTQ;
    private HashMap<Long, String> jTR = new HashMap();
    private View[] jTS = new View[2];
    private int jTU = 0;
    private OnClickListener jTV = new OnClickListener(this) {
        final /* synthetic */ SnsTagUI jTW;

        {
            this.jTW = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof Integer) {
                this.jTW.rf(((Integer) view.getTag()).intValue());
            }
        }
    };
    private int linkColor;

    class a extends j<q> {
        OnClickListener gsK = new OnClickListener(this) {
            final /* synthetic */ a jTX;

            {
                this.jTX = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof a) {
                    this.jTX.jTW.aXv();
                    a aVar = (a) view.getTag();
                    if (this.jTX.jTW.jTR.containsKey(Long.valueOf(aVar.jkF))) {
                        this.jTX.jTW.jTR.remove(Long.valueOf(aVar.jkF));
                        if (this.jTX.jTW.jTR.isEmpty()) {
                            this.jTX.jTW.rf(0);
                        }
                    } else {
                        this.jTX.jTW.jTR.put(Long.valueOf(aVar.jkF), aVar.jTY);
                    }
                    this.jTX.jTW.jTQ.notifyDataSetChanged();
                }
            }
        };
        final /* synthetic */ SnsTagUI jTW;

        class a {
            ImageView hiF;
            TextView jTN;
            TextView jTO;
            final /* synthetic */ a jTX;
            String jTY;
            TextView jTZ;
            View jUa;
            View jUb;
            long jkF;
            int position;

            a(a aVar) {
                this.jTX = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (q) obj;
            if (obj == null) {
                obj = new q();
            }
            obj.b(cursor);
            return obj;
        }

        public a(SnsTagUI snsTagUI, Context context, q qVar) {
            this.jTW = snsTagUI;
            super(context, qVar);
        }

        protected final void Om() {
            avc();
            Ol();
        }

        public final void Ol() {
            r aSI = ad.aSI();
            super.setCursor(aSI.cie.rawQuery(r.aVh() + " where tagId > 5", null));
            notifyDataSetChanged();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            q qVar = (q) super.getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = View.inflate(this.context, 2130904501, null);
                a aVar2 = new a(this);
                aVar2.hiF = (ImageView) view.findViewById(2131759473);
                aVar2.jTN = (TextView) view.findViewById(2131759471);
                aVar2.jTO = (TextView) view.findViewById(2131758477);
                aVar2.jUa = view.findViewById(2131759470);
                aVar2.jTZ = (TextView) aVar2.jUa.findViewById(16908310);
                aVar2.jUb = view.findViewById(2131756639);
                view.setTag(aVar2);
                view.setOnClickListener(this.gsK);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.position = i;
            aVar.jkF = qVar.field_tagId;
            aVar.jTY = qVar.field_tagName;
            if (this.jTW.jTR.containsKey(Long.valueOf(qVar.field_tagId))) {
                aVar.hiF.setImageResource(2131165400);
            } else {
                aVar.hiF.setImageResource(2131165403);
            }
            aVar.jTN.setText(qVar.field_tagName);
            aVar.jTO.setText("  (" + qVar.field_count + ")");
            aVar.jTO.setVisibility(0);
            return view;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        aXt();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131235544);
        NI();
        ak.vy().a(292, this);
        ak.vy().a(new s(), 0);
    }

    protected void onDestroy() {
        ak.vy().b(292, this);
        this.jTQ.avc();
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.jTQ != null) {
            this.jTQ.a("", null);
        }
    }

    public final void aXt() {
        String str = "";
        String str2 = "";
        if (this.jTU < 0 || this.jTU >= 2) {
            Iterator it = new ArrayList(this.jTR.keySet()).iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                q df = ad.aSI().df(longValue);
                if (df.field_tagId == 0) {
                    this.jTR.remove(Long.valueOf(longValue));
                } else {
                    this.jTR.put(Long.valueOf(longValue), be.ah(df.field_tagName, ""));
                }
            }
            Object obj = 1;
            for (Long l : this.jTR.keySet()) {
                String str3;
                if (obj == null) {
                    str = str + ",";
                    str2 = str2 + ",";
                    str3 = str;
                } else {
                    str3 = str;
                }
                str3 = str3 + ((String) this.jTR.get(l));
                str2 = str2 + l;
                obj = null;
                str = str3;
            }
        } else {
            str = getString(jPE[this.jTU]);
        }
        Intent intent = new Intent();
        intent.putExtra("Ktag_name_list", str);
        intent.putExtra("Ktag_id_list", str2);
        intent.putExtra("Ktag_range_index", this.jTU);
        setResult(-1, intent);
        finish();
    }

    protected final void NI() {
        View findViewById;
        this.linkColor = getResources().getColor(2131690029);
        boolean booleanExtra = getIntent().getBooleanExtra("Ktag_rangeFilterprivate", false);
        this.gMx = (ListView) findViewById(2131759467);
        int i = 0;
        while (i < 2) {
            this.jTS[i] = new View(this);
            this.jTS[i] = View.inflate(this, 2130904501, null);
            ((TextView) this.jTS[i].findViewById(2131759471)).setText(jPE[i]);
            this.jTS[i].findViewById(2131759472).setVisibility(0);
            ((TextView) this.jTS[i].findViewById(2131759472)).setText(jTT[i]);
            ((TextView) this.jTS[i].findViewById(2131759472)).setVisibility(8);
            this.jTS[i].setTag(Integer.valueOf(i));
            this.jTS[i].setOnClickListener(this.jTV);
            if (i != 0) {
                this.jTS[1].findViewById(2131759470).setVisibility(8);
            }
            if (booleanExtra && i == 1) {
                this.jTS[1].setLayoutParams(new LayoutParams(-1, 1));
                this.jTS[1].setVisibility(8);
            }
            if (i == 1) {
                findViewById = this.jTS[1].findViewById(2131756639);
                int[] iArr = new int[]{findViewById.getPaddingLeft(), findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom()};
                findViewById.setBackgroundResource(2130838472);
                findViewById.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
            this.gMx.addHeaderView(this.jTS[i]);
            i++;
        }
        findViewById = View.inflate(this, 2130904500, null);
        this.gMx.addFooterView(findViewById, null, false);
        this.jTQ = new a(this, this, new q());
        this.gMx.setAdapter(this.jTQ);
        aXu();
        findViewById.findViewById(2131759469).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsTagUI jTW;

            {
                this.jTW = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("k_sns_tag_id", 4);
                intent.setClass(this.jTW, SnsBlackDetailUI.class);
                this.jTW.startActivity(intent);
            }
        });
        findViewById.findViewById(2131759468).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsTagUI jTW;

            {
                this.jTW = r1;
            }

            public final void onClick(View view) {
                this.jTW.q(SnsTagPartlyUI.class);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagUI jTW;

            {
                this.jTW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jTW.aXt();
                return true;
            }
        });
    }

    private void aXu() {
        int i = 0;
        this.jTU = 0;
        switch (this.jTU) {
            case 0:
            case 1:
                rf(this.jTU);
                return;
            case 2:
                String stringExtra = getIntent().getStringExtra("Ktag_id_list");
                String stringExtra2 = getIntent().getStringExtra("Ktag_name_list");
                String[] split = stringExtra.split(",");
                String[] split2 = stringExtra2.split(",");
                int min = Math.min(split.length, split2.length);
                while (i < min) {
                    this.jTR.put(Long.valueOf(be.getLong(split[i], 0)), split2[i]);
                    i++;
                }
                return;
            default:
                return;
        }
    }

    private void rf(int i) {
        if (i >= 0 && i < 2) {
            aXv();
            this.jTU = i;
            ((ImageView) this.jTS[i].findViewById(2131759473)).setImageResource(2131165400);
            this.jTR.clear();
            if (this.jTQ != null) {
                this.jTQ.notifyDataSetChanged();
            }
        }
    }

    private void aXv() {
        this.jTU = 2;
        for (int i = 0; i < 2; i++) {
            ((ImageView) this.jTS[i].findViewById(2131759473)).setImageResource(2131165403);
        }
    }

    protected final int getLayoutId() {
        return 2130904499;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            this.jTQ.a("", null);
        }
    }
}
