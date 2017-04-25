package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAByPersonAmountSelectUI extends BaseAAPresenterActivity {
    private String aYF;
    private ac cnC = new ac(Looper.getMainLooper());
    private com.tencent.mm.plugin.aa.a.c.c duC = ((com.tencent.mm.plugin.aa.a.c.c) j(com.tencent.mm.plugin.aa.a.c.c.class));
    private ListView duD;
    private TextView duE;
    private TextView duF;
    private View duG;
    private TextView duH;
    private boolean duI = false;
    private Map<String, String> duJ = new HashMap();
    private a duK = null;
    private double duL;
    private long duM = -1;
    private int duN = -1;
    private boolean duO;
    private boolean duP = false;
    private Runnable duQ = new Runnable(this) {
        final /* synthetic */ LaunchAAByPersonAmountSelectUI duR;

        {
            this.duR = r1;
        }

        public final void run() {
            this.duR.NQ();
            this.duR.NR();
        }
    };

    private class a extends BaseAdapter {
        List<b> dataList;
        final /* synthetic */ LaunchAAByPersonAmountSelectUI duR;

        private class a {
            ImageView dtz;
            final /* synthetic */ a duW;
            c duX;
            TextView duy;
            WalletFormView duz;

            private a(a aVar) {
                this.duW = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return gL(i);
        }

        public a(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, List<String> list, Map<String, Double> map) {
            this.duR = launchAAByPersonAmountSelectUI;
            this.dataList = null;
            this.dataList = new ArrayList();
            for (String str : list) {
                b bVar = new b();
                bVar.username = str;
                if (map == null || !map.containsKey(str)) {
                    bVar.duY = "";
                } else {
                    bVar.duY = launchAAByPersonAmountSelectUI.getString(2131230752, new Object[]{map.get(str)});
                }
                this.dataList.add(bVar);
            }
        }

        public final int getCount() {
            return this.dataList.size();
        }

        private b gL(int i) {
            return (b) this.dataList.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b gL = gL(i);
            if (!(gL == null || be.kS(gL.username))) {
                if (view == null) {
                    view = q.em(this.duR).inflate(2130903845, viewGroup, false);
                    final a aVar = new a();
                    aVar.dtz = (ImageView) view.findViewById(2131756854);
                    aVar.duy = (TextView) view.findViewById(2131755499);
                    aVar.duz = (WalletFormView) view.findViewById(2131757654);
                    aVar.duX = new c(this.duR, gL.username);
                    aVar.duz.a(aVar.duX);
                    aVar.dtz.setOnTouchListener(new OnTouchListener(this) {
                        final /* synthetic */ a duW;

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            aVar.duz.requestFocus();
                            return false;
                        }
                    });
                    aVar.duy.setOnTouchListener(new OnTouchListener(this) {
                        final /* synthetic */ a duW;

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            aVar.duz.requestFocus();
                            return false;
                        }
                    });
                    view.setTag(aVar);
                    this.duR.a(aVar.duz, 2, false, true);
                }
                a aVar2 = (a) view.getTag();
                if (!be.kS(gL.username)) {
                    aVar2.duX.username = gL.username;
                    com.tencent.mm.pluginsdk.ui.a.b.m(aVar2.dtz, gL.username);
                    aVar2.duy.setText(e.a(this.duR.nDR.nEl, l.D(gL.username, this.duR.aYF), aVar2.duy.getTextSize()));
                }
                if (!(gL.duY == null || aVar2.duz.getText() == null || gL.duY.equals(aVar2.duz.getText().toLowerCase()))) {
                    WalletFormView walletFormView = aVar2.duz;
                    TextWatcher textWatcher = aVar2.duX;
                    if (walletFormView.pkj != null) {
                        walletFormView.pkj.removeTextChangedListener(textWatcher);
                    }
                    aVar2.duz.setText(gL.duY);
                    aVar2.duz.a(aVar2.duX);
                }
            }
            return view;
        }
    }

    private class b {
        final /* synthetic */ LaunchAAByPersonAmountSelectUI duR;
        String duY;
        String username;

        private b(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
            this.duR = launchAAByPersonAmountSelectUI;
            this.username = null;
            this.duY = null;
        }
    }

    protected class c implements TextWatcher {
        final /* synthetic */ LaunchAAByPersonAmountSelectUI duR;
        String username;

        public c(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, String str) {
            this.duR = launchAAByPersonAmountSelectUI;
            this.username = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            try {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                int lastIndexOf = obj.lastIndexOf(".");
                if (lastIndexOf != indexOf && lastIndexOf > 0 && length > lastIndexOf) {
                    editable.delete(lastIndexOf, length);
                }
            } catch (Exception e) {
            }
            if (be.D(editable) || be.getDouble(editable.toString(), 0.0d) <= 0.0d) {
                this.duR.duJ.remove(this.username);
            } else {
                this.duR.duJ.put(this.username, editable.toString());
            }
            this.duR.cnC.removeCallbacks(this.duR.duQ);
            this.duR.cnC.postDelayed(this.duR.duQ, 50);
        }
    }

    static /* synthetic */ void d(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        launchAAByPersonAmountSelectUI.NQ();
        launchAAByPersonAmountSelectUI.NR();
        if (!launchAAByPersonAmountSelectUI.duO) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAByPersonAmountSelectUI.duJ.keySet()) {
                arrayList.add(str + "," + ((String) launchAAByPersonAmountSelectUI.duJ.get(str)));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selectUI", arrayList);
            launchAAByPersonAmountSelectUI.setResult(-1, intent);
            launchAAByPersonAmountSelectUI.finish();
        }
    }

    static /* synthetic */ void m(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        try {
            launchAAByPersonAmountSelectUI.duE.setTextColor(launchAAByPersonAmountSelectUI.getResources().getColor(2131689563));
            launchAAByPersonAmountSelectUI.duI = false;
            launchAAByPersonAmountSelectUI.duL = 0.0d;
            launchAAByPersonAmountSelectUI.duF.setText(launchAAByPersonAmountSelectUI.getString(2131233477, new Object[]{Double.valueOf(launchAAByPersonAmountSelectUI.duL)}));
            launchAAByPersonAmountSelectUI.duJ.clear();
            launchAAByPersonAmountSelectUI.NQ();
            launchAAByPersonAmountSelectUI.NR();
            if (launchAAByPersonAmountSelectUI.duK != null) {
                a aVar = launchAAByPersonAmountSelectUI.duK;
                for (b bVar : aVar.dataList) {
                    bVar.duY = "";
                }
                aVar.notifyDataSetChanged();
            }
        } catch (Exception e) {
            v.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "clearAmount error: %s", new Object[]{e.getMessage()});
        }
        g.iuh.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(9)});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131233478);
        vE(2131236646);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI duR;

            {
                this.duR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.duR.duJ == null || this.duR.duJ.size() <= 0) {
                    this.duR.finish();
                } else {
                    com.tencent.mm.ui.base.g.a(this.duR, this.duR.getString(2131230780), null, this.duR.getString(2131230784), this.duR.getString(2131230783), false, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 duS;

                        {
                            this.duS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            LaunchAAByPersonAmountSelectUI.d(this.duS.duR);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 duS;

                        {
                            this.duS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.duS.duR.finish();
                        }
                    });
                }
                return true;
            }
        });
        a(233, getString(2131231107), new OnMenuItemClickListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI duR;

            {
                this.duR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.duR.duN <= 0 || this.duR.duJ == null || this.duR.duJ.size() <= this.duR.duN) {
                    LaunchAAByPersonAmountSelectUI.d(this.duR);
                    g.iuh.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(4)});
                } else {
                    com.tencent.mm.ui.base.g.A(this.duR.nDR.nEl, this.duR.getString(2131233482, new Object[]{Integer.valueOf(this.duR.duN)}), "");
                    g.iuh.h(13722, new Object[]{Integer.valueOf(8)});
                }
                return true;
            }
        }, com.tencent.mm.ui.k.b.nET);
        this.duD = (ListView) findViewById(2131757656);
        this.duE = (TextView) findViewById(2131757658);
        this.duF = (TextView) findViewById(2131757659);
        this.duF.setText(getString(2131233477, new Object[]{Float.valueOf(0.0f)}));
        this.duG = findViewById(2131757657);
        this.duH = (TextView) findViewById(2131757660);
        this.dup = this.duD;
        this.duG.setVisibility(8);
        this.duE.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI duR;

            {
                this.duR = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.duR.duI) {
                    return true;
                }
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    this.duR.duE.setTextColor(this.duR.getResources().getColor(2131689565));
                } else if (this.duR.duI) {
                    this.duR.duE.setTextColor(this.duR.getResources().getColor(2131689564));
                } else {
                    this.duR.duE.setTextColor(this.duR.getResources().getColor(2131689563));
                }
                return false;
            }
        });
        this.duE.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI duR;

            {
                this.duR = r1;
            }

            public final void onClick(View view) {
                if (this.duR.duJ != null && this.duR.duJ.size() > 0) {
                    try {
                        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.duR);
                        aVar.wn(2131230753);
                        aVar.wp(2131231107).a(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass6 duU;

                            {
                                this.duU = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                LaunchAAByPersonAmountSelectUI.m(this.duU.duR);
                            }
                        });
                        aVar.wq(2131231010).b(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass6 duU;

                            {
                                this.duU = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.iuh.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(10)});
                            }
                        });
                        aVar.RX().show();
                    } catch (Exception e) {
                        v.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
                    }
                }
                g.iuh.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(8)});
            }
        });
        this.duI = true;
        this.duD.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI duR;

            {
                this.duR = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 1) {
                    this.duR.NP();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        String stringExtra = getIntent().getStringExtra("chatroom");
        this.duM = getIntent().getLongExtra("maxPerAmount", -1);
        this.duN = getIntent().getIntExtra("maxUserNumber", -1);
        ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("oldAmountData");
        v.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, oldDataList: %s", new Object[]{stringExtra, Long.valueOf(this.duM), stringArrayListExtra});
        this.duJ = new HashMap();
        final HashMap hashMap = new HashMap();
        if (stringArrayListExtra != null) {
            try {
                if (stringArrayListExtra.size() > 0) {
                    Iterator it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String[] split = ((String) it.next()).split(",");
                        if (split != null && split.length == 2) {
                            hashMap.put(split[0], Double.valueOf(be.getDouble(split[1], 0.0d)));
                            this.duJ.put(split[0], getString(2131230752, new Object[]{Double.valueOf(r4)}));
                        }
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate parse old data error: %s", new Object[]{e.getMessage()});
            }
        }
        getIntent().getStringExtra("chatroom");
        this.duC.u(com.tencent.mm.plugin.aa.a.c.c.a.class);
        this.duC.a(com.tencent.mm.plugin.aa.a.c.c.a.class, new com.tencent.mm.vending.app.a.b<com.tencent.mm.plugin.aa.a.c.c.a>(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI duR;

            public final /* synthetic */ void aB(Object obj) {
                com.tencent.mm.plugin.aa.a.c.c.a aVar = (com.tencent.mm.plugin.aa.a.c.c.a) obj;
                String str = "MicroMsg.LaunchAAByPersonAmountSelectUI";
                String str2 = "get selectMembers: %s, list.size: %s";
                Object[] objArr = new Object[2];
                objArr[0] = aVar;
                objArr[1] = aVar != null ? Integer.valueOf(aVar.dtf.size()) : "0";
                v.i(str, str2, objArr);
                this.duR.duD.addFooterView(q.em(this.duR).inflate(2130903040, null));
                this.duR.duD.addHeaderView(q.em(this.duR).inflate(2130903046, null));
                if (!(aVar == null || aVar.dtf == null || aVar.dtf.size() <= 0)) {
                    this.duR.duK = new a(this.duR, aVar.dtf, hashMap);
                    this.duR.duD.setAdapter(this.duR.duK);
                }
                this.duR.duG.setVisibility(0);
                this.duR.cnC.post(this.duR.duQ);
            }
        });
    }

    protected final int NO() {
        return 1;
    }

    private void NQ() {
        try {
            this.duL = 0.0d;
            this.duO = false;
            if (this.duJ != null) {
                for (String str : this.duJ.values()) {
                    double d = be.getDouble(str, 0.0d);
                    this.duL += d;
                    if (this.duM > 0 && d * 100.0d > ((double) this.duM)) {
                        this.duO = true;
                    }
                }
                if (this.duK != null) {
                    a aVar = this.duK;
                    Map map = this.duJ;
                    for (b bVar : aVar.dataList) {
                        bVar.duY = "";
                    }
                    if (map != null && map.size() > 0) {
                        for (b bVar2 : aVar.dataList) {
                            if (map.containsKey(bVar2.username)) {
                                bVar2.duY = (String) map.get(bVar2.username);
                            }
                        }
                    }
                }
            }
            this.duF.setText(getString(2131233477, new Object[]{Double.valueOf(this.duL)}));
            if (this.duJ.size() > 0) {
                aq(233, getString(2131230760, new Object[]{Integer.valueOf(this.duJ.size())}));
            } else {
                aq(233, getString(2131231107));
            }
            if (this.duO) {
                g.iuh.h(13722, new Object[]{Integer.valueOf(7)});
                U(233, false);
                CharSequence string = getString(2131233490, new Object[]{Float.valueOf(((float) this.duM) / 100.0f)});
                if (!be.kS(string)) {
                    this.duH.setText(string);
                    if (!this.duH.isShown()) {
                        this.duH.startAnimation(AnimationUtils.loadAnimation(this, 2130968631));
                        this.duH.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            U(233, true);
            if (this.duH.isShown()) {
                this.duH.setText("");
                this.duH.startAnimation(AnimationUtils.loadAnimation(this, 2130968638));
                this.duH.setVisibility(8);
            }
        } catch (Exception e) {
            v.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[]{e.getMessage()});
        }
    }

    private void NR() {
        if (this.duL > 0.0d) {
            this.duI = true;
            this.duE.setTextColor(getResources().getColor(2131689564));
            return;
        }
        this.duI = false;
        this.duE.setTextColor(getResources().getColor(2131689563));
    }

    protected final int getLayoutId() {
        return 2130903846;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.duJ != null) {
            this.duJ.clear();
        }
    }
}
