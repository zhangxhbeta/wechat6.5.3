package com.tencent.mm.plugin.c.a.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import junit.framework.Assert;

public final class c {

    public static final class a {
        private final HandlerThread epM;
        final BluetoothDevice esA;
        BluetoothSocket esv;
        final boolean esw = true;
        public final b esx;
        public final a esy;
        boolean esz = false;
        public final ac mHandler;

        private static class a extends ac {
            private WeakReference<a> epQ = null;

            public a(Looper looper, a aVar) {
                super(looper);
                this.epQ = new WeakReference(aVar);
            }

            public final void handleMessage(Message message) {
                a aVar = (a) this.epQ.get();
                if (aVar == null) {
                    v.e("MicroMsg.exdevice.BluetoothChatThreads", "null == connectTread");
                    return;
                }
                switch (message.what) {
                    case 0:
                        v.i("MicroMsg.exdevice.ConnectThread", "------connectImp------");
                        if (aVar.esz) {
                            v.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready connect, just leave");
                            return;
                        }
                        try {
                            if (aVar.esw) {
                                aVar.esv = aVar.esA.createRfcommSocketToServiceRecord(a.esl);
                            } else {
                                aVar.esv = aVar.esA.createInsecureRfcommSocketToServiceRecord(a.esm);
                            }
                            try {
                                aVar.esv.connect();
                                aVar.esz = true;
                                b bVar = aVar.esx;
                                a aVar2 = aVar.esy;
                                BluetoothSocket bluetoothSocket = aVar.esv;
                                v.i("MicroMsg.exdevice.BluetoothChatSession", "connected");
                                bVar.mState = 3;
                                if (bVar.est != null) {
                                    bVar.est.cancel();
                                    bVar.est = null;
                                }
                                if (bVar.esu != null) {
                                    bVar.esu.cancel();
                                    bVar.esu = null;
                                }
                                bVar.est = new b(bVar, aVar2, bluetoothSocket);
                                e.c(bVar.est, "BluetoothChatSession_recv").start();
                                bVar.esu = new c(bVar, aVar2, bluetoothSocket);
                                e.c(bVar.esu, "BluetoothChatSession_send").start();
                                if (aVar.esy != null) {
                                    aVar.esy.esn.d(aVar.esx.epy, true);
                                    return;
                                }
                                return;
                            } catch (IOException e) {
                                v.e("MicroMsg.exdevice.ConnectThread", "socket connect failed (%s)", new Object[]{e.toString()});
                                try {
                                    aVar.esv.close();
                                } catch (IOException e2) {
                                    v.e("MicroMsg.exdevice.ConnectThread", "Close socket failed!!! (%s)", new Object[]{e2.toString()});
                                }
                                if (aVar.esy != null) {
                                    aVar.esy.esn.d(aVar.esx.epy, false);
                                    return;
                                }
                                return;
                            }
                        } catch (IOException e22) {
                            aVar.esv = null;
                            v.e("MicroMsg.exdevice.ConnectThread", "createRfcommSocket Failed!!! (%s)", new Object[]{e22.toString()});
                            if (aVar.esy != null) {
                                aVar.esy.esn.d(aVar.esx.epy, false);
                                return;
                            }
                            return;
                        }
                    case 1:
                        if (aVar.esz) {
                            try {
                                aVar.esv.close();
                                return;
                            } catch (IOException e3) {
                                v.e("MicroMsg.exdevice.ConnectThread", "socket close failed (%s)", new Object[]{e3.toString()});
                                return;
                            }
                        }
                        v.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready disconnect, just leave");
                        return;
                    default:
                        return;
                }
            }
        }

        public a(b bVar, a aVar, BluetoothDevice bluetoothDevice, boolean z) {
            this.esy = aVar;
            this.esx = bVar;
            this.esA = bluetoothDevice;
            this.epM = e.Lg("BluetoothChatThreads_handlerThread");
            this.epM.start();
            this.mHandler = new a(this.epM.getLooper(), this);
        }

        public final void disconnect() {
            v.i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
            if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
                v.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", new Object[]{Integer.valueOf(1)});
            }
            if (f.dW(18)) {
                this.epM.quitSafely();
            } else {
                this.epM.quit();
            }
        }
    }

    public static final class b implements Runnable {
        private InputStream esB = null;
        private volatile boolean esC = false;
        private final BluetoothSocket esv;
        private b esx;
        a esy;

        public b(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            this.esv = bluetoothSocket;
            this.esx = bVar;
            this.esy = aVar;
            try {
                this.esB = bluetoothSocket.getInputStream();
            } catch (IOException e) {
                this.esB = null;
                v.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", new Object[]{e.toString()});
            }
        }

        public final void run() {
            v.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
            if (this.esB == null) {
                v.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
                return;
            }
            Object obj = new byte[2048];
            while (!this.esC) {
                try {
                    int read = this.esB.read(obj);
                    if (read > 0) {
                        v.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", new Object[]{Integer.valueOf(read)});
                        v.d("MicroMsg.exdevice.RecvThread", "data dump = %s", new Object[]{com.tencent.mm.plugin.exdevice.j.b.w(obj, read)});
                        Object obj2 = new byte[read];
                        System.arraycopy(obj, 0, obj2, 0, read);
                        if (this.esy != null) {
                            this.esy.esn.b(this.esx.epy, obj2);
                        }
                    }
                } catch (IOException e) {
                    v.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", new Object[]{e.toString()});
                    try {
                        this.esv.close();
                        return;
                    } catch (IOException e2) {
                        v.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", new Object[]{e2.toString()});
                        return;
                    }
                }
            }
            v.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
        }

        public final void cancel() {
            v.i("MicroMsg.exdevice.RecvThread", "------cancel------");
            if (this.esC) {
                v.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
                return;
            }
            this.esC = true;
            e.H(this);
            try {
                this.esv.close();
            } catch (IOException e) {
                v.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", new Object[]{e});
            }
        }
    }

    public static final class c implements Runnable {
        private volatile boolean esC = false;
        private volatile Runnable esD = null;
        private OutputStream esE = null;
        private final LinkedList<byte[]> esF = new LinkedList();
        private final LinkedList<byte[]> esG = new LinkedList();
        private b esx = null;
        private a esy = null;

        public c(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
            this.esx = bVar;
            this.esy = aVar;
            try {
                OutputStream outputStream = bluetoothSocket.getOutputStream();
                this.esD = this;
                this.esE = outputStream;
            } catch (IOException e) {
                v.e("MicroMsg.exdevice.SendThread", "temp sockets not created", new Object[]{e});
                this.esE = null;
                if (this.esy != null) {
                    this.esy.esn.b(this.esx.epy, 11, "Can not get write stream");
                }
            }
        }

        public final void run() {
            v.i("MicroMsg.exdevice.SendThread", "BEGIN SendThread");
            if (this.esE != null) {
                while (!this.esC) {
                    if (this.esD == null) {
                        v.w("MicroMsg.exdevice.SendThread", "Send thread has been close. just leave");
                        return;
                    } else if (!this.esG.isEmpty()) {
                        try {
                            this.esE.write((byte[]) this.esG.pop());
                            if (this.esy != null) {
                                this.esy.esn.e(this.esx.epy, true);
                            }
                        } catch (IOException e) {
                            if (this.esy != null) {
                                this.esy.esn.e(this.esx.epy, false);
                            }
                        }
                    } else if (this.esF.isEmpty()) {
                        synchronized (this) {
                            try {
                                wait();
                            } catch (Throwable e2) {
                                v.a("MicroMsg.exdevice.SendThread", e2, "", new Object[0]);
                                v.w("MicroMsg.exdevice.SendThread", "BluetoothChatThread_SendRunnable InterruptedException...");
                            }
                        }
                    } else {
                        synchronized (this.esF) {
                            Assert.assertTrue(this.esG.addAll(this.esF));
                            this.esF.clear();
                        }
                    }
                }
            }
        }

        public final boolean ad(byte[] bArr) {
            v.i("MicroMsg.exdevice.SendThread", "------write------buffer length = %d", new Object[]{Integer.valueOf(bArr.length)});
            if (this.esD == null) {
                v.e("MicroMsg.exdevice.SendThread", "Send thread has been close. Send data abort");
                return false;
            }
            synchronized (this) {
                this.esF.add(bArr);
                notify();
            }
            return true;
        }

        public final void cancel() {
            this.esD = null;
            this.esC = true;
            synchronized (this) {
                notify();
            }
            this.esG.clear();
            this.esF.clear();
        }
    }
}
