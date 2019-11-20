/** TransactionDAOImpl.java  Nov 10,19
*/

package com.hospitality.daoimpl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Transaction;
import com.hospitality.dao.TransactionDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class TransactionDAOImpl extends GenericDAOImpl<Transaction> implements TransactionDAO{

}
