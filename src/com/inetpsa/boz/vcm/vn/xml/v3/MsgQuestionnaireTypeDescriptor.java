/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id: MsgQuestionnaireTypeDescriptor.java,v 1.6.10.1.2.1 2012/09/12 14:37:39 e391165 Exp $
 */

package com.inetpsa.boz.vcm.vn.xml.v3;

//---------------------------------/
//- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.validators.StringValidator;

/**
 * Class MsgQuestionnnaireTypeDescriptor.
 * 
 * @version $Revision: 1.6.10.1.2.1 $ $Date: 2012/09/12 14:37:39 $
 */
public class MsgQuestionnaireTypeDescriptor extends
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

	public MsgQuestionnaireTypeDescriptor() {
		super();
		xmlName = "MsgQuestionnaireType";

		// -- set grouping compositor
		setCompositorAsSequence();

		org.exolab.castor.xml.util.XMLFieldDescriptorImpl desc = null;
		org.exolab.castor.mapping.FieldHandler handler = null;
		org.exolab.castor.xml.FieldValidator fieldValidator = null;
		// -- initialize attribute descriptors

		// -- initialize element descriptors

		// -- _VISIT_NUMBER
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_VISIT_NUMBER", "VISIT_NUMBER",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getVISIT_NUMBER();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setVISIT_NUMBER((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _VISIT_NUMBER
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _VISIT_ID
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_VISIT_ID", "VISIT_ID",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getVISIT_ID();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setVISIT_ID((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _VISIT_ID
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _SCENARIO
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_SCENARIO", "SCENARIO",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getSCENARIO();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setSCENARIO((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _SCENARIO
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q1
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q1", "Q1",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ1();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ1((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q1
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q3
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q3", "Q3",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ3();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ3((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q3
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q6
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q6", "Q6",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ6();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ6((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q6
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q7
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q7", "Q7",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ7();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ7((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q7
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q8
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q8", "Q8",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ8();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ8((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q8
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q9
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q9", "Q9",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ9();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ9((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q9
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q10
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q10", "Q10",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ10();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ10((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q10
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q11

		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q11Bis", "Q11Bis",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		desc.setMatches("Q11BIS Q11Bis Q11bis"); // Aceptamos que venga la
													// etiqueta completamente en
													// mayúsculas o capitalizada
													// (Q11Bis)
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ11Bis();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ11Bis((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q11Bis

		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{
			// -- local scope

			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);

		}

		desc.setValidator(fieldValidator);

		// -- _Q12
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q12", "Q12",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ12();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ12((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q12
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q13
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q13", "Q13",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ13();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ13((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q13
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q15
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q15", "Q15",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ15();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ15((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q15
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q17
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q17", "Q17",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ17();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ17((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q17
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q18

		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q18", "Q18",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ18();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ18((java.lang.String) value);
					// target.setQ18(StringUtils.getValidString("Q18",
					// (java.lang.String) value));
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q18
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope

			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);

		}
		desc.setValidator(fieldValidator);

		// -- _Q20
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q20", "Q20",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ20();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ20((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q20
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q21

		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q21", "Q21",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ21();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ21((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _Q21
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q23
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q23", "Q23",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ23();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ23((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q23
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q24
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q24", "Q24",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ24();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ24((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q24
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q25
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q25", "Q25",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ25();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ25((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q25
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q26
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q26", "Q26",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ26();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ26((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q26
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q29
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q29", "Q29",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ29();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ29((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q29
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q30
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q30", "Q30",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ30();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ30((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q30
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q31
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q31", "Q31",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ31();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ31((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q31
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q33
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q33", "Q33",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ33();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ33((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q33
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q34
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q34", "Q34",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ34();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ34((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q34
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q35
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q35", "Q35",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ35();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ35((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q35
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q38
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q38", "Q38",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ38();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ38((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q38
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q39
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q39", "Q39",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ39();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ39((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q39
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q40
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q40", "Q40",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ40();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ40((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q40
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q41
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q41", "Q41",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ41();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ41((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q41
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q42
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q42", "Q42",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ42();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ42((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q42
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q47
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q47", "Q47",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ47();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ47((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q47
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q48
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q48", "Q48",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ48();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ48((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q48
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q49
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q49", "Q49",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ49();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ49((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q49
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q50
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q50", "Q50",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ50();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ50((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q50
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q51
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q51", "Q51",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ51();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ51((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q51
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q52
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q52", "Q52",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ52();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ52((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q52
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q54
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q54", "Q54",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ54();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ54((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q54
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q55
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q55", "Q55",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ55();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ55((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q55
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q56
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q56", "Q56",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ56();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ56((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q56
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q57
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q57", "Q57",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ57();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ57((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q57
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q58
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q58", "Q58",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ58();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ58((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q58
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q60
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q60", "Q60",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ60();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ60((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q60
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q61
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q61", "Q61",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ61();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ61((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q61
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q62
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q62", "Q62",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ62();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ62((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q62
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q63
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q63", "Q63",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ63();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ63((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q63
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q65
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q65", "Q65",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ65();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ65((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q65
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q66
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q66", "Q66",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ66();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ66((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q66
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q67
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q67", "Q67",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ67();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ67((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q67
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q68
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q68", "Q68",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ68();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ68((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q68
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q69
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q69", "Q69",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ69();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ69((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q69
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q70
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q70", "Q70",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ70();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ70((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q70
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q71
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q71", "Q71",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ71();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ71((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q71
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q72
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q72", "Q72",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ72();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ72((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q72
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q73
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q73", "Q73",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ73();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ73((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q73
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q74
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q74", "Q74",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ74();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ74((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q74
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q75
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q75", "Q75",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ75();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ75((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q75
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q76
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q76", "Q76",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ76();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ76((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q76
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q77
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q77", "Q77",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ77();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ77((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q77
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q78
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q78", "Q78",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ78();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ78((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q78
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q79
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q79", "Q79",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ79();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ79((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q79
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q80
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q80", "Q80",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ80();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ80((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q80
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q81
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q81", "Q81",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ81();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ81((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q81
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q82
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q82", "Q82",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ82();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ82((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q82
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q83
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q83", "Q83",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ83();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ83((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q83
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q84
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q84", "Q84",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ84();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ84((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q84
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q85
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q85", "Q85",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ85();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ85((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q85
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q86
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q86", "Q86",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ86();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ86((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q86
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q87
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q87", "Q87",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ87();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ87((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q87
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q88
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q88", "Q88",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ88();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ88((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q88
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q89
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q89", "Q89",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ89();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ89((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q89
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q90
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q90", "Q90",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ90();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ90((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q90
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q91
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q91", "Q91",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ91();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ91((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q91
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q92
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q92", "Q92",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ92();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ92((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q92
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q93
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q93", "Q93",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ93();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ93((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q93
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _Q94
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_Q94", "Q94",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQ94();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQ94((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		// desc.setRequired(true);
		addFieldDescriptor(desc);

		// -- validation code for: _Q94
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _QO1
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_QO1", "QO1",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQO1();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQO1((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _QO1
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _QO2
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_QO2", "QO2",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQO2();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQO2((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _QO2
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _QO3
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_QO3", "QO3",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQO3();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQO3((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _QO3
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _QO4
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_QO4", "QO4",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQO4();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQO4((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _QO4
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _QO5
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_QO5", "QO5",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQO5();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQO5((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _QO5
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _QL1
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_QL1", "QL1",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQL1();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQL1((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _QL1
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _QL2
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_QL2", "QL2",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQL2();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQL2((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _QL2
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _QL3
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_QL3", "QL3",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQL3();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQL3((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _QL3
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _QL4
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_QL4", "QL4",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQL4();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQL4((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _QL4
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

		// -- _QL5
		desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(
				java.lang.String.class, "_QL5", "QL5",
				org.exolab.castor.xml.NodeType.Element);
		desc.setImmutable(true);
		handler = new org.exolab.castor.xml.XMLFieldHandler() {
			public java.lang.Object getValue(java.lang.Object object)
					throws IllegalStateException {
				MsgQuestionnaireType target = (MsgQuestionnaireType) object;
				return target.getQL5();
			}

			public void setValue(java.lang.Object object, java.lang.Object value)
					throws IllegalStateException, IllegalArgumentException {
				try {
					MsgQuestionnaireType target = (MsgQuestionnaireType) object;
					target.setQL5((java.lang.String) value);
				} catch (java.lang.Exception ex) {
					throw new IllegalStateException(ex.toString());
				}
			}

			public java.lang.Object newInstance(java.lang.Object parent) {
				return null;
			}
		};
		desc.setHandler(handler);
		desc.setMultivalued(false);
		desc.setRequired(false);
		addFieldDescriptor(desc);

		// -- validation code for: _QL5
		fieldValidator = new org.exolab.castor.xml.FieldValidator();
		{ // -- local scope
			StringValidator typeValidator = new StringValidator();
			typeValidator.setWhiteSpace("preserve");
			fieldValidator.setValidator(typeValidator);
		}
		desc.setValidator(fieldValidator);

	}

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
		return com.inetpsa.boz.vcm.vn.xml.v3.MsgQuestionnaireType.class;
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
