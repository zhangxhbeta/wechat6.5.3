package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.as.k;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.as.o.a;
import com.tencent.mm.as.p;
import com.tencent.mm.model.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.FileUtils;
import java.util.HashMap;

public final class h extends a implements a, d.a, ah.a {
    private d iVr;
    private HashMap<String, i.a> oBy;
    private boolean oBz;

    public h(b bVar) {
        super(bVar);
        this.oBz = false;
        this.oBz = false;
        this.oBy = new HashMap();
        k.KV().a(this, Looper.getMainLooper());
        this.iVr = new d();
    }

    public final boolean a(j jVar, at atVar, int i) {
        super.a(jVar, atVar, i);
        k.KV();
        Bitmap c = b.c(o.ld(atVar.field_imgPath), 1.0f);
        if (this.oBy != null) {
            this.oBy.put(atVar.field_imgPath, new i.a(atVar, i));
        }
        a(jVar, false);
        ((View) jVar.bHe().oCR).setVisibility(8);
        jVar.bHe().oCS.setImageBitmap(c);
        jVar.bHe().oCS.setVisibility(0);
        jVar.bHe().oCV.setVisibility(8);
        n lp = p.lp(atVar.field_imgPath);
        jVar.oCV.setTag(lp);
        ayk com_tencent_mm_protocal_c_ayk = lp == null ? null : lp.dhT;
        if (com_tencent_mm_protocal_c_ayk == null) {
            jVar.fQK.setVisibility(8);
        } else if (t.kS(com_tencent_mm_protocal_c_ayk.cqg)) {
            v.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
            CharSequence charSequence = com_tencent_mm_protocal_c_ayk.cqj;
            String str = com_tencent_mm_protocal_c_ayk.cqk;
            if (be.kS(charSequence) || be.kS(str)) {
                jVar.fQK.setVisibility(8);
            } else {
                jVar.fQK.setText(charSequence);
                jVar.fQK.setVisibility(0);
                jVar.fQK.setTag(atVar);
            }
        } else {
            jVar.fQK.setVisibility(0);
            jVar.fQK.setText(this.ozG.ozH.getString(2131235359, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ayk.mtD)}));
            String string = this.ozG.ozH.getString(2131235359);
            if (com_tencent_mm_protocal_c_ayk.mtD / 60 > 0) {
                string = string + this.ozG.ozH.getString(2131235361, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ayk.mtD / 60)});
            }
            if (com_tencent_mm_protocal_c_ayk.mtD % 60 > 0) {
                string = string + this.ozG.ozH.getString(2131235362, new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ayk.mtD % 60)});
            }
            jVar.fQK.setText(string + this.ozG.ozH.getString(2131235360));
            jVar.fQK.setTag(atVar);
        }
        if (jVar.bHe().oCR instanceof VideoSightView) {
            com.tencent.mm.pluginsdk.ui.tools.n.a(jVar.fQK, (VideoSightView) jVar.bHe().oCR);
        }
        return true;
    }

    public final void bGF() {
        SparseArray sparseArray = this.ozG.nZE;
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                j jVar = (j) ((View) sparseArray.get(keyAt)).getTag();
                if (jVar.oCQ != null && jVar.bHe().oCQ.getVisibility() == 0) {
                    jVar.bHe().oCR.a(null);
                    if (((View) jVar.bHe().oCR).getVisibility() == 0 && jVar != null) {
                        a(jVar, false);
                        if (jVar.bHe().oCR != null) {
                            jVar.bHe().oCR.stop();
                        }
                        v.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
                        this.iVr.aN(false);
                        this.ozG.ozH.nDR.nEl.getWindow().clearFlags(FileUtils.S_IWUSR);
                    }
                }
            }
        }
    }

    public final void xI(int i) {
        at xs = this.ozG.xs(i);
        j xq = xq(i);
        if (xs != null && xq != null) {
            n lp = p.lp(xs.field_imgPath);
            if (lp != null) {
                if (xs.field_isSend == 0) {
                    if (lp.status == MMGIFException.D_GIF_ERR_EOF_TOO_SOON || lp.status == MMGIFException.D_GIF_ERR_NOT_READABLE || lp.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                        a(lp, xq);
                        return;
                    } else if (lp.status == 198) {
                        a(lp, xq);
                        return;
                    }
                }
                a(xs, xq);
            }
        }
    }

    private void a(n nVar, j jVar) {
        if (nVar != null) {
            p.ln(nVar.getFileName());
            jVar.bHe().oCU.setVisibility(0);
            jVar.bHe().oCU.setProgress(p.f(nVar));
            k.KV().a(this, Looper.getMainLooper());
        }
    }

    private void a(at atVar, final j jVar) {
        if (!this.oBz) {
            jVar.bHe().oCV.setVisibility(8);
            k.KV();
            String lc = o.lc(atVar.field_imgPath);
            if (atVar.bwv()) {
                Toast.makeText(this.ozG.ozH, 2131235790, 0).show();
            } else if (lc == null || !e.aR(lc)) {
                Toast.makeText(this.ozG.ozH, 2131235790, 0).show();
            } else {
                this.ozG.ozH.nDR.nEl.getWindow().addFlags(FileUtils.S_IWUSR);
                Boolean bool = (Boolean) jVar.oCP.get(lc);
                if (bool == null || !bool.booleanValue()) {
                    ((View) jVar.bHe().oCR).setTag(lc);
                    jVar.bHe().oCT.setVisibility(8);
                    jVar.bHe().oCR.stop();
                    if (this.ozG.ozH.eD(atVar.field_msgId) == 3) {
                        jVar.bHe().oCR.dJ(true);
                    } else {
                        jVar.bHe().oCR.dJ(false);
                    }
                    jVar.bHe().oCR.setVideoPath(lc);
                    if (jVar.bHe().oCR.h(this.ozG.ozH.nDR.nEl, false)) {
                        ((View) jVar.bHe().oCR).setVisibility(0);
                        jVar.bHe().oCS.setVisibility(8);
                    } else {
                        jVar.bHe().oCT.setVisibility(0);
                        jVar.bHe().oCT.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ h oBB;

                            public final void onClick(View view) {
                                jVar.bHe().oCR.h(this.oBB.ozG.ozH.nDR.nEl, true);
                            }
                        });
                        ((View) jVar.bHe().oCR).setVisibility(8);
                        jVar.bHe().oCS.setVisibility(0);
                    }
                    v.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
                    this.iVr.a(this);
                }
                ((View) jVar.bHe().oCR).setVisibility(0);
            }
        }
    }

    private static void a(j jVar, boolean z) {
        if (jVar != null) {
            jVar.bHe().oCU.setVisibility(8);
            if (z) {
                jVar.bHe().oCS.setVisibility(8);
                ((View) jVar.bHe().oCR).setVisibility(0);
                return;
            }
            jVar.bHe().oCS.setVisibility(0);
            ((View) jVar.bHe().oCR).setVisibility(8);
        }
    }

    public final boolean oU() {
        if (this.ozG != null) {
            j bGu = this.ozG.bGu();
            if (!(bGu == null || bGu.oCQ == null || bGu.bHe().oCQ.getVisibility() != 0)) {
                a(bGu, true);
            }
        }
        return false;
    }

    private boolean a(i.a aVar) {
        if (aVar == null) {
            return false;
        }
        k.KV().a((a) this);
        if (this.ozG.ozH.bGP() == aVar.pos) {
            j xq = xq(aVar.pos);
            if (xq != null) {
                xq.bHe().oCU.setVisibility(8);
            }
            return true;
        }
        this.ozG.xz(aVar.pos);
        return false;
    }

    public final void detach() {
        bGF();
        this.ozG.ozH.nDR.nEl.getWindow().clearFlags(FileUtils.S_IWUSR);
        this.oBz = true;
        super.detach();
        this.oBy.clear();
        this.oBy = null;
        k.KV().a((a) this);
        v.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
        this.iVr.aN(true);
    }

    public final void a(a.a aVar) {
        String str = aVar.aST;
        if (!t.kS(str) && this.oBy != null) {
            i.a aVar2 = (i.a) this.oBy.get(str);
            if (aVar2 != null) {
                at atVar = aVar2.aXd;
                if (atVar != null && atVar.field_imgPath != null && atVar.field_imgPath.equals(str)) {
                    n lp = p.lp(atVar.field_imgPath);
                    if (lp == null) {
                        return;
                    }
                    if (!atVar.bwv() && lp.status != 198) {
                        int f = p.f(lp);
                        j xq = xq(aVar2.pos);
                        if (this.ozG.ozH.bGP() == aVar2.pos && xq != null) {
                            xq.bHe().oCU.setVisibility(0);
                            xq.bHe().oCU.setProgress(f);
                        } else if (xq == null) {
                            return;
                        }
                        if (f >= xq.bHf().oCU.pcv && a(aVar2)) {
                            a(atVar, xq);
                        }
                    } else if (a(aVar2)) {
                        Toast.makeText(this.ozG.ozH, 2131235790, 0).show();
                    }
                }
            }
        }
    }
}
