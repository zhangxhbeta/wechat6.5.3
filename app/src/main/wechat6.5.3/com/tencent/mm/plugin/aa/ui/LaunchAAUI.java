package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.c.e;
import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.j;
import com.tencent.mm.protocal.c.w;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAUI extends BaseAAPresenterActivity {
    private String biB = null;
    private TextView dtD;
    private Dialog dtK;
    private boolean duO = false;
    private TextView dvA;
    private d dvB = new d();
    private int dvC = 0;
    private int dvD = 0;
    private boolean dvE = false;
    private e dve = ((e) i(e.class));
    private com.tencent.mm.plugin.aa.a.c.d dvf = this.dve.NC();
    private boolean dvg = false;
    private MMEditText dvh;
    private TextView dvi;
    private TextView dvj;
    private TextView dvk;
    private TextView dvl;
    private WalletFormView dvm;
    private TextView dvn;
    private TextView dvo;
    private ViewGroup dvp;
    private ViewGroup dvq;
    private List<String> dvr = new ArrayList();
    private ViewGroup dvs;
    private ViewGroup dvt;
    private TextView dvu;
    private ViewGroup dvv;
    private Map<String, Double> dvw = new HashMap();
    private Map<String, LaunchAAByPersonNameAmountRow> dvx = new HashMap();
    private Button dvy;
    private TextView dvz;
    private int mode = a.drD;

    static /* synthetic */ void a(LaunchAAUI launchAAUI) {
        if (launchAAUI.mode != a.drD) {
            launchAAUI.NU();
            launchAAUI.NX();
        } else if (!be.kS(launchAAUI.dvm.getText()) && launchAAUI.dvr != null && launchAAUI.dvr.size() != 0) {
            launchAAUI.NU();
            g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
            Map hashMap = new HashMap();
            try {
                Object string;
                String obj = launchAAUI.dvh.getText().toString();
                if (be.kS(obj)) {
                    string = launchAAUI.getString(2131233488);
                } else {
                    String str = obj;
                }
                double d = be.getDouble(launchAAUI.dvm.getText(), 0.0d);
                hashMap.put(k.dsw, string);
                hashMap.put(k.dsx, Double.valueOf(100.0d * d));
                hashMap.put(k.dsA, launchAAUI.biB);
                if ((launchAAUI.dvr != null ? launchAAUI.dvr.size() : 0) > 0) {
                    String str2 = launchAAUI.dtD.getText();
                    obj = "100";
                    double d2 = be.getDouble(str2, 0.0d);
                    double d3 = be.getDouble(obj, 0.0d);
                    if (d2 == 0.0d) {
                        str2 = "0";
                    }
                    BigDecimal bigDecimal = new BigDecimal(str2);
                    if (d3 == 0.0d) {
                        obj = "0";
                    }
                    long longValue = bigDecimal.multiply(new BigDecimal(obj)).longValue();
                    v.d("MicroMsg.LaunchAAUI", "perAmount: %s", new Object[]{Long.valueOf(longValue)});
                    if (longValue <= 0 || longValue > d.Nv()) {
                        v.i("MicroMsg.LaunchAAUI", "illegal avgAmount: %s", new Object[]{Long.valueOf(longValue)});
                        return;
                    }
                    hashMap.put(k.dsz, Long.valueOf(longValue));
                    hashMap.put(k.dsC, launchAAUI.dvr);
                    launchAAUI.dtK = com.tencent.mm.wallet_core.ui.g.a(launchAAUI, false, null);
                    com.tencent.mm.vending.g.g.s(Integer.valueOf(launchAAUI.mode), hashMap).c(launchAAUI.dve.dtj).e(new com.tencent.mm.vending.c.a<Void, Boolean>(launchAAUI) {
                        final /* synthetic */ LaunchAAUI dvF;

                        {
                            this.dvF = r1;
                        }

                        public final /* synthetic */ Object aq(Object obj) {
                            v.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", new Object[]{(Boolean) obj});
                            if (this.dvF.dtK != null) {
                                this.dvF.dtK.dismiss();
                            }
                            if (r7.booleanValue()) {
                                this.dvF.finish();
                                Toast.makeText(this.dvF, 2131233492, 1).show();
                                g.iuh.h(13722, new Object[]{Integer.valueOf(4)});
                            } else {
                                Toast.makeText(this.dvF, 2131233489, 1).show();
                                g.iuh.h(13722, new Object[]{Integer.valueOf(5)});
                            }
                            return phb;
                        }
                    }).a(new com.tencent.mm.vending.g.d.a(launchAAUI) {
                        final /* synthetic */ LaunchAAUI dvF;

                        {
                            this.dvF = r1;
                        }

                        public final void aA(Object obj) {
                            v.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", new Object[]{obj});
                            if (this.dvF.dtK != null) {
                                this.dvF.dtK.dismiss();
                            }
                            if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                                Toast.makeText(this.dvF, obj.toString(), 1).show();
                            } else if (obj == null || !(obj instanceof w)) {
                                Toast.makeText(this.dvF, 2131233489, 1).show();
                            } else {
                                h.a(this.dvF.nDR.nEl, (w) obj);
                            }
                            g.iuh.h(13722, new Object[]{Integer.valueOf(5)});
                        }
                    });
                }
                g.iuh.h(13723, new Object[]{Integer.valueOf(1), h.mc(launchAAUI.biB), Integer.valueOf(launchAAUI.dvr.size()), Double.valueOf(d * 100.0d), string});
            } catch (Exception e) {
                v.e("MicroMsg.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[]{Integer.valueOf(launchAAUI.mode), e.getMessage()});
            }
        }
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, String str, final String str2) {
        launchAAUI.dvA.setVisibility(0);
        launchAAUI.dvA.startAnimation(AnimationUtils.loadAnimation(launchAAUI, 2130968631));
        launchAAUI.dvA.setText(str);
        launchAAUI.dvA.setOnClickListener(new OnClickListener(launchAAUI) {
            final /* synthetic */ LaunchAAUI dvF;

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                c.b(this.dvF.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, List list) {
        Intent intent = new Intent(launchAAUI, AASelectContactUI.class);
        intent.putExtra("titile", launchAAUI.getString(2131233491));
        intent.putExtra("list_type", 12);
        intent.putExtra("chatroomName", launchAAUI.biB);
        if (list != null) {
            intent.putExtra("already_select_contact", be.b(list, ","));
        }
        intent.putExtra("max_select_num", (long) Math.min(d.Nu(), i.el(launchAAUI.biB)));
        intent.putExtra("select_type", 1);
        launchAAUI.startActivityForResult(intent, 233);
        g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
    }

    static /* synthetic */ void e(LaunchAAUI launchAAUI) {
        v.i("MicroMsg.LaunchAAUI", "switchMode");
        launchAAUI.dvg = false;
        if (launchAAUI.mode == a.drD) {
            launchAAUI.mode = a.drE;
            launchAAUI.dvp.setVisibility(8);
            launchAAUI.dvq.setVisibility(8);
            launchAAUI.dvs.setVisibility(0);
            launchAAUI.dvi.setText(launchAAUI.getString(2131233485, new Object[]{Integer.valueOf(0)}));
            if (launchAAUI.dvw != null && launchAAUI.dvw.size() > d.Nt()) {
                g.iuh.h(13722, new Object[]{Integer.valueOf(8)});
                launchAAUI.dvg = true;
            }
            if (launchAAUI.dvg) {
                launchAAUI.mg(launchAAUI.getString(2131233482, new Object[]{Integer.valueOf(d.Nt())}));
            } else {
                launchAAUI.NU();
            }
            g.iuh.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
        } else {
            launchAAUI.mode = a.drD;
            launchAAUI.dvp.setVisibility(0);
            launchAAUI.dvq.setVisibility(0);
            launchAAUI.dvs.setVisibility(8);
            launchAAUI.dvi.setText(2131233474);
            launchAAUI.dvg = false;
            if (launchAAUI.dvr.size() > d.Nu()) {
                g.iuh.h(13722, new Object[]{Integer.valueOf(8)});
                launchAAUI.dvg = true;
            }
            launchAAUI.NY();
            g.iuh.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
        }
        launchAAUI.NP();
        launchAAUI.axg();
        launchAAUI.NT();
        launchAAUI.NW();
        launchAAUI.NV();
        launchAAUI.dvl.post(new Runnable(launchAAUI) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final void run() {
            }
        });
    }

    static /* synthetic */ void i(LaunchAAUI launchAAUI) {
        Intent intent = new Intent(launchAAUI, LaunchAAByPersonAmountSelectUI.class);
        intent.putExtra("chatroom", launchAAUI.biB);
        intent.putExtra("maxPerAmount", d.Nv());
        if (launchAAUI.dvw != null && launchAAUI.dvw.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAUI.dvw.keySet()) {
                arrayList.add(str + "," + ((Double) launchAAUI.dvw.get(str)).doubleValue());
            }
            intent.putStringArrayListExtra("oldAmountData", arrayList);
        }
        intent.putExtra("maxUserNumber", d.Nt());
        launchAAUI.startActivityForResult(intent, 236);
        g.iuh.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(2)});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.LaunchAAUI", "LaunchAAUI onCreate");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.dvF.finish();
                return false;
            }
        });
        vD(2131233493);
        vE(2131236646);
        com.tencent.mm.vending.g.g.bKO().c(this.dve.dtl).e(new com.tencent.mm.vending.c.a<Void, d>(this) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final /* synthetic */ Object aq(Object obj) {
                d dVar = (d) obj;
                v.i("MicroMsg.LaunchAAUI", "fetch operation data finish");
                if (dVar != null) {
                    this.dvF.dvB = dVar;
                    if (!(be.kS(this.dvF.dvB.dsk) || be.kS(this.dvF.dvB.dsj))) {
                        LaunchAAUI.a(this.dvF, this.dvF.dvB.dsk, this.dvF.dvB.dsj);
                    }
                }
                return phb;
            }
        }).a(new com.tencent.mm.vending.g.d.a(this) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final void aA(Object obj) {
                v.i("MicroMsg.LaunchAAUI", "fetch operation data failed");
            }
        });
        this.biB = getIntent().getStringExtra("chatroom_name");
        if (be.kS(this.biB)) {
            v.e("MicroMsg.LaunchAAUI", "chatroomName is null!!!");
            this.biB = "";
        }
        this.dup = findViewById(2131757667);
        this.dup.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.dvF.NP();
                this.dvF.axg();
                return false;
            }
        });
        this.dvk = (TextView) findViewById(2131757674);
        this.dvk.setClickable(true);
        this.dvk.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.h(this));
        NT();
        this.dvy = (Button) findViewById(2131757683);
        this.dvy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final void onClick(View view) {
                LaunchAAUI.a(this.dvF);
            }
        });
        this.dvz = (TextView) findViewById(2131757686);
        this.dvA = (TextView) findViewById(2131757685);
        this.dvh = (MMEditText) findViewById(2131757679);
        this.dvi = (TextView) findViewById(2131757680);
        this.dtD = (TextView) findViewById(2131757682);
        this.dvj = (TextView) findViewById(2131757681);
        this.dvi.setText(2131233474);
        this.mode = a.drD;
        this.dvl = (TextView) findViewById(2131757684);
        this.dvl.setClickable(true);
        this.dvl.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.h());
        CharSequence spannableString = new SpannableString(getString(2131231916));
        spannableString.setSpan(new a(new a.a(this) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final void ND() {
                this.dvF.startActivity(new Intent(this.dvF, AAQueryListUI.class));
                if (this.dvF.mode == a.drD) {
                    g.iuh.h(13721, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                    return;
                }
                g.iuh.h(13721, new Object[]{Integer.valueOf(5), Integer.valueOf(2)});
            }
        }), 0, spannableString.length(), 18);
        this.dvl.setText(spannableString);
        this.dvh.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                this.dvF.NV();
            }
        });
        this.dvm = (WalletFormView) findViewById(2131757669);
        this.dvm.a(new TextWatcher(this) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (indexOf > 6) {
                    editable.delete(6, indexOf);
                } else if (indexOf == -1 && length > 6) {
                    editable.delete(6, length);
                }
                double d = be.getDouble(editable.toString(), 0.0d);
                if (this.dvF.dvr != null && this.dvF.dvr.size() > 0) {
                    d = (d * 100.0d) / ((double) this.dvF.dvr.size());
                    this.dvF.dvB;
                    if (d > ((double) d.Nv())) {
                        this.dvF.duO = true;
                        g.iuh.h(13722, new Object[]{Integer.valueOf(2)});
                        this.dvF.NV();
                        this.dvF.NW();
                        this.dvF.NY();
                    }
                }
                this.dvF.duO = false;
                this.dvF.NV();
                this.dvF.NW();
                this.dvF.NY();
            }
        });
        a(this.dvm, 2, false, false);
        final List mc = h.mc(this.biB);
        this.dvo = (TextView) findViewById(2131757677);
        this.dvn = (TextView) findViewById(2131757676);
        this.dvr = mc;
        if (this.dvr.size() > d.Nu()) {
            this.dvr.clear();
            this.dvo.setText(getString(2131234146));
            NV();
        } else {
            TextView textView = this.dvo;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(mc != null ? mc.size() : 0);
            textView.setText(getString(2131233470, objArr));
        }
        this.dvo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LaunchAAUI dvF;

            public final void onClick(View view) {
                this.dvF.NP();
                this.dvF.axg();
                LaunchAAUI.a(this.dvF, mc);
            }
        });
        this.dvp = (ViewGroup) findViewById(2131757675);
        this.dvq = (ViewGroup) findViewById(2131757668);
        this.dvm.requestFocus();
        this.dvg = false;
        this.dvu = (TextView) findViewById(2131757672);
        this.dvu.setText(2131233486);
        this.dvu.setTextColor(getResources().getColor(2131689481));
        this.dvs = (ViewGroup) findViewById(2131757670);
        this.dvt = (ViewGroup) findViewById(2131757673);
        this.dvv = (ViewGroup) findViewById(2131757671);
        this.dvv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final void onClick(View view) {
                LaunchAAUI.i(this.dvF);
            }
        });
        br(false);
        this.dvl.post(new Runnable(this) {
            final /* synthetic */ LaunchAAUI dvF;

            {
                this.dvF = r1;
            }

            public final void run() {
            }
        });
    }

    protected final boolean NS() {
        return false;
    }

    private void NT() {
        Object string;
        CharSequence string2;
        CharSequence spannableStringBuilder;
        if (this.mode == a.drD) {
            string = getString(2131233472);
            string2 = getString(2131233473);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new a.a(this) {
                final /* synthetic */ LaunchAAUI dvF;

                {
                    this.dvF = r1;
                }

                public final void ND() {
                    LaunchAAUI.e(this.dvF);
                }
            }), string.length(), spannableStringBuilder.length(), 18);
            this.dvk.setText(spannableStringBuilder);
        } else if (this.mode == a.drE) {
            string = getString(2131233483);
            string2 = getString(2131233484);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new a.a(this) {
                final /* synthetic */ LaunchAAUI dvF;

                {
                    this.dvF = r1;
                }

                public final void ND() {
                    LaunchAAUI.e(this.dvF);
                }
            }), string.length(), spannableStringBuilder.length(), 18);
            this.dvk.setText(spannableStringBuilder);
        }
    }

    private void mg(String str) {
        this.dvE = true;
        this.dvz.setVisibility(0);
        this.dvz.startAnimation(AnimationUtils.loadAnimation(this, 2130968631));
        this.dvz.setText(str);
    }

    private void NU() {
        this.dvE = false;
        if (this.dvz.getVisibility() != 8) {
            this.dvz.startAnimation(AnimationUtils.loadAnimation(this, 2130968638));
            this.dvz.setVisibility(8);
        }
    }

    private void NV() {
        if (this.mode == a.drD) {
            if (be.kS(this.dvm.getText())) {
                br(false);
                return;
            } else if (this.duO) {
                br(false);
                return;
            } else if (this.dvr == null || this.dvr.size() == 0) {
                br(false);
                return;
            } else if (this.dvr.size() > d.Nu() || this.dvg) {
                br(false);
                return;
            } else {
                v.d("MicroMsg.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[]{this.dvm.getText(), Integer.valueOf(this.dvr.size()), Double.valueOf(h.b(this.dvm.getText(), this.dvr.size(), 5, 4))});
                if (h.b(this.dvm.getText(), this.dvr.size(), 5, 4) < 0.01d) {
                    v.i("MicroMsg.LaunchAAUI", "less than 0.01");
                    br(false);
                    return;
                }
            }
        } else if (this.dvw == null || this.dvw.size() == 0) {
            br(false);
            return;
        } else if (this.dvw.size() > d.Nu() || this.dvg) {
            br(false);
            return;
        }
        br(true);
    }

    private void br(boolean z) {
        this.dvy.setEnabled(z);
        if (z) {
            this.dvi.setTextColor(getResources().getColor(2131689547));
            this.dtD.setTextColor(getResources().getColor(2131689547));
            this.dvj.setTextColor(getResources().getColor(2131689547));
            return;
        }
        this.dvi.setTextColor(getResources().getColor(2131689482));
        this.dtD.setTextColor(getResources().getColor(2131689482));
        this.dvj.setTextColor(getResources().getColor(2131689482));
    }

    private void NW() {
        if (this.mode == a.drD) {
            if (this.dvr == null || this.dvr.size() <= 0) {
                this.dtD.setText(getString(2131230754));
            } else {
                double b = h.b(this.dvm.getText(), this.dvr.size(), 2, 2);
                this.dtD.setText(getString(2131230752, new Object[]{Double.valueOf(b)}));
            }
            this.dvi.setText(2131233474);
        } else if (this.dvw == null || this.dvw.size() == 0) {
            this.dvi.setText(getString(2131233485, new Object[]{Integer.valueOf(0)}));
            this.dtD.setText(getString(2131230754));
        } else {
            double d = 0.0d;
            for (Double doubleValue : this.dvw.values()) {
                d = doubleValue.doubleValue() + d;
            }
            this.dtD.setText(getString(2131230752, new Object[]{Double.valueOf(d)}));
            this.dvi.setText(getString(2131233485, new Object[]{Integer.valueOf(this.dvw.size())}));
        }
    }

    private void NX() {
        g.iuh.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
        Map hashMap = new HashMap();
        try {
            Object string;
            String obj = this.dvh.getText().toString();
            if (be.kS(obj)) {
                string = getString(2131233488);
            } else {
                String str = obj;
            }
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            long j = 0;
            for (String obj2 : this.dvw.keySet()) {
                double doubleValue = ((Double) this.dvw.get(obj2)).doubleValue();
                j jVar = new j();
                jVar.bst = (long) (doubleValue * 100.0d);
                jVar.username = obj2;
                arrayList.add(jVar);
                long j2 = jVar.bst + j;
                arrayList2.add(jVar.bst);
                j = j2;
            }
            j jVar2 = new j();
            jVar2.username = com.tencent.mm.model.k.xF();
            jVar2.bst = j;
            hashMap.put(k.dsw, string);
            hashMap.put(k.dsx, Long.valueOf(j));
            hashMap.put(k.dsC, arrayList);
            hashMap.put(k.dsA, this.biB);
            if (this.dtK != null) {
                this.dtK.dismiss();
            }
            this.dtK = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
            com.tencent.mm.vending.g.g.br(hashMap).c(this.dve.dtk).e(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.vending.j.d<Boolean, String, Long>>(this) {
                final /* synthetic */ LaunchAAUI dvF;

                {
                    this.dvF = r1;
                }

                public final /* synthetic */ Object aq(Object obj) {
                    v.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", new Object[]{((com.tencent.mm.vending.j.d) obj).get(0)});
                    if (this.dvF.dtK != null) {
                        this.dvF.dtK.dismiss();
                    }
                    if (((Boolean) r8.get(0)).booleanValue()) {
                        this.dvF.finish();
                        Toast.makeText(this.dvF, 2131233492, 1).show();
                        g.iuh.h(13722, new Object[]{Integer.valueOf(9)});
                    } else {
                        Toast.makeText(this.dvF, 2131233489, 1).show();
                        g.iuh.h(13722, new Object[]{Integer.valueOf(10)});
                    }
                    return phb;
                }
            }).a(new com.tencent.mm.vending.g.d.a(this) {
                final /* synthetic */ LaunchAAUI dvF;

                {
                    this.dvF = r1;
                }

                public final void aA(Object obj) {
                    v.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", new Object[]{obj});
                    if (this.dvF.dtK != null) {
                        this.dvF.dtK.dismiss();
                    }
                    if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                        Toast.makeText(this.dvF, obj.toString(), 1).show();
                    } else if (obj == null || !(obj instanceof w)) {
                        Toast.makeText(this.dvF, 2131233489, 1).show();
                    } else {
                        h.a(this.dvF.nDR.nEl, (w) obj);
                    }
                    g.iuh.h(13722, new Object[]{Integer.valueOf(10)});
                }
            });
            g.iuh.h(13723, new Object[]{Integer.valueOf(2), Integer.valueOf(h.mc(this.biB).size()), Integer.valueOf(arrayList.size() + 1), Long.valueOf(j), string, be.b(arrayList2, ",")});
        } catch (Exception e) {
            v.e("MicroMsg.LaunchAAUI", "launchAAByPerson error: %s", new Object[]{e.getMessage()});
        }
    }

    protected final int NO() {
        return 1;
    }

    protected final int getLayoutId() {
        return 2130903850;
    }

    protected void onStop() {
        super.onStop();
        if (this.dvx != null) {
            this.dvx.clear();
        }
    }

    private void NY() {
        if (!this.dvg || this.dvE) {
            if (this.duO && !this.dvE) {
                mg(getString(2131233490, new Object[]{Float.valueOf(((float) d.Nv()) / 100.0f)}));
            } else if (!this.dvg && !this.duO) {
                NU();
            }
        } else if (this.mode == a.drD) {
            mg(getString(2131233482, new Object[]{Integer.valueOf(d.Nu())}));
        } else {
            mg(getString(2131233482, new Object[]{Integer.valueOf(d.Nt())}));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        String[] split;
        if (i == 233) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Contact");
                if (this.mode == a.drD) {
                    if (!be.kS(stringExtra)) {
                        split = stringExtra.split(",");
                        this.dvr.clear();
                        this.dvr.addAll(Arrays.asList(split));
                    }
                    List mc = h.mc(this.biB);
                    TextView textView;
                    Object[] objArr;
                    if (mc == null || this.dvr == null || this.dvr.size() != mc.size()) {
                        textView = this.dvo;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.dvr != null ? this.dvr.size() : 0);
                        textView.setText(getString(2131233475, objArr));
                    } else {
                        textView = this.dvo;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.dvr != null ? this.dvr.size() : 0);
                        textView.setText(getString(2131233470, objArr));
                    }
                }
                NU();
                if (this.dvr == null || this.dvr.size() <= d.Nu()) {
                    this.dvg = false;
                } else {
                    this.dvg = true;
                }
                double d = be.getDouble(this.dvm.getText(), 0.0d);
                if (this.dvr == null || (d * 100.0d) / ((double) this.dvr.size()) <= ((double) d.Nv())) {
                    this.duO = false;
                } else {
                    this.duO = true;
                    g.iuh.h(13722, new Object[]{Integer.valueOf(2)});
                }
                NV();
                NW();
                NY();
            }
        } else if (i == 236 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selectUI");
            this.dvw.clear();
            if (stringArrayListExtra != null) {
                try {
                    if (stringArrayListExtra.size() > 0) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            split = ((String) it.next()).split(",");
                            this.dvw.put(split[0], Double.valueOf(be.getDouble(split[1], 0.0d)));
                        }
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", new Object[]{e.getMessage()});
                    return;
                }
            }
            int dimension;
            if (this.dvw == null || this.dvw.size() <= 0) {
                this.dvu.setText(2131233486);
                this.dvu.setTextColor(getResources().getColor(2131689481));
                dimension = (int) getResources().getDimension(2131493233);
                this.dvv.setPadding(dimension, dimension, dimension, dimension);
                this.dvv.setBackgroundResource(2130838457);
                this.dvt.setVisibility(8);
            } else {
                this.dvu.setText(getString(2131233487, new Object[]{Integer.valueOf(this.dvw.size())}));
                this.dvu.setTextColor(getResources().getColor(2131689547));
                dimension = (int) getResources().getDimension(2131493233);
                this.dvv.setPadding(dimension, (int) getResources().getDimension(2131493230), dimension, (int) getResources().getDimension(2131493231));
                this.dvv.setBackgroundResource(2130838455);
                this.dvt.setVisibility(0);
            }
            this.dvt.removeAllViews();
            this.dvx.clear();
            if (this.dvw != null && this.dvw.size() > 0) {
                int i3 = 0;
                for (String stringExtra2 : this.dvw.keySet()) {
                    double doubleValue = ((Double) this.dvw.get(stringExtra2)).doubleValue();
                    View launchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
                    if (i3 >= this.dvw.size() - 1) {
                        launchAAByPersonNameAmountRow.duA.setVisibility(8);
                    }
                    launchAAByPersonNameAmountRow.duy.setText(com.tencent.mm.pluginsdk.ui.d.e.a(launchAAByPersonNameAmountRow.getContext(), l.D(stringExtra2, this.biB), launchAAByPersonNameAmountRow.duy.getTextSize()));
                    launchAAByPersonNameAmountRow.dtD.setText(launchAAByPersonNameAmountRow.getContext().getString(2131230752, new Object[]{Double.valueOf(doubleValue)}));
                    this.dvt.addView(launchAAByPersonNameAmountRow);
                    this.dvx.put(stringExtra2, launchAAByPersonNameAmountRow);
                    i3++;
                }
            }
            if (this.dup != null) {
                this.dup.requestLayout();
            }
            this.dvD = 0;
            this.dvl.post(new Runnable(this) {
                final /* synthetic */ LaunchAAUI dvF;

                {
                    this.dvF = r1;
                }

                public final void run() {
                }
            });
            NW();
            NV();
        }
    }
}
