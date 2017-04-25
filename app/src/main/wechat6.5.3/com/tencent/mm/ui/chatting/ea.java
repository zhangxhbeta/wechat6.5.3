package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.a.a.f;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.as.o.a.b;
import com.tencent.mm.as.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class ea extends com.tencent.mm.ui.chatting.ad.a {
    private static Map<String, WeakReference<ea>> okq = new HashMap();
    private static SparseArray<String> ozg = new SparseArray();
    private static OnClickListener ozh = new OnClickListener() {
        public final void onClick(View view) {
            a aVar = (a) view.getTag(f.Jm);
            if (aVar == null || aVar.bmk == null) {
                v.w("MicroMsg.ShortVideoItemHolder", "click error");
                return;
            }
            n lp = p.lp(aVar.bmk.field_imgPath);
            if (lp == null) {
                v.w("MicroMsg.ShortVideoItemHolder", "click %s, msg id %d, but videoinfo is null", aVar.bmk.field_imgPath, Long.valueOf(aVar.bmk.field_msgId));
            } else if (aVar.okg) {
                r2 = lp.status;
                v.i("MicroMsg.ShortVideoItemHolder", "on Click, info recv status: %d", Integer.valueOf(r2));
                int i = (int) aVar.bmk.field_msgId;
                if (r2 == 199) {
                    if (aVar.ozi.xg(i)) {
                        aVar.ozi.onh.oqh.onClick(view);
                        aVar.iWn.clear();
                        if (aVar.ozi.tM()) {
                            aVar.kmd.setVisibility(0);
                            aVar.kmd.setImageResource(2131165914);
                            ea.a(view.getContext(), aVar.iWn, aVar.bmk.field_imgPath);
                            aVar.iWn.fy(false);
                            aVar.ozi.xh(i);
                            return;
                        }
                        return;
                    }
                    aVar.kmd.setVisibility(8);
                    ea.a(aVar.iWn.aOZ(), aVar.iWn, aVar.bmk.field_imgPath);
                    k.KV();
                    String lc = o.lc(aVar.bmk.field_imgPath);
                    aVar.iWn.fy(true);
                    aVar.iWn.ag(lc, false);
                    aVar.ozi.xh(i);
                    a.a(com.tencent.mm.ui.chatting.a.a.PlayIcon, aVar.bmk);
                } else if (r2 != MMGIFException.D_GIF_ERR_IMAGE_DEFECT && r2 != 196) {
                    if (r2 == MMGIFException.D_GIF_ERR_EOF_TOO_SOON) {
                        p.ll(lp.getFileName());
                        aVar.iWn.fy(true);
                        if (!aVar.ozi.xg(i)) {
                            aVar.ozi.xh(i);
                        }
                    } else if (r2 == 198) {
                        p.ln(lp.getFileName());
                        aVar.iWn.fy(true);
                        if (!aVar.ozi.xg(i)) {
                            aVar.ozi.xh(i);
                        }
                    } else {
                        p.ll(aVar.bmk.field_imgPath);
                        aVar.iWn.fy(true);
                        if (!aVar.ozi.xg(i)) {
                            aVar.ozi.xh(i);
                        }
                    }
                }
            } else {
                r2 = lp.status;
                v.i("MicroMsg.ShortVideoItemHolder", "info send status: %d", Integer.valueOf(r2));
                if (r2 == MMGIFException.D_GIF_ERR_NO_SCRN_DSCR || r2 == MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
                    aVar.ozi.onh.oqh.onClick(view);
                } else if (r2 == MMGIFException.D_GIF_ERR_NO_IMAG_DSCR) {
                    p.lk(lp.getFileName());
                } else if (r2 == 198) {
                    p.lo(lp.getFileName());
                } else if (r2 == MMGIFException.D_GIF_ERR_NO_COLOR_MAP) {
                    aVar.ozi.onh.oqh.onClick(view);
                } else if (r2 != 196) {
                    int i2 = (int) aVar.bmk.field_msgId;
                    if (aVar.ozi.xg(i2)) {
                        aVar.iWn.clear();
                        aVar.ozi.onh.oqh.onClick(view);
                        if (aVar.ozi.tM()) {
                            aVar.kmd.setVisibility(0);
                            aVar.kmd.setImageResource(2131165914);
                            ea.a(view.getContext(), aVar.iWn, aVar.bmk.field_imgPath);
                            aVar.iWn.fy(false);
                            aVar.ozi.xh(i2);
                            return;
                        }
                        return;
                    }
                    aVar.kmd.setVisibility(8);
                    ea.a(aVar.iWn.aOZ(), aVar.iWn, aVar.bmk.field_imgPath);
                    k.KV();
                    String lc2 = o.lc(aVar.bmk.field_imgPath);
                    aVar.iWn.fy(true);
                    aVar.iWn.ag(lc2, false);
                    aVar.ozi.xh(i2);
                    a.a(com.tencent.mm.ui.chatting.a.a.PlayIcon, aVar.bmk);
                }
            }
        }
    };
    MMPinProgressBtn jzr;
    ImageView jzs;

    private static class a {
        at bmk;
        com.tencent.mm.plugin.sight.decode.a.a iWn;
        ImageView kmd;
        boolean okg;
        com.tencent.mm.ui.chatting.ChattingUI.a ozi;
    }

    static /* synthetic */ void a(Context context, com.tencent.mm.plugin.sight.decode.a.a aVar, String str) {
        ak.yW();
        if (c.isSDCardAvailable()) {
            k.KV();
            Bitmap a = com.tencent.mm.ae.n.GH().a(o.ld(str), com.tencent.mm.bd.a.getDensity(context), context, -1);
            aVar.aOW();
            aVar.s(a);
            return;
        }
        aVar.aOX();
    }

    public static boolean b(com.tencent.mm.as.o.a.a aVar) {
        if (aVar.dia != b.die) {
            return false;
        }
        final n lp = p.lp(aVar.aST);
        if (lp == null) {
            v.w("MicroMsg.ShortVideoItemHolder", "update status, filename %s, videoInfo not found", aVar.aST);
            return false;
        } else if (lp.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT && lp.status != MMGIFException.D_GIF_ERR_NO_SCRN_DSCR && lp.status != MMGIFException.D_GIF_ERR_NOT_GIF_FILE) {
            return false;
        } else {
            ad.o(new Runnable() {
                public final void run() {
                    WeakReference weakReference = (WeakReference) ea.okq.get(lp.getFileName());
                    if (weakReference == null) {
                        v.w("MicroMsg.ShortVideoItemHolder", "update status, filename %s, holder not found", lp.getFileName());
                        return;
                    }
                    ea eaVar = (ea) weakReference.get();
                    if (eaVar == null) {
                        v.w("MicroMsg.ShortVideoItemHolder", "update status, filename %s, holder gc!", lp.getFileName());
                        return;
                    }
                    eaVar.jzr.setVisibility(0);
                    eaVar.jzs.setVisibility(8);
                    if (lp.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                        eaVar.jzr.setProgress(p.f(lp));
                    } else {
                        eaVar.jzr.setProgress(p.g(lp));
                    }
                }
            });
            return true;
        }
    }
}
