package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.j;
import com.tencent.mm.modelfriend.j.a;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAddUI extends MMWizardActivity {
    private String cZU = null;
    private int dHn;
    private e daB = null;
    private ListView dwO;
    private ProgressDialog dwR = null;
    private TextView euo = null;
    private View hFT;
    private boolean ijq = true;
    private String ivg;
    private String nKT = SQLiteDatabase.KeyEmpty;
    private int nKU = 2;
    private j oNG;
    private TextView oNH = null;
    private TextView oNI = null;
    private TextView oNJ = null;
    private TextView oNK = null;
    private Button oNL = null;
    private List<String[]> oNM;
    private a oNN = new a(this) {
        final /* synthetic */ FindMContactAddUI oNO;

        {
            this.oNO = r1;
        }

        public final void notifyDataSetChanged() {
            if (this.oNO.nKU == 2 || this.oNO.nKU != 1) {
                this.oNO.oNL.setText(this.oNO.getString(2131232793, new Object[]{Integer.valueOf(this.oNO.oNG.getCount())}));
            } else {
                this.oNO.oNL.setText(this.oNO.getString(2131232794));
            }
            if (this.oNO.oNG.ET()) {
                if (!(this.oNO.nKU == 1 || this.oNO.oNL.getVisibility() != 0 || this.oNO.oNK == null)) {
                    this.oNO.oNL.setVisibility(8);
                    this.oNO.oNK.setVisibility(0);
                }
            } else if (!(this.oNO.nKU == 1 || this.oNO.oNL.getVisibility() != 8 || this.oNO.oNK == null)) {
                this.oNO.oNL.setVisibility(0);
                this.oNO.oNK.setVisibility(8);
            }
            if (this.oNO.oNG.ES() <= 0 || this.oNO.nKU == 1) {
                this.oNO.oNH.setText(this.oNO.getResources().getQuantityString(2131361800, this.oNO.oNG.getCount(), new Object[]{Integer.valueOf(this.oNO.oNG.getCount())}));
                return;
            }
            this.oNO.oNH.setText(this.oNO.getResources().getQuantityString(2131361797, this.oNO.oNG.ES(), new Object[]{Integer.valueOf(this.oNO.oNG.ES())}));
        }
    };

    static /* synthetic */ void i(FindMContactAddUI findMContactAddUI) {
        findMContactAddUI.axg();
        if (findMContactAddUI.oNG.ES() == 0) {
            g.b((Context) findMContactAddUI, findMContactAddUI.getString(2131232815), SQLiteDatabase.KeyEmpty, findMContactAddUI.getString(2131232791), findMContactAddUI.getString(2131232792), new OnClickListener(findMContactAddUI) {
                final /* synthetic */ FindMContactAddUI oNO;

                {
                    this.oNO = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new OnClickListener(findMContactAddUI) {
                final /* synthetic */ FindMContactAddUI oNO;

                {
                    this.oNO = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.oNO.nKT == null || !this.oNO.nKT.contains("2")) {
                        this.oNO.aKM();
                        return;
                    }
                    Intent intent = new Intent(this.oNO, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", this.oNO.cZU);
                    intent.putExtra("login_type", this.oNO.dHn);
                    intent.putExtra("regsetinfo_NextStyle", this.oNO.nKU);
                    MMWizardActivity.w(this.oNO, intent);
                }
            });
            return;
        }
        n vy = ak.vy();
        e anonymousClass2 = new e(findMContactAddUI) {
            final /* synthetic */ FindMContactAddUI oNO;

            {
                this.oNO = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                if (this.oNO.dwR != null) {
                    this.oNO.dwR.dismiss();
                    this.oNO.dwR = null;
                }
                if (this.oNO.daB != null) {
                    ak.vy().b(30, this.oNO.daB);
                    this.oNO.daB = null;
                }
                if (i == 4 && i2 == -24 && !be.kS(str)) {
                    Toast.makeText(this.oNO.nDR.nEl, str, 1).show();
                } else if (this.oNO.nKT == null || !this.oNO.nKT.contains("2")) {
                    this.oNO.aKM();
                } else {
                    Intent intent = new Intent(this.oNO, FindMContactInviteUI.class);
                    intent.putExtra("regsetinfo_ticket", this.oNO.cZU);
                    intent.putExtra("login_type", this.oNO.dHn);
                    intent.putExtra("regsetinfo_NextStyle", this.oNO.nKU);
                    MMWizardActivity.w(this.oNO, intent);
                }
            }
        };
        findMContactAddUI.daB = anonymousClass2;
        vy.a(30, anonymousClass2);
        Context context = findMContactAddUI.nDR.nEl;
        findMContactAddUI.getString(2131231164);
        findMContactAddUI.dwR = g.a(context, findMContactAddUI.getString(2131232805), true, new OnCancelListener(findMContactAddUI) {
            final /* synthetic */ FindMContactAddUI oNO;

            {
                this.oNO = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        j jVar = findMContactAddUI.oNG;
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (int i = 0; i < jVar.cHx.size(); i++) {
            if (jVar.cHB[i] == 1) {
                linkedList.add(((agl) jVar.cHx.get(i)).gln);
                linkedList2.add(Integer.valueOf(52));
            }
        }
        ak.vy().a(new m(2, linkedList, linkedList2, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232798);
        com.tencent.mm.plugin.a.a.drq.oz();
        this.cZU = getIntent().getStringExtra("regsetinfo_ticket");
        this.nKT = getIntent().getStringExtra("regsetinfo_NextStep");
        this.nKU = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.dHn = getIntent().getIntExtra("login_type", 0);
        this.ivg = b.Oa();
        NI();
    }

    private void bIE() {
        Context context = this.nDR.nEl;
        getString(2131231164);
        this.dwR = g.a(context, getString(2131233853), true, new OnCancelListener(this) {
            final /* synthetic */ FindMContactAddUI oNO;

            {
                this.oNO = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ak.vA().a(new ad.a(this) {
            final /* synthetic */ FindMContactAddUI oNO;

            {
                this.oNO = r1;
            }

            public final boolean Ba() {
                if (this.oNO.dwR != null) {
                    this.oNO.dwR.dismiss();
                    this.oNO.dwR = null;
                }
                this.oNO.oNG.notifyDataSetChanged();
                return false;
            }

            public final boolean AZ() {
                try {
                    this.oNO.oNM = com.tencent.mm.pluginsdk.a.cW(this.oNO);
                } catch (Throwable e) {
                    v.a("MicroMsg.FindMContactAddUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                this.oNO.oNG.cHz = this.oNO.oNM;
                this.oNO.oNG.f(ah.FR());
                return true;
            }

            public final String toString() {
                return super.toString() + "|listMFriendData";
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aKM();
        return true;
    }

    private void aKM() {
        b.mi(this.ivg);
        axg();
        bAv();
    }

    protected void onResume() {
        super.onResume();
        this.oNG.notifyDataSetChanged();
        if (this.dHn == 1) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",R300_300_QQ," + ak.dR("R300_300_QQ") + ",1");
            b.mh("R300_300_QQ");
        } else {
            b.b(true, ak.uR() + "," + getClass().getName() + ",R300_300_phone," + ak.dR("R300_300_phone") + ",1");
            b.mh("R300_300_phone");
        }
        if (this.ijq) {
            v.i("MicroMsg.FindMContactAddUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), be.bur());
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                bIE();
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (this.dHn == 1) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R300_300_QQ," + ak.dR("R300_300_QQ") + ",2");
        } else {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R300_300_phone," + ak.dR("R300_300_phone") + ",2");
        }
    }

    public void onDestroy() {
        if (this.daB != null) {
            ak.vy().b(30, this.daB);
            this.daB = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903637;
    }

    protected final void NI() {
        this.euo = (TextView) findViewById(2131757027);
        this.euo.setText(2131233851);
        this.dwO = (ListView) findViewById(2131757013);
        if (this.nKU == 2 || this.nKU != 1) {
            this.hFT = LayoutInflater.from(this).inflate(2130903638, null);
            this.oNH = (TextView) this.hFT.findViewById(2131757030);
            this.oNI = (TextView) this.hFT.findViewById(2131757029);
            this.oNJ = (TextView) this.hFT.findViewById(2131757033);
            this.oNL = (Button) this.hFT.findViewById(2131757032);
            this.oNI.setText(getString(2131232826));
            this.oNJ.setText(getString(2131232827));
            this.oNL.setText(getString(2131232793, new Object[]{Integer.valueOf(0)}));
            this.oNK = (TextView) this.hFT.findViewById(2131757031);
        } else {
            this.hFT = LayoutInflater.from(this).inflate(2130903639, null);
            this.oNH = (TextView) this.hFT.findViewById(2131757030);
            this.oNI = (TextView) this.hFT.findViewById(2131757029);
            this.oNJ = (TextView) this.hFT.findViewById(2131757033);
            this.oNL = (Button) this.hFT.findViewById(2131757032);
            this.oNI.setText(getString(2131232826));
            this.oNJ.setText(getString(2131232827));
            this.oNL.setText(getString(2131232794));
        }
        this.oNG = new j(this, this.oNN, 1);
        this.oNL.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ FindMContactAddUI oNO;

            {
                this.oNO = r1;
            }

            public final void onClick(View view) {
                b.mj(ak.uR() + "," + this.oNO.getClass().getName() + ",R300_300_AddAllButton," + ak.dR("R300_300_AddAllButton") + ",3");
                if (this.oNO.nKU == 2) {
                    this.oNO.oNG.bb(true);
                    this.oNO.oNG.notifyDataSetChanged();
                    this.oNO.oNL.setVisibility(8);
                    if (this.oNO.oNK != null) {
                        this.oNO.oNK.setVisibility(0);
                    }
                } else if (this.oNO.nKU == 1) {
                    this.oNO.oNG.bb(true);
                    this.oNO.oNG.notifyDataSetChanged();
                    FindMContactAddUI.i(this.oNO);
                } else {
                    this.oNO.oNG.bb(true);
                    this.oNO.oNG.notifyDataSetChanged();
                    this.oNO.oNL.setVisibility(8);
                    if (this.oNO.oNK != null) {
                        this.oNO.oNK.setVisibility(0);
                    }
                }
            }
        });
        if (this.oNK != null) {
            this.oNK.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FindMContactAddUI oNO;

                {
                    this.oNO = r1;
                }

                public final void onClick(View view) {
                    this.oNO.oNL.setVisibility(0);
                    this.oNO.oNK.setVisibility(8);
                    this.oNO.oNG.bb(false);
                    this.oNO.oNG.notifyDataSetChanged();
                }
            });
            this.oNK.setVisibility(8);
        }
        this.dwO.addHeaderView(this.hFT);
        this.dwO.setAdapter(this.oNG);
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ FindMContactAddUI oNO;

            {
                this.oNO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                FindMContactAddUI.i(this.oNO);
                return true;
            }
        });
        AnonymousClass11 anonymousClass11 = new View.OnClickListener(this) {
            final /* synthetic */ FindMContactAddUI oNO;

            {
                this.oNO = r1;
            }

            public final void onClick(View view) {
                c.a(this.oNO.dwO);
            }
        };
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.FindMContactAddUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    bIE();
                    return;
                }
                this.ijq = false;
                g.a((Context) this, getString(2131234161), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                    final /* synthetic */ FindMContactAddUI oNO;

                    {
                        this.oNO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oNO.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.oNO.ijq = true;
                        this.oNO.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ FindMContactAddUI oNO;

                    {
                        this.oNO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oNO.ijq = true;
                        this.oNO.finish();
                    }
                });
                return;
            default:
                return;
        }
    }
}
