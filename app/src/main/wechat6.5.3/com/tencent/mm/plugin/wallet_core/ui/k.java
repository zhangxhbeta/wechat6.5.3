package com.tencent.mm.plugin.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.jm;
import com.tencent.mm.e.a.ld;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class k extends i implements c {
    public OnCancelListener Fe;
    public ImageView cHH;
    private boolean cOX = false;
    public View eEX;
    private Animation fUt;
    private int fUu = 0;
    protected View hcJ;
    protected boolean iPt;
    protected PayInfo imN;
    public TextView isG;
    public TextView iys;
    protected com.tencent.mm.plugin.wallet_core.d.a kGr = new com.tencent.mm.plugin.wallet_core.d.a();
    public FavorPayInfo kID = new FavorPayInfo();
    protected a kJf = null;
    public TextView kJp;
    public Button kUN;
    public ImageView kUO;
    public TextView kUP;
    public TextView kUQ;
    public ImageView kUR;
    public TextView kUS;
    public EditHintPasswdView kUT;
    public c kUU;
    public View kUV;
    public View kUW;
    public TextView kUX;
    public ImageView kUY;
    public TextView kUZ;
    public TextView kVa;
    public View kVb;
    public TextView kVc;
    public a kVd;
    public OnClickListener kVe;
    public boolean kVf = false;
    protected boolean kVg = true;
    public Bankcard kVh = null;
    public TextView kVi;
    public View kVj;
    public TextView kVk;
    public ImageView kVl;
    protected int kVm = 0;
    protected boolean kVn = false;
    private int kVo = 0;
    private Animation kVp = null;
    private String kVq = "";
    protected MyKeyboardWindow mKeyboard;

    public interface a {
        void aEX();
    }

    private static class b implements OnCancelListener {
        private OnCancelListener kVy;

        private b(OnCancelListener onCancelListener) {
            this.kVy = null;
            this.kVy = onCancelListener;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            k.hp(false);
            if (this.kVy != null) {
                this.kVy.onCancel(dialogInterface);
            }
        }
    }

    public interface c {
        void a(String str, FavorPayInfo favorPayInfo, boolean z);
    }

    static /* synthetic */ boolean a(k kVar) {
        String str = "MicroMsg.WalletPwdDialog";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!kVar.cOX);
        v.i(str, str2, objArr);
        return !kVar.cOX;
    }

    public k(Context context) {
        super(context, 2131559267);
        bF(context);
    }

    public void bF(Context context) {
        cM(context);
        cN(context);
        bhg();
    }

    public final void cM(Context context) {
        this.eEX = View.inflate(context, bhj(), null);
        this.kUN = (Button) this.eEX.findViewById(2131756397);
        this.kUO = (ImageView) this.eEX.findViewById(2131758503);
        this.mKeyboard = (MyKeyboardWindow) this.eEX.findViewById(2131756017);
        this.hcJ = this.eEX.findViewById(2131756016);
        this.iys = (TextView) this.eEX.findViewById(2131755329);
        this.kUP = (TextView) this.eEX.findViewById(2131759991);
        this.isG = (TextView) this.eEX.findViewById(2131758504);
        this.kJp = (TextView) this.eEX.findViewById(2131758505);
        this.kJp.getPaint().setFlags(16);
        this.kUQ = (TextView) this.eEX.findViewById(2131758045);
        this.kUR = (ImageView) this.eEX.findViewById(2131759998);
        this.kUV = this.eEX.findViewById(2131759994);
        this.kUS = (TextView) this.eEX.findViewById(2131758509);
        this.cHH = (ImageView) this.eEX.findViewById(2131758501);
        this.kUW = this.eEX.findViewById(2131758507);
        this.kUX = (TextView) this.eEX.findViewById(2131759997);
        com.tencent.mm.pluginsdk.ui.a.b.m(this.cHH, e.getUsername());
        this.kUT = (EditHintPasswdView) this.eEX.findViewById(2131758506);
        this.kUY = (ImageView) this.eEX.findViewById(2131758508);
        this.kVi = (TextView) this.eEX.findViewById(2131759992);
        this.kVj = this.eEX.findViewById(2131759999);
        this.kVk = (TextView) this.eEX.findViewById(2131760001);
        this.kVl = (ImageView) this.eEX.findViewById(2131760000);
        this.kUZ = (TextView) this.eEX.findViewById(2131758918);
        this.kVa = (TextView) this.eEX.findViewById(2131759996);
        this.kVb = this.eEX.findViewById(2131759993);
        this.kVc = (TextView) this.eEX.findViewById(2131759995);
    }

    @TargetApi(14)
    public void cN(Context context) {
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.kUN.setEnabled(false);
        this.kUN.setTextColor(context.getResources().getColorStateList(2131690180));
        com.tencent.mm.wallet_core.ui.formview.a.a(this.kUT);
        this.kUT.pkg = new com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a(this) {
            final /* synthetic */ k kVr;

            {
                this.kVr = r1;
            }

            public final void fc(boolean z) {
                if (z) {
                    this.kVr.bhl();
                    g.iuh.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                }
            }
        };
        this.kUT.requestFocus();
        TextView textView = (TextView) this.eEX.findViewById(2131759991);
        if (textView != null) {
            textView.setText(com.tencent.mm.model.k.xT() ? context.getString(2131236405) : context.getString(2131236404));
        }
        EditText editText = (EditText) this.eEX.findViewById(2131755077);
        e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            com.tencent.mm.ui.a.c cVar = new com.tencent.mm.ui.a.c();
            this.mKeyboard.setSecureAccessibility(cVar);
            editText.setAccessibilityDelegate(cVar);
        }
        editText.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ k kVr;

            {
                this.kVr = r1;
            }

            public final void onClick(View view) {
                if (!this.kVr.hcJ.isShown()) {
                    this.kVr.hcJ.setVisibility(0);
                }
            }
        });
        this.eEX.findViewById(2131756018).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ k kVr;

            {
                this.kVr = r1;
            }

            public final void onClick(View view) {
                if (this.kVr.hcJ.isShown()) {
                    this.kVr.hcJ.setVisibility(8);
                }
            }
        });
    }

    private void bhg() {
        boolean z;
        this.kVo = 0;
        this.kVi.setVisibility(8);
        this.kVj.setVisibility(8);
        ab bga = com.tencent.mm.plugin.wallet_core.model.k.bga();
        if (bga == null || !bga.bgx()) {
            z = true;
        } else {
            z = com.tencent.mm.pluginsdk.j.a.lxX.anE();
        }
        v.i("MicroMsg.WalletPwdDialog", "hy: soter key status: %b", new Object[]{Boolean.valueOf(z)});
        if ((this.imN == null || this.imN.lVG != 100000) && z) {
            if (this.imN != null && this.imN.lVG == 100001) {
                this.imN.lVE = 1;
            }
            j.g gVar = com.tencent.mm.pluginsdk.j.a.lxX;
            if (gVar == null || !gVar.ant() || gVar.ano()) {
                z = false;
            } else {
                z = true;
            }
            boolean bgx = com.tencent.mm.plugin.wallet_core.model.k.bga().bgx();
            if (bgx && z && this.kVn && !bhm()) {
                this.kVi.setVisibility(0);
                this.kVi.setText(getContext().getString(2131236406));
                this.kVm = 1;
                this.kVj.setVisibility(0);
                this.kVl.setVisibility(0);
                this.kUT.setVisibility(8);
                this.hcJ.setVisibility(8);
                this.kUP.setText(2131236399);
                if (this.imN != null) {
                    this.imN.lVE = 1;
                }
                bhh();
                g.iuh.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            } else if (bgx && z && this.kVn && bhm()) {
                this.kVi.setText(getContext().getString(2131236184));
                this.kVi.setVisibility(0);
                this.kVm = 0;
                this.kVj.setVisibility(8);
                this.kUT.setVisibility(0);
                if (!this.hcJ.isShown()) {
                    this.hcJ.setVisibility(0);
                }
                this.kUP.setText(2131236404);
                if (this.imN != null) {
                    this.imN.lVE = 0;
                }
                g.iuh.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                e.yD(8);
            } else {
                if (this.imN != null) {
                    this.imN.lVE = 0;
                }
                this.kVi.setVisibility(8);
                g.iuh.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            }
            v.i("MicroMsg.WalletPwdDialog", "isOpenTouch:" + bgx + ",  isDeviceSupport:" + z + ", use_pay_touch:" + this.kVn + ", isForcePwdMode:" + bhm());
            this.kVi.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ k kVr;

                {
                    this.kVr = r1;
                }

                public final void onClick(View view) {
                    if (this.kVr.kVm == 0) {
                        this.kVr.kVi.setText(this.kVr.getContext().getString(2131236406));
                        this.kVr.kVm = 1;
                        this.kVr.kVj.setVisibility(0);
                        this.kVr.kVl.setVisibility(0);
                        this.kVr.kVk.setVisibility(8);
                        this.kVr.kUT.setVisibility(8);
                        this.kVr.hcJ.setVisibility(8);
                        this.kVr.kUP.setText(2131236399);
                        k.hp(false);
                        this.kVr.imN.lVE = 1;
                        g.iuh.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                        e.yD(9);
                    } else if (this.kVr.kVm == 1) {
                        this.kVr.kVi.setText(this.kVr.getContext().getString(2131236184));
                        this.kVr.kVm = 0;
                        this.kVr.kVj.setVisibility(8);
                        this.kVr.kUT.setVisibility(0);
                        if (!this.kVr.hcJ.isShown()) {
                            this.kVr.hcJ.setVisibility(0);
                        }
                        this.kVr.kUP.setText(2131236404);
                        k.hp(true);
                        this.kVr.imN.lVE = 0;
                        g.iuh.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
                        e.yD(29);
                        k.bhi();
                    }
                    if (this.kVr.kVm == 1) {
                        k.bhi();
                        if (k.a(this.kVr)) {
                            this.kVr.bhh();
                        }
                    }
                }
            });
            return;
        }
        if (!this.hcJ.isShown()) {
            this.hcJ.setVisibility(0);
        }
        if (this.imN != null) {
            this.imN.lVE = 0;
            this.imN.bfs = "";
            this.imN.bft = "";
        }
        this.kVj.setVisibility(0);
        this.kVk.setVisibility(0);
        this.kVk.setText(2131236183);
        this.kVk.setTextColor(getContext().getResources().getColor(2131690112));
        if (z) {
            this.kUW.setVisibility(8);
            this.kUX.setVisibility(8);
        } else {
            this.kUW.setVisibility(0);
            this.kUX.setVisibility(0);
        }
        g.iuh.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
    }

    private void bhh() {
        com.tencent.mm.pluginsdk.f.a.bmK();
        final jm jmVar = new jm();
        jmVar.bjR.bfr = this.imN.fTG;
        jmVar.bjR.bjT = 1;
        jmVar.bjR.bjU = new Runnable(this) {
            final /* synthetic */ k kVr;

            public final void run() {
                v.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback");
                com.tencent.mm.e.a.jm.b bVar = jmVar.bjS;
                int i = bVar.errCode;
                PayInfo payInfo;
                if (bVar != null && i == 0) {
                    this.kVr.imN.lVE = 1;
                    this.kVr.imN.bfs = bVar.bfs;
                    this.kVr.imN.bft = bVar.bft;
                    this.kVr.imN.bjV = bVar.bjV;
                    v.i("MicroMsg.WalletPwdDialog", "hy: payInfo soterAuthReq: %s", new Object[]{bVar.bjV});
                    this.kVr.imN.bfq = bVar.bfq;
                    payInfo = this.kVr.imN;
                    payInfo.lVF++;
                    this.kVr.kVk.setText("");
                    this.kVr.bhl();
                    g.iuh.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)});
                    com.tencent.mm.pluginsdk.f.a.ts(0);
                } else if (bVar == null || i == 0) {
                    this.kVr.imN.lVE = 0;
                    v.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, result == null");
                } else {
                    v.i("MicroMsg.WalletPwdDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                    this.kVr.imN.lVE = 0;
                    this.kVr.kVj.setVisibility(0);
                    this.kVr.kVk.setTextColor(this.kVr.getContext().getResources().getColor(2131689960));
                    this.kVr.kVk.setText(2131236182);
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    int c = currentTimeMillis - this.kVr.fUu;
                    if (c > 1) {
                        this.kVr.fUu = currentTimeMillis;
                        this.kVr.kVo = this.kVr.kVo + 1;
                        payInfo = this.kVr.imN;
                        payInfo.lVF++;
                    }
                    g.iuh.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2)});
                    currentTimeMillis = (i == 2 || i == 10308) ? true : 0;
                    if (this.kVr.kVo < 3 && c > 1 && currentTimeMillis == 0) {
                        if (this.kVr.kVp == null) {
                            this.kVr.kVp = com.tencent.mm.ui.c.a.eq(this.kVr.getContext());
                        }
                        this.kVr.kVl.setVisibility(8);
                        this.kVr.kVk.setVisibility(4);
                        this.kVr.kVp.reset();
                        this.kVr.kVp.setAnimationListener(new AnimationListener(this) {
                            final /* synthetic */ AnonymousClass5 kVt;

                            {
                                this.kVt = r1;
                            }

                            public final void onAnimationStart(Animation animation) {
                                v.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 kVu;

                                    {
                                        this.kVu = r1;
                                    }

                                    public final void run() {
                                        this.kVu.kVt.kVr.kVk.setVisibility(0);
                                    }
                                });
                            }

                            public final void onAnimationEnd(Animation animation) {
                                v.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 kVu;

                                    {
                                        this.kVu = r1;
                                    }

                                    public final void run() {
                                        this.kVu.kVt.kVr.kVk.setVisibility(8);
                                        this.kVu.kVt.kVr.kVl.setVisibility(0);
                                    }
                                });
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        this.kVr.kVk.startAnimation(this.kVr.kVp);
                        com.tencent.mm.pluginsdk.f.a.ts(1);
                    } else if (this.kVr.kVo >= 3 || currentTimeMillis != 0) {
                        k.bhi();
                        this.kVr.kVm = 0;
                        this.kVr.kVi.setVisibility(8);
                        this.kVr.kVj.setVisibility(8);
                        this.kVr.kVk.setVisibility(0);
                        this.kVr.kVk.setText(2131236183);
                        this.kVr.kVk.setTextColor(this.kVr.getContext().getResources().getColor(2131690112));
                        this.kVr.kUP.setText(2131236404);
                        this.kVr.kUT.setVisibility(0);
                        if (!this.kVr.hcJ.isShown()) {
                            this.kVr.hcJ.setVisibility(0);
                        }
                        com.tencent.mm.pluginsdk.f.a.ts(2);
                        k.hp(true);
                    }
                }
            }
        };
        com.tencent.mm.sdk.c.a.nhr.a(jmVar, Looper.getMainLooper());
    }

    private static void bhi() {
        v.i("MicroMsg.WalletPwdDialog", "hy: send release FPManager");
        com.tencent.mm.sdk.c.a.nhr.z(new ld());
    }

    public int bhj() {
        return 2130904649;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Fe != null) {
                this.Fe.onCancel(this);
            }
            if (this.kVd != null) {
                this.kVd.aEX();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.eEX);
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.iPt = z;
        setCanceledOnTouchOutside(this.iPt);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            v.e("MicroMsg.WalletPwdDialog", "dismiss exception, e = " + e.getMessage());
        }
        bhi();
        this.kGr.destory();
        if (this.fUt != null) {
            this.fUt.cancel();
        }
    }

    public final void Dv(String str) {
        this.iys.setText(str);
    }

    public final void Dw(String str) {
        if (TextUtils.isEmpty(str)) {
            this.isG.setVisibility(8);
            return;
        }
        this.isG.setVisibility(0);
        this.isG.setText(str);
    }

    private void Dx(String str) {
        if (TextUtils.isEmpty(str)) {
            v.i("MicroMsg.WalletPwdDialog", "ChargeFee is null");
            this.kUZ.setVisibility(8);
            return;
        }
        this.kUZ.setVisibility(0);
        this.kUZ.setText(str);
    }

    public final void cX(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.kUS.setVisibility(8);
        } else {
            this.kUS.setVisibility(0);
            this.kUS.setText(str2);
        }
        if (TextUtils.isEmpty(str)) {
            this.kVc.setVisibility(8);
            return;
        }
        this.kVc.setText(str);
        this.kVc.setVisibility(0);
    }

    public final void Dy(String str) {
        if (TextUtils.isEmpty(str)) {
            this.kJp.setVisibility(8);
            return;
        }
        this.kJp.setVisibility(0);
        this.kJp.setText(str);
    }

    private void e(Bankcard bankcard) {
        if (bankcard == null) {
            v.e("MicroMsg.WalletPwdDialog", "setBankcardText bankcard == null");
        } else if (bankcard.bfG()) {
            this.kUR.setImageResource(2130839490);
        } else {
            this.kGr.a(getContext(), bankcard, this.kUR);
        }
    }

    public final void a(String str, View.OnClickListener onClickListener, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.kUW.setVisibility(8);
            this.kUX.setVisibility(8);
            return;
        }
        this.kUW.setOnClickListener(onClickListener);
        this.kUQ.setText(str);
        if (this.kVg) {
            this.kUW.setVisibility(0);
            this.kUX.setVisibility(0);
        } else {
            this.kUW.setVisibility(8);
            this.kUX.setVisibility(8);
        }
        if (z) {
            this.kUV.setVisibility(0);
        } else {
            this.kUV.setVisibility(8);
        }
    }

    public final void a(final Context context, final Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard) {
        this.kJf = b.kRN.a(orders);
        if (orders == null || orders.kPn == null || orders.kPn.kHC == null || orders.kPn.kHC.size() <= 0 || this.kJf == null) {
            this.kUS.setVisibility(8);
            return;
        }
        Object obj;
        if (favorPayInfo == null) {
            this.kID = this.kJf.Dq(orders.kPn.kHB);
        } else {
            this.kID = favorPayInfo;
        }
        this.kUS.setVisibility(0);
        if (this.kUW != null) {
            this.kUW.setTag(this.kID);
        }
        this.kVh = bankcard;
        this.kVb.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ k kVr;

            public final void onClick(View view) {
                this.kVr.kUY.setVisibility(8);
                i.a(context, orders, this.kVr.kID.kOv, new com.tencent.mm.plugin.wallet_core.ui.i.b(this) {
                    final /* synthetic */ AnonymousClass6 kVw;

                    {
                        this.kVw = r1;
                    }

                    public final void a(FavorPayInfo favorPayInfo) {
                        List list;
                        String l;
                        String string;
                        String str;
                        String str2;
                        String str3;
                        String str4 = null;
                        this.kVw.kVr.kID = favorPayInfo;
                        this.kVw.kVr.kVf = false;
                        int i = this.kVw.kVr.kID.kOw;
                        String str5 = this.kVw.kVr.kID.kOx;
                        ArrayList hk = com.tencent.mm.plugin.wallet_core.model.k.bga().hk(true);
                        if (i != 0) {
                            List arrayList = new ArrayList();
                            for (int i2 = 0; i2 < hk.size(); i2++) {
                                boolean z;
                                if (be.kS(str5)) {
                                    if (!((Bankcard) hk.get(i2)).field_bankcardType.equals("CFT")) {
                                        z = true;
                                    }
                                    z = false;
                                } else {
                                    if (((Bankcard) hk.get(i2)).field_bankcardType.equals(str5)) {
                                        z = true;
                                    }
                                    z = false;
                                }
                                if (z) {
                                    arrayList.add((Bankcard) hk.get(i2));
                                }
                            }
                            list = arrayList;
                        } else {
                            list = hk;
                        }
                        this.kVw.kVr.kID.kOz = "";
                        if (a.a(this.kVw.kVr.kID, this.kVw.kVr.kVh)) {
                            this.kVw.kVr.kVf = true;
                            if (list.size() == 0) {
                                this.kVw.kVr.kID.kOz = context.getString(2131236178);
                            } else {
                                this.kVw.kVr.kID.kOz = context.getString(2131236179);
                            }
                            this.kVw.kVr.dismiss();
                            if (this.kVw.kVr.kUU != null) {
                                this.kVw.kVr.kUU.a(this.kVw.kVr.kUT.getText(), this.kVw.kVr.kID, this.kVw.kVr.kVf);
                                return;
                            }
                        }
                        if (this.kVw.kVr.kUW != null) {
                            this.kVw.kVr.kUW.setTag(this.kVw.kVr.kID);
                        }
                        com.tencent.mm.plugin.wallet.a.e Dn = this.kVw.kVr.kJf.Dn(this.kVw.kVr.kID.kOv);
                        if (Dn == null || Dn.kHI <= 0.0d) {
                            l = e.l(orders.kPn.kHy);
                            string = context.getString(2131236400);
                            str = null;
                            str2 = null;
                            str3 = l;
                        } else {
                            str = e.l(Dn.kHH);
                            str2 = e.l(orders.kPn.kHy);
                            str3 = str;
                            string = null;
                            str = Dn.kHK;
                        }
                        if (Dn == null || Dn.kHJ == 0) {
                            l = null;
                        } else {
                            l = Dn.kHL;
                            if (!be.kS(str)) {
                                l = "," + l;
                            }
                        }
                        if (be.kS(str) && be.kS(l)) {
                            str4 = string;
                        } else if (!be.kS(string)) {
                            str4 = "," + string;
                        }
                        this.kVw.kVr.Dw(str3);
                        this.kVw.kVr.Dy(str2);
                        this.kVw.kVr.cX(str, str4);
                        k kVar = this.kVw.kVr;
                        str = orders.hNg;
                        kVar.Dz(l);
                    }
                });
            }
        });
        Assert.assertNotNull(this.kJf);
        a aVar = this.kJf;
        String str = this.kID.kOv;
        if (aVar.kRJ.get(str) != null) {
            int i;
            ArrayList hk = com.tencent.mm.plugin.wallet_core.model.k.bga().hk(true);
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            for (i = 0; i < hk.size(); i++) {
                hashMap.put(((Bankcard) hk.get(i)).field_bankcardType, Integer.valueOf(0));
            }
            if (aVar.kRH.kHC != null) {
                for (i = 0; i < aVar.kRH.kHC.size(); i++) {
                    l lVar = (l) aVar.kRH.kHC.get(i);
                    if (lVar != null) {
                        if (!((lVar.kIk != 0 ? 1 : null) == null || hashMap.containsKey(lVar.kIl) || be.kS(lVar.kIl))) {
                            hashMap2.put(lVar.kHv, Integer.valueOf(0));
                        }
                    }
                }
            }
            double d = ((com.tencent.mm.plugin.wallet.a.e) aVar.kRJ.get(str)).kHI;
            if (!(aVar.kRH.kHD == null || aVar.kRH.kHD.kHM == null)) {
                List list = aVar.kRH.kHD.kHM;
                i = 0;
                while (i < list.size()) {
                    com.tencent.mm.plugin.wallet.a.e eVar = (com.tencent.mm.plugin.wallet.a.e) list.get(i);
                    if (eVar != null) {
                        String[] Do = a.Do(eVar.kHO);
                        for (int length = Do.length - 1; length >= 0; length--) {
                            if (hashMap2.containsKey(Do[length])) {
                                obj = 1;
                                v.v("MicroMsg.FavorLogicHelper", "hasNotSupportFavor favid:" + Do[length]);
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null && ((com.tencent.mm.plugin.wallet.a.e) list.get(i)).kHI > d) {
                            obj = 1;
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        obj = null;
        if (obj != null) {
            this.kUY.setVisibility(0);
        } else {
            this.kUY.setVisibility(8);
        }
    }

    public final void bhk() {
        if (this.kUN != null) {
            this.kVe = null;
            this.kUN.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ k kVr;

                {
                    this.kVr = r1;
                }

                public final void onClick(View view) {
                    this.kVr.bhl();
                }
            });
        }
    }

    public void bhl() {
        hp(false);
        if (this.kVe != null) {
            this.kVe.onClick(this, 0);
        }
        dismiss();
        if (this.kUU != null) {
            this.kUU.a(this.kUT.getText(), this.kID, this.kVf);
        }
    }

    public final void b(final OnCancelListener onCancelListener) {
        if (this.kUO != null) {
            this.Fe = onCancelListener;
            this.kUO.setVisibility(0);
            this.kUO.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ k kVr;

                public final void onClick(View view) {
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(null);
                    }
                    if (this.kVr.kVd != null) {
                        this.kVr.kVd.aEX();
                    }
                    this.kVr.cancel();
                    if (this.kVr.kVi.isShown()) {
                        g.iuh.h(11977, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                        return;
                    }
                    g.iuh.h(11977, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                }
            });
        }
    }

    public final void ho(boolean z) {
        if (z) {
            this.kUW.setVisibility(0);
        } else {
            this.kUW.setVisibility(8);
        }
    }

    public final void Dz(String str) {
        if (be.kS(str)) {
            this.kVa.setVisibility(8);
            return;
        }
        this.kVa.setText(str);
        this.kVa.setVisibility(0);
    }

    public static k a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        return a(context, true, orders, favorPayInfo, bankcard, payInfo, null, cVar, onClickListener, onCancelListener);
    }

    public static k a(Context context, boolean z, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, PayInfo payInfo, String str, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (orders == null || orders.kPm == null || orders.kPm.size() <= 0) {
            return null;
        }
        boolean z2;
        String au;
        List bgU;
        String string;
        String string2;
        String string3;
        String str2;
        String str3;
        String string4;
        String str4;
        a a = b.kRN.a(orders);
        if (a != null) {
            if (favorPayInfo != null && bankcard != null) {
                z2 = false;
                if (bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                    z2 = true;
                }
                au = a.au(favorPayInfo.kOv, z2);
                com.tencent.mm.plugin.wallet_core.ui.a.a aVar = (com.tencent.mm.plugin.wallet_core.ui.a.a) a.at(au, true).get(bankcard.field_bankcardType);
                if (aVar == null || aVar.kRK == null || be.kS(aVar.kRK.kHO)) {
                    favorPayInfo.kOv = au;
                } else {
                    favorPayInfo.kOv = aVar.kRK.kHO;
                }
            } else if (orders.kPn != null) {
                favorPayInfo = a.Dq(a.Dr(orders.kPn.kHB));
            }
            bgU = a.bgU();
        } else {
            v.d("MicroMsg.WalletPwdDialog", "getFavorLogicHelper null");
            bgU = null;
        }
        String str5 = "";
        if (payInfo.bkq == 32 || payInfo.bkq == 33) {
            string = payInfo.lVD.getString("extinfo_key_5", "");
            string2 = payInfo.lVD.getString("extinfo_key_1", "");
            string3 = context.getString(2131236403);
            if (be.kS(string)) {
                string = string3;
                string3 = str5;
            } else {
                string3 = string;
            }
            if (be.kS(string2)) {
                v.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
                str5 = string3;
            } else {
                ak.yW();
                u LV = com.tencent.mm.model.c.wH().LV(string2);
                if (LV != null) {
                    string3 = LV.tU();
                    str5 = be.g(string, new Object[]{e.PY(string3)});
                } else {
                    v.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + string2);
                    str5 = string3;
                }
            }
        } else if (payInfo.bkq == 31) {
            string = payInfo.lVD.getString("extinfo_key_1", "");
            if (be.kS(string)) {
                v.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            } else {
                ak.yW();
                r6 = com.tencent.mm.model.c.wH().LV(string);
                if (r6 != null) {
                    r7 = new Object[1];
                    r7[0] = r6.tT() + (be.kS(str) ? "" : "(" + str + ")");
                    str5 = context.getString(2131236403, r7);
                } else {
                    v.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + string);
                }
            }
        } else if (payInfo.bkq == 42) {
            string = payInfo.lVD.getString("extinfo_key_1", "");
            if (be.kS(string)) {
                v.e("MicroMsg.WalletPwdDialog", "userName is null ,scene is MMPAY_PAY_SCENE_TRANSFER");
            } else {
                ak.yW();
                r6 = com.tencent.mm.model.c.wH().LV(string);
                if (r6 != null) {
                    r7 = new Object[1];
                    r7[0] = r6.tT() + (be.kS(str) ? "" : "(" + str + ")");
                    str5 = context.getString(2131236398, r7);
                } else {
                    v.e("MicroMsg.WalletPwdDialog", "can not found contact for user::" + string);
                }
            }
        }
        if (!be.kS(str5) || orders == null || orders.kPm == null) {
            v.w("MicroMsg.WalletPwdDialog", "orders null?:" + (orders == null));
            str2 = str5;
        } else {
            Commodity commodity = (Commodity) orders.kPm.get(0);
            if (commodity != null) {
                string3 = commodity.hMV;
                Object obj = (payInfo == null || !(payInfo.bkq == 31 || payInfo.bkq == 32 || payInfo.bkq == 33)) ? null : 1;
                if (obj != null) {
                    if (!be.kS(string3)) {
                        string3 = string3 + "\n";
                    }
                    string3 = string3 + commodity.desc;
                }
                if (be.kS(string3)) {
                    string3 = commodity.desc;
                }
            } else {
                string3 = str5;
            }
            str2 = string3;
        }
        string2 = null;
        str5 = null;
        string = null;
        boolean z3 = false;
        if (a == null || favorPayInfo == null) {
            au = null;
            z2 = false;
            string3 = null;
            str5 = null;
            string2 = null;
            str3 = null;
        } else {
            com.tencent.mm.plugin.wallet.a.e Dn = a.Dn(favorPayInfo.kOv);
            if (Dn != null && Dn.kHI > 0.0d) {
                z3 = true;
                string2 = e.d(orders.kOU, orders.hNg);
                str3 = e.d(Dn.kHH, orders.hNg);
                str5 = Dn.kHK;
                au = null;
            } else if (bgU == null || bgU.size() <= 0) {
                str3 = e.d(orders.kOU, orders.hNg);
                au = null;
            } else {
                str3 = e.d(Dn.kHH, orders.hNg);
                z3 = true;
                au = context.getString(2131236400);
            }
            if (!(Dn == null || Dn.kHJ == 0)) {
                string = Dn.kHL;
                if (!be.kS(str5)) {
                    string = "," + string;
                }
            }
            boolean z4;
            if (be.kS(str5) && be.kS(string)) {
                z4 = z3;
                string3 = str5;
                str5 = string2;
                string2 = str3;
                str3 = au;
                au = string;
                z2 = z4;
            } else {
                if (be.kS(au)) {
                    au = null;
                } else {
                    au = "," + au;
                }
                z4 = z3;
                string3 = str5;
                str5 = string2;
                string2 = str3;
                str3 = au;
                au = string;
                z2 = z4;
            }
        }
        if (orders.iro > 0.0d) {
            Resources resources = context.getResources();
            Object[] objArr = new Object[1];
            objArr[0] = e.d(orders.iro, orders.hNg);
            string4 = resources.getString(2131236137, objArr);
        } else {
            string4 = null;
        }
        if (bankcard == null) {
            str4 = "";
        } else {
            str4 = bankcard.field_desc;
        }
        k kVar = new k(context);
        kVar.a(context, orders, favorPayInfo, bankcard);
        kVar.ho(z);
        kVar.kVg = z;
        kVar.bhk();
        kVar.b(new b(onCancelListener));
        kVar.setOnCancelListener(new b(onCancelListener));
        kVar.setCancelable(true);
        kVar.Dv(str2);
        kVar.Dw(string2);
        kVar.Dy(str5);
        kVar.a(str4, onClickListener, z2);
        kVar.e(bankcard);
        z2 = orders.kPk == 1;
        kVar.imN = payInfo;
        kVar.kVn = z2;
        if (!com.tencent.mm.model.k.xT()) {
            kVar.bhg();
        }
        kVar.cX(string3, str3);
        string = orders.hNg;
        kVar.Dz(au);
        kVar.Dx(string4);
        kVar.kUU = cVar;
        kVar.show();
        com.tencent.mm.ui.base.g.a(context, kVar);
        return kVar;
    }

    public static k a(Context context, String str, String str2, c cVar, OnCancelListener onCancelListener, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        return a(context, str, str2, "", cVar, onCancelListener, aVar);
    }

    public static k a(Context context, String str, String str2, String str3, c cVar, OnCancelListener onCancelListener, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        k kVar = new k(context);
        kVar.bhk();
        kVar.b(onCancelListener);
        kVar.setOnCancelListener(onCancelListener);
        kVar.setCancelable(true);
        kVar.Dv(str);
        kVar.Dw(str2);
        kVar.ho(false);
        kVar.kVg = false;
        kVar.kVd = aVar;
        kVar.Dx(str3);
        kVar.kUU = cVar;
        kVar.show();
        com.tencent.mm.ui.base.g.a(context, kVar);
        return kVar;
    }

    public static k a(Context context, String str, double d, String str2, Bankcard bankcard, c cVar, View.OnClickListener onClickListener, OnCancelListener onCancelListener) {
        boolean z = true;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        k kVar = new k(context);
        kVar.bhk();
        kVar.b(onCancelListener);
        kVar.setOnCancelListener(onCancelListener);
        kVar.setCancelable(true);
        kVar.Dv(str);
        kVar.Dw(e.d(d, str2));
        kVar.kVg = true;
        Object obj = bankcard == null ? "" : bankcard.field_desc;
        kVar.e(bankcard);
        if (TextUtils.isEmpty(obj)) {
            z = false;
        }
        kVar.ho(z);
        if (bankcard != null) {
            kVar.a(obj, onClickListener, false);
        }
        kVar.kUU = cVar;
        kVar.show();
        com.tencent.mm.ui.base.g.a(context, kVar);
        return kVar;
    }

    public final void bgV() {
        this.cOX = false;
        if (!com.tencent.mm.model.k.xT() && this.kVm == 1) {
            bhh();
        }
    }

    public final void bgW() {
        this.cOX = true;
        if (!com.tencent.mm.model.k.xT() && this.kVm == 1) {
            WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(536870913, "PostLocationService");
            if (newWakeLock != null) {
                newWakeLock.acquire();
            }
            bhi();
            if (newWakeLock != null) {
                newWakeLock.release();
            }
        }
    }

    private static void hp(boolean z) {
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nqb, Boolean.valueOf(z));
    }

    private static boolean bhm() {
        ak.yW();
        Object obj = com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nqb, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }
}
