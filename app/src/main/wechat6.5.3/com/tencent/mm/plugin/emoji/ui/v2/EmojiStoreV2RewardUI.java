package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.a.c.i;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.ui.GridInScrollView;
import com.tencent.mm.protocal.c.oj;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Collection;
import java.util.LinkedList;

public class EmojiStoreV2RewardUI extends MMActivity implements OnItemClickListener, e {
    private ProgressDialog eZg;
    private String fdK;
    private int fdc;
    private String fdi;
    private Button fiH;
    private vv fii;
    private AnimationDrawable foL;
    private int foO;
    private EmojiStoreV2RewardBannerView foP;
    private GridInScrollView foQ;
    private View foR;
    private View foS;
    private MMFormInputView foT;
    private TextView foU;
    private TextView foV;
    private b foW;
    private com.tencent.mm.plugin.emoji.e.b foX;
    private int foY = a.fpf;
    private boolean foZ = false;
    private OnClickListener fpa = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2RewardUI fpd;

        {
            this.fpd = r1;
        }

        public final void onClick(View view) {
            if (this.fpd.foW != null) {
                oj ke = this.fpd.foW.ke(0);
                if (this.fpd.foT.getText() != null) {
                    ke.mqA = this.fpd.foT.getText().toString();
                    this.fpd.a(this.fpd.fdK, ke);
                    return;
                }
                v.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
                return;
            }
            v.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
        }
    };
    private OnClickListener fpb = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2RewardUI fpd;

        {
            this.fpd = r1;
        }

        public final void onClick(View view) {
            if (this.fpd.foY == a.fpf) {
                this.fpd.kd(a.fpg);
            }
        }
    };
    private TextWatcher fpc = new TextWatcher(this) {
        final /* synthetic */ EmojiStoreV2RewardUI fpd;

        {
            this.fpd = r1;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.fpd.fiH != null) {
                if (editable != null && editable.length() > 0) {
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    if (indexOf > 0 && (obj.length() - indexOf) - 1 > 2) {
                        editable.delete(indexOf + 3, indexOf + 4);
                    }
                    float f = 0.0f;
                    try {
                        f = Float.valueOf(editable.toString()).floatValue();
                    } catch (NumberFormatException e) {
                    }
                    if (f > 200.0f || f < 1.0f) {
                        this.fpd.foT.idd.setTextColor(this.fpd.nDR.nEl.getResources().getColor(2131689960));
                    } else {
                        this.fpd.foT.idd.setTextColor(this.fpd.nDR.nEl.getResources().getColor(2131689909));
                        this.fpd.fiH.setEnabled(true);
                        return;
                    }
                }
                this.fpd.fiH.setEnabled(false);
            }
        }
    };
    private ac mHandler = new ac(this) {
        final /* synthetic */ EmojiStoreV2RewardUI fpd;

        {
            this.fpd = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    String str = (String) message.obj;
                    if (be.kS(str) || !com.tencent.mm.a.e.aR(str)) {
                        v.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
                        return;
                    }
                    this.fpd.foP.bN(str, null);
                    this.fpd.foP.setScaleType(ScaleType.FIT_XY);
                    if (this.fpd.foL != null && this.fpd.foL.isRunning()) {
                        this.fpd.foL.stop();
                        return;
                    }
                    return;
                case 1002:
                    this.fpd.av();
                    return;
                default:
                    return;
            }
        }
    };

    private enum a {
        ;

        static {
            fpf = 1;
            fpg = 2;
            fph = new int[]{fpf, fpg};
        }
    }

    class b extends BaseAdapter {
        LinkedList<oj> foE;
        final /* synthetic */ EmojiStoreV2RewardUI fpd;

        b(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
            this.fpd = emojiStoreV2RewardUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return ke(i);
        }

        public final int getCount() {
            return this.foE == null ? 0 : this.foE.size();
        }

        public final oj ke(int i) {
            if (i < 0 || i > getCount() || this.foE == null) {
                return null;
            }
            return (oj) this.foE.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = q.em(this.fpd.nDR.nEl).inflate(2130903506, null);
                cVar = new c(this.fpd, view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            oj ke = ke(i);
            if (ke != null) {
                cVar.fpi.setVisibility(0);
                cVar.fpi.setText(ke.mqA + ke.gnz);
            } else {
                cVar.fpi.setVisibility(8);
            }
            return view;
        }
    }

    class c {
        final /* synthetic */ EmojiStoreV2RewardUI fpd;
        TextView fpi;

        public c(EmojiStoreV2RewardUI emojiStoreV2RewardUI, View view) {
            this.fpd = emojiStoreV2RewardUI;
            this.fpi = (TextView) view.findViewById(2131756722);
        }
    }

    static /* synthetic */ void i(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        emojiStoreV2RewardUI.foY = a.fpf;
        if (emojiStoreV2RewardUI.foS != null) {
            emojiStoreV2RewardUI.foS.setVisibility(8);
            emojiStoreV2RewardUI.foR.setVisibility(0);
            emojiStoreV2RewardUI.foS.startAnimation(AnimationUtils.loadAnimation(emojiStoreV2RewardUI.nDR.nEl, 2130968642));
        }
    }

    protected final int getLayoutId() {
        return 2130903508;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fdK = getIntent().getStringExtra("extra_id");
        this.fdi = getIntent().getStringExtra("name");
        this.fdc = getIntent().getIntExtra("scene", 0);
        this.foO = getIntent().getIntExtra("pageType", 0);
        NI();
        this.fii = g.afx().fcm.NL(this.fdK);
        if (this.fii == null || this.fii.myv == null) {
            cG(false);
        } else {
            n.GL().a(this.fii.myv.mqE, null, com.tencent.mm.plugin.emoji.d.g.c(this.fdK, this.fii.myv.mqE, new Object[0]));
            n.GL().a(this.fii.myv.mqF, null, com.tencent.mm.plugin.emoji.d.g.c(this.fdK, this.fii.myv.mqF, new Object[0]));
        }
        av();
        ak.vy().a(830, this);
        ak.vy().a(822, this);
        com.tencent.mm.plugin.report.service.g.iuh.a(408, 0, 1, false);
    }

    protected void onDestroy() {
        ak.vy().b(830, this);
        ak.vy().b(822, this);
        if (this.foL != null && this.foL.isRunning()) {
            this.foL.stop();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        v.i("MicroMsg.emoji.EmojiStoreV2RewardUI", this.nDR.nEB);
        if (this.foY == a.fpf) {
            if (this.foZ) {
                com.tencent.mm.plugin.report.service.g.iuh.a(408, 2, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.a(408, 1, 1, false);
                com.tencent.mm.plugin.report.service.g.iuh.h(12738, new Object[]{this.fdK, Integer.valueOf(this.foO), Integer.valueOf(this.fdc), Integer.valueOf(4)});
            }
            super.onBackPressed();
            return;
        }
        kd(a.fpf);
    }

    private void kd(int i) {
        if (i == a.fpg) {
            this.foY = a.fpg;
            if (this.foS != null) {
                this.foS.setVisibility(0);
                this.foS.startAnimation(AnimationUtils.loadAnimation(this.nDR.nEl, 2130968641));
                this.foT.idd.requestFocus();
                aJs();
                this.foR.setVisibility(8);
                return;
            }
            return;
        }
        axg();
        this.mHandler.postDelayed(new Runnable(this) {
            final /* synthetic */ EmojiStoreV2RewardUI fpd;

            {
                this.fpd = r1;
            }

            public final void run() {
                EmojiStoreV2RewardUI.i(this.fpd);
            }
        }, 300);
    }

    protected final void NI() {
        if (be.kS(this.fdi)) {
            vD(2131232395);
        } else {
            Fd(getString(2131232409, new Object[]{this.fdi}));
        }
        vE(2131236646);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2RewardUI fpd;

            {
                this.fpd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fpd.onBackPressed();
                return true;
            }
        });
        this.foR = findViewById(2131756728);
        this.foS = findViewById(2131756732);
        this.foT = (MMFormInputView) findViewById(2131756733);
        this.fiH = (Button) findViewById(2131756734);
        this.fiH.setOnClickListener(this.fpa);
        this.fiH.setEnabled(false);
        this.foT.setInputType(8194);
        this.foT.addTextChangedListener(this.fpc);
        this.foT.idd.setFilters(new InputFilter[]{new LengthFilter(12)});
        this.foU = (TextView) findViewById(2131756731);
        this.foU.setOnClickListener(this.fpb);
        this.foV = (TextView) findViewById(2131756730);
        this.foP = (EmojiStoreV2RewardBannerView) findViewById(2131756729);
        this.foQ = (GridInScrollView) findViewById(16908298);
        this.foW = new b(this);
        this.foQ.setAdapter(this.foW);
        this.foQ.setOnItemClickListener(this);
        this.foL = (AnimationDrawable) getResources().getDrawable(2130838147);
    }

    private void av() {
        if (this.fii != null) {
            this.foU.setVisibility(0);
            this.foV.setVisibility(0);
            if (this.fii.myv == null || be.kS(this.fii.myv.mqD)) {
                this.foP.setBackgroundDrawable(getResources().getDrawable(2130839570));
                this.foP.setImageDrawable(this.foL);
                this.foP.setScaleType(ScaleType.CENTER);
                this.foL.start();
            } else {
                final String str = this.fii.myv.mqD;
                ak.yW();
                final String z = EmojiLogic.z(com.tencent.mm.model.c.wY(), this.fdK, str);
                if (com.tencent.mm.a.e.aR(z)) {
                    this.foP.bN(z, null);
                    this.foP.setScaleType(ScaleType.FIT_XY);
                    if (this.foL != null && this.foL.isRunning()) {
                        this.foL.stop();
                    }
                } else {
                    n.GL().a(str, this.foP, com.tencent.mm.plugin.emoji.d.g.c(this.fdK, str, new Object[0]), new i(this) {
                        final /* synthetic */ EmojiStoreV2RewardUI fpd;

                        public final void a(String str, Bitmap bitmap, Object... objArr) {
                            if (!be.kS(str) && str.equalsIgnoreCase(str)) {
                                Message message = new Message();
                                message.what = 1001;
                                message.obj = z;
                                this.fpd.mHandler.sendMessage(message);
                            }
                        }
                    });
                    this.foP.setBackgroundDrawable(getResources().getDrawable(2130839570));
                    this.foP.setImageDrawable(this.foL);
                    this.foP.setScaleType(ScaleType.CENTER);
                    this.foL.start();
                }
            }
        } else {
            this.foU.setVisibility(8);
            this.foV.setVisibility(8);
        }
        if (this.fii == null || this.fii.myu == null) {
            this.foQ.setVisibility(8);
            return;
        }
        this.foQ.setVisibility(0);
        b bVar = this.foW;
        Collection collection = this.fii.myu;
        if (bVar.foE == null) {
            bVar.foE = new LinkedList();
        }
        bVar.foE.clear();
        bVar.foE.addAll(collection);
        bVar.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.foW != null) {
            oj ke = this.foW.ke(i);
            if (ke != null) {
                v.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "onItemClick position:%d", new Object[]{Integer.valueOf(i)});
                a(this.fdK, ke);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 8001:
                if (i2 == -1) {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, EmojiStoreV2RewardThanksUI.class);
                    intent2.putExtra("extra_id", this.fdK);
                    startActivity(intent2);
                    com.tencent.mm.plugin.report.service.g.iuh.h(12738, new Object[]{this.fdK, Integer.valueOf(this.foO), Integer.valueOf(this.fdc), Integer.valueOf(1)});
                    com.tencent.mm.plugin.report.service.g.iuh.a(408, 9, 1, false);
                    cG(true);
                    finish();
                    return;
                } else if (i2 == 0) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(12738, new Object[]{this.fdK, Integer.valueOf(this.foO), Integer.valueOf(this.fdc), Integer.valueOf(3)});
                    com.tencent.mm.plugin.report.service.g.iuh.a(408, 3, 1, false);
                    return;
                } else {
                    if (!this.foZ) {
                        this.foZ = true;
                        com.tencent.mm.plugin.report.service.g.iuh.h(12738, new Object[]{this.fdK, Integer.valueOf(this.foO), Integer.valueOf(this.fdc), Integer.valueOf(2)});
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.a(408, 4, 1, false);
                    return;
                }
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
        switch (kVar.getType()) {
            case 822:
                com.tencent.mm.plugin.emoji.e.n nVar = (com.tencent.mm.plugin.emoji.e.n) kVar;
                if (i == 0 && i2 == 0) {
                    v.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward success.");
                    this.fii = nVar.afR();
                    n.GL().a(this.fii.myv.mqE, null, com.tencent.mm.plugin.emoji.d.g.c(this.fdK, this.fii.myv.mqE, new Object[0]));
                    this.mHandler.sendEmptyMessage(1002);
                    return;
                }
                v.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "update emotion reward failed.");
                return;
            case 830:
                com.tencent.mm.plugin.emoji.e.b bVar = (com.tencent.mm.plugin.emoji.e.b) kVar;
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.pluginsdk.wallet.e.a(this.nDR.nEl, bVar.afI().mdO, bVar.afI().gkz, 5, 8001);
                    return;
                } else if (i == 4) {
                    if (!this.foZ) {
                        this.foZ = true;
                        com.tencent.mm.plugin.report.service.g.iuh.h(12738, new Object[]{this.fdK, Integer.valueOf(this.foO), Integer.valueOf(this.fdc), Integer.valueOf(2)});
                    }
                    if (i2 == com.tencent.mm.plugin.emoji.e.b.fdH) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(408, 6, 1, false);
                        if (be.kS(str)) {
                            rI(getString(2131232400));
                            return;
                        } else {
                            rI(str);
                            return;
                        }
                    } else if (i2 == com.tencent.mm.plugin.emoji.e.b.fdI) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(408, 7, 1, false);
                        if (be.kS(str)) {
                            rI(getString(2131232402));
                            return;
                        } else {
                            rI(str);
                            return;
                        }
                    } else if (i2 == com.tencent.mm.plugin.emoji.e.b.fdJ) {
                        com.tencent.mm.plugin.report.service.g.iuh.a(408, 5, 1, false);
                        if (be.kS(str)) {
                            rI(getString(2131232401));
                            return;
                        } else {
                            rI(str);
                            return;
                        }
                    } else {
                        com.tencent.mm.plugin.report.service.g.iuh.a(408, 8, 1, false);
                        Toast.makeText(this, getString(2131232368), 0).show();
                        return;
                    }
                } else {
                    if (!this.foZ) {
                        this.foZ = true;
                        com.tencent.mm.plugin.report.service.g.iuh.h(12738, new Object[]{this.fdK, Integer.valueOf(this.foO), Integer.valueOf(this.fdc), Integer.valueOf(2)});
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.a(408, 8, 1, false);
                    Toast.makeText(this, getString(2131232368), 0).show();
                    return;
                }
            default:
                v.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "unknown scene. type:%d", new Object[]{Integer.valueOf(kVar.getType())});
                return;
        }
    }

    private void a(String str, oj ojVar) {
        ags();
        this.foX = new com.tencent.mm.plugin.emoji.e.b(str, ojVar);
        ak.vy().a(this.foX, 0);
    }

    private void ags() {
        getString(2131231164);
        this.eZg = com.tencent.mm.ui.base.g.a(this, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ EmojiStoreV2RewardUI fpd;

            {
                this.fpd = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(this.fpd.foX);
            }
        });
    }

    private void rI(String str) {
        com.tencent.mm.ui.base.g.a(this.nDR.nEl, str, null, getString(2131232363), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ EmojiStoreV2RewardUI fpd;

            {
                this.fpd = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void cG(boolean z) {
        v.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "doGetRewardScene");
        if (z) {
            ak.vy().a(new com.tencent.mm.plugin.emoji.e.n(this.fdK, com.tencent.mm.plugin.emoji.e.n.fep), 0);
            return;
        }
        ak.vy().a(new com.tencent.mm.plugin.emoji.e.n(this.fdK, com.tencent.mm.plugin.emoji.e.n.feq), 0);
        ags();
    }

    protected final int NO() {
        return 1;
    }
}
