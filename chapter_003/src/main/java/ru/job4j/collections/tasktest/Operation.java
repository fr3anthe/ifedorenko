package ru.job4j.collections.tasktest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Operation.
 */
public class Operation {
    /**
     * @param info map with our Users and them accounts.
     */
    private Map<User, List<Account>> info = new HashMap<>();

    /**
     * Add new user.
     * @param user user for adding
     */
    public void addUser(User user) {
        this.info.put(user, new ArrayList<Account>());
    }

    /**
     * Delete user.
     * @param user user for deleting
     */
    public void deleteUser(User user) {
        this.info.remove(user);
    }

    /**
     * Add account for user.
     * @param user user
     * @param account account for adding
     */
    public void addAccountToUser(User user, Account account) {
        List<Account> result = this.info.get(user);
        if (result.equals(null)) {
            System.out.println("User " + user.getName() + " not found");
        } else {
            result.add(account);
        }
    }

    /**
     * Delete account for user.
     * @param user user
     * @param account account for deleting
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> result = this.info.get(user);
        if (result.equals(null)) {
            System.out.println("User " + user.getName() + " not found");
        } else {
            if (result.contains(account)) {
                result.remove(account);
            } else {
                System.out.println("Account " + account.getRequisites() + " not found");
            }
        }
    }

    /**
     * Get all user accounts.
     * @param user user
     * @return list of accounts
     */
    public List<Account> getUserAccounts(User user) {
        List<Account> result = new ArrayList<>();
        if (this.info.get(user).equals(null)) {
            System.out.println("User " + user.getName() + " not found");
        } else {
            result = this.info.get(user);
        }
        return result;
    }

    /**
     * Check account.
     * @param user user
     * @param account account
     * @return result
     */
    public boolean checkAccount(User user, Account account) {
        boolean result = false;
        List<Account> list = this.info.get(user);
        if (list.equals(null)) {
            System.out.println("User " + user.getName() + " not found");
        } else {
            if (list.contains(account)) {
                return true;
            } else {
                System.out.println("Account " + account.getRequisites() + " not found");
            }
        }
        return result;
    }

    /**
     * Transfer money.
     * @param srcUser who gives
     * @param srcAccount where transfer
     * @param dstUser who take
     * @param dstAccount where to transfer
     * @param amount how much money
     * @return result
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        if (checkAccount(srcUser, srcAccount) && checkAccount(dstUser, dstAccount)) {
            if (srcAccount.getValue() > amount) {
                srcAccount.setValue(srcAccount.getValue() - amount);
                dstAccount.setValue(dstAccount.getValue() + amount);
                result = true;
            } else {
                System.out.println("Не счете " + srcAccount + "недостаточно средств");
            }
        }
        return result;
    }

    /**
     * Getter info.
     * @return our Map
     */
    public Map<User, List<Account>> getInfo() {
        return info;
    }
}
