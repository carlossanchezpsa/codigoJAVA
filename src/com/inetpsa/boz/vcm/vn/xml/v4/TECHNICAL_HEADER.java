/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: TECHNICAL_HEADER.java,v 1.2 2011/12/28 20:08:39 e354918 Exp $
 */

package com.inetpsa.boz.vcm.vn.xml.v4;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class TECHNICAL_HEADER.
 * 
 * @version $Revision: 1.2 $ $Date: 2011/12/28 20:08:39 $
 */
public class TECHNICAL_HEADER extends MsgHeaderType implements
		java.io.Serializable {

	// ----------------/
	// - Constructors -/
	// ----------------/

	public TECHNICAL_HEADER() {
		super();
	} // -- com.inetpsa.boz.rpv.xml.TECHNICAL_HEADER()

	// -----------/
	// - Methods -/
	// -----------/

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
		return (com.inetpsa.boz.vcm.vn.xml.v4.TECHNICAL_HEADER) Unmarshaller
				.unmarshal(
						com.inetpsa.boz.vcm.vn.xml.v4.TECHNICAL_HEADER.class,
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
