package com.tencent.mm.sdk.platformtools;

public final class g {
    public static String ehY = "]]>";
    public StringBuffer eid = new StringBuffer();
    public String nib = "";

    public g(String str) {
        this.nib = str;
        oT(this.nib);
    }

    private void oT(String str) {
        this.eid.append("<" + str + ">");
    }

    public final void oU(String str) {
        this.eid.append("</" + str + ">");
    }

    public final void aY(String str, String str2) {
        oT(str);
        if (!be.kS(str2)) {
            if (str2.contains(ehY)) {
                this.eid.append("<![CDATA[" + be.KJ(str2) + "]]>");
            } else {
                this.eid.append("<![CDATA[" + str2 + "]]>");
            }
        }
        oU(str);
    }
}
