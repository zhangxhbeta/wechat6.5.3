package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.mm.e.b.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private ac handler;
    List<q> iMS;
    List<q> lAi;
    Map<String, Integer> lAj;
    private ah lAk;

    public e() {
        this.lAi = null;
        this.iMS = null;
        this.lAj = null;
        this.lAk = new ah(new a(this) {
            final /* synthetic */ e lAl;

            {
                this.lAl = r1;
            }

            public final boolean oU() {
                this.lAl.lAj.clear();
                return false;
            }
        }, false);
        this.handler = new ac(this) {
            final /* synthetic */ e lAl;

            {
                this.lAl = r1;
            }

            public final void handleMessage(Message message) {
                t tVar = (t) message.obj;
                q qVar = new q(tVar.appId, tVar.cYK);
                if (this.lAl.lAi.contains(qVar)) {
                    this.lAl.lAi.remove(qVar);
                    if (!am.bnB().d(tVar.appId, tVar.data, tVar.cYK)) {
                        v.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
                    }
                }
                while (this.lAl.iMS.size() > 0) {
                    q qVar2 = (q) this.lAl.iMS.remove(0);
                    if (this.lAl.a(qVar2)) {
                        this.lAl.lAi.add(qVar2);
                        return;
                    }
                }
            }
        };
        this.lAi = new ArrayList();
        this.iMS = new ArrayList();
        this.lAj = new HashMap();
        this.lAk.ea(600000);
    }

    public final void bz(String str, int i) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppIconService", "push fail, appId is null");
            return;
        }
        q qVar = new q(str, i);
        if (this.lAi.contains(qVar)) {
            v.i("MicroMsg.AppIconService", "push, appId = " + str + ", iconType = " + i + " already in running list");
        } else if (this.lAi.size() >= 5) {
            v.i("MicroMsg.AppIconService", "running list has reached the max count");
            if (!this.iMS.contains(qVar)) {
                this.iMS.add(qVar);
            }
        } else if (a(qVar)) {
            this.lAi.add(qVar);
        }
    }

    final boolean a(q qVar) {
        if (qVar == null) {
            v.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
            return false;
        }
        int i;
        if (qVar == null) {
            v.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
            i = 0;
        } else {
            Integer valueOf = Integer.valueOf(be.a((Integer) this.lAj.get(qVar.toString()), 0));
            if (valueOf.intValue() >= 5) {
                v.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
                i = 0;
            } else {
                this.lAj.put(qVar.toString(), Integer.valueOf(valueOf.intValue() + 1));
                i = 1;
            }
        }
        if (i == 0) {
            v.e("MicroMsg.AppIconService", "increaseCounter fail");
            return false;
        }
        n Gz = am.bnB().Gz(qVar.appId);
        if (Gz == null) {
            v.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + qVar.appId);
            return false;
        }
        String str;
        switch (qVar.cYK) {
            case 1:
                if (Gz.field_appIconUrl != null && Gz.field_appIconUrl.length() != 0) {
                    str = Gz.field_appIconUrl;
                    break;
                }
                v.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + qVar.appId);
                return false;
            case 2:
                if (Gz.field_appWatermarkUrl != null && Gz.field_appWatermarkUrl.length() != 0) {
                    str = Gz.field_appWatermarkUrl;
                    break;
                }
                v.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + qVar.appId);
                return false;
            case 3:
                if (Gz.bxv != null && Gz.bxv.length() != 0) {
                    str = Gz.bxv;
                    break;
                }
                v.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + qVar.appId);
                return false;
                break;
            case 4:
                if (Gz.bxG != null && Gz.bxG.length() != 0) {
                    str = Gz.bxG;
                    break;
                }
                v.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + qVar.appId);
                return false;
                break;
            case 5:
                if (Gz.bxH != null && Gz.bxH.length() != 0) {
                    str = Gz.bxH;
                    break;
                }
                v.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + qVar.appId);
                return false;
            default:
                v.e("MicroMsg.AppIconService", "push, unknown iconType = " + qVar.cYK);
                return false;
        }
        v.i("MicroMsg.AppIconService", "appIconUrl = " + str);
        com.tencent.mm.sdk.i.e.a(new r(this.handler, qVar.appId, qVar.cYK, str), "AppIconService_getIcon");
        return true;
    }
}
