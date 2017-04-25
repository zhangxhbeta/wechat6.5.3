package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.as.o.a.b;
import com.tencent.mm.as.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ad.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class ee extends a {
    private static Map<String, WeakReference<ee>> okq = new HashMap();
    private static SparseArray<String> ozg = new SparseArray();
    TextView iem;
    ImageView jzs;
    ImageView okF;
    ImageView okG;
    ImageView okl;
    ImageView okm;
    TextView oks;
    ImageView oxM;
    TextView ozj;
    MMPinProgressBtn ozk;
    View ozl;
    ProgressBar ozm;

    public static boolean b(o.a.a aVar) {
        if (aVar.dia != b.die) {
            return false;
        }
        final n lp = p.lp(aVar.aST);
        if (lp == null) {
            v.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", aVar.aST);
            return false;
        } else if (lp.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT && lp.status != MMGIFException.D_GIF_ERR_NO_SCRN_DSCR && lp.status != MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
            return false;
        } else {
            ad.o(new Runnable() {
                public final void run() {
                    WeakReference weakReference = (WeakReference) ee.okq.get(lp.getFileName());
                    if (weakReference == null) {
                        v.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", lp.getFileName());
                        return;
                    }
                    ee eeVar = (ee) weakReference.get();
                    if (eeVar == null) {
                        v.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", lp.getFileName());
                        return;
                    }
                    eeVar.okG.setVisibility(0);
                    eeVar.okF.setVisibility(8);
                    eeVar.jzs.setVisibility(8);
                    eeVar.ozk.setVisibility(0);
                    int i = lp.status;
                    v.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : " + i);
                    if (i == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || i == 122 || i == 120) {
                        eeVar.ozk.setProgress(p.f(lp));
                    } else {
                        eeVar.ozk.setProgress(p.g(lp));
                    }
                }
            });
            return true;
        }
    }

    public ee(int i) {
        super(i);
    }

    public final a o(View view, boolean z) {
        ImageView imageView;
        ProgressBar progressBar;
        super.cM(view);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.okl = (ImageView) view.findViewById(2131756186);
        this.iJL = (TextView) view.findViewById(2131755341);
        this.iem = (TextView) view.findViewById(2131756188);
        this.ozj = (TextView) view.findViewById(2131756224);
        this.jzs = (ImageView) view.findViewById(2131756189);
        this.okF = (ImageView) view.findViewById(2131756178);
        this.okG = (ImageView) view.findViewById(2131756177);
        this.ozk = (MMPinProgressBtn) view.findViewById(2131756187);
        this.ozl = view.findViewById(2131756223);
        this.onC = view.findViewById(2131756148);
        this.type = z ? 10 : 11;
        this.oks = (TextView) view.findViewById(2131756107);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.oxM = (ImageView) view.findViewById(2131756176);
        if (z) {
            imageView = null;
        } else {
            imageView = (ImageView) view.findViewById(2131756258);
        }
        this.okm = imageView;
        if (z) {
            progressBar = null;
        } else {
            progressBar = (ProgressBar) view.findViewById(2131756267);
        }
        this.ozm = progressBar;
        return this;
    }

    public static void a(ee eeVar, at atVar, boolean z, int i, ChattingUI.a aVar, int i2) {
        int fromDPToPix;
        String str = (String) ozg.get(eeVar.hashCode());
        if (str != null) {
            okq.remove(str);
        }
        ozg.put(eeVar.hashCode(), atVar.field_imgPath);
        okq.put(atVar.field_imgPath, new WeakReference(eeVar));
        n lp = p.lp(atVar.field_imgPath);
        if (lp == null) {
            lp = new n();
        }
        k.KV();
        Bitmap a = com.tencent.mm.ae.n.GH().a(o.ld(atVar.field_imgPath), com.tencent.mm.bd.a.getDensity(aVar.nDR.nEl), aVar.nDR.nEl, i2);
        eeVar.oxM.setLayoutParams(new LayoutParams(0, 0));
        if (a == null) {
            fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, 85);
            int N = com.tencent.mm.bd.a.N(aVar.nDR.nEl, 2131492982);
            Bitmap a2 = d.a(d.Q(aVar.nDR.nEl.getResources().getColor(2131689779), fromDPToPix, N), i2, fromDPToPix, N);
            ak.yW();
            if (c.isSDCardAvailable()) {
                eeVar.okl.setImageBitmap(d.a(a2, i2, fromDPToPix, N));
            } else {
                eeVar.okl.setImageDrawable(com.tencent.mm.bd.a.a(aVar.nDR.nEl, 2131165999));
                eeVar.okl.setBackground(new BitmapDrawable(a2));
            }
            eeVar.oxM.setLayoutParams(new LayoutParams(fromDPToPix, N));
        } else {
            eeVar.okl.setImageBitmap(a);
            eeVar.oxM.setLayoutParams(new LayoutParams(a.getWidth(), a.getHeight()));
        }
        if (z) {
            eeVar.iem.setText(t.aw((long) lp.cyu));
            eeVar.ozj.setText(t.gH(lp.dhK));
            fromDPToPix = lp.status;
            v.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + fromDPToPix + " info : " + lp.getFileName());
            if (fromDPToPix == 199) {
                eeVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(aVar.nDR.nEl, 2131165914));
            } else {
                eeVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(aVar.nDR.nEl, 2131165914));
                eeVar.iem.setVisibility(8);
            }
            if (fromDPToPix == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || fromDPToPix == 122 || fromDPToPix == 120) {
                eeVar.okG.setVisibility(0);
                eeVar.okF.setVisibility(8);
                eeVar.jzs.setVisibility(8);
                eeVar.ozk.setVisibility(0);
                eeVar.ozk.setProgress(p.f(lp));
                v.v("MicroMsg.VideoItemHoder", "status begin");
                eeVar.ozk.invalidate();
            } else if (fromDPToPix == MMGIFException.D_GIF_ERR_EOF_TOO_SOON || fromDPToPix == 198) {
                eeVar.okF.setVisibility(0);
                eeVar.okG.setVisibility(8);
                eeVar.ozk.setVisibility(8);
                eeVar.jzs.setVisibility(0);
                v.v("MicroMsg.VideoItemHoder", "status pause");
            } else {
                eeVar.okG.setVisibility(8);
                eeVar.okF.setVisibility(8);
                eeVar.ozk.setVisibility(8);
                eeVar.jzs.setVisibility(0);
                v.v("MicroMsg.VideoItemHoder", "status gone");
            }
        } else {
            eeVar.iem.setText(t.aw((long) lp.cyu));
            eeVar.ozj.setText(t.gH(lp.dhK));
            fromDPToPix = lp.status;
            eeVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(aVar.nDR.nEl, 2131165914));
            if (eeVar.ozm != null) {
                eeVar.ozm.setVisibility(8);
            }
            v.v("MicroMsg.VideoItemHoder", "video status %d", Integer.valueOf(fromDPToPix));
            if (fromDPToPix == MMGIFException.D_GIF_ERR_NO_SCRN_DSCR || fromDPToPix == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                if (i.tx(lp.dhL)) {
                    if (eeVar.ozm != null) {
                        eeVar.ozm.setVisibility(0);
                    }
                    eeVar.ozj.setText(null);
                    eeVar.iem.setText(null);
                    eeVar.jzs.setImageDrawable(null);
                    eeVar.okG.setVisibility(8);
                    eeVar.okF.setVisibility(8);
                    eeVar.ozk.setVisibility(8);
                } else {
                    eeVar.ozm.setVisibility(8);
                    eeVar.okG.setVisibility(0);
                    eeVar.okF.setVisibility(8);
                    eeVar.jzs.setVisibility(8);
                    eeVar.ozk.setVisibility(0);
                    eeVar.ozk.setProgress(p.g(lp));
                }
                v.v("MicroMsg.VideoItemHoder", "status begin");
            } else if (fromDPToPix == MMGIFException.D_GIF_ERR_NO_IMAG_DSCR || fromDPToPix == 198) {
                eeVar.okF.setVisibility(0);
                eeVar.okG.setVisibility(8);
                eeVar.ozk.setVisibility(8);
                eeVar.jzs.setVisibility(0);
                v.v("MicroMsg.VideoItemHoder", "status pause");
            } else if (fromDPToPix != MMGIFException.D_GIF_ERR_NO_COLOR_MAP) {
                eeVar.okG.setVisibility(8);
                eeVar.okF.setVisibility(8);
                eeVar.ozk.setVisibility(8);
                eeVar.jzs.setVisibility(0);
                v.v("MicroMsg.VideoItemHoder", "status gone");
            } else if (h.Gq(atVar.field_imgPath)) {
                if (eeVar.ozm != null) {
                    eeVar.ozm.setVisibility(0);
                }
                eeVar.ozj.setText(null);
                eeVar.iem.setText(null);
                eeVar.jzs.setImageDrawable(null);
                eeVar.okG.setVisibility(8);
                eeVar.okF.setVisibility(8);
                eeVar.ozk.setVisibility(8);
            } else {
                p.lh(atVar.field_imgPath);
            }
        }
        eeVar.okG.setTag(new dl(atVar, aVar.nQK, i, atVar.field_talker, 4, (byte) 0));
        eeVar.okG.setOnClickListener(aVar.onh.oqh);
        eeVar.okF.setTag(new dl(atVar, aVar.nQK, i, atVar.field_talker, 3, (byte) 0));
        eeVar.okF.setOnClickListener(aVar.onh.oqh);
        eeVar.onC.setTag(new dl(atVar, aVar.nQK, i, atVar.field_talker, 2, (byte) 0));
        eeVar.onC.setOnClickListener(aVar.onh.oqh);
        eeVar.onC.setOnLongClickListener(aVar.onh.oqj);
    }
}
