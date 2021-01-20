package com.wm.interviewing;

import java.util.*;

public class AlephTest {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        //返回结果集
        List<List<String>> result = new ArrayList<>();
        //账户信息记录 账户名：账户信息列表
        Map<String, List<Set<String>>> accountRecord = new HashMap<>();
        //遍历所有账户
        for (List<String> account : accounts) {
            //格式化当前账户
            account = new ArrayList<>(account);
            //当前账户名
            String accountName = account.get(0);
            //移除当前账号名，剩余列表信息为email列表
            account.remove(0);
            //如果账户信息列表中已经存在当前账户名时，则不更新
            accountRecord.putIfAbsent(accountName, new ArrayList<>());
            //创建需要移除email地址的列表
            List<Set<String>> repeatEmail = new ArrayList<>();
            //重复邮箱地址集合
            Set<String> tempEmail = new HashSet<>();
            //遍历账户集合中当前账户信息列表
            for (Set<String> emails : accountRecord.get(accountName)) {
                //遍历当前账户邮箱列表信息
                for (String email : account) {
                    //判断邮箱地址是否已存在
                    if (emails.contains(email)) {
                        tempEmail.addAll(emails);
                        //如果账户集合中当前账户列表中包含当前邮箱，则记录为该邮箱需删除
                        repeatEmail.add(emails);
                        break;
                    }
                }
            }
            tempEmail.addAll(account);
            //移除集合中重复的邮箱地址
            for (Set<String> emails : repeatEmail) {
                accountRecord.get(accountName).remove(emails);
            }
            //为当前账户创建邮箱列表
            accountRecord.get(accountName).add(tempEmail);
        }

        //形成最终账户结果集合
        for (String accountName : accountRecord.keySet()) {
            for (Set<String> emails : accountRecord.get(accountName)) {
                List<String> temp = new ArrayList<>();
                temp.addAll(emails);
                Collections.sort(temp);
                temp.add(0, accountName);
                result.add(temp);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<List<String>>();
        List<String> account1 = new ArrayList<String>();
        List<String> account2 = new ArrayList<String>();
        List<String> account3 = new ArrayList<String>();
        List<String> account4 = new ArrayList<String>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add( "john00@mail.com");
        accounts.add(account1);

        account2.add("John");
        account2.add("johnnybravo@mail.com");
        accounts.add(account2);

        account3.add("John");
        account3.add( "johnsmith@mail.com");
        account3.add("john_newyork@mail.com");
        accounts.add(account3);

        account4.add("Mary");
        account4.add("mary@mail.com");
        accounts.add(account4);
        System.out.println(new AlephTest().accountsMerge(accounts));
    }
}
