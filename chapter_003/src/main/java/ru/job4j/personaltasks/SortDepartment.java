package ru.job4j.personaltasks;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class sort department.
 */
public class SortDepartment {

    /**
     * Sort by Ascending.
     * @param department Array for sort
     * @return sorted array
     */
    public String[] sortAscending(String[] department) {
        String[] result = this.add(department);
        return result;
    }

    /**
     * Sort by descending.
     * @param department Array for sort
     * @return sorted array
     */
    public String[] sortDescending(String[] department) {
        List<String> list = Arrays.asList(this.add(department));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                String[] s1 = o1.split("/");
                String[] s2 = o2.split("/");
                if (s2.length == s1.length) {
                    for (int i = 0; i < s1.length; i++) {
                        if (!s1[i].equals(s2[i])) {
                            result = o2.compareTo(o1);
                        }
                    }
                } else {
                    int lenght = s1.length > s2.length ? s2.length : s1.length;
                    for (int i = 0; i < lenght; i++) {
                        if (!s1[i].equals(s2[i])) {
                            result = o2.compareTo(o1);
                        }
                    }
                }
                return result;
            }
        });
        String[] result = new String[list.size()];
        result = list.toArray(result);
        return result;
    }

    /**
     * Adding missing elements.
     * @param departments array for add
     * @return full array
     */
    private String[] add(String[] departments) {
        Set<String> temp = new TreeSet<>();
        String value;
        for (int i = 0; i < departments.length; i++) {

            if (departments[i].contains("/")) {
                value = departments[i].substring(0, departments[i].lastIndexOf("/"));
                temp.add(value);
            }
            temp.add(departments[i]);
        }
        String[] result = new String[temp.size()];
        result = temp.toArray(result);
        return result;
    }
}
