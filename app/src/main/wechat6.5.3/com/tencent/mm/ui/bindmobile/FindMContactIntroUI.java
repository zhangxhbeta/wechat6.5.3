package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactIntroUI extends MMWizardActivity {
    private String bhT;
    private List<String[]> cHz = null;
    private String cZU = null;
    private e daB = null;
    private ProgressDialog dwR = null;
    private String ivg;
    private TextView izs;
    private String nKT = SQLiteDatabase.KeyEmpty;
    private int nKU = 2;
    private boolean ofS = false;
    private aa ofT;
    private Button ogg;
    private TextView ogh;

    static /* synthetic */ void a(FindMContactIntroUI findMContactIntroUI) {
        if (findMContactIntroUI.ofS) {
            b.mj(ak.uR() + "," + findMContactIntroUI.getClass().getName() + ",R300_200_phone," + ak.dR("R300_200_phone") + ",1");
            g.a((Context) findMContactIntroUI, 2131232799, 2131231164, 2131231107, 2131231010, new OnClickListener(findMContactIntroUI) {
                final /* synthetic */ FindMContactIntroUI ogi;

                {
                    this.ogi = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.yW();
                    c.vf().set(12322, Boolean.valueOf(true));
                    b.mi("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", this.ogi.cZU);
                    intent.putExtra("regsetinfo_NextStep", this.ogi.nKT);
                    intent.putExtra("regsetinfo_NextStyle", this.ogi.nKU);
                    a.drp.a(this.ogi, intent);
                    b.mi("R300_300_phone");
                    b.b(false, ak.uR() + "," + this.ogi.getClass().getName() + ",R300_200_phone," + ak.dR("R300_200_phone") + ",2");
                }
            }, new OnClickListener(findMContactIntroUI) {
                final /* synthetic */ FindMContactIntroUI ogi;

                {
                    this.ogi = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.yW();
                    c.vf().set(12322, Boolean.valueOf(false));
                }
            });
        } else if (m.EX()) {
            b.mj(ak.uR() + "," + findMContactIntroUI.getClass().getName() + ",R300_200_phone," + ak.dR("R300_200_phone") + ",1");
            g.a((Context) findMContactIntroUI, 2131232799, 2131231164, 2131231107, 2131231010, new OnClickListener(findMContactIntroUI) {
                final /* synthetic */ FindMContactIntroUI ogi;

                {
                    this.ogi = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.yW();
                    c.vf().set(12322, Boolean.valueOf(true));
                    this.ogi.bDq();
                }
            }, new OnClickListener(findMContactIntroUI) {
                final /* synthetic */ FindMContactIntroUI ogi;

                {
                    this.ogi = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.yW();
                    c.vf().set(12322, Boolean.valueOf(false));
                }
            });
        } else {
            findMContactIntroUI.bDq();
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        vD(2131232816);
        a.drq.oz();
        this.cZU = getIntent().getStringExtra("regsetinfo_ticket");
        this.nKT = getIntent().getStringExtra("regsetinfo_NextStep");
        this.nKU = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        if (m.EY() != m.a.SUCC) {
            z = true;
        } else {
            z = false;
        }
        this.ofS = z;
        this.ivg = b.Oa();
        v.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", this.nKT, Integer.valueOf(this.nKU));
    }

    public void onDestroy() {
        if (this.daB != null) {
            ak.vy().b(431, this.daB);
            this.daB = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        NI();
        if (this.ofS) {
            b.b(true, ak.uR() + "," + getClass().getName() + ",R300_100_QQ," + ak.dR("R300_100_QQ") + ",1");
            b.mh("R300_100_QQ");
            return;
        }
        b.b(true, ak.uR() + "," + getClass().getName() + ",R300_100_phone," + ak.dR("R300_100_phone") + ",1");
        b.mh("R300_100_phone");
    }

    protected void onPause() {
        super.onPause();
        b.mi("RE900_100");
        if (this.ofS) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R300_100_QQ," + ak.dR("R300_100_QQ") + ",4");
        } else {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R300_100_phone," + ak.dR("R300_100_phone") + ",4");
        }
    }

    protected final void NI() {
        this.ogg = (Button) findViewById(2131757034);
        this.ogh = (TextView) findViewById(2131757036);
        this.izs = (TextView) findViewById(2131757035);
        if (this.nKT == null || !this.nKT.contains("2")) {
            this.izs.setText(getString(2131232797));
        } else {
            this.izs.setText(getString(2131232796));
        }
        ak.yW();
        this.bhT = (String) c.vf().get(6, null);
        if (this.bhT == null || this.bhT.equals(SQLiteDatabase.KeyEmpty)) {
            ak.yW();
            this.bhT = (String) c.vf().get(4097, null);
        }
        this.ogg.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ FindMContactIntroUI ogi;

            {
                this.ogi = r1;
            }

            public final void onClick(View view) {
                FindMContactIntroUI.a(this.ogi);
            }
        });
        this.ogh.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ FindMContactIntroUI ogi;

            {
                this.ogi = r1;
            }

            public final void onClick(View view) {
                g.b(this.ogi, this.ogi.getString(2131232813), null, this.ogi.getString(2131232814), this.ogi.getString(2131232812), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 ogj;

                    {
                        this.ogj = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.ogj.ogi.aKM();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 ogj;

                    {
                        this.ogj = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
    }

    private void bDq() {
        v.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), be.bur());
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            n vy = ak.vy();
            e anonymousClass9 = new e(this) {
                final /* synthetic */ FindMContactIntroUI ogi;

                {
                    this.ogi = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    if (this.ogi.dwR != null) {
                        this.ogi.dwR.dismiss();
                        this.ogi.dwR = null;
                    }
                    if (this.ogi.daB != null) {
                        ak.vy().b(431, this.ogi.daB);
                        this.ogi.daB = null;
                    }
                    if (i == 0 && i2 == 0) {
                        int i3;
                        LinkedList Fx = ((aa) kVar).Fx();
                        ah.g(Fx);
                        int i4;
                        if (Fx == null || Fx.size() <= 0) {
                            i4 = 0;
                            i3 = 0;
                        } else {
                            Iterator it = Fx.iterator();
                            i3 = 0;
                            while (it.hasNext()) {
                                agl com_tencent_mm_protocal_c_agl = (agl) it.next();
                                if (com_tencent_mm_protocal_c_agl != null) {
                                    if (com_tencent_mm_protocal_c_agl.eeO == 1) {
                                        i4 = i3 + 1;
                                    } else {
                                        i4 = i3;
                                    }
                                    i3 = i4;
                                }
                            }
                            i4 = i3 > 0 ? 1 : 0;
                        }
                        String str2 = "MicroMsg.FindMContactIntroUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(Fx == null ? 0 : Fx.size());
                        objArr[1] = Integer.valueOf(i3);
                        v.d(str2, str3, objArr);
                        if (this.ogi.nKT == null || !this.ogi.nKT.contains("1") || r0 == 0) {
                            this.ogi.aKM();
                            return;
                        }
                        b.mi("R300_300_phone");
                        Intent intent = new Intent(this.ogi, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", this.ogi.cZU);
                        intent.putExtra("regsetinfo_NextStep", this.ogi.nKT);
                        intent.putExtra("regsetinfo_NextStyle", this.ogi.nKU);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.w(this.ogi, intent);
                        return;
                    }
                    Toast.makeText(this.ogi, this.ogi.getString(2131231042, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            };
            this.daB = anonymousClass9;
            vy.a(431, anonymousClass9);
            Context context = this.nDR.nEl;
            getString(2131231164);
            this.dwR = g.a(context, getString(2131236682), true, new OnCancelListener(this) {
                final /* synthetic */ FindMContactIntroUI ogi;

                {
                    this.ogi = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.ogi.daB != null) {
                        ak.vy().b(431, this.ogi.daB);
                        this.ogi.daB = null;
                    }
                }
            });
            ak.vA().a(new ad.a(this) {
                final /* synthetic */ FindMContactIntroUI ogi;

                {
                    this.ogi = r1;
                }

                public final boolean Ba() {
                    if (this.ogi.cHz == null || this.ogi.cHz.size() == 0) {
                        if (this.ogi.dwR != null) {
                            this.ogi.dwR.dismiss();
                            this.ogi.dwR = null;
                        }
                        this.ogi.aKM();
                    } else {
                        this.ogi.ofT = new aa(this.ogi.cZU, this.ogi.cHz);
                        ak.vy().a(this.ogi.ofT, 0);
                    }
                    return false;
                }

                public final boolean AZ() {
                    try {
                        this.ogi.cHz = com.tencent.mm.pluginsdk.a.cW(this.ogi);
                        v.d("MicroMsg.FindMContactIntroUI", "tigerreg mobileList size " + (this.ogi.cHz == null ? 0 : this.ogi.cHz.size()));
                    } catch (Throwable e) {
                        v.a("MicroMsg.FindMContactIntroUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
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

    protected final int getLayoutId() {
        return 2130903640;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.FindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    bDq();
                    return;
                } else {
                    g.a((Context) this, getString(2131234161), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ FindMContactIntroUI ogi;

                        {
                            this.ogi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.ogi.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ FindMContactIntroUI ogi;

                        {
                            this.ogi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
