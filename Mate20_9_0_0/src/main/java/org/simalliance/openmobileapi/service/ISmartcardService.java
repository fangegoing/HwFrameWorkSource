package org.simalliance.openmobileapi.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISmartcardService extends IInterface {

    public static abstract class Stub extends Binder implements ISmartcardService {
        private static final String DESCRIPTOR = "org.simalliance.openmobileapi.service.ISmartcardService";
        static final int TRANSACTION_closeChannel = 1;
        static final int TRANSACTION_getAtr = 4;
        static final int TRANSACTION_getReader = 10;
        static final int TRANSACTION_getReaders = 2;
        static final int TRANSACTION_getSelectResponse = 9;
        static final int TRANSACTION_isCardPresent = 3;
        static final int TRANSACTION_isNFCEventAllowed = 11;
        static final int TRANSACTION_openBasicChannel = 5;
        static final int TRANSACTION_openBasicChannelAid = 6;
        static final int TRANSACTION_openLogicalChannel = 7;
        static final int TRANSACTION_registerCallback = 12;
        static final int TRANSACTION_transmit = 8;
        static final int TRANSACTION_unregisterCallback = 13;

        private static class Proxy implements ISmartcardService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void closeChannel(long hChannel, SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(hChannel);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public String[] getReaders(SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    String[] _result = _reply.createStringArray();
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean isCardPresent(String reader, SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(reader);
                    boolean z = false;
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        z = true;
                    }
                    boolean _result = z;
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public byte[] getAtr(String reader, SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(reader);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    byte[] _result = _reply.createByteArray();
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long openBasicChannel(String reader, ISmartcardServiceCallback callback, SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(reader);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long openBasicChannelAid(String reader, byte[] aid, ISmartcardServiceCallback callback, SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(reader);
                    _data.writeByteArray(aid);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public long openLogicalChannel(String reader, byte[] aid, ISmartcardServiceCallback callback, SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(reader);
                    _data.writeByteArray(aid);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    long _result = _reply.readLong();
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public byte[] transmit(long hChannel, byte[] command, SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(hChannel);
                    _data.writeByteArray(command);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    byte[] _result = _reply.createByteArray();
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public byte[] getSelectResponse(long hChannel, SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(hChannel);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    byte[] _result = _reply.createByteArray();
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public ISmartcardServiceReader getReader(String reader, SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(reader);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    ISmartcardServiceReader _result = org.simalliance.openmobileapi.service.ISmartcardServiceReader.Stub.asInterface(_reply.readStrongBinder());
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public boolean[] isNFCEventAllowed(String reader, byte[] aid, String[] packageNames, ISmartcardServiceCallback callback, SmartcardError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(reader);
                    _data.writeByteArray(aid);
                    _data.writeStringArray(packageNames);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    boolean[] _result = _reply.createBooleanArray();
                    if (_reply.readInt() != 0) {
                        error.readFromParcel(_reply);
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } catch (Throwable th) {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void registerCallback(ISmartcardServiceCallback cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(cb != null ? cb.asBinder() : null);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            public void unregisterCallback(ISmartcardServiceCallback cb) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(cb != null ? cb.asBinder() : null);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISmartcardService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof ISmartcardService)) {
                return new Proxy(obj);
            }
            return (ISmartcardService) iin;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i = code;
            Parcel parcel = data;
            Parcel parcel2 = reply;
            String descriptor = DESCRIPTOR;
            if (i != 1598968902) {
                long _arg0;
                SmartcardError _arg1;
                String _arg02;
                SmartcardError _arg12;
                byte[] _result;
                byte[] _arg13;
                ISmartcardServiceCallback _arg2;
                SmartcardError _arg3;
                long _result2;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(descriptor);
                        _arg0 = data.readLong();
                        _arg1 = new SmartcardError();
                        closeChannel(_arg0, _arg1);
                        reply.writeNoException();
                        parcel2.writeInt(1);
                        _arg1.writeToParcel(parcel2, 1);
                        return true;
                    case 2:
                        parcel.enforceInterface(descriptor);
                        SmartcardError _arg03 = new SmartcardError();
                        String[] _result3 = getReaders(_arg03);
                        reply.writeNoException();
                        parcel2.writeStringArray(_result3);
                        parcel2.writeInt(1);
                        _arg03.writeToParcel(parcel2, 1);
                        return true;
                    case 3:
                        parcel.enforceInterface(descriptor);
                        _arg02 = data.readString();
                        _arg12 = new SmartcardError();
                        boolean _result4 = isCardPresent(_arg02, _arg12);
                        reply.writeNoException();
                        parcel2.writeInt(_result4);
                        parcel2.writeInt(1);
                        _arg12.writeToParcel(parcel2, 1);
                        return true;
                    case 4:
                        parcel.enforceInterface(descriptor);
                        _arg02 = data.readString();
                        _arg12 = new SmartcardError();
                        _result = getAtr(_arg02, _arg12);
                        reply.writeNoException();
                        parcel2.writeByteArray(_result);
                        parcel2.writeInt(1);
                        _arg12.writeToParcel(parcel2, 1);
                        return true;
                    case 5:
                        parcel.enforceInterface(descriptor);
                        _arg02 = data.readString();
                        ISmartcardServiceCallback _arg14 = org.simalliance.openmobileapi.service.ISmartcardServiceCallback.Stub.asInterface(data.readStrongBinder());
                        _arg1 = new SmartcardError();
                        long _result5 = openBasicChannel(_arg02, _arg14, _arg1);
                        reply.writeNoException();
                        parcel2.writeLong(_result5);
                        parcel2.writeInt(1);
                        _arg1.writeToParcel(parcel2, 1);
                        return true;
                    case 6:
                        parcel.enforceInterface(descriptor);
                        _arg02 = data.readString();
                        _arg13 = data.createByteArray();
                        _arg2 = org.simalliance.openmobileapi.service.ISmartcardServiceCallback.Stub.asInterface(data.readStrongBinder());
                        _arg3 = new SmartcardError();
                        _result2 = openBasicChannelAid(_arg02, _arg13, _arg2, _arg3);
                        reply.writeNoException();
                        parcel2.writeLong(_result2);
                        parcel2.writeInt(1);
                        _arg3.writeToParcel(parcel2, 1);
                        return true;
                    case 7:
                        parcel.enforceInterface(descriptor);
                        _arg02 = data.readString();
                        _arg13 = data.createByteArray();
                        _arg2 = org.simalliance.openmobileapi.service.ISmartcardServiceCallback.Stub.asInterface(data.readStrongBinder());
                        _arg3 = new SmartcardError();
                        _result2 = openLogicalChannel(_arg02, _arg13, _arg2, _arg3);
                        reply.writeNoException();
                        parcel2.writeLong(_result2);
                        parcel2.writeInt(1);
                        _arg3.writeToParcel(parcel2, 1);
                        return true;
                    case 8:
                        parcel.enforceInterface(descriptor);
                        _arg0 = data.readLong();
                        _result = data.createByteArray();
                        _arg3 = new SmartcardError();
                        byte[] _result6 = transmit(_arg0, _result, _arg3);
                        reply.writeNoException();
                        parcel2.writeByteArray(_result6);
                        parcel2.writeInt(1);
                        _arg3.writeToParcel(parcel2, 1);
                        return true;
                    case 9:
                        parcel.enforceInterface(descriptor);
                        _arg0 = data.readLong();
                        _arg1 = new SmartcardError();
                        byte[] _result7 = getSelectResponse(_arg0, _arg1);
                        reply.writeNoException();
                        parcel2.writeByteArray(_result7);
                        parcel2.writeInt(1);
                        _arg1.writeToParcel(parcel2, 1);
                        return true;
                    case 10:
                        parcel.enforceInterface(descriptor);
                        _arg02 = data.readString();
                        _arg12 = new SmartcardError();
                        ISmartcardServiceReader _result8 = getReader(_arg02, _arg12);
                        reply.writeNoException();
                        parcel2.writeStrongBinder(_result8 != null ? _result8.asBinder() : null);
                        parcel2.writeInt(1);
                        _arg12.writeToParcel(parcel2, 1);
                        return true;
                    case 11:
                        parcel.enforceInterface(descriptor);
                        String _arg04 = data.readString();
                        byte[] _arg15 = data.createByteArray();
                        String[] _arg22 = data.createStringArray();
                        ISmartcardServiceCallback _arg32 = org.simalliance.openmobileapi.service.ISmartcardServiceCallback.Stub.asInterface(data.readStrongBinder());
                        SmartcardError _arg4 = new SmartcardError();
                        SmartcardError _arg42 = _arg4;
                        boolean[] _result9 = isNFCEventAllowed(_arg04, _arg15, _arg22, _arg32, _arg4);
                        reply.writeNoException();
                        parcel2.writeBooleanArray(_result9);
                        parcel2.writeInt(1);
                        _arg42.writeToParcel(parcel2, 1);
                        return true;
                    case 12:
                        parcel.enforceInterface(descriptor);
                        registerCallback(org.simalliance.openmobileapi.service.ISmartcardServiceCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface(descriptor);
                        unregisterCallback(org.simalliance.openmobileapi.service.ISmartcardServiceCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        return true;
                    default:
                        return super.onTransact(code, data, reply, flags);
                }
            }
            parcel2.writeString(descriptor);
            return true;
        }
    }

    void closeChannel(long j, SmartcardError smartcardError) throws RemoteException;

    byte[] getAtr(String str, SmartcardError smartcardError) throws RemoteException;

    ISmartcardServiceReader getReader(String str, SmartcardError smartcardError) throws RemoteException;

    String[] getReaders(SmartcardError smartcardError) throws RemoteException;

    byte[] getSelectResponse(long j, SmartcardError smartcardError) throws RemoteException;

    boolean isCardPresent(String str, SmartcardError smartcardError) throws RemoteException;

    boolean[] isNFCEventAllowed(String str, byte[] bArr, String[] strArr, ISmartcardServiceCallback iSmartcardServiceCallback, SmartcardError smartcardError) throws RemoteException;

    long openBasicChannel(String str, ISmartcardServiceCallback iSmartcardServiceCallback, SmartcardError smartcardError) throws RemoteException;

    long openBasicChannelAid(String str, byte[] bArr, ISmartcardServiceCallback iSmartcardServiceCallback, SmartcardError smartcardError) throws RemoteException;

    long openLogicalChannel(String str, byte[] bArr, ISmartcardServiceCallback iSmartcardServiceCallback, SmartcardError smartcardError) throws RemoteException;

    void registerCallback(ISmartcardServiceCallback iSmartcardServiceCallback) throws RemoteException;

    byte[] transmit(long j, byte[] bArr, SmartcardError smartcardError) throws RemoteException;

    void unregisterCallback(ISmartcardServiceCallback iSmartcardServiceCallback) throws RemoteException;
}
