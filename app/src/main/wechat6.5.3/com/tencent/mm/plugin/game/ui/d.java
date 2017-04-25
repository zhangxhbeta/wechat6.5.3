package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.plugin.game.c.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.downloader.b;
import com.tencent.mm.pluginsdk.model.downloader.e.a;
import com.tencent.mm.pluginsdk.model.downloader.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.al;
import com.tencent.mm.ui.base.g;
import java.io.File;

public abstract class d implements OnClickListener {
    protected c ghX = null;
    protected int gjl;
    protected long goV = -1;
    protected String goW;
    protected f goX;
    protected al goY;
    protected String goZ;
    protected String gpa;
    protected String gpb;
    private String gpc = "xiaomi";
    protected Context mContext;
    protected int mStatus = -1;

    public d(Context context) {
        this.mContext = context;
    }

    public final void lu(int i) {
        this.gjl = i;
    }

    protected final void ask() {
        p.c(this.mContext, Uri.fromFile(new File(this.goX.path)));
    }

    protected final void asl() {
        e.R(this.mContext, this.ghX.field_appId);
    }

    protected final void dn(boolean z) {
        if (ak.vy().BJ() == 0) {
            Toast.makeText(this.mContext, this.mContext.getString(2131232875), 0).show();
            i.ark();
            i.k(this.ghX.field_appId, b.lBR, null);
            return;
        }
        ak.yW();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            Toast.makeText(this.mContext, this.mContext.getString(2131233080), 0).show();
            i.ark();
            i.k(this.ghX.field_appId, b.lBS, null);
        } else if (com.tencent.mm.compatible.util.f.G(52428800)) {
            if (com.tencent.mm.protocal.d.lWa.toLowerCase().contains(this.gpc)) {
                try {
                    if (Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0 && !this.mContext.getSharedPreferences("game_center_pref", 0).getBoolean("show_open_download_authority_tips", false)) {
                        g.a(this.mContext, 2131233134, 2131233135, 2131233143, 2131231010, false, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ d gpd;

                            {
                                this.gpd = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.gpd.mContext.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
                                dialogInterface.cancel();
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ d gpd;

                            {
                                this.gpd = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        this.mContext.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_open_download_authority_tips", true).commit();
                    }
                } catch (SettingNotFoundException e) {
                    v.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", new Object[]{e.getMessage()});
                }
            }
            if (be.kS(this.ghX.bxo) || be.kS(this.ghX.bxt)) {
                v.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
                if (be.kS(this.ghX.bxu)) {
                    v.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
                } else {
                    boolean aO = p.aO(this.mContext, this.ghX.bxu);
                    v.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[]{Boolean.valueOf(aO)});
                }
                if (be.kS(this.ghX.bxo)) {
                    i.ark();
                    i.k(this.ghX.field_appId, b.DOWNLOAD_ERR_URL_INVALID, null);
                }
                if (be.kS(this.ghX.bxt)) {
                    i.ark();
                    i.k(this.ghX.field_appId, b.lBP, null);
                    return;
                }
                return;
            }
            if (z) {
                i.a(this.ghX.bxo, this.ghX.bxt, this.ghX.bmG, this.ghX.field_appId, this.goZ, "app_update");
            } else {
                i.a(this.ghX.bxo, this.ghX.bxt, this.ghX.bmG, this.ghX.field_appId, this.goZ, this.gpb);
            }
            af.a(this.mContext, this.ghX.scene, this.ghX.bmG, this.ghX.position, 4, this.ghX.field_appId, this.gjl, this.ghX.bln, this.gpa);
            a aVar = new a();
            aVar.GQ(this.ghX.bxo);
            aVar.GR(com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, this.ghX, null));
            aVar.setAppId(this.ghX.field_appId);
            aVar.GS(this.ghX.bxt);
            aVar.hO(true);
            aVar.tE(1);
            aVar.GT(this.ghX.field_packageName);
            v.i("MicroMsg.CommonGameClickLinstener", "summertoken add doanload task result:[%d], pkg[%s], versionCode[%d]", new Object[]{Long.valueOf(com.tencent.mm.pluginsdk.model.downloader.d.bnK().a(aVar.lCn)), this.ghX.field_packageName, Integer.valueOf(this.ghX.versionCode)});
            e.S(this.mContext, this.ghX.field_appId);
        } else {
            Toast.makeText(this.mContext, this.mContext.getString(2131235723), 0).show();
            i.ark();
            i.k(this.ghX.field_appId, b.lBS, null);
        }
    }

    protected final void asm() {
        this.goY = com.tencent.mm.pluginsdk.model.downloader.c.GJ(this.ghX.field_appId);
        this.goX = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(this.ghX.field_appId);
        this.goV = this.goX.id;
        this.mStatus = this.goX.status;
        this.goW = this.goX.path;
    }
}
