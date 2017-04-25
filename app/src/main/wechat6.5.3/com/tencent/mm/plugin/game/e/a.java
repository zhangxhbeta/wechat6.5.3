package com.tencent.mm.plugin.game.e;

import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a {
    private Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> gxb;
    public boolean gzA;

    private static class a {
        private static a gzB = new a();
    }

    private a() {
        this.gzA = false;
    }

    public final synchronized void clearCache() {
        if (this.gxb != null) {
            this.gxb.clear();
        }
        this.gzA = false;
    }

    public final synchronized void asF() {
        if (this.gxb != null) {
            for (com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar : this.gxb.values()) {
                aVar.gxa = false;
            }
        }
    }

    public final synchronized void asG() {
        if (this.gxb == null) {
            this.gxb = new LinkedHashMap();
        }
        if (this.gxb.size() <= 0) {
            String str;
            InputStream inputStream = null;
            String str2 = "";
            try {
                inputStream = aa.getContext().getAssets().open("game_region_data.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        v.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{be.e(e)});
                    }
                }
            } catch (Throwable e2) {
                v.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{be.e(e2)});
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str = str2;
                    } catch (Throwable e22) {
                        v.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{be.e(e22)});
                        str = str2;
                    }
                } else {
                    str = str2;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        v.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[]{be.e(e3)});
                    }
                }
            }
            String[] split = str.trim().split("\n|\r\n|\r");
            for (String trim : split) {
                String[] split2 = trim.trim().split("\\|");
                if (split2.length < 4) {
                    v.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", new Object[]{split[r0]});
                } else {
                    com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar = new com.tencent.mm.plugin.game.ui.GameRegionPreference.a();
                    aVar.gwX = split2[0];
                    aVar.gwY = split2[1];
                    aVar.gwZ = split2[2];
                    aVar.bCq = split2[3];
                    aVar.gxa = false;
                    aVar.isDefault = false;
                    this.gxb.put(aVar.bCq, aVar);
                }
            }
            com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar2 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) this.gxb.get(e.ari());
            if (aVar2 != null) {
                com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.gzB.asH().get(e.ari());
                StringBuffer stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.gwX);
                    stringBuffer.append(e.ud("zh_CN"));
                }
                aVar2.gwX = stringBuffer.toString();
                aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.gzB.asH().get(e.ari());
                stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.gwY);
                    stringBuffer.append(e.ud("zh_TW"));
                }
                aVar2.gwY = stringBuffer.toString();
                aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.gzB.asH().get(e.ari());
                stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.gwZ);
                    stringBuffer.append(e.ud("en"));
                }
                aVar2.gwZ = stringBuffer.toString();
                aVar2.isDefault = true;
            }
        }
    }

    public final synchronized Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> asH() {
        asG();
        return this.gxb;
    }
}
