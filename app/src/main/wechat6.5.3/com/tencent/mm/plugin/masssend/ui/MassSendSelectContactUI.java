package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.k.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MassSendSelectContactUI extends MMBaseSelectContactUI {
    private HashSet<String> dud;
    private List<String> ejp;
    private Button hkF;
    private boolean hkG;
    private MultiSelectContactView hkH;

    protected final void NH() {
        super.NH();
        this.ejp = new ArrayList();
        this.ejp.addAll(r.bHP());
        this.ejp.addAll(r.bHQ());
        this.ejp.add(k.xF());
        this.dud = new HashSet();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.MassSendSelectContactUI", "create!");
        this.hkH = this.hkH;
        if (this.hkH == null) {
            finish();
            return;
        }
        this.hkH.setBackgroundDrawable(null);
        a(1, getString(2131233820), new OnMenuItemClickListener(this) {
            final /* synthetic */ MassSendSelectContactUI hkI;

            {
                this.hkI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                v.i("MicroMsg.MassSendSelectContactUI", "Click Next Btn");
                List g = be.g((String[]) this.hkI.dud.toArray(new String[0]));
                if (g == null) {
                    v.e("MicroMsg.MassSendSelectContactUI", "no choosed anyone");
                    return false;
                }
                g.remove(k.xF());
                String b = be.b(g, ";");
                Intent intent = new Intent(this.hkI, MassSendMsgUI.class);
                intent.putExtra("mass_send_contact_list", b);
                this.hkI.startActivity(intent);
                return true;
            }
        }, b.nET);
        this.hkF = (Button) findViewById(2131758178);
        this.hkF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MassSendSelectContactUI hkI;

            {
                this.hkI = r1;
            }

            public final void onClick(View view) {
                boolean z;
                v.i("MicroMsg.MassSendSelectContactUI", "Click SelectAll");
                m mVar = (m) ((HeaderViewListAdapter) this.hkI.ieb.getAdapter()).getWrappedAdapter();
                if (this.hkI.hkG) {
                    this.hkI.hkF.setText(2131233821);
                    Iterator it = this.hkI.dud.iterator();
                    while (it.hasNext()) {
                        this.hkI.hkH.Hq((String) it.next());
                    }
                    this.hkI.dud.clear();
                } else {
                    this.hkI.hkF.setText(2131233809);
                    int count = mVar.getCount();
                    for (int i = 0; i < count; i++) {
                        a xS = mVar.xS(i);
                        if (!(xS == null || xS.euW == null || this.hkI.dud.contains(xS.euW.field_username))) {
                            this.hkI.dud.add(xS.euW.field_username);
                            this.hkI.hkH.Hq(xS.euW.field_username);
                        }
                    }
                }
                MassSendSelectContactUI massSendSelectContactUI = this.hkI;
                if (this.hkI.hkG) {
                    z = false;
                } else {
                    z = true;
                }
                massSendSelectContactUI.hkG = z;
                this.hkI.mT(this.hkI.dud.size());
                mVar.notifyDataSetChanged();
            }
        });
        this.hkH.lHi = new MultiSelectContactView.a(this) {
            final /* synthetic */ MassSendSelectContactUI hkI;

            {
                this.hkI = r1;
            }

            public final void mf(String str) {
                if (str != null) {
                    this.hkI.dud.remove(str);
                    this.hkI.mT(this.hkI.dud.size());
                }
            }
        };
        mT(this.dud.size());
    }

    private void mT(int i) {
        if (i > 0) {
            aq(1, getString(2131233820) + "(" + this.dud.size() + ")");
            U(1, true);
            return;
        }
        aq(1, getString(2131233820));
        U(1, false);
    }

    protected final void wt(String str) {
        g.iuh.h(11225, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        Intent intent = new Intent();
        intent.putExtra("label", str);
        intent.putExtra("always_select_contact", be.b(new ArrayList(this.dud), ","));
        intent.putExtra("list_attr", r.s(new int[]{16384, 64}));
        c.a(this, ".ui.contact.SelectLabelContactUI", intent, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        v.i("MicroMsg.MassSendSelectContactUI", "requestCode=%d | resultCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 0:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (be.kS(stringExtra)) {
                        v.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    v.i("MicroMsg.MassSendSelectContactUI", "GET_LABEL_USERS select username=%s", new Object[]{stringExtra});
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str = split[i3];
                        if (this.dud.add(str)) {
                            this.hkH.Hq(str);
                        }
                        i3++;
                    }
                    mT(this.dud.size());
                    bHH().notifyDataSetChanged();
                    if (this.eSv != null) {
                        this.eSv.clearFocus();
                        this.eSv.bJs();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903958;
    }

    public final void gJ(int i) {
        m bHH = bHH();
        a xS = bHH.xS(i - this.ieb.getHeaderViewsCount());
        if (xS != null && xS.euW != null) {
            v.i("MicroMsg.MassSendSelectContactUI", "ClickUser=%s", new Object[]{xS.euW.field_username});
            String str = xS.euW.field_username;
            bHM();
            if (this.dud.contains(str)) {
                this.dud.remove(str);
                this.hkH.Hq(str);
            } else {
                this.dud.add(str);
                this.hkH.Hq(str);
            }
            mT(this.dud.size());
            bHH.notifyDataSetChanged();
            bHM();
            bHN();
        }
    }

    protected final boolean NJ() {
        return true;
    }

    protected final String NK() {
        return getString(2131233822);
    }

    protected final n NL() {
        com.tencent.mm.ui.contact.c.a aVar = new com.tencent.mm.ui.contact.c.a();
        aVar.oER = true;
        return new com.tencent.mm.ui.contact.c(this, this.ejp, true, true, aVar);
    }

    protected final p NM() {
        return new p(this, this.ejp, true, this.scene);
    }

    public final boolean a(a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.dud.contains(aVar.euW.field_username);
    }

    public final int[] ayD() {
        return new int[]{131072};
    }

    protected final boolean azF() {
        return true;
    }
}
