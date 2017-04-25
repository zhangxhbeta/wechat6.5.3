package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public final class b {

    private static class a implements Runnable {
        private List<Object> iHv;
        private String[] knj;

        public a(String[] strArr, List<Object> list) {
            this.knj = strArr;
            this.iHv = list;
        }

        public final void run() {
            Process start;
            InputStream inputStream;
            IOException iOException;
            long j;
            IOException iOException2;
            InterruptedException interruptedException;
            InterruptedException interruptedException2;
            Exception exception;
            Exception exception2;
            StringBuilder stringBuilder = new StringBuilder();
            ProcessBuilder processBuilder = new ProcessBuilder(this.knj);
            processBuilder.redirectErrorStream(true);
            long Ni = be.Ni();
            long Ni2 = be.Ni();
            try {
                start = processBuilder.start();
                try {
                    start.getOutputStream().close();
                    inputStream = start.getInputStream();
                } catch (IOException e) {
                    iOException = e;
                    inputStream = null;
                    j = Ni2;
                    iOException2 = iOException;
                    b.a(start, inputStream);
                    v.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + iOException2.getMessage());
                    b.a(start, inputStream);
                    this.iHv.add(stringBuilder.toString());
                    this.iHv.add(Long.valueOf(j - Ni));
                    v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                } catch (InterruptedException e2) {
                    interruptedException = e2;
                    inputStream = null;
                    j = Ni2;
                    interruptedException2 = interruptedException;
                    b.a(start, inputStream);
                    v.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + interruptedException2.getMessage());
                    b.a(start, inputStream);
                    this.iHv.add(stringBuilder.toString());
                    this.iHv.add(Long.valueOf(j - Ni));
                    v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                } catch (Exception e3) {
                    exception = e3;
                    inputStream = null;
                    j = Ni2;
                    exception2 = exception;
                    b.a(start, inputStream);
                    v.e("MicroMsg.MMTraceRoute", "run cmd err: " + exception2.getMessage());
                    b.a(start, inputStream);
                    this.iHv.add(stringBuilder.toString());
                    this.iHv.add(Long.valueOf(j - Ni));
                    v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                }
                try {
                    j = be.Ni();
                    try {
                        Reader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 8096);
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuilder.append(readLine);
                        }
                        start.waitFor();
                        bufferedReader.close();
                        inputStreamReader.close();
                    } catch (IOException e4) {
                        iOException2 = e4;
                        b.a(start, inputStream);
                        v.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + iOException2.getMessage());
                        b.a(start, inputStream);
                        this.iHv.add(stringBuilder.toString());
                        this.iHv.add(Long.valueOf(j - Ni));
                        v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    } catch (InterruptedException e5) {
                        interruptedException2 = e5;
                        b.a(start, inputStream);
                        v.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + interruptedException2.getMessage());
                        b.a(start, inputStream);
                        this.iHv.add(stringBuilder.toString());
                        this.iHv.add(Long.valueOf(j - Ni));
                        v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    } catch (Exception e6) {
                        exception2 = e6;
                        b.a(start, inputStream);
                        v.e("MicroMsg.MMTraceRoute", "run cmd err: " + exception2.getMessage());
                        b.a(start, inputStream);
                        this.iHv.add(stringBuilder.toString());
                        this.iHv.add(Long.valueOf(j - Ni));
                        v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    }
                } catch (IOException e7) {
                    iOException = e7;
                    j = Ni2;
                    iOException2 = iOException;
                    b.a(start, inputStream);
                    v.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + iOException2.getMessage());
                    b.a(start, inputStream);
                    this.iHv.add(stringBuilder.toString());
                    this.iHv.add(Long.valueOf(j - Ni));
                    v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                } catch (InterruptedException e8) {
                    interruptedException = e8;
                    j = Ni2;
                    interruptedException2 = interruptedException;
                    b.a(start, inputStream);
                    v.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + interruptedException2.getMessage());
                    b.a(start, inputStream);
                    this.iHv.add(stringBuilder.toString());
                    this.iHv.add(Long.valueOf(j - Ni));
                    v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                } catch (Exception e9) {
                    exception = e9;
                    j = Ni2;
                    exception2 = exception;
                    b.a(start, inputStream);
                    v.e("MicroMsg.MMTraceRoute", "run cmd err: " + exception2.getMessage());
                    b.a(start, inputStream);
                    this.iHv.add(stringBuilder.toString());
                    this.iHv.add(Long.valueOf(j - Ni));
                    v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                }
            } catch (IOException e10) {
                start = null;
                j = Ni2;
                iOException2 = e10;
                inputStream = null;
                b.a(start, inputStream);
                v.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + iOException2.getMessage());
                b.a(start, inputStream);
                this.iHv.add(stringBuilder.toString());
                this.iHv.add(Long.valueOf(j - Ni));
                v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            } catch (InterruptedException e22) {
                start = null;
                j = Ni2;
                interruptedException2 = e22;
                inputStream = null;
                b.a(start, inputStream);
                v.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + interruptedException2.getMessage());
                b.a(start, inputStream);
                this.iHv.add(stringBuilder.toString());
                this.iHv.add(Long.valueOf(j - Ni));
                v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            } catch (Exception e32) {
                start = null;
                j = Ni2;
                exception2 = e32;
                inputStream = null;
                b.a(start, inputStream);
                v.e("MicroMsg.MMTraceRoute", "run cmd err: " + exception2.getMessage());
                b.a(start, inputStream);
                this.iHv.add(stringBuilder.toString());
                this.iHv.add(Long.valueOf(j - Ni));
                v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            }
            b.a(start, inputStream);
            this.iHv.add(stringBuilder.toString());
            this.iHv.add(Long.valueOf(j - Ni));
            v.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
        }
    }

    static /* synthetic */ void a(Process process, InputStream inputStream) {
        if (process != null) {
            try {
                process.destroy();
            } catch (IOException e) {
                v.e("MicroMsg.MMTraceRoute", "close stream failed: " + e.getMessage());
                return;
            }
        }
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public static String CG(String str) {
        v.i("MicroMsg.MMTraceRoute", "output string: " + str);
        if (str == null || str.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf("time=");
        if (indexOf < 0) {
            return null;
        }
        indexOf += 5;
        int indexOf2 = str.indexOf(" ", indexOf);
        if (indexOf2 >= 0) {
            return str.substring(indexOf, indexOf2);
        }
        return null;
    }

    public static int CH(String str) {
        int indexOf = str.indexOf("ttl=");
        if (indexOf < 0) {
            return -1;
        }
        indexOf += 4;
        int indexOf2 = str.indexOf(" ", indexOf);
        if (indexOf2 >= 0) {
            return be.getInt(str.substring(indexOf, indexOf2), 0);
        }
        return -1;
    }

    public static List<Object> y(String[] strArr) {
        String str = " ";
        for (int i = 0; i < 4; i++) {
            str = str + strArr[i] + " ";
        }
        v.i("MicroMsg.MMTraceRoute", str);
        List<Object> arrayList = new ArrayList();
        Runnable aVar = new a(strArr, arrayList);
        e.b(aVar, "MMTraceRouteCMDExecutor_watcher");
        try {
            e.L(aVar);
            v.i("MicroMsg.MMTraceRoute", "watcher thread stopped" + str);
        } catch (InterruptedException e) {
            e.H(aVar);
            v.i("MicroMsg.MMTraceRoute", "interrupt thread" + str);
        }
        return arrayList;
    }
}
