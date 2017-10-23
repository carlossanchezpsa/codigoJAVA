/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: HeaderType.java,v 1.3 2008/12/03 18:56:36 e243060 Exp $
 */

package com.inetpsa.boz.rpv.rp.xml;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import java.util.ArrayList;

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class HeaderType.
 * 
 * @version $Revision: 1.3 $ $Date: 2008/12/03 18:56:36 $
 */
public class HeaderType implements java.io.Serializable {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field _DATE
	 */
	// private java.lang.String _DATE;

	/**
	 * Field _FROM
	 */
	// private java.lang.String _FROM;

	/**
	 * Field _TO
	 */
	// private java.lang.String _TO;

	/**
	 * Field _TRANSFER_DATE
	 */
	private java.lang.String _TRANSFER_DATE;

	/**
	 * Field _EXTRACT_VERSION
	 */
	// private java.lang.String _EXTRACT_VERSION;

	/**
	 * Field _AP_AC
	 */
	// private com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType _AP_AC;

	/**
	 * Field _FILE_TYPE
	 */
	// private java.lang.String _FILE_TYPE;

	/**
	 * Field _ActivityList
	 */
	private java.util.ArrayList _ACTIVITYList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public HeaderType() {
		super();
		_ACTIVITYList = new ArrayList();
	} // -- com.inetpsa.boz.rpv.rrdi.xml.HeaderType()

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Returns the value of field 'AP_AC'.
	 * 
	 * @return MarquePSAType
	 * @return the value of field 'AP_AC'.
	 */
	/*
	 * public com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType getAP_AC() {
	 * return this._AP_AC; } // --
	 * com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType getAP_AC()
	 * 
	 * /** Returns the value of field 'DATE'.
	 * 
	 * @return String
	 * 
	 * @return the value of field 'DATE'.
	 */
	/*
	 * public java.lang.String getDATE() { return this._DATE; } // --
	 * java.lang.String getDATE()
	 * 
	 * /** Returns the value of field 'EXTRACT_VERSION'.
	 * 
	 * @return String
	 * 
	 * @return the value of field 'EXTRACT_VERSION'.
	 */

	public java.lang.String getTRANSFER_DATE() {
		return this._TRANSFER_DATE;
	} // -- java.lang.String getEXTRACT_VERSION()

	/**
	 * Returns the value of field 'FILE_TYPE'.
	 * 
	 * @return String
	 * 
	 * @return the value of field 'FILE_TYPE'.
	 */
	/*
	 * public java.lang.String getFILE_TYPE() { return this._FILE_TYPE; } // --
	 * java.lang.String getFILE_TYPE()
	 * 
	 * /** Returns the value of field 'FROM'.
	 * 
	 * @return String
	 * 
	 * @return the value of field 'FROM'.
	 */
	/*
	 * public java.lang.String getFROM() { return this._FROM; } // --
	 * java.lang.String getFROM()
	 * 
	 * /** Returns the value of field 'TO'.
	 * 
	 * @return String
	 * 
	 * @return the value of field 'TO'.
	 */
	/*
	 * public java.lang.String getTO() { return this._TO; } // --
	 * java.lang.String getTO()
	 * 
	 * /** Method isValid
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
	 * Sets the value of field 'AP_AC'.
	 * 
	 * @param AP_AC
	 *            the value of field 'AP_AC'.
	 */
	/*
	 * public void setAP_AC(com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType
	 * AP_AC) { this._AP_AC = AP_AC; } // -- void
	 * setAP_AC(com.inetpsa.boz.rpv.rrdi.xml.types.MarquePSAType)
	 * 
	 * /** Sets the value of field 'DATE'.
	 * 
	 * @param DATE the value of field 'DATE'.
	 */
	/*
	 * public void setDATE(java.lang.String DATE) { this._DATE = DATE; } // --
	 * void setDATE(java.lang.String)
	 * 
	 * /** Sets the value of field 'EXTRACT_VERSION'.
	 * 
	 * @param EXTRACT_VERSION the value of field 'EXTRACT_VERSION'.
	 */
	/*
	 * public void setEXTRACT_VERSION(java.lang.String EXTRACT_VERSION) {
	 * this._EXTRACT_VERSION = EXTRACT_VERSION; } // -- void
	 * setEXTRACT_VERSION(java.lang.String)
	 * 
	 * /** Sets the value of field 'FILE_TYPE'.
	 * 
	 * @param FILE_TYPE the value of field 'FILE_TYPE'.
	 */

	/**
	 * Sets the value of field 'TRANSFER_DATE'.
	 * 
	 * @param TRANSFER_DATE
	 *            the value of field 'TRANSFER_DATE'.
	 */
	public void setTRANSFER_DATE(java.lang.String TRANSFER_DATE) {
		this._TRANSFER_DATE = TRANSFER_DATE;
	} // -- void setFILE_TYPE(java.lang.String)

	/**
	 * Sets the value of field 'FROM'.
	 * 
	 * @param FROM
	 *            the value of field 'FROM'.
	 */
	/*
	 * public void setFROM(java.lang.String FROM) { this._FROM = FROM; } // --
	 * void setFROM(java.lang.String)
	 * 
	 * /** Sets the value of field 'TO'.
	 * 
	 * @param TO the value of field 'TO'.
	 */
	/*
	 * public void setTO(java.lang.String TO) { this._TO = TO; } // -- void
	 * setTO(java.lang.String)
	 * 
	 * /** Method addACTIVITY
	 * 
	 * 
	 * 
	 * @param vACTIVITY
	 */
	public void addACTIVITY(com.inetpsa.boz.rpv.rp.xml.ACTIVITY vACTIVITY) throws java.lang.IndexOutOfBoundsException {
		_ACTIVITYList.add(vACTIVITY);
	} // -- void addACTIVITY(com.inetpsa.boz.rpv.xml.ACTIVITY)

	/**
	 * Method addACTIVITY
	 * 
	 * 
	 * 
	 * @param index
	 * @param vACTIVITY
	 */
	public void addACTIVITY(int index, com.inetpsa.boz.rpv.rp.xml.ACTIVITY vACTIVITY) throws java.lang.IndexOutOfBoundsException {
		_ACTIVITYList.add(index, vACTIVITY);
	} // -- void addACTIVITY(int, com.inetpsa.boz.rpv.xml.ACTIVITY)

	/**
	 * Method clearACTIVITY
	 * 
	 */
	public void clearACTIVITY() {
		_ACTIVITYList.clear();
	} // -- void clearACTIVITY()

	/**
	 * Method enumerateACTIVITY
	 * 
	 * 
	 * 
	 * @return Enumeration
	 */
	public java.util.Enumeration enumerateACTIVITY() {
		return new org.exolab.castor.util.IteratorEnumeration(_ACTIVITYList.iterator());
	} // -- java.util.Enumeration enumerateACTIVITY()

	/**
	 * Method getACTIVITY
	 * 
	 * 
	 * 
	 * @param index
	 * @return ACTIVITY
	 */
	public com.inetpsa.boz.rpv.rp.xml.ACTIVITY getACTIVITY(int index) throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _ACTIVITYList.size())) {
			throw new IndexOutOfBoundsException();
		}

		return (com.inetpsa.boz.rpv.rp.xml.ACTIVITY) _ACTIVITYList.get(index);
	} // -- com.inetpsa.boz.rpv.xml.ACTIVITY getACTIVITY(int)

	/**
	 * Method getACTIVITY
	 * 
	 * 
	 * 
	 * @return ACTIVITY
	 */
	public com.inetpsa.boz.rpv.rp.xml.ACTIVITY[] getACTIVITY() {
		int size = _ACTIVITYList.size();
		com.inetpsa.boz.rpv.rp.xml.ACTIVITY[] mArray = new com.inetpsa.boz.rpv.rp.xml.ACTIVITY[size];
		for (int index = 0; index < size; index++) {
			mArray[index] = (com.inetpsa.boz.rpv.rp.xml.ACTIVITY) _ACTIVITYList.get(index);
		}
		return mArray;
	} // -- com.inetpsa.boz.rpv.xml.ACTIVITY[] getACTIVITY()

	/**
	 * Method getACTIVITYCount
	 * 
	 * 
	 * 
	 * @return int
	 */
	public int getACTIVITYCount() {
		return _ACTIVITYList.size();
	} // -- int getACTIVITYCount()

	/**
	 * Method removeACTIVITY
	 * 
	 * 
	 * 
	 * @param vACTIVITY
	 * @return boolean
	 */
	public boolean removeACTIVITY(com.inetpsa.boz.rpv.rp.xml.ACTIVITY vACTIVITY) {
		boolean removed = _ACTIVITYList.remove(vACTIVITY);
		return removed;
	} // -- boolean removeACTIVITY(com.inetpsa.boz.rpv.xml.ACTIVITY)

	/**
	 * Method setACTIVITY
	 * 
	 * 
	 * 
	 * @param index
	 * @param vACTIVITY
	 */
	public void setACTIVITY(int index, com.inetpsa.boz.rpv.rp.xml.ACTIVITY vACTIVITY) throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _ACTIVITYList.size())) {
			throw new IndexOutOfBoundsException();
		}
		_ACTIVITYList.set(index, vACTIVITY);
	} // -- void setACTIVITY(int, com.inetpsa.boz.rpv.xml.ACTIVITY)

	/**
	 * Method setACTIVITY
	 * 
	 * 
	 * 
	 * @param ACTIVITYArray
	 */
	public void setACTIVITY(com.inetpsa.boz.rpv.rp.xml.ACTIVITY[] ACTIVITYArray) {
		// -- copy array
		_ACTIVITYList.clear();
		for (int i = 0; i < ACTIVITYArray.length; i++) {
			_ACTIVITYList.add(ACTIVITYArray[i]);
		}
	} // -- void setACTIVITY(com.inetpsa.boz.rpv.xml.ACTIVITY)

	/**
	 * 
	 * Method unmarshal
	 * 
	 * 
	 * 
	 * @param reader
	 * @return Object
	 */
	public static java.lang.Object unmarshal(java.io.Reader reader) throws org.exolab.castor.xml.MarshalException,
			org.exolab.castor.xml.ValidationException {
		return (com.inetpsa.boz.rpv.rp.xml.HeaderType) Unmarshaller.unmarshal(com.inetpsa.boz.rpv.rp.xml.HeaderType.class, reader);
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
