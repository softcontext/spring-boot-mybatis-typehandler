package com.example.web.typehandler;

import java.security.GeneralSecurityException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.NoSuchPaddingException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.example.web.util.EncryptionUtil;

public class PasswordTypeHandler implements TypeHandler<String> {
	
	// 복호화
	public String getResult(ResultSet rs, String columnName) throws SQLException {
		String retValue = null;
		try {
			retValue = EncryptionUtil.decrypt(rs.getBytes(columnName));
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return retValue;
	}

	// 복호화
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		String retValue = null;
		try {
			retValue = EncryptionUtil.decrypt(rs.getBytes(columnIndex));
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return retValue;
	}

	// 복호화
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String retValue = null;
		try {
			retValue = EncryptionUtil.decrypt(cs.getBytes(columnIndex));
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return retValue;
	}

	// 암호화
	public void setParameter(PreparedStatement ps, int i, String columnName, JdbcType jdbcType) throws SQLException {
		byte[] password = null;

		if (columnName != null)
			try {
				password = EncryptionUtil.encrypt(columnName);
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			}
		ps.setBytes(i, password);
	}
	
}
