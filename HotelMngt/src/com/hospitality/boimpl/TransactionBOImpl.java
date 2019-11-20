/** TransactionBOImpl.java  Nov 10,19
*/

package com.hospitality.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.TransactionBO;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.Transaction;
import com.hospitality.dao.TransactionDAO;

/**
* @author  Kishore
*/

@Service("TransactionBO")
@Scope(value="prototype")
public class TransactionBOImpl implements TransactionBO{

	@Autowired
	private TransactionDAO TransactionDAO;
	
	@Override
	public void create(Transaction Transaction) throws Exception{
		try{
			if(StringUtils.isNotBlank(Transaction.getTransactionId())){
				TransactionDAO.update(Transaction);
			}else{
				TransactionDAO.create(Transaction);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Transaction> retrieveList() throws Exception{
		List<Transaction> TransactionList = null;
		try{
			TransactionList = TransactionDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return TransactionList;
	}

}
