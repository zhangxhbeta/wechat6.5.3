package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.be;

public final class e {
    protected String cGj;
    protected int cGk;
    protected int cGl;
    protected int cGm;
    protected int cGn;
    protected boolean cGo;
    protected f[] cGp;

    protected final void a(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        this.cGj = str;
        this.cGk = be.getInt(str2, 0);
        this.cGk = this.cGk == 0 ? 64000 : this.cGk * 1000;
        this.cGl = be.getInt(str3, 1);
        this.cGm = be.getInt(str4, 2);
        this.cGn = be.getInt(str5, 1);
        if (be.getInt(str6, 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        this.cGo = z;
    }

    protected final boolean Eo() {
        if (be.kS(this.cGj)) {
            return true;
        }
        return b.iu(this.cGj);
    }

    protected final VideoTransPara Ep() {
        VideoTransPara videoTransPara = null;
        if (this.cGp != null) {
            for (f fVar : this.cGp) {
                if (fVar != null && fVar.cGq <= 0 && fVar.cGr >= 0) {
                    videoTransPara = new VideoTransPara();
                    videoTransPara.width = fVar.cGs;
                    videoTransPara.height = fVar.cGt;
                    videoTransPara.cdg = fVar.cGu;
                    videoTransPara.cGx = fVar.cGv;
                    videoTransPara.cGl = this.cGl;
                    videoTransPara.cGk = this.cGk;
                    videoTransPara.cGm = this.cGm;
                    videoTransPara.cGn = this.cGn;
                }
            }
        }
        return videoTransPara;
    }

    public final String toString() {
        return "[ busyTime " + this.cGj + " audioBitrate " + this.cGk + " iFrame " + this.cGl + " profileIndex " + this.cGm + " presetIndex " + this.cGn + " isStepBr " + this.cGo + " ]";
    }
}
