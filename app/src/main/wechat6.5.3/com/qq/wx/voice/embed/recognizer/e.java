package com.qq.wx.voice.embed.recognizer;

public final class e {
    public Grammar aHc;
    g aHd;
    byte[] c;
    public boolean d;
    public boolean e;

    private class a implements Runnable {
        private /* synthetic */ e aGV;

        private a(e eVar) {
            this.aGV = eVar;
        }

        public final void run() {
            if (this.aGV.aHc.begin() != 0) {
                this.aGV.aHd.a(-102);
            } else if (this.aGV.aHc.recognize(this.aGV.c, this.aGV.c.length) != 0) {
                this.aGV.aHd.a(-103);
            } else if (this.aGV.aHc.end() != 0) {
                this.aGV.aHd.a(-104);
            } else {
                a aVar = new a();
                if (this.aGV.aHc.getResult(aVar) != 0) {
                    this.aGV.aHd.a(-105);
                }
                g gVar = this.aGV.aHd;
                gVar.aHf.sendMessage(gVar.aHf.obtainMessage(200, aVar));
            }
        }
    }

    public e() {
        this.aHc = null;
        this.aHd = new g();
        this.c = null;
        this.d = false;
        this.e = false;
        this.aHc = new Grammar();
    }

    public final int a(c cVar, byte[] bArr) {
        if (!this.d) {
            return -304;
        }
        if (!this.e) {
            return -302;
        }
        this.aHd.aHe = cVar;
        this.c = bArr;
        if (this.c == null) {
            return -301;
        }
        try {
            new Thread(new a()).start();
            return 0;
        } catch (Exception e) {
            return -302;
        }
    }
}
