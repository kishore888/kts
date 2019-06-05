package com.hospitality.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.Format;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

public class NumberFormatTag extends SimpleTagSupport {
	 private String value;
	 private String decimalValue;

	 public void setValue(String value) {
	    this.value = value;
	 }
	 
	 public void setDecimalValue(String decimalValue) {
		this.decimalValue = decimalValue;
	 }
	 
	 StringWriter sw = new StringWriter();
	 
	 public void doTag() throws JspException, IOException {
	      if (StringUtils.isNotBlank(decimalValue) && StringUtils.isNotBlank(value)) {
	         if(decimalValue.equalsIgnoreCase("true")){
	        	 /* Use message from attribute */
		         JspWriter out = getJspContext().getOut();
		         
		         Format format = com.ibm.icu.text.NumberFormat.getInstance(new Locale("en","in"));
		         out.println(format.format(new BigDecimal(Math.round(new Double(value)*100.0)/100.0)) );
	         }
	      }else if(StringUtils.isNotBlank(value)){
	    	  JspWriter out = getJspContext().getOut();
	    	  
	    	  Format format = com.ibm.icu.text.NumberFormat.getInstance(new Locale("en","in"));
		      out.println(format.format(new BigInteger(value)) );
	      }else if(StringUtils.isBlank(value)){
	    	  JspWriter out = getJspContext().getOut();
	    	  out.println(value);
	      } else {
	         /* use message from the body */
	         getJspBody().invoke(sw);
	         getJspContext().getOut().println(sw.toString());
	      }
	  }

}
