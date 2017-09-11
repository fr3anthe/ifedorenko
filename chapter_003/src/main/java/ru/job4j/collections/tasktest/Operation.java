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
        for (Map.Entry<User, List<Account>> map : this.info.entrySet()) {
            if (map.getKey().equals(user)) {
                map.getValue().add(account);
                break;
            }
        }
    }

    /**
     * Delete account for user.
     * @param user user
     * @param account account for deleting
     */
    public void deleteAccountFromUser(User user, Account account) {
        for (Map.Entry<User, List<Account>> map : this.info.entrySet()) {
            if (map.getKey().equals(user)) {
                map.getValue().remove(account);
                break;
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
        for (User us : this.info.keySet()) {
            if (user.hashCode() == us.hashCode()) {
               result = this.info.get(us);
            }
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
        List<Account> list = new ArrayList<>();
        for (User us : this.info.keySet()) {
            if (us.equals(user)) {
                list = this.info.get(us);
                break;
            }
        }
        for (Account acc : list) {
            if (acc.equals(account)) {
                result = true;
                break;
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
