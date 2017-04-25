package com.tencent.mm.plugin.ipcall.ui;

final class a {
    String bfd;
    String cQn;
    private int gIL;
    String gIM;

    public a(String str, String str2, int i, String str3) {
        this.cQn = str;
        this.bfd = str2;
        this.gIL = i;
        this.gIM = str3;
    }

    public final int auW() {
        if (this.gIL == 0) {
            return 0;
        }
        for (String equals : IPCallCountryCodeScrollbar.gKX) {
            if (equals.equals(String.valueOf((char) this.gIL))) {
                return this.gIL;
            }
        }
        return "#".charAt(0);
    }
}
