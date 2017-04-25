package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a implements Serializable {
    public boolean bbq;
    public long fVN;
    public String pFD;
    public String pFE;
    public Throwable puh;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPatchResult: \n");
        stringBuffer.append("isSuccess:" + this.bbq + "\n");
        stringBuffer.append("rawPatchFilePath:" + this.pFD + "\n");
        stringBuffer.append("costTime:" + this.fVN + "\n");
        if (this.pFE != null) {
            stringBuffer.append("patchVersion:" + this.pFE + "\n");
        }
        if (this.puh != null) {
            stringBuffer.append("Throwable:" + this.puh.getMessage() + "\n");
        }
        return stringBuffer.toString();
    }
}
