/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: MsgDealerType.java,v 1.1 2008/01/11 17:12:12 e243060 Exp $
 */

package com.inetpsa.boz.vcm.apv.xml.v3;

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
	 * Field _RRDI_CODE;
	 */
	private java.lang.String _RRDI_CODE;

	/**
	 * Field _SITE_CODE;
	 */
	private java.lang.String _SITE_CODE;

	/*
	 * /** Field _INDIVIDUALList
	 */
	// private java.util.ArrayList _INDIVIDUALList;

	private java.util.ArrayList _QUESTIONNAIREList;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public MsgDealerType() {
		super();
		_QUESTIONNAIREList = new ArrayList();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Method addQUESTIONNAIRE
	 * 
	 * 
	 * 
	 * @param v_QUESTIONNAIRE
	 */
	public void addQUESTIONNAIRE(
			com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE v_QUESTIONNAIRE)
			throws java.lang.IndexOutOfBoundsException {
		_QUESTIONNAIREList.add(v_QUESTIONNAIRE);
	}

	/**
	 * Method addQUESTIONNAIRE
	 * 
	 * 
	 * 
	 * @param index
	 * @param v_QUESTIONNAIRE
	 */
	public void addQUESTIONNAIRE(int index,
			com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE v_QUESTIONNAIRE)
			throws java.lang.IndexOutOfBoundsException {
		_QUESTIONNAIREList.add(index, v_QUESTIONNAIRE);
	}

	/**
	 * Method clearQUESTIONNAIRE
	 * 
	 */
	public void clearQUESTIONNAIRE() {
		_QUESTIONNAIREList.clear();
	}

	/**
	 * Method enumerateQUESTIONNAIRE
	 * 
	 * 
	 * 
	 * @return Enumeration
	 */
	public java.util.Enumeration enumerateQUESTIONNAIRE() {
		return new org.exolab.castor.util.IteratorEnumeration(
				_QUESTIONNAIREList.iterator());
	}

	/**
	 * Returns the value of field 'RRDI_CODE'.
	 * 
	 * @return String
	 * @return the value of field 'RRDI_CODE'.
	 */
	public java.lang.String getRRDI_CODE() {
		return this._RRDI_CODE;
	}

	/**
	 * Returns the value of field 'SITE_CODE'.
	 * 
	 * @return String
	 * @return the value of field 'SITE_CODE'.
	 */
	public java.lang.String getSITE_CODE() {
		return this._SITE_CODE;
	}

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
	 * Method removeQUESTIONNAIRE
	 * 
	 * 
	 * 
	 * @param vQUESTIONNAIRE
	 * @return boolean
	 */
	public boolean removeQUESTIONNAIRE(
			com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE vQUESTIONNAIRE) {
		boolean removed = _QUESTIONNAIREList.remove(vQUESTIONNAIRE);
		return removed;
	}

	/**
	 * Method getQUESTIONNAIRE
	 * 
	 * 
	 * 
	 * @param index
	 * @return QUESTIONNAIRE
	 */
	public com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE getQUESTIONNAIRE(int index)
			throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _QUESTIONNAIREList.size())) {
			throw new IndexOutOfBoundsException();
		}

		return (com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE) _QUESTIONNAIREList
				.get(index);
	}

	/**
	 * Method getQUESTIONNAIRE
	 * 
	 * 
	 * 
	 * @return QUESTIONNAIRE
	 */
	public com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE[] getQUESTIONNAIRE() {
		int size = _QUESTIONNAIREList.size();
		com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE[] mArray = new com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE[size];
		for (int index = 0; index < size; index++) {
			mArray[index] = (com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE) _QUESTIONNAIREList
					.get(index);
		}
		return mArray;
	}

	/**
	 * Method getQUESTIONNAIRECount
	 * 
	 * 
	 * 
	 * @return int
	 */
	public int getQUESTIONNAIRECount() {
		return _QUESTIONNAIREList.size();
	}

	/**
	 * Method setQUESTIONNAIRE
	 * 
	 * 
	 * 
	 * @param index
	 * @param vQUESTIONNAIRE
	 */
	public void setQUESTIONNAIRE(int index,
			com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE vQUESTIONNAIRE)
			throws java.lang.IndexOutOfBoundsException {
		// -- check bounds for index
		if ((index < 0) || (index > _QUESTIONNAIREList.size())) {
			throw new IndexOutOfBoundsException();
		}
		_QUESTIONNAIREList.set(index, vQUESTIONNAIRE);
	}

	/**
	 * Method setQUESTIONNAIRE
	 * 
	 * 
	 * 
	 * @param QUESTIONNAIREArray
	 */
	public void setQUESTIONNAIRE(
			com.inetpsa.boz.vcm.apv.xml.v3.QUESTIONNAIRE[] QUESTIONNAIREArray) {
		// -- copy array
		_QUESTIONNAIREList.clear();
		for (int i = 0; i < QUESTIONNAIREArray.length; i++) {
			_QUESTIONNAIREList.add(QUESTIONNAIREArray[i]);
		}
	}

	public void setRRDI_CODE(java.lang.String RRDI_CODE) {
		this._RRDI_CODE = RRDI_CODE;
	}

	public void setSITE_CODE(java.lang.String SITE_CODE) {
		this._SITE_CODE = SITE_CODE;
	}

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
		return (com.inetpsa.boz.vcm.apv.xml.v3.MsgDealerType) Unmarshaller
				.unmarshal(com.inetpsa.boz.vcm.apv.xml.v3.MsgDealerType.class,
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
