package com.tencent.mm.ui.bindmobile;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAlertUI extends MMWizardActivity {
    private String bhT;
    private List<String[]> cHz = null;
    private String cZU = null;
    private e daB = null;
    private ProgressDialog dwR = null;
    private String ivg;
    private String nKT = SQLiteDatabase.KeyEmpty;
    private int nKU = 2;
    private String ofQ = null;
    private String ofR = null;
    private boolean ofS = false;
    private aa ofT;
    private String ofU;
    private String ofV;
    private int ofW = 0;
    private final int ofX = 200;
    private int ofY = 0;
    private int ofZ = 0;
    private int oga = 0;
    private int ogb = 0;
    private int ogc = 0;
    private int ogd = 0;

    static /* synthetic */ void a(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        findMContactAlertUI.ofY = i;
        findMContactAlertUI.ofZ = i2;
        if (findMContactAlertUI.oga > 0 && findMContactAlertUI.ogb > 0) {
            findMContactAlertUI.bDp();
        }
    }

    static /* synthetic */ void b(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        findMContactAlertUI.oga = i;
        findMContactAlertUI.ogb = i2;
        if (findMContactAlertUI.ofY > 0 && findMContactAlertUI.ofZ > 0) {
            findMContactAlertUI.bDp();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232816);
        a.drq.oz();
        this.cZU = getIntent().getStringExtra("regsetinfo_ticket");
        this.nKT = getIntent().getStringExtra("regsetinfo_NextStep");
        this.nKU = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.ofQ = getIntent().getStringExtra("alert_title");
        this.ofR = getIntent().getStringExtra("alert_message");
        this.ofS = m.EY() != m.a.SUCC;
        this.ivg = b.Oa();
        v.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", this.nKT, Integer.valueOf(this.nKU));
        if (!isFinishing()) {
            NI();
            bDo();
        }
    }

    public void onDestroy() {
        v.d("MicroMsg.FindMContactAlertUI", "ondestroy");
        if (this.daB != null) {
            ak.vy().b(431, this.daB);
            this.daB = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.ofS) {
            b.mh("R300_100_QQ");
            b.b(true, ak.uR() + "," + getClass().getName() + ",R300_100_QQ," + ak.dR("R300_100_QQ") + ",1");
            return;
        }
        b.mh("R300_100_phone");
        b.b(true, ak.uR() + "," + getClass().getName() + ",RE300_100," + ak.dR("RE300_100") + ",1");
    }

    protected void onPause() {
        super.onPause();
        if (this.ofS) {
            b.b(false, ak.uR() + "," + getClass().getName() + ",R300_100_QQ," + ak.dR("R300_100_QQ") + ",2");
        } else {
            b.b(false, ak.uR() + "," + getClass().getName() + ",RE300_100," + ak.dR("RE300_100") + ",2");
        }
    }

    protected final void NI() {
        this.ofU = getString(2131232800);
        this.ofV = getString(2131232799);
        if (!be.kS(this.ofQ)) {
            this.ofU = this.ofQ;
        }
        if (!be.kS(this.ofR)) {
            this.ofV = this.ofR;
        }
        ak.yW();
        this.bhT = (String) c.vf().get(6, null);
        if (this.bhT == null || this.bhT.equals(SQLiteDatabase.KeyEmpty)) {
            ak.yW();
            this.bhT = (String) c.vf().get(4097, null);
        }
    }

    private void bDo() {
        if (this.ofS) {
            b.mj(ak.uR() + "," + getClass().getName() + ",R300_200_phone," + ak.dR("R300_200_phone") + ",1");
            g.a((Context) this, false, getString(2131232799), getString(2131231164), getString(2131231107), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI oge;

                {
                    this.oge = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.yW();
                    c.vf().set(12322, Boolean.valueOf(true));
                    b.mi("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", this.oge.cZU);
                    intent.putExtra("regsetinfo_NextStep", this.oge.nKT);
                    intent.putExtra("regsetinfo_NextStyle", this.oge.nKU);
                    a.drp.a(this.oge, intent);
                    b.mi("R300_300_phone");
                    b.b(false, ak.uR() + "," + this.oge.getClass().getName() + ",R300_200_phone," + ak.dR("R300_200_phone") + ",2");
                }
            }, new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI oge;

                {
                    this.oge = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.yW();
                    c.vf().set(12322, Boolean.valueOf(false));
                    b.mj(ak.uR() + "," + this.oge.getClass().getName() + ",R300_200_phone," + ak.dR("R300_200_phone") + ",2");
                    this.oge.aKM();
                }
            });
        } else if (m.EX()) {
            CharSequence charSequence = this.ofV;
            CharSequence charSequence2 = this.ofU;
            OnClickListener anonymousClass5 = new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI oge;

                {
                    this.oge = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ak.yW();
                    c.vf().set(12322, Boolean.valueOf(true));
                    this.oge.bDq();
                    dialogInterface.dismiss();
                }
            };
            OnClickListener anonymousClass6 = new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI oge;

                {
                    this.oge = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(this.oge, FindMContactLearmMoreUI.class);
                    intent.putExtra("regsetinfo_ticket", this.oge.cZU);
                    intent.putExtra("regsetinfo_NextStep", this.oge.nKT);
                    intent.putExtra("regsetinfo_NextStyle", this.oge.nKU);
                    MMWizardActivity.w(this.oge, intent);
                }
            };
            final Dialog hVar = new h(this);
            hVar.setTitle(charSequence2);
            hVar.setMessage(charSequence);
            hVar.a(2131232823, anonymousClass5);
            hVar.b(hVar.mContext.getString(2131232818), true, anonymousClass6);
            hVar.kUN.setVisibility(0);
            hVar.setCancelable(false);
            hVar.show();
            hVar.getWindow().clearFlags(2);
            a(hVar);
            hVar.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ FindMContactAlertUI oge;

                public final void onGlobalLayout() {
                    int measuredWidth;
                    hVar.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredWidth2 = hVar.getWindow().getDecorView().getMeasuredWidth();
                    int measuredHeight = hVar.getWindow().getDecorView().getMeasuredHeight();
                    View a = this.oge.g((ViewGroup) hVar.getWindow().getDecorView());
                    if (a != null) {
                        measuredWidth = a.getMeasuredWidth() * 2;
                    } else {
                        measuredWidth = measuredWidth2;
                    }
                    v.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                    FindMContactAlertUI.a(this.oge, measuredWidth, measuredHeight);
                }
            });
            final View findViewById = findViewById(2131757037);
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ FindMContactAlertUI oge;

                public final void onGlobalLayout() {
                    findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredHeight = findViewById.getMeasuredHeight();
                    v.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", Integer.valueOf(findViewById.getMeasuredWidth()), Integer.valueOf(measuredHeight));
                    FindMContactAlertUI.b(this.oge, r1, measuredHeight);
                }
            });
        } else {
            bDq();
        }
    }

    private View g(ViewGroup viewGroup) {
        if (this.ofW >= 200) {
            return null;
        }
        this.ofW++;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Button) {
                return childAt;
            }
            if (childAt instanceof ViewGroup) {
                childAt = g((ViewGroup) childAt);
                if (childAt != null) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private void bDp() {
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = this.oga - (getResources().getDimensionPixelSize(2131493172) + com.tencent.mm.bd.a.fromDPToPix(this, 48));
        int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this, 20) + (((height / 2) + (this.ofZ / 2)) - (height - this.ogb));
        if (dimensionPixelSize != this.ogc || fromDPToPix != this.ogd) {
            this.ogc = dimensionPixelSize;
            this.ogd = fromDPToPix;
            View findViewById = findViewById(2131757040);
            findViewById.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.setMargins(dimensionPixelSize - (findViewById.getMeasuredWidth() / 2), fromDPToPix, 0, 0);
            v.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", Integer.valueOf(dimensionPixelSize), Integer.valueOf(fromDPToPix), Integer.valueOf(findViewById.getMeasuredWidth()));
            findViewById.setLayoutParams(layoutParams);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this, 2130968592));
        }
    }

    private void bDq() {
        v.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), be.bur());
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            View findViewById = findViewById(2131757040);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            n vy = ak.vy();
            e anonymousClass9 = new e(this) {
                final /* synthetic */ FindMContactAlertUI oge;

                {
                    this.oge = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    if (this.oge.dwR != null) {
                        this.oge.dwR.dismiss();
                        this.oge.dwR = null;
                    }
                    if (this.oge.daB != null) {
                        ak.vy().b(431, this.oge.daB);
                        this.oge.daB = null;
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
                        String str2 = "MicroMsg.FindMContactAlertUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(Fx == null ? 0 : Fx.size());
                        objArr[1] = Integer.valueOf(i3);
                        v.d(str2, str3, objArr);
                        if (this.oge.nKT == null || !this.oge.nKT.contains("1") || r0 == 0) {
                            this.oge.aKM();
                            return;
                        }
                        b.mi("R300_300_phone");
                        Intent intent = new Intent(this.oge, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", this.oge.cZU);
                        intent.putExtra("regsetinfo_NextStep", this.oge.nKT);
                        intent.putExtra("regsetinfo_NextStyle", this.oge.nKU);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.w(this.oge, intent);
                        return;
                    }
                    Toast.makeText(this.oge, this.oge.getString(2131231042, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    this.oge.aKM();
                }
            };
            this.daB = anonymousClass9;
            vy.a(431, anonymousClass9);
            Context context = this.nDR.nEl;
            getString(2131231164);
            this.dwR = g.a(context, getString(2131236682), true, new OnCancelListener(this) {
                final /* synthetic */ FindMContactAlertUI oge;

                {
                    this.oge = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.oge.daB != null) {
                        ak.vy().b(431, this.oge.daB);
                        this.oge.daB = null;
                        this.oge.bDo();
                    }
                }
            });
            ak.vA().a(new ad.a(this) {
                final /* synthetic */ FindMContactAlertUI oge;

                {
                    this.oge = r1;
                }

                public final boolean Ba() {
                    if (this.oge.cHz == null || this.oge.cHz.size() == 0) {
                        if (this.oge.dwR != null) {
                            this.oge.dwR.dismiss();
                            this.oge.dwR = null;
                        }
                        this.oge.aKM();
                    } else {
                        this.oge.ofT = new aa(this.oge.cZU, this.oge.cHz);
                        ak.vy().a(this.oge.ofT, 0);
                    }
                    return false;
                }

                public final boolean AZ() {
                    try {
                        this.oge.cHz = com.tencent.mm.pluginsdk.a.cW(this.oge);
                        v.d("MicroMsg.FindMContactAlertUI", "tigerreg mobileList size " + (this.oge.cHz == null ? 0 : this.oge.cHz.size()));
                    } catch (Throwable e) {
                        v.a("MicroMsg.FindMContactAlertUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
            l.g(true, false);
            com.tencent.mm.modelfriend.a.Ew();
            com.tencent.mm.plugin.report.service.g.iuh.h(11438, Integer.valueOf(1));
            v.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(1));
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
        return 2130903642;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.FindMContactAlertUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    bDq();
                    return;
                } else {
                    g.a((Context) this, getString(2131234161), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ FindMContactAlertUI oge;

                        {
                            this.oge = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.oge.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ FindMContactAlertUI oge;

                        {
                            this.oge = r1;
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
