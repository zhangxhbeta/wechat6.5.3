package com.tencent.mm.plugin.shake.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.e.a.cr;
import com.tencent.mm.e.a.cs;
import com.tencent.mm.e.a.cy;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.j;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.k.1;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShakeReportUI extends MMActivity implements af, com.tencent.mm.platformtools.j.a, com.tencent.mm.plugin.shake.b.j.a, com.tencent.mm.plugin.shake.c.a.f.a, com.tencent.mm.sdk.h.g.a, b {
    private static List<com.tencent.mm.plugin.shake.d.a.h.a> bYj = new CopyOnWriteArrayList();
    private c bYe;
    private boolean bYh = false;
    private Map<String, com.tencent.mm.plugin.shake.d.a.h.a> bYi = new ConcurrentHashMap();
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ ShakeReportUI iSG;

        {
            this.iSG = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (z) {
                v.d("MicroMsg.ShakeReportUI", "on location get ok");
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.npv, String.valueOf(f2));
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.npw, String.valueOf(f));
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrG, String.valueOf(d2));
                this.iSG.bYh = true;
                if (this.iSG.bYe != null) {
                    this.iSG.bYe.c(this.iSG.bYl);
                }
            } else {
                v.w("MicroMsg.ShakeReportUI", "getLocation fail");
            }
            return false;
        }
    };
    private com.tencent.mm.ae.a.a cOz = null;
    private ImageView dtz;
    private com.tencent.mm.pluginsdk.n.c hEt;
    private j iRA = new j();
    private f iRB;
    private View iRC;
    private View iRD;
    private TextView iRE;
    private TextView iRF;
    private TextView iRG;
    private View iRH;
    private View iRI;
    private View iRJ;
    private View iRK;
    private Animation iRL;
    private Animation iRM;
    private Animation iRN;
    private Animation iRO;
    private View iRP = null;
    private View iRQ = null;
    private MMImageView iRR = null;
    private TextView iRS = null;
    private ImageView iRT = null;
    private String iRU = "";
    private Bitmap iRV = null;
    private Dialog iRW;
    private ImageView iRX = null;
    private d iRY = null;
    private ImageView iRZ;
    private boolean iRr = false;
    private boolean iRs = false;
    private boolean iRt;
    private boolean iRu = false;
    private boolean iRv = false;
    private boolean iRw = false;
    private boolean iRx = false;
    private int iRy = 22;
    private c iRz;
    private int iSA = 1;
    private long iSB = 0;
    private boolean iSC = false;
    private com.tencent.mm.sdk.c.c iSD = new com.tencent.mm.sdk.c.c<cs>(this) {
        final /* synthetic */ ShakeReportUI iSG;

        {
            this.iSG = r2;
            this.nhz = cs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            cs csVar = (cs) bVar;
            String str = csVar.baG.baE;
            int i = csVar.baG.baH;
            int i2 = csVar.baG.baI;
            String str2 = csVar.baG.baL;
            double d = csVar.baG.baK;
            int i3 = csVar.baG.baM;
            if (!this.iSG.bYi.containsKey(str + "," + i + "," + i2)) {
                com.tencent.mm.plugin.shake.d.a.h.a aVar = new com.tencent.mm.plugin.shake.d.a.h.a();
                aVar.gjT = str;
                aVar.cXH = csVar.baG.baJ;
                aVar.major = i;
                aVar.minor = i2;
                aVar.iQn = str2;
                aVar.iQo = d;
                aVar.iQp = i3;
                this.iSG.bYi.put(str + "," + i + "," + i2, aVar);
                if (csVar.baG.baJ >= 0.0d && ShakeReportUI.bYj.size() > 0) {
                    i3 = 0;
                    while (i3 < ShakeReportUI.bYj.size()) {
                        com.tencent.mm.plugin.shake.d.a.h.a aVar2 = (com.tencent.mm.plugin.shake.d.a.h.a) ShakeReportUI.bYj.get(i3);
                        if (csVar.baG.baJ >= aVar2.cXH) {
                            if (i3 == ShakeReportUI.bYj.size() - 1 && csVar.baG.baJ > aVar2.cXH) {
                                ShakeReportUI.bYj.add(aVar);
                                break;
                            }
                            i3++;
                        } else {
                            ShakeReportUI.bYj.add(i3, aVar);
                            break;
                        }
                    }
                }
                ShakeReportUI.bYj.add(aVar);
                if (this.iSG.bYi.size() == 1 && !this.iSG.iSC) {
                    this.iSG.iSB = System.currentTimeMillis() - this.iSG.iSB;
                    g.iuh.h(11497, new Object[]{String.valueOf((int) (((double) (this.iSG.iSB / 1000)) + 0.5d)), Integer.valueOf(0), Integer.valueOf((int) this.iSG.iSB)});
                    this.iSG.iSB = 0;
                    this.iSG.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass24 iSK;

                        {
                            this.iSK = r1;
                        }

                        public final void run() {
                            ShakeReportUI.h(this.iSK.iSG);
                        }
                    });
                }
            }
            v.i("MicroMsg.ShakeReportUI", "result iBeacon = %s,beaconMap.size:%d", new Object[]{str + "," + i + "," + i2, Integer.valueOf(this.iSG.bYi.size())});
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c iSE = new com.tencent.mm.sdk.c.c<cy>(this) {
        final /* synthetic */ ShakeReportUI iSG;

        {
            this.iSG = r2;
            this.nhz = cy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            cy cyVar = (cy) bVar;
            v.d("MicroMsg.ShakeReportUI", "ExDeviceOnBluetoothStateChangeEvent = %s", new Object[]{Integer.valueOf(cyVar.baW.baX)});
            boolean hasSystemFeature = this.iSG.nDR.nEl.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            if (cyVar.baW.baX == 10 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
                this.iSG.aOy();
            } else if (cyVar.baW.baX == 12) {
                if (VERSION.SDK_INT < 18 || !hasSystemFeature) {
                    this.iSG.iSA = 1;
                } else {
                    this.iSG.aOx();
                    this.iSG.iSA = 0;
                }
                bf zO = bf.zO();
                String ma = be.ma(zO.cvf);
                String ma2 = be.ma(zO.cve);
                int i = hasSystemFeature ? 1 : 0;
                if (this.iSG.iSx) {
                    g.iuh.h(13139, new Object[]{ma, ma2, Integer.valueOf(1), Integer.valueOf(this.iSG.iSA), Integer.valueOf(1), Integer.valueOf(i)});
                } else {
                    g.iuh.h(13139, new Object[]{ma, ma2, Integer.valueOf(0), Integer.valueOf(this.iSG.iSA), Integer.valueOf(1), Integer.valueOf(i)});
                }
                if (this.iSG.iSy && this.iSG.iSx && !this.iSG.iSC && this.iSG.iSh < 4) {
                    this.iSG.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass25 iSL;

                        {
                            this.iSL = r1;
                        }

                        public final void run() {
                            ShakeReportUI.h(this.iSL.iSG);
                        }
                    });
                }
            }
            return false;
        }
    };
    private OnClickListener iSF = new OnClickListener(this) {
        public long iQW = 0;
        final /* synthetic */ ShakeReportUI iSG;

        {
            this.iSG = r3;
        }

        public final void onClick(View view) {
            if (!be.kS((String) this.iSG.iRC.getTag()) && this.iSG.iRY != null) {
                d L = this.iSG.iRY;
                String str = L.field_username;
                Intent intent;
                if (11 != L.field_type) {
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(str);
                    if (com.tencent.mm.i.a.ei(LX.field_type)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("Sns_from_Scene", 22);
                        if (str != null && str.length() > 0) {
                            if (LX.bvm()) {
                                g.iuh.Y(10298, str + "," + this.iSG.iRy);
                                intent2.putExtra("Contact_Scene", this.iSG.iRy);
                            }
                            com.tencent.mm.plugin.shake.a.drp.d(intent2, this.iSG);
                            return;
                        }
                        return;
                    }
                    if ((L.field_reserved1 & 8) > 0) {
                        g.iuh.Y(10298, L.field_username + "," + this.iSG.iRy);
                    }
                    intent = new Intent();
                    intent.putExtra("Contact_User", L.field_username);
                    intent.putExtra("Contact_Nick", L.field_nickname);
                    intent.putExtra("Contact_Distance", L.field_distance);
                    intent.putExtra("Contact_Signature", L.field_signature);
                    intent.putExtra("Contact_Province", L.getProvince());
                    intent.putExtra("Contact_City", L.getCity());
                    intent.putExtra("Contact_Sex", L.field_sex);
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Contact_VUser_Info", L.field_reserved3);
                    intent.putExtra("Contact_VUser_Info_Flag", L.field_reserved1);
                    intent.putExtra("Contact_KSnsIFlag", L.field_snsFlag);
                    intent.putExtra("Contact_KSnsBgUrl", L.field_sns_bgurl);
                    intent.putExtra("Contact_Scene", this.iSG.iRy);
                    intent.putExtra("Sns_from_Scene", 22);
                    com.tencent.mm.plugin.shake.a.drp.d(intent, this.iSG);
                } else if (System.currentTimeMillis() - this.iQW > 3000) {
                    this.iQW = System.currentTimeMillis();
                    intent = new Intent();
                    intent.putExtra("rawUrl", L.getCity());
                    intent.putExtra("scene", 27);
                    intent.putExtra("stastic_scene", 5);
                    com.tencent.mm.ay.c.b(aa.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    j.b bVar = this.iSG.iRA.iOm;
                    if (bVar != null && (bVar instanceof h)) {
                        h.a(L);
                        h.b(L);
                    }
                }
            }
        }
    };
    private ImageView iSa;
    private ImageView iSb;
    private ImageView iSc;
    private ImageView iSd;
    private ImageView iSe;
    private TextView iSf;
    private int iSg = 1;
    private int iSh = 0;
    private View iSi;
    private ImageView iSj;
    private ImageView iSk;
    private ImageView iSl;
    private ImageView iSm;
    private View iSn;
    private View iSo;
    private View iSp;
    private View iSq;
    private View iSr = null;
    private int iSs = 0;
    private com.tencent.mm.plugin.shake.c.b.a iSt;
    private boolean iSu = false;
    @SuppressLint({"UseSparseArrays"})
    private Map<Integer, Boolean> iSv = new HashMap();
    private boolean iSw = false;
    private boolean iSx = false;
    private boolean iSy = false;
    private boolean iSz = false;
    private boolean ijq = true;

    static class a extends com.tencent.mm.pluginsdk.n.c.a {
        private final long[] drm = new long[]{300, 200, 300, 200};
        private long evy = be.Nj();
        private Vibrator ewK;
        WeakReference<ShakeReportUI> iSM;

        public a(ShakeReportUI shakeReportUI) {
            this.iSM = new WeakReference(shakeReportUI);
        }

        public final void aDu() {
            ShakeReportUI shakeReportUI = (ShakeReportUI) this.iSM.get();
            if (shakeReportUI != null) {
                if (shakeReportUI.isFinishing()) {
                    v.e("MicroMsg.ShakeReportUI", "ui finished");
                } else if (shakeReportUI.iRw) {
                    shakeReportUI.aOE();
                    long az = be.az(this.evy);
                    if (az < 1200) {
                        v.i("MicroMsg.ShakeReportUI", "tryStartShake delay too short:" + az);
                        return;
                    }
                    v.w("MicroMsg.ShakeReportUI", "tryStartShake delaytoo enough:" + az);
                    this.evy = be.Nj();
                    if (shakeReportUI.iRz != null) {
                        c w = shakeReportUI.iRz;
                        if (w.view != null) {
                            w.view.setKeepScreenOn(true);
                        }
                        w.aSW.ea(30000);
                    }
                    if (shakeReportUI.iRB != null) {
                        f q = shakeReportUI.iRB;
                        if (q.hha != null) {
                            q.hha.dismiss();
                        }
                    }
                    ShakeReportUI shakeReportUI2;
                    if (shakeReportUI.iRt) {
                        shakeReportUI2 = (ShakeReportUI) this.iSM.get();
                        if (shakeReportUI2 != null) {
                            ao.T(shakeReportUI2, 2131235284);
                        }
                    } else {
                        shakeReportUI2 = (ShakeReportUI) this.iSM.get();
                        if (shakeReportUI2 != null) {
                            if (this.ewK == null) {
                                this.ewK = (Vibrator) shakeReportUI2.getSystemService("vibrator");
                            }
                            if (this.ewK != null) {
                                this.ewK.vibrate(this.drm, -1);
                            }
                        }
                    }
                    com.tencent.mm.pluginsdk.n.c.a.reset();
                    ShakeReportUI.y(shakeReportUI);
                } else {
                    v.i("MicroMsg.ShakeReportUI", "tryShake the status is can's shake");
                }
            }
        }

        public final void onRelease() {
        }
    }

    static /* synthetic */ void h(ShakeReportUI shakeReportUI) {
        if (aOJ()) {
            ViewGroup viewGroup = (ViewGroup) shakeReportUI.findViewById(2131759153);
            if (viewGroup != null) {
                int i;
                int childCount = viewGroup.getChildCount();
                List arrayList = new ArrayList();
                int i2 = 0;
                for (i = 0; i < childCount; i++) {
                    if (viewGroup.getChildAt(i).getVisibility() == 0) {
                        i2++;
                        arrayList.add(viewGroup.getChildAt(i));
                    }
                }
                int width;
                Animation animationSet;
                Animation alphaAnimation;
                Animation translateAnimation;
                View view;
                if (!shakeReportUI.iSw && (shakeReportUI.iSx || shakeReportUI.iSz)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    animationSet = new AnimationSet(false);
                    alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(600);
                    translateAnimation = new TranslateAnimation((float) viewGroup.getWidth(), (float) (viewGroup.getWidth() - childCount), 0.0f, 0.0f);
                    animationSet.addAnimation(alphaAnimation);
                    translateAnimation.setDuration(600);
                    animationSet.addAnimation(translateAnimation);
                    shakeReportUI.findViewById(2131759167).setAnimation(animationSet);
                    if (i2 < 4) {
                        for (i = 0; i < i2; i++) {
                            view = (View) arrayList.get(i);
                            translateAnimation = new TranslateAnimation((float) (((i * width) + (width / 2)) - ((i * childCount) + (childCount / 2))), 0.0f, 0.0f, 0.0f);
                            translateAnimation.setDuration(600);
                            view.setAnimation(translateAnimation);
                        }
                    }
                } else if (!(shakeReportUI.iSw || shakeReportUI.iSx || shakeReportUI.iSz)) {
                    childCount = viewGroup.getWidth() / (i2 + 1);
                    width = viewGroup.getWidth() / i2;
                    Animation animationSet2 = new AnimationSet(false);
                    animationSet = new AlphaAnimation(0.0f, 1.0f);
                    animationSet.setDuration(1200);
                    alphaAnimation = new TranslateAnimation((float) ((-childCount) / 2), 0.0f, 0.0f, 0.0f);
                    animationSet2.addAnimation(animationSet);
                    alphaAnimation.setDuration(600);
                    animationSet2.addAnimation(alphaAnimation);
                    shakeReportUI.findViewById(2131759154).setAnimation(animationSet2);
                    for (i = 1; i < i2 + 1; i++) {
                        view = (View) arrayList.get(i - 1);
                        translateAnimation = new TranslateAnimation((float) (-(((i * childCount) + (childCount / 2)) - (((i - 1) * width) + (width / 2)))), 0.0f, 0.0f, 0.0f);
                        translateAnimation.setDuration(600);
                        view.setAnimation(translateAnimation);
                    }
                }
                shakeReportUI.iSw = true;
                shakeReportUI.iSg = 5;
                shakeReportUI.iSC = true;
                shakeReportUI.aOH();
                shakeReportUI.aOA();
                shakeReportUI.fu(false);
            }
        }
    }

    static /* synthetic */ void y(ShakeReportUI shakeReportUI) {
        if (shakeReportUI.iRH == null) {
            shakeReportUI.iRH = shakeReportUI.findViewById(2131759136);
        }
        if (shakeReportUI.iRI == null) {
            shakeReportUI.iRI = shakeReportUI.findViewById(2131759139);
        }
        if (shakeReportUI.iRJ == null) {
            shakeReportUI.iRJ = shakeReportUI.findViewById(2131759145);
        }
        if (shakeReportUI.iRK == null) {
            shakeReportUI.iRK = shakeReportUI.findViewById(2131759138);
        }
        if (shakeReportUI.iRL == null) {
            shakeReportUI.iRL = AnimationUtils.loadAnimation(shakeReportUI.nDR.nEl, 2130968693);
            shakeReportUI.iRL.setAnimationListener(new AnimationListener(shakeReportUI) {
                final /* synthetic */ ShakeReportUI iSG;

                {
                    this.iSG = r1;
                }

                public final void onAnimationStart(Animation animation) {
                    this.iSG.iRr = false;
                    this.iSG.iRs = true;
                    this.iSG.ft(false);
                    this.iSG.iRv = true;
                    this.iSG.fx(true);
                }

                public final void onAnimationEnd(Animation animation) {
                    this.iSG.ft(true);
                    this.iSG.iRv = false;
                    if (!this.iSG.iRr) {
                        this.iSG.iRu = true;
                        this.iSG.fw(true);
                        this.iSG.aOA();
                        if (this.iSG.iRA.iOl == 3) {
                            com.tencent.mm.ai.b.HB();
                        } else if (this.iSG.iRA.iOl == 5) {
                            j.b bVar = this.iSG.iRA.iOm;
                            if (bVar != null && (bVar instanceof h)) {
                                h hVar = (h) bVar;
                                Collection arrayList = new ArrayList();
                                arrayList.addAll(ShakeReportUI.bYj);
                                hVar.iQh = arrayList;
                            }
                        }
                        this.iSG.iRA.iOm.start();
                    }
                    this.iSG.iRs = false;
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (shakeReportUI.iRM == null) {
            shakeReportUI.iRM = AnimationUtils.loadAnimation(shakeReportUI.nDR.nEl, 2130968691);
        }
        if (shakeReportUI.iRN == null) {
            shakeReportUI.iRN = AnimationUtils.loadAnimation(shakeReportUI.nDR.nEl, 2130968662);
        }
        if (!(shakeReportUI.iRO == null || shakeReportUI.iRF == null)) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a.c(shakeReportUI.iRF, shakeReportUI.iRO);
        }
        shakeReportUI.pu(3);
        shakeReportUI.iRJ.startAnimation(shakeReportUI.iRN);
        shakeReportUI.iRK.startAnimation(shakeReportUI.iRN);
        shakeReportUI.iRJ.setVisibility(0);
        shakeReportUI.iRK.setVisibility(0);
        shakeReportUI.iRE.setVisibility(4);
        shakeReportUI.iRH.startAnimation(shakeReportUI.iRL);
        shakeReportUI.iRI.startAnimation(shakeReportUI.iRM);
        if (shakeReportUI.iRC != null && shakeReportUI.iRC.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(shakeReportUI.nDR.nEl, 2130968666);
            loadAnimation.setFillAfter(true);
            shakeReportUI.iRC.startAnimation(loadAnimation);
            new ac().postDelayed(new Runnable(shakeReportUI) {
                final /* synthetic */ ShakeReportUI iSG;

                {
                    this.iSG = r1;
                }

                public final void run() {
                    if (this.iSG.iRC != null) {
                        this.iSG.iRC.setVisibility(8);
                    }
                }
            }, loadAnimation.getDuration());
        }
        shakeReportUI.iRx = false;
        new ac().postDelayed(new Runnable(shakeReportUI) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void run() {
                if (this.iSG.iRJ != null) {
                    this.iSG.iRJ.setVisibility(8);
                }
                if (this.iSG.iRK != null) {
                    this.iSG.iRK.setVisibility(8);
                }
                if (this.iSG.iRE != null) {
                    this.iSG.iRE.setVisibility(0);
                }
                if (!this.iSG.iRx && !this.iSG.iRr) {
                    this.iSG.pu(1);
                }
            }
        }, 1200);
    }

    protected final int getLayoutId() {
        return 2130904373;
    }

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        super.onCreate(bundle);
        vD(2131235271);
        this.bYe = c.FY();
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.npv, "");
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.npw, "");
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrG, "");
        this.iSr = findViewById(2131759154);
        bf zO = bf.zO();
        String ma = be.ma(zO.cvf);
        String ma2 = be.ma(zO.cve);
        String z = com.tencent.mm.h.j.sV().z("IBeacon", "GatedLaunch");
        if (be.kS(z)) {
            z = null;
        }
        this.iSx = false;
        this.iSy = false;
        if (z != null) {
            try {
                JSONObject jSONObject = new JSONObject(z);
                i = jSONObject.getInt("gatedlaunch");
                ak.uz();
                if (i != 0) {
                    JSONArray jSONArray;
                    int length;
                    String string;
                    int i3;
                    JSONArray jSONArray2;
                    if (i == 1) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(ma) && i3 == 1) {
                                this.iSx = true;
                            } else if (string.equals(ma) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(ma2)) {
                                        this.iSx = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 2) {
                        jSONArray = jSONObject.getJSONArray("citylist");
                        length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("province");
                            i3 = jSONObject.getInt("allgatedlaunch");
                            if (string.equals(ma) && i3 == 1) {
                                this.iSy = true;
                                this.iSx = true;
                            } else if (string.equals(ma) && i3 == 0) {
                                jSONArray2 = jSONObject.getJSONArray("cities");
                                i3 = jSONArray2.length();
                                for (i2 = 0; i2 < i3; i2++) {
                                    if (jSONArray2.getString(i2).equals(ma2)) {
                                        this.iSy = true;
                                        this.iSx = true;
                                    }
                                }
                            }
                        }
                    } else if (i == 3) {
                        this.iSx = true;
                        this.iSy = false;
                    } else if (i == 4) {
                        this.iSx = true;
                        this.iSy = true;
                    }
                }
            } catch (JSONException e) {
                v.e("MicroMsg.ShakeReportUI", "[shakezb]parse dymanic setting json fail!!");
                this.iSx = false;
                this.iSy = false;
            }
        }
        if (ak.uz()) {
            ak.yW();
            if (((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nry, Integer.valueOf(0))).intValue() == 1) {
                this.iSz = true;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean hasSystemFeature = aa.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter == null || !hasSystemFeature || VERSION.SDK_INT < 18 || defaultAdapter.getState() != 12) {
            this.iSA = 1;
        } else {
            this.iSA = 0;
        }
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (hasSystemFeature) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.iSx) {
            g.iuh.h(13139, new Object[]{ma, ma2, Integer.valueOf(1), Integer.valueOf(this.iSA), Integer.valueOf(i2), Integer.valueOf(i)});
        } else {
            g.iuh.h(13139, new Object[]{ma, ma2, Integer.valueOf(0), Integer.valueOf(this.iSA), Integer.valueOf(i2), Integer.valueOf(i)});
        }
        if (this.iSz || this.iSx) {
            this.iSw = true;
            this.iSr = findViewById(2131759167);
            if (this.iSy) {
                if (defaultAdapter == null || defaultAdapter.getState() != 12) {
                    this.iSw = false;
                } else if (defaultAdapter != null) {
                    defaultAdapter.getState();
                }
            }
        }
        com.tencent.mm.plugin.shake.c.a.f aNT = k.aNT();
        if (aNT.eAR == null) {
            aNT.eAR = new ArrayList();
        }
        if (this != null) {
            aNT.eAR.add(new WeakReference(this));
        }
        Boolean valueOf = Boolean.valueOf(false);
        long Nh = be.Nh();
        long j = 0;
        long j2 = 0;
        if (ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrv, Boolean.valueOf(true));
            ak.yW();
            Boolean valueOf2 = Boolean.valueOf(be.a((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nrt, null), false));
            ak.yW();
            j = be.a((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nru, null), 0);
            ak.yW();
            j2 = be.a((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nro, null), 0);
            valueOf = valueOf2;
        }
        if (!valueOf.booleanValue() || Nh - r6 >= r4) {
            NI();
        } else {
            this.iSg = 5;
            this.iSw = true;
            this.iRu = true;
            NI();
            aOA();
            ak.yW();
            String ah = be.ah((String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nrs, null), "");
            ak.yW();
            z = be.ah((String) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nrr, null), "");
            if (!(z == null || z.equals(""))) {
                String[] split = z.split(",");
                d dVar = new d();
                dVar.field_type = 11;
                dVar.field_username = split[0];
                dVar.field_nickname = split[0];
                dVar.field_signature = split[1];
                dVar.field_province = split[2];
                dVar.field_city = split[3];
                dVar.field_sex = 1;
                try {
                    dVar.field_lvbuffer = (String.valueOf(split[4]) + "," + String.valueOf(split[5]) + "," + String.valueOf(split[6])).getBytes("utf-8");
                } catch (UnsupportedEncodingException e2) {
                    v.e("MicroMsg.ShakeReportUI", "[kevinkma]parst shakeItem error!");
                }
                dVar.field_insertBatch = 2;
                e aNO = k.aNO();
                aNO.aNG();
                aNO.a(dVar, true);
                List linkedList = new LinkedList();
                linkedList.add(dVar);
                d(linkedList, 1);
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrr, "");
                z = ah + "," + split[4] + split[5] + split[6];
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrs, z);
            }
        }
        this.iRz = new c(this.nDR.nDX);
        this.hEt = new com.tencent.mm.pluginsdk.n.c(this);
        if (!this.hEt.bou()) {
            com.tencent.mm.ui.base.g.a(this, 2131235264, 2131231164, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ShakeReportUI iSG;

                {
                    this.iSG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.iSG.finish();
                }
            });
        }
        if (com.tencent.mm.plugin.shake.a.drq != null) {
            com.tencent.mm.plugin.shake.a.drq.ow();
        }
        com.tencent.mm.platformtools.j.b(this);
        v.i("MicroMsg.ShakeReportUI", "%s", new Object[]{getResources().getDisplayMetrics().toString()});
        i = k.aNP().Kw();
        g.iuh.h(11317, new Object[]{Integer.valueOf(i), e.aOL()});
        g.iuh.h(11710, new Object[]{Integer.valueOf(1)});
    }

    protected void onResume() {
        super.onResume();
        if (this.ijq) {
            v.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkposition[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")), be.bur(), this});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                aIP();
            }
        }
    }

    private void aIP() {
        aOz();
        ak.yW();
        com.tencent.mm.model.c.a(this);
        ak.yW();
        com.tencent.mm.model.c.vf().a(this);
        k.aNO().c(this);
        if (this.iRA.iOm != null) {
            this.iRA.iOm.resume();
        }
        this.iRw = true;
        if (!(this.iSt == null || !this.iSt.isShowing() || this.iSt.iPu)) {
            this.iRw = false;
        }
        v.i("MicroMsg.ShakeReportUI", "tryStartShake");
        if (!(this.hEt == null || this.hEt.bos())) {
            this.hEt.a(new a(this));
            if (!this.hEt.bou() || this.iRE == null) {
                this.iRE.setText(getString(2131235264));
            } else {
                this.iRE.setText(getString(2131235213));
            }
        }
        new ac().postDelayed(new Runnable(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void run() {
                if (this.iSG.hEt != null) {
                    this.iSG.hEt.bot();
                }
            }
        }, 1000);
        if (this.hEt != null) {
            this.hEt.bot();
        }
        fv(false);
        fw(false);
        aOB();
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(327696, "1");
        if (com.tencent.mm.plugin.shake.d.a.k.aNM()) {
            if (this.iSg == 4) {
                fs(true);
            }
            if (str.equals("4")) {
                bY(findViewById(2131759165));
            }
        }
        if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
            bY(findViewById(2131759162));
        } else if (str.equals("6") && com.tencent.mm.plugin.shake.c.c.a.aOn()) {
            bY(findViewById(2131759156));
        }
        boolean ay = com.tencent.mm.p.c.us().ay(262154, 266258);
        if (getIntent().getBooleanExtra("shake_music", false) && com.tencent.mm.ai.c.HG() && this.iRA.iOl != 3) {
            getIntent().putExtra("shake_music", false);
            this.iSg = 3;
        } else if (getIntent().getBooleanExtra("shake_tv", false) && this.iRA.iOl != 4 && com.tencent.mm.plugin.shake.d.a.k.aNM()) {
            getIntent().putExtra("shake_tv", false);
            this.iSg = 4;
        } else if (this.iRA.iOl != 6 && com.tencent.mm.plugin.shake.c.c.a.aOn() && (ay || getIntent().getBooleanExtra("shake_card", false))) {
            this.iSs = getIntent().getIntExtra("shake_card", 0);
            getIntent().putExtra("shake_card", false);
            v.i("MicroMsg.ShakeReportUI", "onresume shake card tab is open, activity type is 0 or open from specialview");
            this.iSg = 6;
        }
        aOA();
        ft(true);
        v.d("MicroMsg.ShakeReportUI", "isShakeGetConfigList = %s", new Object[]{Boolean.valueOf(q.dpZ)});
        if (q.dpZ) {
            ak.vy().a(new com.tencent.mm.al.k(7), 0);
        }
        fx(true);
        aOH();
        aOx();
    }

    protected void onPause() {
        ak.yW();
        com.tencent.mm.model.c.b(this);
        ak.yW();
        com.tencent.mm.model.c.vf().b(this);
        k.aNO().d(this);
        if (this.iRA.iOm != null) {
            this.iRA.iOm.pause();
        }
        this.iRw = false;
        if (this.hEt != null) {
            this.hEt.arf();
        }
        this.iRz.aOv();
        if (this.iSg != 5) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(327696, this.iSg);
        }
        if (this.iSg == 4) {
            fs(false);
        }
        aOy();
        super.onPause();
    }

    protected void onDestroy() {
        if (!(this.iRV == null || this.iRV.isRecycled())) {
            this.iRV.recycle();
        }
        if (this.iRW != null && this.iRW.isShowing()) {
            this.iRW.dismiss();
            this.iRW = null;
        }
        if (this.iRA.iOm != null) {
            this.iRA.iOm.aNB();
        }
        if (this.hEt != null) {
            this.hEt.arf();
            this.hEt = null;
        }
        com.tencent.mm.plugin.shake.d.a.j a = com.tencent.mm.plugin.shake.d.a.j.a(null);
        if (com.tencent.mm.plugin.shake.d.a.j.hqt) {
            com.tencent.mm.plugin.shake.d.a.j.hqt = false;
            if (!a.iQq.aOp()) {
                v.e("Micromsg.ShakeMusicMgr", "release MusicFingerPrintRecorder error");
            }
        }
        com.tencent.mm.plugin.shake.d.a.j.iQr = null;
        com.tencent.mm.platformtools.j.c(this);
        com.tencent.mm.sdk.c.a.nhr.f(this.iSD);
        com.tencent.mm.sdk.c.a.nhr.f(this.iSE);
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nrv, Boolean.valueOf(false));
        aOy();
        if (com.tencent.mm.plugin.shake.c.c.a.aOn()) {
            com.tencent.mm.p.c.us().t(262154, false);
        }
        aOE();
        com.tencent.mm.plugin.shake.c.a.f aNT = k.aNT();
        if (aNT.eAR != null && this != null) {
            for (int i = 0; i < aNT.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) aNT.eAR.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.shake.c.a.f.a aVar = (com.tencent.mm.plugin.shake.c.a.f.a) weakReference.get();
                    if (aVar != null && aVar.equals(this)) {
                        aNT.eAR.remove(weakReference);
                        break;
                    }
                }
            }
        }
        com.tencent.mm.plugin.shake.c.a.d aNU = k.aNU();
        aNU.bYf = -1000.0f;
        aNU.bYg = -1000.0f;
        if (this.bYe != null) {
            this.bYe.c(this.bYl);
        }
        super.onDestroy();
    }

    private void aOx() {
        if (aOJ() && BluetoothAdapter.getDefaultAdapter() != null) {
            List<String> sR = com.tencent.mm.h.j.sV().sR();
            if (sR != null) {
                this.iSB = System.currentTimeMillis();
                for (String str : sR) {
                    v.i("MicroMsg.ShakeReportUI", "op=true,iBeacon = %s", new Object[]{str});
                    cr crVar = new cr();
                    crVar.baC.baE = str;
                    crVar.baC.baB = true;
                    com.tencent.mm.sdk.c.a.nhr.z(crVar);
                }
            }
        }
    }

    private void aOy() {
        ak.yW();
        if (!Boolean.valueOf(be.a((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nrv, null), false)).booleanValue()) {
            this.bYi.clear();
            bYj = new CopyOnWriteArrayList();
        }
        if (VERSION.SDK_INT >= 18) {
            List<String> sR = com.tencent.mm.h.j.sV().sR();
            if (sR != null) {
                for (String str : sR) {
                    cr crVar = new cr();
                    v.i("MicroMsg.ShakeReportUI", "op=false,iBeacon = %s", new Object[]{str});
                    crVar.baC.baE = str;
                    crVar.baC.baB = false;
                    com.tencent.mm.sdk.c.a.nhr.z(crVar);
                }
            }
        }
    }

    protected final void NI() {
        com.tencent.mm.plugin.shake.c.c.a.aNI();
        this.iSv.put(Integer.valueOf(1), Boolean.valueOf(true));
        this.iSv.put(Integer.valueOf(3), Boolean.valueOf(false));
        this.iSv.put(Integer.valueOf(4), Boolean.valueOf(false));
        this.iSv.put(Integer.valueOf(5), Boolean.valueOf(false));
        this.iSv.put(Integer.valueOf(6), Boolean.valueOf(false));
        this.cOz = new com.tencent.mm.ae.a.a(this);
        this.iRE = (TextView) findViewById(2131759141);
        this.iRD = findViewById(2131759142);
        this.iRF = (TextView) findViewById(2131759144);
        this.iRG = (TextView) findViewById(2131759143);
        this.iSi = findViewById(2131759169);
        this.iSj = (ImageView) findViewById(2131759171);
        this.iSk = (ImageView) findViewById(2131759173);
        this.iSl = (ImageView) findViewById(2131759175);
        this.iSm = (ImageView) findViewById(2131759177);
        this.iSn = findViewById(2131759170);
        this.iSo = findViewById(2131759172);
        this.iSp = findViewById(2131759174);
        this.iSq = findViewById(2131759176);
        this.iRC = findViewById(2131759147);
        this.iRC.setOnClickListener(this.iSF);
        this.dtz = (ImageView) this.iRC.findViewById(2131759148);
        this.dtz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void onClick(View view) {
                if (this.iSG.iSg != 5) {
                    this.iSG.iRB = new f(this.iSG, (String) this.iSG.iRC.getTag(), null, com.tencent.mm.pluginsdk.ui.f.a.lGI);
                    this.iSG.iRB.boy();
                }
            }
        });
        aOz();
        View inflate = View.inflate(this.nDR.nEl, 2130904370, null);
        this.iRW = new i(this.nDR.nEl, 2131559263);
        this.iRW.setContentView(inflate);
        this.iRW.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                    final /* synthetic */ AnonymousClass4 iSH;

                    {
                        this.iSH = r1;
                    }

                    public final boolean queueIdle() {
                        s.a(this.iSH.iSG, 0, this.iSH.iSG.getString(2131235280));
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(4117, Boolean.valueOf(true));
                        return false;
                    }
                });
            }
        });
        ((Button) inflate.findViewById(2131759129)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void onClick(View view) {
                this.iSG.iRW.cancel();
            }
        });
        ak.yW();
        boolean c = be.c((Boolean) com.tencent.mm.model.c.vf().get(4108, null));
        ak.yW();
        boolean c2 = be.c((Boolean) com.tencent.mm.model.c.vf().get(4117, null));
        if (!c) {
            inflate.setVisibility(0);
            this.iRW.show();
            ak.yW();
            com.tencent.mm.model.c.vf().set(4108, Boolean.valueOf(true));
        } else if (!c2) {
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ ShakeReportUI iSG;

                {
                    this.iSG = r1;
                }

                public final boolean queueIdle() {
                    s.a(this.iSG, 0, this.iSG.getString(2131235280));
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(4117, Boolean.valueOf(true));
                    return false;
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iSG.iRu = false;
                this.iSG.finish();
                return true;
            }
        });
        a(0, 2131230801, 2131165208, new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iSG.iRu = false;
                Intent intent = new Intent();
                intent.setClass(this.iSG, ShakePersonalInfoUI.class);
                this.iSG.startActivityForResult(intent, 3);
                return true;
            }
        });
        OnClickListener anonymousClass29 = new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void onClick(View view) {
                this.iSG.bY(view);
            }
        };
        if (this.iSz || this.iSx) {
            this.iRX = (ImageView) findViewById(2131759168);
        } else {
            this.iRX = (ImageView) findViewById(2131759155);
        }
        this.iRZ = (ImageView) findViewById(2131759161);
        this.iSa = (ImageView) findViewById(2131759163);
        this.iSb = (ImageView) findViewById(2131759166);
        this.iSc = (ImageView) findViewById(2131759157);
        this.iSf = (TextView) findViewById(2131759159);
        this.iSe = (ImageView) findViewById(2131759158);
        this.iSd = (ImageView) findViewById(2131759164);
        aOG();
        this.iSr.setOnClickListener(anonymousClass29);
        findViewById(2131759167).setOnClickListener(anonymousClass29);
        findViewById(2131759160).setOnClickListener(anonymousClass29);
        findViewById(2131759162).setOnClickListener(anonymousClass29);
        findViewById(2131759165).setOnClickListener(anonymousClass29);
        findViewById(2131759156).setOnClickListener(anonymousClass29);
        com.tencent.mm.sdk.c.a.nhr.e(this.iSD);
        com.tencent.mm.sdk.c.a.nhr.e(this.iSE);
        aOC();
        aOF();
        fx(true);
    }

    private void aOz() {
        ak.yW();
        int a = be.a((Integer) com.tencent.mm.model.c.vf().get(12290, null), 0);
        ImageView imageView = (ImageView) findViewById(2131759135);
        if (!(this.iRV == null || this.iRV.isRecycled())) {
            this.iRV.recycle();
        }
        ak.yW();
        if (be.b((Boolean) com.tencent.mm.model.c.vf().get(4110, null))) {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.wP()).append("default_shake_img_filename.jpg").toString();
            if (com.tencent.mm.a.e.aR(stringBuilder2)) {
                this.iRV = com.tencent.mm.platformtools.j.lW(stringBuilder2);
                imageView.setImageDrawable(new BitmapDrawable(this.iRV));
            } else {
                Drawable bitmapDrawable;
                try {
                    bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.decodeStream(this.nDR.nEl.getAssets().open("resource/shakehideimg_man.jpg")));
                } catch (IOException e) {
                    v.w("MicroMsg.ShakeReportUI", "Bg decode exp:" + e.getLocalizedMessage());
                    bitmapDrawable = null;
                }
                imageView.setImageDrawable(bitmapDrawable);
            }
        } else {
            ak.yW();
            this.iRV = com.tencent.mm.platformtools.j.lW((String) com.tencent.mm.model.c.vf().get(4111, null));
            imageView.setImageDrawable(new BitmapDrawable(this.iRV));
        }
        imageView = (ImageView) findViewById(2131759137);
        ImageView imageView2 = (ImageView) findViewById(2131759140);
        imageView.setImageResource(a == 2 ? 2130839132 : 2130839133);
        imageView2.setImageResource(a == 2 ? 2130839131 : 2130839130);
        OnClickListener anonymousClass7 = new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void onClick(View view) {
                if (this.iSG.iRs) {
                    this.iSG.iRw = false;
                    this.iSG.iRr = true;
                    this.iSG.fw(false);
                    com.tencent.mm.ui.base.g.a(this.iSG.nDR.nEl, null, new String[]{this.iSG.getString(2131235248)}, "", new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ AnonymousClass7 iSI;

                        {
                            this.iSI = r1;
                        }

                        public final void gT(int i) {
                            this.iSI.iSG.iRw = true;
                            switch (i) {
                                case 0:
                                    l.a(this.iSI.iSG, 1, null);
                                    return;
                                default:
                                    return;
                            }
                        }
                    }, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass7 iSI;

                        {
                            this.iSI = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            this.iSI.iSG.iRw = true;
                        }
                    });
                }
            }
        };
        imageView.setOnClickListener(anonymousClass7);
        imageView2.setOnClickListener(anonymousClass7);
        if (this.iRJ == null) {
            this.iRJ = findViewById(2131759145);
        }
        this.iRJ.setOnClickListener(anonymousClass7);
        if (this.iRK == null) {
            this.iRK = findViewById(2131759138);
        }
        this.iRK.setOnClickListener(anonymousClass7);
    }

    private void fs(boolean z) {
        String format = String.format("%1$s-shaketype-%2$d", new Object[]{getClass().getName(), Integer.valueOf(4)});
        v.d("MicroMsg.ShakeReportUI", "activate change report , class name=" + format + ", isActive=" + z);
        w.a(z, new Intent().putExtra("classname", format));
    }

    private void aOA() {
        j.b bVar;
        if (this.iSg == 3 && com.tencent.mm.ai.c.HG()) {
            this.iSg = 3;
            this.iRG.setText(2131235278);
            this.iRX.setBackgroundResource(2130839116);
            this.iRZ.setBackgroundResource(2130839122);
            this.iSa.setBackgroundResource(2130839121);
            this.iSb.setBackgroundResource(2130839125);
            this.iSc.setBackgroundResource(2130839112);
            findViewById(2131759153).setVisibility(0);
            vD(2131235274);
            g.iuh.h(11720, new Object[]{Integer.valueOf(2)});
        } else if (this.iSg == 4 && com.tencent.mm.plugin.shake.d.a.k.aNM()) {
            this.iSg = 4;
            this.iRG.setText(2131235279);
            this.iRX.setBackgroundResource(2130839116);
            this.iRZ.setBackgroundResource(2130839122);
            this.iSa.setBackgroundResource(2130839119);
            this.iSb.setBackgroundResource(2130839127);
            this.iSc.setBackgroundResource(2130839112);
            findViewById(2131759153).setVisibility(0);
            vD(2131235275);
            g.iuh.h(11720, new Object[]{Integer.valueOf(3)});
        } else if (this.iSg == 5 && aOI()) {
            this.iSg = 5;
            this.iRG.setText(2131235277);
            this.iRX.setBackgroundResource(2130839118);
            this.iRZ.setBackgroundResource(2130839122);
            this.iSa.setBackgroundResource(2130839119);
            this.iSb.setBackgroundResource(2130839125);
            this.iSc.setBackgroundResource(2130839112);
            findViewById(2131759153).setVisibility(0);
            vD(2131235273);
            g.iuh.h(11720, new Object[]{Integer.valueOf(4)});
        } else if (this.iSg == 6 && com.tencent.mm.plugin.shake.c.c.a.aOn()) {
            this.iSg = 6;
            this.iRG.setText(2131235276);
            this.iRX.setBackgroundResource(2130839116);
            this.iRZ.setBackgroundResource(2130839122);
            this.iSa.setBackgroundResource(2130839119);
            this.iSb.setBackgroundResource(2130839125);
            this.iSc.setBackgroundResource(2130839113);
            findViewById(2131759153).setVisibility(0);
            vD(2131235272);
            aOD();
            aOG();
            g.iuh.h(11720, new Object[]{Integer.valueOf(5)});
        } else {
            this.iSg = 1;
            this.iRG.setText(2131235227);
            this.iRX.setBackgroundResource(2130839116);
            this.iRZ.setBackgroundResource(2130839124);
            this.iSa.setBackgroundResource(2130839119);
            this.iSb.setBackgroundResource(2130839125);
            this.iSc.setBackgroundResource(2130839112);
            if (com.tencent.mm.ai.c.HG()) {
                findViewById(2131759153).setVisibility(0);
            }
            vD(2131235271);
            g.iuh.h(11720, new Object[]{Integer.valueOf(1)});
        }
        j jVar = this.iRA;
        int i = this.iSg;
        if (i == jVar.iOl) {
            bVar = jVar.iOm;
        } else {
            if (jVar.iOm != null) {
                jVar.iOm.aNB();
            }
            switch (i) {
                case 1:
                    jVar.iOm = new com.tencent.mm.plugin.shake.b.c(this, this);
                    break;
                case 3:
                    jVar.iOm = com.tencent.mm.plugin.shake.d.a.j.a((com.tencent.mm.plugin.shake.b.j.a) this);
                    break;
                case 4:
                    jVar.iOm = new com.tencent.mm.plugin.shake.d.a.l(this, this);
                    break;
                case 5:
                    jVar.iOm = new h(this);
                    break;
                case 6:
                    jVar.iOm = new com.tencent.mm.plugin.shake.c.a.g(this);
                    break;
            }
            jVar.iOl = i;
            jVar.iOm.init();
            bVar = jVar.iOm;
        }
        if (!this.iRu) {
            fw(false);
        }
        if (com.tencent.mm.plugin.shake.c.c.a.aOn() && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
            com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
            int i2 = this.iSs;
            gVar.exT = i2;
            v.i("MicroMsg.ShakeCardService", "ShakeCardService from_scene:" + i2);
            if (this.iSs == 3) {
                v.i("MicroMsg.ShakeReportUI", "open shake card from specialview");
                com.tencent.mm.plugin.shake.c.a.g gVar2 = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                String stringExtra = getIntent().getStringExtra("key_shake_card_ext_info");
                if (stringExtra == null || stringExtra.length() > 256) {
                    v.i("MicroMsg.ShakeCardService", "ShakeCardService ext_info size > 256 byte, extinfo:" + stringExtra);
                    return;
                }
                v.i("MicroMsg.ShakeCardService", "ShakeCardService mExtInfo:" + gVar2.gux);
                gVar2.gux = stringExtra;
            }
        }
    }

    private void aOB() {
        ak.yW();
        this.iRt = be.b((Boolean) com.tencent.mm.model.c.vf().get(4112, null));
        if (this.iRt) {
            vI(8);
        } else {
            vI(0);
        }
    }

    private void ft(boolean z) {
        fu(z);
        if (this.iRQ == null) {
            this.iRQ = findViewById(2131757423);
        }
        if (z) {
            if (k.aNP().Kw() <= 0) {
                this.iRQ.setVisibility(8);
                return;
            }
            com.tencent.mm.plugin.shake.b.f fVar;
            if (this.iRS == null) {
                this.iRS = (TextView) this.iRQ.findViewById(2131757425);
            }
            this.iRS.setText(getString(2131235257, new Object[]{Integer.valueOf(r2)}));
            this.iRQ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ShakeReportUI iSG;

                {
                    this.iSG = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.iSG, ShakeMsgListUI.class);
                    intent.putExtra("shake_msg_from", 1);
                    intent.putExtra("shake_msg_list_title", this.iSG.getString(2131235289));
                    this.iSG.startActivity(intent);
                }
            });
            if (this.iRR == null) {
                this.iRR = (MMImageView) findViewById(2131757424);
            }
            com.tencent.mm.plugin.shake.b.g aNP = k.aNP();
            Cursor rawQuery = aNP.cie.rawQuery("SELECT * FROM " + aNP.getTableName() + " where status != 1 ORDER BY rowid" + " DESC LIMIT 1", null);
            if (rawQuery == null) {
                fVar = null;
            } else if (rawQuery.getCount() != 1) {
                rawQuery.close();
                fVar = null;
            } else {
                rawQuery.moveToFirst();
                fVar = new com.tencent.mm.plugin.shake.b.f();
                fVar.b(rawQuery);
                rawQuery.close();
            }
            if (fVar != null) {
                String str = fVar.field_thumburl;
                if (be.kS(str)) {
                    this.iRR.setImageResource(2131165247);
                } else {
                    com.tencent.mm.plugin.shake.e.b bVar = new com.tencent.mm.plugin.shake.e.b(str);
                    Bitmap a = com.tencent.mm.platformtools.j.a(bVar);
                    this.iRR.setTag(bVar.MW());
                    if (a == null || a.isRecycled()) {
                        this.iRR.setImageResource(2131165247);
                    } else {
                        this.iRR.setImageBitmap(a);
                    }
                }
            }
            this.iRQ.setVisibility(0);
            return;
        }
        this.iRQ.setVisibility(8);
    }

    private void fu(boolean z) {
        if (this.iRP == null) {
            this.iRP = findViewById(2131757420);
        }
        if (this.iRA.iOl == 3 || this.iRA.iOl == 4 || this.iRA.iOl == 5 || this.iRA.iOl == 6 || !z) {
            this.iRP.setVisibility(8);
            return;
        }
        int Kw = com.tencent.mm.ar.l.KF().Kw();
        if (Kw <= 0) {
            this.iRP.setVisibility(8);
            return;
        }
        this.iRP.setVisibility(0);
        ((TextView) this.iRP.findViewById(2131757422)).setText(getResources().getQuantityString(2131361818, Kw, new Object[]{Integer.valueOf(Kw)}));
        this.iRP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.iSG, ShakeSayHiListUI.class);
                intent.putExtra("IntentSayHiType", 1);
                this.iSG.startActivity(intent);
            }
        });
        if (this.iRT == null) {
            this.iRT = (ImageView) findViewById(2131757421);
        }
        com.tencent.mm.ar.j KA = com.tencent.mm.ar.l.KF().KA();
        if (KA != null) {
            this.iRU = KA.field_sayhiuser;
            com.tencent.mm.pluginsdk.ui.a.b.m(this.iRT, this.iRU);
        }
    }

    private void fv(boolean z) {
        if (this.iRF == null) {
            return;
        }
        if (z) {
            this.iRF.setVisibility(0);
            return;
        }
        this.iRF.setVisibility(8);
        this.iRF.cancelLongPress();
    }

    private void fw(boolean z) {
        if (this.iRD == null) {
            return;
        }
        if (z) {
            this.iRD.setVisibility(0);
        } else {
            this.iRD.setVisibility(4);
        }
    }

    private void pu(int i) {
        fw(i == 1);
        if (i == 2) {
            fv(true);
        } else {
            fv(false);
        }
    }

    public final void yM() {
        aOA();
    }

    private void zx(String str) {
        this.iRu = false;
        if (this.iRt) {
            ao.T(this.nDR.nEl, 2131235263);
        }
        if (this.iRO == null) {
            this.iRO = AnimationUtils.loadAnimation(this.nDR.nEl, 2130968617);
        }
        pu(2);
        if (str == null || str.length() <= 1) {
            this.iRF.setText(2131235234);
        } else {
            this.iRF.setText(str);
        }
        this.iRF.startAnimation(this.iRO);
        this.iRx = true;
        ad.g(new Runnable(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void run() {
                this.iSG.fv(false);
                this.iSG.fw(false);
            }
        }, this.iRO.getDuration());
    }

    public final void d(List<d> list, long j) {
        fx(true);
        if (list == null || !this.iRu || j == 6) {
            this.iRY = null;
            if (j == 6) {
                zx(getString(2131235242));
                return;
            } else if (j == 7) {
                zx(getString(2131235240));
                return;
            } else if (j == 8) {
                zx(getString(2131235238));
                return;
            } else if (j == 9) {
                zx(getString(2131235237));
                return;
            } else if (j == 10) {
                zx(getString(2131235241));
                return;
            } else {
                zx(null);
                return;
            }
        }
        this.iRu = false;
        if (list.size() > 0) {
            this.iRY = (d) list.get(0);
        }
        int size;
        d dVar;
        Intent intent;
        if (this.iRA.iOl == 1) {
            if (list.size() <= 0 || ((d) list.get(0)).field_type == 0) {
                this.iRy = ((d) list.get(0)).scene;
                size = list.size();
                if (size == 0) {
                    zx(null);
                    return;
                } else if (size == 1) {
                    v.i("MicroMsg.ShakeReportUI", "1 u:" + ((d) list.get(0)).field_username + " n:" + ((d) list.get(0)).field_nickname + " d:" + ((d) list.get(0)).field_distance);
                    if (this.iRt) {
                        ao.T(this.nDR.nEl, 2131235255);
                    }
                    pu(3);
                    dVar = (d) list.get(0);
                    if (!be.kS(dVar.field_username)) {
                        this.iRC.setTag(dVar.field_username);
                        this.iRC.setVisibility(0);
                        ak.yW();
                        u LX = com.tencent.mm.model.c.wH().LX(dVar.field_username);
                        String str = dVar.field_nickname + (com.tencent.mm.i.a.ei(LX.field_type) ? getString(2131235256) : "");
                        if (dVar.field_sex == 1) {
                            this.iRC.setContentDescription(str + dVar.field_distance + this.nDR.nEl.getString(2131235283));
                        } else if (dVar.field_sex == 2) {
                            this.iRC.setContentDescription(str + dVar.field_distance + this.nDR.nEl.getString(2131235282));
                        } else {
                            this.iRC.setContentDescription(str + dVar.field_distance);
                        }
                        TextView textView = (TextView) this.iRC.findViewById(2131759149);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.nDR.nEl, dVar.field_nickname + (com.tencent.mm.i.a.ei(LX.field_type) ? getString(2131235256) : ""), textView.getTextSize()));
                        if (this.dtz != null) {
                            if (be.kS(str)) {
                                this.dtz.setContentDescription(getString(2131235223));
                            } else {
                                this.dtz.setContentDescription(String.format(getString(2131235222), new Object[]{str}));
                            }
                        }
                        ((TextView) this.iRC.findViewById(2131759152)).setText(dVar.field_distance);
                        com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) this.iRC.findViewById(2131759148), dVar.field_username);
                        ImageView imageView = (ImageView) this.iRC.findViewById(2131759151);
                        if (dVar.field_reserved1 != 0) {
                            imageView.setVisibility(0);
                            imageView.setImageBitmap(BackwardSupportUtil.b.c(com.tencent.mm.model.ab.a.csb.eI(dVar.field_reserved1), 2.0f));
                        } else {
                            imageView.setVisibility(8);
                        }
                        if (dVar.field_reserved1 != 0 || dVar.field_sex == 0) {
                            this.iRC.findViewById(2131759150).setVisibility(8);
                        } else {
                            Drawable a = com.tencent.mm.bd.a.a(this, dVar.field_sex == 1 ? 2131165606 : 2131165605);
                            this.iRC.findViewById(2131759150).setVisibility(0);
                            ((ImageView) this.iRC.findViewById(2131759150)).setImageDrawable(a);
                        }
                        if (dVar.getProvince() == null) {
                            v.e("MicroMsg.ShakeReportUI", "PROVINCE NULL");
                            dVar.field_province = "";
                        }
                        if (dVar.getCity() == null) {
                            v.e("MicroMsg.ShakeReportUI", "CITY NULL");
                            dVar.field_city = "";
                        }
                        this.iRC.startAnimation(AnimationUtils.loadAnimation(this.nDR.nEl, 2130968665));
                        return;
                    }
                    return;
                } else {
                    if (this.iRt) {
                        ao.T(this.nDR.nEl, 2131235255);
                    }
                    pu(3);
                    fu(false);
                    intent = new Intent(this, ShakeItemListUI.class);
                    intent.putExtra("_key_show_type_", -1);
                    intent.putExtra("_key_title_", getString(2131235253));
                    startActivity(intent);
                    return;
                }
            }
            zx(null);
        } else if (this.iRA.iOl == 3) {
            size = list.size();
            if (size == 0) {
                zx(getString(2131235262));
            } else if (size == 1) {
                if (this.iRt) {
                    ao.T(this.nDR.nEl, 2131235255);
                }
                pu(3);
                if (((d) list.get(0)).field_type == 4) {
                    ajr a2 = com.tencent.mm.plugin.shake.d.a.i.a(((d) list.get(0)).field_lvbuffer, j);
                    com.tencent.mm.ai.b.c(a2);
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_mode", 1);
                    intent2.putExtra("key_offset", a2.mJX);
                    intent2.putExtra("music_player_beg_time", a2.jer);
                    intent2.putExtra("key_scene", 3);
                    if (com.tencent.mm.ai.c.HH()) {
                        intent2.putExtra("KGlobalShakeMusic", true);
                    }
                    com.tencent.mm.ay.c.b(this, "music", ".ui.MusicMainUI", intent2);
                    return;
                }
                v.w("MicroMsg.ShakeReportUI", "Unexpected type, ignore.");
            }
        } else if (this.iRA.iOl == 4) {
            fx(true);
            size = list.size();
            if (size == 0) {
                zx(getString(2131235290));
            } else if (size == 1) {
                if (this.iRt) {
                    ao.T(this.nDR.nEl, 2131235255);
                }
                pu(3);
                new ac().postDelayed(new 1((d) list.get(0), this), 100);
            }
        } else if (this.iRA.iOl == 5) {
            switch ((int) j) {
                case 1:
                    if (list.isEmpty() || ((d) list.get(0)).field_type != 11) {
                        zx(null);
                        return;
                    } else if (list.size() == 1) {
                        if (this.iRt) {
                            ao.T(this.nDR.nEl, 2131235255);
                        }
                        pu(3);
                        dVar = (d) list.get(0);
                        if (!be.kS(dVar.field_username)) {
                            this.iRC.setTag(dVar.field_username);
                            ((TextView) this.iRC.findViewById(2131759149)).setText(dVar.field_username);
                            this.iRC.setContentDescription(be.ma(dVar.field_nickname));
                            ((TextView) this.iRC.findViewById(2131759152)).setText(dVar.field_signature);
                            this.cOz.a(dVar.getProvince(), (ImageView) this.iRC.findViewById(2131759148));
                            this.iRC.findViewById(2131759150).setVisibility(8);
                            this.iRC.startAnimation(AnimationUtils.loadAnimation(this.nDR.nEl, 2130968665));
                            this.iRC.setVisibility(0);
                            return;
                        }
                        return;
                    } else {
                        if (this.iRt) {
                            ao.T(this.nDR.nEl, 2131235255);
                        }
                        pu(3);
                        fu(false);
                        intent = new Intent(this, ShakeItemListUI.class);
                        intent.putExtra("_key_show_type_", -12);
                        intent.putExtra("_key_title_", getString(2131235252));
                        intent.putExtra("_key_show_from_shake_", true);
                        intent.putExtra("_ibeacon_new_insert_size", list.size());
                        startActivity(intent);
                        return;
                    }
                case 6:
                    zx(getString(2131235242));
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, final com.tencent.mm.plugin.shake.c.a.e eVar, long j) {
        this.iSu = true;
        if (i == 1251) {
            if (eVar != null) {
                v.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_GetLbsCard");
                com.tencent.mm.plugin.shake.c.c.a.aNI();
                aOH();
                aOC();
                aOF();
                this.iSs = 4;
                k.aNU().putValue("key_shake_card_item", eVar);
            }
        } else if (i != 1250) {
        } else {
            if (eVar == null) {
                this.iRY = null;
                zx(null);
            } else if ((eVar == null || this.iRu) && !this.iRu) {
                this.iRY = null;
                zx(null);
            } else {
                this.iRu = false;
                v.i("MicroMsg.ShakeReportUI", "onShakeCardReturn MMFunc_Biz_ShakeCard");
                if (this.iRA.iOl == 6) {
                    j.b bVar = this.iRA.iOm;
                    if (bVar != null && (bVar instanceof com.tencent.mm.plugin.shake.c.a.g)) {
                        com.tencent.mm.plugin.shake.c.a.g gVar = (com.tencent.mm.plugin.shake.c.a.g) bVar;
                        switch ((int) j) {
                            case 1:
                                v.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_OK");
                                if (gVar.eCZ == 3) {
                                    v.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is  MMBIZ_SHAKE_CARD_ACTION_TYPE_NO_CARD");
                                    if (eVar == null || TextUtils.isEmpty(eVar.iOO)) {
                                        zx(getString(2131235224));
                                        return;
                                    } else {
                                        zx(eVar.iOO);
                                        return;
                                    }
                                }
                                v.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() actionType is " + gVar.eCZ);
                                pu(3);
                                if (eVar.eCZ == 1) {
                                    this.iRw = false;
                                }
                                if (this.iSt != null && this.iSt.isShowing()) {
                                    return;
                                }
                                if (eVar.iOQ) {
                                    ViewStub viewStub = (ViewStub) findViewById(2131759146);
                                    if (viewStub != null) {
                                        viewStub.inflate();
                                    }
                                    ((ShakeEggAnimFrame) findViewById(2131756316)).K(this);
                                    new ac().postDelayed(new Runnable(this) {
                                        final /* synthetic */ ShakeReportUI iSG;

                                        public final void run() {
                                            this.iSG.a(eVar);
                                        }
                                    }, 1000);
                                    return;
                                }
                                a(eVar);
                                return;
                            case 2:
                                v.i("MicroMsg.ShakeReportUI", "onShakeGetReturn() ShakeCardService RETURN_ERR_REPORT");
                                zx(getString(2131235224));
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        }
    }

    private void a(com.tencent.mm.plugin.shake.c.a.e eVar) {
        this.iSt = com.tencent.mm.plugin.shake.c.b.a.a(this, eVar, new OnCancelListener(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                this.iSG.iRw = true;
                this.iSG.iSt = null;
                this.iSG.iRG.setText("");
            }
        }, new com.tencent.mm.plugin.shake.c.b.a.b(this) {
            final /* synthetic */ ShakeReportUI iSG;

            {
                this.iSG = r1;
            }

            public final void aOd() {
                this.iSG.iRw = true;
                this.iSG.iRG.setText("");
            }
        });
    }

    private void bY(View view) {
        if (view != null) {
            v.i("MicroMsg.ShakeReportUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), be.bur(), this});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")) {
                af("", false);
                if (view.getId() == 2131759160) {
                    g.iuh.h(11722, new Object[]{Integer.valueOf(1)});
                    if (this.iSg != 1) {
                        if (this.iSg == 4) {
                            fs(false);
                        }
                        this.iSg = 1;
                        aOA();
                        fu(false);
                        if (this.iRC != null) {
                            this.iRC.setVisibility(8);
                        }
                    }
                } else if (view.getId() == 2131759162) {
                    g.iuh.h(11722, new Object[]{Integer.valueOf(2)});
                    if (!(this.bYh || this.bYe == null)) {
                        this.bYe.a(this.bYl, true);
                    }
                    if (!(com.tencent.mm.as.u.bj(this) || com.tencent.mm.ah.a.aT(this) || this.iSg == 3)) {
                        if (this.iSg == 4) {
                            fs(false);
                        }
                        this.iSg = 3;
                        aOA();
                        fu(false);
                        if (this.iRC != null) {
                            this.iRC.setVisibility(8);
                        }
                    }
                    if (com.tencent.mm.ai.c.HH()) {
                        ak.yW();
                        if (com.tencent.mm.model.c.vf().getInt(4118, 0) == 0) {
                            com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.nDR.nEl);
                            aVar.wm(2131231164);
                            aVar.wn(2131235244);
                            aVar.wp(2131235243).a(new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ ShakeReportUI iSG;

                                {
                                    this.iSG = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (this.iSG.iRW != null) {
                                        this.iSG.iRW.cancel();
                                    }
                                }
                            });
                            aVar.jk(true);
                            aVar.c(new OnCancelListener(this) {
                                final /* synthetic */ ShakeReportUI iSG;

                                {
                                    this.iSG = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().setInt(4118, 1);
                                    this.iSG.iSd.setVisibility(8);
                                }
                            });
                            this.iRW = aVar.RX();
                            this.iRW.show();
                        }
                    }
                } else if (view.getId() == 2131759165) {
                    g.iuh.h(11722, new Object[]{Integer.valueOf(3)});
                    if (!(this.bYh || this.bYe == null)) {
                        this.bYe.a(this.bYl, true);
                    }
                    if (!(com.tencent.mm.as.u.bj(this) || com.tencent.mm.ah.a.aT(this) || this.iSg == 4)) {
                        fs(true);
                        this.iSg = 4;
                        aOA();
                        fu(false);
                        if (this.iRC != null) {
                            this.iRC.setVisibility(8);
                        }
                    }
                } else if (view.getId() == 2131759167 || view.getId() == 2131759154) {
                    g.iuh.h(11722, new Object[]{Integer.valueOf(4)});
                    if (this.iSg != 5) {
                        this.iSg = 5;
                        aOA();
                        fu(false);
                        if (this.iRC != null) {
                            this.iRC.setVisibility(8);
                        }
                        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
                            boolean isProviderEnabled;
                            LocationManager locationManager = (LocationManager) aa.getContext().getSystemService("location");
                            if (locationManager != null) {
                                isProviderEnabled = locationManager.isProviderEnabled("gps");
                            } else {
                                isProviderEnabled = true;
                            }
                            if (!isProviderEnabled) {
                                zx(getString(2131235238));
                            }
                        }
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
                            zx(getString(2131235237));
                        } else if (defaultAdapter == null) {
                            zx(getString(2131235241));
                        }
                    }
                } else if (view.getId() == 2131759156) {
                    g.iuh.h(11722, new Object[]{Integer.valueOf(5)});
                    if (this.iSg != 6) {
                        if (this.iSg == 4) {
                            fs(false);
                        }
                        this.iSg = 6;
                        aOA();
                        fu(false);
                        if (this.iRC != null) {
                            this.iRC.setVisibility(8);
                        }
                        com.tencent.mm.p.c.us().t(262155, false);
                        this.iSe.setVisibility(8);
                    }
                }
                ft(true);
                fw(false);
                fx(true);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    ak.yW();
                    intent2.putExtra("CropImage_OutputPath", stringBuilder.append(com.tencent.mm.model.c.wP()).append("custom_shake_img_filename.jpg").toString());
                    com.tencent.mm.plugin.shake.a.drp.a(intent2, 2, this, intent);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(4110, Boolean.valueOf(false));
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(4111, stringExtra);
                    aOz();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        aOB();
        if (!this.iRv) {
            ft(true);
        }
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        a("", null);
    }

    public final void k(String str, Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled() && this.iRR != null && this.iRR.getTag() != null && str.equals((String) this.iRR.getTag())) {
            this.iRR.setImageBitmap(bitmap);
        }
    }

    public final void aNX() {
        com.tencent.mm.plugin.shake.c.c.a.aNI();
        aOC();
        aOD();
        aOG();
        aOH();
        aOF();
    }

    private void aOC() {
        if (!com.tencent.mm.plugin.shake.c.c.a.aOn()) {
            return;
        }
        if (com.tencent.mm.p.c.us().ay(262155, 266259)) {
            this.iSe.setVisibility(0);
        } else {
            this.iSe.setVisibility(8);
        }
    }

    private void aOD() {
        if (this.iSg == 6 && com.tencent.mm.plugin.shake.c.c.a.aOn()) {
            boolean ay = com.tencent.mm.p.c.us().ay(262154, 266258);
            boolean ay2 = com.tencent.mm.p.c.us().ay(262155, 266259);
            if (ay) {
                af(com.tencent.mm.plugin.shake.c.c.a.aOi(), true);
            } else if (ay2) {
                af(com.tencent.mm.plugin.shake.c.c.a.aOk(), true);
            } else if (!this.iSu) {
                if (TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.aOg())) {
                    af(getString(2131235225), true);
                } else {
                    af(com.tencent.mm.plugin.shake.c.c.a.aOg(), true);
                }
            }
        }
    }

    private void af(String str, boolean z) {
        this.iRu = false;
        if (this.iRO == null) {
            this.iRO = AnimationUtils.loadAnimation(this.nDR.nEl, 2130968617);
        }
        pu(2);
        fv(true);
        if (str != null && str.length() > 1) {
            this.iRF.setText(str);
        } else if (z) {
            this.iRF.setText(2131235225);
        } else {
            this.iRF.setText("");
            fv(false);
        }
        this.iRx = true;
    }

    private void aOE() {
        if (this.iSt != null && this.iSt.isShowing()) {
            this.iSt.dismiss();
        }
        this.iSt = null;
    }

    private void aOF() {
        int intExtra;
        int i;
        int i2 = 1;
        boolean aNJ = com.tencent.mm.plugin.shake.c.c.a.aNJ();
        boolean ay = com.tencent.mm.p.c.us().ay(262154, 266258);
        boolean ay2 = com.tencent.mm.p.c.us().ay(262155, 266259);
        if (getIntent().getBooleanExtra("shake_card", false)) {
            intExtra = getIntent().getIntExtra("shake_card", 0);
        } else {
            intExtra = 0;
        }
        g gVar = g.iuh;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(intExtra);
        if (ay) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(aNJ ? 1 : 0);
        objArr[4] = com.tencent.mm.plugin.shake.c.c.a.aOj();
        objArr[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.aOf());
        gVar.h(11668, objArr);
        g gVar2 = g.iuh;
        Object[] objArr2 = new Object[6];
        objArr2[0] = Integer.valueOf(2);
        objArr2[1] = Integer.valueOf(intExtra);
        if (ay2) {
            intExtra = 1;
        } else {
            intExtra = 0;
        }
        objArr2[2] = Integer.valueOf(intExtra);
        if (!aNJ) {
            i2 = 0;
        }
        objArr2[3] = Integer.valueOf(i2);
        objArr2[4] = com.tencent.mm.plugin.shake.c.c.a.aOj();
        objArr2[5] = Integer.valueOf(com.tencent.mm.plugin.shake.c.c.a.aOf());
        gVar2.h(11668, objArr2);
    }

    private void aOG() {
        if (!TextUtils.isEmpty(com.tencent.mm.plugin.shake.c.c.a.aOh())) {
            this.iSf.setText(com.tencent.mm.plugin.shake.c.c.a.aOh());
        }
    }

    private void aOH() {
        if (com.tencent.mm.ai.c.HG()) {
            v.i("MicroMsg.ShakeReportUI", "is not oversea user, show shake music");
            this.iSv.put(Integer.valueOf(3), Boolean.valueOf(true));
            findViewById(2131759162).setVisibility(0);
            if (com.tencent.mm.ai.c.HH()) {
                ak.yW();
                if (com.tencent.mm.model.c.vf().getInt(4118, 0) == 0) {
                    this.iSd.setVisibility(0);
                } else {
                    this.iSd.setVisibility(8);
                }
            }
        } else {
            this.iSv.put(Integer.valueOf(3), Boolean.valueOf(false));
            findViewById(2131759162).setVisibility(8);
            v.i("MicroMsg.ShakeReportUI", "is oversea user, hide shake music");
        }
        if (com.tencent.mm.plugin.shake.d.a.k.aNM()) {
            this.iSv.put(Integer.valueOf(4), Boolean.valueOf(true));
            findViewById(2131759165).setVisibility(0);
            v.i("MicroMsg.ShakeReportUI", "show shake tv tab");
        } else {
            this.iSv.put(Integer.valueOf(4), Boolean.valueOf(false));
            findViewById(2131759165).setVisibility(8);
            v.i("MicroMsg.ShakeReportUI", "hide shake tv tab");
        }
        if (com.tencent.mm.plugin.shake.c.c.a.aOn()) {
            this.iSv.put(Integer.valueOf(6), Boolean.valueOf(true));
            findViewById(2131759156).setVisibility(0);
            v.i("MicroMsg.ShakeReportUI", "show shake card tab");
        } else {
            findViewById(2131759156).setVisibility(8);
            this.iSv.put(Integer.valueOf(6), Boolean.valueOf(false));
            v.i("MicroMsg.ShakeReportUI", "hide shake card tab");
        }
        if (aOI()) {
            this.iSv.put(Integer.valueOf(5), Boolean.valueOf(true));
            this.iSr.setVisibility(0);
            v.i("MicroMsg.ShakeReportUI", "[shakezb]show shake ibeacon tab");
        } else {
            this.iSv.put(Integer.valueOf(5), Boolean.valueOf(false));
            this.iSr.setVisibility(8);
            v.i("MicroMsg.ShakeReportUI", "[shakezb]hide shake ibeacon tab");
        }
        int i = 0;
        for (Boolean booleanValue : this.iSv.values()) {
            int i2;
            if (booleanValue.booleanValue()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        this.iSh = i;
        LinearLayout linearLayout = (LinearLayout) findViewById(2131759153);
        if (i == 1) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
        }
        if (i > 4 && this.iSC) {
            findViewById(2131759165).setVisibility(8);
            v.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() > 0.");
            this.iSh--;
        } else if (i > 4 && !this.iSC) {
            this.iSr.setVisibility(8);
            this.iSw = false;
            this.iSh--;
            v.i("MicroMsg.ShakeReportUI", "show tab count is > 4 and beaconMap.size() <= 0.");
        }
    }

    private boolean aOI() {
        v.i("MicroMsg.ShakeReportUI", "[shakezb] isChineseAppLang :" + com.tencent.mm.sdk.platformtools.u.bsU() + " ,getApplicationLanguage[en or zh_CN or zh_HK or zh_TW is avaliable] :" + com.tencent.mm.sdk.platformtools.u.bsY());
        return this.iSw && aOJ();
    }

    private static boolean aOJ() {
        return com.tencent.mm.sdk.platformtools.u.bsU() || com.tencent.mm.sdk.platformtools.u.bsY().equals("en") || com.tencent.mm.sdk.platformtools.u.bsY().equals("ja");
    }

    private void fx(boolean z) {
        this.iSi.setVisibility(8);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            int i2;
            String str = "MicroMsg.ShakeReportUI";
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
        v.i("MicroMsg.ShakeReportUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    aIP();
                    return;
                }
                this.ijq = false;
                com.tencent.mm.ui.base.g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ ShakeReportUI iSG;

                    {
                        this.iSG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.iSG.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.iSG.ijq = true;
                        this.iSG.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ ShakeReportUI iSG;

                    {
                        this.iSG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.iSG.ijq = true;
                        this.iSG.finish();
                    }
                });
                return;
            case 80:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ShakeReportUI iSG;

                        {
                            this.iSG = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.iSG.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ShakeReportUI iSG;

                        {
                            this.iSG = r1;
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
