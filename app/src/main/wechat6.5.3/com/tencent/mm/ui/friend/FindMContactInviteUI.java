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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.j;
import com.tencent.mm.modelfriend.j.a;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.List;

public class FindMContactInviteUI extends MMWizardActivity {
    private int dHn;
    private e daB = null;
    private ListView dwO;
    private ProgressDialog dwR = null;
    private TextView euo = null;
    private View hFT;
    private boolean ijq = true;
    private String ivg;
    private int nKU = 2;
    private j oNG;
    private TextView oNH = null;
    private TextView oNI = null;
    private TextView oNJ = null;
    private TextView oNK = null;
    private Button oNL = null;
    private List<String[]> oNM;
    private a oNN = new a(this) {
        final /* synthetic */ FindMContactInviteUI oNQ;

        {
            this.oNQ = r1;
        }

        public final void notifyDataSetChanged() {
            if (this.oNQ.nKU == 2 || this.oNQ.nKU != 1) {
                this.oNQ.oNL.setText(this.oNQ.getString(2131232802, new Object[]{Integer.valueOf(this.oNQ.oNG.getCount())}));
            } else {
                this.oNQ.oNL.setText(this.oNQ.getString(2131232803));
            }
            if (this.oNQ.oNG.ET()) {
                if (!(this.oNQ.nKU == 1 || this.oNQ.oNL.getVisibility() != 0 || this.oNQ.oNK == null)) {
                    this.oNQ.oNL.setVisibility(8);
                    this.oNQ.oNK.setVisibility(0);
                }
            } else if (!(this.oNQ.nKU == 1 || this.oNQ.oNL.getVisibility() != 8 || this.oNQ.oNK == null)) {
                this.oNQ.oNL.setVisibility(0);
                this.oNQ.oNK.setVisibility(8);
            }
            if (this.oNQ.oNG.ES() <= 0 || this.oNQ.nKU == 1) {
                this.oNQ.oNH.setText(this.oNQ.getResources().getQuantityString(2131361799, this.oNQ.oNG.getCount(), new Object[]{Integer.valueOf(this.oNQ.oNG.getCount())}));
                return;
            }
            this.oNQ.oNH.setText(this.oNQ.getResources().getQuantityString(2131361798, this.oNQ.oNG.ES(), new Object[]{Integer.valueOf(this.oNQ.oNG.ES())}));
        }
    };
    private String oNP = null;

    static /* synthetic */ void h(FindMContactInviteUI findMContactInviteUI) {
        findMContactInviteUI.axg();
        if (findMContactInviteUI.oNG.ES() == 0) {
            findMContactInviteUI.aKM();
        } else {
            g.a((Context) findMContactInviteUI, findMContactInviteUI.getString(2131232801), SQLiteDatabase.KeyEmpty, new OnClickListener(findMContactInviteUI) {
                final /* synthetic */ FindMContactInviteUI oNQ;

                {
                    this.oNQ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.oNQ.dHn == 1) {
                        b.mj(ak.uR() + "," + getClass().getName() + ",R300_500_QQ," + ak.dR("R300_500_QQ") + ",3");
                    } else {
                        b.mj(ak.uR() + "," + getClass().getName() + ",R300_500_phone," + ak.dR("R300_500_phone") + ",3");
                    }
                    ak.vy().a(432, this.oNQ.daB = new e(this) {
                        final /* synthetic */ AnonymousClass12 oNR;

                        {
                            this.oNR = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            if (this.oNR.oNQ.dwR != null) {
                                this.oNR.oNQ.dwR.dismiss();
                                this.oNR.oNQ.dwR = null;
                            }
                            if (this.oNR.oNQ.daB != null) {
                                ak.vy().b(432, this.oNR.oNQ.daB);
                                this.oNR.oNQ.daB = null;
                            }
                            this.oNR.oNQ.aKM();
                        }
                    });
                    FindMContactInviteUI findMContactInviteUI = this.oNQ;
                    Context context = this.oNQ.nDR.nEl;
                    this.oNQ.getString(2131231164);
                    findMContactInviteUI.dwR = g.a(context, this.oNQ.getString(2131232805), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass12 oNR;

                        {
                            this.oNR = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    this.oNQ.oNG.iF(this.oNQ.oNP);
                }
            }, new OnClickListener(findMContactInviteUI) {
                final /* synthetic */ FindMContactInviteUI oNQ;

                {
                    this.oNQ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232806);
        com.tencent.mm.plugin.a.a.drq.oz();
        this.oNP = getIntent().getStringExtra("regsetinfo_ticket");
        this.dHn = getIntent().getIntExtra("login_type", 0);
        this.nKU = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.ivg = b.Oa();
        NI();
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
            b.b(true, ak.uR() + "," + getClass().getName() + ",R300_400_QQ," + ak.dR("R300_400_QQ") + ",1");
        } else {
            b.b(true, ak.uR() + "," + getClass().getName() + ",R300_400_phone," + ak.dR("R300_400_phone") + ",1");
        }
        if (this.ijq) {
            v.i("MicroMsg.FindMContactInviteUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), be.bur());
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                bIE();
            }
        }
    }

    private void bIE() {
        Context context = this.nDR.nEl;
        getString(2131231164);
        this.dwR = g.a(context, getString(2131233853), true, new OnCancelListener(this) {
            final /* synthetic */ FindMContactInviteUI oNQ;

            {
                this.oNQ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        ak.vA().a(new ad.a(this) {
            final /* synthetic */ FindMContactInviteUI oNQ;

            {
                this.oNQ = r1;
            }

            public final boolean Ba() {
                if (this.oNQ.dwR != null) {
                    this.oNQ.dwR.dismiss();
                    this.oNQ.dwR = null;
                }
                this.oNQ.oNG.notifyDataSetChanged();
                return false;
            }

            public final boolean AZ() {
                try {
                    this.oNQ.oNM = com.tencent.mm.pluginsdk.a.cW(this.oNQ);
                } catch (Throwable e) {
                    v.a("MicroMsg.FindMContactInviteUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                this.oNQ.oNG.cHz = this.oNQ.oNM;
                this.oNQ.oNG.f(ah.FR());
                return true;
            }

            public final String toString() {
                return super.toString() + "|listMFriendData";
            }
        });
    }

    public void onPause() {
        super.onPause();
        if (this.dHn == 1) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R300_400_QQ," + ak.dR("R300_400_QQ") + ",2");
        } else {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R300_400_phone," + ak.dR("R300_400_phone") + ",2");
        }
    }

    public void onDestroy() {
        if (this.daB != null) {
            ak.vy().b(432, this.daB);
            this.daB = null;
        }
        if (this.oNG != null) {
            j jVar = this.oNG;
            if (jVar.cHD != null) {
                jVar.cHD.detach();
                jVar.cHD = null;
            }
        }
        ah.FS();
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
            this.oNI.setText(getString(2131232807));
            this.oNJ.setText(getString(2131232804));
            this.oNL.setText(getString(2131232802, new Object[]{Integer.valueOf(0)}));
            this.oNK = (TextView) this.hFT.findViewById(2131757031);
        } else {
            this.hFT = LayoutInflater.from(this).inflate(2130903639, null);
            this.oNH = (TextView) this.hFT.findViewById(2131757030);
            this.oNI = (TextView) this.hFT.findViewById(2131757029);
            this.oNJ = (TextView) this.hFT.findViewById(2131757033);
            this.oNL = (Button) this.hFT.findViewById(2131757032);
            this.oNI.setText(getString(2131232804));
            this.oNJ.setText(getString(2131232804));
            this.oNL.setText(getString(2131232803));
        }
        this.oNG = new j(this, this.oNN, 2);
        this.oNL.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ FindMContactInviteUI oNQ;

            {
                this.oNQ = r1;
            }

            public final void onClick(View view) {
                b.mj(ak.uR() + "," + this.oNQ.getClass().getName() + ",R300_400_AddAllButton," + ak.dR("R300_300_AddAllButton") + ",3");
                if (this.oNQ.nKU == 2) {
                    this.oNQ.oNG.bb(true);
                    this.oNQ.oNG.notifyDataSetChanged();
                    this.oNQ.oNL.setVisibility(8);
                    if (this.oNQ.oNK != null) {
                        this.oNQ.oNK.setVisibility(0);
                    }
                } else if (this.oNQ.nKU == 1) {
                    this.oNQ.oNG.bb(true);
                    this.oNQ.oNG.notifyDataSetChanged();
                    FindMContactInviteUI.h(this.oNQ);
                } else {
                    this.oNQ.oNG.bb(true);
                    this.oNQ.oNG.notifyDataSetChanged();
                    this.oNQ.oNL.setVisibility(8);
                    if (this.oNQ.oNK != null) {
                        this.oNQ.oNK.setVisibility(0);
                    }
                }
            }
        });
        if (this.oNK != null) {
            this.oNK.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ FindMContactInviteUI oNQ;

                {
                    this.oNQ = r1;
                }

                public final void onClick(View view) {
                    this.oNQ.oNL.setVisibility(0);
                    this.oNQ.oNK.setVisibility(8);
                    this.oNQ.oNG.bb(false);
                    this.oNQ.oNG.notifyDataSetChanged();
                }
            });
            this.oNK.setVisibility(8);
        }
        this.dwO.addHeaderView(this.hFT);
        this.dwO.setAdapter(this.oNG);
        this.dwO.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        this.dwO.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FindMContactInviteUI oNQ;

            {
                this.oNQ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.oNQ.oNG != null) {
                    j b = this.oNQ.oNG;
                    if (b.cHD != null) {
                        b.cHD.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ FindMContactInviteUI oNQ;

            {
                this.oNQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                FindMContactInviteUI.h(this.oNQ);
                return true;
            }
        });
        AnonymousClass11 anonymousClass11 = new View.OnClickListener(this) {
            final /* synthetic */ FindMContactInviteUI oNQ;

            {
                this.oNQ = r1;
            }

            public final void onClick(View view) {
                c.a(this.oNQ.dwO);
            }
        };
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.FindMContactInviteUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    bIE();
                    return;
                }
                this.ijq = false;
                g.a((Context) this, getString(2131234161), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                    final /* synthetic */ FindMContactInviteUI oNQ;

                    {
                        this.oNQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oNQ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.oNQ.ijq = true;
                        this.oNQ.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ FindMContactInviteUI oNQ;

                    {
                        this.oNQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oNQ.ijq = true;
                        this.oNQ.finish();
                    }
                });
                return;
            default:
                return;
        }
    }
}
