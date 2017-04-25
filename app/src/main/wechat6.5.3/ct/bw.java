package ct;

import java.util.LinkedList;

public final class bw {
    private static bw a = new bw();
    private a b = a.UNKNOW;
    private LinkedList<ch> c = new LinkedList();

    enum a {
        UNKNOW,
        MOVE,
        STATIC;

        static {
            UNKNOW = new a("UNKNOW", 0);
            MOVE = new a("MOVE", 1);
            STATIC = new a("STATIC", 2);
            a[] aVarArr = new a[]{UNKNOW, MOVE, STATIC};
        }
    }

    private bw() {
    }

    public static bw a() {
        return a;
    }

    public final synchronized int a(ch chVar) {
        if (chVar != null) {
            while (this.c.size() > 9) {
                this.c.remove(0);
            }
            while (this.c.size() > 0) {
                ch chVar2 = (ch) this.c.getFirst();
                long j = chVar.b - chVar2.b;
                double a = ct.b.a.a(chVar2.a.getLatitude(), chVar2.a.getLongitude(), chVar.a.getLatitude(), chVar.a.getLongitude());
                if (j <= 180000 || a <= 500.0d) {
                    break;
                }
                this.c.remove(0);
            }
            this.c.add(new ch(chVar));
        }
        return this.c.size();
    }

    public final synchronized long b() {
        long j;
        double d;
        int size;
        double d2;
        if (this.c.size() < 2) {
            d2 = 0.0d;
        } else {
            long j2;
            int size2 = this.c.size() - 1;
            ch chVar = (ch) this.c.get(size2);
            ch chVar2 = (ch) this.c.get(size2 - 1);
            if (chVar.b != chVar2.b) {
                j2 = chVar.b - chVar2.b;
            } else {
                j2 = 500;
            }
            d2 = (ct.b.a.a(chVar2.a.getLatitude(), chVar2.a.getLongitude(), chVar.a.getLatitude(), chVar.a.getLongitude()) / ((double) j2)) * 1000.0d;
        }
        if (this.c.size() >= 2) {
            long j3 = 0;
            double d3 = 0.0d;
            for (int i = 1; i < this.c.size(); i++) {
                ch chVar3 = (ch) this.c.get(i);
                ch chVar4 = (ch) this.c.get(i - 1);
                j3 = (chVar3.b - chVar4.b) + j3;
                d3 += ct.b.a.a(chVar4.a.getLatitude(), chVar4.a.getLongitude(), chVar3.a.getLatitude(), chVar3.a.getLongitude());
            }
            if (j3 > 0) {
                d = (d3 / ((double) j3)) * 1000.0d;
                if (this.c.size() >= 2) {
                    j = 0;
                } else {
                    j = ((ch) this.c.getLast()).b - ((ch) this.c.getFirst()).b;
                }
                size = this.c.size();
                if (size >= 2) {
                    this.b = a.UNKNOW;
                } else if (size <= 6 && r18 < 3.0d && r4 < 6.0d) {
                    this.b = a.STATIC;
                } else if (j > 60000 || r18 >= 3.0d || r4 >= 3.0d) {
                    this.b = a.MOVE;
                } else {
                    this.b = a.STATIC;
                }
                if (this.b != a.STATIC) {
                    j = 90000;
                } else {
                    j = 30000;
                }
            }
        }
        d = 0.0d;
        if (this.c.size() >= 2) {
            j = ((ch) this.c.getLast()).b - ((ch) this.c.getFirst()).b;
        } else {
            j = 0;
        }
        size = this.c.size();
        if (size >= 2) {
            if (size <= 6) {
            }
            if (j > 60000) {
            }
            this.b = a.MOVE;
        } else {
            this.b = a.UNKNOW;
        }
        if (this.b != a.STATIC) {
            j = 30000;
        } else {
            j = 90000;
        }
        return j;
    }
}
