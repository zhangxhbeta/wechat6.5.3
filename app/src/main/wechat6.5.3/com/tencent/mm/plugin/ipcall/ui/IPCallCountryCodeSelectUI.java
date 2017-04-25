package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

@a(3)
public class IPCallCountryCodeSelectUI extends MMActivity {
    private String bfd;
    private String cQn;
    private String dwS = "";
    private p eSv;
    public LinearLayout gKH;
    private List<a> gKQ;
    private boolean gKT = false;
    private ListView gLl;
    private f gLm;
    private IPCallCountryCodeScrollbar gLn;
    private IPCallCountryCodeScrollbar.a gLo;
    private boolean gLp = false;

    static /* synthetic */ void a(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        if (iPCallCountryCodeSelectUI.gLm != null) {
            iPCallCountryCodeSelectUI.gLm.uU(iPCallCountryCodeSelectUI.dwS);
        }
    }

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gKQ = new ArrayList();
        this.cQn = be.ah(getIntent().getStringExtra("country_name"), "");
        this.bfd = be.ah(getIntent().getStringExtra("couttry_code"), "");
        this.gKT = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI gLq;

            {
                this.gLq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gLq.finish();
                return false;
            }
        });
        NI();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(-1, 2130968644);
    }

    protected final int getLayoutId() {
        return 2130903819;
    }

    protected void onPause() {
        super.onPause();
        if (this.eSv != null) {
            this.eSv.bJs();
        }
    }

    protected final void NI() {
        vD(2131230884);
        this.eSv = new p(true, true);
        this.eSv.oUs = new b(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI gLq;

            {
                this.gLq = r1;
            }

            public final void ml(String str) {
                this.gLq.dwS = str;
                IPCallCountryCodeSelectUI.a(this.gLq);
            }

            public final void Of() {
                this.gLq.dwS = "";
                IPCallCountryCodeSelectUI.a(this.gLq);
            }

            public final void Og() {
            }

            public final boolean mk(String str) {
                return false;
            }

            public final void Oh() {
            }
        };
        a(this.eSv);
        this.gLn = (IPCallCountryCodeScrollbar) findViewById(2131755320);
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (Integer intValue : c.atY().aub()) {
            int intValue2 = intValue.intValue();
            if (i >= 5) {
                break;
            }
            String vj = com.tencent.mm.plugin.ipcall.b.a.vj(String.valueOf(intValue2));
            if (be.kS(vj) || c.atY().lU(intValue2)) {
                intValue2 = i;
            } else {
                this.gKQ.add(new a(vj, String.valueOf(intValue2), 0, "0"));
                intValue2 = i + 1;
            }
            i = intValue2;
        }
        if (i > 0) {
            this.gLp = true;
        }
        avi();
        v.d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        this.gKH = (LinearLayout) findViewById(2131757516);
        this.gLl = (ListView) findViewById(2131755317);
        this.gLm = new f(this, this.gKQ);
        this.gLm.gKT = this.gKT;
        this.gLm.gKU = this.gLp;
        this.gLl.setAdapter(this.gLm);
        this.gLl.setVisibility(0);
        this.gLo = new IPCallCountryCodeScrollbar.a(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI gLq;

            {
                this.gLq = r1;
            }

            public final void pC(String str) {
                int i = 0;
                char charAt = str.charAt(0);
                if ("↑".equals(str)) {
                    this.gLq.gLl.setSelection(0);
                    return;
                }
                int[] iArr = this.gLq.gLm.gKS;
                if (iArr != null) {
                    while (i < iArr.length) {
                        if (iArr[i] == charAt) {
                            this.gLq.gLl.setSelection(i + this.gLq.gLl.getHeaderViewsCount());
                            return;
                        }
                        i++;
                    }
                }
            }
        };
        this.gLn.gLh = this.gLo;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI gLq;

            {
                this.gLq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gLq.axg();
                Intent intent = new Intent();
                intent.putExtra("country_name", this.gLq.cQn);
                intent.putExtra("couttry_code", this.gLq.bfd);
                this.gLq.setResult(100, intent);
                this.gLq.finish();
                return true;
            }
        });
        this.gLl.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI gLq;

            {
                this.gLq = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                if (i >= this.gLq.gLl.getHeaderViewsCount()) {
                    a aVar = (a) this.gLq.gLm.getItem(i - this.gLq.gLl.getHeaderViewsCount());
                    intent.putExtra("country_name", aVar.cQn);
                    intent.putExtra("couttry_code", aVar.bfd);
                    this.gLq.setResult(100, intent);
                }
                this.gLq.finish();
            }
        });
    }

    private void avi() {
        com.tencent.mm.plugin.ipcall.b.b bVar;
        String str;
        if (u.bsU()) {
            for (Entry entry : com.tencent.mm.plugin.ipcall.b.a.avx().entrySet()) {
                entry.getKey();
                bVar = (com.tencent.mm.plugin.ipcall.b.b) entry.getValue();
                str = bVar.gPK;
                if (!(str == null || "".equals(str.trim()))) {
                    char[] toCharArray = str.toCharArray();
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = toCharArray.length;
                    for (int i = 0; i < length; i++) {
                        String f = SpellMap.f(toCharArray[i]);
                        if (be.kS(f)) {
                            stringBuffer.append(toCharArray[i]);
                        } else {
                            stringBuffer.append(f);
                        }
                    }
                    str = stringBuffer.toString();
                }
                str = str.toUpperCase();
                if (be.kS(str)) {
                    str = " ";
                }
                if (!c.atY().lU(be.getInt(bVar.gPJ, 0))) {
                    this.gKQ.add(new a(bVar.gPK, bVar.gPJ, str.charAt(0), str));
                }
            }
        } else {
            for (Entry entry2 : com.tencent.mm.plugin.ipcall.b.a.avx().entrySet()) {
                entry2.getKey();
                bVar = (com.tencent.mm.plugin.ipcall.b.b) entry2.getValue();
                str = bVar.gPK.toUpperCase();
                if (be.kS(str)) {
                    str = " ";
                }
                if (!c.atY().lU(be.getInt(bVar.gPJ, 0))) {
                    this.gKQ.add(new a(bVar.gPK, bVar.gPJ, str.charAt(0), str));
                }
            }
        }
        Collections.sort(this.gKQ, new Comparator<a>(this) {
            final /* synthetic */ IPCallCountryCodeSelectUI gLq;

            {
                this.gLq = r1;
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((a) obj).gIM.compareTo(((a) obj2).gIM);
            }
        });
        for (a auW : this.gKQ) {
            int auW2 = auW.auW();
            if (auW2 != 0) {
                this.gLn.uY(String.valueOf((char) auW2));
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        Intent intent = new Intent();
        intent.putExtra("country_name", this.cQn);
        intent.putExtra("couttry_code", this.bfd);
        setResult(100, intent);
        finish();
        return true;
    }
}
