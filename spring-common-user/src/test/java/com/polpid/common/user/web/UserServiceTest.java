package com.polpid.common.user.web;

import com.polpid.common.user.UserStatus;
import com.polpid.common.user.domain.Users;
import com.polpid.common.user.repository.UserRepository;
import com.polpid.common.user.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {


    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Rule
    public ExpectedException rule = ExpectedException.none();

    private Users user1;

    @Before
    public void setup(){

        userService = new UserService(userRepository);

        user1 = Users.builder()
                .email("test01@test.com")
                .name("test01")
                .status(UserStatus.APPLIED)
                .build();
    }

    @Test
    public void findUserById(){
        when(userRepository.findById("test01@test.com")).thenReturn(Optional.of(user1));

        Users user = userService.findUserById("test01@test.com");

        Assert.assertNotNull(user);
        Assert.assertEquals("test01@test.com", user.getEmail());

        verify(userRepository).findById("test01@test.com");
    }

    @Test(expected = RuntimeException.class)
    public void findUserByIdException(){
        when(userRepository.findById("test011@test.com")).thenThrow(new RuntimeException("User not found"));

        userService.findUserById("test011@test.com");

        verify(userService).findUserById("test011@test.com");
    }

    @Test
    public void findUserByIdExceptionMessage(){
        rule.expect(RuntimeException.class);
        rule.expectMessage("User not found");

        userService.findUserById("test011@test.com");

        verify(userService).findUserById("test011@test.com");
    }


    @Test
    public void privateMethodTestReflectionUtilsFalse(){
        boolean validateId = ReflectionTestUtils.invokeMethod(userService, "validateId", new Object[]{ null });
        Assert.assertFalse(validateId);
    }

    @Test
    public void privateMethodTestReflectionUtilsTrue(){
        boolean validateId = ReflectionTestUtils.invokeMethod(userService, "validateId", "TEST");
        Assert.assertTrue(validateId);
    }

    @Test
    public void privateMethodTestMethodInvoke(){
        try {
            Method validateIdMethod = UserService.class.getDeclaredMethod("validateId", String.class);
            validateIdMethod.setAccessible(true);

            boolean test = (boolean)validateIdMethod.invoke(userService, "TEST");

            Assert.assertTrue(test);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
