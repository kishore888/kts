/** TransactionBOImpl.java  Nov 10,19
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.HotelBO;
import com.hospitality.bo.TransactionBO;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.Payment;
import com.hospitality.core.PaymentAccount;
import com.hospitality.core.PaymentDetails;
import com.hospitality.core.Reservation;
import com.hospitality.core.Transaction;
import com.hospitality.dao.PaymentAccountDAO;
import com.hospitality.dao.PaymentDAO;
import com.hospitality.dao.PaymentDetailsDAO;
import com.hospitality.dao.TransactionDAO;
import com.hospitality.util.Constants;
import com.hospitality.util.PaymentType;

/**
* @author  Kishore
*/

@Service("TransactionBO")
@Scope(value="prototype")
public class TransactionBOImpl implements TransactionBO{

	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@Autowired
	private PaymentDetailsDAO paymentDetailsDAO;
	
	@Autowired
	private PaymentAccountDAO paymentAccountDAO;
	
	@Autowired
	private HotelBO hotelBO;
	
	@Override
	public void create(Transaction transaction) throws Exception{
		try{
			if(StringUtils.isNotBlank(transaction.getTransactionId())){
				transactionDAO.update(transaction);
			}else{
				transactionDAO.create(transaction);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Transaction> retrieveList() throws Exception{
		List<Transaction> transactionList = null;
		try{
			transactionList = transactionDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return transactionList;
	}

	@Override
	public void createTransaction(Reservation reservation, Hotel hotel) throws Exception {
		String billNo = "";
		PaymentAccount paymentAccount = null;
		try{
			paymentAccount = paymentAccountDAO.retrieveById(reservation.getPaymentAccount().getPaymentAccountId());
			billNo = hotelBO.generateBillNo(hotel, paymentAccount);
			
			PaymentDetails paymentDetails = new PaymentDetails();
			paymentDetails.setTotalAmount(reservation.getTotalAmount());
			paymentDetails.setTypeOfPayment(Constants.ONLINE);
			paymentDetails.setBillNo(billNo);
			paymentDetailsDAO.save(paymentDetails);
			
			paymentAccount.setBillCount(paymentAccount.getBillCount()+1);
			paymentAccountDAO.update(paymentAccount);
			
			Payment payment = new Payment();
			payment.setAmount(reservation.getAmount());
			payment.setPaymentDetails(paymentDetails);
			payment.setReservation(reservation);
			paymentDAO.save(payment);
			
			Transaction transaction = new Transaction();
			transaction.setPaymentDetails(paymentDetails);
			transactionDAO.create(transaction);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

}
