// Automatically generated by the Thrifty compiler; do not edit!
// Generated on: 2017-02-19T11:45:33.008Z
// Source: /Users/nico/Documents/projekte/msc-webrtc/thrifty/webrtc.thrift at 19:1
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

public final class RegisterResult implements Struct {
  public static final Adapter<RegisterResult, Builder> ADAPTER = new RegisterResultAdapter();

  @ThriftField(
      fieldId = 1,
      isRequired = true
  )
  public final String response;

  private RegisterResult(Builder builder) {
    this.response = builder.response;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (!(other instanceof RegisterResult)) return false;
    RegisterResult that = (RegisterResult) other;
    return (this.response == that.response || this.response.equals(that.response));
  }

  @Override
  public int hashCode() {
    int code = 16777619;
    code ^= this.response.hashCode();
    code *= 0x811c9dc5;
    return code;
  }

  @Override
  public String toString() {
    return "RegisterResult{response=" + this.response + "}";
  }

  @Override
  public void write(Protocol protocol) throws IOException {
    ADAPTER.write(protocol, this);
  }

  public static final class Builder implements StructBuilder<RegisterResult> {
    private String response;

    public Builder() {
    }

    public Builder(RegisterResult struct) {
      this.response = struct.response;
    }

    public Builder response(String response) {
      if (response == null) {
        throw new NullPointerException("Required field 'response' cannot be null");
      }
      this.response = response;
      return this;
    }

    @Override
    public RegisterResult build() {
      if (this.response == null) {
        throw new IllegalStateException("Required field 'response' is missing");
      }
      return new RegisterResult(this);
    }

    @Override
    public void reset() {
      this.response = null;
    }
  }

  private static final class RegisterResultAdapter implements Adapter<RegisterResult, Builder> {
    @Override
    public void write(Protocol protocol, RegisterResult struct) throws IOException {
      protocol.writeStructBegin("RegisterResult");
      protocol.writeFieldBegin("response", 1, TType.STRING);
      protocol.writeString(struct.response);
      protocol.writeFieldEnd();
      protocol.writeFieldStop();
      protocol.writeStructEnd();
    }

    @Override
    public RegisterResult read(Protocol protocol, Builder builder) throws IOException {
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
              builder.response(value);
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
    public RegisterResult read(Protocol protocol) throws IOException {
      return read(protocol, new Builder());
    }
  }
}
