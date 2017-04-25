package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.dn;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.gb;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI extends MMActivity implements com.tencent.mm.plugin.exdevice.model.e.b, e {
    private ListView Eq;
    private p dFI;
    private final BroadcastReceiver esp = new BroadcastReceiver(this) {
        final /* synthetic */ ExdeviceAddDataSourceUI fyV;

        {
            this.fyV = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent == null) {
                v.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
                return;
            }
            String action = intent.getAction();
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 12) {
                    if (com.tencent.mm.plugin.c.a.e.a.Xw()) {
                        this.fyV.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 fyY;

                            {
                                this.fyY = r1;
                            }

                            public final void run() {
                                if (!this.fyY.fyV.fyT || this.fyY.fyV.fyS.isProviderEnabled("gps")) {
                                    this.fyY.fyV.kp(3);
                                    v.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                                    return;
                                }
                                this.fyY.fyV.kp(4);
                            }
                        });
                        if (!this.fyV.fyT || this.fyV.fyS.isProviderEnabled("gps")) {
                            ac.ajB();
                            com.tencent.mm.plugin.exdevice.model.e.aiS();
                        }
                    }
                } else if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10 && !com.tencent.mm.plugin.c.a.e.a.Xw()) {
                    this.fyV.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 fyY;

                        {
                            this.fyY = r1;
                        }

                        public final void run() {
                            this.fyY.fyV.kp(1);
                            v.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                        }
                    });
                    ac.ajC().Xe();
                }
            }
            if (!this.fyV.fyT || !"android.location.MODE_CHANGED".equals(action)) {
                return;
            }
            if (this.fyV.fyS.isProviderEnabled("gps")) {
                this.fyV.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 fyY;

                    {
                        this.fyY = r1;
                    }

                    public final void run() {
                        if (com.tencent.mm.plugin.c.a.e.a.Xw()) {
                            this.fyY.fyV.kp(3);
                            v.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                            return;
                        }
                        this.fyY.fyV.kp(1);
                    }
                });
                if (com.tencent.mm.plugin.c.a.e.a.Xw()) {
                    ac.ajB();
                    com.tencent.mm.plugin.exdevice.model.e.aiS();
                    return;
                }
                return;
            }
            this.fyV.runOnUiThread(new Runnable(this) {
                final /* synthetic */ AnonymousClass3 fyY;

                {
                    this.fyY = r1;
                }

                public final void run() {
                    this.fyY.fyV.kp(4);
                    v.i("MicroMsg.ExdeviceAddDataSourceUI", "Stop scan...");
                }
            });
            ac.ajC().Xe();
        }
    };
    private View fgW;
    private a fyM;
    private List<b> fyN;
    private TextView fyO;
    private TextView fyP;
    private TextView fyQ;
    private RelativeLayout fyR;
    private LocationManager fyS;
    private boolean fyT = false;
    private l fyU;

    private static final class a extends BaseAdapter {
        private List<b> fyN = new LinkedList();
        private com.tencent.mm.ae.a.a.c fzb;

        private static class a {
            TextView eVA;
            ImageView eZn;

            private a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return kq(i);
        }

        public a() {
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPH = 2130838188;
            this.fzb = aVar.GU();
        }

        public final void an(List<b> list) {
            this.fyN.clear();
            if (list != null && list.size() != 0) {
                this.fyN.addAll(list);
            }
        }

        public final b sv(String str) {
            if (!be.kS(str)) {
                for (b bVar : this.fyN) {
                    if (str.equalsIgnoreCase(bVar.mac)) {
                        return bVar;
                    }
                }
            }
            return null;
        }

        public final int getCount() {
            return this.fyN.size();
        }

        public final b kq(int i) {
            return (b) this.fyN.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            b kq = kq(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), 2130903537, null);
                aVar2.eZn = (ImageView) view.findViewById(2131756775);
                aVar2.eVA = (TextView) view.findViewById(2131756776);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            v.d("MicroMsg.ExdeviceAddDataSourceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), kq.name, kq.mac});
            aVar.eVA.setText(kq.name);
            n.GL().a(kq.iconUrl, aVar.eZn, this.fzb);
            return view;
        }
    }

    private static class b {
        String bax;
        int fzc;
        public String iconUrl;
        String mac;
        String name;

        private b() {
            this.fzc = c.fzd;
        }
    }

    private enum c {
        ;

        static {
            fzd = 1;
            fze = 2;
            fzf = 3;
            fzg = new int[]{fzd, fze, fzf};
        }
    }

    protected final int getLayoutId() {
        return 2130903538;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI fyV;

            {
                this.fyV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fyV.finish();
                return true;
            }
        });
        vD(2131232490);
        if (!(!f.dW(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            this.fyT = true;
        }
        this.fyN = new LinkedList();
        this.fyS = (LocationManager) this.nDR.nEl.getSystemService("location");
        NI();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.location.MODE_CHANGED");
        this.nDR.nEl.registerReceiver(this.esp, intentFilter);
        ak.vy().a(536, this);
        ak.vy().a(1706, this);
        ac.ajB().a(this);
        if (!com.tencent.mm.plugin.c.a.e.a.by(this.nDR.nEl)) {
            v.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            kp(2);
        } else if (!com.tencent.mm.plugin.c.a.e.a.Xw()) {
            v.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
            kp(1);
        } else if (this.fyS == null || !this.fyT || this.fyS.isProviderEnabled("gps")) {
            ac.ajB();
            com.tencent.mm.plugin.exdevice.model.e.aiS();
        } else {
            v.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
            kp(4);
        }
    }

    private void kp(int i) {
        switch (i) {
            case 1:
                this.fyR.setVisibility(8);
                this.fyP.setText(2131232508);
                this.fyQ.setText(2131232496);
                return;
            case 2:
                this.fyR.setVisibility(8);
                this.fyP.setText(2131232506);
                this.fyQ.setText("");
                return;
            case 3:
                this.fyR.setVisibility(0);
                this.fgW.setVisibility(0);
                return;
            case 4:
                this.fyR.setVisibility(8);
                this.fyP.setText(2131232508);
                this.fyQ.setText(2131232543);
                return;
            default:
                return;
        }
    }

    protected final void NI() {
        this.Eq = (ListView) findViewById(2131755705);
        View inflate = View.inflate(this, 2130903540, null);
        this.fyR = (RelativeLayout) findViewById(2131756780);
        this.fgW = View.inflate(this, 2130903539, null);
        this.fyO = (TextView) findViewById(2131756781);
        this.fyP = (TextView) findViewById(2131756778);
        this.fyQ = (TextView) findViewById(2131756779);
        String string = getString(2131232579);
        String string2 = getString(2131232515);
        CharSequence spannableString = new SpannableString(string + string2);
        spannableString.setSpan(new ForegroundColorSpan(2131689819), string.length(), string.length() + string2.length(), 33);
        spannableString.setSpan(new ClickableSpan(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI fyV;

            {
                this.fyV = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.exdevice.model.f.P(this.fyV.nDR.nEl, "https://hw.weixin.qq.com/steprank/step/connect-help.html");
            }

            public final void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(false);
            }
        }, string.length(), string.length() + string2.length(), 33);
        this.fyO.setMovementMethod(LinkMovementMethod.getInstance());
        this.fyO.setText(spannableString);
        this.Eq.addHeaderView(inflate, null, false);
        this.Eq.addFooterView(this.fgW, null, false);
        this.fyM = new a();
        this.Eq.setAdapter(this.fyM);
        this.Eq.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI fyV;

            {
                this.fyV = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b kq = this.fyV.fyM.kq(i - ((ListView) adapterView).getHeaderViewsCount());
                if (kq.fzc == c.fzd) {
                    if (ExdeviceAddDataSourceUI.W(kq.mac, true)) {
                        this.fyV.runOnUiThread(new Runnable(this.fyV, kq.mac) {
                            final /* synthetic */ ExdeviceAddDataSourceUI fyV;

                            public final void run() {
                                this.fyV.dFI = g.a(this.fyV.nDR.nEl, this.fyV.getString(2131231182), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass2 fyX;

                                    {
                                        this.fyX = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(this.fyX.fyV.fyU);
                                        this.fyX.fyV.fyU = null;
                                        b sv = this.fyX.fyV.fyM.sv(r2);
                                        if (sv != null) {
                                            sv.fzc = c.fzd;
                                        }
                                    }
                                });
                            }
                        });
                        kq.fzc = c.fze;
                        this.fyV.fyM.notifyDataSetChanged();
                        return;
                    }
                    v.i("MicroMsg.ExdeviceAddDataSourceUI", "try connect device failed.");
                }
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(536, this);
        ak.vy().b(1706, this);
        ac.ajB().b(this);
        ac.ajC().Xe();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            v.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
        } else if (kVar.getType() == 536) {
            akc();
            this.fyU = null;
            gb ajj = ((l) kVar).ajj();
            if (i == 0 && i2 == 0) {
                Intent intent = new Intent();
                intent.putExtra("device_mac", com.tencent.mm.plugin.exdevice.j.b.sE(com.tencent.mm.plugin.exdevice.j.b.sF(ajj.mgn.mfU)));
                W(com.tencent.mm.plugin.exdevice.j.b.sF(ajj.mgn.mfU), false);
                setResult(-1, intent);
                finish();
                return;
            }
            b sv = this.fyM.sv(com.tencent.mm.plugin.exdevice.j.b.sF(ajj.mgn.mfU));
            if (sv != null) {
                sv.fzc = c.fzd;
                W(sv.mac, false);
            }
            v.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
        } else if (kVar.getType() == 1706) {
            arp ajm = ((t) kVar).ajm();
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[]{Long.valueOf(ajm.mgn.bLh)});
                if (0 == (ajm.mgn.bLh & 1)) {
                    return;
                }
                if (ac.ajq().bs(ajm.mgm.eez, ajm.mgm.meq) != null) {
                    v.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[]{ajm.mgn.mfU});
                    return;
                }
                b bVar = new b();
                bVar.name = ajm.mga.mEj == null ? "" : m.a(ajm.mga.mEj);
                bVar.mac = com.tencent.mm.plugin.exdevice.j.b.sF(ajm.mgn.mfU);
                bVar.bax = ajm.mfZ;
                bVar.iconUrl = ajm.mgn.gnp;
                this.fyN.add(bVar);
                v.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[]{bVar.mac, bVar.name});
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceAddDataSourceUI fyV;

                    {
                        this.fyV = r1;
                    }

                    public final void run() {
                        this.fyV.fyM.an(this.fyV.fyN);
                        this.fyV.fyM.notifyDataSetChanged();
                    }
                });
                return;
            }
            v.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    public final void h(String str, String str2, boolean z) {
        v.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
        if (z) {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceAddDataSourceUI fyV;

                {
                    this.fyV = r1;
                }

                public final void run() {
                    this.fyV.fgW.setVisibility(8);
                    this.fyV.fyM.notifyDataSetChanged();
                }
            });
        }
        if (be.kS(str2)) {
            v.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
            return;
        }
        int i = 0;
        while (i < this.fyN.size()) {
            int i2;
            b bVar = (b) this.fyN.get(i);
            if (bVar == null || be.kS(bVar.mac)) {
                i2 = i - 1;
                this.fyN.remove(i);
            } else if (bVar.mac.equalsIgnoreCase(str2)) {
                v.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", new Object[]{str2});
                return;
            } else {
                i2 = i;
            }
            i = i2 + 1;
        }
        boolean a = ak.vy().a(new t(str2.replaceAll(":", ""), null, null), 0);
        v.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[]{Boolean.valueOf(a), str2});
    }

    public final void b(String str, int i, long j) {
        if (be.kS(str)) {
            v.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
            return;
        }
        final b sv = this.fyM.sv(str);
        if (sv == null) {
            v.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[]{str});
            return;
        }
        if (sv.fzc == c.fze && i == 4) {
            sv.fzc = c.fzd;
            akc();
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceAddDataSourceUI fyV;

                public final void run() {
                    g.a(this.fyV, 2131232518, 2131232516, 2131232517, 2131232519, false, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass8 fza;

                        {
                            this.fza = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.fza.fyV.fyN.remove(sv);
                            this.fza.fyV.fyM.an(this.fza.fyV.fyN);
                            this.fza.fyV.fyM.notifyDataSetChanged();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass8 fza;

                        {
                            this.fza = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.exdevice.model.f.P(this.fza.fyV.nDR.nEl, "https://hw.weixin.qq.com/steprank/step/connect-help.html");
                        }
                    }).show();
                }
            });
        } else if (i == 2) {
            if (sv.fzc == c.fze) {
                sv.fzc = c.fzf;
                v.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[]{sv.mac, sv.name});
                if (sv.bax != null) {
                    this.fyU = new l(sv.bax, 0);
                    ak.vy().a(this.fyU, 0);
                }
            } else {
                v.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[]{str});
                W(str, false);
            }
        } else if (i != 1 && i != 2) {
            sv.fzc = c.fzd;
        } else {
            return;
        }
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI fyV;

            {
                this.fyV = r1;
            }

            public final void run() {
                this.fyV.fyM.notifyDataSetChanged();
            }
        });
    }

    public final void c(String str, byte[] bArr, boolean z) {
    }

    private static boolean W(String str, boolean z) {
        dn dnVar = new dn();
        dnVar.bbC.mac = str;
        dnVar.bbC.aZV = z;
        if (com.tencent.mm.sdk.c.a.nhr.z(dnVar)) {
            return true;
        }
        v.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[]{str});
        return false;
    }

    private void akc() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceAddDataSourceUI fyV;

            {
                this.fyV = r1;
            }

            public final void run() {
                if (this.fyV.dFI != null && this.fyV.dFI.isShowing()) {
                    this.fyV.dFI.dismiss();
                }
            }
        });
    }
}
