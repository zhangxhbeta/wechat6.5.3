package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q {
    static Pattern lVg = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    String aEZ;
    String gox;
    String lVd;
    String lVe;
    int lVf;

    public q(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.lVd = SQLiteDatabase.KeyEmpty;
        this.lVe = SQLiteDatabase.KeyEmpty;
        this.lVf = -1;
        this.aEZ = "/";
        this.gox = SQLiteDatabase.KeyEmpty;
        Matcher matcher = lVg.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null) {
                this.lVd = group.toLowerCase();
            }
            group = matcher.group(2);
            if (group != null) {
                this.gox = group;
            }
            group = matcher.group(3);
            if (group != null) {
                this.lVe = group;
            }
            group = matcher.group(4);
            if (group != null && group.length() > 0) {
                try {
                    this.lVf = Integer.parseInt(group);
                } catch (NumberFormatException e) {
                    throw new Exception("Bad port");
                }
            }
            String group2 = matcher.group(5);
            if (group2 != null && group2.length() > 0) {
                if (group2.charAt(0) == '/') {
                    this.aEZ = group2;
                } else {
                    this.aEZ = "/" + group2;
                }
            }
            if (this.lVf == 443 && this.lVd.equals(SQLiteDatabase.KeyEmpty)) {
                this.lVd = "https";
            } else if (this.lVf == -1) {
                if (this.lVd.equals("https")) {
                    this.lVf = 443;
                } else {
                    this.lVf = 80;
                }
            }
            if (this.lVd.equals(SQLiteDatabase.KeyEmpty)) {
                this.lVd = "http";
                return;
            }
            return;
        }
        throw new Exception("Bad address");
    }

    public final String toString() {
        String str = SQLiteDatabase.KeyEmpty;
        if ((this.lVf != 443 && this.lVd.equals("https")) || (this.lVf != 80 && this.lVd.equals("http"))) {
            str = ":" + Integer.toString(this.lVf);
        }
        String str2 = SQLiteDatabase.KeyEmpty;
        if (this.gox.length() > 0) {
            str2 = this.gox + "@";
        }
        return this.lVd + "://" + str2 + this.lVe + str + this.aEZ;
    }
}
