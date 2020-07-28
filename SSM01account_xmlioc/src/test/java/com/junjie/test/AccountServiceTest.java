package com.junjie.test;

import com.junjie.domain.Account;
import com.junjie.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 */
public class AccountServiceTest {

    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    IAccountService as = ac.getBean("accountService", IAccountService.class);

    @Test
    public void testFindAll(){
        List<Account> accounts = as.findAllAccount();

        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        System.out.println(as.findAccountById(2));
    }

    @Test
    public void testSave(){
        Account account = new Account(null, "aaaa", 1234.5f);
        as.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        Account account = new Account(2, "bbbb", 1234.5f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        as.deleteAccount(4);
    }
}
