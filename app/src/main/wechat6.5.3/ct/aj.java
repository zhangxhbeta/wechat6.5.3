package ct;

public final class aj extends bh {
    private static ao g;
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public ao f = null;

    public final void a(bf bfVar) {
        this.a = bfVar.a(this.a, 0, false);
        this.b = bfVar.a(this.b, 1, false);
        this.c = bfVar.a(this.c, 2, false);
        this.d = bfVar.a(this.d, 3, false);
        this.e = bfVar.a(this.e, 4, false);
        if (g == null) {
            g = new ao();
        }
        this.f = (ao) bfVar.a(g, 5, false);
    }

    public final void a(bg bgVar) {
        bgVar.a(this.a, 0);
        bgVar.a(this.b, 1);
        bgVar.a(this.c, 2);
        bgVar.a(this.d, 3);
        bgVar.a(this.e, 4);
        if (this.f != null) {
            bgVar.a(this.f, 5);
        }
    }
}
