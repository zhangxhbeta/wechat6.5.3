package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.p.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailAddrListUI extends MMActivity {
    private j ibk = null;
    private p ieX = null;
    private TextView ieY = null;
    private TextView ieZ = null;
    private ListView ifa;
    private a ifb;
    private List<i> ifc;
    private com.tencent.mm.plugin.qqmail.b.j.a ifd = new com.tencent.mm.plugin.qqmail.b.j.a(this) {
        final /* synthetic */ MailAddrListUI ife;

        {
            this.ife = r1;
        }

        public final void onComplete() {
            if (this.ife.ieX != null) {
                this.ife.ieX.dismiss();
            }
            this.ife.ifc = this.ife.ibk.ya(null);
            if (this.ife.ifc.size() == 0) {
                this.ife.ieY.setText(2131235120);
                this.ife.ieY.setVisibility(0);
            }
            String[] stringArrayExtra = this.ife.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
            for (String yb : stringArrayExtra == null ? new String[]{""} : stringArrayExtra) {
                i yb2 = j.yb(yb);
                if (yb2 != null) {
                    int i;
                    for (i iVar : this.ife.ifc) {
                        if (iVar.gRG.equalsIgnoreCase(yb2.gRG)) {
                            this.ife.ifb.c(iVar);
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        this.ife.ifb.c(yb2);
                    }
                }
            }
            this.ife.Fd(this.ife.getString(2131234187) + (this.ife.ifb.aIg() > 0 ? "(" + this.ife.ifb.aIg() + ")" : ""));
            this.ife.ifb.notifyDataSetChanged();
        }
    };

    class a extends BaseAdapter {
        private final Context context;
        final /* synthetic */ MailAddrListUI ife;
        boolean iff = false;
        boolean ifg = false;
        Map<String, i> ifh = new HashMap();

        class a {
            CheckBox dua;
            TextView eVA;
            TextView ifi;
            TextView ifj;
            final /* synthetic */ a ifk;

            a(a aVar) {
                this.ifk = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return oz(i);
        }

        public a(MailAddrListUI mailAddrListUI, Context context) {
            this.ife = mailAddrListUI;
            this.context = context;
        }

        public final void c(i iVar) {
            this.ifh.put(iVar.gRG, iVar);
        }

        public final int aIg() {
            return this.ifh.size();
        }

        public final int getCount() {
            int size = this.ife.ifc.size();
            if (size != 0) {
                return !this.ifg ? size + 1 : size;
            } else {
                if (this.iff) {
                    return 1;
                }
                return 0;
            }
        }

        private TextView aIh() {
            TextView textView = new TextView(this.context);
            textView.setBackgroundResource(2130838472);
            textView.setTextColor(-16777216);
            textView.setTextSize(0, (float) this.ife.getResources().getDimensionPixelSize(2131493128));
            int dimensionPixelSize = this.ife.getResources().getDimensionPixelSize(2131493135);
            int dimensionPixelSize2 = this.ife.getResources().getDimensionPixelSize(2131493199);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            return textView;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z;
            if (i == 0) {
                if (this.iff) {
                    view = aIh();
                    view.setText(2131234196);
                    int dimensionPixelSize = this.ife.getResources().getDimensionPixelSize(2131493135);
                    view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    view.setTextSize(0, (float) this.ife.getResources().getDimensionPixelSize(2131492967));
                    view.setGravity(17);
                    return view;
                } else if (!this.ifg) {
                    view = aIh();
                    view.setText(2131234195);
                    return view;
                }
            }
            if (view == null || view.getTag() == null) {
                a aVar2 = new a(this);
                view = View.inflate(this.context, 2130904211, null);
                aVar2.ifi = (TextView) view.findViewById(2131758683);
                aVar2.eVA = (TextView) view.findViewById(2131758685);
                aVar2.ifj = (TextView) view.findViewById(2131758686);
                aVar2.dua = (CheckBox) view.findViewById(2131758687);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            i oz = oz(i);
            if (this.ifg || i <= 10) {
                aVar.ifi.setVisibility(8);
            } else {
                i oz2 = oz(i - 1);
                if (i == 11) {
                    oz2 = null;
                }
                String d = d(oz);
                String d2 = d(oz2);
                if (d == null) {
                    aVar.ifi.setVisibility(8);
                } else if (d.equals(d2)) {
                    aVar.ifi.setVisibility(8);
                } else {
                    aVar.ifi.setText(d.toUpperCase());
                    aVar.ifi.setVisibility(0);
                }
            }
            aVar.eVA.setText(oz.name);
            aVar.ifj.setText(oz.gRG);
            CheckBox checkBox = aVar.dua;
            if (this.ifh.get(oz.gRG) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            return view;
        }

        private static String d(i iVar) {
            if (iVar == null) {
                return null;
            }
            String xW = com.tencent.mm.plugin.qqmail.b.a.xW(iVar.iaO);
            char charAt = xW.length() > 1 ? xW.charAt(0) : '~';
            switch (charAt) {
                case au.CTRL_INDEX /*123*/:
                    charAt = xW.charAt(1);
                    if (be.j(charAt)) {
                        return String.valueOf(charAt);
                    }
                    return "~";
                case '~':
                    return "~";
                default:
                    if (be.i(charAt)) {
                        return String.valueOf(charAt);
                    }
                    return "~";
            }
        }

        public final i oz(int i) {
            if (!this.ifg) {
                i = i == 0 ? 0 : i - 1;
            }
            return (i) this.ife.ifc.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final boolean areAllItemsEnabled() {
            return false;
        }

        public final boolean isEnabled(int i) {
            if (i == 0) {
                return this.ifg;
            }
            return true;
        }
    }

    protected final int getLayoutId() {
        return 2130904210;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131234187);
        this.ifc = new ArrayList();
        this.ibk = x.aHG().ibk;
        NI();
        this.ibk.a(this.ifd);
        this.ibk.aHv();
    }

    protected final void NI() {
        this.ifa = (ListView) findViewById(2131758681);
        this.ieY = (TextView) findViewById(2131757510);
        this.ieZ = (TextView) findViewById(2131758682);
        this.ifb = new a(this, this);
        com.tencent.mm.ui.tools.p pVar = new com.tencent.mm.ui.tools.p(true, true);
        pVar.oUs = new b(this) {
            final /* synthetic */ MailAddrListUI ife;

            {
                this.ife = r1;
            }

            public final void Oh() {
            }

            public final boolean mk(String str) {
                return false;
            }

            public final void ml(String str) {
                String ah = be.ah(str, "");
                this.ife.ifc = this.ife.ibk.ya(ah.toLowerCase().trim());
                if (ah.length() > 0) {
                    this.ife.ifb.ifg = true;
                } else {
                    this.ife.ifb.ifg = false;
                }
                this.ife.ifb.iff = false;
                if (this.ife.ifc.size() == 0) {
                    this.ife.iT(false);
                    this.ife.ieZ.setVisibility(0);
                } else {
                    this.ife.iT(true);
                    this.ife.ieZ.setVisibility(8);
                }
                this.ife.ifb.notifyDataSetChanged();
            }

            public final void Of() {
            }

            public final void Og() {
            }
        };
        a(pVar);
        this.ifa.setAdapter(this.ifb);
        this.ifa.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MailAddrListUI ife;

            {
                this.ife = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a e = this.ife.ifb;
                i oz = e.oz(i - this.ife.ifa.getHeaderViewsCount());
                String str = oz.gRG;
                if (e.ifh.containsKey(str)) {
                    e.ifh.remove(str);
                } else {
                    e.ifh.put(str, oz);
                }
                e.notifyDataSetChanged();
                this.ife.Fd(this.ife.getString(2131234187) + (this.ife.ifb.aIg() > 0 ? "(" + this.ife.ifb.aIg() + ")" : ""));
            }
        });
        this.ifa.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ MailAddrListUI ife;

            {
                this.ife = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    this.ife.axg();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.ifc = this.ibk.ya(null);
        this.ifb.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MailAddrListUI ife;

            {
                this.ife = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ife.setResult(0);
                this.ife.finish();
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new OnClickListener(this) {
            final /* synthetic */ MailAddrListUI ife;

            {
                this.ife = r1;
            }

            public final void onClick(View view) {
                c.a(this.ife.ifa);
            }
        };
        a(0, getString(2131234186), new OnMenuItemClickListener(this) {
            final /* synthetic */ MailAddrListUI ife;

            {
                this.ife = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                a e = this.ife.ifb;
                List arrayList = new ArrayList();
                for (String str : e.ifh.keySet()) {
                    arrayList.add(e.ifh.get(str));
                }
                ComposeUI.aZ(arrayList);
                this.ife.setResult(-1);
                this.ife.finish();
                return true;
            }
        });
        iT(!this.ifc.isEmpty());
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.ieX = g.a(actionBarActivity, getString(2131234185), true, new OnCancelListener(this) {
            final /* synthetic */ MailAddrListUI ife;

            {
                this.ife = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.ifb.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.ibk.b(this.ifd);
    }
}
