/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: MsgHeaderType.java,v 1.1 2008/01/11 17:12:12 e243060 Exp $
 */

package com.inetpsa.boz.rpv.ecm.xml.f2016;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import java.util.ArrayList;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class MsgHeaderType.
 * 
 * @version $Revision: 1.1 $ $Date: 2008/01/11 17:12:12 $
 */
public class MsgHeaderType implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _COUNTRY_CODE
	 */
	private java.lang.String _COUNTRY_CODE;

	/**
	 * Field _AP_AC
	 */
	private com.inetpsa.boz.rpv.xml.types.MarquePSAType _AP_AC;

	/**
	 * Field _FIRST_DATE
	 */
	private java.lang.String _FIRST_DATE;

	/**
	 * Field _PERIOD
	 */
	private java.lang.String _PERIOD;
	/**
	 * Field _LAST_DATE
	 */
	private java.lang.String _LAST_DATE;

	/**
	 * Field _FILE_TYPE
	 */
	private java.lang.String _FILE_TYPE;

	/**
	 * Field _TRANSFER_DATE
	 */
	private java.lang.String _TRANSFER_DATE;

	/**
	 * Field _EXTRACT_VERSION
	 */
	private java.lang.String _EXTRACT_VERSION;

	/**
	 * Field _DEALERList
	 */
	private java.util.ArrayList _DEALERList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public MsgHeaderType() {
		super();
		_DEALERList = new ArrayList();
	} // -- com.inetpsa.boz.rpv.xml.MsgHeaderType()

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Method addDEALER
	 * 
	 * 
	 * 
	 * @param vDEALER
	 */
	public void addDEALER(com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER vDEALER)
			throws java.lang.IndexOutOfBoundsException {
		_DEALERList.add(vDEALER);
	} // -- void addDEALER(com.inetpsa.boz.rpv.xml.DEALER)

	/**
	 * Method addDEALER
	 * 
	 * 
	 * 
	 * @param index
	 * @param vDEALER
	 */
	public void addDEALER(int index,
			com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER vDEALER)
			throws java.lang.IndexOutOfBoundsException {
		_DEALERList.add(index, vDEALER);
	} // -- void addDEALER(int, com.inetpsa.boz.rpv.xml.DEALER)

	/**
	 * Method clearDEALER
	 * 
	 */
	public void clearDEALER() {
		_DEALERList.clear();
	} // -- void clearDEALER()

	/**
	 * Method enumerateDEALER
	 * 
	 * 
	 * 
	 * @return Enumeration
	 */
	public java.util.Enumeration enumerateDEALER() {
		return new org.exolab.castor.util.IteratorEnumeration(
				_DEALERList.iterator());
	} // -- java.util.Enumeration enumerateDEALER()

	/**
	 * Returns the value of field 'AP_AC'.
	 * 
	 * @return MarquePSAType
	 * @return the value of field 'AP_AC'.
	 */
	public com.inetpsa.boz.rpv.xml.types.MarquePSAType getAP_AC() {
		return this._AP_AC;
	} // -- com.inetpsa.boz.rpv.xml.types.MarquePSAType getAP_AC()

	/**
	 * Returns the value of field 'COUNTRY_CODE'.
	 * 
	 * @return String
	 * @return the value of field 'COUNTRY_CODE'.
	 */
	public java.lang.String getCOUNTRY_CODE() {
		return this._COUNTRY_CODE;
	} // -- java.lang.String getCOUNTRY_CODE()

	/**
	 * Method getDEALER
	 * 
	 * 
	 * 
	 * @param index
	 * @return DEALER
	 */
	public com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER getDEALER(int index)
			throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _DEALERList.size())) {
			throw new IndexOutOfBoundsException();
		}

		return (com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER) _DEALERList
				.get(index);
	} // -- com.inetpsa.boz.rpv.xml.DEALER getDEALER(int)

	/**
	 * Method getDEALER
	 * 
	 * 
	 * 
	 * @return DEALER
	 */
	public com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER[] getDEALER() {
		int size = _DEALERList.size();
		com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER[] mArray = new com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER[size];
		for (int index = 0; index < size; index++) {
			mArray[index] = (com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER) _DEALERList
					.get(index);
		}
		return mArray;
	} // -- com.inetpsa.boz.rpv.xml.DEALER[] getDEALER()

	/**
	 * Method getDEALERCount
	 * 
	 * 
	 * 
	 * @return int
	 */
	public int getDEALERCount() {
		return _DEALERList.size();
	} // -- int getDEALERCount()

	/**
	 * Returns the value of field 'EXTRACT_VERSION'.
	 * 
	 * @return String
	 * @return the value of field 'EXTRACT_VERSION'.
	 */
	public java.lang.String getEXTRACT_VERSION() {
		return this._EXTRACT_VERSION;
	} // -- java.lang.String getEXTRACT_VERSION()

	/**
	 * Returns the value of field 'FILE_TYPE'.
	 * 
	 * @return String
	 * @return the value of field 'FILE_TYPE'.
	 */
	public java.lang.String getFILE_TYPE() {
		return this._FILE_TYPE;
	} // -- java.lang.String getFILE_TYPE()

	/**
	 * Returns the value of field 'FIRST_DATE'.
	 * 
	 * @return String
	 * @return the value of field 'FIRST_DATE'.
	 */
	public java.lang.String getFIRST_DATE() {
		return this._FIRST_DATE;
	} // -- java.lang.String getFIRST_DATE()

	/**
	 * Returns the value of field 'LAST_DATE'.
	 * 
	 * @return String
	 * @return the value of field 'LAST_DATE'.
	 */
	public java.lang.String getLAST_DATE() {
		return this._LAST_DATE;
	} // -- java.lang.String getLAST_DATE()

	/**
	 * Returns the value of field 'TRANSFER_DATE'.
	 * 
	 * @return String
	 * @return the value of field 'TRANSFER_DATE'.
	 */
	public java.lang.String getTRANSFER_DATE() {
		return this._TRANSFER_DATE;
	} // -- java.lang.String getTRANSFER_DATE()

	/**
	 * Returns the value of field 'PERIOD'.
	 * 
	 * @return String
	 * @return the value of field 'PERIOD'.
	 */
	public java.lang.String getPERIOD() {
		return this._PERIOD;
	} // -- java.lang.String getPERIOD()

	/**
	 * Method isValid
	 * 
	 * 
	 * 
	 * @return boolean
	 */
	public boolean isValid() {
		try {
			validate();
		} catch (org.exolab.castor.xml.ValidationException vex) {
			return false;
		}
		return true;
	} // -- boolean isValid()

	/**
	 * Method marshal
	 * 
	 * 
	 * 
	 * @param out
	 */
	public void marshal(java.io.Writer out)
			throws org.exolab.castor.xml.MarshalException,
			org.exolab.castor.xml.ValidationException {

		Marshaller.marshal(this, out);
	} // -- void marshal(java.io.Writer)

	/**
	 * Method marshal
	 * 
	 * 
	 * 
	 * @param handler
	 */
	public void marshal(org.xml.sax.ContentHandler handler)
			throws java.io.IOException, org.exolab.castor.xml.MarshalException,
			org.exolab.castor.xml.ValidationException {

		Marshaller.marshal(this, handler);
	} // -- void marshal(org.xml.sax.ContentHandler)

	/**
	 * Method removeDEALER
	 * 
	 * 
	 * 
	 * @param vDEALER
	 * @return boolean
	 */
	public boolean removeDEALER(com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER vDEALER) {
		boolean removed = _DEALERList.remove(vDEALER);
		return removed;
	} // -- boolean removeDEALER(com.inetpsa.boz.rpv.xml.DEALER)

	/**
	 * Sets the value of field 'AP_AC'.
	 * 
	 * @param AP_AC
	 *            the value of field 'AP_AC'.
	 */
	public void setAP_AC(com.inetpsa.boz.rpv.xml.types.MarquePSAType AP_AC) {
		this._AP_AC = AP_AC;
	} // -- void setAP_AC(com.inetpsa.boz.rpv.xml.types.MarquePSAType)

	/**
	 * Sets the value of field 'COUNTRY_CODE'.
	 * 
	 * @param COUNTRY_CODE
	 *            the value of field 'COUNTRY_CODE'.
	 */
	public void setCOUNTRY_CODE(java.lang.String COUNTRY_CODE) {
		this._COUNTRY_CODE = COUNTRY_CODE;
	} // -- void setCOUNTRY_CODE(java.lang.String)

	/**
	 * Sets the value of field 'COUNTRY_CODE'.
	 * 
	 * @param PERIOD
	 *            the value of field 'PERIOD'.
	 */
	public void setPERIOD(java.lang.String PERIOD) {
		this._PERIOD = PERIOD;
	} // -- void setPERIOD(java.lang.String)

	/**
	 * Method setDEALER
	 * 
	 * 
	 * 
	 * @param index
	 * @param vDEALER
	 */
	public void setDEALER(int index,
			com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER vDEALER)
			throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _DEALERList.size())) {
			throw new IndexOutOfBoundsException();
		}
		_DEALERList.set(index, vDEALER);
	} // -- void setDEALER(int, com.inetpsa.boz.rpv.xml.DEALER)

	/**
	 * Method setDEALER
	 * 
	 * 
	 * 
	 * @param DEALERArray
	 */
	public void setDEALER(com.inetpsa.boz.rpv.ecm.xml.f2016.DEALER[] DEALERArray) {
		// -- copy array
		_DEALERList.clear();
		for (int i = 0; i < DEALERArray.length; i++) {
			_DEALERList.add(DEALERArray[i]);
		}
	} // -- void setDEALER(com.inetpsa.boz.rpv.xml.DEALER)

	/**
	 * Sets the value of field 'EXTRACT_VERSION'.
	 * 
	 * @param EXTRACT_VERSION
	 *            the value of field 'EXTRACT_VERSION'.
	 */
	public void setEXTRACT_VERSION(java.lang.String EXTRACT_VERSION) {
		this._EXTRACT_VERSION = EXTRACT_VERSION;
	} // -- void setEXTRACT_VERSION(java.lang.String)

	/**
	 * Sets the value of field 'FILE_TYPE'.
	 * 
	 * @param FILE_TYPE
	 *            the value of field 'FILE_TYPE'.
	 */
	public void setFILE_TYPE(java.lang.String FILE_TYPE) {
		this._FILE_TYPE = FILE_TYPE;
	} // -- void setFILE_TYPE(java.lang.String)

	/**
	 * Sets the value of field 'FIRST_DATE'.
	 * 
	 * @param FIRST_DATE
	 *            the value of field 'FIRST_DATE'.
	 */
	public void setFIRST_DATE(java.lang.String FIRST_DATE) {
		this._FIRST_DATE = FIRST_DATE;
	} // -- void setFIRST_DATE(java.lang.String)

	/**
	 * Sets the value of field 'LAST_DATE'.
	 * 
	 * @param LAST_DATE
	 *            the value of field 'LAST_DATE'.
	 */
	public void setLAST_DATE(java.lang.String LAST_DATE) {
		this._LAST_DATE = LAST_DATE;
	} // -- void setLAST_DATE(java.lang.String)

	/**
	 * Sets the value of field 'TRANSFER_DATE'.
	 * 
	 * @param TRANSFER_DATE
	 *            the value of field 'TRANSFER_DATE'.
	 */
	public void setTRANSFER_DATE(java.lang.String TRANSFER_DATE) {
		this._TRANSFER_DATE = TRANSFER_DATE;
	} // -- void setTRANSFER_DATE(java.lang.String)

	/**
	 * Method unmarshal
	 * 
	 * 
	 * 
	 * @param reader
	 * @return Object
	 */
	public static java.lang.Object unmarshal(java.io.Reader reader)
			throws org.exolab.castor.xml.MarshalException,
			org.exolab.castor.xml.ValidationException {
		return (com.inetpsa.boz.rpv.ecm.xml.f2016.MsgHeaderType) Unmarshaller
				.unmarshal(
						com.inetpsa.boz.rpv.ecm.xml.f2016.MsgHeaderType.class,
						reader);
	} // -- java.lang.Object unmarshal(java.io.Reader)

	/**
	 * Method validate
	 * 
	 */
	public void validate() throws org.exolab.castor.xml.ValidationException {
		org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
		validator.validate(this);
	} // -- void validate()

}
