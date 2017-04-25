package com.tencent.mm.plugin.bottle.ui;

import java.util.Calendar;
import java.util.Date;

final class f {
    private static final long[] evf = new long[]{19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42448, 83315, 21200, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46496, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19415, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448};
    private static final long evi = new Date(0, 0, 31).getTime();
    public int evg;
    public boolean evh;
    public int month;
    public int year;

    public f() {
        this(Calendar.getInstance());
    }

    private f(Calendar calendar) {
        int time = (int) ((calendar.getTime().getTime() - evi) / 86400000);
        int i = 1900;
        int i2 = 0;
        while (i < 2050 && time > 0) {
            i2 = iC(i);
            time -= i2;
            i++;
        }
        if (time < 0) {
            time += i2;
            i--;
        }
        this.year = i;
        int iE = iE(i);
        this.evh = false;
        int i3 = 0;
        i2 = time;
        time = 1;
        while (time < 13 && i2 > 0) {
            if (iE <= 0 || time != iE + 1 || this.evh) {
                i = (evf[this.year + -1900] & ((long) (65536 >> time))) == 0 ? 29 : 30;
            } else {
                time--;
                this.evh = true;
                i = iD(this.year);
            }
            i2 -= i;
            if (this.evh && time == iE + 1) {
                this.evh = false;
            }
            time++;
            i3 = i;
        }
        if (i2 != 0 || iE <= 0 || time != iE + 1) {
            i = time;
        } else if (this.evh) {
            this.evh = false;
            i = time;
        } else {
            this.evh = true;
            i = time - 1;
        }
        if (i2 < 0) {
            time = i2 + i3;
            i--;
        } else {
            time = i2;
        }
        this.month = i;
        this.evg = time + 1;
    }

    private static int iC(int i) {
        int i2 = 348;
        for (int i3 = 32768; i3 > 8; i3 >>= 1) {
            if ((evf[i - 1900] & ((long) i3)) != 0) {
                i2++;
            }
        }
        return i2 + iD(i);
    }

    private static int iD(int i) {
        if (iE(i) == 0) {
            return 0;
        }
        if ((evf[i - 1900] & 65536) != 0) {
            return 30;
        }
        return 29;
    }

    private static int iE(int i) {
        return (int) (evf[i - 1900] & 15);
    }
}
