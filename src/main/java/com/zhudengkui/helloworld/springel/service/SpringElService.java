package com.zhudengkui.helloworld.springel.service;

import com.zhudengkui.helloworld.springel.domain.Order;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * <b>类 名 称</b> :  SpringELService<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/14 10:29<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/14 10:29<br/>
 * <b>修改备注</b> :
 * @author z_dk
 */
public class SpringElService {
    
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<Order>(){
            private static final long serialVersionUID = 3427620709309409347L;
    
            {
            //年龄19，不是新客，周一下单，金额11
            add(new Order("张三",19,false, LocalDate.of(2020,11,9),new BigDecimal(11)));
            //年龄17，是新客，周五下单，金额19
            add(new Order("李四",17,true,LocalDate.of(2020,11,13),new BigDecimal(19)));
            //年龄17，不是新客，周六下单，金额9
            add(new Order("王五",17,true,LocalDate.of(2020,11,14),new BigDecimal(9)));
        }};
        
        // 缓存
        Map<String, Expression> expressionCache = new HashMap<>(16);
        
        // 周一、周五的新客
        Predicate<Order> newOrder = order -> order.getNewFlag() && (order.getOrderDate().getDayOfWeek().getValue() == 1 
                || order.getOrderDate().getDayOfWeek().getValue() == 5);// 原始写法
        List<String> filterRule1 = Arrays.asList("orderDate.getDayOfWeek().getValue() == 1 || orderDate.getDayOfWeek().getValue() == 5","newFlag");
        String settleRule1 = "price * 0.2";
        settle(orders,filterRule1,settleRule1,expressionCache);
    
        System.out.println("*********************************************");
        // 年龄大于18，金额大于10
        // 原始写法，代码写死规则，对于计算规则灵活多变的场景代码修改频繁
        Predicate<Order> oldOrder = order -> order.getAge() > 18 && order.getPrice().compareTo(BigDecimal.valueOf(10)) > 0;
        // 使用springEL实现的规则引擎
        List<String> filterRule2 = Arrays.asList("age > 18","price > 10");
        String settleRule2 = "(price -10) * 0.8";
        settle(orders,filterRule2,settleRule2,expressionCache);
        
    }
    
    private static void settle(List<Order> orders, List<String> filterRule, String settleRule, Map<String,Expression> expressionCache){
        ExpressionParser expressionParser = new SpelExpressionParser();
        Stream<Order> stream = orders.stream();
        // 缓存过滤条件的el表达式
        for (String rule : filterRule){
            Expression expression = expressionParser.parseExpression(rule);
            expressionCache.put(rule,expression);
            stream = stream.filter(o -> expression.getValue(o,Boolean.class));
        }
        // 缓存计算结果的el表达式
        Expression expression = expressionParser.parseExpression(settleRule);
        expressionCache.put(settleRule, expression);
        stream.forEach(o -> System.out.println(o.getUserId() + expression.getValue(o)));
    }
    
    public static <T> Stream<T> filter(Stream<T> stream, Expression expression){
        return stream.filter(s -> expression.getValue(s,Boolean.class));
    }
    
}
