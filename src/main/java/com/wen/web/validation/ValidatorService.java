package com.wen.web.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author wsy48420
 * @version $Id: ValidatorService.java, v 0.1 2017年8月23日 上午11:09:46 wsy48420 Exp $
 */
@Service
public class ValidatorService {
    private Validator validator;

    @PostConstruct
    private void init(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        test();
    }

    public Map<String, String> validate(Object obj) {
        Set<ConstraintViolation<Object>> set = validator.validate(obj);
        if (set != null) {
            final Map<String, String> map = new HashMap<>((int) (set.size() * 1.5));
            set.forEach((a)-> {
                map.put(a.getPropertyPath().toString(), a.getMessage());
            });
            return map;
        }
        return null;
    }
    public void test() {
        SearchParam sp = new SearchParam();
//        User user = new User();
        
//        sp.setUser(user);
        Map<String, String> map = validate(sp);
        if(sp.getUser()!=null){
        Map<String, String> m2 = validate(sp.getUser());
        map.putAll(m2);
        }
        System.out.println(map);
    }
    
}
