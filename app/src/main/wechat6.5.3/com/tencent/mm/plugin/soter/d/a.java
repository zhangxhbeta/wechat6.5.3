package com.tencent.mm.plugin.soter.d;

import android.content.Context;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.e.a.oo;
import com.tencent.mm.plugin.soter.c.k;
import com.tencent.mm.pluginsdk.l.c;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public abstract class a {
    protected c kdr = null;
    protected oo kds = null;
    private boolean kdt = false;
    protected Context mContext = null;

    public abstract void aYP();

    public final void a(Context context, c cVar, oo ooVar) {
        this.mContext = context;
        this.kdr = cVar;
        this.kds = ooVar;
        this.kdt = true;
        aYP();
    }

    public final void rl(int i) {
        af(i, "");
    }

    public final void af(int i, String str) {
        String str2;
        switch (i) {
            case -1:
                str2 = "unknown error";
                break;
            case 0:
                str2 = "OK";
                break;
            case 1:
                str2 = "param error";
                break;
            case 2:
                str2 = "process not registered";
                break;
            case 3:
                str2 = "soter not supported";
                break;
            case 4:
                str2 = "get ASK error";
                break;
            case 5:
                str2 = "get auth key error";
                break;
            case 6:
                str2 = "upload auth key error";
                break;
            case 7:
                str2 = "upload auth key error";
                break;
            case 8:
                str2 = "no ASK exist";
                break;
            case NetStatusUtil.MOBILE /*9*/:
                str2 = "sign failed";
                break;
            case NetStatusUtil.LTE /*10*/:
                str2 = "authenticate error";
                break;
            case 11:
                str2 = "authenticate failed";
                break;
            case 12:
                str2 = "no fingerprint hardware detected";
                break;
            case 13:
                str2 = "no fingerprint enrolled";
                break;
            case 14:
                str2 = "authenticate json info parse error";
                break;
            case 15:
                str2 = "signature init error";
                break;
            case 16:
                str2 = "key pair unrecoverable due to authenticator id changed";
                break;
            default:
                str2 = "unhandled error";
                break;
        }
        v.i("MicroMsg.SoterBaseProcess", "hy: finishProcess errCode: %d, errMsg: %s, extras: %s", new Object[]{Integer.valueOf(i), str2, str});
        k.a(i, str2, str, this.kds);
        if (aYR()) {
            this.mContext = null;
            this.kdr = null;
            this.kds = null;
            this.kdt = false;
        }
    }

    protected static String l(int i, int i2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("err_type", i);
            jSONObject.put("err_code", i2);
            jSONObject.put("err_msg", str);
        } catch (Throwable e) {
            v.a("MicroMsg.SoterBaseProcess", e, "", new Object[0]);
        }
        return jSONObject.toString();
    }

    public static String aYQ() {
        com.tencent.mm.pluginsdk.l.a aVar = (com.tencent.mm.pluginsdk.l.a) Integer.valueOf(11).getClass().getAnnotation(com.tencent.mm.pluginsdk.l.a.class);
        if (aVar != null) {
            return aVar.bok();
        }
        return null;
    }

    protected boolean aYR() {
        return true;
    }
}
