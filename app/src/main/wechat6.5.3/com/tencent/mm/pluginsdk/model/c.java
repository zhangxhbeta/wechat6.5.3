package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qb;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qn;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.snackbar.a;
import java.util.List;

public final class c {
    public static qb a(int i, qf qfVar, qn qnVar) {
        if (qfVar == null) {
            v.w("MicroMsg.FavExportLogic", "proto item is null");
            return null;
        }
        qb qbVar = new qb();
        qg qgVar = qfVar.mtP;
        if (qgVar != null) {
            qbVar.bhM = qgVar.bhM;
            qbVar.mtF = qgVar.mtu;
            qbVar.appId = qgVar.appId;
            qbVar.aWH = qgVar.aWH;
        }
        if (qnVar != null) {
            if (qnVar.mua != null) {
                qbVar.mtG.addAll(qnVar.mua);
            }
            if (qnVar.mub != null) {
                qbVar.mtG.addAll(qnVar.mub);
            }
        }
        qbVar.bmi = qfVar;
        qbVar.type = i;
        switch (i) {
            case 1:
                qbVar.title = "";
                qbVar.desc = qfVar.desc;
                return qbVar;
            case 2:
                if (qfVar.mtR != null && qfVar.mtR.size() > 0) {
                    qbVar.title = ((pw) qfVar.mtR.get(0)).title;
                }
                return qbVar;
            case 4:
                if (!(qfVar.mtR == null || qfVar.mtR.isEmpty())) {
                    qbVar.title = ((pw) qfVar.mtR.get(0)).title;
                }
                return qbVar;
            case 5:
                if (qfVar.mtc != null) {
                    qbVar.title = qfVar.mtc.title;
                    qbVar.desc = qfVar.mtc.mur;
                }
                if (!(!be.kS(qbVar.title) || qfVar.mtR == null || qfVar.mtR.isEmpty())) {
                    qbVar.title = ((pw) qfVar.mtR.get(0)).title;
                }
                if (be.kS(qbVar.desc) && qgVar != null) {
                    qbVar.desc = qgVar.cZp;
                }
                return qbVar;
            case 6:
                qbVar.title = qfVar.gxy;
                if (be.kS(qbVar.title)) {
                    if (qfVar.mta != null) {
                        qbVar.title = qfVar.mta.bkV;
                        qbVar.desc = qfVar.mta.label;
                    }
                } else if (qfVar.mta != null) {
                    qbVar.desc = qfVar.mta.bkV;
                }
                return qbVar;
            case 7:
                if (!(qfVar.mtR == null || qfVar.mtR.isEmpty())) {
                    qbVar.title = ((pw) qfVar.mtR.get(0)).title;
                    qbVar.desc = ((pw) qfVar.mtR.get(0)).desc;
                }
                return qbVar;
            case 8:
                qbVar.title = qfVar.title;
                if (!(!be.kS(qbVar.title) || qfVar.mtR == null || qfVar.mtR.isEmpty())) {
                    qbVar.title = ((pw) qfVar.mtR.get(0)).title;
                }
                return qbVar;
            case 10:
            case 11:
                if (qfVar.mte != null) {
                    qbVar.title = qfVar.mte.title;
                    qbVar.desc = qfVar.mte.desc;
                }
                return qbVar;
            case 12:
            case am.CTRL_INDEX /*15*/:
                if (qfVar.mtg != null) {
                    qbVar.title = qfVar.mtg.title;
                    qbVar.desc = qfVar.mtg.desc;
                }
                return qbVar;
            case an.CTRL_INDEX /*14*/:
            case 18:
                List<pw> list = qfVar.mtR;
                if (list == null) {
                    return null;
                }
                for (pw pwVar : list) {
                    if (1 == pwVar.aKG) {
                        qbVar.title = pwVar.desc;
                        return qbVar;
                    }
                }
                return qbVar;
            default:
                v.w("MicroMsg.FavExportLogic", "unknown type %d", new Object[]{Integer.valueOf(i)});
                return qbVar;
        }
    }

    public static String dg(String str, String str2) {
        if (be.kS(str)) {
            return str2;
        }
        if (be.kS(str2)) {
            return str;
        }
        return str + '​' + str2;
    }

    public static void a(int i, int i2, Activity activity) {
        a(i, i2, activity, null, null, null);
    }

    public static void a(int i, int i2, Activity activity, Fragment fragment, com.tencent.mm.ui.snackbar.b.c cVar, final OnClickListener onClickListener) {
        if (activity == null && fragment == null) {
            v.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
        } else if (i != 0) {
            if (activity == null && fragment != null) {
                activity = fragment.aG();
            }
            if (i == -2) {
                a.a(activity, onClickListener);
            } else {
                g.a(activity, i, 0, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (onClickListener != null) {
                            onClickListener.onClick(dialogInterface, -1);
                        }
                    }
                });
            }
        } else if (fragment != null) {
            a.a(i2, fragment, fragment.getString(2131232695), fragment.getString(2131232639), cVar);
        } else if (activity != null) {
            a.a(i2, activity, activity.getString(2131232695), activity.getString(2131232639), cVar);
        }
    }
}
