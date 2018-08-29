package com.cg.customerproject.accountRepo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.customerproject.account.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, ObjectId>{

	

	Account findOneByAccountId(int accountId);

	

}
