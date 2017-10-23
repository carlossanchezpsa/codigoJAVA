/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: MsgActivityType.java,v 1.1 2008/01/11 17:12:12 e243060 Exp $
 */

package com.inetpsa.boz.rpv.rp.xml;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import java.util.ArrayList;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class MsgActivityType.
 * 
 * @version $Revision: 1.1 $ $Date: 2008/01/11 17:12:12 $
 */
public class MsgSubsidiaryType implements java.io.Serializable {

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
	// private com.inetpsa.boz.rpv.rp.xml.types.MarquePSAType _AP_AC;
	private java.lang.String _AP_AC;

	/*
	 * /** Field _INDIVIDUALList
	 */
	// private java.util.ArrayList _INDIVIDUALList;

	private java.util.ArrayList _DEALERList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public MsgSubsidiaryType() {
		super();
		// _INDIVIDUALList = new ArrayList();
		_DEALERList = new ArrayList();
	} // -- com.inetpsa.boz.rpv.xml.MsgActivityType()

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Method addINDIVIDUAL
	 * 
	 * 
	 * 
	 * @param vINDIVIDUAL
	 */
	/*
	 * public void addINDIVIDUAL(com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL
	 * vINDIVIDUAL) throws java.lang.IndexOutOfBoundsException {
	 * _INDIVIDUALList.add(vINDIVIDUAL); } // -- void
	 * addINDIVIDUAL(com.inetpsa.boz.rpv.xml.INDIVIDUAL)
	 */

	/**
	 * Method addDEALER
	 * 
	 * 
	 * 
	 * @param vDEALER
	 */
	public void addDEALER(com.inetpsa.boz.rpv.rp.xml.DEALER vDEALER) throws java.lang.IndexOutOfBoundsException {
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
	public void addDEALER(int index, com.inetpsa.boz.rpv.rp.xml.DEALER vDEALER) throws java.lang.IndexOutOfBoundsException {
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
		return new org.exolab.castor.util.IteratorEnumeration(_DEALERList.iterator());
	} // -- java.util.Enumeration enumerateDEALER()

	/**
	 * Method enumerateDEALER
	 * 
	 * 
	 * 
	 * @return Enumeration
	 */

	/**
	 * Method addINDIVIDUAL
	 * 
	 * 
	 * 
	 * @param index
	 * @param vINDIVIDUAL
	 */
	/*
	 * public void addINDIVIDUAL(int index,
	 * com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL vINDIVIDUAL) throws
	 * java.lang.IndexOutOfBoundsException { _INDIVIDUALList.add(index,
	 * vINDIVIDUAL); } // -- void addINDIVIDUAL(int,
	 * com.inetpsa.boz.rpv.xml.INDIVIDUAL)
	 */

	/**
	 * Method clearINDIVIDUAL
	 * 
	 */
	/*
	 * public void clearINDIVIDUAL() { _INDIVIDUALList.clear(); } // -- void
	 * clearINDIVIDUAL()
	 */

	/**
	 * Method enumerateINDIVIDUAL
	 * 
	 * 
	 * 
	 * @return Enumeration
	 */
	/*
	 * public java.util.Enumeration enumerateINDIVIDUAL() { return new
	 * org.exolab.castor.util.IteratorEnumeration(_INDIVIDUALList.iterator()); }
	 * // -- java.util.Enumeration enumerateINDIVIDUAL()
	 */

	/**
	 * Returns the value of field 'DEALER_CODE'.
	 * 
	 * @return String
	 * @return the value of field 'DEALER_CODE'.
	 */
	public java.lang.String getCOUNTRY_CODE() {
		return this._COUNTRY_CODE;
	} // -- java.lang.String getCOUNTRY_CODE()

	/**
	 * Sets the value of field 'COUNTRY_CODE'.
	 * 
	 * @param DATE
	 *            the value of field 'COUNTRY_CODE'.
	 */
	public void setCOUNTRY_CODE(java.lang.String COUNTRY_CODE) {
		this._COUNTRY_CODE = COUNTRY_CODE;
	} // -- void setCOUNTRY_CODE(java.lang.String)

	/**
	 * Returns the value of field 'AP_AC'.
	 * 
	 * @return MarquePSAType
	 * @return the value of field 'AP_AC'.
	 */
	/*
	 * public com.inetpsa.boz.rpv.rp.xml.types.MarquePSAType getAP_AC() { return
	 * this._AP_AC; } // -- com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType
	 * getAP_AC()
	 */

	public java.lang.String getAP_AC() {
		return this._AP_AC;
	} // -- com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType getAP_AC()

	/**
	 * Sets the value of field 'AP_AC'.
	 * 
	 * @param AP_AC
	 *            the value of field 'AP_AC'.
	 */
	/*
	 * public void setAP_AC(com.inetpsa.boz.rpv.rp.xml.types.MarquePSAType
	 * AP_AC) { this._AP_AC = AP_AC; } // -- void
	 * setAP_AC(com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType)
	 */

	public void setAP_AC(java.lang.String AP_AC) {
		this._AP_AC = AP_AC;
	} // -- void setAP_AC(com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType)

	/**
	 * Method getINDIVIDUAL
	 * 
	 * 
	 * 
	 * @param index
	 * @return INDIVIDUAL
	 */
	/*
	 * public com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL getINDIVIDUAL(int index)
	 * throws java.lang.IndexOutOfBoundsException { // -- check bounds for index
	 * if ((index < 0) || (index > _INDIVIDUALList.size())) { throw new
	 * IndexOutOfBoundsException(); }
	 * 
	 * return (com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL)
	 * _INDIVIDUALList.get(index); } // -- com.inetpsa.boz.rpv.xml.INDIVIDUAL
	 * getINDIVIDUAL(int)
	 */

	/**
	 * Method getINDIVIDUAL
	 * 
	 * 
	 * 
	 * @return INDIVIDUAL
	 */
	/*
	 * public com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL[] getINDIVIDUAL() { int
	 * size = _INDIVIDUALList.size(); com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL[]
	 * mArray = new com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL[size]; for (int index
	 * = 0; index < size; index++) { mArray[index] =
	 * (com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL) _INDIVIDUALList.get(index); }
	 * return mArray; } // -- com.inetpsa.boz.rpv.xml.INDIVIDUAL[]
	 * getINDIVIDUAL()
	 */

	/**
	 * Method getINDIVIDUALCount
	 * 
	 * 
	 * 
	 * @return int
	 */
	/*
	 * public int getINDIVIDUALCount() { return _INDIVIDUALList.size(); } // --
	 * int getINDIVIDUALCount()
	 */
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
	public void marshal(java.io.Writer out) throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {

		Marshaller.marshal(this, out);
	} // -- void marshal(java.io.Writer)

	/**
	 * Method marshal
	 * 
	 * 
	 * 
	 * @param handler
	 */
	public void marshal(org.xml.sax.ContentHandler handler) throws java.io.IOException, org.exolab.castor.xml.MarshalException,
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
	public boolean removeDEALER(com.inetpsa.boz.rpv.rp.xml.DEALER vDEALER) {
		boolean removed = _DEALERList.remove(vDEALER);
		return removed;
	} // -- boolean removeDEALER(com.inetpsa.boz.rpv.xml.DEALER)

	/**
	 * Method getDEALER
	 * 
	 * 
	 * 
	 * @param index
	 * @return DEALER
	 */
	public com.inetpsa.boz.rpv.rp.xml.DEALER getDEALER(int index) throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _DEALERList.size())) {
			throw new IndexOutOfBoundsException();
		}

		return (com.inetpsa.boz.rpv.rp.xml.DEALER) _DEALERList.get(index);
	} // -- com.inetpsa.boz.rpv.xml.DEALER getDEALER(int)

	/**
	 * Method getDEALER
	 * 
	 * 
	 * 
	 * @return DEALER
	 */
	public com.inetpsa.boz.rpv.rp.xml.DEALER[] getDEALER() {
		int size = _DEALERList.size();
		com.inetpsa.boz.rpv.rp.xml.DEALER[] mArray = new com.inetpsa.boz.rpv.rp.xml.DEALER[size];
		for (int index = 0; index < size; index++) {
			mArray[index] = (com.inetpsa.boz.rpv.rp.xml.DEALER) _DEALERList.get(index);
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
	 * Method setDEALER
	 * 
	 * 
	 * 
	 * @param index
	 * @param vDEALER
	 */
	public void setDEALER(int index, com.inetpsa.boz.rpv.rp.xml.DEALER vDEALER) throws java.lang.IndexOutOfBoundsException {
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
	public void setDEALER(com.inetpsa.boz.rpv.rp.xml.DEALER[] DEALERArray) {
		// -- copy array
		_DEALERList.clear();
		for (int i = 0; i < DEALERArray.length; i++) {
			_DEALERList.add(DEALERArray[i]);
		}
	} // -- void setDEALER(com.inetpsa.boz.rpv.xml.DEALER)

	/**
	 * Method removeINDIVIDUAL
	 * 
	 * 
	 * 
	 * @param vINDIVIDUAL
	 * @return boolean
	 */
	/*
	 * public boolean removeINDIVIDUAL(com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL
	 * vINDIVIDUAL) { boolean removed = _INDIVIDUALList.remove(vINDIVIDUAL);
	 * return removed; } // -- boolean
	 * removeINDIVIDUAL(com.inetpsa.boz.rpv.xml.INDIVIDUAL)
	 */
	/*
	 * setDEALER_CODE(java.lang.String)
	 * 
	 * 
	 * /** Method setINDIVIDUAL
	 * 
	 * 
	 * 
	 * @param index
	 * 
	 * @param vINDIVIDUAL
	 */
	/*
	 * public void setINDIVIDUAL(int index,
	 * com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL vINDIVIDUAL) throws
	 * java.lang.IndexOutOfBoundsException { // -- check bounds for index if
	 * ((index < 0) || (index > _INDIVIDUALList.size())) { throw new
	 * IndexOutOfBoundsException(); } _INDIVIDUALList.set(index, vINDIVIDUAL); }
	 * // -- void setINDIVIDUAL(int, com.inetpsa.boz.rpv.xml.INDIVIDUAL)
	 */

	/**
	 * Method setINDIVIDUAL
	 * 
	 * 
	 * 
	 * @param INDIVIDUALArray
	 */
	/*
	 * public void setINDIVIDUAL(com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL[]
	 * INDIVIDUALArray) { // -- copy array _INDIVIDUALList.clear(); for (int i =
	 * 0; i < INDIVIDUALArray.length; i++) {
	 * _INDIVIDUALList.add(INDIVIDUALArray[i]); } } // -- void
	 * setINDIVIDUAL(com.inetpsa.boz.rpv.xml.INDIVIDUAL)
	 */

	/**
	 * Method unmarshal
	 * 
	 * 
	 * 
	 * @param reader
	 * @return Object
	 */
	public static java.lang.Object unmarshal(java.io.Reader reader) throws org.exolab.castor.xml.MarshalException,
			org.exolab.castor.xml.ValidationException {
		return (com.inetpsa.boz.rpv.rp.xml.MsgSubsidiaryType) Unmarshaller.unmarshal(com.inetpsa.boz.rpv.rp.xml.MsgSubsidiaryType.class, reader);
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
