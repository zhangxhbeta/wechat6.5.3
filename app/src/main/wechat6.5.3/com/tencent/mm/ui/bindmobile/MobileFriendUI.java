package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.ac;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.x;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.InviteFriendUI;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.v.e;
import java.util.List;

public class MobileFriendUI extends MMActivity implements e {
    private ListView dwO;
    private View dwQ;
    private ProgressDialog dwR = null;
    String dwS;
    private TextView euo = null;
    private TextView nIp = null;
    a ogA;
    private ac ogB;

    static /* synthetic */ void a(MobileFriendUI mobileFriendUI, b bVar) {
        if (be.kS(bVar.getUsername())) {
            v.e("MicroMsg.MobileFriendUI", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", bVar.getUsername());
        intent.putExtra("Contact_Nick", bVar.EG());
        intent.putExtra("Contact_Mobile_MD5", bVar.EB());
        intent.putExtra("Contact_Alias", bVar.cHh);
        intent.putExtra("Contact_Sex", bVar.cHc);
        intent.putExtra("Contact_Signature", bVar.cHf);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(bVar.cHl, bVar.cHd, bVar.cHe));
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra("Contact_ShowUserName", false);
        a.drp.d(intent, (Context) mobileFriendUI);
    }

    static /* synthetic */ void e(MobileFriendUI mobileFriendUI) {
        if (m.EY() != m.a.SUCC && m.EY() != m.a.SUCC_UNLOAD) {
            mobileFriendUI.dwQ.setVisibility(0);
            mobileFriendUI.dwQ.setOnClickListener(new OnClickListener(mobileFriendUI) {
                final /* synthetic */ MobileFriendUI ogC;

                {
                    this.ogC = r1;
                }

                public final void onClick(View view) {
                    MMWizardActivity.w(this.ogC, new Intent(this.ogC, BindMContactIntroUI.class));
                }
            });
            mobileFriendUI.dwO.setVisibility(8);
            mobileFriendUI.euo.setVisibility(8);
        } else if (mobileFriendUI.ogA.getCount() <= 0) {
            mobileFriendUI.euo.setVisibility(0);
            mobileFriendUI.dwO.setVisibility(8);
            mobileFriendUI.dwQ.setVisibility(8);
        } else {
            mobileFriendUI.euo.setVisibility(8);
            mobileFriendUI.dwO.setVisibility(0);
            mobileFriendUI.dwQ.setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131233855);
        ah.FL().cuX.dF("qqlist", "update addr_upload2 set reserved4=0");
        ak.vy().a(32, (e) this);
        ak.vy().a(133, (e) this);
        NI();
        v.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)));
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            aDD();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.MobileFriendUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    aDD();
                    return;
                } else {
                    g.a((Context) this, getString(2131234161), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ MobileFriendUI ogC;

                        {
                            this.ogC = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ogC.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            this.ogC.finish();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ MobileFriendUI ogC;

                        {
                            this.ogC = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ogC.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    private void aDD() {
        if (!m.EX()) {
            Context context = this.nDR.nEl;
            getString(2131231164);
            this.dwR = g.a(context, getString(2131233853), true, new OnCancelListener(this) {
                final /* synthetic */ MobileFriendUI ogC;

                {
                    this.ogC = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.ogC.ogB != null) {
                        ak.vy().c(this.ogC.ogB);
                    }
                }
            });
            if (this.ogA.getCount() != 0) {
                List Ff = m.Ff();
                List Fe = m.Fe();
                if (Ff.size() == 0 && Fe.size() == 0) {
                    ak.vy().a(new x(), 0);
                    return;
                }
                this.ogB = new ac(m.Ff(), m.Fe());
                ak.vy().a(this.ogB, 0);
            } else if (!com.tencent.mm.modelfriend.a.a(new com.tencent.mm.modelfriend.a.b(this) {
                final /* synthetic */ MobileFriendUI ogC;

                {
                    this.ogC = r1;
                }

                public final void ba(boolean z) {
                    v.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
                    if (z) {
                        System.currentTimeMillis();
                        ak.vy().a(new ac(m.Ff(), m.Fe()), 0);
                    } else if (this.ogC.dwR != null) {
                        this.ogC.dwR.dismiss();
                        this.ogC.dwR = null;
                    }
                }
            }) && this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.ogA.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        com.tencent.mm.model.a.e.gf("2");
        ak.vy().b(32, (e) this);
        ak.vy().b(133, (e) this);
        this.ogA.avc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904085;
    }

    protected final void NI() {
        boolean z;
        this.euo = (TextView) findViewById(2131757027);
        this.euo.setText(2131233851);
        this.nIp = (TextView) findViewById(2131757028);
        this.nIp.setText(2131233864);
        this.dwQ = findViewById(2131757015);
        this.dwO = (ListView) findViewById(2131757013);
        p pVar = new p(true, true);
        pVar.oUs = new p.b(this) {
            final /* synthetic */ MobileFriendUI ogC;

            {
                this.ogC = r1;
            }

            public final boolean mk(String str) {
                return false;
            }

            public final void ml(String str) {
                this.ogC.dwS = be.lZ(str);
                MobileFriendUI mobileFriendUI = this.ogC;
                if (mobileFriendUI.ogA != null) {
                    mobileFriendUI.ogA.uU(mobileFriendUI.dwS);
                }
            }

            public final void Of() {
            }

            public final void Og() {
            }

            public final void Oh() {
            }
        };
        a(pVar);
        if (f.Aj().ga("2") != null) {
            String str = f.Aj().ga("2").value;
            if (str.equals("0")) {
                z = false;
            } else if (str.equals("1")) {
                z = true;
            } else {
                z = true;
            }
            com.tencent.mm.model.a.e.ge("2");
        } else {
            z = true;
        }
        v.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", Boolean.valueOf(z));
        if (z) {
            this.ogA = new c(this, new j.a(this) {
                final /* synthetic */ MobileFriendUI ogC;

                {
                    this.ogC = r1;
                }

                public final void Oj() {
                }

                public final void Oi() {
                    MobileFriendUI mobileFriendUI = this.ogC;
                    this.ogC.ogA.getCount();
                    MobileFriendUI.e(mobileFriendUI);
                }
            });
        } else {
            this.ogA = new b(this, new j.a(this) {
                final /* synthetic */ MobileFriendUI ogC;

                {
                    this.ogC = r1;
                }

                public final void Oj() {
                }

                public final void Oi() {
                    MobileFriendUI mobileFriendUI = this.ogC;
                    this.ogC.ogA.getCount();
                    MobileFriendUI.e(mobileFriendUI);
                }
            });
        }
        this.dwO.setAdapter(this.ogA);
        this.dwO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MobileFriendUI ogC;

            {
                this.ogC = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.ogC.dwO.getHeaderViewsCount()) {
                    b bVar = (b) this.ogC.ogA.getItem(i - this.ogC.dwO.getHeaderViewsCount());
                    if (bVar.status == 1 || bVar.status == 2) {
                        MobileFriendUI.a(this.ogC, bVar);
                    }
                    if (bVar.status == 0) {
                        Intent intent = new Intent(this.ogC, InviteFriendUI.class);
                        intent.putExtra("friend_type", 1);
                        intent.putExtra("friend_user_name", bVar.getUsername());
                        intent.putExtra("friend_num", bVar.EJ());
                        intent.putExtra("friend_nick", bVar.ED());
                        intent.putExtra("friend_weixin_nick", bVar.EG());
                        intent.putExtra("friend_scene", 13);
                        this.ogC.startActivity(intent);
                    }
                }
            }
        });
        this.ogA.a(new a.a(this) {
            final /* synthetic */ MobileFriendUI ogC;

            {
                this.ogC = r1;
            }

            public final void vT(int i) {
                if (i > 0) {
                    this.ogC.nIp.setVisibility(8);
                } else {
                    this.ogC.nIp.setVisibility(0);
                }
            }
        });
        if (!(m.EY() == m.a.SUCC || m.EY() == m.a.SUCC_UNLOAD)) {
            this.dwQ = findViewById(2131757015);
            this.dwQ.setVisibility(0);
            this.dwQ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MobileFriendUI ogC;

                {
                    this.ogC = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.ogC.nDR.nEl, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 6);
                    MMWizardActivity.w(this.ogC, intent);
                }
            });
            this.dwO.setVisibility(8);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MobileFriendUI ogC;

            {
                this.ogC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ogC.axg();
                this.ogC.finish();
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener(this) {
            final /* synthetic */ MobileFriendUI ogC;

            {
                this.ogC = r1;
            }

            public final void onClick(View view) {
                c.a(this.ogC.dwO);
            }
        };
        if (!k.yj() || m.EX()) {
            g.a((Context) this, 2131231386, 2131231164, 2131231107, 2131231010, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ MobileFriendUI ogC;

                {
                    this.ogC = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11438, Integer.valueOf(6));
                    v.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(6));
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(12322, Boolean.valueOf(true));
                    l.g(true, true);
                    this.ogC.aDD();
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ MobileFriendUI ogC;

                {
                    this.ogC = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(12322, Boolean.valueOf(false));
                    l.g(false, true);
                    this.ogC.finish();
                }
            });
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 32 && this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (!(i == 0 && i2 == 0)) {
            v.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
        if (kVar.getType() == 133) {
            ak.vy().a(new x(), 0);
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 32) {
                d.aZ(getApplicationContext());
            }
            this.ogA.a(null, null);
        } else if (kVar.getType() == 32) {
            Toast.makeText(this, 2131233852, 0).show();
        }
    }
}
