package com.xh.springBoot.web;

import com.xh.springBoot.MyApplication;
import com.xh.springBoot.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MyApplication.class})
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456","2018"));
//        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456","2018"));
//        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456","2018"));

//        Assert.assertEquals(9, userRepository.findAll().size());
//        userRepository.findByUserName("bb").getNickName();
//        userRepository.delete(userRepository.findByUserName("aa"));
    }

}
