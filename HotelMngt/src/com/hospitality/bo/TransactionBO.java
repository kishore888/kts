/** TransactionBO.java  Nov 10,19
*/

package com.hospitality.bo;

import java.util.List;

import com.hospitality.core.Customer;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.Reservation;
import com.hospitality.core.Transaction;

/**
* @author  Kishore
*/

public interface TransactionBO {

	public void create(Transaction Transaction) throws Exception;
	public List<Transaction> retrieveList() throws Exception;
	public String createTransaction(Customer customer, Hotel hotel) throws Exception;
	public Transaction retrieveByClientTransactionNo(String clientTransactionNo) throws Exception;
	public void payUSuccess(String clientTransactionNo, Hotel hotel) throws Exception;

}
