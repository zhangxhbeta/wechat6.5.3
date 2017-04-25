package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.util.ArrayList;

public class ShareDexDiffPatchInfo {
    public final String cGS;
    public final String pGI;
    public final String pGJ;
    public final String pGK;
    public final String pGL;
    public final String pGM;
    public final String pGN;
    public final boolean pGO;
    public final String path;

    private ShareDexDiffPatchInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.pGI = str;
        this.path = str2;
        this.pGJ = str3;
        this.pGK = str4;
        this.pGM = str5;
        this.pGL = str6;
        this.pGN = str7;
        if (str7.equals("jar")) {
            this.pGO = true;
            if (SharePatchFileUtil.QD(str)) {
                this.cGS = str + ".jar";
            } else {
                this.cGS = str;
            }
        } else if (str7.equals("raw")) {
            this.pGO = false;
            this.cGS = str;
        } else {
            throw new TinkerRuntimeException("can't recognize dex mode:" + str7);
        }
    }

    public static void j(String str, ArrayList<ShareDexDiffPatchInfo> arrayList) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split("\n")) {
                if (str2 != null && str2.length() > 0) {
                    String[] split = str2.split(",", 7);
                    if (split != null && split.length >= 7) {
                        arrayList.add(new ShareDexDiffPatchInfo(split[0].trim(), split[1].trim(), split[2].trim(), split[3].trim(), split[4].trim(), split[5].trim(), split[6].trim()));
                    }
                }
            }
        }
    }

    public static boolean b(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (shareDexDiffPatchInfo == null) {
            return false;
        }
        String str = shareDexDiffPatchInfo.pGI;
        String str2 = ShareTinkerInternals.bPb() ? shareDexDiffPatchInfo.pGK : shareDexDiffPatchInfo.pGJ;
        if (str == null || str.length() <= 0 || str2 == null || str2.length() != 32) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.pGI);
        stringBuffer.append(",");
        stringBuffer.append(this.path);
        stringBuffer.append(",");
        stringBuffer.append(this.pGJ);
        stringBuffer.append(",");
        stringBuffer.append(this.pGK);
        stringBuffer.append(",");
        stringBuffer.append(this.pGL);
        stringBuffer.append(",");
        stringBuffer.append(this.pGM);
        stringBuffer.append(",");
        stringBuffer.append(this.pGN);
        return stringBuffer.toString();
    }
}
