package io.tomoto.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Tomoto
 * <p>
 * 2020/11/24 9:31
 */
public class Person {
    private String name;
    private String[] phones;
    private List<String> cities;
    private Map<String, Object> map;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String[] getPhones() {
        return phones;
    }

    public Person setPhones(String[] phones) {
        this.phones = phones;
        return this;
    }

    public List<String> getCities() {
        return cities;
    }

    public Person setCities(List<String> cities) {
        this.cities = cities;
        return this;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public Person setMap(Map<String, Object> map) {
        this.map = map;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", cities=" + cities +
                ", map=" + map +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Arrays.equals(phones, person.phones) &&
                Objects.equals(cities, person.cities) &&
                Objects.equals(map, person.map);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, cities, map);
        result = 31 * result + Arrays.hashCode(phones);
        return result;
    }
}
