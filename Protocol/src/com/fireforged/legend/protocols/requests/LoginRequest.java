package com.fireforged.legend.protocols.requests;

import java.io.Serializable;

/***************************************************************************************************
 * 
 * Name: LoginRequestObject
 * 
 * Description: Contains the details of an attempted login.
 * 
 * @author Chris Rhodes
 * 
 **************************************************************************************************/
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 463721109329576178L;

	private String _accountName;
	private byte[] _passwordHash;
	
	/***********************************************************************************************
	 * 
	 * Name: LoginRequestObject
	 * 
	 * Description: Constructor.
	 * 
	 * @param accountName 
	 * 
	 **********************************************************************************************/
	public LoginRequest(String accountName, byte[] passwordHash) {
		_accountName = accountName;
		_passwordHash = passwordHash;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getAccountName
	 * 
	 * Description: Returns the account name.
	 * 
	 * @return String The account name.
	 * 
	 **********************************************************************************************/
	public String getAccountName() {
		return _accountName;
	}
	
	/***********************************************************************************************
	 * 
	 * Name: getPasswordHash
	 * 
	 * Description: Returns the password hash.
	 * 
	 * @return String The password hash.
	 * 
	 **********************************************************************************************/
	public byte[] getPasswordHash() {
		return _passwordHash;
	}
	
}
