package ru.job4j.personaltasks;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class sort department.
 */
public class SortDepartment {

    /**
     * Sort by Ascending.
     *
     * @param department Array for sort
     * @return sorted array
     */
    public String[] sortAscending(String[] department) {
        String[] result = this.add(department);
        return result;
    }

    /**
     * Sort by descending.
     *
     * @param department Array for sort
     * @return sorted array
     */
    public String[] sortDescending(String[] department) {
        String[] temp = this.add(department);
        Map<String, String[]> map = new TreeMap<>();
        for (int i = 0; i < temp.length; i++) {
            map.put(temp[i], temp[i].split("/"));
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                if (map.get(o1).length == map.get(o2).length) {
                    for (int i = 0; i < map.get(o1).length; i++) {
                        if (!map.get(o1)[i].equals(map.get(o2)[i])) {
                            result = o2.compareTo(o1);
                        }
                    }
                } else {
                    int length = map.get(o1).length > map.get(o2).length ? map.get(o2).length : map.get(o1).length;
                    for (int i = 0; i < length; i++) {
                        if (!map.get(o1)[i].equals(map.get(o2)[i])) {
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
