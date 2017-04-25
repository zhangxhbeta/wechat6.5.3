package com.tencent.mm.booter;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.xlog.app.XLogSetup;
import java.util.HashMap;

public final class c {
    private static c bXM;
    public int bXJ = -1;
    private final String[] bXK = new String[]{"_id", "key", "type", "value"};
    private final HashMap<String, Object> bXL = new HashMap();
    private Context ctx;

    public static final class a {
        public static Object j(int i, String str) {
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    try {
                        v.e("MicroMsg.Debugger.Resolver", "unknown type");
                    } catch (Exception e) {
                    }
                    return null;
            }
        }
    }

    public static c ao(Context context) {
        if (bXM == null) {
            bXM = new c(context);
        }
        return bXM;
    }

    private c(Context context) {
        Cursor query;
        this.ctx = context;
        try {
            query = context.getContentResolver().query(com.tencent.mm.k.a.a.CONTENT_URI, this.bXK, null, null, null);
        } catch (Exception e) {
            query = null;
        }
        if (query != null) {
            if (query.getCount() <= 0) {
                query.close();
            } else if ("18c867f0717aa67b2ab7347505ba07ed".equals(be.j("com.tencent.mm.coolassist", context))) {
                b.bsH();
                int columnIndex = query.getColumnIndex("key");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("value");
                while (query.moveToNext()) {
                    this.bXL.put(query.getString(columnIndex), a.j(query.getInt(columnIndex2), query.getString(columnIndex3)));
                }
                query.close();
            } else {
                query.close();
            }
        }
    }

    public final void cR(String str) {
        boolean z = true;
        Integer integer = getInteger(".com.tencent.mm.debug.log.level");
        boolean a = be.a(cS(".com.tencent.mm.debug.log.append_mode"), false);
        boolean z2 = be.kS(getString(".com.tencent.mm.debug.log.mmlog")) && be.a(cS(".com.tencent.mm.debug.test.uploadLog"), false);
        if (z2) {
            String string = getString(".com.tencent.mm.debug.log.tag.skey");
            if (string != null && string.length() > 0) {
                Xlog.logDecryptor = new w(string);
            }
        }
        boolean z3 = this.ctx.getSharedPreferences("system_config_prefs", 4).getBoolean("first_launch_weixin", true);
        if (!"MM".equalsIgnoreCase(str)) {
            z3 = false;
        }
        XLogSetup.keep_setupXLog(!z3, t.nog, e.cgn, integer, Boolean.valueOf(a), Boolean.valueOf(z2), str);
        v.uZ(v.getLogLevel());
        if (be.getInt(be.ah(getString(".com.tencent.mm.debug.monkeyEnv"), "0"), 0) != 1) {
            z = false;
        }
        b.iu(z);
    }

    public final String getString(String str) {
        Object obj = this.bXL.get(str);
        if (!(obj instanceof String)) {
            return null;
        }
        v.d("MicroMsg.Debugger", "getString(): key=" + str + ", value=" + obj.toString());
        return (String) obj;
    }

    public final Integer getInteger(String str) {
        Object obj = this.bXL.get(str);
        if (!(obj instanceof Integer)) {
            return null;
        }
        v.d("MicroMsg.Debugger", "getInteger(): key=" + str + ", value=" + obj.toString());
        return (Integer) obj;
    }

    public final Boolean cS(String str) {
        Object obj = this.bXL.get(str);
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Boolean)) {
            return null;
        }
        v.d("MicroMsg.Debugger", "getBoolean(): key=" + str + ", value=" + obj.toString());
        return (Boolean) obj;
    }
}
