/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: MsgDealerType.java,v 1.1 2008/01/11 17:12:12 e243060 Exp $
 */

package com.inetpsa.boz.rpv.ecm.xml.f2017;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import java.util.ArrayList;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class MsgDealerType.
 * 
 * @version $Revision: 1.1 $ $Date: 2008/01/11 17:12:12 $
 */
public class MsgDealerType implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _COD_PDV
	 */
	private java.lang.String _DEALER_CODE;

	/*
	 * /** Field _INDIVIDUALList
	 */
	// private java.util.ArrayList _INDIVIDUALList;

	private java.util.ArrayList _LEADList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public MsgDealerType() {
		super();
		// _INDIVIDUALList = new ArrayList();
		_LEADList = new ArrayList();
	} // -- com.inetpsa.boz.rpv.xml.MsgDealerType()

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
	 * Method addLEAD
	 * 
	 * 
	 * 
	 * @param vLEAD
	 */
	public void addLEAD(com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD vLEAD)
			throws java.lang.IndexOutOfBoundsException {
		_LEADList.add(vLEAD);
	} // -- void addLEAD(com.inetpsa.boz.rpv.xml.LEAD)

	/**
	 * Method addLEAD
	 * 
	 * 
	 * 
	 * @param index
	 * @param vLEAD
	 */
	public void addLEAD(int index, com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD vLEAD)
			throws java.lang.IndexOutOfBoundsException {
		_LEADList.add(index, vLEAD);
	} // -- void addLEAD(int, com.inetpsa.boz.rpv.xml.LEAD)

	/**
	 * Method clearLEAD
	 * 
	 */
	public void clearLEAD() {
		_LEADList.clear();
	} // -- void clearLEAD()

	/**
	 * Method enumerateLEAD
	 * 
	 * 
	 * 
	 * @return Enumeration
	 */
	public java.util.Enumeration enumerateLEAD() {
		return new org.exolab.castor.util.IteratorEnumeration(
				_LEADList.iterator());
	} // -- java.util.Enumeration enumerateLEAD()

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
	public java.lang.String getDEALER_CODE() {
		return this._DEALER_CODE;
	} // -- java.lang.String getCOD_PDV()

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
	 * Method removeLEAD
	 * 
	 * 
	 * 
	 * @param vLEAD
	 * @return boolean
	 */
	public boolean removeLEAD(com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD vLEAD) {
		boolean removed = _LEADList.remove(vLEAD);
		return removed;
	} // -- boolean removeLEAD(com.inetpsa.boz.rpv.xml.LEAD)

	/**
	 * Method getLEAD
	 * 
	 * 
	 * 
	 * @param index
	 * @return LEAD
	 */
	public com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD getLEAD(int index)
			throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _LEADList.size())) {
			throw new IndexOutOfBoundsException();
		}

		return (com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD) _LEADList.get(index);
	} // -- com.inetpsa.boz.rpv.xml.LEAD getLEAD(int)

	/**
	 * Method getLEAD
	 * 
	 * 
	 * 
	 * @return LEAD
	 */
	public com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD[] getLEAD() {
		int size = _LEADList.size();
		com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD[] mArray = new com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD[size];
		for (int index = 0; index < size; index++) {
			mArray[index] = (com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD) _LEADList
					.get(index);
		}
		return mArray;
	} // -- com.inetpsa.boz.rpv.xml.LEAD[] getLEAD()

	/**
	 * Method getLEADCount
	 * 
	 * 
	 * 
	 * @return int
	 */
	public int getLEADCount() {
		return _LEADList.size();
	} // -- int getLEADCount()

	/**
	 * Method setLEAD
	 * 
	 * 
	 * 
	 * @param index
	 * @param vLEAD
	 */
	public void setLEAD(int index, com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD vLEAD)
			throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _LEADList.size())) {
			throw new IndexOutOfBoundsException();
		}
		_LEADList.set(index, vLEAD);
	} // -- void setLEAD(int, com.inetpsa.boz.rpv.xml.LEAD)

	/**
	 * Method setLEAD
	 * 
	 * 
	 * 
	 * @param LEADArray
	 */
	public void setLEAD(com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD[] LEADArray) {
		// -- copy array
		_LEADList.clear();
		for (int i = 0; i < LEADArray.length; i++) {
			_LEADList.add(LEADArray[i]);
		}
	} // -- void setLEAD(com.inetpsa.boz.rpv.xml.LEAD)

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
	/**
	 * Sets the value of field 'COD_PDV'.
	 * 
	 * @param DEALER_CODE
	 *            the value of field 'DEALER_CODE'.
	 */

	public void setDEALER_CODE(java.lang.String DEALER_CODE) {
		this._DEALER_CODE = DEALER_CODE;
	} // -- void

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
	public static java.lang.Object unmarshal(java.io.Reader reader)
			throws org.exolab.castor.xml.MarshalException,
			org.exolab.castor.xml.ValidationException {
		return (com.inetpsa.boz.rpv.ecm.xml.f2017.MsgDealerType) Unmarshaller
				.unmarshal(
						com.inetpsa.boz.rpv.ecm.xml.f2017.MsgDealerType.class,
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
