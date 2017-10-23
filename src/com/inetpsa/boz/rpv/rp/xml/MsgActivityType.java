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
public class MsgActivityType implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _ACTIVITY_CODE
	 */
	private java.lang.String _ACTIVITY_CODE;

	/*
	 * /** Field _INDIVIDUALList
	 */
	// private java.util.ArrayList _INDIVIDUALList;

	private java.util.ArrayList _SUBSIDIARYList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public MsgActivityType() {
		super();
		// _INDIVIDUALList = new ArrayList();
		_SUBSIDIARYList = new ArrayList();
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
	 * Method addSUBSIDIARY
	 * 
	 * 
	 * 
	 * @param vSUBSIDIARY
	 */
	public void addSUBSIDIARY(com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY vSUBSIDIARY) throws java.lang.IndexOutOfBoundsException {
		_SUBSIDIARYList.add(vSUBSIDIARY);
	} // -- void addSUBSIDIARY(com.inetpsa.boz.rpv.xml.SUBSIDIARY)

	/**
	 * Method addSUBSIDIARY
	 * 
	 * 
	 * 
	 * @param index
	 * @param vSUBSIDIARY
	 */
	public void addSUBSIDIARY(int index, com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY vSUBSIDIARY) throws java.lang.IndexOutOfBoundsException {
		_SUBSIDIARYList.add(index, vSUBSIDIARY);
	} // -- void addSUBSIDIARY(int, com.inetpsa.boz.rpv.xml.SUBSIDIARY)

	/**
	 * Method clearSUBSIDIARY
	 * 
	 */
	public void clearSUBSIDIARY() {
		_SUBSIDIARYList.clear();
	} // -- void clearSUBSIDIARY()

	/**
	 * Method enumerateSUBSIDIARY
	 * 
	 * 
	 * 
	 * @return Enumeration
	 */
	public java.util.Enumeration enumerateSUBSIDIARY() {
		return new org.exolab.castor.util.IteratorEnumeration(_SUBSIDIARYList.iterator());
	} // -- java.util.Enumeration enumerateSUBSIDIARY()

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
	public java.lang.String getACTIVITY_CODE() {
		return this._ACTIVITY_CODE;
	} // -- java.lang.String getCOD_PDV()

	/**
	 * Sets the value of field 'COD_PDV'.
	 * 
	 * @param DEALER_CODE
	 *            the value of field 'DEALER_CODE'.
	 */

	public void setACTIVITY_CODE(java.lang.String ACTIVITY_CODE) {
		this._ACTIVITY_CODE = ACTIVITY_CODE;
	} // -- void

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
	 * Method removeSUBSIDIARY
	 * 
	 * 
	 * 
	 * @param vSUBSIDIARY
	 * @return boolean
	 */
	public boolean removeSUBSIDIARY(com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY vSUBSIDIARY) {
		boolean removed = _SUBSIDIARYList.remove(vSUBSIDIARY);
		return removed;
	} // -- boolean removeSUBSIDIARY(com.inetpsa.boz.rpv.xml.SUBSIDIARY)

	/**
	 * Method getSUBSIDIARY
	 * 
	 * 
	 * 
	 * @param index
	 * @return SUBSIDIARY
	 */
	public com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY getSUBSIDIARY(int index) throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _SUBSIDIARYList.size())) {
			throw new IndexOutOfBoundsException();
		}

		return (com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY) _SUBSIDIARYList.get(index);
	} // -- com.inetpsa.boz.rpv.xml.SUBSIDIARY getSUBSIDIARY(int)

	/**
	 * Method getSUBSIDIARY
	 * 
	 * 
	 * 
	 * @return SUBSIDIARY
	 */
	public com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY[] getSUBSIDIARY() {
		int size = _SUBSIDIARYList.size();
		com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY[] mArray = new com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY[size];
		for (int index = 0; index < size; index++) {
			mArray[index] = (com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY) _SUBSIDIARYList.get(index);
		}
		return mArray;
	} // -- com.inetpsa.boz.rpv.xml.SUBSIDIARY[] getSUBSIDIARY()

	/**
	 * Method getSUBSIDIARYCount
	 * 
	 * 
	 * 
	 * @return int
	 */
	public int getSUBSIDIARYCount() {
		return _SUBSIDIARYList.size();
	} // -- int getSUBSIDIARYCount()

	/**
	 * Method setSUBSIDIARY
	 * 
	 * 
	 * 
	 * @param index
	 * @param vSUBSIDIARY
	 */
	public void setSUBSIDIARY(int index, com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY vSUBSIDIARY) throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _SUBSIDIARYList.size())) {
			throw new IndexOutOfBoundsException();
		}
		_SUBSIDIARYList.set(index, vSUBSIDIARY);
	} // -- void setSUBSIDIARY(int, com.inetpsa.boz.rpv.xml.SUBSIDIARY)

	/**
	 * Method setSUBSIDIARY
	 * 
	 * 
	 * 
	 * @param SUBSIDIARYArray
	 */
	public void setSUBSIDIARY(com.inetpsa.boz.rpv.rp.xml.SUBSIDIARY[] SUBSIDIARYArray) {
		// -- copy array
		_SUBSIDIARYList.clear();
		for (int i = 0; i < SUBSIDIARYArray.length; i++) {
			_SUBSIDIARYList.add(SUBSIDIARYArray[i]);
		}
	} // -- void setSUBSIDIARY(com.inetpsa.boz.rpv.xml.SUBSIDIARY)

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
		return (com.inetpsa.boz.rpv.rp.xml.MsgActivityType) Unmarshaller.unmarshal(com.inetpsa.boz.rpv.rp.xml.MsgActivityType.class, reader);
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
