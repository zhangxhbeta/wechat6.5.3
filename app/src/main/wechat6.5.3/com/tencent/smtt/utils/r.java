package com.tencent.smtt.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class r {
    public b pzI = null;
    public b pzJ = null;

    class a {
        private String mName;
        long pzK;
        long pzL;
        final /* synthetic */ r pzM;

        a(r rVar, String str, long j, long j2) {
            this.pzM = rVar;
            this.mName = str;
            this.pzK = j;
            this.pzL = j2;
        }
    }

    class b {
        final /* synthetic */ r pzM;
        public Map<String, a> pzN = new HashMap();

        public b(r rVar, File file) {
            this.pzM = rVar;
            this.pzN.clear();
            I(file);
        }

        private void I(File file) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File I : listFiles) {
                    I(I);
                }
            } else if (file.isFile()) {
                String name = file.getName();
                long length = file.length();
                long lastModified = file.lastModified();
                if (name != null && name.length() > 0 && length > 0 && lastModified > 0) {
                    a aVar = new a(this.pzM, name, length, lastModified);
                    if (!this.pzN.containsKey(name)) {
                        this.pzN.put(name, aVar);
                    }
                }
            }
        }
    }

    public static boolean a(b bVar, b bVar2) {
        if (bVar == null || bVar.pzN == null || bVar2 == null || bVar2.pzN == null) {
            return false;
        }
        Map map = bVar.pzN;
        Map map2 = bVar2.pzN;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            a aVar = (a) entry.getValue();
            if (!map2.containsKey(str)) {
                return false;
            }
            a aVar2 = (a) map2.get(str);
            if (aVar.pzK == aVar2.pzK) {
                if (aVar.pzL != aVar2.pzL) {
                }
            }
            return false;
        }
        return true;
    }
}
