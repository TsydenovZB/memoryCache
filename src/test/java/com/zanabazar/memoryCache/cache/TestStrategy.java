package com.zanabazar.memoryCache.cache;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestStrategy {

    public Person person1 = new Person("Anallise", "Kinsell", "akinsell0@time.com", Person.Gender.FEMALE);
    public Person person2 = new Person("Bayard", "Craydon", "bcraydon1@tinypic.com", Person.Gender.MALE);
    public Person person3 = new Person("Falito", "Darcy", "fdarcy2@lycos.com", Person.Gender.MALE);
    public Person person4 = new Person("Odey", "Tschirschky", "otschirschky3@123-reg.co.uk", Person.Gender.MALE);
    public Person person5 = new Person("Tawsha", "Colbourne", "tcolbourne4@sfgate.com", Person.Gender.FEMALE);
    public Person person6 = new Person("Eldredge", "Keir", "ekeir5@nps.gov", Person.Gender.MALE);
    public Person person7 = new Person("Xenos", "Bontoft", "xbontoft6@ox.ac.uk", Person.Gender.MALE);
    public Person person8 = new Person("Micky", "Currington", "mcurrington7@oracle.com", Person.Gender.MALE);
    public Person person9 = new Person("Dun", "Becke", "dbecke8@ezinearticles.com", Person.Gender.MALE);
    public Person person10 = new Person("Dan", "St Leger", "dstleger9@over-blog.com", Person.Gender.MALE);


    public static void assertModel(Cache<Object> cache, Object... keysAndValues) {
        List<Object> actualKeysAndValues = new ArrayList<>();
        for (Map.Entry<Integer, Object> entry : cache.model().entrySet()) {
            actualKeysAndValues.add(entry.getValue());
        }
        Assert.assertEquals(actualKeysAndValues, Arrays.asList(keysAndValues));
    }
}
