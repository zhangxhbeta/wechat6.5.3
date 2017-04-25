package com.tencent.mm.plugin.ipcall.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class IPCallContactUI extends MMActivity implements e {
    private ac cnC = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ IPCallContactUI gKN;

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (this.gKN.gKB != null) {
                    this.gKN.gKB.dismiss();
                }
                this.gKN.gKD.setVisibility(0);
                c.gIA = b.auR();
                this.gKN.gKC.Ol();
                this.gKN.gKC.notifyDataSetChanged();
                this.gKN.gKm.invalidateViews();
                this.gKN.gKF.mb(this.gKN.gKC.getCount());
                a.atI().MR();
            } else if (message.what == 2) {
                if (this.gKN.gKC.getCount() == 0) {
                    this.gKN.gKH.setVisibility(0);
                } else {
                    this.gKN.gKH.setVisibility(8);
                }
                if (this.gKN.gKC.getCount() != 0 && this.gKN.gKM) {
                    this.gKN.gKC.notifyDataSetChanged();
                }
            }
        }
    };
    private String dwS;
    private p eSv = new p(true, true);
    private ProgressDialog gKB = null;
    private c gKC;
    private RelativeLayout gKD;
    private LinearLayout gKE;
    private IPCallAddressCountView gKF = null;
    private VerticalScrollBar gKG;
    private LinearLayout gKH;
    private int gKI = -1;
    private int gKJ = -1;
    private com.tencent.mm.plugin.ipcall.a.a.a gKK = new com.tencent.mm.plugin.ipcall.a.a.a(this) {
        final /* synthetic */ IPCallContactUI gKN;

        {
            this.gKN = r1;
        }

        public final void atX() {
            this.gKN.cnC.sendEmptyMessage(1);
        }
    };
    private Runnable gKL = new Runnable(this) {
        final /* synthetic */ IPCallContactUI gKN;

        {
            this.gKN = r1;
        }

        public final void run() {
            if (this.gKN.gKC != null && this.gKN.gKm != null && !this.gKN.gKC.eyB) {
                this.gKN.gKC.uU(this.gKN.dwS);
                this.gKN.cnC.sendEmptyMessage(2);
                this.gKN.gKm.invalidateViews();
            }
        }
    };
    private boolean gKM = true;
    private ListView gKm;
    private Runnable gKt = new Runnable(this) {
        final /* synthetic */ IPCallContactUI gKN;

        {
            this.gKN = r1;
        }

        public final void run() {
            com.tencent.mm.plugin.ipcall.a.a.atW().a(this.gKN.gKK, false);
        }
    };

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131233336);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallContactUI gKN;

            {
                this.gKN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gKN.finish();
                return true;
            }
        });
        v.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), be.bur()});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            this.gKD = (RelativeLayout) findViewById(2131757519);
            this.gKE = (LinearLayout) findViewById(2131757514);
            this.gKm = (ListView) findViewById(2131757515);
            this.gKG = (VerticalScrollBar) findViewById(2131755320);
            this.gKH = (LinearLayout) findViewById(2131757516);
            this.eSv.oUs = new p.b(this) {
                final /* synthetic */ IPCallContactUI gKN;

                {
                    this.gKN = r1;
                }

                public final void Og() {
                    v.d("MicroMsg.IPCallContactUI", "onEnterSearch");
                    g.iuh.h(12767, new Object[]{Integer.valueOf(1)});
                    this.gKN.gKE.setVisibility(0);
                    this.gKN.gKm.setVisibility(8);
                    this.gKN.gKF.setVisibility(8);
                    this.gKN.dM(false);
                }

                public final void Of() {
                    v.d("MicroMsg.IPCallContactUI", "onQuitSearch");
                    this.gKN.uU("");
                    this.gKN.dM(true);
                    this.gKN.gKE.setVisibility(8);
                    this.gKN.gKm.setVisibility(0);
                    this.gKN.gKF.setVisibility(0);
                }

                public final void ml(String str) {
                    v.d("MicroMsg.IPCallContactUI", "onSearchChange");
                    this.gKN.uU(str);
                    if (!be.kS(str)) {
                        this.gKN.gKE.setVisibility(8);
                        this.gKN.gKm.setVisibility(0);
                        this.gKN.gKF.setVisibility(8);
                    }
                }

                public final boolean mk(String str) {
                    v.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
                    return false;
                }

                public final void Oh() {
                    this.gKN.gKE.setVisibility(0);
                    this.gKN.gKm.setVisibility(8);
                    this.gKN.gKF.setVisibility(8);
                }
            };
            this.eSv.oUx = 2131231148;
            a(this.eSv);
            this.gKC = new c(this.nDR.nEl);
            c.gIA = b.auR();
            this.gKF = new IPCallAddressCountView(this.nDR.nEl, this.gKC.avb());
            this.gKm.addFooterView(this.gKF, null, false);
            this.gKm.setAdapter(this.gKC);
            this.gKm.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ IPCallContactUI gKN;

                {
                    this.gKN = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!this.gKN.gKC.lB(i)) {
                        c ma = this.gKN.gKC.ma(i);
                        if (ma != null) {
                            if (!this.gKN.gKM) {
                                g.iuh.h(12767, new Object[]{Integer.valueOf(2)});
                            }
                            Intent intent = new Intent(this.gKN.nDR.nEl, IPCallUserProfileUI.class);
                            intent.putExtra("IPCallProfileUI_contactid", ma.field_contactId);
                            intent.putExtra("IPCallProfileUI_systemUsername", ma.field_systemAddressBookUsername);
                            intent.putExtra("IPCallProfileUI_wechatUsername", ma.field_wechatUsername);
                            this.gKN.nDR.nEl.startActivity(intent);
                        }
                    }
                }
            });
            this.gKG.setVisibility(0);
            this.gKm.setOnScrollListener(new OnScrollListener(this) {
                final /* synthetic */ IPCallContactUI gKN;
                private int gKO = 0;

                {
                    this.gKN = r2;
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    this.gKO = i;
                    this.gKN.axg();
                }

                @TargetApi(11)
                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (this.gKN.gKI == -1) {
                        this.gKN.gKI = i;
                    } else if (this.gKN.gKJ == -1) {
                        this.gKN.gKJ = i;
                    }
                }
            });
            this.gKG.obP = new VerticalScrollBar.a(this) {
                final /* synthetic */ IPCallContactUI gKN;

                {
                    this.gKN = r1;
                }

                public final void pC(String str) {
                    if ("↑".equals(str)) {
                        this.gKN.gKm.setSelection(0);
                        return;
                    }
                    int intValue;
                    c d = this.gKN.gKC;
                    if (d.eTn.containsKey(str)) {
                        intValue = ((Integer) d.eTn.get(str)).intValue();
                    } else {
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        this.gKN.gKm.setSelection(intValue);
                    }
                }
            };
            if (this.gKC.avb() <= 0) {
                this.gKD.setVisibility(8);
                ActionBarActivity actionBarActivity = this.nDR.nEl;
                this.nDR.nEl.getString(2131231164);
                this.gKB = com.tencent.mm.ui.base.g.a(actionBarActivity, this.nDR.nEl.getString(2131233353), true, new OnCancelListener(this) {
                    final /* synthetic */ IPCallContactUI gKN;

                    {
                        this.gKN = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.gKN.finish();
                    }
                });
                com.tencent.mm.sdk.i.e.a(this.gKt, "IPCall_LoadSystemAddressBook");
                return;
            }
            a.atI().MR();
        }
    }

    public final void uU(String str) {
        this.dwS = str;
        this.cnC.removeCallbacks(this.gKL);
        this.cnC.postDelayed(this.gKL, 200);
    }

    public final void dM(boolean z) {
        this.gKM = z;
        if (this.gKM) {
            this.gKC.notifyDataSetChanged();
        }
    }

    protected final int getLayoutId() {
        return 2130903817;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.ipcall.a.a atW = com.tencent.mm.plugin.ipcall.a.a.atW();
        com.tencent.mm.plugin.ipcall.a.a.a aVar = this.gKK;
        if (atW.gEv.contains(aVar)) {
            atW.gEv.remove(aVar);
        }
        this.cnC.removeMessages(1);
        ak.vy().b(257, this);
    }

    protected void onResume() {
        super.onResume();
        aR();
        com.tencent.mm.plugin.ipcall.a.f.b.auP().dK(false);
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        v.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.IPCallContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234161), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ IPCallContactUI gKN;

                        {
                            this.gKN = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.gKN.finish();
                            this.gKN.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ IPCallContactUI gKN;

                        {
                            this.gKN = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.gKN.finish();
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
