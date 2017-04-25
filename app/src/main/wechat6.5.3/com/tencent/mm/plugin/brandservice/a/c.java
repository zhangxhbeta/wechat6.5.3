package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.e.a.aa;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.afv;
import com.tencent.mm.protocal.c.hy;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class c {

    private static class a implements e {
        private String aXp;
        private long aXq;
        private boolean aXr;
        private Context context;
        private aa exk;
        private int fromScene;
        private int offset;
        private String title;

        public a(Context context, String str, long j, int i, int i2, String str2, boolean z, aa aaVar) {
            this.context = context;
            this.aXp = str;
            this.aXq = j;
            this.offset = i;
            this.fromScene = i2;
            this.title = str2;
            this.aXr = z;
            this.exk = aaVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i != 0 || i2 != 0) {
                cc(false);
            } else if (kVar == null) {
                v.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
                cc(false);
            } else if (kVar.getType() != 1071) {
                v.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
            } else {
                v.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
                hy Ym = ((h) kVar).Ym();
                if (Ym == null || Ym.miT == null) {
                    v.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
                    cc(false);
                    return;
                }
                v.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", new Object[]{Ym.miU});
                Intent intent = new Intent(this.context, BizSearchDetailPageUI.class);
                intent.putExtra("addContactScene", 35);
                intent.putExtra("fromScene", this.fromScene);
                intent.putExtra("keyword", this.aXp);
                intent.putExtra("businessType", this.aXq);
                intent.putExtra("offset", this.offset);
                intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.title);
                intent.putExtra("showEditText", this.aXr);
                try {
                    intent.putExtra("result", Ym.toByteArray());
                    if (!(this.context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    cc(true);
                } catch (Throwable e) {
                    cc(false);
                    v.a("MicroMsg.BrandService.BrandServiceLogic", e, "", new Object[0]);
                }
            }
        }

        private void cc(boolean z) {
            ak.vy().b(1071, this);
            if (this.exk != null && this.exk.aXn.aXs != null) {
                this.exk.aXo.aWL = z;
                this.exk.aXn.aXs.run();
            }
        }
    }

    public static afv Ig() {
        try {
            ak.yW();
            String str = (String) com.tencent.mm.model.c.vf().get(67591, null);
            if (str != null) {
                afv com_tencent_mm_protocal_c_afv = new afv();
                String[] split = str.split(",");
                com_tencent_mm_protocal_c_afv.mrA = Integer.valueOf(split[0]).intValue();
                com_tencent_mm_protocal_c_afv.mrD = Integer.valueOf(split[1]).intValue();
                com_tencent_mm_protocal_c_afv.mjN = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                com_tencent_mm_protocal_c_afv.mjM = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                v.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", new Object[]{Float.valueOf(com_tencent_mm_protocal_c_afv.mjN), Float.valueOf(com_tencent_mm_protocal_c_afv.mjM)});
                return com_tencent_mm_protocal_c_afv;
            }
            v.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            v.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
