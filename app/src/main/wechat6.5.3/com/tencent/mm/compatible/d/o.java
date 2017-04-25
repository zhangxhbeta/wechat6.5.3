package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.v;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class o {
    private RandomAccessFile cet;
    private a ceu;
    private ArrayList<a> cev;

    public class a {
        int cew = 0;
        private long cex = 0;
        final /* synthetic */ o cey;
        private long mLastIdle = 0;

        public a(o oVar) {
            this.cey = oVar;
        }

        public final void d(String[] strArr) {
            long parseLong = Long.parseLong(strArr[4], 10);
            long j = 0;
            Object obj = 1;
            for (String str : strArr) {
                if (obj != null) {
                    obj = null;
                } else {
                    j += Long.parseLong(str, 10);
                }
            }
            long j2 = j - this.cex;
            this.cew = (int) ((((float) (j2 - (parseLong - this.mLastIdle))) / ((float) j2)) * 100.0f);
            this.cex = j;
            this.mLastIdle = parseLong;
            v.i(" MicroMsg.CpuUsage", "CPU total=" + j + "; idle=" + parseLong + "; usage=" + this.cew);
        }
    }

    private void rI() {
        if (this.cet != null) {
            try {
                this.cet.seek(0);
                int i = -1;
                while (true) {
                    String readLine = this.cet.readLine();
                    if (readLine == null || readLine.length() <= 0) {
                        v.e(" MicroMsg.CpuUsage", "unable to get cpu line");
                    } else {
                        String[] split = readLine.split("[ ]+");
                        if (split[0].indexOf("cpu") != -1) {
                            if (i == -1) {
                                if (this.ceu == null) {
                                    this.ceu = new a(this);
                                }
                                this.ceu.d(split);
                            } else {
                                if (this.cev == null) {
                                    this.cev = new ArrayList();
                                }
                                if (i < this.cev.size()) {
                                    ((a) this.cev.get(i)).d(split);
                                } else {
                                    a aVar = new a(this);
                                    aVar.d(split);
                                    this.cev.add(aVar);
                                }
                            }
                        }
                    }
                    int i2 = i + 1;
                    if (readLine != null) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            } catch (IOException e) {
                v.e(" MicroMsg.CpuUsage", "Ops: " + e);
            }
        }
    }

    public final String toString() {
        try {
            this.cet = new RandomAccessFile("/proc/stat", "r");
            rI();
            if (this.cet != null) {
                this.cet.close();
            }
        } catch (FileNotFoundException e) {
            this.cet = null;
            v.e(" MicroMsg.CpuUsage", "cannot open /proc/stat: " + e);
        } catch (IOException e2) {
            v.e(" MicroMsg.CpuUsage", "cannot close /proc/stat: " + e2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (this.ceu != null) {
            stringBuffer.append("Cpu Total : ");
            stringBuffer.append(this.ceu.cew);
            stringBuffer.append("%");
        }
        if (this.cev != null) {
            for (int i = 0; i < this.cev.size(); i++) {
                a aVar = (a) this.cev.get(i);
                stringBuffer.append(" Cpu Core(" + i + ") : ");
                stringBuffer.append(aVar.cew);
                stringBuffer.append("%");
            }
        }
        return stringBuffer.toString();
    }
}
