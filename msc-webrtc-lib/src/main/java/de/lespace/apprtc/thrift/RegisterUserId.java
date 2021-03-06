// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2017-02-19T11:45:33.007Z
// Source: /Users/nico/Documents/projekte/msc-webrtc/thrifty/webrtc.thrift at 14:1
package de.lespace.apprtc.thrift;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.Struct;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.TType;
import com.microsoft.thrifty.ThriftField;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class RegisterUserId implements Struct {
  public static final Adapter<RegisterUserId, Builder> ADAPTER = new RegisterUserIdAdapter();

  @ThriftField(
      fieldId = 1,
      isRequired = true
  )
  public final String userId;

  @ThriftField(
      fieldId = 2,
      isRequired = true
  )
  public final String firebaseToken;

  private RegisterUserId(Builder builder) {
    this.userId = builder.userId;
    this.firebaseToken = builder.firebaseToken;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (!(other instanceof RegisterUserId)) return false;
    RegisterUserId that = (RegisterUserId) other;
    return (this.userId == that.userId || this.userId.equals(that.userId))
        && (this.firebaseToken == that.firebaseToken || this.firebaseToken.equals(that.firebaseToken));
  }

  @Override
  public int hashCode() {
    int code = 16777619;
    code ^= this.userId.hashCode();
    code *= 0x811c9dc5;
    code ^= this.firebaseToken.hashCode();
    code *= 0x811c9dc5;
    return code;
  }

  @Override
  public String toString() {
    return "RegisterUserId{userId=" + this.userId + ", firebaseToken=" + this.firebaseToken + "}";
  }

  @Override
  public void write(Protocol protocol) throws IOException {
    ADAPTER.write(protocol, this);
  }

  public static final class Builder implements StructBuilder<RegisterUserId> {
    private String userId;

    private String firebaseToken;

    public Builder() {
    }

    public Builder(RegisterUserId struct) {
      this.userId = struct.userId;
      this.firebaseToken = struct.firebaseToken;
    }

    public Builder userId(String userId) {
      if (userId == null) {
        throw new NullPointerException("Required field 'userId' cannot be null");
      }
      this.userId = userId;
      return this;
    }

    public Builder firebaseToken(String firebaseToken) {
      if (firebaseToken == null) {
        throw new NullPointerException("Required field 'firebaseToken' cannot be null");
      }
      this.firebaseToken = firebaseToken;
      return this;
    }

    @Override
    public RegisterUserId build() {
      if (this.userId == null) {
        throw new IllegalStateException("Required field 'userId' is missing");
      }
      if (this.firebaseToken == null) {
        throw new IllegalStateException("Required field 'firebaseToken' is missing");
      }
      return new RegisterUserId(this);
    }

    @Override
    public void reset() {
      this.userId = null;
      this.firebaseToken = null;
    }
  }

  private static final class RegisterUserIdAdapter implements Adapter<RegisterUserId, Builder> {
    @Override
    public void write(Protocol protocol, RegisterUserId struct) throws IOException {
      protocol.writeStructBegin("RegisterUserId");
      protocol.writeFieldBegin("userId", 1, TType.STRING);
      protocol.writeString(struct.userId);
      protocol.writeFieldEnd();
      protocol.writeFieldBegin("firebaseToken", 2, TType.STRING);
      protocol.writeString(struct.firebaseToken);
      protocol.writeFieldEnd();
      protocol.writeFieldStop();
      protocol.writeStructEnd();
    }

    @Override
    public RegisterUserId read(Protocol protocol, Builder builder) throws IOException {
      protocol.readStructBegin();
      while (true) {
        FieldMetadata field = protocol.readFieldBegin();
        if (field.typeId == TType.STOP) {
          break;
        }
        switch (field.fieldId) {
          case 1: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.userId(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          case 2: {
            if (field.typeId == TType.STRING) {
              String value = protocol.readString();
              builder.firebaseToken(value);
            } else {
              ProtocolUtil.skip(protocol, field.typeId);
            }
          }
          break;
          default: {
            ProtocolUtil.skip(protocol, field.typeId);
          }
          break;
        }
        protocol.readFieldEnd();
      }
      protocol.readStructEnd();
      return builder.build();
    }

    @Override
    public RegisterUserId read(Protocol protocol) throws IOException {
      return read(protocol, new Builder());
    }
  }
}
