package com.tencent.mm.compatible.loader;

import android.content.Context;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static Map<String, String> cfJ;

    public static String v(Context context, String str) {
        long Ni = be.Ni();
        if (cfJ == null) {
            try {
                Map Kb = q.Kb(be.e(context.getAssets().open("preload/libraries.ini")));
                v.v("MicroMsg.PluginClassLoader", "libraries.ini content\n%s", r0);
                if (Kb == null || Kb.size() <= 0) {
                    v.e("MicroMsg.PluginClassLoader", "parse libraries.ini failed");
                } else {
                    cfJ = new HashMap(Kb.size());
                    for (Entry entry : Kb.entrySet()) {
                        v.d("MicroMsg.PluginClassLoader", "preload file, plugin=%s, md5=%s", entry.getKey(), entry.getValue());
                        cfJ.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable e) {
                v.e("MicroMsg.PluginClassLoader", "load preload libraries failed");
                v.a("MicroMsg.PluginClassLoader", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        String absolutePath = context.getDir("lib", 0).getAbsolutePath();
        if (cfJ == null) {
            v.e("MicroMsg.PluginClassLoader", "extractVoipDex preload so files loaded failed");
            return null;
        }
        String str2 = absolutePath + "/" + str;
        absolutePath = (String) cfJ.get(str);
        if (absolutePath == null) {
            v.w("MicroMsg.PluginClassLoader", "extractVoipDex not in preloadfiles");
            return null;
        }
        File file = new File(str2);
        if (file.exists()) {
            String g = g.g(file);
            if (g == null || !g.equalsIgnoreCase(absolutePath)) {
                v.e("MicroMsg.PluginClassLoader", "extractVoipDex target file exists, but md5 check failed, target=%s assets=%s", g, absolutePath);
            } else {
                v.d("MicroMsg.PluginClassLoader", "extractVoipDex: targetFilePath:[%s] time:%d", file, Long.valueOf(be.ay(Ni)));
                return str2;
            }
        }
        b.deleteFile(str2);
        if (j.y(context, "preload/" + str, str2)) {
            v.i("MicroMsg.PluginClassLoader", "extractVoipDex time:%d so:%s md5:%s ", Long.valueOf(be.ay(Ni)), str, absolutePath);
            return str2;
        }
        v.f("MicroMsg.PluginClassLoader", "extractVoipDex  copyAssets failed");
        return null;
    }
}
