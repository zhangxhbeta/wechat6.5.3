package com.tencent.mm.plugin.multitalk.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.e.a.ib;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.p;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class MultiTalkSelectContactUI extends MMBaseSelectContactUI {
    private String biB;
    private HashSet<String> duc;
    private HashSet<String> dud;
    private boolean hAP;
    private d hAQ;
    private boolean hAR = false;
    private c hzy = new c<ib>(this) {
        final /* synthetic */ MultiTalkSelectContactUI hAS;

        {
            this.hAS = r2;
            this.nhz = ib.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ib ibVar = (ib) bVar;
            if ((ibVar instanceof ib) && ibVar.bhW.action == 0) {
                this.hAS.finish();
            }
            return false;
        }
    };

    protected final void NH() {
        super.NH();
        this.hAP = getIntent().getBooleanExtra("key_need_gallery", false);
        this.biB = getIntent().getStringExtra("chatroomName");
        if (!m.dE(this.biB)) {
            finish();
        }
        this.dud = new HashSet();
        this.duc = new HashSet();
    }

    protected void NI() {
        super.NI();
        this.hAQ = new d(this);
        if (this.hAP) {
            this.hAQ.setVisible(true);
        } else {
            this.hAQ.setVisible(false);
        }
        int i = 2131231107;
        if (this.hAP) {
            i = 2131233951;
        }
        a(1, getString(i), new OnMenuItemClickListener(this) {
            final /* synthetic */ MultiTalkSelectContactUI hAS;

            {
                this.hAS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (ak.isNetworkConnected(aa.getContext())) {
                    List linkedList = new LinkedList();
                    linkedList.addAll(this.hAS.dud);
                    linkedList.add(k.xF());
                    String b = be.b(linkedList, ",");
                    if (this.hAS.hAP) {
                        com.tencent.mm.plugin.multitalk.a.d.a(this.hAS.dud.size(), this.hAS.hAR, 1, "", this.hAS.hAQ.hBx);
                        o.aCG().a(this.hAS, b, this.hAS.biB);
                    } else {
                        com.tencent.mm.plugin.multitalk.a.d.a(this.hAS.dud.size(), this.hAS.hAR, 2, i.aCw(), 0);
                        this.hAS.setResult(-1, this.hAS.getIntent().putExtra("Select_Contact", b));
                        this.hAS.finish();
                    }
                } else {
                    com.tencent.mm.ah.a.a(this.hAS, 2131235928, null);
                }
                this.hAS.axg();
                return true;
            }
        }, com.tencent.mm.ui.k.b.nET);
        NN();
        this.hkH.setBackgroundResource(2131689895);
        this.hkH.lHd.setTextColor(-1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!be.kS(stringExtra)) {
            this.duc.addAll(be.g(stringExtra.split(",")));
        }
        this.duc.add(k.xF());
        if (this.hAP) {
            this.hAQ.wV(k.xF());
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.hzy);
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.hzy);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904101;
    }

    protected final boolean NJ() {
        return false;
    }

    protected final String NK() {
        return getIntent().getStringExtra("titile");
    }

    protected final n NL() {
        return new a(this, this.biB);
    }

    protected final p NM() {
        return new b(this, this.biB);
    }

    public final void gJ(int i) {
        com.tencent.mm.ui.contact.m bHH = bHH();
        com.tencent.mm.ui.contact.a.a xS = bHH.xS(i - this.ieb.getHeaderViewsCount());
        if (xS != null && xS.euW != null) {
            v.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[]{xS.euW.field_username});
            String str = xS.euW.field_username;
            if (!k.xF().equals(str)) {
                bHM();
                if (this.dud.contains(str)) {
                    if (this.hAP) {
                        d dVar = this.hAQ;
                        if (dVar.size != 0) {
                            int i2;
                            boolean z;
                            boolean z2;
                            int i3 = -1;
                            for (i2 = 0; i2 < dVar.hBq.getChildCount(); i2++) {
                                if (dVar.hBq.getChildAt(i2).getTag().equals(str)) {
                                    i3 = i2;
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                            if (i3 < 0) {
                                i2 = 0;
                                while (i2 < dVar.hBr.getChildCount()) {
                                    if (dVar.hBr.getChildAt(i2).getTag().equals(str)) {
                                        z2 = true;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            i2 = i3;
                            z2 = false;
                            if (i2 >= 0) {
                                if (z2) {
                                    dVar.hBr.removeViewAt(i2);
                                    dVar.size--;
                                }
                                if (z) {
                                    if (dVar.size <= 5) {
                                        dVar.hBq.removeViewAt(i2);
                                        dVar.size--;
                                    } else {
                                        dVar.hBq.removeViewAt(i2);
                                        View childAt = dVar.hBr.getChildAt(0);
                                        dVar.hBr.removeViewAt(0);
                                        dVar.hBq.addView(childAt);
                                        dVar.size--;
                                    }
                                }
                                dVar.nr(dVar.size);
                                dVar.ns(dVar.size);
                            }
                        }
                    }
                    this.dud.remove(str);
                } else if (this.duc.size() + this.dud.size() == 9) {
                    this.hAR = true;
                    Toast.makeText(this, 2131233948, 0).show();
                    return;
                } else {
                    if (this.hAP) {
                        this.hAQ.wV(str);
                    }
                    this.dud.add(str);
                }
                bHH.notifyDataSetChanged();
                NN();
            }
        }
    }

    protected final void ayE() {
        super.ayE();
        axg();
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.dud.contains(aVar.euW.field_username);
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.duc.contains(aVar.euW.field_username);
    }

    private void NN() {
        if (this.dud.size() > 0) {
            U(1, true);
        } else {
            U(1, false);
        }
    }

    protected final int NO() {
        return 1;
    }
}
