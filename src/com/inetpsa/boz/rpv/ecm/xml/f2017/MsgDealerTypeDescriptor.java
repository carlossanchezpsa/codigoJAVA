/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: MsgDealerTypeDescriptor.java,v 1.1 2008/01/11 17:12:11 e243060 Exp $
 */

package com.inetpsa.boz.rpv.ecm.xml.f2017;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.validators.StringValidator;

/**
 * Class MsgDealerTypeDescriptor.
 * 
 * @version $Revision: 1.1 $ $Date: 2008/01/11 17:12:11 $
 */
public class MsgDealerTypeDescriptor extends
		org.exolab.castor.xml.util.XMLClassDescriptorImpl {

	// --------------------------/
	// - Class/Member Variables -/
	// --------------------------/

	/**
	 * Field nsPrefix
	 */
	private java.lang.String nsPrefix;

	/**
	 * Field nsURI
	 */
	private java.lang.String nsURI;

	/**
	 * Field xmlName
	 */
	private java.lang.String xmlName;

	/**
	 * Field identity
	 */
	private org.exolab.castor.xml.XMLFieldDescriptor identity;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public MsgDealerTypeDescriptor() {
		super();
		xmlName = "MsgDealerType";

		// -- set grouping compositor
		setCompositorAsSequence();
		org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
		org.exolab.castor.mapping.FieldHandler handler = null;
		org.exolab.castor.xml.FieldValidator fieldValidator = null;
		// -- initialize attribute descriptors

		// -- initialize element descriptors

		// -- _DEALER_CODE
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_DEALER_CODE", "DEALER_CODE",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgDealerType target = (MsgDealerType) object;
				return target.getDEALER_CODE();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgDealerType target = (MsgDealerType) object;
					target.setDEALER_CODE((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setRequired(true);
		desc.setMultivalued(false);
		addFieldDescriptor(desc);

		// -- validation code for: _DEALER_CODE
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(1);
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _LEADList
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD.class, "_LEADList",
				"LEAD", org.exolab.castor.xml.NodeType.Element);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgDealerType target = (MsgDealerType) object;
				return target.getLEAD();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgDealerType target = (MsgDealerType) object;
					target.addLEAD((com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return new com.inetpsa.boz.rpv.ecm.xml.f2017.LEAD();
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(true);
		addFieldDescriptor(desc);

		// -- validation code for: _LEADList
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		fieldValidator.setMinOccurs(0);
		{ // -- local scope
		}
		desc.setValidator(fieldValidator);
		// -- _INDIVIDUALList
		/*
		 * desc = new
		 * org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.inetpsa
		 * .boz.rpv.opp.xml.INDIVIDUAL.class, "_INDIVIDUALList", "INDIVIDUAL",
		 * org.exolab.castor.xml.NodeType.Element); handler = new
		 * org.exolab.castor.xml.XMLFieldHandler() { public java.lang.Object
		 * getValue( java.lang.Object object ) throws IllegalStateException {
		 * MsgDealerType target = (MsgDealerType) object; return
		 * target.getINDIVIDUAL(); } public void setValue( java.lang.Object
		 * object, java.lang.Object value) throws IllegalStateException,
		 * IllegalArgumentException { try { MsgDealerType target =
		 * (MsgDealerType) object; target.addINDIVIDUAL(
		 * (com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL) value); } catch
		 * (java.lang.Exception ex) { throw new
		 * IllegalStateException(ex.toString()); } } public java.lang.Object
		 * newInstance( java.lang.Object parent ) { return new
		 * com.inetpsa.boz.rpv.opp.xml.INDIVIDUAL(); } };
		 * desc.setHandler(handler); desc.setMultivalued(true);
		 * addFieldDescriptor(desc);
		 * 
		 * //-- validation code for: _INDIVIDUALList fieldValidator = new
		 * org.exolab.castor.xml.FieldValidator();
		 * fieldValidator.setMinOccurs(0); { //-- local scope }
		 * desc.setValidator(fieldValidator);
		 */
	} // -- com.inetpsa.boz.rpv.xml.MsgDealerTypeDescriptor()

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Method getAccessMode
	 * 
	 * 
	 * 
	 * @return AccessMode
	 */
	public org.exolab.castor.mapping.AccessMode getAccessMode() {
		return null;
	} // -- org.exolab.castor.mapping.AccessMode getAccessMode()

	/**
	 * Method getExtends
	 * 
	 * 
	 * 
	 * @return ClassDescriptor
	 */
	public org.exolab.castor.mapping.ClassDescriptor getExtends() {
		return null;
	} // -- org.exolab.castor.mapping.ClassDescriptor getExtends()

	/**
	 * Method getIdentity
	 * 
	 * 
	 * 
	 * @return FieldDescriptor
	 */
	public org.exolab.castor.mapping.FieldDescriptor getIdentity() {
		return identity;
	} // -- org.exolab.castor.mapping.FieldDescriptor getIdentity()

	/**
	 * Method getJavaClass
	 * 
	 * 
	 * 
	 * @return Class
	 */
	public java.lang.Class getJavaClass() {
		return com.inetpsa.boz.rpv.ecm.xml.f2017.MsgDealerType.class;
	} // -- java.lang.Class getJavaClass()

	/**
	 * Method getNameSpacePrefix
	 * 
	 * 
	 * 
	 * @return String
	 */
	public java.lang.String getNameSpacePrefix() {
		return nsPrefix;
	} // -- java.lang.String getNameSpacePrefix()

	/**
	 * Method getNameSpaceURI
	 * 
	 * 
	 * 
	 * @return String
	 */
	public java.lang.String getNameSpaceURI() {
		return nsURI;
	} // -- java.lang.String getNameSpaceURI()

	/**
	 * Method getValidator
	 * 
	 * 
	 * 
	 * @return TypeValidator
	 */
	public org.exolab.castor.xml.TypeValidator getValidator() {
		return this;
	} // -- org.exolab.castor.xml.TypeValidator getValidator()

	/**
	 * Method getXMLName
	 * 
	 * 
	 * 
	 * @return String
	 */
	public java.lang.String getXMLName() {
		return xmlName;
	} // -- java.lang.String getXMLName()

}
