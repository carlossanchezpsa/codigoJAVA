/*
 * Creation : 16/10/2014
 */
package com.inetpsa.boz.common.bean;

import java.util.ArrayList;
import java.util.List;

public class eMailBean {
	String sEmail = null;
	List lAlertBean = null;

	public eMailBean() {
		sEmail = "";
		lAlertBean = new ArrayList();
	}

	public eMailBean(String sEmail) {
		this.sEmail = sEmail;
		lAlertBean = new ArrayList();
	}

	public eMailBean(String sEmail, AlertBean alertBean) {
		this.sEmail = sEmail;
		if (lAlertBean == null) {
			lAlertBean = new ArrayList();
		}
		lAlertBean.add(alertBean);
	}

}
