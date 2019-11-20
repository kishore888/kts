/** TransactionBO.java  Nov 10,19
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.Transaction;

/**
* @author  Kishore
*/

public interface TransactionBO {

	public void create(Transaction Transaction) throws Exception;
	public List<Transaction> retrieveList() throws Exception;

}
