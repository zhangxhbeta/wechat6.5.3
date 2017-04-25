package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.he;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.plugin.ipcall.a.d;
import com.tencent.mm.plugin.ipcall.a.e.h;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;

public class IPCallAddressUI extends MMActivity implements e {
    private View gKc;
    private ListView gKm;
    private e gKn = null;
    private int gKo = 0;
    private boolean gKp = false;
    private boolean gKq = true;
    private boolean gKr = false;
    private c gKs = new c<he>(this) {
        final /* synthetic */ IPCallAddressUI gKu;

        {
            this.gKu = r2;
            this.nhz = he.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.gKu.gKn != null) {
                this.gKu.gKn.avd();
            }
            return true;
        }
    };
    private Runnable gKt = new Runnable(this) {
        final /* synthetic */ IPCallAddressUI gKu;

        {
            this.gKu = r1;
        }

        public final void run() {
            a.atW().a(null, true);
        }
    };

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        if (((Boolean) com.tencent.mm.model.c.vf().get(t.a.nqW, Boolean.valueOf(false))).booleanValue()) {
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.nqW, Boolean.valueOf(false));
            Intent intent = new Intent();
            intent.setClass(this.nDR.nEl, IPCallAcitivityUI.class);
            this.nDR.nEl.startActivity(intent);
            overridePendingTransition(2130968680, 2130968677);
            this.gKq = false;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallAddressUI gKu;

            {
                this.gKu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.gKu.gKo == 1) {
                    com.tencent.mm.plugin.ipcall.b.drp.t(new Intent(), this.gKu);
                } else {
                    this.gKu.finish();
                }
                return true;
            }
        });
        if (this.gKq) {
            this.gKr = true;
            avf();
        }
        ak.yW();
        this.gKp = ((Boolean) com.tencent.mm.model.c.vf().get(t.a.nqt, Boolean.valueOf(true))).booleanValue();
        vD(2131233354);
        this.gKm = (ListView) findViewById(2131757515);
        this.gKc = findViewById(2131757516);
        this.gKn = new e(this, this.gKm, this.gKc);
        e eVar = this.gKn;
        eVar.gKb = new h(eVar.gKd);
        ViewGroup viewGroup = (ViewGroup) View.inflate(eVar.gKd, 2130903827, null);
        eVar.gKa.addHeaderView(viewGroup, null, false);
        eVar.gKa.setAdapter(eVar.gKb);
        eVar.gKg = (TextView) viewGroup.findViewById(2131757594);
        eVar.gKh = (ImageView) viewGroup.findViewById(2131757595);
        eVar.gKf = (TextView) viewGroup.findViewById(2131757591);
        viewGroup.findViewById(2131757590).setOnClickListener(new OnClickListener(eVar) {
            final /* synthetic */ e gKi;

            {
                this.gKi = r1;
            }

            public final void onClick(View view) {
                ak.yW();
                if (((Boolean) com.tencent.mm.model.c.vf().get(t.a.nqx, Boolean.valueOf(false))).booleanValue()) {
                    ak.yW();
                    h.C(2, ((Integer) com.tencent.mm.model.c.vf().get(t.a.nqy, Integer.valueOf(-1))).intValue(), -1);
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.nqy, Integer.valueOf(-1));
                }
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.nqx, Boolean.valueOf(false));
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.nqz, "");
                ak.yW();
                if (((Integer) com.tencent.mm.model.c.vf().get(t.a.nqB, Integer.valueOf(0))).intValue() != 1) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.nqA, "");
                }
                g.iuh.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                this.gKi.avd();
                Intent intent = new Intent();
                intent.setClass(this.gKi.gKd, IPCallShareCouponUI.class);
                this.gKi.gKd.startActivity(intent);
            }
        });
        viewGroup.findViewById(2131757596).setOnClickListener(new OnClickListener(eVar) {
            final /* synthetic */ e gKi;

            {
                this.gKi = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.gKi.gKd, IPCallContactUI.class);
                this.gKi.gKd.startActivity(intent);
            }
        });
        viewGroup.findViewById(2131757597).setOnClickListener(new OnClickListener(eVar) {
            final /* synthetic */ e gKi;

            {
                this.gKi = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.gKi.gKd, IPCallDialUI.class);
                intent.putExtra("IPCallTalkUI_dialScene", 1);
                this.gKi.gKd.startActivityForResult(intent, 1001);
            }
        });
        eVar.gKa.setOnItemClickListener(new OnItemClickListener(eVar) {
            final /* synthetic */ e gKi;

            {
                this.gKi = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!this.gKi.gKb.lB(i) && (adapterView instanceof ListView)) {
                    k mh = this.gKi.gKb.mh(i - ((ListView) adapterView).getHeaderViewsCount());
                    if (mh != null) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar = null;
                        if (mh.field_addressId > 0) {
                            cVar = i.aur().ca(mh.field_addressId);
                        }
                        Intent intent = new Intent(this.gKi.gKd, IPCallUserProfileUI.class);
                        if (cVar != null) {
                            intent.putExtra("IPCallProfileUI_contactid", cVar.field_contactId);
                            intent.putExtra("IPCallProfileUI_systemUsername", cVar.field_systemAddressBookUsername);
                            intent.putExtra("IPCallProfileUI_wechatUsername", cVar.field_wechatUsername);
                        } else {
                            intent.putExtra("IPCallProfileUI_phonenumber", mh.field_phonenumber);
                        }
                        intent.putExtra("IPCallProfileUI_isNeedShowRecord", true);
                        this.gKi.gKd.startActivity(intent);
                    }
                }
            }
        });
        eVar.gKa.setOnItemLongClickListener(new OnItemLongClickListener(eVar) {
            final /* synthetic */ e gKi;

            {
                this.gKi = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                h hVar = this.gKi.gKb;
                if (hVar.gMQ == null) {
                    hVar.gMQ = m.auV();
                }
                k mh = this.gKi.gKb.mh(i - ((ListView) adapterView).getHeaderViewsCount());
                e eVar = this.gKi;
                int headerViewsCount = i - ((ListView) adapterView).getHeaderViewsCount();
                if (mh != null) {
                    l lVar = new l(eVar.gKd);
                    lVar.jXn = new n.c(eVar) {
                        final /* synthetic */ e gKi;

                        {
                            this.gKi = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            lVar.add(2131231020);
                        }
                    };
                    lVar.jXo = new AnonymousClass8(eVar, mh, headerViewsCount);
                    lVar.aXZ();
                }
                return true;
            }
        });
        eVar.avd();
        ak.yW();
        if (((Boolean) com.tencent.mm.model.c.vf().get(t.a.nqt, Boolean.valueOf(true))).booleanValue()) {
            d.auc().dy(true);
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.nqt, Boolean.valueOf(false));
        } else {
            d.auc().dy(false);
        }
        if (eVar.gKb.getCount() > 0) {
            eVar.gKc.setVisibility(8);
        } else {
            eVar.gKc.setVisibility(0);
        }
        eVar.gKe = true;
        ak.vy().a(257, this);
        com.tencent.mm.sdk.c.a.nhr.e(this.gKs);
        this.gKo = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
        g.iuh.a(257, 0, 1, true);
    }

    protected final int getLayoutId() {
        return 2130903815;
    }

    private void avf() {
        v.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), be.bur()});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            com.tencent.mm.sdk.i.e.a(this.gKt, "IPCallAddressUI_LoadSystemAddressBook");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.gKn != null) {
            e eVar = this.gKn;
            eVar.gKa.setOnItemClickListener(null);
            eVar.gKa.setOnItemLongClickListener(null);
            com.tencent.mm.u.n.AX().b(eVar.gKb);
        }
        ak.vy().b(257, this);
        com.tencent.mm.sdk.c.a.nhr.f(this.gKs);
    }

    protected void onResume() {
        super.onResume();
        if (this.gKn != null) {
            e eVar = this.gKn;
            if (!(eVar.gKb == null || eVar.gKe)) {
                eVar.gKb.notifyDataSetChanged();
                if (eVar.gKb.getCount() > 0) {
                    eVar.gKc.setVisibility(8);
                } else {
                    eVar.gKc.setVisibility(0);
                }
            }
            eVar.gKe = false;
        }
        aR();
        com.tencent.mm.plugin.ipcall.a.f.b.auP().dK(true);
        if (!this.gKr) {
            this.gKr = true;
            avf();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.ipcall.a.d.e) && i == 0 && i2 == 0 && this.gKn != null) {
            this.gKn.avd();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        v.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        if (this.gKo == 1) {
            com.tencent.mm.plugin.ipcall.b.drp.t(new Intent(), this);
        } else {
            super.onBackPressed();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            int i2;
            String str = "MicroMsg.IPCallAddressUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            if (iArr == null) {
                i2 = -1;
            } else {
                i2 = iArr.length;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = be.bur();
            v.w(str, str2, objArr);
            return;
        }
        v.i("MicroMsg.IPCallAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 48:
                if (iArr[0] != 0 && this.gKp) {
                    this.gKp = false;
                    com.tencent.mm.ui.base.g.a(this, getString(2131234161), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ IPCallAddressUI gKu;

                        {
                            this.gKu = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.gKu.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ IPCallAddressUI gKu;

                        {
                            this.gKu = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
