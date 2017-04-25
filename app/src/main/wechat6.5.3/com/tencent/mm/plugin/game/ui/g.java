package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.plugin.game.c.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class g extends d {
    public g(Context context) {
        super(context);
    }

    public final void bJ(String str, String str2) {
        this.gpa = str;
        this.gpb = str2;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof c) {
            boolean z;
            this.ghX = (c) view.getTag();
            v.i("MicsoMsg.GameClickListener", "Clicked appid = " + this.ghX.field_appId);
            asm();
            if (this.goX == null || !this.goX.jPw) {
                z = false;
            } else {
                this.goX.jPw = false;
                if (this.goY != null) {
                    this.goY.field_autoInstall = true;
                    this.goY.field_showNotification = true;
                    this.goY.field_autoDownload = false;
                    com.tencent.mm.pluginsdk.model.downloader.c.b(this.goY);
                }
                z = true;
            }
            boolean z2;
            if (com.tencent.mm.pluginsdk.model.app.g.o(this.mContext, this.ghX.field_appId)) {
                int i;
                int i2;
                if (this.ghX instanceof c) {
                    int ut = com.tencent.mm.plugin.game.e.c.ut(this.ghX.field_packageName);
                    i = this.ghX.versionCode;
                    i2 = ut;
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (i > i2) {
                    v.i("MicsoMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[]{this.ghX.field_appId, Integer.valueOf(i2), Integer.valueOf(i)});
                    i.a(this.ghX.bxo, this.ghX.bxt, this.ghX.bmG, this.ghX.field_appId, this.goZ, "app_update");
                    if (this.goX.status == 1) {
                        if (!z) {
                            z2 = d.bnK().do(this.goX.id);
                            if (!z2) {
                                v.e("MicsoMsg.GameClickListener", "pauseDownloadTask ret = " + z2);
                                d.bnK().dm(this.goX.id);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (this.goX.status == 2) {
                        if (d.bnK().dp(this.goX.id)) {
                            e.S(this.mContext, this.ghX.field_appId);
                            af.a(this.mContext, this.ghX.scene, this.ghX.bmG, this.ghX.position, 4, this.ghX.field_appId, this.gjl, this.ghX.bln, this.gpa);
                            return;
                        }
                        v.e("MicsoMsg.GameClickListener", "resumeDownloadTask false");
                        d.bnK().dm(this.goX.id);
                        dn(true);
                        return;
                    } else if (this.goX.status != 3) {
                        dn(true);
                        return;
                    } else if (!com.tencent.mm.a.e.aR(this.goX.path) || com.tencent.mm.plugin.game.e.c.uu(this.goX.path) <= i2) {
                        d.bnK().dm(this.goX.id);
                        dn(true);
                        return;
                    } else {
                        p.c(this.mContext, Uri.fromFile(new File(this.goX.path)));
                        af.a(this.mContext, this.ghX.scene, this.ghX.bmG, this.ghX.position, 8, this.ghX.field_appId, this.gjl, this.ghX.bln, this.gpa);
                        return;
                    }
                }
                v.d("MicsoMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[]{this.ghX.field_appId, this.ghX.field_packageName, this.ghX.field_openId});
                af.a(this.mContext, this.ghX.scene, this.ghX.bmG, this.ghX.position, 3, this.ghX.field_appId, this.gjl, this.ghX.bln, this.gpa);
                asl();
                return;
            }
            i.a(this.ghX.bxo, this.ghX.bxt, this.ghX.bmG, this.ghX.field_appId, this.goZ, this.gpb);
            switch (this.mStatus) {
                case 1:
                    if (!z) {
                        z2 = d.bnK().do(this.goX.id);
                        if (!z2) {
                            v.e("MicsoMsg.GameClickListener", "pauseDownloadTask ret = " + z2);
                            d.bnK().dm(this.goX.id);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (!d.bnK().dp(this.goX.id)) {
                        v.e("MicsoMsg.GameClickListener", "resumeDownloadTask false");
                        d.bnK().dm(this.goX.id);
                        break;
                    }
                    e.S(this.mContext, this.ghX.field_appId);
                    af.a(this.mContext, this.ghX.scene, this.ghX.bmG, this.ghX.position, 4, this.ghX.field_appId, this.gjl, this.ghX.bln, this.gpa);
                    return;
                case 3:
                    if (be.kS(this.goW)) {
                        d.bnK().dm(this.goV);
                        break;
                    }
                    ask();
                    af.a(this.mContext, this.ghX.scene, this.ghX.bmG, this.ghX.position, 8, this.ghX.field_appId, this.gjl, this.ghX.bln, this.gpa);
                    return;
            }
            dn(false);
            return;
        }
        v.e("MicsoMsg.GameClickListener", "No AppInfo");
    }
}
