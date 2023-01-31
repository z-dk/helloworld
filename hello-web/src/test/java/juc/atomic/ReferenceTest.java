package juc.atomic;

import com.zdk.hello.service.user.entity.User;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ReferenceTest {

    public static void main(String[] args) {
        AtomicReference<User> userRef = new AtomicReference<>(new User());
        userRef.getAndUpdate(user -> {
            user.setId("1L");
            user.setName("");
            return user;
        });

        AtomicStampedReference<User> userStamp = new AtomicStampedReference<>(new User(), 0);
        userStamp.compareAndSet(new User(), new User(), 0, 1);

    }

}
