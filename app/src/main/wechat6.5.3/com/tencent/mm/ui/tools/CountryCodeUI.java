package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryCodeUI extends MMActivity {
    private String bfd;
    private String cQn;
    private String dwS = SQLiteDatabase.KeyEmpty;
    private p eSv;
    private List<c> gKQ;
    private boolean gKT = false;
    private ListView gLl;
    private a oEx;
    private d oQZ;
    private VerticalScrollBar oRa;

    static /* synthetic */ void a(CountryCodeUI countryCodeUI) {
        if (countryCodeUI.oQZ != null) {
            countryCodeUI.oQZ.uU(countryCodeUI.dwS);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gKQ = new ArrayList();
        this.cQn = t.ah(getIntent().getStringExtra("country_name"), SQLiteDatabase.KeyEmpty);
        this.bfd = t.ah(getIntent().getStringExtra("couttry_code"), SQLiteDatabase.KeyEmpty);
        this.gKT = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
        NI();
    }

    protected final int getLayoutId() {
        if (u.bsW()) {
            return 2130903439;
        }
        return 2130903438;
    }

    protected void onPause() {
        super.onPause();
        if (this.eSv != null) {
            this.eSv.bJs();
        }
    }

    protected final void NI() {
        vD(2131230884);
        v.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode start:" + System.currentTimeMillis());
        String[] split = getString(2131232236).trim().split(",");
        String[] split2;
        if (u.bsW()) {
            v.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode t1:" + System.currentTimeMillis());
            for (String trim : split) {
                split2 = trim.trim().split(":");
                this.gKQ.add(new c(split2[1], split2[0], com.tencent.mm.af.a.jm(split2[1]), split2[1]));
            }
            v.d("MicroMsg.CountryCodeUI", "CHT:initCountryCode t2:" + System.currentTimeMillis());
            Collections.sort(this.gKQ, new Comparator<c>(this) {
                final /* synthetic */ CountryCodeUI oRb;

                {
                    this.oRb = r1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return new Integer(((c) obj).gIL).intValue() - new Integer(((c) obj2).gIL).intValue();
                }
            });
            v.d("MicroMsg.CountryCodeUI", "CHT2:initCountryCode t3:" + System.currentTimeMillis());
        } else {
            for (String trim2 : split) {
                split2 = trim2.trim().split(":");
                if (split2.length < 3) {
                    v.e("MicroMsg.CountryCodeUI", "this country item has problem %s", split[r0]);
                } else {
                    this.gKQ.add(new c(split2[1], split2[0], split2[2].charAt(0), split2[2]));
                }
            }
            Collections.sort(this.gKQ, new Comparator<c>(this) {
                final /* synthetic */ CountryCodeUI oRb;

                {
                    this.oRb = r1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((c) obj).gIM.compareTo(((c) obj2).gIM);
                }
            });
        }
        this.eSv = new p(true, true);
        this.eSv.oUs = new b(this) {
            final /* synthetic */ CountryCodeUI oRb;

            {
                this.oRb = r1;
            }

            public final void ml(String str) {
                this.oRb.dwS = str;
                CountryCodeUI.a(this.oRb);
            }

            public final void Of() {
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
        this.gLl = (ListView) findViewById(2131755317);
        this.oQZ = new d(this, this.gKQ);
        this.oQZ.gKT = this.gKT;
        this.gLl.setAdapter(this.oQZ);
        this.gLl.setVisibility(0);
        this.oRa = (VerticalScrollBar) findViewById(2131755320);
        if (u.bsW()) {
            this.oEx = new a(this) {
                final /* synthetic */ CountryCodeUI oRb;

                {
                    this.oRb = r1;
                }

                public final void pC(String str) {
                    int i = 0;
                    if (this.oRb.getString(2131234799).equals(str)) {
                        this.oRb.gLl.setSelection(0);
                        return;
                    }
                    int intValue = Integer.decode(str.substring(0, str.length() - 1)).intValue();
                    int[] iArr = this.oRb.oQZ.gKS;
                    if (iArr != null) {
                        while (i < iArr.length) {
                            if (iArr[i] == intValue) {
                                this.oRb.gLl.setSelection(i + this.oRb.gLl.getHeaderViewsCount());
                                return;
                            }
                            i++;
                        }
                    }
                }
            };
        } else {
            this.oEx = new a(this) {
                final /* synthetic */ CountryCodeUI oRb;

                {
                    this.oRb = r1;
                }

                public final void pC(String str) {
                    int i = 0;
                    char charAt = str.charAt(0);
                    if (this.oRb.getString(2131234799).equals(str)) {
                        this.oRb.gLl.setSelection(0);
                        return;
                    }
                    int[] iArr = this.oRb.oQZ.gKS;
                    if (iArr != null) {
                        while (i < iArr.length) {
                            if (iArr[i] == charAt) {
                                this.oRb.gLl.setSelection(i + this.oRb.gLl.getHeaderViewsCount());
                                return;
                            }
                            i++;
                        }
                    }
                }
            };
        }
        this.oRa.obP = this.oEx;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CountryCodeUI oRb;

            {
                this.oRb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oRb.axg();
                Intent intent = new Intent();
                intent.putExtra("country_name", this.oRb.cQn);
                intent.putExtra("couttry_code", this.oRb.bfd);
                this.oRb.setResult(100, intent);
                this.oRb.finish();
                return true;
            }
        });
        this.gLl.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CountryCodeUI oRb;

            {
                this.oRb = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                if (i >= this.oRb.gLl.getHeaderViewsCount()) {
                    c cVar = (c) this.oRb.oQZ.getItem(i - this.oRb.gLl.getHeaderViewsCount());
                    intent.putExtra("country_name", cVar.cQn);
                    intent.putExtra("couttry_code", cVar.bfd);
                    this.oRb.setResult(100, intent);
                }
                this.oRb.finish();
            }
        });
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
