package com.tencent.mm.plugin.luckymoney.c;

import android.text.TextUtils;
import com.tencent.mm.e.a.ac;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import java.io.File;
import java.util.ArrayList;

public final class b extends c<ac> {
    private ArrayList<String> hag;

    public b() {
        this.hag = new ArrayList();
        this.nhz = ac.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
        ac acVar = (ac) bVar;
        if (!ak.uz()) {
            v.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() acc not ready!");
        } else if (acVar instanceof ac) {
            v.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() receive C2CNYPredownloadImgEvent event!");
            ak.yW();
            int intValue = ((Integer) com.tencent.mm.model.c.vf().get(a.nss, Integer.valueOf(1))).intValue();
            v.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "prestrainFlag:" + intValue);
            if (intValue == 0) {
                v.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:prestrainFlag is 0, do nothing!");
            } else {
                String str = acVar.aXB.aXC;
                String str2 = acVar.aXB.aXD;
                int i = acVar.aXB.aXE;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i <= 0) {
                    v.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:c2c new year msg image param is invalid!");
                } else if (!com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                    v.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:is not wifi network, do nothing!");
                } else if (this.hag.contains(str)) {
                    v.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imageid is exist!, do nothing!  imageid:" + str);
                } else {
                    String str3 = n.wb(str) + ".temp";
                    if (new File(str3).exists()) {
                        v.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imagePath file is exist! not download it!");
                    } else {
                        v.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() imagePath:" + str3 + " is not exist!");
                        this.hag.add(str);
                        new j().a(str, str2, i, str3, new j.a(this) {
                            final /* synthetic */ b hah;

                            {
                                this.hah = r1;
                            }

                            public final void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str, boolean z) {
                                if (z) {
                                    v.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:" + str);
                                } else {
                                    v.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:" + str);
                                }
                            }
                        });
                    }
                }
            }
        }
        return false;
    }
}
